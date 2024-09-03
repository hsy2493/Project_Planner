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
    <title>Free Board Registration</title>
    <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
    <style>
        .h2 {
            width: 50%;
            border-radius: 10px;
            text-align: center;
            padding: 10px;
            margin: auto auto 20px;
            box-shadow: 2px 4px 6px gray;
            background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
            color:black;
        }

        .content {
            border: 3px dotted black;
            width: 100%;
            border-radius: 20px;
            padding: 30px;
            margin: auto;
            background: #F4F4F4;
        }

        .div01 {
            border: 2px solid black;
            border-radius: 10px;
            box-shadow: 1px 2px 2px grey;
            margin: 10px 0;
            padding: 10px;
            background: #F4F4F4;
            font-weight: bold;
        }

        .input01 {
            border: none;
            background: #F4F4F4;
            width: calc(100% - 20px);
            padding: 10px;
        }

        .Btn01 {
            background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
            border: none;
            margin: 10px;
            border-radius: 10px;
            font-size: 16px;
            color: black;
        }

        .Btn01:hover {
            box-shadow: 2px 2px 2px grey;
        }

        textarea {
            border-radius: 10px;
        }
    </style>
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${path}/a00_com/jquery-ui.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var msg = "${msg}";
            if (msg !== "") {
                alert(msg); // 등록 성공 alert()로딩 : 모델 데이터를 받아서..
                $("[name=refno]").val("0");
                $("[name=subject]").val("");
                $("[name=content]").val("");
                location.href = "freeBoardList";
            }

            $("#regBtn").click(function() {
                if (confirm("등록하시겠습니까?")) {
                    $("form").submit();
                }
            });

            $("#mainBtn").click(function() {
                location.href = "freeBoardList";
            });
        });
    </script>
</head>
<body id="page-top">
    <div id="wrapper">
        <!-- Sidebar -->
        <%@ include file="a02_sliderBar.jsp" %>

        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <!-- Topbar -->
                <%@ include file="a03_topBar.jsp" %>

                <div class="container-fluid">
                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <h2 class="h2">자유게시판 글 등록</h2>
                                        <div class="content">
                                            <!-- 게시글 입력 폼 -->
                                            <form action="freeBoardInsert" method="post" enctype="multipart/form-data">
                                                <input type="hidden" name="refno" value="${empty param.refno?'0':param.refno}" />
                                                <!-- 제목 -->
                                                <div class="div01">
                                                    <span>제목 : </span>
                                                    <input type="text" name="subject" class="input01" value="${param.subject}" placeholder="제목입력" />
                                                </div>
                                                <!-- 작성자 -->
                                                <div class="div01">
                                                    <span>작성자 : </span>
                                                    <c:forEach var="user" items="${sessionScope.userList}">
                                                    <input name="writer" class="input01" value="${user.name}" readonly />
                                                    </c:forEach>
                                                </div>
                                                <!-- 내용 -->
                                                <div class="div01">
                                                    <span>내용</span>
                                                    <textarea name="content" rows="10" class="input01" placeholder="내용입력">${param.content}</textarea>
                                                </div>
                                                <!-- 첨부파일 -->
                                                <div class="div01">
                                                    <span>첨부파일 : </span>
                                                    <input type="file" name="reports" multiple class="input01" />
                                                </div>
                                                <div class="text-right mt-3">
                                                    <input type="button" class="Btn01" value="등록" id="regBtn" />
                                                    <input type="button" class="Btn01" value="메인화면" id="mainBtn" />
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
