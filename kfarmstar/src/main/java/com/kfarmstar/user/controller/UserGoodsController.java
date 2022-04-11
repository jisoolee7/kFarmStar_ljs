package com.kfarmstar.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfarmstar.dto.FileDto;
import com.kfarmstar.dto.Goods;
import com.kfarmstar.user.service.UserGoodsService;

@Controller
@RequestMapping("/userGoods")
public class UserGoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserGoodsController.class);

	
	private UserGoodsService userGoodsService;
	
	public UserGoodsController(UserGoodsService userGoodsService) {
		this.userGoodsService = userGoodsService;
	}
	
	
	@GetMapping("/userGoodsDetail")
	public String getShopGoodsDetail(Model model
									,@RequestParam(name="goodsRefurbCode", required = false) String goodsRefurbCode) {
		log.info("상품별 상세정보");
		Goods goods = userGoodsService.getUserGoodsByCode(goodsRefurbCode);	//각 상품별 정보
		List<Goods> randomGoods = userGoodsService.getRandomGoods(goodsRefurbCode); // 특정 상품 제외 후 네 가지 상품 정보 랜덤 조회
		model.addAttribute("title", "Food Refurb : 개인 상품");	
		model.addAttribute("breadTitle", "Refurb Goods");
		model.addAttribute("breadSubTitle", "Goods Info");
		
		/*
		 * FileDto file = goods.getFileList().get(0);
		 * model.addAttribute("goodsFile",file);
		 */
		
		model.addAttribute("goods", goods);	
		model.addAttribute("randomGoods", randomGoods);	
		
		return "userGoods/userGoodsDetail";
	}

	
	
	
	@GetMapping("/userGoodsList")
	public String getUserGoodsList(Model model) {
		
		List<Goods> goodsList = userGoodsService.getUserGoodsList();
		model.addAttribute("title", "Food Refurb : 전체 상품");
		model.addAttribute("breadTitle", "Refurb Goods");
		model.addAttribute("breadSubTitle", "Goods List");
		
		model.addAttribute("goodsList", goodsList);
		
		return "userGoods/userGoodsList";
	}
}
