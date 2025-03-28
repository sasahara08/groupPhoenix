<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<header>
		<h1>
			<a href="${pageContext.request.contextPath}/AdminTop" class="logo">Phoenix管理画面</a>
		</h1>

		<c:if test="${not empty admin}">
			<div class="adminName">管理者名 : ${admin.name}</div>
		</c:if>

		<button type="button" class="logout-button" onclick="location.href='${pageContext.request.contextPath}/adminLogout'">ログアウト</button>


	</header>
