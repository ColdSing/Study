<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/validate_mark.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/validate/jquery.validate.min.js" type="text/javascript"></script>
<script src="js/validate/messages_zh.js" type="text/javascript"></script>
<script src="js/validate/validate_self.js" type="text/javascript"></script>
<script type="text/javascript">
	function changeImg(){
		document.getElementById("check").setAttribute("src","/${pageContext.request.contextPath }/checkImg?"+(new Date()));
	}
	
	
	 $(function(){

            //让当前表单调用validate方法，实现表单验证功能
            $("#registForm").validate({
                debug:false, //调试模式，即使验证成功也不会跳转到目标页面
                rules:{     //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
                    username:{
                        required:true,  //必填。如果验证方法不需要参数，则配置为true
                        rangelength:[4,12],
                        remote:{
                            url:"${pageContext.request.contextPath }/ajaxCheckUsername",
                            type:"post"
                        }
                    },
                    password:{
                        required:true,
                        rangelength:[6,16]
                    },
                    confirmpwd:{
                        required:true,
                        equalTo:'#password' //表示和id="spass"的值相同
                    },
                    name:{
                        required:true
                    },
                    birthdate:{
                        required:true,
                        dateISO:true
                    },
                    checkCode:{
                        required:true,
                    },
                    email:{
                        required:true,
                        email:true
                    }
                },
                messages:{
                    username:{
                        required:"请输入用户名",
                        rangelength:$.validator.format("用户名长度为{0}-{1}个字符"),
                        remote:"该用户名已存在！"
                    },
                    password:{
                        required:"请输入密码",
                        rangelength:$.validator.format("密码长度为{0}-{1}个字符")
                    },
                    confirmpwd:{
                        required:"请再次输入密码",
                        equalTo:"两次密码必须一致" //表示和id="spass"的值相同
                    },
                    name:{
                        required:"请输入姓名"
                    },
                    birthdate:{
                        required:"请输入生日！",
                        dateISO:"请按2009-06-23格式输入"
                    },
                    checkCode:{
                        required:"请输入验证码",
                    },
                    email:{
                        required:"请填写邮件",
                        email:"邮箱格式不正确"
                    }
                }
            });
        });
</script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>

	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>

	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>会员注册</font>USER REGISTER
				<form  id="registForm" class="form-horizontal" style="margin-top: 5px;" method="post" action="${pageContext.request.contextPath }/regist">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名" tip="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="请输入密码" tip="password">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="confirmpwd"
								placeholder="请输入确认密码" tip="">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputEmail3" name="email"
								placeholder="Email" tip="">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="usercaption" name="name"
								placeholder="请输入姓名" tip="">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio1" value="male">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="inlineRadio2" value="femal">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" name="birthdate" tip="">
						</div>
					</div>

					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">验证码</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="checkCode" tip="">

						</div>
						<div class="col-sm-2" >
							<img src="${pageContext.request.contextPath }/checkImg" id="check" onclick="changeImg()"/>
						</div>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" 
								style="background: url('./images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>




