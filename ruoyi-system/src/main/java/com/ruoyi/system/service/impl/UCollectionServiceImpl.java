package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UCollectionMapper;
import com.ruoyi.system.domain.UCollection;
import com.ruoyi.system.service.IUCollectionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Service
public class UCollectionServiceImpl implements IUCollectionService 
{
    @Autowired
    private UCollectionMapper uCollectionMapper;

    /**
     * 查询收藏
     * 
     * @param collectionId 收藏ID
     * @return 收藏
     */
    @Override
    public UCollection selectUCollectionById(Long collectionId)
    {
        return uCollectionMapper.selectUCollectionById(collectionId);
    }

    /**
     * 查询收藏列表
     * 
     * @param uCollection 收藏
     * @return 收藏
     */
    @Override
    public List<UCollection> selectUCollectionList(UCollection uCollection)
    {
        return uCollectionMapper.selectUCollectionList(uCollection);
    }

    /**
     * 新增收藏
     * 
     * @param uCollection 收藏
     * @return 结果
     */
    @Override
    public int insertUCollection(UCollection uCollection)
    {
        uCollection.setCreateTime(DateUtils.getNowDate());
        return uCollectionMapper.insertUCollection(uCollection);
    }

    /**
     * 修改收藏
     * 
     * @param uCollection 收藏
     * @return 结果
     */
    @Override
    public int updateUCollection(UCollection uCollection)
    {
        return uCollectionMapper.updateUCollection(uCollection);
    }

    /**
     * 删除收藏对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUCollectionByIds(String ids)
    {
        return uCollectionMapper.deleteUCollectionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收藏信息
     * 
     * @param collectionId 收藏ID
     * @return 结果
     */
    @Override
    public int deleteUCollectionById(Long collectionId)
    {
        return uCollectionMapper.deleteUCollectionById(collectionId);
    }
}
