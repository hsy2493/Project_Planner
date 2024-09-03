package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.Calendar;

@Mapper
public interface CalendarDao {

	// 개인 캘린더
	@Select("select id, title, writer, start1 \"start\", end1 \"end\", content, 'skyblue' BACKGROUNDCOLOR,\r\n"
			+ "		textColor, allDay, urlLink, div, projectid\r\n"
			+ "from calendar2 where writer = #{writer} and div = '개인' and projectid=#{projectid}")
	List<Calendar> getCalendarList(@Param("writer")String writer, 
								   @Param("projectid")int projectid);
	
	// 팀 캘린더
	@Select("select id, title, writer, start1 \"start\", end1 \"end\", content, 'blue' BACKGROUNDCOLOR,\r\n"
			+ "		textColor, allDay, urlLink, div, projectid\r\n"
			+ "from calendar2 where projectid = #{projectid} and div = '팀'")
	List<Calendar> getCalendarList2(@Param("projectid")int id);
	
	// 간트 캘린더 
	@Select("SELECT \r\n"
			+ "	9999+a.taskid id, \r\n"
			+ "	a.text title, \r\n"
			+ "	b.empno writer, \r\n"
			+ "	to_char(a.start_date,'YYYY-MM-DD') \"start\", \r\n"
			+ "	to_char(a.end_date,'YYYY-MM-DD')  \"end\", \r\n"
			+ "	'ㄱㄱ' content, \r\n"
			+ "	'navy' BACKGROUNDCOLOR, \r\n"
			+ "	'white' textcolor, 1 allday, 'ㄱㄱ' urllink\r\n"
			+ "FROM tasks a\r\n"
			+ "JOIN todo b ON a.taskid = b.taskid\r\n"
			+ "WHERE a.projectid = #{projectid}")
	List<Calendar> getCalendarList3(@Param("projectid")int projectid);
	
	
	// 캘린더 등록
	@Insert("INSERT INTO calendar2 values(cal_seq2.nextval,\r\n"
			+ "	#{title},#{writer},#{start},#{end},\r\n"
			+ "	#{content},#{backgroundColor},#{textColor},#{allDay},\r\n"
			+ "	#{urlLink}, #{div}, #{projectid})")
	int insertCalendar(Calendar ins);

	// 캘린더 수정
    @Update("UPDATE calendar2 " +
            "SET title = #{title}, " +
            "    start1 = #{start}, " +
            "    end1 = #{end}, " +
            "    content = #{content}, " +
            "    backgroundColor = #{backgroundColor}, " +
            "    textColor = #{textColor}, " +
            "    allDay = #{allDay}, " +
            "    urlLink = #{urlLink} " +
            "WHERE id = #{id} AND writer = #{writer} AND div = #{div}")
    int updateCalendar(Calendar upt);

    // 캘린더 삭제
    @Delete("DELETE FROM calendar2 " +
            "WHERE id = #{id} AND writer = #{writer} AND div = #{div}")
    int deleteCalendar(@Param("id") int id, @Param("writer") String writer, @Param("div") String div);

}
