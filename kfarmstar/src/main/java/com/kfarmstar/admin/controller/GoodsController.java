package com.kfarmstar.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.admin.service.GoodsService;
import com.kfarmstar.dto.GoodsCate;


@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	

	
	
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 등록");
		model.addAttribute("titleName", "상품 등록");
		
		return "goods/addGoods";
	}

	
	
	@GetMapping("/addLargeCate")
	public String addLargeCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 대분류 카테고리 등록");
		model.addAttribute("titleName", "상품 대분류 카테고리 등록");
		
		return "goods/addLargeCate";
	}
	
	@PostMapping("/addLargeCate")
	public String addLargeCate(GoodsCate goodsCate) {
		
		log.info("상품 대분류 카테고리 등록 폼 입력값: {}", goodsCate); //받은 내용이 여기{}에 담긴다.
		goodsService.addLargeCate(goodsCate);
		
		return "redirect:/goods/goodsCateList";
	}
	
	
	
	
	
	
	@GetMapping("/addSmallCate")
	public String addSmallCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 소분류 카테고리 등록");
		model.addAttribute("titleName", "상품 소분류 카테고리 등록");
		
		return "goods/addSmallCate";
	}
	
	
	@GetMapping("/goodsCateList")
	public String getGoodsCateList(Model model) {
		
		log.info("상품 카테고리 목록 요청");

		model.addAttribute("title", "FoodRefurb : 상품 카테고리 목록");
		model.addAttribute("titleName", "상품 카테고리 목록");
		
		List<GoodsCate> goodsCateList = goodsService.getGoodsCateList();
		model.addAttribute("goodsCateList", goodsCateList);
		
		return "goods/goodsCateList";
	}
	
	
	@GetMapping("/goodsDetail")
	public String getDetailGoodsInfo(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 정보");
		model.addAttribute("titleName", "상품 상세 정보");
		
		return "goods/goodsDetail";
	}
	
	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model
			, HttpSession session
			, @RequestParam(name="searchKey", required = false) String searchKey
			, @RequestParam(name="searchValue", required = false) String searchValue) {
		
		
		model.addAttribute("title", "FoodRefurb : 상품 목록");
		model.addAttribute("titleName", "상품 목록");
		
		return "goods/goodsList";
	}
	
	
	@GetMapping("/modifyGoods")
	public String modifyGoods(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 수정");
		model.addAttribute("titleName", "상품 수정");
		
		return "goods/modifyGoods";
	}
	
	
	@GetMapping("/modifyGoodsCate")
	public String modifyGoodsCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 수정");
		model.addAttribute("titleName", "상품 카테고리 수정");
		
		return "goods/modifyGoodsCate";
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
