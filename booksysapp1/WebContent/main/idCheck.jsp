<!-- ID �ߺ�üũ �� -->

<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="booksysapp1.MemberMgr" />
<%
	request.setCharacterEncoding("EUC-KR");
	String id = request.getParameter("id");
	boolean result = mMgr.checkId(id);
%>
<html>
<head>
<title>ID �ߺ�üũ</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
		<br/><b><%=id%></b>
		<%
			if (result) {
				out.println("�̹� �����ϴ� ID �Դϴ�.<p/>");
			} else {
				out.println("��� ������ ID �Դϴ�.<p/>");
			}
		%>
		<a href="#" onClick="self.close()">�ݱ�</a>
	</div>
</body>
</html>