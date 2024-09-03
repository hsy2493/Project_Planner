<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#regBtn").click(function(){
			location.href="boardInsertFrm.do"
		})
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>게시판</h2>

</div>
<%-- 
		
--%>
<div class="container">
	<form id="frm01" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input placeholder="제목" name="subject" value="${sch.subject }"  class="form-control mr-sm-2" />
	    <input placeholder="작성자"  name="writer"  value="${sch.writer }"  class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="submit">Search</button>
	    <button class="btn btn-success" id="regBtn"
	        type="button">등록</button>
	        
 	</nav>
 		<input type="hidden" name="curPage" value="${sch.curPage}"/>
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
      </tr>
    </thead>	
    <tbody>
    	<c:forEach var="bd" items="${blist}">
    	<tr ondblclick="goDetail(${bd.no})"><td>${bd.cnt}</td>
    	
    	<td class="text-left" >
    		<c:forEach begin="2" end="${bd.level}">
    			&nbsp;&nbsp;&nbsp;
    		</c:forEach>
    		${bd.subject}</td><td>${bd.writer}</td>
    	<td><fmt:formatDate value="${bd.regdte}"/></td>
    	<td>${bd.readcnt}</td></tr>
    	</c:forEach>
    </tbody>
	</table>    
	<script type="text/javascript">
		function goDetail(no){
			location.href="boardDetail.do?no="+no
		}
	</script>
	<ul class="pagination justify-content-end">
	  <li class="page-item"><a class="page-link" href="javascript:goPage(${sch.startBlock-1})">Previous</a></li>
	  <c:forEach var="pCnt" begin="${sch.startBlock}" 
	  						end="${sch.endBlock}">
	  <li class="page-item ${sch.curPage==pCnt?'active':''}">
	  	<a class="page-link" href="javascript:goPage(${pCnt})">${pCnt}</a></li>
	  </c:forEach>
	  <li class="page-item"><a class="page-link" href="javascript:goPage(${sch.endBlock+1})">Next</a></li>
	</ul>	
	<script type="text/javascript">
		function goPage(pCnt){
			$("[name=curPage]").val(pCnt)  // 클릭한 것을 현제 페이지 번호로 전송.. 페이지가 이동 처리.
			$("form").submit()
			
		}
	</script>
</div>
</body>
</html>