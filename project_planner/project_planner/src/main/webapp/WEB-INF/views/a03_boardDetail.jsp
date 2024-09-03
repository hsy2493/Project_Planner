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
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var msg = "${msg}"
		if(msg!=""){
			alert(msg)  // 등록 성공 alert()로딩 : 모델 데이터를 받아서..
			var proc = "${proc}"
			if(proc == 'del'){
				location.href="boardList.do"
			}
				
		}
	});
</script>
</head>
<body>
<div class="jumbotron text-center">
  <h2>게시물 상세</h2>
</div>
<%--
			번호			상위번호
			제목
			작성자        조회수
			등록일        수정일
			내용
			
			첨부파일		
 --%>
<div class="container">
	<form method="post" enctype="multipart/form-data">
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">번호</span>
		</div>
		<input type="number" name="no" class="form-control" value="${board.no}" readonly/>
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">상위번호</span>
		</div>
		<input type="number" name="refno" class="form-control" value="${board.refno}"  readonly/>
		
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">제목</span>
		</div>
		<input type="text" name="subject" class="form-control" value="${board.subject}" />
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">작성자</span>
		</div>
		<input name="writer" class="form-control" value="${board.writer}" />	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">조회수</span>
		</div>
		<input class="form-control" value="${board.readcnt}" readonly/>			
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">등록일</span>
		</div>
		<input class="form-control" value="<fmt:formatDate value='${board.regdte}'/>" />	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">수정일</span>
		</div>
		<input class="form-control" value="<fmt:formatDate value='${board.uptdte}'/>" >			
	</div>		
	<div class="input-group mb-3">	
		<div class="input-group-prepend">
			<span class="input-group-text  justify-content-center">내용</span>
		</div>
		<textarea name="content" rows="10" class="form-control" >${board.content}</textarea>
	</div>	
	<div class="input-group mb-3">	
		<div class="input-group-prepend">
			<span class="input-group-text  justify-content-center">첨부파일</span>
		</div>
		<c:forEach var="fname" items="${board.fnames}">
			<a href="javascript:download('${fname}')">${fname}</a>,&nbsp;&nbsp;
		</c:forEach>
		<script>
		function download(fname){
			if(confirm(fname+"다운로드 하시겠습니까?")){
				location.href="downLoad.do?fname="+fname
			}
		}
		
		</script>
		<%--
		<input type="file"  name="reports" multiple="multiple" class="form-control" value="" />	
		 --%>
	</div>	
	<div style="text-align:right;">
			<input type="button" class="btn btn-info" value="수정" id="uptBtn"/>
			<input type="button" class="btn btn-danger" value="삭제" id="delBtn"/>
			<input type="button" class="btn btn-success" value="답글" id="repBtn"/>
			<input type="button" class="btn btn-secondary" value="초기화" id="initBtn" />
			<input type="button" class="btn btn-primary" value="메인화면" id="mainBtn"/>
	</div>	
	</form>	
	<script type="text/javascript">
		$("#repBtn").click(function(){
			if(confirm("답글을 등록하시겠습니까?")){
				// 답글 form 요청값을 변경해서 ==> 입력 form으로 전달 처리..
				$("[name=refno]").val($("[name=no]").val())
				$("[name=subject]").val("RE:"+$("[name=subject]").val())
				$("[name=content]").val(
					"\n\n\n\n=== 이전글 ===\n"+$("[name=content]").val()	
				)
				$("form").attr("action","boardInsertFrm.do")
				$("form").submit()
				
				
				
			}
			
		})
		$("#initBtn").click(function(){
			$("form")[0].reset()
		})	
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				// boardUpdate.do boardDelete.do
				$("form").attr("action","boardUpdate.do");
				$("form").submit()
			}
		})
		$("#delBtn").click(function(){
			location.href="boardDelete.do?no="+$("[name=no]").val();
		})		
		$("#mainBtn").click(function(){
			location.href="boardList.do"
		})
	
	</script>
</div>	
</body>
</html>