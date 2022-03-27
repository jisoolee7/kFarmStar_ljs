package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delivery")
public class DliveryController {

	/************************************************************
	 * 배송 회사 목록 조회 폼
	 ************************************************************/
	@GetMapping("/deliveryCompanyList")
	public String getCompanyList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 정보 조회");
		model.addAttribute("titleName", "회사 정보 조회");
		
		return "delivery/deliveryCompanyList";
	}
	
	/************************************************************
	 * 배송 회사 정보 조회 폼
	 ************************************************************/
	@GetMapping("/deliveryCompany")
	public String getDeliveryCompany(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 정보 조회");
		model.addAttribute("titleName", "회사 정보 조회");
		
		return "delivery/deliveryCompany";
	}
	
	/************************************************************
	 * 배송 회사 사원 조회 폼
	 ************************************************************/
	@GetMapping("/companyEmployee")
	public String getCompanyEmployee(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회사 사원 정보 조회");
		model.addAttribute("titleName", "회사 사원 정보 조회");
		
		return "delivery/companyEmployee";
	}
	
	/************************************************************
	 * 배송 운송장 정보 조회 폼
	 ************************************************************/
	@GetMapping("/deliveryList")
	public String getDeliveryList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 운송장 정보 조회");
		model.addAttribute("titleName", "배송 운송장 정보 조회");
		
		return "delivery/deliveryList";
	}
	
	/************************************************************
	 * 배송 집하장 내역 조회 폼
	 ************************************************************/
	@GetMapping("/warehouseList")
	public String getWarehouseList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 집하장 내역 조회");
		model.addAttribute("titleName", "배송 집하장 내역 조회");
		
		return "delivery/warehouseList";
	}
	
	/************************************************************
	 * 배송 회사 등록 폼
	 ************************************************************/
	@GetMapping("/deliveryCompanyInfo")
	public String deliveryCompanyInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 회사 등록");
		model.addAttribute("titleName", "배송 회사 등록");
		
		return "delivery/deliveryCompanyInfo";
	}
	
	/************************************************************
	 * 배송 등록 폼
	 ************************************************************/
	@GetMapping("/deliveryInfo")
	public String deliveryInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 등록");
		model.addAttribute("titleName", "배송 등록");
		
		return "delivery/deliveryInfo";
	}
	
	/************************************************************
	 * 배송 집하장 내역 등록 폼
	 ************************************************************/
	@GetMapping("/warehouseListInfo")
	public String warehouseListInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 집하장 내역 등록");
		model.addAttribute("titleName", "배송 집하장 내역 등록");
		
		return "delivery/warehouseListInfo";
	}
	
	/************************************************************
	 * 배송 회사 정보 수정 폼
	 ************************************************************/
	@GetMapping("/modifyDeliveryCompany")
	public String modifyDeliveryCompany(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 회사 정보 수정");
		model.addAttribute("titleName", "배송 회사 정보 수정");
		
		return "delivery/modifyDeliveryCompany";
	}
	
	/************************************************************
	 * 배송 회사 사원 정보 수정 폼
	 ************************************************************/
	@GetMapping("/modifyCompanyWarehouse")
	public String modifyCompanyWarehouse(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 회사 사원 정보 수정");
		model.addAttribute("titleName", "배송 회사 사원 정보 수정");
		
		return "delivery/modifyCompanyWarehouse";
	}
	
	/************************************************************
	 * 배송 운송장 정보 수정 폼
	 ************************************************************/
	@GetMapping("/modifyDeliveryList")
	public String modifyDeliveryList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 배송 운송장 정보 수정");
		model.addAttribute("titleName", "배송 운송장 정보 수정");
		
		return "delivery/modifyDeliveryList";
	}
	
	/************************************************************
	 * 삭제 기능
	 ************************************************************/
	
}
