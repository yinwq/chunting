package com.yinwq.chunting.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.yinwq.chunting.util.PagedQuery;

public class Goods extends PagedQuery {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id
	 */
	private Integer id;
	
	/**
	 * 商品名称
	 */
    private String goodsName;
    
    /** 商品类型 : 1:三草 2:彩妆**/
    private Integer goodsType;
    
    /**
	 * 总代价
	 */
    private Double totalAgentPrice;
    
    /**
	 * 一级价
	 */
    private Double firstAgentPrice;
    
    /**
	 * 二级价
	 */
    private Double secondAgentPrice;

    /**
	 * 三级价
	 */
    private Double thirdAgentPrice;
    
    /**
	 * 微商价
	 */
    private Double derivativePrice;
    
    /**
	 * 市场价
	 */
    private Double marketPrice;
    
    /**
	 * 库存
	 */
    private Integer goodsStock;
    
    /**
	 * 创建时间
	 */
    private Date createTime;
    
    /**
	 * 修改时间
	 */
    private Date updateTime;
    
    /**
     * 搜索创建时间区间
     */
	private String startTime;

	private String endTime;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }
    
	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(Integer goodsStock) {
		this.goodsStock = goodsStock;
	}

	public Double getTotalAgentPrice() {
		return totalAgentPrice;
	}

	public void setTotalAgentPrice(Double totalAgentPrice) {
		this.totalAgentPrice = totalAgentPrice;
	}

	public Double getFirstAgentPrice() {
		return firstAgentPrice;
	}

	public void setFirstAgentPrice(Double firstAgentPrice) {
		this.firstAgentPrice = firstAgentPrice;
	}

	public Double getSecondAgentPrice() {
		return secondAgentPrice;
	}

	public void setSecondAgentPrice(Double secondAgentPrice) {
		this.secondAgentPrice = secondAgentPrice;
	}

	public Double getThirdAgentPrice() {
		return thirdAgentPrice;
	}

	public void setThirdAgentPrice(Double thirdAgentPrice) {
		this.thirdAgentPrice = thirdAgentPrice;
	}

	public Double getDerivativePrice() {
		return derivativePrice;
	}

	public void setDerivativePrice(Double derivativePrice) {
		this.derivativePrice = derivativePrice;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCreateTimeStr(){
		if(this.createTime != null)
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.createTime);
		else
			return "";
	}
	
	public String getUpdateTimeStr(){
		if(this.updateTime != null)
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.updateTime);
		else
			return "";
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}