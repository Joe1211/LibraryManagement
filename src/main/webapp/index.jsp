<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <meta charset="utf-8" />
    <title>搜索结果</title>
    <link rel="shortcut icon" href="img/icon/favicon.ico"/>
    <link rel="bookmark" href="img/icon/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css" />
    <link rel="stylesheet" type="text/css" href="css/custom.css" />
    <style>
        .new-tupian {
            height: 200px;
            width: 360px;
            margin: 5px;
        }

        #cont {
            padding-left: 60px;
            padding-right: 60px;
        }
        #cont1{
            left: 50%;
        }

        #container {
            width: 668px;
            height: 410px;
            position: relative;
            overflow: hidden;
            margin: 5px;
        }

        .item {
            position: absolute;
        }

        #tabs {
            position: absolute;
            right: 350px;
            bottom: 20px;
        }

        .tab {
            float: left;
            margin-right: 10px;
            width: 6px;
            height: 6px;
            border: 3px solid rgba(184, 178, 182, .8);
            border-radius: 50%;
            background: #989196;
            cursor: pointer;
        }

        .active {
            background: #fff;
            border-color: #999497;
        }

        .btn1 {
            position: absolute;
            top: 50%;
            margin-top: -35px;
            width: 40px;
            height: 70px;
            color: #d6d3d5;
            font-size: 36px;
            line-height: 70px;
            text-align: center;
            cursor: pointer;
        }

        .btn:hover {
            background: rgba(127, 120, 125, 0.8);
        }

        .prev {
            position: absolute;
            left: 5px;
            border-radius: 0 5px 5px 0;
        }

        .next {
            position: absolute;
            right: 5px;
            border-radius: 0 5px 5px 0;
            left: 620px;
        }

        .btn-l {
            height: 100px;
            width: 200px;
            margin-right: 20px;
            margin-top: 20px;
            font-size: 30px;
        }
        .tupian2{
            width: 160px;
            height: 200px;
        }
        .tupian3{
            width: 20px;
            height: 20px;
        }
        .tuijian{
            margin-top: 5px;
            margin-bottom: 20px;
        }
        .biaoti{
            margin-top: 540px;
            margin-left: 45%;
        }
        .dibu{
            background-color:#3399CC;
            font-size: 15px;
        }
        .info{
            height:198px;
            overflow : hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
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
                    <label class="control-label col-sm-2">手机号</label>
                    <div class="col-sm-9">
                        <input name="readerPhone" disabled="disabled" class="form-control" value="${reader.readerPhone}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">邮箱</label>
                    <div class="col-sm-9">
                        <input name="readerEmail" disabled="disabled" class="form-control" value="${reader.readerEmail}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">账户余额</label>
                    <div class="col-sm-9">
                        <input name="readerBalance" disabled="disabled" class="form-control" value="${reader.readerBalance}">
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" data-dismiss="modal" id="readerInf">确认</button>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- 信息模态框 -->

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
        <div class="btn-group col-md-1 col-sm-8 col-lg-offset-7 ver2 ">
            <div class="input-group input-group-md ">
                <a href="search.jsp"><button class="btn btn-info ">搜索图书</button></a>
        </span>
            </div>
        </div>

        <!--用户信息-->
        <form class="btn-group col-md-2 col-sm-4 ver ">
            <ul class="nav navbar-nav navbar-right ">
                <li class="ver1 ">
                    <span id=" ">
                        消息
                        <span class="badge">18</span>
                    </span>
                </li>
                <li class="ver1 ">
                    <div class="dropdown ">
									<span data-toggle="dropdown">
                                <input type="hidden" id="readerId" value="${reader.readerId}">
								${reader.readerName}
								<span class="caret"></span>
									</span>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="person.jsp">个人中心</a>
                            </li>
                            <c:if test="${reader.role==2}">
                                <li>
                                    <a href="admin.jsp">管理员页面</a>
                                </li>
                            </c:if>
                            <li>
                                <a href="" data-toggle="modal" data-target="#info">个人资料</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="api/readermanagement/outReader" id="outReader">退出登录</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>

<div class="container-fluid" id="cont">
    <!--左侧区域 -->
    <div class="row col-md-3 ">
        <a href="">
            <%--<img src="" alt="" class="new-tupian" />--%>
            <img src="img/4df0c2da9bccabfb97b7053819a9051e.jpg" alt="" class="new-tupian">
        </a>
        <a href="">
            <img src="img/2c8534267dda2de06f9d8fae01213654.jpeg" alt="" class="new-tupian" />
        </a>
    </div>

    <!--中间区域-->
    <div class="row col-md-6 left_1 ">

        <!--<%--图书信息--%>-->
        <div id="container">
            <a class="item" href="#"><img src="img/b87b3b679af9036e639aefda73b70f60.jpg" /></a>
            <a class="item" href="#"><img src="img/90b6655287a0ba2dde2988dc359b9d3b.jpg" /></a>
            <a class="item" href="#"><img src="img/e55a30eb9b5f21869c1a9fa3a530cb80.jpg" /></a>
            <a class="item" href="#"><img src="img/d61099f9a2a644a19f850026b02ecc9a.jpg" /></a>
            <a class="item" href="#"><img src="img/2c8534267dda2de06f9d8fae01213654.jpeg" /></a>

            <div class="btn1 prev">
                <</div>
            <div class="btn1 next">></div>
            <ul id="tabs">
                <li class="tab active"></li>
                <li class="tab"></li>
                <li class="tab"></li>
                <li class="tab"></li>
                <li class="tab"></li>
            </ul>
        </div>
    </div>

    <!--右侧区域-->
    <div class="row col-md-3 ">
        <a href="">
            <img src="img/cde6c733b25a348ef11026da7995b06b.jpg" alt="" class="new-tupian" />
        </a>
        <a href="">
            <img src="img/31aae3617c9f37a8e3e51e77a69f7d0.jpg" alt="" class="new-tupian" />
        </a>
    </div>

    <!--活动信息-->
    <%--<div class="col-md-12">--%>
        <%--<div class="col-md-2">--%>
            <%--<a class="btn btn-info btn-l" href="#" role="button">--%>
                <%--新闻公告--%>
                <%--<p style="font-size: 15px;">Library News</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
            <%--<a class="btn btn-info btn-l" href="#" role="button">--%>
                <%--服务指南--%>
                <%--<p style="font-size: 15px;">Guidenlines</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
            <%--<a class="btn btn-info btn-l" href="#" role="button">--%>
                <%--在线咨询--%>
                <%--<p style="font-size: 15px;">Online Q&A</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
            <%--<a class="btn btn-info btn-l" href="#" role="button">--%>
                <%--已借图书--%>
                <%--<p style="font-size: 15px;">Borrowed books</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
            <%--<a class="btn btn-info btn-l" href="#" role="button">--%>
                <%--我的活动--%>
                <%--<p style="font-size: 15px;">My activities</p>--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
            <%--<a class="btn btn-info btn-l" href="#" role="button">--%>
                <%--馆藏信息--%>
                <%--<p style="font-size: 15px;">Library Info</p>--%>
            <%--</a>--%>
        <%--</div>--%>
    <%--</div>--%>


    <h3 class="biaoti">---每日推荐---</h3>
    <div id="bod">
    </div>


    <br>
    <h3 class="" style="margin-left: 45%;">---借阅排行榜---</h3>
    <div id="bod1">
    </div>
    <div class="col-md-4 col-lg-offset-9">
        <h3>
            <a href="rank.jsp"><button class="btn-info">查看更多---></button></a>
        </h3>
    </div>

</div>
<!--关于我们-->
<div class="col-md-12 dibu">
    <div class="col-md-3 col-lg-offset-2">
        <h4>交通信息</h4>
        <p>地址：******************</p>
        <p>邮编：200031</p>
        <p>电话：021-34865724</p>
        <p>传真：021-34562345</p>
    </div>
    <div class="col-md-3">
        <h4>开馆时间</h4>
        <p>周一至周日:8:30-20:30</p>
        <p>国家法定假日:9:00-16:00</p>
    </div>
    <div class="col-md-3">
        <h4>关于我们</h4>
        <p>成立时间:********</p>
        <p>小组成员:***********</p>
        <p>技术支持:********</p>
    </div>
    <div class="col-md-8" style="left: 40%;">
        <p>版权所有©万达信息图书馆 2016-2018</p>
    </div>
</div>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script src="js/defaults-zh_CN.min.js"></script>
<script src="js/search.js"></script>
<script>
    window.onload=function(){
        $.ajax({
            type:'get',
            url:'api/books/indexbook',
            success:function (data) {
                if(data.code == 1){
                    var html = '';
                    $.each(data.result,function (i,item) {
                        html+='<div class="col-md-4 tuijian">';
                        html+='<div class="col-md-5">';
                        html+='<a href="javascript:load('+item.bookId+')">';
                        html+='<img class="tupian2"src="/api/books/findBookCover?id='+item.bookId+'"/>';
                        html+='</a>'
                        html+='</div>';
                        html+='<div class="col-md-7 info">';
                        html+='<a href="javascript:load('+item.bookId+')">';
                        html+='<h3>'+item.bookName+'</h3>';
                        html+='</a>'
                        html+='<p>'+item.bookWriter+'</p>';
                        html+='<p>'+item.bookPress+'</p>';
                        html+='<p>'+item.bookInfo+'</p>';
                        html+='</div>';
                        html+='</div>';

                    });
                    html+='<div style="clear: both;"></div>';
                   $("#bod").html(html);
                }
            }
        })
        // 图书借阅排行榜
        $.ajax({
            type:'get',
            url:'api/books/borrowtop?currentPage=1&pageSize=8',
            success:function (data) {
                if(data.code == 1){
                    var html = '';
                    $.each(data.result.list,function (i,item) {
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
        })
    }
    //显示图书的详细信息
    function load(bookId) {
        location.href="/api/books/selectById?bookId="+bookId;
    }
    $(document).ready(function() {
        var i = 0;
        var timer;

        //用jquery方法设置第一张图片显示，其余隐藏
        $('.item').eq(0).show().siblings('.item').hide();

        //调用showTime()函数（轮播函数）
        showTime();

        //当鼠标经过下面的数字时，触发两个事件（鼠标悬停和鼠标离开）
        $('.tab').hover(function() {
            //获取当前i的值，并显示，同时还要清除定时器
            i = $(this).index();
            Show();
            clearInterval(timer);
        }, function() {
            //
            showTime();
        });

        //鼠标点击左侧的箭头
        $('.prev').click(function() {
            clearInterval(timer);
            if(i == 0) {
                i = 5; //注意此时i的值
            }
            i--;
            Show();
            showTime();
        });

        //鼠标点击右侧的箭头
        $('.next').click(function() {
            clearInterval(timer);
            if(i == 4) {
                i = -1; //注意此时i的值
            }
            i++;
            Show();
            showTime();
        });

        //创建一个showTime函数
        function showTime() {
            //定时器
            timer = setInterval(function() {
                //调用一个Show()函数
                Show();
                i++;
                //当图片是最后一张的后面时，设置图片为第一张
                if(i == 5) {
                    i = 0;
                }
            }, 2000);
        }

        //创建一个Show函数
        function Show() {
            //在这里可以用其他jquery的动画
            $('.item').eq(i).fadeIn(300).siblings('.item').fadeOut(300);

            //给.tab创建一个新的Class为其添加一个新的样式，并且要在css代码中设置该样式
            $('.tab').eq(i).addClass('active').siblings('.tab').removeClass('active');

        }
    });

</script>

</body>

</html>