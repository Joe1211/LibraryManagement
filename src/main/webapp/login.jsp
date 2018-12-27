<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="css/amazeui.min.css" />
<link rel="stylesheet" href="css/app1.css" />
<style>
	.log{
			top: 100px;
	}
</style>
</head>
<body>
	<div class="am-g am-u-md-6 am-u-md-offset-5 log">
	<!-- LOGO -->
	<div class="am-u-sm-12 am-text-center " >
		 <img src="img/logo.jpg" alt="" />
	</div>
	<!-- 登陆框 -->
	<div class="am-u-sm-11 am-u-md-8  am-u-sm-centered">
	<form class="am-form" method="get" action="api/readermanagement/login">
	<!-- 隐藏域 -->
	  <fieldset class="myapp-login-form am-form-set">
	 	 <!--手机号 -->
		<div class="am-form-group am-form-icon">
			<i class="am-icon-phone"></i>
			<input type="text" name="readerPhone" id="phone" class="myapp-login-input-text am-form-field" required placeholder="请输入您的手机号">
		</div>
		<span id="d1" style="color:red;font-size:13px;"></span>
		<!--密码 -->
	    <div class="am-form-group am-form-icon">
			<i class="am-icon-lock"></i>
			<input type="password" name="readerPassword" id="password" class="myapp-login-input-text am-form-field" required placeholder="至少6个字符">
		</div>
		<span id="d2" style="text-align:right; color:red;font-size:13px;"></span>
	  </fieldset>
	  <button type="submit" class="myapp-login-form-submit am-btn am-btn-primary am-btn-block " id="denglu">登 陆</button>
	</form>
		<div class="form-group text-right">
			<span>还没有账号？立即<a href="#">注册</a></span>
		</div>
	</div>
</div>
	
	
	
	
	
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script>
//手机号验证
$('#phone').on('blur',function(){
	var html;
	if(!(( /^1[34578]\d{9}$/).test(this.value))){ 
    	$('#d1').append('电话号码格式输入错误');
    	return false;
	}else{
		$('#d1').remove();
	}
})
//密码验证
$('#password').on('blur',function(){
	var html;
	if(!((/^[a-z0-9]{6,18}$/).test(this.value))){ 
    	$('#d2').append('密码为6~18位字母或数字');
        $("#denglu").attr("disabled", true);
    	return false;
	}else{
		$('#d2').remove();
        $("#denglu").attr("disabled", false);
	}
})
</script>
</body>
</html>