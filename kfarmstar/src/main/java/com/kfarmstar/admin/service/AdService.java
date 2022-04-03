package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.AdMapper;
import com.kfarmstar.dto.AdPrice;

@Service
@Transactional
public class AdService {

	private AdMapper adMapper;
	
	@Autowired
	public AdService(AdMapper adMapper) {
		this.adMapper = adMapper;
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
	
}
