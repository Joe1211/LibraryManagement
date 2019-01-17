<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html style="height: 100%">
<head>
    <meta charset="utf-8"/>
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.css"/>
    <%--<script src="js/pccs.js" type="text/javascript"></script>--%>
</head>
<body style="height: 100%">
<div style="height:100% ">
    <!--导航栏-->
    <nav class="navbar navbar-default col-md-12" style="background: none">
        <div class="container-fluid">
            <!--logo-->
            <div class="navbar-header col-sm-2 ">
                <a href="index.jsp" class="navbar-header ">
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


    <div class="container-fluid " style="height: calc(100% - 55px);">
        <!--左侧区域 -->
        <div class="row col-md-3 ">
            <div class="list-group">
                <a href="#" class="list-group-item disabled">
                    个人主页
                </a>
                <a href="xinxi.jsp" target="showiframe" class="list-group-item">基本信息</a>
                <a href="updata.jsp" target="showiframe" class="list-group-item">修改密码</a>
                <a href="borrow.jsp" target="showiframe" class="list-group-item">我的借阅</a>
                <a href="repay.jsp" target="showiframe" class="list-group-item">已还图书</a>
            </div>
        </div>

        <!--右侧区域-->
        <div class="row col-md-9 left_1 " style="height: calc(100% - 55px);">
            <%--图书信息--%>

            <div id="bod" style="height: calc(100% - 55px);">
                <iframe src="xinxi.jsp" width="100%" height="100%" frameborder="0" name="showiframe"></iframe>
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