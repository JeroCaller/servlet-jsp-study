<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Item"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JeroCaller's Online Shopping mall</title>
<link rel="stylesheet" href="/MVCPatternStudy/css/header.css">
<link rel="stylesheet" href="/MVCPatternStudy/css/style.css">
</head>
<body>
	<%-- 
		// 사용자 요청을 받음. 
		request.setCharacterEncoding("utf-8");
	--%>
	<jsp:include page="/webComponents/header.jsp"/>
	<div id="container">
		<!-- 
			왼쪽 사이드바. 카테고리 메뉴. 
			각 카테고리에 맞는 물품들이 나오도록 한다. 
		-->
		<aside>
			<jsp:include page="/webComponents/shops/shopCategory.jsp"/>
		</aside>
		
		<!-- 
			메인. 물품 목록들이 나오며, 사용자가 특정 물품을 선택하여 
			장바구니에 등록할 수 있도록 한다. 
		-->
		<main>
			<jsp:include page="/webComponents/shops/productList.jsp"/>
		</main>
		
		<!-- 오른쪽 사이드바. 사용자의 장바구니 목록 보이기 -->
		<aside>
			<jsp:include page="/webComponents/shops/cartList.jsp"/>
		</aside>
	</div>
	
	<jsp:include page="/webComponents/footer.jsp"/>
</body>
</html>