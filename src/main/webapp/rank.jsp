<%--
  Created by IntelliJ IDEA.
  User: 10253
  Date: 2019/1/21
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>搜索结果</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.css"/>
    <style>
        .info{
            height:198px;
            overflow : hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
        }
        .tuijian{
            margin-top: 5px;
            margin-bottom: 20px;
        }
        .tupian2{
            width: 160px;
            height: 200px;
        }
        .top{
            font-size: 4em;
            font-family: 楷体;
            color: #0f9ae0;
            margin:20px 0 0 20px ;
        }
        .num{
            font-size: 1em;
            color: #0f9ae0;
            margin:0;
        }
        .top-1{
            color:#f54545;
        }
        .top-2{
            color:#ff8547;
        }
        .top-3{
            color:#ffac38;
        }
    </style>
</head>
<body>

<!-- 修改信息模态框 -->
<div class="modal animated fadeInUp" id="info">
    <form class="form-horizontal" id="readerInfo">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4>读者信息</h4>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">姓名</label>
                    <div class="col-sm-9">
                        <input name="readerName" disabled="disabled" class="form-control" value="${reader.readerName}">
                    </div>
                </div>


                <div class="form-group">
                    <label  class="control-label col-sm-2">手机号</label>
                    <div class="col-sm-9">
                        <input name="readerPhone" disabled="disabled" class="form-control" value="${reader.readerPhone}">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="control-label col-sm-2">邮箱</label>
                    <div class="col-sm-9">
                        <input name="readerEmail" disabled="disabled" class="form-control" value="${reader.readerEmail}">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="control-label col-sm-2">账户余额</label>
                    <div class="col-sm-9">
                        <input name="readerBalance" disabled="disabled" class="form-control" value="${reader.readerBalance}">
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" data-dismiss="modal" id="readerInf" >确认</button>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- 信息模态框 -->

<!-- 修改密码模态框 -->
<div class="modal animated fadeInUp" id="upPassword">
    <form class="form-horizontal" id="pass">
        <input type="hidden" name="readerPhone" value="${reader.readerPhone}"/>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">&times;</button>
                    <h4>修改密码</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2">原密码</label>
                        <div class="col-sm-9">
                            <input name="readerPassword" type="password" class="form-control" required>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label  class="control-label col-sm-2">新密码</label>
                        <div class="col-sm-9">
                            <input name="readerPassword1" type="password" class="form-control" >
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label  class="control-label col-sm-2">请再次输入新密码</label>
                        <div class="col-sm-9">
                            <input name="readerPassword2" id="rPwd" type="password" class="form-control" >
                            <span id="d3"></span>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-default" data-dismiss="modal">取消</button>
                    <button class="btn btn-primary" data-dismiss="modal" id="upPwd" >确认修改</button>
                </div>
            </div>
        </div>
    </form>
</div>

<!-- 读者登陆模态框 -->
<%--<form action="api/books/selectById">--%>
<%--<input type="text" name="bookId" placeholder="请输入bookid"><br>--%>
<%--<button type="submit">查询</button>--%>
<%--</form>--%>

<!-- 修改密码模态框 -->

<!--导航栏-->
<nav class="navbar navbar-default col-md-12" style="background: none">
    <div class="container-fluid">
        <!--logo-->
        <div class="navbar-header col-sm-2 ">
            <a href="index.jsp" class="navbar-header ">
                <img src="img/logo.jpg">
            </a>
        </div>

        <%--<!--搜索框-->--%>
        <%--<div class="btn-group col-md-4 col-md-offset-1 col-sm-8 ver2 ">--%>

            <%--<div class="input-group input-group-md ">--%>
                <%--<input type="text " class="form-control " placeholder="请输入索书号、书名、作者等 " id="content"/>--%>
                <%--<span class="input-group-btn ">--%>
            <%--<button class="btn btn-primary " id="select">检索</button>--%>
        <%--</span>--%>
            <%--</div>--%>
        <%--</div>--%>

        <!--用户信息-->
        <form class="btn-group col-md-4 col-sm-4 ver col-md-offset-1 ">
            <ul class="nav navbar-nav navbar-right ">
                <%--<li><a href=" " id="borrowBook">我的借阅</a></li>--%>
                <li class="ver1 ">
                    <div class="dropdown">
							<span data-toggle="dropdown">
                                我的借阅
								<span class="caret"></span>
							</span>
                        <ul class="dropdown-menu">
                            <li><a href="#" id="borrowBook">已借阅</a></li>
                            <li><a href="#" id="repayBook">已归还</a></li>
                        </ul>
                    </div>
                </li>

                <li class="ver1 ">
						<span id=" ">
							消息
							<span class="badge">18</span>
						</span>
                <li class="ver1 ">
                    <div class="dropdown ">
							<span data-toggle="dropdown">
                                <input type="hidden" id="readerId" value="${reader.readerId}">
								${reader.readerName}
								<span class="caret"></span>
							</span>
                        <ul class="dropdown-menu">
                            <li><a href="person.jsp">个人中心</a></li>
                            <li><a href="" data-toggle="modal" data-target="#info">个人资料</a></li>
                            <li><a href="" data-toggle="modal" data-target="#upPassword">修改密码</a></li>
                            <li class="divider"></li>
                            <li><a href="../../login.jsp" id="outReader">注销账户</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>


<div class="container-fluid" id="cont">
    <h3 class="" style="margin-left: 45%;">---借阅排行榜---</h3>
    <div id="bod1">
    </div>
</div>


<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script src="js/defaults-zh_CN.min.js"></script>
<script src="js/rank.js"></script>
<script>
    // 图书借阅排行榜
    $.ajax({
        type:'get',
        url:'api/books/borrowtop',
        success:function (data) {
            if(data.code == 1){
                var html = '';
                $.each(data.result,function (i,item) {
                    html+='<div class="col-md-12">';
                    html+='<div class="col-md-1">';
                    html+='<p class="top top-'+(i+1)+'">'+(i+1)+'</p>'
                    html+='<p class="num top-'+(i+1)+'">'+"借阅次数："+item.bookBorrow+'</p>';
                    html+='</div>';
                    html+='<div class="col-md-11 tuijian">';
                    html+='<div class="col-md-2">';
                    html+='<a href="javascript:load('+item.bookId+')">';
                    html+='<img class="tupian2"src="/api/books/findBookCover?id='+item.bookId+'"/>';
                    html+='</a>'
                    html+='</div>';
                    html+='<div class="col-md-10 info">';
                    html+='<a href="javascript:load('+item.bookId+')">';
                    html+='<h3>'+item.bookName+'</h3>';
                    html+='</a>'
                    html+='<p>'+item.bookWriter+'</p>';
                    html+='<p>'+item.bookPress+'</p>';
                    html+='<p>'+item.bookInfo+'</p>';
                    html+='</div>';
                    html+='</div>';
                    html+='</div>';
                });
                html+='<div style="clear: both;"></div>';
                $("#bod1").html(html);
            }
        }
    });
    //显示图书的详细信息
    function load(bookId) {
        location.href="/api/books/selectById?bookId="+bookId;
    }
    //手机号验证
    $('#phone').on('blur',function(){
        var html;
        if(!(( /^1[34578]\d{9}$/).test(this.value))){
            $('#d1').html('电话号码格式输入错误');
            return false;
        }else{
            $('#d1').remove();
        }
    });
    //密码验证
    $('#password').on('blur',function(){
        var html;
        if(!((/^[a-z0-9]{6,18}$/).test(this.value))){
            $('#d2').html('密码为6~18位字母或数字');
            return false;
        }else{
            $('#d2').remove();
        }
    });
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
