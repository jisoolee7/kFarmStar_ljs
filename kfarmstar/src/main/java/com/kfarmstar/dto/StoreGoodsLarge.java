package com.kfarmstar.dto;

public class StoreGoodsLarge {

	private String goodsLargeCode;
	private String sellerStoreNum;
	private String memberId;
	private String goodsLargeCate;
	
	private SellerStore sellerStore;
	private Member member;
	private GoodsLarge goodLarge;
	
	public String getGoodsLargeCode() {
		return goodsLargeCode;
	}
	public void setGoodsLargeCode(String goodsLargeCode) {
		this.goodsLargeCode = goodsLargeCode;
	}
	public String getSellerStoreNum() {
		return sellerStoreNum;
	}
	public void setSellerStoreNum(String sellerStoreNum) {
		this.sellerStoreNum = sellerStoreNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getGoodsLargeCate() {
		return goodsLargeCate;
	}
	public void setGoodsLargeCate(String goodsLargeCate) {
		this.goodsLargeCate = goodsLargeCate;
	}
	public SellerStore getSellerStore() {
		return sellerStore;
	}
	public void setSellerStore(SellerStore sellerStore) {
		this.sellerStore = sellerStore;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public GoodsLarge getGoodLarge() {
		return goodLarge;
	}
	public void setGoodLarge(GoodsLarge goodLarge) {
		this.goodLarge = goodLarge;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StoreGoodsLarge [goodsLargeCode=");
		builder.append(goodsLargeCode);
		builder.append(", sellerStoreNum=");
		builder.append(sellerStoreNum);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsLargeCate=");
		builder.append(goodsLargeCate);
		builder.append(", sellerStore=");
		builder.append(sellerStore);
		builder.append(", member=");
		builder.append(member);
		builder.append(", goodLarge=");
		builder.append(goodLarge);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
