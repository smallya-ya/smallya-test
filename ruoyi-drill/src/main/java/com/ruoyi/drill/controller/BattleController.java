package com.ruoyi.drill.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.drill.domain.Battle;
import com.ruoyi.drill.service.IBattleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 演习管理Controller
 * 
 * @author sixiaoya
 * @date 2024-07-30
 */
@RestController
@RequestMapping("/drill/battle")
public class BattleController extends BaseController
{
    @Autowired
    private IBattleService battleService;

    /**
     * 查询演习管理列表
     */
    @PreAuthorize("@ss.hasPermi('drill:battle:list')")
    @GetMapping("/list")
    public TableDataInfo list(Battle battle)
    {
        startPage();
        List<Battle> list = battleService.selectBattleList(battle);
        return getDataTable(list);
    }

    /**
     * 导出演习管理列表
     */
    @PreAuthorize("@ss.hasPermi('drill:battle:export')")
    @Log(title = "演习管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Battle battle)
    {
        List<Battle> list = battleService.selectBattleList(battle);
        ExcelUtil<Battle> util = new ExcelUtil<Battle>(Battle.class);
        util.exportExcel(response, list, "演习管理数据");
    }

    /**
     * 获取演习管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('drill:battle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(battleService.selectBattleById(id));
    }

    /**
     * 新增演习管理
     */
    @PreAuthorize("@ss.hasPermi('drill:battle:add')")
    @Log(title = "演习管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Battle battle)
    {
        return toAjax(battleService.insertBattle(battle));
    }

    /**
     * 修改演习管理
     */
    @PreAuthorize("@ss.hasPermi('drill:battle:edit')")
    @Log(title = "演习管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Battle battle)
    {
        return toAjax(battleService.updateBattle(battle));
    }

    /**
     * 删除演习管理
     */
    @PreAuthorize("@ss.hasPermi('drill:battle:remove')")
    @Log(title = "演习管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(battleService.deleteBattleByIds(ids));
    }
}
