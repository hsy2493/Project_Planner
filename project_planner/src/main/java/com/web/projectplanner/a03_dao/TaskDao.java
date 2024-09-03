package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.Task;


@Mapper
public interface TaskDao {

	@Select("""
	        SELECT taskid, text, TO_CHAR(start_date, 'YYYY-MM-DD HH24:MI:SS') AS start_date,
	               TO_CHAR(end_date, 'YYYY-MM-DD HH24:MI:SS') AS end_date, progress, projectid
	        FROM tasks
	    """)
	    List<Task> findAll();


	@Select("WITH RankedTasks AS (\r\n"
			+ "    SELECT projectid,\r\n"
			+ "           ROW_NUMBER() OVER (PARTITION BY projectid ORDER BY projectid) AS rn\r\n"
			+ "    FROM TASKS\r\n"
			+ ")\r\n"
			+ "SELECT projectid\r\n"
			+ "FROM RankedTasks\r\n"
			+ "WHERE rn = 1\r\n"
			+ "ORDER BY projectid")
		List<Task> finddisAll();
	
	    @Insert("""
	        INSERT INTO tasks(taskid, text, start_date, end_date, progress, projectid)
	        VALUES(tasks_seq.NEXTVAL, #{text}, TO_DATE(#{start_date}, 'YYYY-MM-DD HH24:MI:SS'),
	               TO_DATE(#{end_date}, 'YYYY-MM-DD HH24:MI:SS'), #{progress}, #{projectid})
	    """)
	    @Options(useGeneratedKeys = true, keyProperty = "taskid", keyColumn = "taskid")
	    int insert(Task task);

		    @Update("""
		    		UPDATE tasks SET text=#{text}, start_date=TO_DATE(#{start_date},
		    		'YYYY-MM-DD HH24:MI:SS'), end_date=TO_DATE(#{end_date}, 'YYYY-MM-DD HH24:MI:SS'),
		    		progress=#{progress}
		    		 WHERE taskid=#{taskid}

		    		""")
		    int update(Task task);

		    @Delete("DELETE FROM tasks WHERE taskid=#{taskid}")
		    int delete(Long taskid);

	    @Select("""
	        SELECT taskid, text, TO_CHAR(start_date, 'YYYY-MM-DD HH24:MI:SS') AS start_date,
	               TO_CHAR(end_date, 'YYYY-MM-DD HH24:MI:SS') AS end_date, progress, projectid
	        FROM tasks
	        WHERE projectid = #{projectid}
	    """)
	    List<Task> findTasksByProjectId(Long projectid);


}