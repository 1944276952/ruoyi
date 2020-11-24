package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.util.ShiroUtils;
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
import com.ruoyi.system.domain.UCollection;
import com.ruoyi.system.service.IUCollectionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏Controller
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Controller
@RequestMapping("/system/collection")
public class UCollectionController extends BaseController
{
    private String prefix = "system/collection";

    @Autowired
    private IUCollectionService uCollectionService;

    @RequiresPermissions("system:collection:view")
    @GetMapping()
    public String collection()
    {
        return prefix + "/collection";
    }

    /**
     * 查询收藏列表
     */
    @RequiresPermissions("system:collection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UCollection uCollection)
    {
        startPage();
        List<UCollection> list = uCollectionService.selectUCollectionList(uCollection);
        return getDataTable(list);
    }

    /**
     * 导出收藏列表
     */
    @RequiresPermissions("system:collection:export")
    @Log(title = "收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UCollection uCollection)
    {
        List<UCollection> list = uCollectionService.selectUCollectionList(uCollection);
        ExcelUtil<UCollection> util = new ExcelUtil<UCollection>(UCollection.class);
        return util.exportExcel(list, "collection");
    }

    /**
     * 新增收藏
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存收藏
     */
    @RequiresPermissions("system:collection:add")
    @Log(title = "收藏", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UCollection uCollection)
    {

        uCollection.setCreateUserId(ShiroUtils.getUserId());
        return toAjax(uCollectionService.insertUCollection(uCollection));
    }

    /**
     * 修改收藏
     */
    @GetMapping("/edit/{collectionId}")
    public String edit(@PathVariable("collectionId") Long collectionId, ModelMap mmap)
    {
        UCollection uCollection = uCollectionService.selectUCollectionById(collectionId);
        mmap.put("uCollection", uCollection);
        return prefix + "/edit";
    }

    /**
     * 修改保存收藏
     */
    @RequiresPermissions("system:collection:edit")
    @Log(title = "收藏", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UCollection uCollection)
    {
        return toAjax(uCollectionService.updateUCollection(uCollection));
    }

    /**
     * 删除收藏
     */
    @RequiresPermissions("system:collection:remove")
    @Log(title = "收藏", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(uCollectionService.deleteUCollectionByIds(ids));
    }
}
