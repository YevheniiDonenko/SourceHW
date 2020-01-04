<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.btn {
    display: inline-block;
    vertical-align: top;
    padding: 14px 40px;

    border-radius: 2px;
    border: 0;
    cursor: pointer;

    font-family: inherit;
    font-size: 13px;
    color: #fff;
    font-weight: 600;
    text-transform: uppercase;
    text-decoration: none;
    text-align: center;
    transition: background .1 linear;
}

.btn--red {
    background-color: #e84545;
}
.btn--red:hover {
    background-color: #dd3434;
}
.btn--long {
    min-width:280px;
}
</style>
<meta charset="utf-8">
<title>Login page</title>
</head>
<body>


	<div align="center">
		<h1>login</h1>
	</div>
	<div align="center" style="padding-top: 20px">
		<form action="login" method="post">
			<p>
				<input type="text" placeholder="Your login" name="login" />
			</p>
			<p>
				<input type="password" placeholder="Your password" name="password" />
			</p>
			<p>
				<input class="btn btn--red btn--long" type="submit" value="Send" />
			</p>

		</form>
	</div>
</body>
</html>
