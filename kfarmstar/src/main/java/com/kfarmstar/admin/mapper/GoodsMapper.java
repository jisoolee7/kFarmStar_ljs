package com.kfarmstar.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;
import com.kfarmstar.dto.SellerStore;
import com.kfarmstar.dto.StoreGoodsLarge;
import com.kfarmstar.dto.StoreGoodsSmall;


@Mapper
public interface GoodsMapper {
	
	
	// 상품 등록
	public int addGoods(Goods goods);
	
	// seller_store_num 스토어별 상품 등록 (store_goods_large 테이블 등록)
	public int addStoreGoodsLarge(StoreGoodsLarge storeGoodsLarge);

	// seller_store_num 스토어별 상품 등록 (store_goods_large 테이블 등록)
	public int addStoreGoodsSmall(StoreGoodsSmall storeGoodsSmall);
	
	// 판매자 아이디별 seller_store_num 조회
	public SellerStore getSellerStoreNumById(String memberId);

	
	
	// 상품 목록 조회
	public List<Goods> getGoodsList(Map<String, Object> paramMap);
	
	// 상품 코드별 상세 정보 조회
	public Goods getGoodsByCode(String goodsRefurbCode);
	
	// 상품 코드별 상세 정보 수정
	public int modifyGoods(Goods goods);

	
	// 상품 카테고리 전체 목록 조회
	public List<GoodsSmall> getGoodsCateList(String searchKey, String searchValue);

	// 상품 대분류 카테고리 등록
	public int addLargeCate(GoodsLarge goodsLarge);
		
	// 상품 소분류 카테고리 등록
	public int addSmallCate(GoodsSmall goodsSmall);
	
	// 상품 소분류 카테고리  수정
	public int modifyGoodsCate(GoodsSmall goodsSmall);
	
	// 상품 대분류 카테고리 목록 조회
	public List<GoodsLarge> getLargeCateList();
	
	// 소분류 코드별 정보 조회
	public GoodsSmall getSmallCateInfoByCode(String goodsSmallCate);

	// 소분류 카테고리 목록
	public List<GoodsSmall> getSmallCateList(String goodsLargeCate);
	

	
}
