<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/score.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/lq-score.js"></script>

    <style>
        #kuan {
            width: 400px;
        }

        .textare {
            float: left;
        }

        .tupian2 {
            width: 256px;
            height: 320px;
        }

        .icon {
            width: 20px;
            height: 20px;
        }

        .distance {
            margin-bottom: 10px;
        }
        #score{
            hight:20px;
            line-height: 20px;
        }
        div.lq-score{
            float: left;
        }
        #score-tip{
            padding: 0 8px;
            float: left;
        }
        .lq-score-tip{
            margin: 0px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="images">
                <a href="search.jsp">
                    <img src="img/logo.jpg" width="250" height="70"/>
                </a>
            </div>
        </div>
        <div class="">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="search.jsp">搜索</a>
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
            </ul>
        </div>
    </div>
</nav>
<div class="contrainer panel panel-collapse">

    <div class="panel-body">
        <%--图书详情--%>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">图书详情</div>
                <div class="panel-body">

                    <div class="col-md-3">
                        <img src="/api/books/findBookCover?id=${msg.bookId}" class="tupian2"/>
                    </div>
                    <div class="col-md-8">
                        <h3>&nbsp&nbsp&nbsp${msg.bookName}</h3>
                        <input type="hidden" class="bid" value=${msg.bookId}>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/rate.png" alt="" class="icon">
                            </div>
                            <div class="col-md-11">
                                <div id="score" style="float:left;">
                                    <div id="rate">
                                    </div>
                                    <div id="score-tip">
                                        <span id="tip1" class="lq-score-tip"></span>&nbsp;&nbsp;<span id="scoreNum"></span>
                                    </div>
                                </div>
                                <div style="clear:both;"></div>
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/writer.png" alt="" class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookWriter}
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/press.png" alt="" class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookPress}
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/callnum.png" alt="" class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookCallnum}
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/info.png" alt="" class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookInfo}
                            </div>
                        </div>
                        <div class="col-md-2 col-lg-offset-10">
                            <a href="javascript:loadBorrow()">
                                <button class="btn btn-primary form-group" type="button">图书借阅</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--图书详情--%>
        <%--评论--%>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">图书评论</div>
                <div class="panel-body">
                    <div id="bod2">

                    </div>
                    <div id="bod">

                    </div>
                    <div id="bod1">

                    </div>
                </div>
            </div>
        </div>
        <%--评论--%>
    </div>
</div>


<script>
    window.onload = function () {
        //评论
        $.ajax({
            type: 'get',
            url: 'api/books/likesort' + '?bookId=' + $(".bid").val(),
            success: function (data) {
                if(data.code == 1 ){
                    // alert(data)
                    var html = '';
                    $.each(data.result,function (i,item) {
                        html+='<div class="col-md-12 distance">';
                        html+=' <div>';
                        html+=''+item.readerName+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                        // html+='<input class="hidden" id="bclid" value="'+item.id+'">'
                        html+=''+item.updateTime+'';
                        html+='  </div>';
                        html+=' <p>';
                        html+=''+item.comment+'';
                        html+='</p>';
                        if(item.status==1){
                            //已点赞
                            html+='<div style="height:16px;line-height: 16px;"><a href="javascript:void(0)" data-islike="true" onclick="likeToggle(this,'+item.id+')"><img src="img/icon/like.png" style="width:16px;height: 16px;"/></a>';
                        }else{
                            //未点赞
                            html+='<div style="height:16px;line-height: 16px;"><a href="javascript:void(0)" data-islike="false" onclick="likeToggle(this,'+item.id+')"><img src="img/icon/nolike.png" style="width:16px;height: 16px;"/></a>';
                        }
                        html+='&nbsp;&nbsp;<span>'+item.likeCount+'</span></div><hr style="margin:5px 0 5px 0">';
                        html+='</div>';
                    })
                    html+="最新评论"
                    // alert(html);
                    $("#bod2").html(html);
                }else{
                    $("#bod").html("该书还没有评论！");
                }
            }
        })
        $.ajax({
            type: 'get',
            url: 'api/books/comments' + '?bookId=' + $(".bid").val(),
            success: function (data) {
                if(data.code == 1 ){
                    loadInfo(data);
                }else{
                    $("#bod").html("该书还没有评论！");
                }
            }
        })

        $.ajax({
            type:"get",
            url:"api/bookScore/getBookScoreVO",
            data:{bookId:${msg.bookId}},
            success:function(data){
                if(data!=null&&data.code==1){
                    var result=data.result.scoreAvg.toFixed(1);
                    $("#rate").lqScore({
                        $tipEle:$("#tip1"),
                        fontsize:"17px",
                        zeroTip: result+"分",
                        tips:[result+"分",result+"分",result+"分",result+"分",result+"分"],
                        score:result,
                        isScoreFinish:true
                    });
                    $("#scoreNum").html("共"+data.result.scoreNum+"人评价");
                }else{
                    $("#rate").lqScore({
                        $tipEle:$("#tip1"),
                        fontsize:"17px",
                        zeroTip: "暂无评分",
                        score:0,
                        isScoreFinish: true
                    });
                }
            }
        });
    }

    function  loadInfo(data) {
        var html = '';
        $.each(data.result.list,function (i,item) {
            html+='<div class="col-md-12 distance">';
            html+=' <div>';
            html+=''+item.readerName+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
            html+='<input class="hidden" id="bclid" value="'+item.id+'">'
            html+=''+item.updateTime+'';
            html+='  </div>';
            html+=' <p>';
            html+=''+item.comment+'';
            html+='</p>';
            if(item.status==1){
                //已点赞
                html+='<div style="height:16px;line-height: 16px;"><a href="javascript:void(0)" data-islike="true" onclick="likeToggle(this,'+item.id+')"><img src="img/icon/like.png" style="width:16px;height: 16px;"/></a>';
            }else{
                //未点赞
                html+='<div style="height:16px;line-height: 16px;"><a href="javascript:void(0)" data-islike="false" onclick="likeToggle(this,'+item.id+')"><img src="img/icon/nolike.png" style="width:16px;height: 16px;"/></a>';
            }
            html+='&nbsp;&nbsp;<span>'+item.likeCount+'</span></div><hr style="margin:5px 0 5px 0">';
            html+='</div>';
        })

        $("#bod").append(html);
        var html =  '';
        // 下一页
        //是否有下一页
        if (test = data.result.hasNextPage) {
            html+='<li><a href="javascript:loadData('+(data.result.pageNum+1)+')">'+"查看更多"+'</a></li>';
        }else{
            html+='<li><a href="javascript:void(0))">'+"到底了"+'</a></li>';
        }
        $("#bod1").html(html);
    }

    //点赞切换
    function likeToggle(obj,commentId){
        if(obj.dataset.islike=="true"){
            //取消点赞
            $.ajax({
                type:"post",
                dataType:"json",
                url:"api/bookcomment/deletelike?id="+commentId,
                success:function(data){
                    if(data!=null&&data.code==1){
                        obj.getElementsByTagName("img")[0].src="img/icon/nolike.png";
                        obj.parentElement.getElementsByTagName("span")[0].innerText=Number(obj.parentElement.getElementsByTagName("span")[0].innerText)-1;
                        obj.dataset.islike="false";
                    }
                },
                error:function(){
                    console.log("服务器错误");
                }
            });
        }else{
            //点赞
            $.ajax({
                type:"post",
                dataType:"json",
                url:"api/bookcomment/like?id="+commentId,
                success:function(data){
                    if(data!=null&&data.code==1){
                        obj.getElementsByTagName("img")[0].src="img/icon/like.png";
                        obj.parentElement.getElementsByTagName("span")[0].innerText=Number(obj.parentElement.getElementsByTagName("span")[0].innerText)+1;
                        obj.dataset.islike="true";
                    }
                },
                error:function(){
                    console.log("服务器错误");
                }
            });
        }
    }


    // 评论查询加载分页
    function loadData(page) {
        $.ajax({
            type: 'get',
            url: 'api/books/comments' + '?bookId=' + $(".bid").val() + '&pn=' + page,
            dataType: 'json',
            success: function (data) {
                loadInfo(data);
            }
        })
    }

    function loadFindComm(){
        $.ajax({
            type: 'get',
            url: 'api/bookcomment/select' + '?bookId=' +${msg.bookId},
            dataType: "json",
            success: function (data) {
                loadComm(data);
            }
        })
    }

    function loadComm(data) {
        // alert(data)
        // alert(JSON.stringify(data))直接将数据弹出来
        if (data != null) {
            var html = '';
            $.each(data, function (i, item) {
                html += '<div class="col-md-12 distance">'
                html += '<div class="col-md-2">'
                html += '' + item.readerName + ':</br>'
                html += '' + item.updateTime + ''
                html += '</div>'
                html += '<div class="col-md-10">'
                html += '' + item.comment + ''
                html += '</div>'
                html += '</div>'
            })
        }
        $("#bod").html(html);
    }


    $("#lib").click(function () {
        // alert("测试一下")
        $.ajax({
            type: 'get',
            url: 'api/library/select' + '?libraryId=' +${msg.libraryId},
            dataType: "json",
            success: function (data) {
                loadOne(data);
            }
        })
    })

    function loadOne(data) {
        // alert("测试代码")
        var html = '';
        html += '<div class="col-lg-12 panel-body">';
        html += '<p>图书馆地址：' + data.libraryLocation + '</p>'
        html += '</div>'
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

</script>

</body>
</html>
