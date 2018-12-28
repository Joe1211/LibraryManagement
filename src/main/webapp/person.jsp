<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.css"/>
    <%--<script src="js/pccs.js" type="text/javascript"></script>--%>
</head>
<body>

<!--导航栏-->
<nav class="navbar navbar-default col-md-12" style="background: none">
    <div class="container-fluid">
        <!--logo-->
        <div class="navbar-header col-sm-2 ">
            <a href="search.jsp" class="navbar-header ">
                <img src="img/logo.jpg">
            </a>
        </div>

        <!--搜索框-->

        <!--用户信息-->
        <form class="btn-group col-md-6 col-sm-6 ver col-md-offset-3 ">
            <ul class="nav navbar-nav navbar-right">
                <li class="ver1 ">
                    <div class="dropdown ">
							<span>
                                <input type="hidden" id="readerId" value="${reader.readerId}">
								欢迎，${reader.readerName}
							</span>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>


<div class="container-fluid ">
    <!--左侧区域 -->
    <div class="row col-md-3 ">
        <table class="table table-hover">
            <tr><td><a href="xinxi.jsp" target="showiframe">基本信息</a></td></tr>
            <tr><td><a href="updata.jsp" target="showiframe">修改密码</a></td></tr>
            <tr><td><a href="borrow.jsp" target="showiframe">我的借阅</a></td></tr>
            <tr><td><a href="repay.jsp" target="showiframe">已还图书</a></td></tr>
        </table>
    </div>

    <!--右侧区域-->
    <div class="row col-md-9 left_1 ">
        <%--图书信息--%>
        <div id="bod">
            <iframe src="xinxi.jsp" width="100%" height="600px" frameborder="0" name="showiframe"></iframe>
            <%--<iframe src="updata.jsp" width="100%" height="300px" frameborder="0" name="showiframe1"></iframe>--%>
        </div>
    </div>

</div>
</div>


<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script src="js/defaults-zh_CN.min.js"></script>
<script src="js/search.js"></script>
<script>
    //手机号验证
    $('#phone').on('blur',function(){
        var html;
        if(!(( /^1[34578]\d{9}$/).test(this.value))){
            $('#d1').html('电话号码格式输入错误');
            return false;
        }else{
            $('#d1').remove();
        }
    })
    //密码验证
    $('#password').on('blur',function(){
        var html;
        if(!((/^[a-z0-9]{6,18}$/).test(this.value))){
            $('#d2').html('密码为6~18位字母或数字');
            return false;
        }else{
            $('#d2').remove();
        }
    })
    $('#rPwd').on('blur',function(){
        var html;
        var pwd = $("input[name='readerPassword1']").val();
        var cpwd = $("input[name='readerPassword2']").val();
        if (pwd != cpwd) {
            $("#d3").html("两次密码不一致");
            $("#upPwd").attr("disabled", true);
        }else {
            $('#d3').remove();
            $("#upPwd").attr("disabled", false);
        }
    })

</script>

</body>
</html>