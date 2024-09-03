package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.projectplanner.a03_dao.ProjectDao;
import com.web.projectplanner.a04_vo.Project;
import com.web.projectplanner.a04_vo.User;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }
    
    @Transactional
    public void insertProject(Project project, String empno) {
        projectDao.insert(project);
        projectDao.addMemberToProject(project.getProjectid(), empno);
    }

    public int updateProject(Project project) {
        return projectDao.update(project);
    }
    
	/*
	 * public void deleteProject(Long projectid) { projectDao.delete(projectid); }
	 */

    public Project getProjectById(Long projectid) {
        return projectDao.findById(projectid);
    }

    public List<Project> getProjectsByEmpno(String empno) {
    	System.out.println(empno);
        return projectDao.findProjectsByEmpno(empno);
    }
    public int getProejctId() {
    	return projectDao.getProejctId();
    }
    
    //하위 팀원 찾는 코드
    
    public List<User> findUsersNotInProject(Long projectId) {
        return projectDao.findUsersNotInProject(projectId);
    }

    public void addMemberToProject(Long projectId, String empno, String role) {
        projectDao.insertProjectMember(projectId, empno, role);
    }
    
    //팀원목록확인
    public List<User> getProjectMembers(Long projectId) {
        return projectDao.findMembersByProjectId(projectId);
    }
    
    public void removeMember(Long projectId, String empno) {
        projectDao.deleteMember(projectId, empno);
    }
}
