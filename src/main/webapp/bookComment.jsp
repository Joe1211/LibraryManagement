<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/score.css"/>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/lq-score.js"></script>

    <style>
        #kuan{
            width:400px;
        }
        .textare{
            float: left;
        }
        .tupian2{
            width: 256px;
            height: 320px;
        }
        .icon{
            width:20px;
            height:20px;
        }
        .distance{
            margin-bottom: 10px;
        }
        .score{
            hight:50px;
            line-height: 50px;
        }
        div.lq-score{
            float: left;
        }
        .score-tip{
            padding: 0 8px;
            float: left;
        }
        .lq-score-tip{
            margin: 0px;
        }
        div.lq-score>ul>li {
            font-size: 25px;
        }
    </style>
</head>
<body>
<div class="contrainer panel panel-collapse">
    <div class="panel-body">
        <%--图书详情--%>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">图书详情</div>
                <div class="panel-body">
                    <div class="col-md-4">
                        <img src="api/books/findBookCover?id=${msg.bookId}" class="tupian2"/>
                    </div>
                    <div class="col-md-8">
                        <input id="bookId" type="hidden" class="bid" value=${msg.bookId}>
                        <h3>&nbsp&nbsp&nbsp${msg.bookName}</h3>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/rate.png" alt="" class="icon">
                            </div>
                            <div class="col-md-11">
                                <div id="score2" style="float:left;height: 20px;line-height: 20px;">
                                    <div id="rate2">
                                    </div>
                                    <div class="score-tip">
                                        <span id="tip2" class="lq-score-tip"></span>&nbsp;&nbsp;<span id="scoreNum"></span>
                                    </div>
                                </div>
                                <div style="clear:both;"></div>
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/writer.png" alt=""class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookWriter}
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/press.png" alt=""class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookPress}
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/callnum.png" alt=""class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookCallnum}
                            </div>
                        </div>
                        <div class="col-md-12 distance">
                            <div class="col-md-1">
                                <img src="img/icon/info.png" alt=""class="icon">
                            </div>
                            <div class="col-md-11">
                                ${msg.bookInfo}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--图书详情--%>
        <%--评论--%>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">图书评论</div>
                <div class="panel-body">
                    <div id="bod">
                        <%--<c:forEach items="${comm}" var="com">--%>
                            <%--<div class="col-md-12 distance">--%>
                                <%--<div class="col-md-2">--%>
                                        <%--${com.readerName}:</br>--%>
                                        <%--${com.updateTime}--%>
                                <%--</div>--%>
                                <%--<div class="col-md-10">--%>
                                        <%--${com.comment}--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</c:forEach>--%>
                    </div>
                    <form class="textare" id="myform">
                        <div style="height: 50px;;line-height: 50px;">
                            <p style="float: left;margin-bottom:0;margin-right: 20px;">说点什么...</p>
                            <div id="score" class="score" style="float:left;height: 20px;">
                                <div id="rate" class="lq-score">
                                </div>
                                <div class="score-tip">
                                    <span id="tip1" class="lq-score-tip"></span>
                                </div>
                            </div>
                            <div style="clear:both;"></div>
                        </div>
                        <textarea name="say" rows="3" cols="120" class="t"></textarea>
                        <button class="btn btn-primary col-md-2 col-md-offset-10 form-group" id="sub" type="button">确定</button>
                    </form>
                </div>
            </div>
        </div>
        <%--评论--%>
    </div>
</div>


