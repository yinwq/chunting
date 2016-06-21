package com.yinwq.chunting.entity;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.yinwq.chunting.util.PagedQuery;

public class Goods extends PagedQuery {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String goodsName;
    
    /** 商品类型 : 1:三草 2:彩妆**/
    private Integer goodsType;

    private Double totalAgentPrice;

    private Double firstAgentPrice;

    private Double secondAgentPrice;

    private Double thirdAgentPrice;

    private Double derivativePrice;
    
    private Double marketPrice;

    private Integer goodsStock;
    
    private Date createTime;
    
    private Date updateTime;
    

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
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}