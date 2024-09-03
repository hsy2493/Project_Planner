package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.projectplanner.a03_dao.TaskDao;
import com.web.projectplanner.a03_dao.TodoDao;
import com.web.projectplanner.a04_vo.Task;
import com.web.projectplanner.a04_vo.Todo;

@Service
public class TaskService {
	@Autowired
    private TaskDao taskDAO;
	@Autowired
	private TodoDao todoDao;
	
    public List<Task> getAllTasks() {
        return taskDAO.findAll();
    }

   

    @Transactional
    public void updateTask(Task task) {
        // Task 업데이트
        int result = taskDAO.update(task);

        // Task 업데이트가 성공하면 관련된 Todo 업데이트
        if(result > 0) {
            List<Todo> todos = todoDao.findTodosByTaskId(task.getTaskid());

            for (Todo todo : todos) {
                todo.setText(task.getText()); // Task의 text가 변경되었을 경우
                todo.setStart_date(task.getStart_date()); // 시작 날짜 업데이트
                todo.setEnd_date(task.getEnd_date()); // 종료 날짜 업데이트

                // empno가 null이 아니면 업데이트, null이면 기존 값을 유지
                if (task.getEmpno() != null) {
                    todo.setEmpno(task.getEmpno());
                }
                String status;
                if (task.getProgress() == null || task.getProgress().isEmpty() || task.getProgress().equals("0")) {
                    status = todo.getStatus(); // 기존 상태를 유지
                } else {
                    status = task.getProgress(); // 새로운 상태로 업데이트
                }
                todo.setStatus(status);
                
                todoDao.update(todo); // 업데이트 실행
            }
        }
    }

    public void deleteTask(Long taskid) {
    	  // Task와 연결된 모든 Todo 항목 삭제
        todoDao.delete(taskid);
        // Task 삭제
        taskDAO.delete(taskid);
    }

    public List<Task> getTasksByProjectId(Long projectid) {
        return taskDAO.findTasksByProjectId(projectid);
    }
    @Transactional
    public int insertTask(Task task) {
    	 System.out.println(task.getEmpno());
    	    	 
        int taskResult = taskDAO.insert(task);
       
        if(taskResult > 0) {
            Todo todo = new Todo();
            todo.setTaskid(task.getTaskid());
            todo.setText(task.getText());
            todo.setStart_date(task.getStart_date());
            todo.setEnd_date(task.getEnd_date());
            todo.setStatus("예정");
            todo.setEmpno(task.getEmpno());
            todoDao.insert(todo);
        }

        return taskResult;
    }

}