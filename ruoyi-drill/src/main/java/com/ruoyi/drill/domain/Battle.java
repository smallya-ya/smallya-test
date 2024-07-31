package com.ruoyi.drill.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 演习管理对象 t_battle
 * 
 * @author sixiaoya
 * @date 2024-07-30
 */
public class Battle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 演习名字 */
    @Excel(name = "演习名字")
    private String name;

    /** 地图id */
    @Excel(name = "地图id")
    private Long mapId;

    /** 地图格式 */
    @Excel(name = "地图格式")
    private Long mapType;

    /** 队伍 */
    @Excel(name = "队伍")
    private String team;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMapId(Long mapId) 
    {
        this.mapId = mapId;
    }

    public Long getMapId() 
    {
        return mapId;
    }
    public void setMapType(Long mapType) 
    {
        this.mapType = mapType;
    }

    public Long getMapType() 
    {
        return mapType;
    }
    public void setTeam(String team) 
    {
        this.team = team;
    }

    public String getTeam() 
    {
        return team;
    }
    public void setBeginTime(Date beginTime) 
    {
        this.beginTime = beginTime;
    }

    public Date getBeginTime() 
    {
        return beginTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("mapId", getMapId())
            .append("mapType", getMapType())
            .append("team", getTeam())
            .append("beginTime", getBeginTime())
            .append("endTime", getEndTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
