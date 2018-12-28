<%--
  Created by IntelliJ IDEA.
  User: 韩佳奇
  Date: 2018/12/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/img/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">


</head>

<body data-type="index">

<div class="am-g tpl-g">
    <!-- 头部 -->
    <header>
        <!-- logo -->
        <div class="am-fl tpl-header-logo">
            <a href="javascript:;"><img src="${pageContext.request.contextPath}/img/logo.jpg" alt=""></a>
        </div>
        <!-- 右侧内容 -->
        <div class="tpl-header-fluid">
            <!-- 其它功能-->
            <div class="am-fr tpl-header-navbar">
                <ul>
                    <!-- 欢迎语 -->
                    <li class="am-text-sm tpl-header-navbar-welcome">
                        <a href="javascript:;">欢迎你, <span>xxx</span> </a>
                    </li>

                    <!-- 退出 -->
                    <li class="am-text-sm">
                        <a href="javascript:;">
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
                    <img src="${pageContext.request.contextPath}/img/user04.png" alt="">
                </div>
                <span class="user-panel-logged-in-text">
	              			<i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>禁言小张
	                    </span>
            </div>
        </div>

        <!-- 菜单 -->
        <ul class="sidebar-nav">

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 信息统计
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="${pageContext.request.contextPath}/admin/bookListFenYe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图书借阅数量
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="${pageContext.request.contextPath}/management/bookchart.jsp">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图表统计
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
                        <a href="">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 以借图书
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 待还图书
                        </a>
                    </li>
                </ul>
            </li>

            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-table sidebar-nav-link-logo"></i> 图书管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub">
                    <li class="sidebar-nav-link">
                        <a href="${pageContext.request.contextPath}/admin_book.jsp" target="showiframe">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图书入库
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 图书出库
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
                        <a href="">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span> 评论管理
                        </a>
                    </li>

                    <li class="sidebar-nav-link">
                        <a href="${pageContext.request.contextPath}/book/booklist/information">
                            <span class="am-icon-angle-right sidebar-nav-link-logo"></span>评论详情
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>


    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h3 class="text-primary">图书信息</h3>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered  table-hover  table-condensed" >
                    <tr class="text-center text-primary">
                        <td>图书ID</td>
                        <td>图书名称</td>
                        <td>书刊号</td>
                        <td>索书号</td>
                        <td>作者</td>
                        <td>出版社</td>
                        <td>封面</td>
                        <td>入库时间</td>
                        <td>二级类目</td>
                        <td>图书馆ID</td>
                        <td>操作</td>
                    </tr>

                    <c:forEach items="${pageinfo.list}" var="book">
                        <tr class="text-center ">
                            <td>${book.bookId}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookPeriodicals}</td>
                            <td>${book.bookCallnum}</td>
                            <td>${book.bookWriter}</td>
                            <td>${book.bookPress}</td>
                            <td><img  src="${book.bookCover}"></td>
                            <td><fmt:formatDate value="${book.bookTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                            <td>${book.typeTwoValue}</td>
                            <td>${book.libraryId}</td>
                            <td><a href="${pageContext.request.contextPath}/admin/findbookbyid?bookId=${book.bookId}" class="btn btn-primary  btn-xs"
                                   data-toggle="modal" data-target="#myModal">修改</a>
                                <a href="${pageContext.request.contextPath}/admin/delete?bookId=${book.bookId}"
                                   class="btn btn-primary  btn-xs" onclick="javascript:return confirm('是否确定删除')">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>

                <div>

                    <div class="text-center">
                        <c:choose>
                            <c:when test="${pageinfo.size > 0 }">
                                <ul class="pagination">
                                    <li><span>显示${pageinfo.startRow }到${pageinfo.endRow}共${pageinfo.total}条</span>
                                    </li>
                                    <li><a
                                            href="${pageContext.request.contextPath}/admin/bookListFenYe?pageNum=1">首页
                                    </a></li>
                                    <c:choose>
                                        <c:when test="${pageinfo.hasPreviousPage}">
                                            <li><a
                                                    href="${pageContext.request.contextPath}/admin/bookListFenYe?pageNum=${pageinfo.pageNum-1}">上一页
                                            </a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><span>上一页</span></li>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach var="item" items="${pageinfo.navigatepageNums}">
                                        <c:choose>
                                            <c:when test="${pageinfo.pageNum == item }">
                                                <li class="active"><span class="current">${pageinfo.pageNum }</span>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a
                                                        href="${pageContext.request.contextPath}/admin/bookListFenYe?pageNum=${item}">${item}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${!pageinfo.isLastPage }">
                                            <li><a
                                                    href="${pageContext.request.contextPath}/admin/bookListFenYe?pageNum=${pageinfo.pageNum+1}">下一页
                                            </a></li>
                                            <li><a
                                                    href="${pageContext.request.contextPath}/admin/bookListFenYe?pageNum=${pageinfo.lastPage}">尾页</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><span>下一页</span></li>
                                            <li><span>尾页</span></li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">

                    </div>
                </div>
            </div>
    </div>



</div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>



</body>

</html>