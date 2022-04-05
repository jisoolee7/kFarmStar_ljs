package com.kfarmstar.dto;

public class StoreGoodsSmall {
	
	private String goodsSmallCode;
	private String sellerStoreNum;
	private String goodsLargeCode;
	private String memberId;
	private String goodsLargeCate;
	private String goodsSmallCate;
	
	private StoreGoodsLarge storeGoodsLarge;
	private SellerStore sellerStore;
	private Member member;
	private GoodsLarge goodLarge;
	private GoodsSmall goodsSmall;
	public String getGoodsSmallCode() {
		return goodsSmallCode;
	}
	public void setGoodsSmallCode(String goodsSmallCode) {
		this.goodsSmallCode = goodsSmallCode;
	}
	public String getSellerStoreNum() {
		return sellerStoreNum;
	}
	public void setSellerStoreNum(String sellerStoreNum) {
		this.sellerStoreNum = sellerStoreNum;
	}
	public String getGoodsLargeCode() {
		return goodsLargeCode;
	}
	public void setGoodsLargeCode(String goodsLargeCode) {
		this.goodsLargeCode = goodsLargeCode;
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
	public String getGoodsSmallCate() {
		return goodsSmallCate;
	}
	public void setGoodsSmallCate(String goodsSmallCate) {
		this.goodsSmallCate = goodsSmallCate;
	}
	public StoreGoodsLarge getStoreGoodsLarge() {
		return storeGoodsLarge;
	}
	public void setStoreGoodsLarge(StoreGoodsLarge storeGoodsLarge) {
		this.storeGoodsLarge = storeGoodsLarge;
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
	public GoodsSmall getGoodsSmall() {
		return goodsSmall;
	}
	public void setGoodsSmall(GoodsSmall goodsSmall) {
		this.goodsSmall = goodsSmall;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StoreGoodsSmall [goodsSmallCode=");
		builder.append(goodsSmallCode);
		builder.append(", sellerStoreNum=");
		builder.append(sellerStoreNum);
		builder.append(", goodsLargeCode=");
		builder.append(goodsLargeCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsLargeCate=");
		builder.append(goodsLargeCate);
		builder.append(", goodsSmallCate=");
		builder.append(goodsSmallCate);
		builder.append(", storeGoodsLarge=");
		builder.append(storeGoodsLarge);
		builder.append(", sellerStore=");
		builder.append(sellerStore);
		builder.append(", member=");
		builder.append(member);
		builder.append(", goodLarge=");
		builder.append(goodLarge);
		builder.append(", goodsSmall=");
		builder.append(goodsSmall);
		builder.append("]");
		return builder.toString();
	}
	
}
