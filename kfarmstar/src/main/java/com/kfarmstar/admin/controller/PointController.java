package com.kfarmstar.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PointController {

	@GetMapping("/pointUseSave")
	public String pointUseSave(Model model) {
		return "point/pointUseSave";
	}
	
	@GetMapping("/pointUseSaveModify")
	public String pointUseSaveModify(Model model) {
		return "point/pointUseSaveModify";
	}
	
	@GetMapping("/pointUseSaveRemove")
	public String pointUseSaveRemove(Model model) {
		return "point/pointUseSaveRemove";
	}
	
	@GetMapping("/pointUseSaveDetail")
	public String pointUseSaveDetail(Model model) {
		return "point/pointUseSaveDetail";
	}
	
	@GetMapping("/pointGiveStandard")
	public String pointGiveStandard(Model model) {
		return "point/pointGiveStandard";
	}
	
	@GetMapping("/pointGiveStandardModify")
	public String pointGiveStandardModify(Model model) {
		return "point/pointGiveStandardModify";
	}
	
	@GetMapping("/pointGiveStandardRemove")
	public String pointGiveStandardRemove(Model model) {
		return "point/pointGiveStandardRemove";
	}
}
