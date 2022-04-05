package com.kfarmstar.dto;

public class Goods {
	private String goodsRefurbCode;
	private String sellerStoreNum;
	private String goodsLargeCode;
	private String goodsSmallCode;
	private String memberId;
	private String goodsLargeCate;
	private String goodsSmallCate;
	private String goodsRefurbName;
	private String goodsNormalPrice;
	private String goodsRefurbPrice;
	private String goodsRefurbCount;
	private String goodsRefurbHarvestDate;
	private String goodsRefurbOrganic;
	private String goodsRefurbImg;
	private String goodsPostExplain;
	private String goodsRefurbSellState;
	private String entryTime;
	
	private GoodsLarge goodsLarge;
	private GoodsSmall goodsSmall;
	private Member member;
	private SellerStore sellerStore;
	private StoreGoodsLarge storeGoodsLarge;
	private StoreGoodsSmall storeGoodsSmall;
	public String getGoodsRefurbCode() {
		return goodsRefurbCode;
	}
	public void setGoodsRefurbCode(String goodsRefurbCode) {
		this.goodsRefurbCode = goodsRefurbCode;
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
	public String getGoodsSmallCode() {
		return goodsSmallCode;
	}
	public void setGoodsSmallCode(String goodsSmallCode) {
		this.goodsSmallCode = goodsSmallCode;
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
	public String getGoodsRefurbName() {
		return goodsRefurbName;
	}
	public void setGoodsRefurbName(String goodsRefurbName) {
		this.goodsRefurbName = goodsRefurbName;
	}
	public String getGoodsNormalPrice() {
		return goodsNormalPrice;
	}
	public void setGoodsNormalPrice(String goodsNormalPrice) {
		this.goodsNormalPrice = goodsNormalPrice;
	}
	public String getGoodsRefurbPrice() {
		return goodsRefurbPrice;
	}
	public void setGoodsRefurbPrice(String goodsRefurbPrice) {
		this.goodsRefurbPrice = goodsRefurbPrice;
	}
	public String getGoodsRefurbCount() {
		return goodsRefurbCount;
	}
	public void setGoodsRefurbCount(String goodsRefurbCount) {
		this.goodsRefurbCount = goodsRefurbCount;
	}
	public String getGoodsRefurbHarvestDate() {
		return goodsRefurbHarvestDate;
	}
	public void setGoodsRefurbHarvestDate(String goodsRefurbHarvestDate) {
		this.goodsRefurbHarvestDate = goodsRefurbHarvestDate;
	}
	public String getGoodsRefurbOrganic() {
		return goodsRefurbOrganic;
	}
	public void setGoodsRefurbOrganic(String goodsRefurbOrganic) {
		this.goodsRefurbOrganic = goodsRefurbOrganic;
	}
	public String getGoodsRefurbImg() {
		return goodsRefurbImg;
	}
	public void setGoodsRefurbImg(String goodsRefurbImg) {
		this.goodsRefurbImg = goodsRefurbImg;
	}
	public String getGoodsPostExplain() {
		return goodsPostExplain;
	}
	public void setGoodsPostExplain(String goodsPostExplain) {
		this.goodsPostExplain = goodsPostExplain;
	}
	public String getGoodsRefurbSellState() {
		return goodsRefurbSellState;
	}
	public void setGoodsRefurbSellState(String goodsRefurbSellState) {
		this.goodsRefurbSellState = goodsRefurbSellState;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public GoodsLarge getGoodsLarge() {
		return goodsLarge;
	}
	public void setGoodsLarge(GoodsLarge goodsLarge) {
		this.goodsLarge = goodsLarge;
	}
	public GoodsSmall getGoodsSmall() {
		return goodsSmall;
	}
	public void setGoodsSmall(GoodsSmall goodsSmall) {
		this.goodsSmall = goodsSmall;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public SellerStore getSellerStore() {
		return sellerStore;
	}
	public void setSellerStore(SellerStore sellerStore) {
		this.sellerStore = sellerStore;
	}
	public StoreGoodsLarge getStoreGoodsLarge() {
		return storeGoodsLarge;
	}
	public void setStoreGoodsLarge(StoreGoodsLarge storeGoodsLarge) {
		this.storeGoodsLarge = storeGoodsLarge;
	}
	public StoreGoodsSmall getStoreGoodsSmall() {
		return storeGoodsSmall;
	}
	public void setStoreGoodsSmall(StoreGoodsSmall storeGoodsSmall) {
		this.storeGoodsSmall = storeGoodsSmall;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsRefurbCode=");
		builder.append(goodsRefurbCode);
		builder.append(", sellerStoreNum=");
		builder.append(sellerStoreNum);
		builder.append(", goodsLargeCode=");
		builder.append(goodsLargeCode);
		builder.append(", goodsSmallCode=");
		builder.append(goodsSmallCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", goodsLargeCate=");
		builder.append(goodsLargeCate);
		builder.append(", goodsSmallCate=");
		builder.append(goodsSmallCate);
		builder.append(", goodsRefurbName=");
		builder.append(goodsRefurbName);
		builder.append(", goodsNormalPrice=");
		builder.append(goodsNormalPrice);
		builder.append(", goodsRefurbPrice=");
		builder.append(goodsRefurbPrice);
		builder.append(", goodsRefurbCount=");
		builder.append(goodsRefurbCount);
		builder.append(", goodsRefurbHarvestDate=");
		builder.append(goodsRefurbHarvestDate);
		builder.append(", goodsRefurbOrganic=");
		builder.append(goodsRefurbOrganic);
		builder.append(", goodsRefurbImg=");
		builder.append(goodsRefurbImg);
		builder.append(", goodsPostExplain=");
		builder.append(goodsPostExplain);
		builder.append(", goodsRefurbSellState=");
		builder.append(goodsRefurbSellState);
		builder.append(", entryTime=");
		builder.append(entryTime);
		builder.append(", goodsLarge=");
		builder.append(goodsLarge);
		builder.append(", goodsSmall=");
		builder.append(goodsSmall);
		builder.append(", member=");
		builder.append(member);
		builder.append(", sellerStore=");
		builder.append(sellerStore);
		builder.append(", storeGoodsLarge=");
		builder.append(storeGoodsLarge);
		builder.append(", storeGoodsSmall=");
		builder.append(storeGoodsSmall);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
