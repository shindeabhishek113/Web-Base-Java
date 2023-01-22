<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To JSP</h1>
<%
int abhi=20;
int abhi1=25;
int add = abhi+abhi1;
out.write("Additon"+add);
%>

<%=LocalDateTime.now() %>

<%! int c=2000; %>
<%=c %>
</body>
</html>