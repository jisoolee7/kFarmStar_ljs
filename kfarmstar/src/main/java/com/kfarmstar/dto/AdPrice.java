package com.kfarmstar.dto;

public class AdPrice {
	
	private String adPriceCode;
	private String adCate;
	private int adPricePerDay;
	private String memberId;
	private String regDate;
	
	public String getAdPriceCode() {
		return adPriceCode;
	}
	public void setAdPriceCode(String adPriceCode) {
		this.adPriceCode = adPriceCode;
	}
	public String getAdCate() {
		return adCate;
	}
	public void setAdCate(String adCate) {
		this.adCate = adCate;
	}
	public int getAdPricePerDay() {
		return adPricePerDay;
	}
	public void setAdPricePerDay(int adPricePerDay) {
		this.adPricePerDay = adPricePerDay;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "AdPrice [adPriceCode=" + adPriceCode + ", adCate=" + adCate + ", adPricePerDay=" + adPricePerDay
				+ ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}

}
