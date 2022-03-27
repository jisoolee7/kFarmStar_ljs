package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@GetMapping("/basketPurchaseList")
	public String basketPurchaseList(Model model) {
		return "payment/basketPurchaseList";
	}
	
	@GetMapping("/beforePurchaserInfo")
	public String beforePurchaserInfo(Model model) {
		return "payment/beforePurchaserInfo";
	}
	
	@GetMapping("/afterPaymentInfo")
	public String afterPaymentInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 결제관리");
		model.addAttribute("titleName", "결제 내역 관리");
		
		return "payment/afterPaymentInfo";
	}
	
	@GetMapping("/afterPaymentDetail")
	public String afterPaymentDetail(Model model) {
		return "payment/afterPaymentDetail";
	}
	
	@GetMapping("/afterPaymentModify")
	public String afterPaymentModify(Model model) {
		return "payment/afterPaymentModify";
	}
	
	@GetMapping("/afterPaymentRemove")
	public String afterPaymentRemove(Model model) {
		return "payment/afterPaymentRemove";
	}
	
	@GetMapping("/afterPaymentStatistics")
	public String afterPaymentStatistics(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 결제통계");
		model.addAttribute("titleName", "결제 내역 통계");
		
		return "payment/afterPaymentStatistics";
	}
	
	@GetMapping("/goodsOrderCancel")
	public String goodsOrderCancel(Model model) {
		return "payment/goodsOrderCancel";
	}
	
	@GetMapping("/goodsOrderCancelDetail")
	public String goodsOrderCancelDetail(Model model) {
		return "payment/goodsOrderCancelDetail";
	}
	
	@GetMapping("/goodsOrderCancelModify")
	public String goodsOrderCancelModify(Model model) {
		return "payment/goodsOrderCancelModify";
	}
	
	@GetMapping("/goodsOrderCancelRemove")
	public String goodsOrderCancelRemove(Model model) {
		return "payment/goodsOrderCancelRemove";
	}
	
	@GetMapping("/goodsOrderStatistics")
	public String goodsOrderStatistics(Model model) {
		return "payment/goodsOrderStatistics";
	}
	
	@GetMapping("/goodsExchange")
	public String goodsExchange(Model model) {
		return "payment/goodsExchange";
	}
	
	@GetMapping("/goodsExchangeModify")
	public String goodsExchangeModify(Model model) {
		return "payment/goodsExchangeModify";
	}
	
	@GetMapping("/goodsExchangeRemove")
	public String goodsExchangeRemove(Model model) {
		return "payment/goodsExchangeRemove";
	}
	
	@GetMapping("/goodsExchangeDetail")
	public String goodsExchangeDetail(Model model) {
		return "payment/goodsExchangeDetail";
	}
	
	@GetMapping("/goodsExchangeStatistics")
	public String goodsExchangeStatistics(Model model) {
		return "payment/goodsExchangeStatistics";
	}
	
	@GetMapping("/goodsRefund")
	public String goodsRefund(Model model) {
		return "payment/goodsRefund";
	}
	
	@GetMapping("/goodsRefundModify")
	public String goodsRefundModify(Model model) {
		return "payment/goodsRefundModify";
	}
	
	@GetMapping("/goodsRefundRemove")
	public String goodsRefundRemove(Model model) {
		return "payment/goodsRefundRemove";
	}
	
	@GetMapping("/goodsRefundDetail")
	public String goodsRefundDetail(Model model) {
		return "payment/goodsRefundDetail";
	}
	
	@GetMapping("/goodsRefundStatistics")
	public String goodsRefundStatistics(Model model) {
		return "payment/goodsRefundStatistics";
	}
}
