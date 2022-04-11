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

import com.kfarmstar.admin.service.AdService;
import com.kfarmstar.dto.AdApply;
import com.kfarmstar.dto.AdPrice;


@Controller
@RequestMapping("/advertisement")
public class AdController {
	
	private static final Logger log = LoggerFactory.getLogger(AdController.class);
	
	
	private AdService adService;
	
	public AdController(AdService adService) {
		this.adService = adService;
	}
	
	/**
	 * 광고 신청 후 상세 화면
	 * @param model
	 * @param adApplyCode
	 */
	@GetMapping("/adApplyDetail")
	public String getDetailAdApplyInfo(Model model
									, HttpSession session
									, @RequestParam(name="adApplyCode", required = false) String adApplyCode) {
		
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		AdApply adApply = adService.getAdApplyByCode(adApplyCode);
		List<AdPrice> adPriceList = adService.getAdPriceList();
		log.info("광고별 상세정보");
		log.info("광고 폼 쿼리스트링 adApplyCode : {}", adApplyCode);
		model.addAttribute("title", "FoodRefurb : 광고 상세 정보");
		model.addAttribute("titleName", "광고 상세 정보");
		model.addAttribute("adApply", adApply);
		model.addAttribute("adPriceList", adPriceList);
		model.addAttribute("sessionLevel", sessionLevel);
		
		return "advertisement/adApplyDetail";
	}

	
	/**
	 * 광고신청 상세화면(adApplyDetail)에서  수정처리 (수정 -> 저장 버튼 클릭시)
	 * 
	 */
	@PostMapping("/modifyAdApply")
	public String modifyAdApply(AdApply adApply) {
		log.info("광고 상세정보 수정");
		adService.modifyAdApply(adApply);
		
		return "redirect:/advertisement/adApplyList";
	}
	
	
	/**
	 * 광고 신청 목록 화면
	 */
	@GetMapping("/adApplyList")
	public String getAdApplyList(Model model
								, @RequestParam(name="adApplyCode", required = false) String adApplyCode) {
		log.info("광고 신청 목록 화면");
		
		List<AdApply> adApplyList = adService.getAdApplyList();
		AdApply adApply = adService.getAdApplyByCode(adApplyCode);
		model.addAttribute("title", "FoodRefurb : 광고 신청 목록");
		model.addAttribute("titleName", "광고 신청 목록");
		model.addAttribute("adApplyList", adApplyList);
		model.addAttribute("adApply", adApply);
		
		return "advertisement/adApplyList";
	}

	
	/**
	 * 광고 신청 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/addAdApply")
	public String addAdApply(Model model) {
		
		List<AdPrice> adPriceList = adService.getAdPriceList();
		
		model.addAttribute("title", "FoodRefurb : 광고 신청");
		model.addAttribute("titleName", "광고 신청");
		model.addAttribute("adPriceList", adPriceList);
		
		return "advertisement/addAdApply";
	}
	
	
	/**
	 * 광고 승인 처리
	 * (관리자 : 신청 상세 화면을 보고 승인 버튼을 누르면 진행 상태가 결제전 으로 바뀐다)
	 * @param adApplyCode
	 */
	@GetMapping("/adApproveUpdate")
	public String adApproveUpdate(AdApply adApply, HttpSession session) {
		log.info("광고 승인 처리");
		String sessionId = (String) session.getAttribute("SID");
		adService.adApproveUpdate(adApply, sessionId);
		return "redirect:/advertisement/adApplyList";
	}
	
	
	/**
	 * 광고 거절 처리
	 * (관리자 : 신청 상세 화면을 보고 승인 버튼을 누르면 진행 상태가 결제전 으로 바뀐다)
	 * @param adApplyCode
	 */
	@GetMapping("/adApproveCancle")
	public String adApproveCancle(AdApply adApply, HttpSession session) {
		log.info("광고 거절 처리");
		String sessionId = (String) session.getAttribute("SID");
		adService.adApproveCancle(adApply, sessionId);
		return "redirect:/advertisement/adApplyList";
	}
	
	
	/**
	 * 광고 단가 등록 화면
	 * @param adPrice
	 */
	@GetMapping("/addAdPrice")
	public String addAdPrice(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 단가 등록");
		model.addAttribute("titleName", "광고 단가 등록");
		
		
		return "advertisement/addAdPrice";
	}
	
	
	/**
	 * 광고 단가 등록 처리
	 * @param adPrice
	 */
	@PostMapping("/addAdPrice")
	public String addAdPrice(AdPrice adPrice) {
		
		adService.addAdPrice(adPrice);
		log.info("광고 단가 등록 폼 입력값: {}", adPrice); //받은 내용이 여기{}에 담긴다.
		
		return "redirect:/advertisement/adPriceList";
	}
	

