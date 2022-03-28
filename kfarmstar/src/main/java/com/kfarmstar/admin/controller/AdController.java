package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advertisement")
public class AdController {
	@GetMapping("/adApplyDetail")
	public String getDetailAdApplyInfo(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 상세 정보");
		model.addAttribute("titleName", "광고 상세 정보");
		
		return "advertisement/adApplyDetail";
	}

	
	@GetMapping("/adApplyList")
	public String getAdApplyList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 신청 목록");
		model.addAttribute("titleName", "광고 신청 목록");
		
		return "advertisement/adApplyList";
	}

	
	
	@GetMapping("/addAdApply")
	public String addApplyAd(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 신청");
		model.addAttribute("titleName", "광고 신청");
		
		return "advertisement/addAdApply";
	}
	
	
	
	
	@GetMapping("/addAdPrice")
	public String addAdPrice(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 단가 등록");
		model.addAttribute("titleName", "광고 단가 등록");
		
		return "advertisement/addAdPrice";
	}
	
	@GetMapping("/addAdRefund")
	public String addAdRefund(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 환불 신청");
		model.addAttribute("titleName", "광고 환불 신청");
		
		return "advertisement/addAdRefund";
	}

	@GetMapping("/addAdvertising")
	public String addAdvertising(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 등록");
		model.addAttribute("titleName", "광고 등록");
		
		return "advertisement/addAdvertising";
	}
	
	
	
	@GetMapping("/adPaymentList")
	public String getAdPaymentList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 결제 목록");
		model.addAttribute("titleName", "광고 결제 목록");
		
		return "advertisement/adPaymentList";
	}
	
	@GetMapping("/adPriceList")
	public String getAdPriceList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 단가 목록");
		model.addAttribute("titleName", "광고 단가 목록");
		
		return "advertisement/adPriceList";
	}
	
	
	@GetMapping("/adRefundList")
	public String getAdRefundList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 환불 목록");
		model.addAttribute("titleName", "광고 환불 목록");
		
		return "advertisement/adRefundList";
	}
	
	@GetMapping("/advertisingList")
	public String getAdvertisingList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 목록");
		model.addAttribute("titleName", "광고 목록");
		
		return "advertisement/advertisingList";
	}
	
	
	@GetMapping("/modifyAdApply")
	public String modifyAdApply(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 신청 수정");
		model.addAttribute("titleName", "광고 신청 수정");
		
		return "advertisement/modifyAdApply";
	}
	
	
	@GetMapping("/modifyAdPrice")
	public String modifyAdPrice(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 단가 수정");
		model.addAttribute("titleName", "광고 단가 수정");
		
		return "advertisement/modifyAdPrice";
	}
	
	
	
	@GetMapping("/modifyAdRefund")
	public String modifyAdRefund(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 환불 수정");
		model.addAttribute("titleName", "광고 환불 수정");
		
		return "advertisement/modifyAdRefund";
	}
	
	
	@GetMapping("/removeAdApply")
	public String removeAdApply(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 신청 취소");
		model.addAttribute("titleName", "광고 신청 취소");
		
		return "advertisement/removeAdApply";
	}
	
	
	@GetMapping("/removeAdPrice")
	public String removeAdPrice(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 단가 삭제");
		model.addAttribute("titleName", "광고 단가 삭제");
		
		return "advertisement/removeAdPrice";
	}
	
	
	@GetMapping("/removeAdRefund")
	public String removeAdRefund(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 환불 취소");
		model.addAttribute("titleName", "광고 환불 취소");
		
		return "advertisement/removeAdRefund";
	}
	
	
	
	
}
