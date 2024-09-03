package com.web.projectplanner.a03_dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.projectplanner.a04_vo.User;

@Mapper
public interface RegisterDao {
   //사원등록: 사원번호 생성
   @Insert("""
         insert into users(empno, name, email, password)
         values(TO_CHAR(SYSDATE, 'YY')|| #{dname} ||emp_seq.nextval, #{name}, #{email}, #{password})
         """)
   int insertUser(User ins);
  
   //이메일 전송
   @Select("""
   		     SELECT * FROM USERS where email = #{email}
              """)
   User getUser(@Param("email") String email);


   //전체 사원 수 조회
   @Select("SELECT COUNT(*) FROM USERS")
   int getCountInsertUser();


   //이메일 중복확인
   @Select("""
  			SELECT COUNT(*)
  			FROM users
  			WHERE email = #{email}
  		   """)
  int emailDupck(@Param("email") String email);


}