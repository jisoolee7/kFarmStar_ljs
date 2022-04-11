package com.kfarmstar.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kfarmstar.admin.mapper.CommonMapper;
import com.kfarmstar.admin.mapper.FileMapper;
import com.kfarmstar.admin.mapper.GoodsMapper;
import com.kfarmstar.dto.FileDto;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;
import com.kfarmstar.dto.SellerStore;
import com.kfarmstar.dto.StoreGoodsLarge;
import com.kfarmstar.dto.StoreGoodsSmall;
import com.kfarmstar.util.FileUtil;


@Service
@Transactional
public class GoodsService {

	//DI 의존성 주입
	private GoodsMapper goodsMapper;
	private CommonMapper commonMapper;
	private FileUtil fileUtil;
	private FileMapper fileMapper;
	
	@Autowired
	public GoodsService(GoodsMapper goodsMapper, CommonMapper commonMapper, FileUtil fileUtil, FileMapper fileMapper) {
		this.goodsMapper = goodsMapper;
		this.commonMapper = commonMapper;
		this.fileUtil = fileUtil;
		this.fileMapper = fileMapper;
	}
	
	
	/**
	 * 상품 등록
	 */
	public int addGoods(String sessionId, Goods goods, StoreGoodsLarge storeGoodsLarge, StoreGoodsSmall storeGoodsSmall, MultipartFile[] fileImage, String fileRealPath) {
		
		// seller_store_num 스토어별 상품 등록 (store_goods_large 테이블 등록)
		String storeGoodsLargeCode = commonMapper.getNewCode("goods_large_code", "store_goods_large");
		storeGoodsLarge.setGoodsLargeCode(storeGoodsLargeCode);
		storeGoodsLarge.setMemberId(sessionId);	// 로그인한 판매자 아이디 
		SellerStore sellerStore = goodsMapper.getSellerStoreNumById(storeGoodsLarge.getMemberId()); //아이디별 셀러스토어 정보 검색
		storeGoodsLarge.setSellerStoreNum(sellerStore.getSellerStoreNum());	// 아이디에 해당하는  판매자 상점 번호 입력
		
		int result = goodsMapper.addStoreGoodsLarge(storeGoodsLarge);
		
		// seller_store_num 스토어별 상품 등록 (store_goods_small 테이블 등록)
		String storeGoodsSmallCode = commonMapper.getNewCode("goods_small_code", "store_goods_small");
		storeGoodsSmall.setGoodsSmallCode(storeGoodsSmallCode);
		storeGoodsSmall.setGoodsLargeCode(storeGoodsLarge.getGoodsLargeCode());
		storeGoodsSmall.setMemberId(storeGoodsLarge.getMemberId());
		storeGoodsSmall.setSellerStoreNum(storeGoodsLarge.getSellerStoreNum());
		
		result += goodsMapper.addStoreGoodsSmall(storeGoodsSmall);

		// goods_management 테이블에 상품 등록
		String goodsRefurbCode = commonMapper.getNewCode("goods_refurb_code", "goods_management");
		goods.setGoodsRefurbCode(goodsRefurbCode);
		goods.setMemberId(storeGoodsLarge.getMemberId());
		goods.setSellerStoreNum(storeGoodsLarge.getSellerStoreNum());
		goods.setGoodsLargeCode(storeGoodsLarge.getGoodsLargeCode());
		goods.setGoodsSmallCode(storeGoodsSmall.getGoodsSmallCode());
		
		result += goodsMapper.addGoods(goods);
		
		List<FileDto> fileList = fileUtil.parseFileInfo(fileImage, fileRealPath);
		
		fileMapper.addFiles(fileList);
		
		List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
		
		Map<String, String> paramMap = null;
		
		for(FileDto fileDto : fileList) {
			paramMap = new HashMap<String,String>();
			paramMap.put("referenceCode", goodsRefurbCode);
			paramMap.put("fileIdx", fileDto.getFileIdx());
			paramList.add(paramMap);
		}
		
		fileMapper.addFilesContol(paramList);
		
		return result;
	}
	
	/**
	 * 상품 코드별 상세 정보 조회
	 */
	public Goods getGoodsByCode(String goodsRefurbCode) {
		
		return goodsMapper.getGoodsByCode(goodsRefurbCode);
	}
	
	
	/**
	 * 상품 상세 정보 수정
	 */
	public int modifyGoods(Goods goods) {
		return goodsMapper.modifyGoods(goods);
		
	}
	
	
	/**
	 * 상품 목록 조회
	 */
	public List<Goods> getGoodsList(Map<String, Object> paramMap) {
		List<Goods> goodsList = goodsMapper.getGoodsList(paramMap);
		return goodsList;
	}
	
	
	/**
	 * 전체 상품 카테고리 목록 조회
	 * @param searchValue 
	 * @param searchKey 
	 */
	public List<GoodsSmall> getGoodsCateList(String searchKey, String searchValue) {
		List<GoodsSmall> goodsCateList = goodsMapper.getGoodsCateList(searchKey, searchValue);
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