	@GetMapping("/addAdvertising")
	public String addAdvertising(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 등록");
		model.addAttribute("titleName", "광고 등록");
		
		return "advertisement/addAdvertising";
	}
	
	
	
	@GetMapping("/addAdPayment")
	public String addAdPayment(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 결제");
		model.addAttribute("titleName", "광고 결제");
		
		return "advertisement/addAdPayment";
	}
	
	
	@GetMapping("/adPaymentDetail")
	public String adPaymentDetail(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 결제 상세 정보");
		model.addAttribute("titleName", "광고 결제 상세 정보");
		
		return "advertisement/adPaymentDetail";
	}
	
	
	@GetMapping("/adPaymentList")
	public String getAdPaymentList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 결제 목록");
		model.addAttribute("titleName", "광고 결제 목록");
		
		return "advertisement/adPaymentList";
	}
	
	
	@GetMapping("/adPaymentOrderInfo")
	public String adPaymentOrderInfo(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 결제");
		model.addAttribute("titleName", "광고 결제");
		
		return "advertisement/adPaymentOrderInfo";
	}
	
	@GetMapping("/adPriceList")
	public String getAdPriceList(Model model) {
		
		log.info("광고 단가 목록 요청");
		model.addAttribute("title", "FoodRefurb : 광고 단가 목록");
		model.addAttribute("titleName", "광고 단가 목록");
		List<AdPrice> adPriceList = adService.getAdPriceList();
		model.addAttribute("adPriceList", adPriceList);
		
		log.info("광고 단가 목록 : {}", adPriceList);
		
		return "advertisement/adPriceList";
	}
	
	
	@GetMapping("/adRefundList")
	public String getAdRefundList(Model model) {
		model.addAttribute("title", "FoodRefurb : 광고 환불 목록");
		model.addAttribute("titleName", "광고 환불 목록");
		
		return "advertisement/adRefundList";
	}
	
	
	/**
	 * 결제완료, 광고중, 광고완료 상태인 광고 목록
	 * @param model
	 * @return
	 */
	@GetMapping("/advertisingList")
	public String getAdvertisingList(Model model
									, @RequestParam(name="adApplyCode", required = false) String adApplyCode) {
		List<AdApply> advertisingList = adService.getAdvertisingList();
		AdApply adApply = adService.getAdApplyByCode(adApplyCode);
		
		
		model.addAttribute("title", "FoodRefurb : 광고 목록");
		model.addAttribute("titleName", "광고 목록");
		model.addAttribute("advertisingList", advertisingList);
		model.addAttribute("adApply", adApply);
		
		return "advertisement/advertisingList";
	}
	
	
	
	/**
	 * 광고 단가 수정 화면 연결
	 * @param adPriceCode
	 * @return
	 */
	@GetMapping("/modifyAdPrice")
	public String modifyAdPrice(Model model
								,@RequestParam(name="adPriceCode", required = false) String adPriceCode) {
		
		log.info("광고 단가 수정 화면");
		log.info("상품 폼 쿼리스트링 adPriceCode : {}", adPriceCode);
		AdPrice adPrice = adService.getAdPriceInfoByCode(adPriceCode);
		model.addAttribute("title", "FoodRefurb : 광고 단가 수정");
		model.addAttribute("titleName", "광고 단가 수정");
		
		model.addAttribute("adPrice", adPrice);
		
		return "advertisement/modifyAdPrice";
	}
	
	
	/**
	 * 단가 수정 처리
	 * @param adPrice
	 */
	@PostMapping("/modifyAdPrice")
	public String modifyAdPrice(AdPrice adPrice) {
		adService.modifyAdPrice(adPrice);
		
		return "redirect:/advertisement/adPriceList";
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
