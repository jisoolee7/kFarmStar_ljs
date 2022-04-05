package com.kfarmstar.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.GoodsMapper;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;
import com.kfarmstar.dto.StoreGoodsLarge;
import com.kfarmstar.dto.StoreGoodsSmall;


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
	
	
	public int addGoods(Goods goods, StoreGoodsLarge storeGoodsLarge, StoreGoodsSmall storeGoodsSmall) {
		
		// seller_store_num 스토어별 상품 등록 (store_goods_large 테이블 등록)
		String storeGoodsLargeCode = commonMapper.getNewCode("goods_large_code", "store_goods_large");
		storeGoodsLarge.setGoodsLargeCode(storeGoodsLargeCode);
		storeGoodsLarge.setMemberId("id002");	// 임의로 넣은 판매자 아이디
		storeGoodsLarge.setSellerStoreNum("seller_store_num_3");	// 임의로 넣은 판매자 상점 번호
		
		int result = goodsMapper.addStoreGoodsLarge(storeGoodsLarge);
		
		// seller_store_num 스토어별 상품 등록 (store_goods_small 테이블 등록)
		String storeGoodsSmallCode = commonMapper.getNewCode("goods_small_code", "store_goods_small");
		storeGoodsSmall.setGoodsSmallCode(storeGoodsSmallCode);
		storeGoodsSmall.setGoodsLargeCode(storeGoodsLarge.getGoodsLargeCode());
		storeGoodsSmall.setMemberId(storeGoodsLarge.getMemberId());
		storeGoodsSmall.setSellerStoreNum(storeGoodsLarge.getSellerStoreNum());
		
		result += goodsMapper.addStoreGoodsSmall(storeGoodsSmall);

		// goods_management 
		String goodsRefurbCode = commonMapper.getNewCode("goods_refurb_code", "goods_management");
		goods.setGoodsRefurbCode(goodsRefurbCode);
		goods.setMemberId(storeGoodsLarge.getMemberId());
		goods.setSellerStoreNum(storeGoodsLarge.getSellerStoreNum());
		goods.setGoodsLargeCode(storeGoodsLarge.getGoodsLargeCode());
		goods.setGoodsSmallCode(storeGoodsSmall.getGoodsSmallCode());
		
		result += goodsMapper.addGoods(goods);
		
		return result;
	}
	
	/**
	 * 상품 코드별 상세 정보 조회
	 */
	public Goods getGoodsByCode(String goodsRefurbCode) {
		
		return goodsMapper.getGoodsByCode(goodsRefurbCode);
	}
	
	
	/**
	 * 전체 상품 목록 조회
	 */
	public List<Goods> getGoodsList() {
		List<Goods> goodsList = goodsMapper.getGoodsList();
		return goodsList;
	}
	
	
	/**
	 * 전체 상품 카테고리 목록 조회
	 */
	public List<GoodsSmall> getGoodsCateList() {
		List<GoodsSmall> goodsCateList = goodsMapper.getGoodsCateList();
		return goodsCateList;
	}
	 
	
	/**
	 * 상품 대분류 카테고리 목록 조회
	 */
	public List<GoodsLarge> getLargeCateList() {
		List<GoodsLarge> largeCateList = goodsMapper.getLargeCateList();
		return largeCateList;
	}
	
	
	/**
	 * 상품 대분류 카테고리 등록
	 */
	public int addLargeCate(GoodsLarge goodsLarge) {
		 //pk컬럼에 들어갈 코드를 자동으로 만들어주는 Mapper //pk로 쓸 db의 컬럼명 //코드가 들어갈 db의 테이블명 
		  String newCode = commonMapper.getNewCode("goods_large_cate", "goods_large");
		  goodsLarge.setGoodsLargeCate(newCode); 
		  goodsLarge.setMemberId("id002"); //임의로 넣은 등록자 아이디
		  
		  int result = goodsMapper.addLargeCate(goodsLarge);
		  
		  return result; 
	}
	
	
	/**
	 * 상품 카테고리 수정
	 */
	public int modifyGoodsCate(GoodsSmall goodsSmall) {
			
		return goodsMapper.modifyGoodsCate(goodsSmall);
	}
	
	
	/**
	 * 상품 소분류 카테고리 등록
	 */
	public int addSmallCate(GoodsSmall goodsSmall) {
		String newCode = commonMapper.getNewCode("goods_small_cate", "goods_small");
		goodsSmall.setGoodsSmallCate(newCode);
		goodsSmall.setMemberId("id002"); //임의로 넣은 등록자 아이디

		int result = goodsMapper.addSmallCate(goodsSmall);
		
		return result;
	}

	
	/**
	 * 상품 코드별 카테고리 정보 조회
	 */
	public GoodsSmall getSmallCateInfoByCode(String goodsSmallCate) {
		return goodsMapper.getSmallCateInfoByCode(goodsSmallCate);
	}
	
	
}
