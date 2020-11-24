package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留言对象 u_message
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public class UMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 留言id */
    private Long messageId;

    /** 对象id */
    @Excel(name = "对象id")
    private Long objectId;

    /** 对象类型 */
    @Excel(name = "对象类型")
    private Long objectType;

    /** 留言内容 */
    @Excel(name = "留言内容")
    private String content;

    /** 留言人id */
    @Excel(name = "留言人id")
    private Long createUserId;

    /** 留言人姓名 */
    @Excel(name = "留言人姓名")
    private String createUserName;

    /** 备用字段1 */
    @Excel(name = "备用字段1")
    private String ext1;

    /** 备用字段2 */
    @Excel(name = "备用字段2")
    private String ext2;

    /** 备用字段3 */
    @Excel(name = "备用字段3")
    private String ext3;

    /** 备用字段4 */
    @Excel(name = "备用字段4")
    private String ext4;

    /** 备用字段5 */
    @Excel(name = "备用字段5")
    private Long ext5;

    public void setMessageId(Long messageId) 
    {
        this.messageId = messageId;
    }

    public Long getMessageId() 
    {
        return messageId;
    }
    public void setObjectId(Long objectId) 
    {
        this.objectId = objectId;
    }

    public Long getObjectId() 
    {
        return objectId;
    }
    public void setObjectType(Long objectType) 
    {
        this.objectType = objectType;
    }

    public Long getObjectType() 
    {
        return objectType;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setCreateUserName(String createUserName) 
    {
        this.createUserName = createUserName;
    }

    public String getCreateUserName() 
    {
        return createUserName;
    }
    public void setExt1(String ext1) 
    {
        this.ext1 = ext1;
    }

    public String getExt1() 
    {
        return ext1;
    }
    public void setExt2(String ext2) 
    {
        this.ext2 = ext2;
    }

    public String getExt2() 
    {
        return ext2;
    }
    public void setExt3(String ext3) 
    {
        this.ext3 = ext3;
    }

    public String getExt3() 
    {
        return ext3;
    }
    public void setExt4(String ext4) 
    {
        this.ext4 = ext4;
    }

    public String getExt4() 
    {
        return ext4;
    }
    public void setExt5(Long ext5) 
    {
        this.ext5 = ext5;
    }

    public Long getExt5() 
    {
        return ext5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageId", getMessageId())
            .append("objectId", getObjectId())
            .append("objectType", getObjectType())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .append("ext1", getExt1())
            .append("ext2", getExt2())
            .append("ext3", getExt3())
            .append("ext4", getExt4())
            .append("ext5", getExt5())
            .toString();
    }
}
