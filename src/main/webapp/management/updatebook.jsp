<%--
  Created by IntelliJ IDEA.
  User: 31261
  Date: 2018/12/25
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改图书信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>

<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"
            aria-hidden="true">&times;</button>
    <h4 class="modal-title text-primary" id="myModalLabel">修改图书信息</h4>
</div>
<form id="updatebook" action="${pageContext.request.contextPath}/admin/updatebook"
      method="post" class="form-horizontal" enctype="multipart/form-data">
    <div class="form-group">
        <label for="bookId" class=" col-sm-3  text-right" style="padding-right: 0;">图书编号:</label>
        <div class="col-sm-6">
            <input type="text" name="bookId" id="bookId"
                   value="${book.bookId}" class="form-control" readonly="readonly"/>
        </div>
    </div>

    <div class="form-group">
        <label for="bookName" class=" col-sm-3  text-right"
               style="padding-right: 0;">书名&nbsp;&nbsp;&nbsp;:</label>
        <div class="col-sm-6">
            <input type="text" name="bookName" id="bookName" class="form-control"
                   value="${book.bookName}"/>
        </div>
    </div>

    <div class="form-group">
        <label for="bookWriter" class=" col-sm-3  text-right"
               style="padding-right: 0;">作者&nbsp;&nbsp;&nbsp;:</label>
        <div class="col-sm-6">
            <input type="text" name="bookWriter" id="bookWriter"
                   value="${book.bookWriter}" class="form-control" />
        </div>
    </div>

    <div class="form-group">
        <label for="bookInfo" class=" col-sm-3  text-right"
               style="padding-right: 0;">详细介绍&nbsp;:</label>
        <div class="col-sm-6">
            <input type="text" name="bookInfo" id="bookInfo" class="form-control"
                   value="${book.bookInfo}"/>
        </div>
    </div>

    <div class="form-group">
        <label for="bookPeriodicals" class=" col-sm-3  text-right"
               style="padding-right: 0;">书刊号&nbsp;&nbsp;&nbsp;:</label>
        <div class="col-sm-6">
            <input type="text" name="bookPeriodicals" id="bookPeriodicals"
                   value="${book.bookPeriodicals}" class="form-control" />
        </div>
    </div>

    <div class="form-group">
        <label for=bookCallnum class=" col-sm-3  text-right"
               style="padding-right: 0;">索书号&nbsp;&nbsp;&nbsp;:</label>
        <div class="col-sm-6">
            <input type="text" name="bookCallnum" id="bookCallnum"
                   value="${book.bookCallnum}" class="form-control" />
        </div>
    </div>

    <div class="form-group">
        <label for="bookPress" class="col-sm-3 text-right">出版社</label>
        <div class="col-sm-6">
            <input type="text" id="bookPress" name="bookPress"
                   value="${book.bookPress}" class="form-control" />
        </div>
    </div>

    <div class="form-group">
        <label for="bookTime" class="col-sm-3 text-right">入库时间</label>
        <div class="col-sm-6">
            <input type="text" id="bookTime" name="bookTime"
                   value='<fmt:formatDate value="${book.bookTime}" pattern="yyyy-MM-dd HH:mm:ss"/> ' class="form-control" />
        </div>
    </div>

    <div class="form-group">
        <label for="libraryId" class="col-sm-3 text-right">图书馆ID</label>
        <div class="col-sm-6">
            <input type="text" id="libraryId" name="libraryId"
                   value="${book.libraryId}" class="form-control" />
        </div>
    </div>

    <div class="form-group ">
        <label class="col-sm-3 text-right" for="bookState"
               style="padding-right: 0;"> 图书状态:</label>
        <div class="col-sm-7">
            <select id="bookState" name="bookState" class="form-control">
                <option value="1">可借阅</option>
                <option value="0">已借阅</option>
            </select>
        </div>
    </div>

    <div class="form-group ">
        <label class="col-sm-3 text-right" for="typeTwoValue"
               style="padding-right: 0;"> 分类&nbsp;&nbsp;&nbsp;:</label>
        <div class="col-sm-7">
            <select id="typeTwoValue" name="typeTwoValue"
                    class="form-control">
            </select>

        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-3 text-right" style="padding-right: 0;">
            <label>图片&nbsp;&nbsp;&nbsp;:</label>
        </div>
        <div class="col-sm-9 big-photo">
            <div id="preview">
                <img id="imghead" border="0"
                     src="${book.bookCover}"
                     width="50" height="50" onclick="$('#bimg').click();">
            </div>
            <input type="file" name="bimg" onchange="bimg(this)"
                   style="display: none;" id="bimg"
                   accept="png,jpg,jpeg,gif,icon,bmp">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-4 col-sm-offset-2">
            <button type="submit" class="btn btn-primary">修改</button>
        </div>
    </div>
</form>


<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $.post('${pageContext.request.contextPath}/admin/findbookTypeList',
            function(data) {
                for (var i = 0; i < data.length; i++) {
                    var bookType = data[i];
                    $("#typeTwoValue").append(
                        "<option value='"+bookType.typeTwoValue+"'>"
                        + bookType.typeTwoType
                        + "</option>");
                }
            }, 'json');
    })


</script>

</body>
</html>
