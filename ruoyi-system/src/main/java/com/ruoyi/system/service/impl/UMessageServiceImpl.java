package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UMessageMapper;
import com.ruoyi.system.domain.UMessage;
import com.ruoyi.system.service.IUMessageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 留言Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Service
public class UMessageServiceImpl implements IUMessageService 
{
    @Autowired
    private UMessageMapper uMessageMapper;

    /**
     * 查询留言
     * 
     * @param messageId 留言ID
     * @return 留言
     */
    @Override
    public UMessage selectUMessageById(Long messageId)
    {
        return uMessageMapper.selectUMessageById(messageId);
    }

    /**
     * 查询留言列表
     * 
     * @param uMessage 留言
     * @return 留言
     */
    @Override
    public List<UMessage> selectUMessageList(UMessage uMessage)
    {
        return uMessageMapper.selectUMessageList(uMessage);
    }

    /**
     * 新增留言
     * 
     * @param uMessage 留言
     * @return 结果
     */
    @Override
    public int insertUMessage(UMessage uMessage)
    {
        uMessage.setCreateTime(DateUtils.getNowDate());
        return uMessageMapper.insertUMessage(uMessage);
    }

    /**
     * 修改留言
     * 
     * @param uMessage 留言
     * @return 结果
     */
    @Override
    public int updateUMessage(UMessage uMessage)
    {
        return uMessageMapper.updateUMessage(uMessage);
    }

    /**
     * 删除留言对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUMessageByIds(String ids)
    {
        return uMessageMapper.deleteUMessageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除留言信息
     * 
     * @param messageId 留言ID
     * @return 结果
     */
    @Override
    public int deleteUMessageById(Long messageId)
    {
        return uMessageMapper.deleteUMessageById(messageId);
    }
}
