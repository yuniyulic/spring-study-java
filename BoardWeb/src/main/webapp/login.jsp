<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login</title>
</head>
<body>
	<center>
		<h1>로그인</h1><hr>
		<form action="login.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">ID</td>
					<td><input type="text" name="id" value="${user.id}"/></td>
				</tr>
				<tr>
					<td bgcolor="orange">PW</td>
					<td><input type="password" name="password" value="${user.password }"/></td>
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