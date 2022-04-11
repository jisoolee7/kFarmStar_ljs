package com.kfarmstar.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerStore;

@Mapper
public interface UserMemberMapper {
	
	public int addSellerStoreInfo(SellerStore sellerStore);
	
	//아이디별 회원정보 조회
	public Member getMemberInfoById(String memberId);
	
	//구매자 회원가입
	public int addMember(Member member);
	
	//구매자 아이디 중복 체크
	public boolean isIdCheck(String memberId);
}
