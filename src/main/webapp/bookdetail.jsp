<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <style>
        #kuan{
            width:400px;
        }
        .textare{
            float: left;
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


<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="images">
                <img src="img/logo.jpg" width="250" height="70"/>
            </div>
        </div>
        <div class="">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="search.jsp">搜索</a>
                    <%--<form action="" method="post" class="navbar-form" role="search">--%>
                        <%--<div class="form-group">--%>
                            <%--<input type="text" class="form-control" value="" placeholder="Search"  />--%>
                        <%--</div>--%>
                        <%--<button type="submit" class="btn btn-default">检索</button>--%>
                    <%--</form>--%>
                </li>
                <li class="alert">
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
                <li class="alert">
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
                <li class="active"><a href="#">登录系统</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="contrainer panel panel-collapse">
    <div class="panel-heading">
        <div class="row-fluid">
            <div class=" col-lg-1"><a href="javascript:loadBorrow()">图书借阅</a></div>
            <div class="col-lg-1"><a href="javascript:0" id="lib">馆藏信息</a></div>
            <div class=" col-lg-1"><a href="javascript:showInfo()" >详细内容</a></div>
            <div class="col-lg-1"><a href="javascript:0" id="comm">评论标签</a></div>
            <div class="col-lg-1"><a href="">其他信息</a></div>
            <div class="col-lg-1"><a href="">虚拟书架</a></div>
            <%--<input type="text" value="${reader.readerId}">--%>
        </div>
    </div>
    <div class="panel-body" id="bod">
        <div><P>图书名：${msg.bookName}</P></div>
        <div><p>书刊号：${msg.bookPeriodicals}</p></div>
        <div><p>索书号:${msg.bookCallnum}</p></div>
        <div><p>图书作者：${msg.bookWriter}</p></div>
        <div><p>图书信息：${msg.bookInfo}</p></div>
    </div>

</div>


<script>


    $(document).on('click', '#sub',function() {
        var idis=${reader.readerId};
        var pinglun=$("textarea[name='say']").val();
        var data = "readerId="+idis+"&say="+pinglun+ "&bookId="+${msg.bookId};
        $.ajax({
            "url":'api/bookcomment/insert',
            "data":data,
            "type":'post',
            "dataType":"json",
            "success":function (result) {
                if(result==1){
                    alert("评论成功")
                }else {
                    alert("评论失败")
                };
            },
        })


    });

    $("#comm").click(function () {
        $.ajax({
            type:'get',
            url: 'api/bookcomment/select'+'?bookId='+${msg.bookId},
            dataType: "json",
            success: function(data){
                loadComm(data);
            }
        })
    })
    function loadComm(data){
        // alert(data)
        // alert(JSON.stringify(data))直接将数据弹出来
        if (data!=null) {
            var html='';
            $.each(data,function (i, item) {
                // html+='<p>'+item.readerName+':'+item.comment+'</p>';
                html+='<label>'+item.readerName+':</label>'+item.comment+item.updateTime +'</br>';
                html+='<hr>';
                // html+='<p>'+item.updateTime+'</p>';
            })
        }
        $("#bod").html(html);
    }



    $("#lib").click(function (){
        // alert("测试一下")
        $.ajax({
            type:'get',
            url:'api/library/select'+'?libraryId='+${msg.libraryId},
            dataType:"json",
            success: function(data){
                loadOne(data);
            }
        })
    })

    function loadOne(data) {
        // alert("测试代码")
        var html='';
        html+='<div class="col-lg-12 panel-body">';
        html+='<p>图书馆地址：'+data.libraryLocation+'</p>'
        html+='</div>'
        $("#bod").html(html);
    }




    function  showInfo() {
        var html='';
        html+='<div class="container"> '
        html+='<table class="table table-hover">'
        html+='<thead>';
        html+='<tr>';
        html+='<th id="kuan"><h1>图书详情展示</h1></th>';
        html+='</tr>';
        html+='</thead>';
        html+='<tbody>';
        html+='<tr>';
        html+='<th>图书名字：</th>';
        html+='<th>${msg.bookName}</th>';
        html+='</tr>'
        html+='<tr>';
        html+='<th>图书刊号：</th>';
        html+='<th>${msg.bookPeriodicals}</th>';
        html+='</tr>'
        html+='<tr>';
        html+='<th>图书索书号：</th>';
        html+='<th>${msg.bookCallnum}</th>';
        html+='</tr>'
        html+='<tr>';
        html+='<th><p>图书作者：</th>';
        html+='<th>${msg.bookWriter}</th>';
        html+='</tr>'
        html+='<tr>';
        html+='<th>图书馆：</th>';
        html+='<th>${msg.bookPress}</th>';
        html+='</tr>'
        html+='<tr>';
        html+='<th>图书信息：</th>';
        html+='<th>${msg.bookInfo}</th>';
        html+='</tr>'
        html+='</tbody>'
        html+='</table>'
        html+='</div>'
        html+='<form class="col-md-offset-2 textare" id="myform">';
        html+='<p>说点什么...</p>'
        html+='<textarea name="say" rows="3" cols="150" class="t"></textarea>';
        html+='<button class="btn btn-primary col-lg-1 col-lg-offset-9 form-group" id="sub" type="button">确定</button>';
        html+='</form>'

        $("#bod").html(html);
    }
    function reserve() {
        location.href="/api/reserve/borrowBook?bookId="+${msg.bookId};
    }


    function dateFtt(fmt,date)
    { //author: meizz
        var o = {
            "M+" : date.getMonth()+1,                 //月份
            "d+" : date.getDate(),                    //日
            "h+" : date.getHours(),                   //小时
            "m+" : date.getMinutes(),                 //分
            "s+" : date.getSeconds(),                 //秒
            "q+" : Math.floor((date.getMonth()+3)/3), //季度
            "S"  : date.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }

    // 密码修改
    $("#upPwd").click(function () {
        // alert("111111")
        $.ajax({
            type:'get',
            url:'api/readermanagement/upPassword',
            data:$("#pass").serialize(),
            dataType:'json',
            success:function (data) {
                if(data.code==1){
                    alert(data.msg)
                    window.location.href="login.jsp";
                }else {
                    alert(data.msg)
                }
            }
        })
    })

    // 我的借阅记录
    $("#borrowBook").click(function () {
        alert("借阅记录")
        $.ajax({
            type:'get',
            url:'api/books/record/borrow'+'?bookId='+$("#readerId").val(),
            success:function (data) {
                alert(data)
                loadRecordInfo(data)
            }
        })
    })
    // 我的已还记录
    $("#repayBook").click(function () {
        alert("归还记录")
        $.ajax({
            type:'get',
            url:'api/books/record/repay'+'?bookId='+$("#readerId").val(),
            success:function (data) {
                alert(data)
                loadRecordInfo(data)
            }
        })
    })
    // 图书借阅
    function loadBorrow() {
        var bookId=${msg.bookId}
        $.ajax({
            type:'get',
            url:'api/books/borrow'+'?bookId='+bookId+'&readerId='+$("#readerId").val(),
            success:function (data) {
                alert(data.msg)
            }
        })
    }

</script>

</body>
</html>
