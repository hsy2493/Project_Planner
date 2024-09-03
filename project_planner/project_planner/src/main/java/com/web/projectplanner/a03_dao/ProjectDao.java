package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.Project;
import com.web.projectplanner.a04_vo.User;

@Mapper
public interface ProjectDao {
	    @Select("SELECT projectid, projectname, empno, createdat FROM projects WHERE projectid = #{projectid}")
	    Project findById(Long projectid);
	    //프로젝트 정보 반환

	    @Select("SELECT projectid, projectname, empno, createdat FROM projects")
	    List<Project> findAll();
	    //프로젝트 정보 리스트 반환

	    @Insert("""
	    		INSERT INTO projects(projectid, projectname, empno, createdat) 
	    		VALUES(projects_seq.NEXTVAL, #{projectname}, #{empno}, CURRENT_DATE)
	    		""")
	    @Options(useGeneratedKeys = true, keyProperty = "projectid", keyColumn = "projectid")
	   int insert(Project project);
	    @Insert("""
	            INSERT INTO project_members(project_id, empno, role)
	            VALUES(#{projectId}, #{empno}, 'PM')
	        """)
	        int addMemberToProject(@Param("projectId") Long projectId, @Param("empno") String empno); 
	    
	   @Select(" select projects_seq.CURRVAL FROM dual")
	   int getProejctId();
	    
	    //프로젝트 추가

	    @Update("""
	    		UPDATE projects SET projectname=#{projectname}, empno=#{empno}, 
	    		createdat=CURRENT_DATE WHERE projectid=#{projectid}
	    		""")
	    int update(Project project);
	    //프로젝트 업데이트

	    @Select(" SELECT p.* FROM projects p\r\n"
	    		+ "        JOIN project_members pm ON p.projectid = pm.project_id\r\n"
	    		+ "        WHERE pm.empno = #{empno}")
	    List<Project> findProjectsByEmpno(String empno);
	    //empno가 만든 프로젝트
	    
	    //-- 팀원 초대 DAO
	  

	        @Select("""
	            SELECT * FROM users 
	            WHERE empno NOT IN (
	                SELECT empno FROM project_members WHERE project_id = #{projectId}
	            )
	        """)
	        List<User> findUsersNotInProject(@Param("projectId") Long projectId);

	        @Insert("""
	            INSERT INTO project_members (project_id, empno, role)
	            VALUES (#{projectId}, #{empno}, #{role})
	        """)
	        void insertProjectMember(@Param("projectId") Long projectId, @Param("empno") String empno, @Param("role") String role);
	       
	        //팀원 목록확인
	        
	        @Select("""
	                SELECT u.empno, u.name, u.role 
	                FROM users u 
	                JOIN project_members pm ON u.empno = pm.empno
	                WHERE pm.project_id = #{projectId}
	            """)
	            List<User> findMembersByProjectId(@Param("projectId") Long projectId);

}
