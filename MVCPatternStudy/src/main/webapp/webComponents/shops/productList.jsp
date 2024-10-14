<%@page import="java.util.ArrayList"%>
<%@page import="model.db.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<ProductDTO> products 
		= (ArrayList<ProductDTO>) session.getAttribute("products");
%>
<table border="1">
	<tr>
		<th>상품</th>
		<th>가격</th>
		<th>장바구니 추가</th>
	</tr>
	<%
		// presentation logic
		if (products != null) {
			for (ProductDTO item : products) {
	%>
		<tr>
			<form method="post" action="/MVCPatternStudy/cart.do">
				<input 
					type="hidden" 
					name="productName" 
					value="<%= item.getName() %>"
				/>
				<input 
					type="hidden" 
					name="price" 
					value="<%= item.getPrice() %>"
				/>
				<td><%= item.getName() %></td>
				<td><%= item.getPrice() %></td>
				<td><button type="submit">장바구니 추가</button></td>
			</form>
		</tr>
	<%
			}
		}
	%>
</table>