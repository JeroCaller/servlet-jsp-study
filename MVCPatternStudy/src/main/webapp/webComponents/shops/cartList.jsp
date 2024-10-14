<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Item"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Item> items = (ArrayList<Item>) session.getAttribute("items");
%>
<!-- Presentation Logic -->
<h3>장바구니</h3>
<table border="1">
	<tr>
		<th>상품명</th>
		<th>수량</th>
		<th>총 가격</th>
	</tr>
	<%
		if (items != null) {
			for (Item oneItem : items) {
	%>
		<tr>
			<td><%=oneItem.getProductName()%></td>
			<td><%=oneItem.getEa()%></td>
			<td><%=oneItem.getPrice()%></td>
		</tr>
	<%
			}
		}
	%>
</table>