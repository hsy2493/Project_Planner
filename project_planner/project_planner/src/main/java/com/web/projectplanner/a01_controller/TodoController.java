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
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.projectplanner.a02_service.TaskService;
import com.web.projectplanner.a02_service.TodoService;
import com.web.projectplanner.a04_vo.TaskTodo;
import com.web.projectplanner.a04_vo.Todo;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TaskService taskService;

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
        System.out.println(todo.getTodoid());
        return "Status updated";
    }
}
