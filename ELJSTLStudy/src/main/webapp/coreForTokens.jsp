<%@page import="java.util.StringTokenizer"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<select name="book">
			<option value="default">
				선택
			</option>
			<option value="코딩 잘하는법/김큐엘/23000원">
				코딩잘하는법/김큐엘/23000원
			</option>
			<option value="날계란과 삶은 계란 구분법/정디비/8000원">
				날계란과 삶은 계란 구분법/정디비/8000원
			</option>
			<option value="맨홀 뚜껑이 정사각형이 아닌 원 형태인 이유/자바스/7000원">
				맨홀 뚜껑이 정사각형이 아닌 원 형태인 이유/자바스/7000원
			</option>
		</select>
		<input type="submit" value="구매" />
	</form>
	
	<% request.setCharacterEncoding("utf-8"); %>
	<table border="1">
		<tr>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
		</tr>
		<c:if test="${!empty param.book and param.book ne 'default' }">
			<tr>
				<c:forTokens items="${ param.book }" delims="/" var="token">
						<td>${ token }</td>
				</c:forTokens>
			</tr>
		</c:if>
	</table>
	
	<hr/>
	
	<!-- script tag 방식 -->
	<table border="1">
		<tr>
			<th>제목</th>
			<th>저자</th>
			<th>가격</th>
		</tr>
		<%
			String bookInfo = request.getParameter("book");
			
			if (bookInfo != null && !bookInfo.equals("default")) {
		%>
				<tr>
		<%
				StringTokenizer tokens = new StringTokenizer(bookInfo, "/");
				while(tokens.hasMoreTokens()) {
		%>
					<td><%= tokens.nextToken() %></td>
		<%
				}
		%>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>