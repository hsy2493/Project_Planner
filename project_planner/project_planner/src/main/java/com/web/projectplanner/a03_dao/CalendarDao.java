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

	@Select("select id, title, writer, start1 \"start\", end1 \"end\", content, backgroundColor,\r\n"
			+ "		textColor, allDay, urlLink\r\n"
			+ "from calendar2 where writer = #{writer}")
	List<Calendar> getCalendarList(@Param("writer")String writer);

	@Insert("INSERT INTO calendar2 values(cal_seq2.nextval,\r\n"
			+ "	#{title},#{writer},#{start},#{end},\r\n"
			+ "	#{content},#{backgroundColor},#{textColor},#{allDay},\r\n"
			+ "	#{urlLink})")
	int insertCalendar(Calendar ins);

	@Update("UPDATE CALENDAR2 \r\n"
			+ "SET title = #{title},\r\n"
			+ "    start1=#{start},\r\n"
			+ "    end1=#{end},\r\n"
			+ "    content=#{content},\r\n"
			+ "    backgroundColor=#{backgroundColor},\r\n"
			+ "    textColor=#{textColor},\r\n"
			+ "    allDay = #{allDay},\r\n"
			+ "    urlLink=#{urlLink}\r\n"
			+ "WHERE id = #{id} and writer = #{writer}")
	int updateCalendar(Calendar upt);

	@Delete("DELETE FROM calendar2\r\n"
			+ "WHERE id = #{id} and writer = #{writer}")
	int deleteCalendar(@Param("id") int id, @Param("writer")String writer);

}
