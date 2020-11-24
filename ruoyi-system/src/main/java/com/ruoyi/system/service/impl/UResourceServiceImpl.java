package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UResourceMapper;
import com.ruoyi.system.domain.UResource;
import com.ruoyi.system.service.IUResourceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 资料Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Service
public class UResourceServiceImpl implements IUResourceService 
{
    @Autowired
    private UResourceMapper uResourceMapper;

    /**
     * 查询资料
     * 
     * @param resourceId 资料ID
     * @return 资料
     */
    @Override
    public UResource selectUResourceById(Long resourceId)
    {
        return uResourceMapper.selectUResourceById(resourceId);
    }

    /**
     * 查询资料列表
     * 
     * @param uResource 资料
     * @return 资料
     */
    @Override
    public List<UResource> selectUResourceList(UResource uResource)
    {
        return uResourceMapper.selectUResourceList(uResource);
    }

    /**
     * 新增资料
     * 
     * @param uResource 资料
     * @return 结果
     */
    @Override
    public int insertUResource(UResource uResource)
    {
        uResource.setCreateTime(DateUtils.getNowDate());
        return uResourceMapper.insertUResource(uResource);
    }

    /**
     * 修改资料
     * 
     * @param uResource 资料
     * @return 结果
     */
    @Override
    public int updateUResource(UResource uResource)
    {
        return uResourceMapper.updateUResource(uResource);
    }

    /**
     * 删除资料对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUResourceByIds(String ids)
    {
        return uResourceMapper.deleteUResourceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资料信息
     * 
     * @param resourceId 资料ID
     * @return 结果
     */
    @Override
    public int deleteUResourceById(Long resourceId)
    {
        return uResourceMapper.deleteUResourceById(resourceId);
    }
}
