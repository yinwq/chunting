package com.yinwq.chunting.entity;

import java.util.Date;

import com.yinwq.chunting.util.PagedQuery;

public class Area extends PagedQuery{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 区域id
	 */
    private Integer areaId;
    
    /**
	 * 区域名称
	 */
    private String areaName;

    /**
	 * 区域编码
	 */
    private String areaNo;

    /**
	 * 上级区域id
	 */
    private Integer parentId;

    /**
	 * 拼音首字母
	 */
    private String initial;

    /**
	 * 全拼写
	 */
    private String spelling;
    
    /**
	 * 创建人
	 */
    private String createPerson;
    
    /**
	 * 创建时间
	 */
    private Date createTime;

    /**
	 * 修改人
	 */
    private String updatePerson;

    /**
	 * 修改时间
	 */
    private Date updateTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo == null ? null : areaNo.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling == null ? null : spelling.trim();
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}