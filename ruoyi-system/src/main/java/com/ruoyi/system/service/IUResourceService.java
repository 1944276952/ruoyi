package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UResource;

/**
 * 资料Service接口
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public interface IUResourceService 
{
    /**
     * 查询资料
     * 
     * @param resourceId 资料ID
     * @return 资料
     */
    public UResource selectUResourceById(Long resourceId);

    /**
     * 查询资料列表
     * 
     * @param uResource 资料
     * @return 资料集合
     */
    public List<UResource> selectUResourceList(UResource uResource);

    /**
     * 新增资料
     * 
     * @param uResource 资料
     * @return 结果
     */
    public int insertUResource(UResource uResource);

    /**
     * 修改资料
     * 
     * @param uResource 资料
     * @return 结果
     */
    public int updateUResource(UResource uResource);

    /**
     * 批量删除资料
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUResourceByIds(String ids);

    /**
     * 删除资料信息
     * 
     * @param resourceId 资料ID
     * @return 结果
     */
    public int deleteUResourceById(Long resourceId);
}
