package com.web.projectplanner.a02_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.AjaxDao;

@Service
public class AjaxService {

	@Autowired(required=false)
	private AjaxDao dao;

	public String checkEmpno(int empno) {
		return dao.checkEmpno(empno)>0?"등록된 사원번호가 있음":"해당 사원번호로 등록 가능";
	}
}
