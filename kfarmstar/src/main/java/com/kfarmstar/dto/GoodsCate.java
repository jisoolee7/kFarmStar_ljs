package com.kfarmstar.dto;

public class GoodsCate {
	
	private String goodsLargeCode;
	private String goodsLargeName;
	private String goodsSmallCode;
	private String goodsSmallName;
	private String entryId;
	private String updateId;
	private String entryTime;
	private String updateTime;
	
	public String getGoodsLargeCode() {
		return goodsLargeCode;
	}
	public void setGoodsLargeCode(String goodsLargeCode) {
		this.goodsLargeCode = goodsLargeCode;
	}
	public String getGoodsLargeName() {
		return goodsLargeName;
	}
	public void setGoodsLargeName(String goodsLargeName) {
		this.goodsLargeName = goodsLargeName;
	}
	public String getGoodsSmallCode() {
		return goodsSmallCode;
	}
	public void setGoodsSmallCode(String goodsSmallCode) {
		this.goodsSmallCode = goodsSmallCode;
	}
	public String getGoodsSmallName() {
		return goodsSmallName;
	}
	public void setGoodsSmallName(String goodsSmallName) {
		this.goodsSmallName = goodsSmallName;
	}
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
	public String getUpdateId() {
		return updateId;
	}
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "GoodsCate [goodsLargeCode=" + goodsLargeCode + ", goodsLargeName=" + goodsLargeName
				+ ", goodsSmallCode=" + goodsSmallCode + ", goodsSmallName=" + goodsSmallName + ", entryId=" + entryId
				+ ", updateId=" + updateId + ", entryTime=" + entryTime + ", updateTime=" + updateTime + "]";
	}
	
}
