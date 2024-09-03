package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.TaskTodo;
import com.web.projectplanner.a04_vo.Todo;

@Mapper
public interface TodoDao {

    @Select("""
        SELECT * FROM todo
    """)
    List<Todo> findAll();

    @Insert("""
    	    INSERT INTO todo (todoid, taskid, empno, text, start_date, end_date, status)
    	    VALUES (todo_seq.nextval, #{taskid}, #{empno}, #{text}, 
    	            TO_DATE(#{start_date}, 'YYYY-MM-DD HH24:MI:SS'), 
    	            TO_DATE(#{end_date}, 'YYYY-MM-DD HH24:MI:SS'), 
    	            #{status})
    	""")
    	void insert(Todo todo);

    @Update("""
    	    UPDATE todo
    	    SET status = #{status},
    	        taskid = #{taskid},
    	        empno = #{empno},
    	        text = #{text},
    	        start_date = TO_DATE(#{start_date}, 'YYYY-MM-DD HH24:MI:SS'),
    	        end_date = TO_DATE(#{end_date}, 'YYYY-MM-DD HH24:MI:SS')
    	    WHERE todoid = #{todoid}
    	""")
    	void update(Todo todo);

    @Delete("DELETE FROM todo WHERE taskid = #{taskid}")
    void delete(Long taskid);

    @Select("""
        SELECT * FROM todo WHERE taskid = #{taskid}
    """)
    List<Todo> findTodosByTaskId(Long taskid);

    @Select("""
        SELECT taskid FROM todo WHERE todoid = #{todoid}
    """)
    Long findTaskIdByTodoId(Long todoid);
    
    @Select("""
		            SELECT
		    t.taskid,
		    t.text AS task_text,  
		    t.start_date AS task_start_date,
		    t.end_date AS task_end_date,
		    t.PROGRESS AS task_progress,
		    t.projectid,
		    td.todoid,
		    td.empno,
		    td.text AS todo_text, 
		    td.start_date AS todo_start_date,
		    td.end_date AS todo_end_date,
		    td.status AS todo_status
		FROM
		    tasks t
		LEFT JOIN
		    todo td ON t.taskid = td.taskid
		WHERE
		    t.projectid = #{projectid}
        """)
        List<TaskTodo> findTasksWithTodosByProjectId(Long projectid);
    
    @Update("""
    	    UPDATE todo
    	    SET status = #{status}
    	    WHERE todoid = #{todoid}
    	""")
    	void updateTodoStatus(Long todoid, String status);
}
