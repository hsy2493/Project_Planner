package com.web.projectplanner.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.projectplanner.a02_service.ProjectService;
import com.web.projectplanner.a02_service.TaskService;
import com.web.projectplanner.a04_vo.Project;
import com.web.projectplanner.a04_vo.Task;
import com.web.projectplanner.a04_vo.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/create")
    public String showCreateProjectForm(HttpSession session, Model model) {
        model.addAttribute("project", new Project());

        List<User> userList = (List<User>) session.getAttribute("userList");
        if (userList != null && !userList.isEmpty()) {
            model.addAttribute("empno", userList.get(0).getEmpno()); // 사용자 ID를 모델에 추가
            
        }

        return "createProject";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createProject(HttpSession session, @ModelAttribute Project project, @RequestParam("empno") String empno, Model model) {
    	
        project.setEmpno(empno); // 사용자 ID 설정
        projectService.insertProject(project, empno);
        session.setAttribute("projectid", projectService.getProejctId());
        
        // 프로젝트가 생성되었을 때 리다이렉트할 URL을 반환합니다.
        return "/my";
    }

    @PostMapping("/project/update")
    public String updateProject(@ModelAttribute Project project, @RequestParam("empno") String empno, Model model) {
        project.setEmpno(empno); // 사용자 ID 설정
        projectService.updateProject(project);
        model.addAttribute("msg", "프로젝트가 업데이트되었습니다."); // 알림 메시지 추가
        return "redirect:/my"; // 업데이트 후 리다이렉트
    }
    
	/*
	 * @DeleteMapping("/project/delete/{projectid}") public String
	 * deleteProject(@PathVariable("projectid") Long projectid, Model model) {
	 * projectService.deleteProject(projectid); model.addAttribute("msg",
	 * "프로젝트가 성공적으로 삭제되었습니다."); return "redirect:/my"; // 삭제 후 'My Projects' 페이지로
	 * 리다이렉트 }     //foregin key 삭제처리로인해 현재 미사용
 	 */
    
    @GetMapping("/project/edit/{projectid}")
    public String editProject(@PathVariable("projectid") Long projectid, Model model) {
        Project project = projectService.getProjectById(projectid);
        model.addAttribute("project", project);
        return "edit_project"; // 수정 페이지로 이동
    }

    @GetMapping("/project/{projectid}")
    public String getProjectTasks(@PathVariable("projectid") Long projectId, @RequestParam(value = "msg", required = false) String msg, Model model) {
        // 프로젝트와 관련된 작업 목록을 가져옵니다.
        Project project = projectService.getProjectById(projectId);
        List<Task> tasks = taskService.getTasksByProjectId(projectId);
        
        // 모델에 프로젝트 정보, 작업 목록 및 메시지를 추가합니다.
        model.addAttribute("project", project);
        model.addAttribute("tasks", tasks);
        model.addAttribute("msg", msg);
        
        // "projectTasks" 뷰를 반환합니다.
        return "projectTasks";
    }

    @GetMapping("/my")
    public String getMyProjects(HttpSession session, Model model) {
        List<User> userList = (List<User>) session.getAttribute("userList");
        if (userList != null && !userList.isEmpty()) {
            String empno = userList.get(0).getEmpno();
            List<Project> myProjects = projectService.getProjectsByEmpno(empno);
            model.addAttribute("projects", myProjects);
        }
        return "myProjects";
    }
    
    //하위 코드   프로젝트 인원 파악 코드
    
    @GetMapping("/invite/{projectId}")
    public String inviteMemberForm(@PathVariable("projectId") Long projectid, Model model) {
        Project project = projectService.getProjectById(projectid);
        List<User> availableUsers = projectService.findUsersNotInProject(projectid);
        model.addAttribute("projectid", projectid);
        model.addAttribute("project", project);
        model.addAttribute("availableUsers", availableUsers);
        return "invite_member";
    }

    @PostMapping("/project/invite")
    public String inviteMember(@RequestParam("projectid") Long projectid, 
                               @RequestParam("empno") String empno, 
                               @RequestParam("role") String role, 
                               Model model) {
        projectService.addMemberToProject(projectid, empno, role);
        model.addAttribute("msg", "팀원이 성공적으로 초대되었습니다.");
        return "redirect:/project/" + projectid;
    }
    
    @GetMapping("/project/{projectId}/members")
    public String viewProjectMembers(@PathVariable("projectId") Long projectId, Model model) {
        List<User> projectMembers = projectService.getProjectMembers(projectId);
        model.addAttribute("projectMembers", projectMembers);
        return "teammanagement";  // team_management.jsp로 반환
    }
    
    @GetMapping("/project/{projectId}/members1")
    @ResponseBody
    public List<User> viewProjectMembers(@PathVariable("projectId") Long projectId) {
        return projectService.getProjectMembers(projectId);
    }
    
    @GetMapping("/project/{projectId}/teammanagement")
    public String teamManagement(@PathVariable("projectId") Long projectId, Model model) {
        // 프로젝트 정보와 팀원 관리 용도
        Project project = projectService.getProjectById(projectId);
        List<User> projectMembers = projectService.getProjectMembers(projectId);
        List<User> availableUsers = projectService.findUsersNotInProject(projectId);
        
        // 모델에 데이터를 추가합니다.
        model.addAttribute("project", project);
        model.addAttribute("projectMembers", projectMembers);
        model.addAttribute("availableUsers", availableUsers);
        
        return "teammanagement";
    }
    
    @DeleteMapping("/project/{projectId}/removeMember")
    @ResponseBody
    public String removeMember(@PathVariable("projectId") Long projectId, @RequestParam("empno") String empno) {
    	//팀원 제거 
    	projectService.removeMember(projectId, empno);
        return "팀원이 성공적으로 제거되었습니다.";
    }
    
    
    @GetMapping("/ganttList/{empno}")
    public String getGanttProjectsByEmpno(@PathVariable String empno, Model model) {
        List<Project> projectsG = projectService.getProjectsByEmpno(empno);
        model.addAttribute("projectsgantt", projectsG);
        return "ganttList"; // 보여줄 JSP 페이지
    }
    @GetMapping("/todoListList/{empno}")
    public String getTodoProjectsByEmpno(@PathVariable String empno, Model model) {
        List<Project> projectsG = projectService.getProjectsByEmpno(empno);
        model.addAttribute("projectsgantt", projectsG);
        return "todoListList"; // 보여줄 JSP 페이지
    }
    @GetMapping("/budgetprojectList/{empno}")
    public String getBudgetprojectByEmpno(@PathVariable String empno, Model model) {
        List<Project> projectsG = projectService.getProjectsByEmpno(empno);
        model.addAttribute("projectsgantt", projectsG);
        return "budgetprojectList"; // 보여줄 JSP 페이지
    }
}
