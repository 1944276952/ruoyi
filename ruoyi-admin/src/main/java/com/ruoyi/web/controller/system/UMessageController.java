package com.ruoyi.web.controller.system;

import java.util.Date;
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
import com.ruoyi.system.domain.UMessage;
import com.ruoyi.system.service.IUMessageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 留言Controller
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Controller
@RequestMapping("/system/message")
public class UMessageController extends BaseController
{
    private String prefix = "system/message";

    @Autowired
    private IUMessageService uMessageService;

    @RequiresPermissions("system:message:view")
    @GetMapping()
    public String message()
    {
        return prefix + "/message";
    }

    /**
     * 查询留言列表
     */
    @RequiresPermissions("system:message:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UMessage uMessage)
    {
        startPage();
        List<UMessage> list = uMessageService.selectUMessageList(uMessage);
        return getDataTable(list);
    }

    /**
     * 导出留言列表
     */
    @RequiresPermissions("system:message:export")
    @Log(title = "留言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UMessage uMessage)
    {
        List<UMessage> list = uMessageService.selectUMessageList(uMessage);
        ExcelUtil<UMessage> util = new ExcelUtil<UMessage>(UMessage.class);
        return util.exportExcel(list, "message");
    }

    /**
     * 新增留言
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存留言
     */
    @RequiresPermissions("system:message:add")
    @Log(title = "留言", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UMessage uMessage)
    {
        SysUser cuser= ShiroUtils.getSysUser();
        uMessage.setCreateUserId(cuser.getUserId());
        uMessage.setCreateUserName(cuser.getUserName());
        uMessage.setCreateTime(new Date());
        return toAjax(uMessageService.insertUMessage(uMessage));
    }

    /**
     * 修改留言
     */
    @GetMapping("/edit/{messageId}")
    public String edit(@PathVariable("messageId") Long messageId, ModelMap mmap)
    {
        UMessage uMessage = uMessageService.selectUMessageById(messageId);
        mmap.put("uMessage", uMessage);
        return prefix + "/edit";
    }

    /**
     * 修改保存留言
     */
    @RequiresPermissions("system:message:edit")
    @Log(title = "留言", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UMessage uMessage)
    {
        return toAjax(uMessageService.updateUMessage(uMessage));
    }

    /**
     * 删除留言
     */
    @RequiresPermissions("system:message:remove")
    @Log(title = "留言", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uMessageService.deleteUMessageByIds(ids));
    }
}
