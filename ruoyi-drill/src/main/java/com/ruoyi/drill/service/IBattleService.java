package com.ruoyi.drill.service;

import java.util.List;
import com.ruoyi.drill.domain.Battle;

/**
 * 演习管理Service接口
 * 
 * @author sixiaoya
 * @date 2024-07-30
 */
public interface IBattleService 
{
    /**
     * 查询演习管理
     * 
     * @param id 演习管理主键
     * @return 演习管理
     */
    public Battle selectBattleById(Long id);

    /**
     * 查询演习管理列表
     * 
     * @param battle 演习管理
     * @return 演习管理集合
     */
    public List<Battle> selectBattleList(Battle battle);

    /**
     * 新增演习管理
     * 
     * @param battle 演习管理
     * @return 结果
     */
    public int insertBattle(Battle battle);

    /**
     * 修改演习管理
     * 
     * @param battle 演习管理
     * @return 结果
     */
    public int updateBattle(Battle battle);

    /**
     * 批量删除演习管理
     * 
     * @param ids 需要删除的演习管理主键集合
     * @return 结果
     */
    public int deleteBattleByIds(Long[] ids);

    /**
     * 删除演习管理信息
     * 
     * @param id 演习管理主键
     * @return 结果
     */
    public int deleteBattleById(Long id);
}
