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
                    <div id="bod">

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
            url: 'api/books/comments' + '?bookId=' + $(".bid").val(),
            success: function (data) {
                loadInfo(data);
            }
        })

        $.ajax({
            type:"get",
            url:"api/bookScore/getBookScoreVO",
            data:{bookId:${msg.bookId}},
            success:function(data){
                if(data!=null&&data.code==1){
                    var result=data.result.score.toFixed(1);
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

    function loadInfo(data) {
        var html = '';
        $.each(data.result.list, function (i, item) {
            html += '<div class="col-md-12 distance">';
            html += ' <div class="col-md-2">';
            html += '' + item.readerName + '</br>';
            html += '' + item.updateTime + '';
            html += '  </div>';
            html += ' <div class="col-md-10">';
            html += '' + item.comment + '';
            html += '</div>';
            html += '</div>';

        })
        html += '当前第' + data.result.pageNum + ' 页.总共' + data.result.pages + '页.一共 ' + data.result.total + ' 条记录'

        html += '<div class="col-md-12">';
        html += '';
        html += '<nav aria-label="Page navigation">';
        html += '  <ul class="pagination">';
        // 上一页
        //是否有上一页
        if (test = data.result.hasPreviousPage) {
            html += '<li><a href="javascript:loadData(' + (data.result.pageNum - 1) + ')">' + "上一页" + '</a></li>';
        } else {
            html += '<li><a href="javascript:void(0))">' + "上一页" + '</a></li>';
        }

        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
        // navigatepageNums所有导航页号
        // pageNum 当前页
        $.each(data.result.navigatepageNums, function (i, n) {
            if (data.result.pageNum == n) {
                html += '<li class="active"><a href="javascript:void(0))">' + n + '</a></li> ';
            } else {
                html += '<li><a href="javascript:loadData(' + n + ')">' + n + '</a></li> ';
            }
        })

        // 下一页
        //是否有下一页
        if (test = data.result.hasNextPage) {
            html += '<li><a href="javascript:loadData(' + (data.result.pageNum + 1) + ')">' + "下一页" + '</a></li>';
        } else {
            html += '<li><a href="javascript:void(0))">' + "下一页" + '</a></li>';
        }

        html += '  </ul>';
        html += '   </nav>';
        html += '  </div>';
        $("#bod").html(html);
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
