package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UMessage;

/**
 * 留言Mapper接口
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public interface UMessageMapper 
{
    /**
     * 查询留言
     * 
     * @param messageId 留言ID
     * @return 留言
     */
    public UMessage selectUMessageById(Long messageId);

    /**
     * 查询留言列表
     * 
     * @param uMessage 留言
     * @return 留言集合
     */
    public List<UMessage> selectUMessageList(UMessage uMessage);

    /**
     * 新增留言
     * 
     * @param uMessage 留言
     * @return 结果
     */
    public int insertUMessage(UMessage uMessage);

    /**
     * 修改留言
     * 
     * @param uMessage 留言
     * @return 结果
     */
    public int updateUMessage(UMessage uMessage);

    /**
     * 删除留言
     * 
     * @param messageId 留言ID
     * @return 结果
     */
    public int deleteUMessageById(Long messageId);

    /**
     * 批量删除留言
     * 
     * @param messageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteUMessageByIds(String[] messageIds);
}
