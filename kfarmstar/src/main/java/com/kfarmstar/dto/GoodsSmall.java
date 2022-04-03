package com.kfarmstar.dto;

public class GoodsSmall {
	private String goodsSmallCate;
	private String goodsLargeCate;
	private String memberId;
	private String updateManagerId;
	private String goodsSmallName;
	private String entryTime;
	private String lastUpdateTime;
	
	private GoodsLarge goodsLarge;
	private Member member;
	
	public String getGoodsSmallCate() {
		return goodsSmallCate;
	}
	public void setGoodsSmallCate(String goodsSmallCate) {
		this.goodsSmallCate = goodsSmallCate;
	}
	public String getGoodsLargeCate() {
		return goodsLargeCate;
	}
	public void setGoodsLargeCate(String goodsLargeCate) {
		this.goodsLargeCate = goodsLargeCate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getUpdateManagerId() {
		return updateManagerId;
	}
	public void setUpdateManagerId(String updateManagerId) {
		this.updateManagerId = updateManagerId;
	}
	public String getGoodsSmallName() {
		return goodsSmallName;
	}
	public void setGoodsSmallName(String goodsSmallName) {
		this.goodsSmallName = goodsSmallName;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public GoodsLarge getGoodsLarge() {
		return goodsLarge;
	}
	public void setGoodsLarge(GoodsLarge goodsLarge) {
		this.goodsLarge = goodsLarge;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsSmall [goodsSmallCate=");
		builder.append(goodsSmallCate);
		builder.append(", goodsLargeCate=");
		builder.append(goodsLargeCate);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", updateManagerId=");
		builder.append(updateManagerId);
		builder.append(", goodsSmallName=");
		builder.append(goodsSmallName);
		builder.append(", entryTime=");
		builder.append(entryTime);
		builder.append(", lastUpdateTime=");
		builder.append(lastUpdateTime);
		builder.append(", goodsLarge=");
		builder.append(goodsLarge);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
	
}
