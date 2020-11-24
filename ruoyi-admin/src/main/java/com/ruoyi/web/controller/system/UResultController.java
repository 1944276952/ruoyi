package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UResult;
import com.ruoyi.system.service.IUResultService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生学习Controller
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Controller
@RequestMapping("/system/result")
public class UResultController extends BaseController
{
    private String prefix = "system/result";

    @Autowired
    private IUResultService uResultService;

    @RequiresPermissions("system:result:view")
    @GetMapping()
    public String result()
    {
        return prefix + "/result";
    }

    /**
     * 查询学生学习列表
     */
    @RequiresPermissions("system:result:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UResult uResult)
    {
        startPage();
        List<UResult> list = uResultService.selectUResultList(uResult);
        return getDataTable(list);
    }

    /**
     * 导出学生学习列表
     */
    @RequiresPermissions("system:result:export")
    @Log(title = "学生学习", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UResult uResult)
    {
        List<UResult> list = uResultService.selectUResultList(uResult);
        ExcelUtil<UResult> util = new ExcelUtil<UResult>(UResult.class);
        return util.exportExcel(list, "result");
    }

    /**
     * 新增学生学习
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学生学习
     */
    @RequiresPermissions("system:result:add")
    @Log(title = "学生学习", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UResult uResult)
    {
        return toAjax(uResultService.insertUResult(uResult));
    }

    /**
     * 修改学生学习
     */
    @GetMapping("/edit/{resultId}")
    public String edit(@PathVariable("resultId") Long resultId, ModelMap mmap)
    {
        UResult uResult = uResultService.selectUResultById(resultId);
        mmap.put("uResult", uResult);
        return prefix + "/edit";
    }

    /**
     * 修改保存学生学习
     */
    @RequiresPermissions("system:result:edit")
    @Log(title = "学生学习", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UResult uResult)
    {
        return toAjax(uResultService.updateUResult(uResult));
    }

    /**
     * 删除学生学习
     */
    @RequiresPermissions("system:result:remove")
    @Log(title = "学生学习", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uResultService.deleteUResultByIds(ids));
    }
}
