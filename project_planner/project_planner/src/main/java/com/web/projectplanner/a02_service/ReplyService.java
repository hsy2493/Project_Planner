package com.web.projectplanner.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.projectplanner.a03_dao.ReplyDao;
import com.web.projectplanner.a04_vo.Reply;

@Service
public class ReplyService {

	@Autowired
	private ReplyDao dao;

	public List<Reply> getReplyList(int no){
		return dao.getReplyList(no);
	}

	public String replyInsert(Reply ins) {
		String msg = null;
		msg = dao.replyInsert(ins)>0?"댓글 등록성공":"댓글 등록실패";
		return msg;
	}

	public int deleteReply(String replyid, int replyno) {
	    return dao.deleteReply(replyid, replyno);
	}
	
	
}
