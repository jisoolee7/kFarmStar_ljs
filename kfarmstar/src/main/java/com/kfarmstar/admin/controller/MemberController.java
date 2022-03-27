package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 등록");
		model.addAttribute("titleName", "회원 등록");
		
		return "member/addMember";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 목록");
		model.addAttribute("titleName", "회원 관리");
		
		return "member/memberList";
	}
	
	
	@GetMapping("/modifyMember")
	public String modifyMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 수정");
		model.addAttribute("titleName", "회원 정보 수정");
		
		return "member/modifyMember";
	}
	
	@GetMapping("/removeMember")
	public String removeMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 삭제");
		model.addAttribute("titleName", "회원 삭제");
		
		return "member/removeMember";
	}
	
	@GetMapping("/detailMember")
	public String getDetailMemberInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 프로필");
		model.addAttribute("titleName", "회원 프로필");
		
		return "member/detailMember";
	}
	
	@GetMapping("/loginList")
	public String loginMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 로그인");
		model.addAttribute("titleName", "회원 로그인 내역");
		
		return "member/loginList";
	}
	
	@GetMapping("/logoutList")
	public String logoutMember(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 로그아웃");
		model.addAttribute("titleName", "회원 로그아웃 내역");
		
		return "member/logoutList";
	}
	
	@GetMapping("/sellerGrade")
	public String sellerGrade(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 회원 등급");
		model.addAttribute("titleName", "회원 등급 혜택 및 기준");
		
		return "member/sellerGrade";
	}
	
	@GetMapping("/modifySellerGradeCriteria")
	public String modifySellerGrade(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 기준 수정");
		model.addAttribute("titleName", "등급 기준 수정");
		
		return "member/modifySellerGradeCriteria";
	}
	
	@GetMapping("/modifySellerGradeBenefit")
	public String modifySellerGradeBenefit(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 혜택 수정");
		model.addAttribute("titleName", "등급 혜택 수정");
		
		return "member/modifySellerGradeBenefit";
	}
	
	@GetMapping("/removeSellerGradeCriteria")
	public String removeSellerGraderemoveSellerGradeCriteria(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 기준 삭제");
		model.addAttribute("titleName", "등급 기준 삭제");
		
		return "member/removeSellerGradeCriteria";
	}
	
	@GetMapping("/removeSellerGradeBenefit")
	public String removeSellerGradeBenefit(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 등급 혜택 삭제");
		model.addAttribute("titleName", "등급 혜택 삭제");
		
		return "member/removeSellerGradeBenefit";
	}
	
	@GetMapping("/sellerStoreInfo")
	public String sellerStoreInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사업장 관리");
		model.addAttribute("titleName", "판매자 사업장 관리");
		
		return "member/sellerStoreInfo";
	}
	
	@GetMapping("/modifySellerStoreInfo")
	public String modifySellerStoreInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사업장 수정");
		model.addAttribute("titleName", "사업장 정보 수정");
		
		return "member/modifySellerStoreInfo";
	}
	
	@GetMapping("/removeSellerStoreInfo")
	public String removeSellerStoreInfo(Model model) {
		
		model.addAttribute("title", "FoodRefurb : 사업장 삭제");
		model.addAttribute("titleName", "사업장 정보 삭제");
		
		return "member/removeSellerStoreInfo";
	}
	
	@GetMapping("/detailSellerStoreInfo")
	public String detailSellerStoreInfo(Model model) {
		return "member/detailSellerStoreInfo";
	}
}
