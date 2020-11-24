package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UResult;

/**
 * 学生学习Service接口
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
public interface IUResultService 
{
    /**
     * 查询学生学习
     * 
     * @param resultId 学生学习ID
     * @return 学生学习
     */
    public UResult selectUResultById(Long resultId);

    /**
     * 查询学生学习列表
     * 
     * @param uResult 学生学习
     * @return 学生学习集合
     */
    public List<UResult> selectUResultList(UResult uResult);

    /**
     * 新增学生学习
     * 
     * @param uResult 学生学习
     * @return 结果
     */
    public int insertUResult(UResult uResult);

    /**
     * 修改学生学习
     * 
     * @param uResult 学生学习
     * @return 结果
     */
    public int updateUResult(UResult uResult);

    /**
     * 批量删除学生学习
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUResultByIds(String ids);

    /**
     * 删除学生学习信息
     * 
     * @param resultId 学生学习ID
     * @return 结果
     */
    public int deleteUResultById(Long resultId);
}
