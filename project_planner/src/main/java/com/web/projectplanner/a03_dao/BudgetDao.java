package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.Budget;

@Mapper
public interface BudgetDao { //프로젝트 예산 관리 Dao
	//프로젝트 예산 목록
	//조회
	@Select("""
			SELECT 
			    b.Budcontent AS budcontent, 
			    b.Budget AS Budget, 
			    b.BudActual AS BudActual, 
			    b.status AS status, 
			    b.approval AS approval, 
			    p.projectname AS projectname, 
			    p.empno AS empno
			FROM 
				Budget b
			JOIN 
				projects p 
			ON 
			    b.projectid = p.projectid
			WHERE 
			 	p.projectid = #{projectid}
			""")
	List<Budget> getBudgetList(int projectid);
	
	 @Select("""
		        SELECT budid, projectid, budcontent, budget, budActual, status, approval
		        FROM Budget
		        WHERE budid = #{budid}
		    """)
		    Budget getBudgetById(@Param("budid") Long budid);

		    @Insert("""
		        INSERT INTO Budget (budid, projectid, budcontent, budget, budActual, status, approval)
		        VALUES (budid_seq.nextval, #{projectid}, #{budcontent}, #{budget}, #{budActual}, #{status}, #{approval})
		    """)
		    void insertBudget(Budget budget);

		    @Update("""
		        UPDATE Budget
		        SET budcontent = #{budcontent}, budget = #{budget}, budActual = #{budActual}, 
		            status = #{status}, approval = #{approval}
		        WHERE budid = #{budid}
		    """)
		    void updateBudget(Budget budget);

		    @Delete("DELETE FROM Budget WHERE budid = #{budid}")
		    void deleteBudget(@Param("budid") Long budid);
		   

}
