package com.yinwq.chunting.util;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PagedData <T extends Serializable > implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分页大小
	 */
	public int pageSize;
	
	/**
	 * 页码
	 */
	public int pageNo;
	
	/**
	 * 结果总数
	 */
	public int totalSize;
	
	public List<T> resultList;

	public int getTotalSize() {
		return totalSize;
	}
	
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);		
	}
}
