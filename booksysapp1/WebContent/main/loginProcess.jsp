<!-- 로그인 프로세스 성공/실패 -->

<%@ page contentType="text/html; charset=EUC-KR" %>
<jsp:useBean id="mMgr" class="booksysapp1.MemberMgr"/>
<%
	  request.setCharacterEncoding("EUC-KR");
	  String id = request.getParameter("id");
	  String password = request.getParameter("password");
	  String url = "login.jsp";
	  String msg = "로그인에 실패 하였습니다.";
	  
	  boolean result = mMgr.loginMember(id,password);
	  if(result){
	    session.setAttribute("idKey",id);
	    msg = "로그인에 성공 하였습니다.";
	    url = "booking.jsp";
	  }
%>
<script>
	alert("<%=msg%>");	
	location.href="<%=url%>"
</script>