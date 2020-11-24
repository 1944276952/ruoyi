package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生学习对象 u_result
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public class UResult extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学习结果id */
    private Long resultId;

    /** 学习资料id */
    @Excel(name = "学习资料id")
    private Long resourceId;

    /** 学习资料类型 */
    @Excel(name = "学习资料类型")
    private Long resourceType;

    /** 是否已经通过 */
    @Excel(name = "是否已经通过")
    private Long isPass;

    /** 学生id */
    @Excel(name = "学生id")
    private Long userId;

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

    public void setResultId(Long resultId) 
    {
        this.resultId = resultId;
    }

    public Long getResultId() 
    {
        return resultId;
    }
    public void setResourceId(Long resourceId) 
    {
        this.resourceId = resourceId;
    }

    public Long getResourceId() 
    {
        return resourceId;
    }
    public void setResourceType(Long resourceType) 
    {
        this.resourceType = resourceType;
    }

    public Long getResourceType() 
    {
        return resourceType;
    }
    public void setIsPass(Long isPass) 
    {
        this.isPass = isPass;
    }

    public Long getIsPass() 
    {
        return isPass;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
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
            .append("resultId", getResultId())
            .append("resourceId", getResourceId())
            .append("resourceType", getResourceType())
            .append("isPass", getIsPass())
            .append("userId", getUserId())
            .append("ext1", getExt1())
            .append("ext2", getExt2())
            .append("ext3", getExt3())
            .append("ext4", getExt4())
            .append("ext5", getExt5())
            .toString();
    }
}