<script>
    $(function(){
        $.ajax({
            type:"get",
            url:"api/bookScore/selectBookScoreByBookAndReader",
            data:{bookId:$("#bookId").val()},
            success:function(data){
                if(data!=null&&data.code==1){
                    $("#rate").lqScore({
                        fontSize:"25px",
                        $tipEle:$("#tip1"),
                        tips: ["不推荐", "一般", "不错", "很棒", "极力推荐！"],
                        score:data.result.score,
                        isScoreFinish:true
                    });
                }else{
                    $("#rate").lqScore({
                        fontSize:"25px",
                        $tipEle:$("#tip1"),
                        zeroTip:"未评论",
                        tips: ["不推荐", "一般", "不错", "很棒", "极力推荐！"],
                        afterScore:function(ele,score){
                            $.ajax({
                                type:"get",
                                url:"api/bookScore/insertBookScore",
                                data:{bookId:$("#bookId").val(),score:score},
                                success:function(data){
                                    if(data!=null&&data.code==1){
                                        alert(data.msg);
                                    }else{
                                        alert(data.msg);
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
        $.ajax({
            type:"get",
            url:"api/bookScore/getBookScoreVO",
            data:{bookId:${msg.bookId}},
            success:function(data){
                if(data!=null&&data.code==1){
                    var result=data.result.scoreAvg.toFixed(1);
                    $("#rate2").lqScore({
                        $tipEle:$("#tip2"),
                        fontsize:"17px",
                        zeroTip: result+"分",
                        tips:[result+"分",result+"分",result+"分",result+"分",result+"分"],
                        score:result,
                        isScoreFinish:true
                    });
                    $("#scoreNum").html("共"+data.result.scoreNum+"人评价");
                }else{
                    $("#rate2").lqScore({
                        $tipEle:$("#tip2"),
                        fontsize:"17px",
                        zeroTip: "暂无评分",
                        score:0,
                        isScoreFinish: true
                    });
                }
            }
        });
    });
    window.onload=function(){

        //评论
        $.ajax({
            type:'get',
            url:'api/books/comments'+'?bookId='+$(".bid").val(),
            success:function (data) {
                if(data.code == 1 ){
                    loadInfo(data);
                }
                else{
                    $("#bod").html(data.msg);
                }
            }
        })
    }
    function  loadInfo(data) {
        var html = '';
        $.each(data.result.list,function (i,item) {
            html+='<div class="col-md-12 distance">';
            html+=' <div class="col-md-2">';
            html+=''+item.readerName+'</br>';
            html+=''+item.updateTime+'';
            html+='  </div>';
            html+=' <div class="col-md-10">';
            html+=''+item.comment+'';
            html+='</div>';
            html+='</div>';

        })
        html+= '当前第'+data.result.pageNum+' 页.总共'+data.result.pages+'页.一共 '+data.result.total+' 条记录'

        html+='<div class="col-md-12">';
        html+='';
        html+='<nav aria-label="Page navigation">';
        html+='  <ul class="pagination">';
        // 上一页
        //是否有上一页
        if (test = data.result.hasPreviousPage) {
            html+='<li><a href="javascript:loadData('+(data.result.pageNum-1)+')">'+"上一页"+'</a></li>';
        }else{
            html+='<li><a href="javascript:void(0))">'+"上一页"+'</a></li>';
        }

        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
        // navigatepageNums所有导航页号
        // pageNum 当前页
        $.each(data.result.navigatepageNums,function (i,n) {
            if (data.result.pageNum == n){
                html+='<li class="active"><a href="javascript:void(0))">'+n+'</a></li> ';
            } else {
                html+='<li><a href="javascript:loadData('+n+')">'+n+'</a></li> ';
            }
        })

        // 下一页
        //是否有下一页
        if (test = data.result.hasNextPage) {
            html+='<li><a href="javascript:loadData('+(data.result.pageNum+1)+')">'+"下一页"+'</a></li>';
        }else{
            html+='<li><a href="javascript:void(0))">'+"下一页"+'</a></li>';
        }

        html+='  </ul>';
        html+='   </nav>';
        html+='  </div>';
        $("#bod").html(html);
    }

    // 评论查询加载分页
    function loadData(page) {
        $.ajax({
            type: 'get',
            url:'api/books/comments'+'?bookId='+$(".bid").val()+'&pn='+page,
            dataType: 'json',
            success: function (data) {
                loadInfo(data);
            }
        })
    }


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
                    loadFindComm()
                    alert("评论成功")
                    $(".t").val("");
                    loadData(1);
                }else {
                    alert("评论失败")
                };
            },
        })
    });

    function loadFindComm(){
        $.ajax({
            type:'get',
            url: 'api/bookcomment/select'+'?bookId='+${msg.bookId},
            dataType: "json",
            success: function(data){
                loadComm(data);
            }
        })
    }
    function loadComm(data){
        // alert(data)
        // alert(JSON.stringify(data))直接将数据弹出来
        if (data!=null) {
            var html='';
            $.each(data,function (i, item) {
                html+='<div class="col-md-12 distance">'
                html+='<div class="col-md-2">'
                html+=''+item.readerName+':</br>'
                html+=''+item.updateTime+''
                html+='</div>'
                html+='<div class="col-md-10">'
                html+=''+item.comment+''
                html+='</div>'
                html+='</div>'
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

        <%--var html='';--%>
        <%--html+='<div class="container"> '--%>
        <%--html+='<table class="table table-hover">'--%>
        <%--html+='<thead>';--%>
        <%--html+='<tr>';--%>
        <%--html+='<th id="kuan"><h1>图书详情展示</h1></th>';--%>
        <%--html+='</tr>';--%>
        <%--html+='</thead>';--%>
        <%--html+='<tbody>';--%>
        <%--html+='<tr>';--%>
        <%--html+='<th>图书名字：</th>';--%>
        <%--html+='<th>${msg.bookName}</th>';--%>
        <%--html+='</tr>'--%>
        <%--html+='<tr>';--%>
        <%--html+='<th>图书刊号：</th>';--%>
        <%--html+='<th>${msg.bookPeriodicals}</th>';--%>
        <%--html+='</tr>'--%>
        <%--html+='<tr>';--%>
        <%--html+='<th>图书索书号：</th>';--%>
        <%--html+='<th>${msg.bookCallnum}</th>';--%>
        <%--html+='</tr>'--%>
        <%--html+='<tr>';--%>
        <%--html+='<th><p>图书作者：</th>';--%>
        <%--html+='<th>${msg.bookWriter}</th>';--%>
        <%--html+='</tr>'--%>
        <%--html+='<tr>';--%>
        <%--html+='<th>图书馆：</th>';--%>
        <%--html+='<th>${msg.bookPress}</th>';--%>
        <%--html+='</tr>'--%>
        <%--html+='<tr>';--%>
        <%--html+='<th>图书信息：</th>';--%>
        <%--html+='<th>${msg.bookInfo}</th>';--%>
        <%--html+='</tr>'--%>
        <%--html+='</tbody>'--%>
        <%--html+='</table>'--%>
        <%--html+='</div>'--%>
        <%--html+='<form class="col-md-offset-2 textare" id="myform">';--%>
        <%--html+='<p>说点什么...</p>'--%>
        <%--html+='<textarea name="say" rows="3" cols="150" class="t"></textarea>';--%>
        <%--html+='<button class="btn btn-primary col-lg-1 col-lg-offset-9 form-group" id="sub" type="button">确定</button>';--%>
        <%--html+='</form>'--%>

        <%--$("#bod").html(html);--%>
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
