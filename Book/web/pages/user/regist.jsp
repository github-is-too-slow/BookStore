<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
	<%--静态包含base标签、css文件、js文件--%>
	<%@include file="/pages/common/header.jsp"%>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}
	</style>
	<script>
		$(function () {
		    $("#username").blur(function () {
				var username = this.value;
				$.getJSON("${basePath}" + "user", "action=existsUsername&username=" + username, function (msg) {
					if(msg.existsUsername){
                        $(".errorMsg").text("用户名已存在");
					}else{
                        $(".errorMsg").text("用户名可用");
					}
                });
            });
            $("#sub_btn").click(function () {
                //1.检查用户名
                var username = $("#username").val();
                var regexp = /\w{5,12}/;
                if(!regexp.test(username)){
                    $(".errorMsg").text("用户名不合法");
                    return false;
                }
                //2.检查密码
                var password = $("#password").val();
                if(!regexp.test(password)){
                    $(".errorMsg").text("密码不合法");
                    return false;
                }
                //3.检查确认密码
                var repwd = $("#repwd").val();
                if(password !== repwd){
                    $(".errorMsg").text("确认密码与密码不一致");
                    return false;
                }
                //4.检查电子邮箱
                var email = $("#email").val();
                regexp = /^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/;
                if(!regexp.test(email)){
                    $(".errorMsg").text("邮箱格式不合法");
                    return false;
                }
                //5.检查验证码
                var code = $.trim($("#code").val());
                if(null == code || code === ""){
                    $(".errorMsg").text("验证码不能为空");
                    return false;
                }
                $(".errorMsg").text("");
            });
            $("#codeImg").click(function () {
				this.src = "${basePath}kaptcha.jpg?d=" + new Date().getMilliseconds();
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
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%--<%=request.getAttribute("msg") == null? "": request.getAttribute("msg")%>--%>
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="/bookStore/user" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text"
										   placeholder="请输入用户名" autocomplete="off"
										   tabindex="1" name="username" id="username"
											value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password"
										   placeholder="请输入密码" autocomplete="off"
										   tabindex="1" name="password" id="password"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password"
										   placeholder="确认密码" autocomplete="off"
										   tabindex="1" name="repwd" id="repwd"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text"
										   placeholder="请输入邮箱地址" autocomplete="off"
										   tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
									<img alt="" src="${basePath}kaptcha.jpg" id="codeImg"
										 style="float: right; margin-right: 40px; width: 110px; height: 35px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
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