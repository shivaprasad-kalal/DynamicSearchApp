package com.shiva.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shiva.commons.InsuranceSearchCriteria;
import com.shiva.entity.Insurance;
import com.shiva.service.InsuranceService;

@Controller
public class InsuranceController {
	private InsuranceService service;

	public InsuranceController(InsuranceService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String showHome() {

		return "index";
	}

	@PostMapping(value = "/plans")
	public String showPolicies(Model model, @ModelAttribute InsuranceSearchCriteria sc) {

		List<Insurance> policyHolders = service.search(sc);
		model.addAttribute("holders", policyHolders);
		model.addAttribute("planName", sc.getPlanName());
		model.addAttribute("planStatus", sc.getPlanStatus());
		return "index";
	}

	@GetMapping("/pdf_report")
	public String exportPdfReport(Model model, InsuranceSearchCriteria sc) {
		List<Insurance> policyHolders = exportView(sc);
		model.addAttribute("holders", policyHolders);
		return "pdfView";
	}

	@GetMapping("/excel_report")
	public String exportExcelReport(Model model, InsuranceSearchCriteria sc) {
		List<Insurance> policyHolders = exportView(sc);
		model.addAttribute("holders", policyHolders);
		return "excelView";
	}

	// utility method to export pdf and excel
	public List<Insurance> exportView(InsuranceSearchCriteria sc) {
		List<Insurance> policyHolders = service.search(sc);
		return policyHolders;
	}

}
