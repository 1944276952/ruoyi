package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UCollection;

/**
 * 收藏Service接口
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public interface IUCollectionService 
{
    /**
     * 查询收藏
     * 
     * @param collectionId 收藏ID
     * @return 收藏
     */
    public UCollection selectUCollectionById(Long collectionId);

    /**
     * 查询收藏列表
     * 
     * @param uCollection 收藏
     * @return 收藏集合
     */
    public List<UCollection> selectUCollectionList(UCollection uCollection);

    /**
     * 新增收藏
     * 
     * @param uCollection 收藏
     * @return 结果
     */
    public int insertUCollection(UCollection uCollection);

    /**
     * 修改收藏
     * 
     * @param uCollection 收藏
     * @return 结果
     */
    public int updateUCollection(UCollection uCollection);

    /**
     * 批量删除收藏
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUCollectionByIds(String ids);

    /**
     * 删除收藏信息
     * 
     * @param collectionId 收藏ID
     * @return 结果
     */
    public int deleteUCollectionById(Long collectionId);
}
