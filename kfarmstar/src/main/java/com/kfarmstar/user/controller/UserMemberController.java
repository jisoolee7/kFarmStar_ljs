package com.kfarmstar.user.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kfarmstar.dto.Member;
import com.kfarmstar.dto.SellerStore;
import com.kfarmstar.user.mapper.UserMemberMapper;
import com.kfarmstar.user.service.UserMemberService;

@Controller
@RequestMapping("/userMember")
public class UserMemberController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserMemberController.class);

	private UserMemberService userMemberService;
	private UserMemberMapper userMemberMapper;
	
	public UserMemberController(UserMemberService userMemberService, UserMemberMapper userMemberMapper) {
		this.userMemberService = userMemberService;
		this.userMemberMapper = userMemberMapper;
	}
	
	@GetMapping("/beforeAddMember")
	public String beforeAddMember(Model model) {
			
			model.addAttribute("title", "Food Refurb : 이용약관");
			
			return "userMember/beforeAddMember";
		}
	
	
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean isIdCheck(@RequestParam(value = "memberId") String memberId) {
		boolean idCheck = false;
		log.info("아이디중복체크 클릭시 요청받은 memberId의 값: {}", memberId);
		
		boolean result = userMemberMapper.isIdCheck(memberId);
		if(result) idCheck = true;
		
		log.info("아이디중복체크 여부 : {}", result);
		return idCheck;
	}
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		
		model.addAttribute("title", "Food Refurb : 구매자 회원가입");
		
		return "userMember/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		userMemberService.addMember(member);
		
		log.info("회원가입:{}", member);
		
		return "redirect:/userMain";
		
	}
	
	@GetMapping("/addSellerMember")
	public String addSellerMember(Model model) {
		
		model.addAttribute("title", "Food Refurb : 판매자 회원가입");
		
		return "userMember/addSellerMember";
	}
	
	@PostMapping("/addSellerMember")
	public String addSellerMember(SellerStore sellerStore, Member member) {
		
		userMemberService.addSellerStoreInfo(sellerStore, member);
		
		log.info("판매자 회원 가입:{}");
		log.info("사업장 정보 기입:{}", sellerStore);
		
		return "redirect:/userMain";
	}
	
	
	@GetMapping("/login")
	public String login(Model model
						,@RequestParam(value="result", required = false) String result) {
		
		model.addAttribute("title", "Foode Refurb : 로그인");
		
		if(result != null) model.addAttribute("result", result);
		
		return "userMember/login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session, RedirectAttributes reAttr) {
		
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();
		
		log.info("{}",member);
		
		Member checkMember = userMemberMapper.getMemberInfoById(memberId);
		
		if(checkMember != null && checkMember.getMemberPw() != null && memberPw.equals(checkMember.getMemberPw())) {
			String sessionName = checkMember.getMemberName();
			String sessionLevel = checkMember.getMemberLevel();
			
			
			session.setAttribute("SID", memberId);
			session.setAttribute("SNAME", sessionName);
			session.setAttribute("SLEVEL", sessionLevel);
			
			
			log.info("로그인성공");
			
			return "redirect:/userMain";
		}
		
		reAttr.addAttribute("result", "아이디 또는 비밀번호를 잘못 입력하셨습니다. 다시 확인해주세요.");
		
		return "redirect:/userMember/login";
		
	}
	@GetMapping("/logout")
	public String logout(Member member, HttpSession session, RedirectAttributes reAttr) {
		
		session.invalidate();
		
		return "redirect:/userMember/login";
	}
	
}
