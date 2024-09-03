package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.TodoDao;
import com.web.projectplanner.a04_vo.TaskTodo;
import com.web.projectplanner.a04_vo.Todo;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    public List<Todo> getAllTodos() {
        return todoDao.findAll();
    }

    public void insertTodo(Todo todo) {
        todoDao.insert(todo);
    }

    public void updateTodo(Todo todo) {
        todoDao.update(todo);
    }

    public void deleteTodo(Long todoid) {
        todoDao.delete(todoid);
    }

    public Long findTaskIdByTodoId(Long todoid) {
        return todoDao.findTaskIdByTodoId(todoid);
    }

    public List<Todo> getTodosByTaskId(Long taskid) {
        return todoDao.findTodosByTaskId(taskid);
    }
    public List<TaskTodo> getTasksWithTodosByProjectId(Long projectid) {
        return todoDao.findTasksWithTodosByProjectId(projectid);
    }
    public void updateTodoStatus(Long todoid, String status) {
        todoDao.updateTodoStatus(todoid, status);
    }
}
