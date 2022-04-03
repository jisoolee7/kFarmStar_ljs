package com.kfarmstar.dto;


public class Member {
	//member_id, member_name, member_level, member_pw, member_nickname
	//member_addr, member_phone, member_birth, member_email, member_point, member_date

	private String memberId;
	private String memberName;
	private String memberLevel;
	private String memberPw;
	private String memberNickname;
	private String memberAddr;
	private String memberPhone;
	private String memberBirth;
	private String memberEmail;
	private int memberPoint;
	private String memberDate;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public String getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [memberId=");
		builder.append(memberId);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", memberLevel=");
		builder.append(memberLevel);
		builder.append(", memberPw=");
		builder.append(memberPw);
		builder.append(", memberNickname=");
		builder.append(memberNickname);
		builder.append(", memberAddr=");
		builder.append(memberAddr);
		builder.append(", memberPhone=");
		builder.append(memberPhone);
		builder.append(", memberBirth=");
		builder.append(memberBirth);
		builder.append(", memberEmail=");
		builder.append(memberEmail);
		builder.append(", memberPoint=");
		builder.append(memberPoint);
		builder.append(", memberDate=");
		builder.append(memberDate);
		builder.append("]");
		return builder.toString();
	}
	
}
