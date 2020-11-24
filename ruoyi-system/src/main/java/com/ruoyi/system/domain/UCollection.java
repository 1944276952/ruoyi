package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏对象 u_collection
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public class UCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏id */
    private Long collectionId;

    /** 资料id */
    @Excel(name = "资料id")
    private Long resourceId;

    /** 创建人id */
    @Excel(name = "创建人id")
    private Long createUserId;

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

    public void setCollectionId(Long collectionId) 
    {
        this.collectionId = collectionId;
    }

    public Long getCollectionId() 
    {
        return collectionId;
    }
    public void setResourceId(Long resourceId) 
    {
        this.resourceId = resourceId;
    }

    public Long getResourceId() 
    {
        return resourceId;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
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
            .append("collectionId", getCollectionId())
            .append("resourceId", getResourceId())
            .append("createTime", getCreateTime())
            .append("createUserId", getCreateUserId())
            .append("ext1", getExt1())
            .append("ext2", getExt2())
            .append("ext3", getExt3())
            .append("ext4", getExt4())
            .append("ext5", getExt5())
            .toString();
    }
}
