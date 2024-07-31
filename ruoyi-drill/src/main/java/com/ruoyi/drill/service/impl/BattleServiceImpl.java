package com.ruoyi.drill.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.drill.mapper.BattleMapper;
import com.ruoyi.drill.domain.Battle;
import com.ruoyi.drill.service.IBattleService;

/**
 * 演习管理Service业务层处理
 * 
 * @author sixiaoya
 * @date 2024-07-30
 */
@Service
public class BattleServiceImpl implements IBattleService 
{
    @Autowired
    private BattleMapper battleMapper;

    /**
     * 查询演习管理
     * 
     * @param id 演习管理主键
     * @return 演习管理
     */
    @Override
    public Battle selectBattleById(Long id)
    {
        return battleMapper.selectBattleById(id);
    }

    /**
     * 查询演习管理列表
     * 
     * @param battle 演习管理
     * @return 演习管理
     */
    @Override
    public List<Battle> selectBattleList(Battle battle)
    {
        return battleMapper.selectBattleList(battle);
    }

    /**
     * 新增演习管理
     * 
     * @param battle 演习管理
     * @return 结果
     */
    @Override
    public int insertBattle(Battle battle)
    {
        battle.setCreateTime(DateUtils.getNowDate());
        return battleMapper.insertBattle(battle);
    }

    /**
     * 修改演习管理
     * 
     * @param battle 演习管理
     * @return 结果
     */
    @Override
    public int updateBattle(Battle battle)
    {
        battle.setUpdateTime(DateUtils.getNowDate());
        return battleMapper.updateBattle(battle);
    }

    /**
     * 批量删除演习管理
     * 
     * @param ids 需要删除的演习管理主键
     * @return 结果
     */
    @Override
    public int deleteBattleByIds(Long[] ids)
    {
        return battleMapper.deleteBattleByIds(ids);
    }

    /**
     * 删除演习管理信息
     * 
     * @param id 演习管理主键
     * @return 结果
     */
    @Override
    public int deleteBattleById(Long id)
    {
        return battleMapper.deleteBattleById(id);
    }
}
