package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.projectplanner.a04_vo.FreeBoard;
import com.web.projectplanner.a04_vo.FreeBoardSch;
import com.web.projectplanner.a04_vo.FreeBoardfile;




@Mapper
public interface FreeBoardDao {


	// 자유게시판 리스트
	@Select("SELECT count(*)\r\n"
			+ "FROM freeboard\r\n"
			+ "WHERE subject LIKE '%'||#{subject}||'%'\r\n"
			+ "AND writer LIKE '%'||#{writer}||'%'\r\n")
	int getFreeboardCount(FreeBoardSch sch);

	// 자유게시판 페이징
	@Select("SELECT *\r\n"
			+ "FROM (\r\n"
			+ "	select rownum cnt, level, t.*  \r\n"
			+ "	from freeboard t\r\n"
			+ "	where subject like '%'||#{subject}||'%'\r\n"
			+ "	and writer like '%'||#{writer}||'%'\r\n"
			+ "	start with refno = 0\r\n"
			+ "	connect by prior no = refno\r\n"
			+ "	order siblings by no DESC )\r\n"
			+ "WHERE cnt BETWEEN #{start} AND #{end}")
	List<FreeBoard> getFreeboardList(FreeBoardSch sch);

	// 자유게시판 글 등록
	@Insert("insert into freeboard values(freeboard_seq.nextval,#{refno},#{subject},\r\n"
			+ "	#{content},#{writer},#{readcnt},sysdate,sysdate) ")
	int freeboardInsert(FreeBoard ins);

	// 자유게시판 파일 업로드
	@Insert("INSERT INTO freeboardfile values(freeboard_seq.currval,#{fname},\r\n"
			+ "	#{etc},sysdate,sysdate)")
	int freeboardFileInsert(FreeBoardfile ins);

	// 자유게시판 상세조회
	@Select("select * from freeboard where no = #{no}")
	FreeBoard getFreeboard(@Param("no") int no );

	// 자유게시판 파일조회
	@Select("select fname from freeboardfile where no = #{no}")
	List<String> getFiles(@Param("no") int no);

	// 자유게시판 조회수 증가
	@Update("update freeboard\r\n"
			+ "   set readcnt = readcnt + 1\r\n"
			+ "where no = #{no}")
	int uptReadCnt(@Param("no") int no);

	// 자유게시판 수정
	@Update("	UPDATE freeboard \r\n"
			+ "	SET subject = #{subject},\r\n"
			+ "	    content = #{content},\r\n"
			+ "	    uptdte = sysdate\r\n"
			+ "WHERE NO = #{no}")
	int updateFreeboard(int no, String writer, String subject, String content);

	// 자유게시판 삭제
	@Delete("DELETE FROM freeboard\r\n"
			+ "WHERE NO = #{no}")
	int deleteFreeboard(@Param("no") int no, @Param("writer")String writer);




}
