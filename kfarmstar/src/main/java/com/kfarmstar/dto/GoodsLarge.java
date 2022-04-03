package com.kfarmstar.dto;

public class GoodsLarge {
	private String goodsLargeCate;
	private String memberId;
	private String updateManagerId;
	private String goodsLargeName;
	private String entryTime;
	private String lastUpdateTime;
	
	private Member member;

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

	public String getGoodsLargeName() {
		return goodsLargeName;
	}

	public void setGoodsLargeName(String goodsLargeName) {
		this.goodsLargeName = goodsLargeName;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsLarge [goodsLargeCate=");
		builder.append(goodsLargeCate);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", updateManagerId=");
		builder.append(updateManagerId);
		builder.append(", goodsLargeName=");
		builder.append(goodsLargeName);
		builder.append(", entryTime=");
		builder.append(entryTime);
		builder.append(", lastUpdateTime=");
		builder.append(lastUpdateTime);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

	
}
