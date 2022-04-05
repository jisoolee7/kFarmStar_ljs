package com.kfarmstar.admin.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.AdMapper;
import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.dto.AdApply;
import com.kfarmstar.dto.AdPrice;

@Service
@Transactional
public class AdService {

	private AdMapper adMapper;
	private CommonMapper commonMapper;
	
	@Autowired
	public AdService(AdMapper adMapper, CommonMapper commonMapper) {
		this.adMapper = adMapper;
		this.commonMapper = commonMapper;
	}
	
	
	/**
	 * 광고 신청 목록 조회
	 */
	public List<AdApply> getAdApplyList() {
		
		List<AdApply> adApplyList = adMapper.getAdApplyList();
		return adApplyList;
	}
	
	// 상품 코드별 상세 정보 조회
	public AdApply getAdApplyByCode(String adApplyCode) {
		
		return adMapper.getAdApplyByCode(adApplyCode);
	}
	
	
	
	
	/**
	 * 광고 단가 목록 조회
	 */
	public List<AdPrice> getAdPriceList() {
		
		List<AdPrice> adPriceList = adMapper.getAdPriceList();
		return adPriceList;
	}
	

	/**
	 * 광고단가 코드별 정보 조회
	 */
	public AdPrice getAdPriceInfoByCode(String adPriceCode) {
		return adMapper.getAdPriceInfoByCode(adPriceCode);
	}
	
	/**
	 * 광고 신청 상세 정보 수정
	 */
	public int modifyAdApply(AdApply adApply) {
		
		String startDate = adApply.getAdStartDate();	//datePicker 시작날짜
		String endDate = adApply.getAdEndDate();		//datePicker 종료날짜
		
		//문자열을 LocalDateTime객체로 만들기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);	
		LocalDate localStartDate = LocalDate.parse(startDate, formatter);
		LocalDate localEndDate = LocalDate.parse(endDate, formatter);
		
		//기간 구하기
		Period period = Period.between(localStartDate, localEndDate);
		int contractTerm = period.getDays()+1;
		String term = Integer.toString(contractTerm);
		
		adApply.setAdContractTerm(term); // 계약기간 dto에 넣어주기
		return adMapper.modifyAdApply(adApply);
	}
	
	
	/**
	 * 광고 단가 수정
	 */
	public int modifyAdPrice(AdPrice adPrice) {
		
		adPrice.setUpdateManagerId("id003"); //임의로 넣은 수정자 아이디
		return adMapper.modifyAdPrice(adPrice);
	}
	
	
	/**
	 * 광고 단가 등록
	 */
	public int addAdPrice(AdPrice adPrice) {
		//pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("ad_price_code", "ad_price");
		  adPrice.setAdPriceCode(newCode);
		  adPrice.setMemberId("id002"); //임의로 넣은 등록자 아이디
		  
		  int result = adMapper.addAdPrice(adPrice);
		  
		  return result; 
	}
	
	
}
