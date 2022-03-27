package com.kfarmstar.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	

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
	@GetMapping("/addSmallCate")
	public String addSmallCate(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 소분류 카테고리 등록");
		model.addAttribute("titleName", "상품 소분류 카테고리 등록");
		
		return "goods/addSmallCate";
	}
	
	@GetMapping("/goodsBannerAd")
	public String getGoodsAd(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 배너 광고");
		model.addAttribute("titleName", "상품 배너 광고");
		
		return "goods/goodsBannerAd";
	}
	
	@GetMapping("/goodsCateList")
	public String getGoodsCateList(Model model) {
		model.addAttribute("title", "FoodRefurb : 상품 카테고리 목록");
		model.addAttribute("titleName", "상품 카테고리 목록");
		
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
