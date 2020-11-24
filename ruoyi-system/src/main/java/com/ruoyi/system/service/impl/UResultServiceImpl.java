package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UResultMapper;
import com.ruoyi.system.domain.UResult;
import com.ruoyi.system.service.IUResultService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生学习Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-24
 */
@Service
public class UResultServiceImpl implements IUResultService 
{
    @Autowired
    private UResultMapper uResultMapper;

    /**
     * 查询学生学习
     * 
     * @param resultId 学生学习ID
     * @return 学生学习
     */
    @Override
    public UResult selectUResultById(Long resultId)
    {
        return uResultMapper.selectUResultById(resultId);
    }

    /**
     * 查询学生学习列表
     * 
     * @param uResult 学生学习
     * @return 学生学习
     */
    @Override
    public List<UResult> selectUResultList(UResult uResult)
    {
        return uResultMapper.selectUResultList(uResult);
    }

    /**
     * 新增学生学习
     * 
     * @param uResult 学生学习
     * @return 结果
     */
    @Override
    public int insertUResult(UResult uResult)
    {
        return uResultMapper.insertUResult(uResult);
    }

    /**
     * 修改学生学习
     * 
     * @param uResult 学生学习
     * @return 结果
     */
    @Override
    public int updateUResult(UResult uResult)
    {
        return uResultMapper.updateUResult(uResult);
    }

    /**
     * 删除学生学习对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUResultByIds(String ids)
    {
        return uResultMapper.deleteUResultByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生学习信息
     * 
     * @param resultId 学生学习ID
     * @return 结果
     */
    @Override
    public int deleteUResultById(Long resultId)
    {
        return uResultMapper.deleteUResultById(resultId);
    }
}
