<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bond</title>
<link rel="stylesheet" type="text/css" href="/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/resources/css/user.css">
<script type="text/javascript" src="/resources/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="/resources/js/colorClass.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">
	$(document).ready(function(){
		$('#home').click(function(){
			$(location).attr('href', '/main.bond');
		});
		
		$('#login').click(function(){
			$(location).attr('href', '/member/login.bond');
		});
		
		$('#logout').click(function(){
			$(location).attr('href', '/member/logoutProc.bond');
		});
		$('#join').click(function(){
			$(location).attr('href', '/member/join.bond');
		});
		$('#wbtn').click(function(){
			alert("응애");
		});
	});
</script>
</head>
<body>
	<div class="w3-content mxw600 w3-center">
		<h1 class="w3-col w3-pale-green w3-center w3-padding w3-card-4 w3-round-large">Bond 방명록</h1>
		<div class="w3-col">
			<div class="w3-blue-gray w3-btn w3-left w3-small" id="home">처음화면</div>
<c:if test="${empty SID }"><!-- 로그인 안한 경우 -->
			<div class="w3-light-gray w3-btn w3-right w3-small" id="login">로그인</div>
			<div class="w3-light-blue w3-btn w3-right w3-small" id="join">회원가입</div>
</c:if>
<c:if test="${not empty SID }"><!-- 로그인한경우 -->
			<div class="w3-pale-red w3-btn w3-left w3-small" id="logout">로그아웃</div>
	<c:if test="${CNT ne 1}">
			<div class="w3-pale-blue w3-btn w3-right w3-small" id="wbtn">글작성</div>
	</c:if>
</c:if>
		</div>
		<div class="w3-col">
<c:forEach var="DATA" items="${LIST }">
			<div class="w3-col w3-card-4 mgt10">
				<div class="w3-left w3-padding "> ${DATA.gno} | ${DATA.id} | ${DATA.sdate} | ${DATA.body}</div>	
			</div>
</c:forEach>
		</div>
	</div>
</body>
</html>