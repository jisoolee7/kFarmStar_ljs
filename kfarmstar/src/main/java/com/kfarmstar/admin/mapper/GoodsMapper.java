package com.kfarmstar.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.GoodsCate;


@Mapper
public interface GoodsMapper {

	// 상품 카테고리 전체 목록 조회
	public List<GoodsCate> getGoodsCateList();
		
	// 상품 대분류 카테고리 등록
	public int addLargeCate(GoodsCate goodsCate);
}
