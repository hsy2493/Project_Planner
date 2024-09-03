package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.BudgetDao;
import com.web.projectplanner.a04_vo.Budget;

@Service
public class BudgetService { //프로젝트 예산 관리 service
	
	
	 @Autowired(required = false)
	 private BudgetDao budgetDao; //예산 목록 dao
	 
	 
	 //프로젝트 예산 목록
	 public List<Budget> getBudgetList(int projectid){ //조회
		 return budgetDao.getBudgetList(projectid);
	 }
	 public Budget getBudgetById(Long budid) {
	        return budgetDao.getBudgetById(budid);
	    }

	    public void insertBudget(Budget budget) {
	        budgetDao.insertBudget(budget);
	    }

	    public void updateBudget(Budget budget) {
	        budgetDao.updateBudget(budget);
	    }

	    public void deleteBudget(Long budid) {
	        budgetDao.deleteBudget(budid);
	    }

}
