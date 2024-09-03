package com.web.projectplanner.a04_vo;

public class FreeBoardSch {
/*
		주요 속성 : 검색-제목(subject),작성자(writer)
		기본페이지처리 - 전체데이터건수(count), 한번에 보여줄 데이터 건수(pageSize),
			총페이지수(pageCount), 현재 클릭한 페이지 번호(curPage),
			시작번호(start), 마지막번호(end)
		페이지블럭처리 - 한번에 보여줄 block의 크기(blockSize), block 시작번호(startBlock),
					 block 마지막번호(endBlock)
 * */
	private String subject;
	private String writer;
	private int count;
	private int pageSize;
	private int pageCount;
	private int curPage;
	private int start;
	private int end;
	private int blockSize;
	private int startBlock;
	private int endBlock;
	public FreeBoardSch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FreeBoardSch(String subject, String writer, int count, int pageSize, int pageCount, int curPage,
			int start, int end, int blockSize, int startBlock, int endBlock) {
		super();
		this.subject = subject;
		this.writer = writer;
		this.count = count;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.curPage = curPage;
		this.start = start;
		this.end = end;
		this.blockSize = blockSize;
		this.startBlock = startBlock;
		this.endBlock = endBlock;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

}
