package com.yinwq.chunting.util;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 分页查询对象
 *
 * @author yinwq
 * 
 */
public class PagedQuery implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int defaultPageSize = 10;
	public static final int defaultPageNo = 1;
	
	private Integer pageSize = defaultPageSize;
	private Integer pageNo = defaultPageNo;
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize == null || defaultPageSize <= 0 ? defaultPageSize : pageSize;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo == null || pageNo <= 0 ? defaultPageNo : pageNo;
	}
	
	public Integer getStartRow() {
		return (pageNo - 1) * pageSize;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
}
