package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.User;


@Mapper
public interface UserDao {
	//로그인
	@Select("""
	        SELECT *
	        FROM users
	        WHERE email = #{email}
	        AND password = #{password}
	    """)
	    List<User> findByEmailAndPassword(String email, String password);

	//마이페이지 조회
	@Select("""
				SELECT * FROM users
		        WHERE empno = #{empno}

			""")
	User getUserList( @Param("empno") String empno );

	//마이페이지-역할 선택
	@Update("""
            UPDATE users
            SET role = #{role}
            WHERE empno = #{empno}
            """)
    int updateUserRole(@Param("empno") String empno, @Param("role") String role);

	//마이페이지-비밀번호 재설정(새비밀번호로 변경)
	@Update("""
	        UPDATE users
	        SET password = #{password}
	        WHERE empno = #{empno}
	    """)
	int updatePwd(@Param("empno") String empno, @Param("password") String password);
	

	//로그인-비밀번호 재설정(임시 비밀번호)이메일 발송
	@Select("""
		    SELECT *
		    FROM users
		    WHERE email = #{email}
			""")
	User getUserByEmail(@Param("email") String email);

	//로그인-비밀번호 메일발송
	@Select("""
			SELECT COUNT(*) 
			FROM users 
			WHERE email = #{email}
			""")
	int updpwd(@Param("email") String email);
	
	//발송된 임시비밀번호 사원정보에 저장
    @Update("""
    		  UPDATE users
    		  SET password = #{password}
    		  WHERE email = #{email}
    	    """)
    void changepwd(@Param("password") String password, @Param("email") String email);
    
    
    //사원정보 List
    //사원명, 역할로 사원 검색
    //프로젝트 활동 여부 : 참여 중(활동) / 미참여 중(미활동)
    @Select("""
    		 SELECT DISTINCT u.empno, u.name, u.email, u.role,
             CASE 
             WHEN pm.empno IS NOT NULL THEN '활동 중'
             ELSE '미활동'
             END AS projectStatus
             FROM users u
             LEFT JOIN project_members pm ON u.empno = pm.empno
             
    		 WHERE u.name LIKE '%' || #{name} || '%'
    		 AND u.role LIKE '%' || #{role} || '%'
    		 ORDER BY u.name
    		""")
     List<User> getEmpList(User sch);
    


}
