<!-- �α��� ���μ��� ����/���� -->

<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="booksysapp1.MemberMgr"/>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = request.getParameter("id");
	  String password = request.getParameter("password");
	  String url = "login.jsp";
	  String msg = "�α��ο� ���� �Ͽ����ϴ�.";
	  
	  boolean result = mMgr.loginMember(id,password);
	  if(result){
	    session.setAttribute("idKey",id);
	    msg = "�α��ο� ���� �Ͽ����ϴ�.";
	    url = "booking.jsp";
	  }
%>
<script>
	alert("<%=msg%>");	
	location.href="<%=url%>"
</script>