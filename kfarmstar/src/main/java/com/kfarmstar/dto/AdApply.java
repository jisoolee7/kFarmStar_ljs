package com.kfarmstar.dto;

public class AdApply {
	
	private String adApplyCode;
	private String adPriceCode;
	private String memberId;
	private String adApplyTitle;
	private String adCate;
	private String adContractPrice;
	private String adApplyDate;
	private String adStartDate;
	private String adEndDate;
	private String adContractTerm;
	private String adGoodsUrl;
	private String adContent;
	private String adImg;
	private String adPermitState;
	private String managerId;
	private String adPermitDate;
	
	
	private AdPrice adPrice;
	private Member member;
	public String getAdApplyCode() {
		return adApplyCode;
	}
	public void setAdApplyCode(String adApplyCode) {
		this.adApplyCode = adApplyCode;
	}
	public String getAdPriceCode() {
		return adPriceCode;
	}
	public void setAdPriceCode(String adPriceCode) {
		this.adPriceCode = adPriceCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAdApplyTitle() {
		return adApplyTitle;
	}
	public void setAdApplyTitle(String adApplyTitle) {
		this.adApplyTitle = adApplyTitle;
	}
	public String getAdCate() {
		return adCate;
	}
	public void setAdCate(String adCate) {
		this.adCate = adCate;
	}
	public String getAdContractPrice() {
		return adContractPrice;
	}
	public void setAdContractPrice(String adContractPrice) {
		this.adContractPrice = adContractPrice;
	}
	public String getAdApplyDate() {
		return adApplyDate;
	}
	public void setAdApplyDate(String adApplyDate) {
		this.adApplyDate = adApplyDate;
	}
	public String getAdStartDate() {
		return adStartDate;
	}
	public void setAdStartDate(String adStartDate) {
		this.adStartDate = adStartDate;
	}
	public String getAdEndDate() {
		return adEndDate;
	}
	public void setAdEndDate(String adEndDate) {
		this.adEndDate = adEndDate;
	}
	public String getAdContractTerm() {
		return adContractTerm;
	}
	public void setAdContractTerm(String adContractTerm) {
		this.adContractTerm = adContractTerm;
	}
	public String getAdGoodsUrl() {
		return adGoodsUrl;
	}
	public void setAdGoodsUrl(String adGoodsUrl) {
		this.adGoodsUrl = adGoodsUrl;
	}
	public String getAdContent() {
		return adContent;
	}
	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}
	public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
	public String getAdPermitState() {
		return adPermitState;
	}
	public void setAdPermitState(String adPermitState) {
		this.adPermitState = adPermitState;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getAdPermitDate() {
		return adPermitDate;
	}
	public void setAdPermitDate(String adPermitDate) {
		this.adPermitDate = adPermitDate;
	}
	public AdPrice getAdPrice() {
		return adPrice;
	}
	public void setAdPrice(AdPrice adPrice) {
		this.adPrice = adPrice;
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
		builder.append("AdApply [adApplyCode=");
		builder.append(adApplyCode);
		builder.append(", adPriceCode=");
		builder.append(adPriceCode);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", adApplyTitle=");
		builder.append(adApplyTitle);
		builder.append(", adCate=");
		builder.append(adCate);
		builder.append(", adContractPrice=");
		builder.append(adContractPrice);
		builder.append(", adApplyDate=");
		builder.append(adApplyDate);
		builder.append(", adStartDate=");
		builder.append(adStartDate);
		builder.append(", adEndDate=");
		builder.append(adEndDate);
		builder.append(", adContractTerm=");
		builder.append(adContractTerm);
		builder.append(", adGoodsUrl=");
		builder.append(adGoodsUrl);
		builder.append(", adContent=");
		builder.append(adContent);
		builder.append(", adImg=");
		builder.append(adImg);
		builder.append(", adPermitState=");
		builder.append(adPermitState);
		builder.append(", managerId=");
		builder.append(managerId);
		builder.append(", adPermitDate=");
		builder.append(adPermitDate);
		builder.append(", adPrice=");
		builder.append(adPrice);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}
	
	
}
