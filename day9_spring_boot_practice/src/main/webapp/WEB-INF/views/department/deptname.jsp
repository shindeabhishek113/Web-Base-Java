<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Dept Names</h1>

<form method=post>
		<table style="background-color: lightgrey; margin: auto">
			<caption>All Department Names</caption>

			<tr>
				<td>Choose Department</td>

				<td><select name="dept_name">
						<c:forEach var="deptNm" items="${requestScope.deptname}">
							<option value="${deptNm}">${deptNm}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
			<td><input type="submit" value="Choose A Department"/></td>
			</tr>

		</table>
	</form>
</body>
</html>