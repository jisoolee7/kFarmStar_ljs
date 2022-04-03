package com.kfarmstar.dto;

public class SellerGrade {
	
	private String sellerGradeNum;
	private String gradeType;
	private String memberId;
	private int sellCount;
	private int sellAmount;
	private float sellerStarpointStandard;
	private float sellerAdDiscount;
	private float deliveryPriceDiscount;
	
	private Member member;

	public String getSellerGradeNum() {
		return sellerGradeNum;
	}

	public void setSellerGradeNum(String sellerGradeNum) {
		this.sellerGradeNum = sellerGradeNum;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public int getSellAmount() {
		return sellAmount;
	}

	public void setSellAmount(int sellAmount) {
		this.sellAmount = sellAmount;
	}

	public float getSellerStarpointStandard() {
		return sellerStarpointStandard;
	}

	public void setSellerStarpointStandard(float sellerStarpointStandard) {
		this.sellerStarpointStandard = sellerStarpointStandard;
	}

	public float getSellerAdDiscount() {
		return sellerAdDiscount;
	}

	public void setSellerAdDiscount(float sellerAdDiscount) {
		this.sellerAdDiscount = sellerAdDiscount;
	}

	public float getDeliveryPriceDiscount() {
		return deliveryPriceDiscount;
	}

	public void setDeliveryPriceDiscount(float deliveryPriceDiscount) {
		this.deliveryPriceDiscount = deliveryPriceDiscount;
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
		builder.append("SellerGrade [sellerGradeNum=");
		builder.append(sellerGradeNum);
		builder.append(", gradeType=");
		builder.append(gradeType);
		builder.append(", memberId=");
		builder.append(memberId);
		builder.append(", sellCount=");
		builder.append(sellCount);
		builder.append(", sellAmount=");
		builder.append(sellAmount);
		builder.append(", sellerStarpointStandard=");
		builder.append(sellerStarpointStandard);
		builder.append(", sellerAdDiscount=");
		builder.append(sellerAdDiscount);
		builder.append(", deliveryPriceDiscount=");
		builder.append(deliveryPriceDiscount);
		builder.append(", member=");
		builder.append(member);
		builder.append("]");
		return builder.toString();
	}

	
}
