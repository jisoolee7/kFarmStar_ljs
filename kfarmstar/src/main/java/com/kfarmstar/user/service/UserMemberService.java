package com.kfarmstar.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerStore;
import com.kfarmstar.user.mapper.UserMemberMapper;

@Service
@Transactional
public class UserMemberService {
	
	//DI 의존성 주입 생성자 메서드 주입 방식
	private UserMemberMapper userMemberMapper;
	private CommonMapper commonMapper;
	
	@Autowired
	public UserMemberService(UserMemberMapper userMemberMapper, CommonMapper commonMapper) {
		this.userMemberMapper = userMemberMapper;
		this.commonMapper = commonMapper;
	}
	
	public int addSellerStoreInfo(SellerStore sellerStore, Member member) {
		
		String newCode = commonMapper.getNewCode("seller_store_num", "seller_store");
		sellerStore.setSellerStoreNum(newCode);
		
		member.setMemberLevel("판매자");
		
		int result = userMemberMapper.addMember(member);
		sellerStore.setMemberId(member.getMemberId());
		 result += userMemberMapper.addSellerStoreInfo(sellerStore);
		
		return result;
	}
	
	public Member getMemberInfoById(String memberId) {
		return userMemberMapper.getMemberInfoById(memberId);
	}
	
	public int addMember(Member member) {
		
		member.setMemberLevel("구매자");
		member.setMemberPoint(0);
		
		int addMember = userMemberMapper.addMember(member);
		
		return addMember;
		
	}
	
}
