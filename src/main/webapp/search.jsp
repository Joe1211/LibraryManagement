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
    <script src="js/pccs.js" type="text/javascript"></script>
</head>

<body>
<!--导航栏-->
<nav class="navbar navbar-default col-md-12" style="background: none;>
        <div class=" container-fluid">
<!--logo-->
<div class="navbar-header col-sm-2 ">
    <a href=" " class="navbar-header ">
        <img src="images/logo.jpg">
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
        <li><a href=" ">图书标签</a></li>
        <li><a href=" ">我的借阅</a></li>
        <li class="ver1 ">
						<span id=" ">
							消息
							<span class="badge">18</span>
						</span>
        </li>
        <li class="ver1 ">
            <div class="dropdown ">
							<span data-toggle="dropdown">
								用户
								<span class="caret"></span>
							</span>
                <ul class="dropdown-menu">
                    <li><a href=" ">个人资料</a></li>
                    <li><a href=" ">修改密码</a></li>
                    <li><a href=" ">清除缓存</a></li>
                    <li class="divider"></li>
                    <li><a href=" ">注销账户</a></li>
                </ul>
            </div>
        </li>
    </ul>
    </div>
</form>
</div>
</nav>


<div class="container-fluid ">
    <!--左侧区域 -->
    <div class="row col-md-3 ">
        <h3>按类型检索</h3>
        <!--本部类-->
        <select name="province" id="province" class="form-group form-control">
        </select>

        <!--一级类目-->
        <select name="city" id="city" class="form-group form-control">
        </select>

        <!--二级类目-->
        <select name="county" id="county" class="form-group form-control">
        </select>

        <button class="btn btn-info col-md-12 col-xs-12">检索</button>

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
<script language="javascript">
    setup()
</script>

<script type="text/javascript">
    // 加载标签
    window.onload=function(){
        $.ajax({
            type:'get',
            url:'api/labels',
            dataType:'json',
            success:function (data) {
                if(data.code == 1){
                    var html = '';
                    $.each(data.result,function (i,item) {
                        html+='<label>';
                        html+='<input type="checkbox" name="lab" value='+item.bookLabelId+'>'+item.bookLabel;
                        html+='</label>';
                    })
                    $("#lab").html(html);
                }
            }
        })
    }
    // 根据书名模糊查询
    // 搜索
    $('#select').click(function () {
        $.ajax({
            type: 'get',
            url: 'api/books/books/' +'?bookname='+$('#content').val(),
            dataType: 'json',
            success: function (data) {
                loadInfo(data);
            }
        })
    })
    function loadInfo(data){
        if(data.code == 1){
            var html = '';
            $.each(data.result.list,function (i,item) {
                html+='<div class="col-md-12 ">';
                html+=' <div class="panel panel-default panel_1">';
                html+='<div class="panel-body panel_2 ">';
                html+='  <div class="form-group col-md-1 ">';
                html+='<div class="picture box tupian ">';
                html+='<img src=""/>';
                html+='</div>';
                html+='</div>';
                html+=' <div id="" class="col-md-8 ">';
                html+='<p>'+item.bookName+'</p>';
                html+='<p>'+item.bookWriter+'</p>';
                html+='<p>'+item.bookPress+'</p>';
                html+='<a href=" ">预约请求</a>';
                html+=' <a href=" ">馆藏信息</a>';
                html+='<a href=" ">详细信息</a>';
                html+='<a href=" ">评论/标签</a>';
                html+='</div>';
                html+='</div>';
                html+='</div> ';
                html+='</div>';
            })
            html+= '当前第'+data.result.pageNum+' 页.总共'+data.result.pages+'页.一共 '+data.result.total+' 条记录'

            html+='<div class="col-md-12">';
            html+='';
            html+='<nav aria-label="Page navigation">';
            html+='  <ul class="pagination">';
            // 上一页
            html+=' <li>';
            <%--html+='<c:if test="${data.result.hasPreviousPage}">';//是否有上一页--%>
            html+='<a href="javascript:loadData('+(data.result.pageNum-1)+')">'+"上一页"+'</a>';
            html+='</a>';
            <%--html+='</c:if>';--%>
            html+='   </li>';

            <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
            $.each(data.result.navigatepageNums,function (i,n) {
                html+='<li><a href="javascript:loadData('+n+')">'+n+'</a></li> ';
            })

            // 下一页
            html+=' <li>';
            <%--html+='  <c:if test="${data.result.hasNextPage}">';;//判断是否有下一页--%>
            html+='<a href="javascript:loadData('+(data.result.pageNum+1)+')">'+"下一页"+'</a>';
            <%--html+='</c:if>';--%>
            html+='  </li>';

            html+='  </ul>';
            html+='   </nav>';
            html+='  </div>';
            $("#bod").html(html);
        }else {
            data.msg();
        }
    }
    // 加载分页
    function loadData(page) {

        $.ajax({
            type: 'get',
            url: 'api/books/books' + '?bookname=' +$('#content').val() + '&pn=' + page,
            dataType: 'json',
            success: function (data) {
                loadInfo(data);
            }
        })
    }


    // 标签查询
    $('#labelsubmit').click(function(){
        var data = $("form").serialize(); // 表单序列化
        alert(data)
        $.ajax({
            type : 'get',
            url : 'api/books/label'+'?'+data,
            success : function(data) {
                if(data.code == 1){
                    var html = '';
                    $.each(data.result,function (i,item) {
                        html+='<div class="col-md-12 ">';
                        html+=' <div class="panel panel-default ">';
                        html+='<div class="panel-body ">';
                        html+='  <div class="form-group col-md-1 ">';
                        html+='<div class="picture box ">';
                        html+='<img src=""/>';
                        html+='</div>';
                        html+='</div>';
                        html+=' <div id="" class="col-md-8 ">';
                        html+='<p>'+item.bookName+'</p>';
                        html+='<p>'+item.bookWriter+'</p>';
                        html+='<p>'+item.bookPress+'</p>';
                        html+='<a href=" ">预约请求</a>';
                        html+=' <a href=" ">馆藏信息</a>';
                        html+='<a href=" ">详细信息</a>';
                        html+='<a href=" ">评论/标签</a>';
                        html+='</div>';
                        html+='</div>';
                        html+='</div> ';
                        html+='</div>';
                    })
                    $("#bod").html(html);
                }else {
                    alert(data.msg);
                }
            }
        });
    });




</script>


</body>
</html>