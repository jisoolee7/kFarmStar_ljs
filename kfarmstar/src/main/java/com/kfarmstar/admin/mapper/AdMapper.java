package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.AdPrice;

@Mapper
public interface AdMapper {


	// 광고 단가 목록
	public List<AdPrice> getAdPriceList();

}
