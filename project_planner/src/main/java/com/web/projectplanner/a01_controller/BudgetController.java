package com.web.projectplanner.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.projectplanner.a02_service.BudgetService;
import com.web.projectplanner.a02_service.ProjectService;
import com.web.projectplanner.a04_vo.Budget;

@Controller
public class BudgetController { //프로젝트 예산 관리 controller
	 @Autowired(required=false)
	 private BudgetService budgetservice; //예산 목록 service
	

	// http://localhost:7070/budget
	
	
	
	@GetMapping("/projects/{projectid}/budgetList")
	public String budgetList(@PathVariable("projectid") int projectid, Model model) {
	    // 서비스 메서드를 통해 해당 프로젝트의 예산 목록을 가져옵니다.
	    List<Budget> budgetList = budgetservice.getBudgetList(projectid);
	 
	    // 모델에 예산 목록을 추가합니다.
	    model.addAttribute("budgetList", budgetList);
	    
	    // 예산 목록을 보여줄 JSP 페이지를 반환합니다.
	    return "budget"; // JSP 파일명
	}
	
	@PostMapping("/projects/{projectid}/insertBudget")
	public String insertBudget(@ModelAttribute Budget budget, 
	                           @PathVariable("projectid") Long projectid, 
	                           Model model) {
	    // 프로젝트 ID를 Budget 객체에 설정
	    budget.setProjectid(projectid);

	   
	    // 예산 삽입
	    budgetservice.insertBudget(budget);
	    model.addAttribute("msg", "예산이 성공적으로 등록되었습니다.");
	    return "redirect:/projects/" + projectid + "/budgetList";
	}

    // 예산 수정 페이지로 이동 (모달 팝업으로 처리)
    @GetMapping("/edit/{budid}")
    public String editBudgetForm(@PathVariable("budid") Long budid, Model model) {
        Budget budget = budgetservice.getBudgetById(budid);
        model.addAttribute("budget", budget);
        return "budget_edit_modal"; // 예산 수정 모달 JSP 파일 이름을 반환합니다.
    }

    // 예산 수정 처리
    @PostMapping("/editBudget")
    public String updateBudget(@ModelAttribute Budget budget, Model model) {
        budgetservice.updateBudget(budget);
        model.addAttribute("msg", "예산이 성공적으로 수정되었습니다.");
        return "redirect:/budget/project/" + budget.getProjectid();
    }

    // 예산 삭제
    @PostMapping("/deleteBudget")
    public String deleteBudget(@RequestParam("budid") Long budid, @RequestParam("projectid") Long projectId, Model model) {
        budgetservice.deleteBudget(budid);
        model.addAttribute("msg", "예산이 성공적으로 삭제되었습니다.");
        return "redirect:/budget/project/" + projectId;
    }

    
}
