<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<center>
		<h1>로그인</h1><hr>
		<form action="login_proc.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">ID</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">PW</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인"/>
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>