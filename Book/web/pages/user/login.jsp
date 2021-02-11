<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
	<%--静态包含base标签、css文件、js文件--%>
	<%@include file="/pages/common/header.jsp"%>
<script>
	$(function () {
		$("#sub_btn").click(function () {
			//1.判断用户名是否合法
			var username = $("#username").val();
			var regExp = /\w{5,12}/;
			if(!regExp.test(username)){
			    $(".errorMsg").text("用户名格式不合法");
			    return false;
            }

            //2.判断密码是否合法
			var password = $("#password").val();
			if(!regExp.test(password)){
                $(".errorMsg").text("密码格式不合法");
                return false;
			}
            $(".errorMsg").text("");
        });
    });
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg") == null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
									${empty requestScope.msg? "请输入用户名和密码": requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="/bookStore/user" method="post">
									<input type="hidden" name="action" value="login"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
											value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含尾部信息--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>