<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		private String somethingToSay = null;
	
		public String getSay() {
			return somethingToSay;
		}
		
		public void setSay(String say) {
			somethingToSay = say;
		}
	%>
	
	<p>하고 싶은 말 설정 전: <%= getSay() %> </p>
	
	<%
		setSay("안녕하세요. hi. 123");
	%>
	
	<p>하고 싶은 말 설정 후: <%= getSay() %> </p>

</body>
</html>