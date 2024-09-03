package com.web.projectplanner.a03_dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.projectplanner.a04_vo.Reply;

@Mapper
public interface ReplyDao {

	@Select("SELECT * FROM reply WHERE no = #{no}")
	List<Reply> getReplyList(@Param("no") int no);

	@Insert("INSERT INTO reply VALUES (#{no}, reply_seq.nextval, #{replyid}, #{content}, sysdate)")
	int replyInsert(Reply ins);

	@Delete("DELETE FROM reply WHERE replyid = #{replyid} AND replyno = #{replyno}")
    int deleteReply(@Param("replyid") String replyid, @Param("replyno") int replyno);
	
	@Delete("DELETE FROM reply where no = #{no}")
	int deleteAll(@Param("no")int no);
	
}
