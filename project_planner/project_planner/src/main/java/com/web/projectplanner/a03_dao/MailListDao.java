package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.projectplanner.a04_vo.User;

@Mapper
public interface MailListDao {

	@Select("""
   		 SELECT DISTINCT u.empno, u.name, u.email, u.role,
            CASE 
            WHEN pm.empno IS NOT NULL THEN '활동 중'
            ELSE '미활동'
            END AS projectStatus
            FROM users u
            LEFT JOIN project_members pm ON u.empno = pm.empno
            
   		 WHERE u.empno LIKE '%' || #{empno} || '%'
   		 AND u.name LIKE '%' || #{name} || '%'
   		  ORDER BY u.name
   		""")
    List<User> getEmpList(User sch);
	
	@Select("select *\r\n"
			+ "	from users\r\n"
			+ "	where empno = #{empno}")
	User getEmp(@Param("empno") String empno);
}
