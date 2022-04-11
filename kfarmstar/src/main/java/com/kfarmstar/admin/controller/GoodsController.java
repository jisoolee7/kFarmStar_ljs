package com.kfarmstar.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kfarmstar.admin.mapper.GoodsMapper;
import com.kfarmstar.admin.service.GoodsService;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.dto.GoodsLarge;
import com.kfarmstar.dto.GoodsSmall;
import com.kfarmstar.dto.StoreGoodsLarge;
import com.kfarmstar.dto.StoreGoodsSmall;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private GoodsService goodsService;
	private GoodsMapper goodsMapper;
	
	
	public GoodsController(GoodsService goodsService, GoodsMapper goodsMapper) {
		this.goodsService = goodsService;
		this.goodsMapper = goodsMapper;
	}
	

	/**
	 * 대분류 코드에 해당하는 소분류 카테고리 목록 불러오기
	 * 카테고리 ajax
	 */
	@PostMapping("/getSmallCateList")
	@ResponseBody
	public List<GoodsSmall> getSmallCateList(@RequestParam(value = "goodsLargeCate") String goodsLargeCate) {
		
		return goodsMapper.getSmallCateList(goodsLargeCate);
	}
	
	
	/**
	 * 상품 등록 화면
	 */
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		log.info("상품 등록 화면");
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		model.addAttribute("title", "FoodRefurb : 상품 등록");
		model.addAttribute("titleName", "상품 등록");
		model.addAttribute("largeCateList", largeCateList);
		log.info("상품 대분류 카테고리 : {}",largeCateList);
		
		return "goods/addGoods";
	}

	/**
	 * 상품 등록 처리
	 */
	@PostMapping("/addGoods")
	public String addGoods(HttpSession session
						 , Goods goods
						 , StoreGoodsLarge storeGoodsLarge
						 , StoreGoodsSmall storeGoodsSmall
						 , @RequestParam MultipartFile[] fileImage
						 , HttpServletRequest request) {
		log.info("상품 등록 처리");
		String sessionId = (String) session.getAttribute("SID");
		
		String serverName = request.getServerName();
		String fileRealPath = "";
		if("localhost".equals(serverName)) {				
			fileRealPath = System.getProperty("user.dir") + "/src/main/resources/static/";
			//fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}else {
			fileRealPath = request.getSession().getServletContext().getRealPath("/WEB-INF/classes/static/");
		}
		
		goodsService.addGoods(sessionId, goods, storeGoodsLarge, storeGoodsSmall, fileImage, fileRealPath);
		
		return "redirect:/goods/goodsList";
	}
	
	
	@GetMapping("/addLargeCate")
	public String addLargeCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 대분류 카테고리 등록");
		model.addAttribute("titleName", "상품 대분류 카테고리 등록");
		
		return "goods/addLargeCate";
	}
	
	@PostMapping("/addLargeCate")
	public String addLargeCate(GoodsLarge goodsLarge) {
		
		goodsService.addLargeCate(goodsLarge);
		log.info("상품 대분류 카테고리 등록 폼 입력값: {}", goodsLarge); //받은 내용이 여기{}에 담긴다.
		
		return "redirect:/goods/goodsCateList";
	}
	
	
	
	@GetMapping("/addSmallCate")
	public String addSmallCate(Model model) {
		// 대분류 카테고리 리스트
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();
		model.addAttribute("title", "FoodRefurb : 상품 소분류 카테고리 등록");
		model.addAttribute("titleName", "상품 소분류 카테고리 등록");
		model.addAttribute("largeCateList", largeCateList);
		
		return "goods/addSmallCate";
	}
	
	@PostMapping("/addSmallCate")
	public String addSmallCate(GoodsSmall goodsSmall) {
		
		goodsService.addSmallCate(goodsSmall);
		log.info("상품 소분류 카테고리 등록 폼 입력값: {}", goodsSmall);
		
		return "redirect:/goods/goodsCateList"; 
	}
	
	
	/**
	 * 상품 카테고리 목록
	 */
	@GetMapping("/goodsCateList")
	public String getGoodsCateList(Model model
								, @RequestParam(value="searchKey", required = false) String searchKey
								, @RequestParam(value="searchValue", required = false) String searchValue) {
		log.info("상품 카테고리 목록 요청");
		log.info("searchValue:{}", searchValue);
		
		if(searchKey != null) {
			if("goodsLargeCate".equals(searchKey)) {
				searchKey = "l.goods_large_cate";
			}else if("goodsSmallCate".equals(searchKey)) {
				searchKey = "goods_small_cate";
			}else if("goodsLargeName".equals(searchKey)) {
				searchKey = "goods_large_name";
			}else if("goodsSmallName".equals(searchKey)) {
				searchKey = "goods_small_name";
			}
		}
		
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 목록");
		model.addAttribute("titleName", "상품 카테고리 목록");
		
		List<GoodsSmall> goodsCateList = goodsService.getGoodsCateList(searchKey, searchValue);
		model.addAttribute("goodsCateList", goodsCateList);
		log.info("상품 카테고리 목록 : {}", goodsCateList);
		
		return "goods/goodsCateList";
	}
	
	/**
	 * 상품 상세 화면 
	 */
	@GetMapping("/goodsDetail")
	public String getDetailGoodsInfo(Model model
									,@RequestParam(name="goodsRefurbCode", required = false) String goodsRefurbCode) {
		
		Goods goods = goodsService.getGoodsByCode(goodsRefurbCode);			//각 상품별 정보
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		log.info("상품별 상세정보");
		log.info("상품 폼 쿼리스트링 goods : {}", goods);
		
		List<GoodsSmall> goodsSmallList = goodsMapper.getSmallCateList(goods.getGoodsLargeCate());
		model.addAttribute("title", "FoodRefurb : 상품 정보");
		model.addAttribute("titleName", "상품 상세 정보");
		model.addAttribute("goods", goods);
		model.addAttribute("largeCateList", largeCateList);
		model.addAttribute("goodsSmallList", goodsSmallList);
		
		return "goods/goodsDetail";
	}
	
	
	/**
	 * 상품 수정 처리 
	 */
	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods) {
		
		log.info("상품 정보 수정 폼 입력값: {}", goods); 
		goodsService.modifyGoods(goods);
		return "redirect:/goods/goodsList"; 
		
	}
	
	/**
	 * 상품 목록 화면 및 검색 화면
	 * 
	 */
	@GetMapping("/goodsList")
	public String getGoodsList(Model model
							, HttpSession session
							, @RequestParam(value="searchKey", required = false) String searchKey
							, @RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("상품 목록 요청");
		log.info("searchValue:{}", searchValue);
		log.info("searchKey:{}", searchKey);
		String sessionId = (String) session.getAttribute("SID");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		Map<String, Object> paramMap = new HashMap<String , Object>();
		
		if(sessionId != null && sessionLevel.equals("판매자")) {
			paramMap.put("memberId", sessionId);
		}
		
		if(searchKey != null) {
			if("memberId".equals(searchKey)) {
				searchKey = "m.member_id";						// member_id 컬럼이 여러개이기 때문에 어느 테이블에서 검색할 것인지 확실히 지정해주어야한다.
			}else if("goodsRefurbName".equals(searchKey)) {
				searchKey = "goods_refurb_name";
			}else if("goodsLargeName".equals(searchKey)) {
				searchKey = "goods_large_name";
			}else if("goodsSmallName".equals(searchKey)) {
				searchKey = "goods_small_name";
			}
		}
		
		paramMap.put("searchKey", searchKey);
		paramMap.put("searchValue", searchValue);
		
		List<Goods> goodsList = goodsService.getGoodsList(paramMap);
		
		paramMap = null;
		
		model.addAttribute("title", "FoodRefurb : 상품 목록");
		model.addAttribute("titleName", "상품 목록");
		model.addAttribute("goodsList", goodsList);
		
		return "goods/goodsList";
	}
	
	
	
	/**
	 * 상품 카테고리 수정화면 
	 */
	@GetMapping("/modifyGoodsCate")
	public String modifyGoodsCate(Model model
								,@RequestParam(name="goodsSmallCate", required = false) String goodsSmallCate) {
		
		log.info("상품소분류 카테고리 수정");
		log.info("상품소분류 카테고리 폼 쿼리스트링 goodsSmallCate : {}", goodsSmallCate);
		GoodsSmall goodsSmall = goodsService.getSmallCateInfoByCode(goodsSmallCate);
		List<GoodsLarge> largeCateList = goodsService.getLargeCateList();	// 대분류 카테고리 리스트
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 수정");
		model.addAttribute("titleName", "상품 카테고리 수정");
		model.addAttribute("goodsSmall", goodsSmall);
		model.addAttribute("largeCateList", largeCateList);
		
		log.info("goodsSmall 리스트 : {}", goodsSmall);
		log.info("대분류 리스트 : {}", largeCateList);
		
		return "goods/modifyGoodsCate";
	}
	
	/**
	 * 상품 카테고리 수정처리 
	 */
	@PostMapping("/modifyGoodsCate")
	public String modifyGoodsCate(GoodsSmall goodsSmall) {
		
		log.info("카테고리 수정화면에서 입력받은 값: {}", goodsSmall);
		goodsService.modifyGoodsCate(goodsSmall);
		return "redirect:/goods/goodsCateList";
	}
	
	
	@GetMapping("/removeGoods")
	public String removeGoods(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 삭제");
		model.addAttribute("titleName", "상품 삭제");
		
		return "goods/removeGoods";
	}
	
	@GetMapping("/removeGoodsCate")
	public String removeGoodsCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 삭제");
		model.addAttribute("titleName", "상품 카테고리 삭제");
		
		return "goods/removeGoodsCate";
	}

}
