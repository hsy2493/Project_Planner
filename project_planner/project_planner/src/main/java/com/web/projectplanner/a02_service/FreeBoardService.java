package com.web.projectplanner.a02_service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.projectplanner.a03_dao.FreeBoardDao;
import com.web.projectplanner.a04_vo.FreeBoard;
import com.web.projectplanner.a04_vo.FreeBoardSch;
import com.web.projectplanner.a04_vo.FreeBoardfile;



@Service
public class FreeBoardService {
   @Autowired(required=false)
   private FreeBoardDao dao;

   public List<FreeBoard> getFreeBoardList(FreeBoardSch sch){
      if(sch.getSubject()==null) {
         sch.setSubject("");
      }
      if(sch.getWriter()==null) {
         sch.setWriter("");
      }
      // 1. 총데이터 수(DB)
      sch.setCount(dao.getFreeboardCount(sch));

      // 2. 현재 클릭한 번호(화면단 요청값)..- 초기값 1(첫번째페이지)
      if(sch.getCurPage()==0) {
         sch.setCurPage(1);
      }

      // 3. 한페이지에 보일 데이터 건수(화면단 선택으로 요청값) - 초기값5(첫번째 페이지)
      if(sch.getPageSize()==0) {
         sch.setPageSize(10);
      }

      // 4. 총페이지수(수치연산/알고리즘 - 총데이터건수/한페이지에 보일 데이터 수)

      //    13건   5  ==>  13/5 ==> 2.6  ==> 3.0 ==> 3
      //                  10/5 ==> 2   ==> 2.0 ==> 2
      //                  7/5 ==> 1.4 ==> 2.0 ==> 2
      //                  5/5 ==> 1  ==> 1.0 ==> 1
      //  정수/정수 ==> 실수/정수 vs 정수/실수 ==> 실수
      // sch.getCount()/sch.getPageSize() ==> 정수..
      //  sch.getCount()/(double)sch.getPageSize() ==> 실수
      //  Math.ceil(sch.getCount()/(double)sch.getPageSize()) ==> 실수
      // (int)(Math.ceil(sch.getCount()/(double)sch.getPageSize())) ==> 정수
      sch.setPageCount( (int)(Math.ceil(sch.getCount()/(double)sch.getPageSize())) );

      // 마지막 page block에서 next를 클릭하더라도, 더 이상 페이지번호가
      // 증가되지 않게 처리..
      if(sch.getCurPage()>sch.getPageCount()) {
         sch.setCurPage(sch.getPageCount());
      }

      // 5. 시작번호/마지막번호 -  마지막번호?( 한페이지에 보일 데이터 건수*현재 클릭한 번호)
      ///   1페이지 클릭 ==> 1~5
      ///   2페이지    ==> 6~10
      //    3페이지    ==> 11~15
      //    4페이지    ==> 16~20     17...
      //   ex) 3 ===>  1,4,7,10....
      //   ex) 10 ===>  1,11,21,31....
      //    마지막번호는 마지막데이터건수보다 클 수 없다..
      //    if( sch.getCount() < sch.getEnd() )
      //       sch.setEnd( sch.getCount() )

      sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);

      int imEnd = sch.getPageSize()*sch.getCurPage();
      sch.setEnd(imEnd > sch.getCount()?sch.getCount():imEnd);


      // start, end  ==> 특정 페이지 범위에 데이터 출력..

      // 6. 페이징 블럭 처리..
      /*
      이전 [ 1][ 2][ 3][ 4][ 5] 이후  ==> 1번 block
      이전 [ 6][ 7][ 8][ 9][10] 이후  ==> 2번 block
      이전 [11][12][13] 이후          ==> 3번 block

      특정 페이지번호에 시작블럭 번호와 마지막 번호를 BoardSch에 설정함으로 화면에서 위와 같은
      UI(user interface)를 보이게 하기 위한 것이다.
      결국은 각 block에서 시작블럭번호(startBlock)과 마지막블럭번호(endBlock)를 화면단에 넘겨주어서
      출력하기 위해서 처리하는 것이다.
       * */
      //    1) 블럭 크기 설정.-일반적으로 홀수로 정함..
      sch.setBlockSize(5);
      //  2) 블럭 번호 지정..1~5 ==> 1,  6~10 ==> 2,  11~15 ==> 3...
      //  (int) Math.ceil(sch.getCurPage()/(double)sch.getBlockSize())  1/5, 2/5, 3/5, 4/5, 5/5 =>1
      int blockNum = (int) Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
      //  3) 시작블럭
      sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
      //  4) 마지막블럭..
      int endBlock = blockNum*sch.getBlockSize();
      sch.setEndBlock( (endBlock>sch.getPageCount())?sch.getPageCount():endBlock );


      return dao.getFreeboardList(sch);
   }

   @Value("${user.upload}")
   String path;

   public String freeBoardInsert(FreeBoard ins) {
      String msg = null;
      // 메인테이블 등록..
      msg = dao.freeboardInsert(ins)>0?"게시물 등록 성공":"게시물 등록 실패";

      // 파일업로드관련 등록 정보
      if(ins.getReports()!=null && ins.getReports().length>0) {
         // 물리적 파일 등록
         try {
            int fcnt=0;
            for(MultipartFile mp:ins.getReports() ) {
               String fnm = mp.getOriginalFilename();
               if( fnm!=null && !fnm.equals("") ) {
                  File fup = new File(path,fnm);
                  mp.transferTo(fup);
                  //fcnt++;
                  // 파일정보 등록.
                  fcnt+=dao.freeboardFileInsert(
                        new FreeBoardfile( fnm, ins.getSubject()+"관련 파일 등록") );
               }
            }
            msg+="\\n 파일 "+fcnt+"건 등록 성공";
         } catch (IllegalStateException e) {
            msg+="\\n 파일 등록 에러 발생:"+e.getMessage();

         } catch (IOException e) {
            msg+="\\n 파일 등록 에러 발생"+e.getMessage();
         } catch(Exception e) {
            msg+="\\n 파일 등록 기타 에러 발생"+e.getMessage();
         }
      }
      System.out.println("메시지:"+msg);


      return msg;
   }
   public FreeBoard detail(int no) {
      dao.uptReadCnt(no);
      FreeBoard dt = dao.getFreeboard(no);
      dt.setFnames(dao.getFiles(no));
      return dt;
   }

   public FreeBoard getfreeBoard(int no) {
      return dao.getFreeboard(no);
   }
   public List<String> getFiles(int no){
      return dao.getFiles(no);
   }
   public int uptReadCnt(int no) {
      return dao.uptReadCnt(no);
   }

   public int updateFreeboard(int no, String writer, String subject, String content) {
        return dao.updateFreeboard(no, writer, subject, content);
    }
   public int deleteFreeboard(int no, String writer) {
        return dao.deleteFreeboard(no, writer);
    }   

}
