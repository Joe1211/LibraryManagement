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
                    <form action="" method="post" class="navbar-form" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" value="" placeholder="Search"  />
                        </div>
                        <button type="submit" class="btn btn-default">检索</button>
                    </form>
                </li>
                <li class="alert"><p>匿名用户</p></li>
                <li class="active"><a href="https://www.baidu.com/">我的借阅详情</a></li>
                <li class="active"><a href="#">登录系统</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="contrainer panel panel-collapse">
    <div class="panel-heading">
        <div class="row-fluid">
            <div class=" col-lg-1"><a href="javascript:reserve()" id="res">预约请求</a></div>
            <div class="col-lg-1"><a href="javascript:0" id="lib">馆藏信息</a></div>
            <div class=" col-lg-1"><a href="javascript:showInfo()" >详细内容</a></div>
            <div class="col-lg-1"><a href="javascript:0" id="comm">评论标签</a></div>
            <div class="col-lg-1"><a href="">其他信息</a></div>
            <div class="col-lg-1"><a href="">虚拟书架</a></div>
        </div>
    </div>
    <div class="panel-body" id="bod">
        <%--${msg}--%>
        ${reser}
        <%--${libr.libraryLocation}--%>
    </div>

</div>
<script>


    $(document).on('click', '#sub',function() {
        var pinglun=$("textarea[name='say']").val();
        var data = "readerId="+1+"&say="+pinglun+ "&bookId="+${msg.bookId};
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

</script>

</body>
</html>
