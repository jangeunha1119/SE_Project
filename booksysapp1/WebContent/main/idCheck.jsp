<!-- ID 중복체크 폼 -->

<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="booksysapp1.MemberMgr" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkId(id);
%>
<html>
<head>
<title>ID 중복체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
		<br/><b><%=id%></b>
		<%
			if (result) {
				out.println("이미 존재하는 ID 입니다.<p/>");
			} else {
				out.println("사용 가능한 ID 입니다.<p/>");
			}
		%>
		<a href="#" onClick="self.close()">닫기</a>
	</div>
</body>
</html>