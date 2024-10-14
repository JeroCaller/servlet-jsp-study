<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String baseUrl = "/MVCPatternStudy/products.do";
%>
<ul>
	<li>
		<form method="post" action="<%=baseUrl%>">
			<input type="hidden" name="category" value="food"/>
			<button type="submit">먹을 거리</button>
		</form>
	</li>
	<li>
		<form method="post" action="<%=baseUrl%>">
			<input type="hidden" name="category" value="cloth"/>
			<button type="submit">의류</button>
		</form>
	</li>
	<li>
		<form method="post" action="<%=baseUrl%>">
			<input type="hidden" name="category" value="sundries"/>
			<button type="submit">잡화</button>
		</form>
	</li>
</ul>
