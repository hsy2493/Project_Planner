package com.web.projectplanner.a01_controller;

import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.multipart.MultipartFile;

import com.web.projectplanner.a02_service.TaskService;
import com.web.projectplanner.a02_service.TodoService;
import com.web.projectplanner.a04_vo.TaskTodo;
import com.web.projectplanner.a04_vo.Todo;
import com.web.projectplanner.a04_vo.TodoFile;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TaskService taskService;
    
    @Value("${user.upload}")
	private String upload;

    @GetMapping("/todos")
    @ResponseBody
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    @ResponseBody
    public String insertTodo(@RequestBody Todo todo) {
    	
        todoService.insertTodo(todo);
        return "redirect:/tasks/" + todo.getTaskid() + "/todo";
    }

    @PutMapping("/todos/{todoid}")
    @ResponseBody
    public String updateTodo(@PathVariable Long todoid, @RequestBody Todo todo) {
        todo.setTodoid(todoid);
        todoService.updateTodo(todo);
        return "redirect:/tasks/" + todo.getTaskid() + "/todo";
    }

    @DeleteMapping("/todos/{todoid}")
    @ResponseBody
    public String deleteTodo(@PathVariable Long todoid) {
        // taskid가 필요하다면, 관련된 정보를 todo에서 가져와야 할 수도 있습니다.
        Long taskid = todoService.findTaskIdByTodoId(todoid);
        todoService.deleteTodo(todoid);
        return "redirect:/tasks/" + taskid + "/todo";
    }

    @GetMapping("/projects/{projectid}/todo")
    public String getProjectTodoList(@PathVariable Long projectid, Model model) {
    	 List<TaskTodo> taskTodos = todoService.getTasksWithTodosByProjectId(projectid);
         model.addAttribute("taskTodos", taskTodos);
        return "todoList";
    }
    
    @PostMapping("/tasks/updateStatus")
    @ResponseBody
    public String updateTodoStatus(@RequestBody Todo todo) {
        todoService.updateTodoStatus(todo.getTodoid(), todo.getStatus());
        return "상태변경이 완료되었습니다.";
    }
    
 // 결재 요청 처리 메서드
    @PostMapping("/tasks/requestApproval")
    @ResponseBody
    public String requestApproval(@RequestBody Todo todo) {
        todoService.requestApproval(todo.getTodoid(), "결재 요청");
        return "결재 요청이 성공적으로 처리되었습니다.";
    }
    
 // 결재 승인 처리 메서드
    @PostMapping("/approve")
    @ResponseBody
    public String approveTodo(@RequestBody Todo todo) {
        todoService.approveTodo(todo.getTodoid());
        return "결재가 성공적으로 승인되었습니다.";
    }

    // 결재 반려 처리 메서드
    @PostMapping("/reject")
    @ResponseBody
    public String rejectTodo(@RequestBody Todo todo) {
        todoService.rejectTodo(todo.getTodoid(), todo.getReason());
        return "결재가 반려되었습니다.";
    }
    
    //파일 업로드 처리 메서드
    @PostMapping("/todos/{todoid}/upload")
    @ResponseBody
    public String uploadFiles(@PathVariable Long todoid, 
                              @RequestParam("files") MultipartFile[] files) {
        todoService.addFilesToTodo(todoid, files);
        return "파일 업로드가 완료되었습니다.";
    }
    
    @GetMapping("/todos/{todoid}/files")
    @ResponseBody
    public List<TodoFile> getTodoFiles(@PathVariable Long todoid) {
        return todoService.getFilesByTodoId(todoid);
    }
 // 파일 삭제 처리 메서드
    @DeleteMapping("/todos/{todoid}/deleteFiles")
    @ResponseBody
    public String deleteFiles(@PathVariable Long todoid) {
        todoService.deleteFiles(todoid);
        return "모든 파일이 삭제되었습니다.";
    }
   
    
    @GetMapping("/todos/{todoid}/download/{filename}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("todoid") Long todoid, @PathVariable("filename") String filename) {
        try {
            Path filePath = Paths.get(upload+filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)  // MIME 타입 설정
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(resource.getFilename(), "UTF-8").replaceAll("\\+", "%20") + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            return ResponseEntity.status(500).build();
        }
    }
    
}
