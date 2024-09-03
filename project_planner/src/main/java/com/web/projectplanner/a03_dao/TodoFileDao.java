package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.web.projectplanner.a04_vo.TodoFile;

@Mapper
public interface TodoFileDao {
	
	@Insert("""
	        INSERT INTO todofile (fileid, todoid, filename, filepath, uploaded_at)
	        VALUES (todofile_seq.nextval, #{todoid}, #{filename}, #{filepath}, CURRENT_TIMESTAMP)
	    """)
	void insertTodoFile(TodoFile todoFile);
	
	@Select("SELECT * FROM todofile WHERE todoid = #{todoid}")
	List<TodoFile> findFilesByTodoId(Long todoid);
	

    // 특정 fileid에 해당하는 파일을 삭제하는 메서드
    @Delete("""
        DELETE FROM todofile WHERE fileid = #{fileid}
    """)
    void deleteTodoFile(Long fileid);
}
