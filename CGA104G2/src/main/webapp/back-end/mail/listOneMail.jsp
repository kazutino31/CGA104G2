<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.mail.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  MailVO mailVO = (MailVO) request.getAttribute("mailVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>住戶郵件資料 - listOneEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneEmp.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>住戶編號</th>
		<th>郵件項目</th>

	</tr>
	<tr>
		<td><%=mailVO.getMemberId()%></td>
		<td><%=mailVO.getMailType()%></td>
	</tr>
</table>

</body>
</html>