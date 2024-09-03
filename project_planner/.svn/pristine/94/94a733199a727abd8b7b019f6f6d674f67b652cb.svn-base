<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style>
.h2 {
   width: 50%;
   border-radius: 10px;
   text-align: center;
   padding: 10px;
   margin: 50px auto 100px;
   box-shadow: 2px 4px 6px gray;
   background: #4E73DF
}

.content {
   border: 3px dotted black;
   width: 80%;
   border-radius: 20px;
   padding: 30px;
   margin: auto;
   height: 600px;
   background: #F4F4F4;
}
.input01 {
   border: none;
   background: #F4F4F4;
   font-size:20px;
}
.div01 {
   border: 2px solid black;
   border-radius: 10px;
   box-shadow: 1px 2px 2px grey;
   margin: 10px;
   padding: 20px;
   background: #F4F4F4;
   font-weight: bold;
}
.table01 {
   border: 2px solid black;
   border-radius: 10px;
   box-shadow: 1px 2px 2px grey;
   margin: 10px;
   padding: 20px;
   background: #F4F4F4;
   width:98%;
   height:auto;
}
.th01{
   border: 2px solid black;
   border-radius: 10px;
   box-shadow: 1px 2px 2px grey;
}
th, td{
   border:2px solid black;
   border-radius: 10px;
   box-shadow: 1px 2px 2px grey;
   text-align:center;
   padding:5px;
}
.Btn01 {
   background:#4E73DF;
   float: right;
   border-radius: 10px;
   margin-right:10px;
   font-size:20px;
}
.Btn01:hover {
   box-shadow: 2px 2px 2px grey;
}
li{
   list-style-type: none;
   display:inline;
   }
li>a{
   border:2px solid black;
   border-radius:10px;
   text-decoration: none;
   color:black;
   font-size:15px;
   float:right;
   margin:10px;
   padding:5px;
   background:#4E73DF;
}
li>a:hover{
box-shadow: 2px 2px 2px grey;
}
input:focus {
  outline: none;
}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
   src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
   type="text/javascript"></script>
<script type="text/javascript">
   $(document).ready(function() {
      $("#regBtn").click(function() {
         location.href = "freeBoardInsertFrm"
      })
   });
</script>
</head>

<body>
   <div class="jumbotron text-center">
      <h2 class="h2">자유게시판</h2>

   </div>
   <%-- 
      
--%>
   <div class="content">
      <form id="frm01" class="form" method="post">
         <nav class="div01">
            <input placeholder="제목" name="subject" value="${sch.subject }" class="input01" /> 
            <input placeholder="작성자" name="writer" value="${sch.writer }" class="input01" />
            <button class="Btn01" type="submit">Search</button>
            <button class="Btn01" id="regBtn" type="button">Regist</button>

         </nav>
         <input type="hidden" name="curPage" value="${sch.curPage}" />
      </form>
      <table class="table01">
         <col width="10%">
         <col width="50%">
         <col width="15%">
         <col width="15%">
         <col width="10%">
         <thead>
            <tr>
               <th class="th01">번호</th>
               <th class="th01">제목</th>
               <th class="th01">작성자</th>
               <th class="th01">작성일</th>
               <th class="th01">조회수</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="fd" items="${flist}">
               <tr ondblclick="goDetail(${fd.no})">
                  <td class="td01">${fd.cnt}</td>

                  <td><c:forEach begin="2" end="${fd.level}">
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </c:forEach> ${fd.subject}</td>
                  <td>${fd.writer}</td>
                  <td><fmt:formatDate value="${fd.regdte}" /></td>
                  <td>${fd.readcnt}</td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      <script type="text/javascript">
         function goDetail(no) {
            location.href = "freeBoardDetail?no=" + no
         }
      </script>
      <ul class="pagination justify-content-end">
    <!-- Previous Button -->
    <li class="page-item ${sch.curPage <= 1 ? 'disabled' : ''}">
        <a class="page-link" href="javascript:goPage(${sch.curPage - 1})">Previous</a>
    </li>

    <!-- Page Numbers -->
    <c:forEach var="pCnt" begin="${sch.startBlock}" end="${sch.endBlock}">
        <li class="page-item ${sch.curPage == pCnt ? 'active' : ''}">
            <a class="page-link" href="javascript:goPage(${pCnt})">${pCnt}</a>
        </li>
    </c:forEach>

    <!-- Next Button -->
    <li class="page-item ${sch.curPage >= sch.endBlock ? 'disabled' : ''}">
        <a class="page-link" href="javascript:goPage(${sch.curPage + 1})">Next</a>
    </li>
</ul>
      <script type="text/javascript">
      function goPage(pCnt) {
    	    if (pCnt < 1 || pCnt > ${sch.endBlock}) return; // 페이지 범위 검증
    	    $("[name=curPage]").val(pCnt); // 클릭한 페이지 번호를 설정
    	    $("form").submit(); // 폼 제출
    	}
      </script>
   </div>
</body>
</html>