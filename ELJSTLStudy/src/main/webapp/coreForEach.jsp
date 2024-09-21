<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>좋아하는 음식 선택 (다중 선택 가능)</h3>
	<form>
		<ul>
			<li>
				<label for="pizza">피자</label>
				<input type="checkbox" name="food" value="피자" id="pizza" />
			</li>
			<li>
				<label for="hamburger">햄버거</label>
				<input type="checkbox" name="food" value="햄버거" id="hamburger" />
			</li>
			<li>
				<label for="samgupsal">삼겹살</label>
				<input type="checkbox" name="food" value="삼겹살" id="samgupsal" />
			</li>
			<li>
				<label for="gukbab">국밥</label>
				<input type="checkbox" name="food" value="국밥" id="gukbab" />
			</li>
			<li>
				<label for="zzolmeon">쫄면</label>
				<input type="checkbox" name="food" value="쫄면" id="zzolmeon" />
			</li>
		</ul>
		<input type="submit" value="제출" />
	</form>
	
	<hr/>
	<!-- 일반적인 for문 방식 -->
	<c:if test="${!empty paramValues.food }">
		<h2>당신이 선택한 음식들</h2>
		<ul>
		<c:forEach begin="0" end="5" step="1" var="i">
			<c:if test="${!empty paramValues.food[i] }">
				<li>${ paramValues.food[i] }</li>
			</c:if>
		</c:forEach>
		</ul>
	</c:if>
	
	<hr/>
	<!-- Enhanced for문 방식 -->
	<c:if test="${!empty paramValues.food }">
		<ul>
		<c:forEach var="oneFood" items="${ paramValues.food }">
			<li>${ oneFood }</li>
		</c:forEach>
		</ul>
	</c:if>
</body>
</html>