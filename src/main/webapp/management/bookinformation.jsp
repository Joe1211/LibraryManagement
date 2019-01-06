<%--
  Created by IntelliJ IDEA.
  User: 韩佳奇
  Date: 2018/12/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/img/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">


</head>

<body data-type="index">

<div class="container-fluid">
    <div class="panel-heading text-center">
        <h3 class="text-primary">图书信息</h3>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered  table-hover  table-condensed">
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
                    <td><img src="${book.bookCover}" width="60px" height="50px"></td>
                    <td><fmt:formatDate value="${book.bookTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${book.typeTwoValue}</td>
                    <td>${book.libraryId}</td>
                    <td><a href="${pageContext.request.contextPath}/admin/findbookbyid?bookId=${book.bookId}"
                           class="btn btn-primary  btn-xs"
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
                                    <li  class="disabled"><span>上一页</span></li>
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
                                    <li  class="disabled"><span>下一页</span></li>
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
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/theme.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>


</body>

</html>