package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.UResource;
import com.ruoyi.system.service.IUResourceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.framework.util.*;

/**
 * 资料Controller
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Controller
@RequestMapping("/system/resource")
public class UResourceController extends BaseController
{
    private String prefix = "system/resource";

    @Autowired
    private IUResourceService uResourceService;

    @RequiresPermissions("system:resource:view")
    @GetMapping()
    public String resource()
    {
        return prefix + "/resource";
    }

    /**
     * 查询资料列表
     */
    @RequiresPermissions("system:resource:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UResource uResource)
    {
        startPage();
        List<UResource> list = uResourceService.selectUResourceList(uResource);
        return getDataTable(list);
    }

    /**
     * 导出资料列表
     */
    @RequiresPermissions("system:resource:export")
    @Log(title = "资料", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UResource uResource)
    {
        List<UResource> list = uResourceService.selectUResourceList(uResource);
        ExcelUtil<UResource> util = new ExcelUtil<UResource>(UResource.class);
        return util.exportExcel(list, "resource");
    }

    /**
     * 新增资料
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存资料
     */
    @RequiresPermissions("system:resource:add")
    @Log(title = "资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UResource uResource)
    {
        SysUser cuser=ShiroUtils.getSysUser();
        uResource.setCreateUserId(cuser.getUserId());
        uResource.setCreateUserName(cuser.getUserName());
        uResource.setCreateTime(new Date());

        return toAjax(uResourceService.insertUResource(uResource));
    }

    /**
     * 修改资料
     */
    @GetMapping("/edit/{resourceId}")
    public String edit(@PathVariable("resourceId") Long resourceId, ModelMap mmap)
    {
        UResource uResource = uResourceService.selectUResourceById(resourceId);
        mmap.put("uResource", uResource);
        return prefix + "/edit";
    }

    /**
     * 修改保存资料
     */
    @RequiresPermissions("system:resource:edit")
    @Log(title = "资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UResource uResource)
    {
        return toAjax(uResourceService.updateUResource(uResource));
    }

    /**
     * 删除资料
     */
    @RequiresPermissions("system:resource:remove")
    @Log(title = "资料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uResourceService.deleteUResourceByIds(ids));
    }
}
