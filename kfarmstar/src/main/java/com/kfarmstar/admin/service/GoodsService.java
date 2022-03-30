package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.GoodsMapper;
import com.kfarmstar.dto.GoodsCate;


@Service
@Transactional
public class GoodsService {

	//DI 의존성 주입
	private GoodsMapper goodsMapper;
	private CommonMapper commonMapper;
	
	@Autowired
	public GoodsService(GoodsMapper goodsMapper, CommonMapper commonMapper) {
		this.goodsMapper = goodsMapper;
		this.commonMapper = commonMapper;
	}
	
	// 전체 상품 카테고리 목록 조회
	public List<GoodsCate> getGoodsCateList() {
		List<GoodsCate> goodsCateList = goodsMapper.getGoodsCateList();
		return goodsCateList;
	}
	
	
	// 상품 대분류 카테고리 등록
	public int addLargeCate(GoodsCate goodsCate) {
		//pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper      //pk로 쓸 db의 컬럼명                     //코드가 들어갈 db의 테이블명
		String newCode = commonMapper.getNewCode("goods_large_cate", "goods_large");
		goodsCate.setGoodsLargeCode(newCode);
		goodsCate.setEntryId("id002");
		
		int result = goodsMapper.addLargeCate(goodsCate);
		
		return result;
	}
}
