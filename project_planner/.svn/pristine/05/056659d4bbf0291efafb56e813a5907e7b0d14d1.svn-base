<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="sendMail" /></title>
    <!-- Custom fonts for this template -->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <style>
        body {
            background: #EAEAEA;
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }

        .h2 {
            width: 50%;
            border-radius: 10px;
            text-align: center;
            padding: 10px;
            margin: 10px auto 50px;
            box-shadow: 2px 4px 6px gray;
            background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
        }

        .content {
            border: 3px dotted black;
            width: 90%;
            border-radius: 20px;
            padding: 30px;
            margin: auto;
            height: 600px;
            background: #F4F4F4;
        }

        .div01 {
            border: 2px solid black;
            border-radius: 10px;
            box-shadow: 1px 2px 2px grey;
            margin: 10px;
            padding: 5px;
            background: #F4F4F4;
            font-weight: bold;
        }

        .input01 {
            border: none;
            background: #F4F4F4;
        }

        .Btn01 {
            background: linear-gradient(to top right, #ECB3FF, #B6EAF6);
            float: right;
            margin: 20px;
            border-radius: 10px;
        }

        .Btn01:hover {
            box-shadow: 2px 2px 2px grey;
        }

        .selectLan {
            margin: auto auto 30px 80px;
        }
    </style>
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
    <script src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
    <script src="${path}/a00_com/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue@2"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var msg = "${msg}";
            if (msg !== "") {
                alert(msg);
            }
            $(".MailSch").click(function(){
                location.href = "/z06_emailList.html";
            });
        });
    </script>
</head>
<body>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar">
            <%@ include file="a02_sliderBar.jsp" %>
        </div>

        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Topbar -->
            <div id="topbar">
                <%@ include file="a03_topBar.jsp" %>
            </div>

            <div id="content">
                <div>
                    <h2 class="h2">
                        <fmt:message key="sendMail" />
                    </h2>
                </div>

                <!-- 언어 선택 폼 (GET 방식) -->
                <div>
                    <form method="get" action="mail" class="selectLan">
                        <select name="lang" onchange="this.form.submit()">
                            <option value="ko" ${param.lang == 'ko' ? 'selected' : ''}>한국어</option>
                            <option value="en" ${param.lang == 'en' ? 'selected' : ''}>English</option>
                        </select>
                    </form>
                </div>

                <div class="content">
                    <!-- 메일 발송 폼 -->
                    <form method="post" action="mail">
                        <div class="">
                            <div class="div01">
                                <span class=""><fmt:message key="title" /> : </span>
                                <input type="text" name="title" class="input01" placeholder="<fmt:message key='title'/>" />
                            </div>
                        </div>
                        <div class="">
                            <div class="div01">
                                <span class=""><fmt:message key="receiver" /> :
                                    <button type="button" class="MailSch">사원메일 조회하기</button>
                                </span>
                                <input name="receiver" class="input01" placeholder="<fmt:message key='receiver'/>" />
                            </div>
                        </div>
                        <div class="">
                            <div class="div01">
                                <span class=""><fmt:message key="sender" /> : </span>
                                <input name="sender" class="input01" value="amjunha106@gmail.com" readonly />
                            </div>
                        </div>
                        <div class="">
                            <div class="div01">
                                <span class=""><fmt:message key='content' /></span>
                            </div>
                            <textarea name="content" rows="10" cols="120" class="div01"
                                placeholder="<fmt:message key='content'/>" style="width: 97%"></textarea>
                        </div>
                        <div>
                            <input type="submit" class="Btn01" value="<fmt:message key='send'/>" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
