package com.web.projectplanner.a01_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.projectplanner.a02_service.TaskService;
import com.web.projectplanner.a04_vo.Task;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    @ResponseBody
    public String insertTask(@RequestBody Task task ,Model model) {
        int result = taskService.insertTask(task);
        if (result > 0) {
            model.addAttribute("msg", "추가가 완료되었습니다.");
        } else {
            model.addAttribute("msg", "추가에 실패하였습니다.");
        }
        return "redirect:/projects/" + task.getProjectid() + "/tasks";
    }

    @PutMapping("/tasks/{taskid}")
    @ResponseBody
    public String updateTask(@PathVariable Long taskid, @RequestBody Task task) {
        // Task ID 설정
    	
        task.setTaskid(taskid);

        // Task와 관련된 Todo 업데이트
        taskService.updateTask(task);

        return "redirect:/projects/" + task.getProjectid() + "/tasks";
    }

    @DeleteMapping("/tasks/{taskid}")
    @ResponseBody
    public String deleteTask(@PathVariable Long taskid) {
        taskService.deleteTask(taskid);
        return "삭제가 완료되었습니다";
    }

    @GetMapping("/projects/{projectid}/tasks")
    public String getProjectTasks(@PathVariable Long projectid, Model model, @RequestParam(value = "msg", required = false) String msg) {
        List<Task> tasks = taskService.getTasksByProjectId(projectid);
        model.addAttribute("tasks", tasks);
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        return "projectTasks";
    }

    // JSON 응답을 위한 메서드
    @GetMapping("/projects/{projectid}/tasks/json")
    @ResponseBody
    public List<Task> getProjectTasksJson(@PathVariable Long projectid) {
        return taskService.getTasksByProjectId(projectid);
    }

    // JSP 페이지 반환을 위한 메서드
    @GetMapping("/projecttasks/view")
    public String getProjectTasksView(@RequestParam("projectId") Long projectId, Model model) {
        List<Task> tasks = taskService.getTasksByProjectId(projectId);
        model.addAttribute("tasks", tasks);
        return "projectTasks";
    }
 // 간트 차트 페이지 반환을 위한 메서드 추가
    @GetMapping("/projects/{projectid}/gantt")
    public String getGanttPage(@PathVariable Long projectid, Model model) {
        model.addAttribute("projectId", projectid);
        return "gantt";
    }

	/*
	 * // ToDo 리스트 페이지 반환을 위한 메서드 추가
	 * 
	 * @GetMapping("/projects/{projectid}/todo") public String
	 * getTodoPage(@PathVariable Long projectid, Model model) { List<Task> tasks =
	 * taskService.getTasksByProjectId(projectid); model.addAttribute("tasks",
	 * tasks); return "todoList"; }
	 */
}
