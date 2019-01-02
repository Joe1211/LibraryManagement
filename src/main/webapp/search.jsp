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
    <a href=" " class="navbar-header ">
        <img src="img/logo.jpg">
    </a>
</div>

<!--搜索框-->
<div class="btn-group col-md-4 col-sm-8 ver2 ">

    <div class="input-group input-group-md ">
        <input type="text " class="form-control " placeholder="请输入索书号、书名、作者等 " id="content"/>
        <span class="input-group-btn ">
            <button class="btn btn-primary " id="select">检索</button>
        </span>
    </div>
</div>

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


<div class="container-fluid">
    <!--左侧区域 -->
    <div class="row col-md-3 ">
        <h3>按类型检索</h3>
        <!--本部类-->
        <select name="type0" id="type0" class="form-group form-control">
        </select>

        <!--一级类目-->
        <select name="type1" id="type1" class="form-group form-control">
        </select>

        <!--二级类目-->
        <select name="type2" id="type2" class="form-group form-control">
        </select>

        <button type="button" id="selectType" class="btn btn-info col-md-12 col-xs-12">检索</button>

    </div>

    <!--右侧区域-->
    <div class="row col-md-9 left_1 ">

        <!--标签-->
        <div class="form-group ">
            <label for=" " class="col-md-2 control-label input-group ">选择你喜欢的标签</label>
            <div class="col-md-10 input-group ">
                <form>
                    <div class="checkbox right_1" id="lab">

                    </div>
                    <button type="button" class="btn btn-primary " id="labelsubmit">检索</button>
                </form>
            </div>
        </div>

        <%--图书信息--%>
        <div id="bod">
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