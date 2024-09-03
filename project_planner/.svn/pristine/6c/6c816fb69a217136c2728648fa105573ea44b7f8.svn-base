package com.web.projectplanner.a03_dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AjaxDao {
	@Select("SELECT count(*)\r\n"
			+ "FROM emp\r\n"
			+ "WHERE empno=#{empno}")
	int checkEmpno(@Param("empno") int empno);
}
