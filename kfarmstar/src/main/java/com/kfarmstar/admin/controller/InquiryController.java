package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	/************************************************************
	 * 카테고리 목록 조회 폼
	 ************************************************************/
	@GetMapping("/categoryList")
	public String getCategoryList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 카테고리 목록 조회");
		model.addAttribute("titleName", "카테고리 목록 조회");
		
		return "inquiry/categoryList";
	}
	
	/************************************************************
	 * 문의 내역 조회 폼
	 ************************************************************/
	@GetMapping("/inquiryList")
	public String getInquiryList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 문의 내역 조회");
		model.addAttribute("titleName", "문의 내역 조회");
		
		return "inquiry/inquiryList";
	}
	
	/************************************************************
	 * 문의/답변 내역 조회 폼
	 ************************************************************/
	@GetMapping("/inquiryHistorysList")
	public String getInquiryHistorysList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 문의/답변 내역 조회");
		model.addAttribute("titleName", "문의/답변 내역 조회");
		
		return "inquiry/inquiryHistorysList";
	}
	
	/************************************************************
	 * 카테고리 등록 폼
	 ************************************************************/
	@GetMapping("/categoryInfo")
	public String categoryInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 카테고리 등록");
		model.addAttribute("titleName", "카테고리 등록");
		
		return "inquiry/categoryInfo";
	}
	
	/************************************************************
	 * 문의 등록 폼
	 ************************************************************/
	@GetMapping("/inquiryInfo")
	public String inquiryInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 문의 등록");
		model.addAttribute("titleName", "문의 등록");
		
		return "inquiry/inquiryInfo";
	}
	
	/************************************************************
	 * 문의 답변 등록 폼
	 ************************************************************/
	@GetMapping("/inquiryAnswerInfo")
	public String inquiryAnswerInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 문의 답변 등록");
		model.addAttribute("titleName", "문의 답변 등록");
		
		return "inquiry/inquiryAnswerInfo";
	}
	
	/************************************************************
	 * 카테고리 수정 폼
	 ************************************************************/
	@GetMapping("/modifyCategory")
	public String modifyCategory(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 카테고리 수정");
		model.addAttribute("titleName", "카테고리 수정");
		
		return "inquiry/modifyCategory";
	}
	
	/************************************************************
	 * 문의 답변 내역 수정 폼
	 ************************************************************/
	@GetMapping("/modifyinquiryAnswer")
	public String modifyinquiryAnswer(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 문의 답변 내역 수정");
		model.addAttribute("titleName", "문의 답변 내역 수정");
		
		return "inquiry/modifyinquiryAnswer";
	}
	
	
}
