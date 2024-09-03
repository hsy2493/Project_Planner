<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Free Board</title>
    <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
</head>
<body>
    <div id="wrapper">
        <%@ include file="a02_sliderBar.jsp" %>
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <%@ include file="a03_topBar.jsp" %>
                <div class="container-fluid">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center mb-4">
                                            <h2 class="h2 text-gray-900">자유게시판</h2>
                                        </div>
                                        <form id="frm01" class="form" method="post">
                                            <nav class="navbar navbar-light bg-light mb-4 p-3">
                                                <input placeholder="제목" name="subject" value="${sch.subject }" class="form-control mr-2" />
                                                <input placeholder="작성자" name="writer" value="${sch.writer }" class="form-control mr-2" />
                                                <button class="btn btn-primary" type="submit" style="margin-top:10px;">Search</button>
                                                <button class="btn btn-secondary" id="regBtn" type="button" style="margin-top:10px;">Regist</button>
                                            </nav>
                                            <input type="hidden" name="curPage" value="${sch.curPage}" />
                                        </form>
                                        <div class="table-responsive">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>번호</th>
                                                        <th>제목</th>
                                                        <th>작성자</th>
                                                        <th>작성일</th>
                                                        <th>조회수</th>
                                                    </tr>
                                                </thead>
                                                <tbody style="cursor:pointer;">
                                                    <c:forEach var="fd" items="${flist}">
                                                        <tr ondblclick="goDetail(${fd.no})">
                                                            <td>${fd.cnt}</td>
                                                            <td>${fd.subject}</td>
                                                            <td>${fd.writer}</td>
                                                            <td><fmt:formatDate value="${fd.regdte}" pattern="yyyy-MM-dd" /></td>
                                                            <td>${fd.readcnt}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
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
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
    <script src="${path}/a00_com/jquery-ui.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#regBtn").click(function() {
                location.href = "freeBoardInsertFrm"
            })
        
            <c:if test="${not empty noResults}">
            alert("검색 결과가 없습니다.");
        </c:if>
            
    		});
        function goDetail(no) {
            location.href = "freeBoardDetail?no=" + no
        }
            
        function goPage(pCnt) {
            if (pCnt < 1 || pCnt > ${sch.endBlock}) return; // 페이지 범위 검증
            $("[name=curPage]").val(pCnt); // 클릭한 페이지 번호를 설정
            $("form").submit(); // 폼 제출
        }
        
        
    </script>

</body>
</html>
