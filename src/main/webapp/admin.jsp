<%--
  Created by IntelliJ IDEA.
  User: 韩佳奇
  Date: 2018/12/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Library</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <link rel="icon" type="image/png" href="img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="img/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <script src="js/echarts.min.js"></script>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="css/app.css">
    <%--<link rel="stylesheet" href="css/admin.css">--%>
    <script src="js/jquery.min.js"></script>
    <style>
        .reader-div{
            display: table-cell;
            vertical-align: middle;
            height:56px;
            padding: 0 16px;
        }
    </style>
</head>

<body data-type="index">
<script src="js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;"><img src="img/logo.jpg" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <li class="am-text-sm">
                        <c:if test="${reader.role==1}">
                            <div class="reader-div">
                                <button id="beReader" class="reader-btn am-btn am-btn-secondary am-round">成为读者</button>
                            </div>
                        </c:if>
                        <c:if test="${reader.role==2}">
                            <div class="reader-div">
                                <button id="toIndex" class="reader-btn am-btn am-btn-secondary am-round">进入读者首页</button>
                            </div>
                        </c:if>
                    </li>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span>${reader.readerName}</span> </a>
                    </li>
                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="api/readermanagement/outReader">
                            <span class="am-icon-sign-out"></span> 退出
                        </a>
                    </li>
                </ul>
            </div>
        </div>

    </header>
    <!-- 风格切换 -->
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    <!-- 侧边导航栏 -->
    <div class="left-sidebar">
        <!-- 用户信息 -->
        <div class="tpl-sidebar-user-panel">
            <div class="tpl-user-panel-slide-toggleable">
                <div class="tpl-user-panel-profile-picture">
                    <img src="img/user04.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
                    <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
                    ${reader.readerName}
                </span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 图书管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="${pageContext.request.contextPath}/admin/bookListFenYe" target="showiframe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图书信息
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="admin_book.jsp" target="showiframe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图书入库
                        </a>
                    </li>
                </ul>
            </li>



            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 借阅管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="admin_repay.jsp" target="showiframe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 待还图书
                        </a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 信息统计
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">


                    <li class="sidebar-nav-link">
                        <a href="${pageContext.request.contextPath}/management/bookchart.jsp" target="showiframe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图表统计
                        </a>
                    </li>
                </ul>
            </li>


            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 标签管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 添加标签
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 删除标签
                        </a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 评论管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="admin_comment.jsp" target="showiframe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 评论管理
                        </a>
                    </li>

                    <%--<li class="sidebar-nav-link">--%>
                    <%--<a href="${pageContext.request.contextPath}/book/booklist/information">--%>
                    <%--<span class="am-icon-angle-right sidebar-nav-link-logo"></span>评论详情--%>
                    <%--</a>--%>
                    <%--</li>--%>
                </ul>
            </li>
        </ul>
    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <iframe src="hello.jsp" width="100%" height="100%" frameborder="0" name="showiframe"></iframe>
    </div>

    <%--确认框--%>
    <div class="am-modal am-modal-confirm" tabindex="-1" id="beReader-confirm">
        <div class="am-modal-dialog">
            <div class="am-modal-hd">成为读者？</div>
            <div class="am-modal-bd">
                确定要注册成为读者？
            </div>
            <div class="am-modal-footer">
                <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                <span class="am-modal-btn" data-am-modal-confirm>确定</span>
            </div>
        </div>
    </div>
</div>
</div>

<script src="js/amazeui.min.js"></script>
<script src="js/amazeui.datatables.min.js"></script>
<script src="js/dataTables.responsive.min.js"></script>
<script src="js/app.js"></script>
<script>
    $("#beReader").on('click',function(){
        $('#beReader-confirm').modal({
            onConfirm: function(options) {
                //确认成为读者
                $.ajax({
                    type:"get",
                    dataType:"json",
                    url:"api/readermanagement/adminToReader",
                    data:{readerId:${reader.readerId}},
                    success:function(data){
                        //跳转到读者首页
                        if(data!=null&&data.code==1){
                            alert("恭喜你，成为了读者，即将跳转到读者页");
                            location.href="/index.jsp";
                        }else{
                            alert("请求失败");
                        }
                    },
                    error:function(){
                        alert("服务器异常");
                    }
                });
            }
        });
    });
    $("#toIndex").on("click",function(){
        location.href="/index.jsp";
    });
</script>
</body>

</html>