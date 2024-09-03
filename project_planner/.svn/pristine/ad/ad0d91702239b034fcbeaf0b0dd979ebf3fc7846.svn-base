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
	background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
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

.div01 {
	border: 2px solid black;
	border-radius: 10px;
	width: 28%;
	box-shadow: 1px 2px 2px grey;
	margin: 10px;
	padding: 5px;
	background: #F4F4F4;
	display: inline-block;
	font-weight: bold;
}

.input01 {
	border: none;
	background: #F4F4F4;
}

input:focus {
	outline: none;
}

.Btn01 {
	background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
	float: right;
	margin: 10px;
	border-radius: 10px;
	font-size: 20px;
}

.Btn02 {
	background: linear-gradient(to top right, #63B6D9, #C2E8FF);
	float: right;
	margin: 10px;
	border-radius: 10px;
	font-size: 20px;
}

.Btn03 {
	background: linear-gradient(to top right, #FB3F32, #FFE1DF);
	float: right;
	margin: 10px;
	border-radius: 10px;
	font-size: 20px;
}

.Btn04 {
	position: relative;
	bottom: 80px;
	background: linear-gradient(to top right, #FB3F32, #FFE1DF);
	float: right;
	margin: 10px;
	border-radius: 10px;
	font-size: 20px;
}

.Btn01:hover {
	box-shadow: 2px 2px 2px grey;
}

.Btn02:hover {
	box-shadow: 2px 2px 2px grey;
}

.Btn03:hover {
	box-shadow: 2px 2px 2px grey;
}

.replyh2 {
	border: 2px solid black;
	border-radius: 20px;
	padding: 15px;
	margin: 30px 85px;
	width: 5%;
	text-align: center;
}

.replycontent {
	border: 2px dotted black;
	border-radius: 20px;
	width: 85%;
	margin: 30px auto 30px;
	padding: 15px;
	height: auto;
}

.formdiv {
	border: 1px solid black;
	border-radius: 20px;
	width: 86%;
	margin: 20px auto 20px;
	padding: 15px;
}

.repBtn {
	background: linear-gradient(to top right, #63B6D9, #C2E8FF);
	margin: 10px;
	border-radius: 10px;
	font-size: 20px;
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

</head>
<body>
	<div class="">
		<h2 class="h2">게시글 상세</h2>
	</div>

	<div class="content">
		<form id="mainForm" method="post" enctype="multipart/form-data">
			<div class="">
				<div class="div01">
					<span>번호 : </span> <input type="number" name="no" class="input01"
						value="${freeBoard.no}" readonly />
				</div>
				<div class="div01">
					<span class="">상위번호 : </span> <input type="number" name="refno"
						class="input01" value="${freeBoard.refno}" readonly />
				</div>
				<div class="div01">
					<span class="">첨부파일 : </span>
				</div>
				<c:forEach var="fname" items="${freeBoard.fnames}">
					<a href="javascript:download('${fname}')">${fname}</a>,&nbsp;&nbsp;
		</c:forEach>
				<script>
					function download(fname) {
						if (confirm(fname + "다운로드 하시겠습니까?")) {
							location.href = "downLoad?fname=" + fname
						}
					}
				</script>
			</div>
			<div class="">
				<div class="div01">
					<span class="">조회수 : </span> <input class="input01"
						value="${freeBoard.readcnt}" readonly />
				</div>
				<div class="div01">
					<span class="">등록일 : </span> <input class="input01"
						value="<fmt:formatDate value='${freeBoard.regdte}'/>" />
				</div>
				<div class="div01">
					<span class="">수정일 : </span> <input class="input01"
						value="<fmt:formatDate value='${freeBoard.uptdte}'/>">
				</div>
			</div>
			<div class="">
				<div class="div01">
					<span class="">내용</span>
				</div>
				<div class="div01">
					<span class="">제목 : </span> <input type="text" name="subject"
						class="input01" value="${freeBoard.subject}" />
				</div>
				<div class="div01">
					<span class="">작성자 : </span> <input name="writer" class="input01"
						value="${freeBoard.writer}" readonly/>
				</div>
			</div>
			<div class="">
				<textarea name="content" rows="20" cols="135" class="div01"
					style="width: 92%">${freeBoard.content}</textarea>
			</div>
			<div class=""></div>
			<div style="text-align: right;">
			<c:if test="${writer == freeBoard.writer}">
				<input type="button" class="Btn02" value="수정" id="uptBtn" style="margin-right: 50px;" /> 
				<input type="button" class="Btn03" value="삭제" id="delBtn" /> 
			</c:if>		
					<input type="button" class="Btn01" value="답글" id="repBtn" /> 
					<input type="button" class="Btn01" value="초기화" id="initBtn" /> 
					<input type="button" class="Btn01" value="메인화면" id="mainBtn" />
			</div>
		</form>
		<script type="text/javascript">
		$("#repBtn").click(function() {
		    if (confirm("답글을 등록하시겠습니까?")) {
		        // 답글 form 요청값을 변경해서 ==> 입력 form으로 전달 처리..
		        $("#mainForm [name=refno]").val($("#mainForm [name=no]").val());
		        $("#mainForm [name=subject]").val("RE:" + $("#mainForm [name=subject]").val());
		        $("#mainForm [name=content]").val("\n\n\n\n=== 이전글 ===\n" + $("#mainForm [name=content]").val());
		        $("#mainForm").attr("action", "freeBoardInsertFrm");
		        $("#mainForm").submit();
		    }
		});
			$("#initBtn").click(function() {
				$("form")[0].reset()
			})
			$("#uptBtn").click(function() {
				if (confirm("수정하시겠습니까?")) {
					$("#mainForm").attr("action", "freeBoardUpdate");
					$("#mainForm").submit();
				}
			});
			$("#delBtn").click(function() {
				if (confirm("삭제하시겠습니까?")) {
				location.href = "freeBoardDelete?no=" + $("[name=no]").val();
				}
			})
			$("#mainBtn").click(function() {
				location.href = "freeBoardList"
			})
		</script>
	</div>

	<div class="reply">
		<h2 class="replyh2">댓글</h2>
	</div>

	<c:choose>
		<c:when test="${not empty rlist}">
    		<c:forEach var="rpl" items="${rlist}">
        		<div class="replycontent">
            		<span>게시글 번호 : ${rpl.no} // 아이디 : ${rpl.replyid} // 등록일 : 
                	<fmt:formatDate value="${rpl.regdte}" pattern="yyyy-MM-dd" />
            		</span>
            		<p>${rpl.content}</p>
            	<c:if test="${sessionScope.writer == rpl.replyid}">
            	<input type="button" class="Btn04 rpldelBtn" value="삭제"
                data-replyid="${rpl.replyid}" data-replyno="${rpl.replyno}" />
                </c:if>
        		</div>
    		</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="replycontent">
				<p>댓글이 없습니다.</p>
			</div>
		</c:otherwise>
	</c:choose>

	<form action="replyInsert" method="post" id="subForm">
		<div class="formdiv">

			<div class="div01">
				<span style="font-size: 20px;">no : </span> 
				<input name="no" value="${freeBoard.no}" class="input01"/>
			</div>
			<div class="div01">
				<span style="font-size: 20px;">replyid : </span> 
				<input name="replyid" placeholder="" class="input01" value="${writer}" readonly/>
			</div>
			<div class="div01">
				<span style="font-size: 20px;">내용 : </span> <input type="text"
					name="content" placeholder="내용" class="input01" />
			</div>

			<input type="submit" value="댓글작성" class="repBtn" id="replyBtn" />
		</div>
	</form>
	<script type="text/javascript">
        $(document).ready(function() {
            var msg = "${msg}";
            if (msg != "") {
                alert(msg); // Display the alert with the message
                var proc = "${proc}";
                if (proc == 'del') {
                    location.href = "freeBoardList";
                }
                var proc2 = "${proc2}";
                if (proc2 == 'suc') {
                    alert("댓글이 추가되었습니다.");
                }
            }

            $("#replyBtn").click(function(event) {
                event.preventDefault();
                var formData = $("#subForm").serialize();

                $.ajax({
                    type: "POST",
                    url: "replyInsert",
                    data: formData,
                    success: function(response) {
                        alert("댓글이 추가되었습니다.");
                        location.reload();
                    },
                    error: function(xhr, status, error) {
                        alert("댓글 추가에 실패했습니다.");
                    }
                });
            });

            $(document).on('click', '.rpldelBtn', function() {
                var replyid = $(this).data('replyid');
                var replyno = $(this).data('replyno'); // 댓글 번호 추가

                if (confirm("댓글을 삭제하시겠습니까?")) {
                    $.ajax({
                        type: "POST", // DELETE 메소드 사용 권장
                        url: "replyDelete", // 서버에 맞는 URL
                        data: { replyid: replyid, replyno: replyno },
                        success: function(response) {
                            alert("댓글이 삭제되었습니다.");
                            location.reload(); // 페이지 새로고침
                        },
                        error: function(xhr, status, error) {
                            alert("댓글 삭제에 실패했습니다.");
                        }
                    });
                }
            });
       alert("${writer}")
        });
       
    </script>
</body>
</html>