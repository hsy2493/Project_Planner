package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.web.projectplanner.a03_dao.TodoDao;
import com.web.projectplanner.a03_dao.TodoFileDao;
import com.web.projectplanner.a04_vo.TaskTodo;
import com.web.projectplanner.a04_vo.Todo;
import com.web.projectplanner.a04_vo.TodoFile;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;
    @Autowired
    private TodoFileDao todoFileDao;
    @Autowired
    private FileUploadService fileUploadService;
    
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
    
    public void requestApproval(Long todoid, String review_status) {
        todoDao.updateReview(todoid, review_status);
    }
    
 // 결재 상태가 "결재 요청", "결재 완료", "반려"인 항목들을 가져오는 메서드
    public List<Todo> getApprovalTodos(String empno) {
        return todoDao.findApprovalTodosByEmpno(empno);
    }
    
    @Transactional
    public void approveTodo(Long todoid) {
        // 결재 상태를 "결재 완료"로 업데이트
        todoDao.updateReviewStatus(todoid, "결재 완료", "");
    }

    @Transactional
    public void rejectTodo(Long todoid, String reason) {
        // 결재 상태를 "반려"로 업데이트하고, 반려 사유를 저장
        todoDao.updateReviewStatus(todoid, "반려", reason);
    }
    
    @Transactional
    public void addFilesToTodo(Long todoid, MultipartFile[] files) {
        if (files != null && files.length > 0) {
            for (MultipartFile file : files) {
                String filePath = fileUploadService.uploadFile(file); // 파일 저장 후 경로 반환
                TodoFile todoFile = new TodoFile();
                todoFile.setTodoid(todoid);
                todoFile.setFilename(file.getOriginalFilename());
                todoFile.setFilepath(filePath);
                todoFileDao.insertTodoFile(todoFile);
            }
        }
    }
    
    public List<TodoFile> getFilesByTodoId(Long todoid) {
        return todoFileDao.findFilesByTodoId(todoid);
    }
    
    @Transactional
    public void deleteFiles(Long todoid) {
        List<TodoFile> files = todoFileDao.findFilesByTodoId(todoid);
        for (TodoFile file : files) {
            fileUploadService.deleteFile(file.getFilepath()); // 실제 파일 삭제
            todoFileDao.deleteTodoFile(file.getFileid());     // DB에서 파일 기록 삭제
        }
    }
}
