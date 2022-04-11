package com.kfarmstar.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Goods;

@Mapper
public interface UserGoodsMapper {

	
	// 사용자 화면 - 상품 전체 목록 조회
	public List<Goods> getUserGoodsList();
	
	// 사용자 화면 - 상품 코드별 상세 정보 조회
	public Goods getUserGoodsByCode(String goodsRefurbCode);

	// 사용자 화면 - 특정 상품을 제외하고  네 가지 상품 랜덤 조회
	public List<Goods> getRandomGoods(String goodsRefurbCode);
	
}
