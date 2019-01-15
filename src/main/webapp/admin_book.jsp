<%--
  Created by IntelliJ IDEA.
  User: 乔翰林
  Date: 2018/12/18
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>图书管理</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css"/>
    <%--<link rel="stylesheet" type="text/css" href="css/tab.css">--%>
    <style>
        input.error{
            border: red 1px solid;
        }
        label.error{
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>图书入库</h1>
    <form class="form-horizontal" method="post" enctype ="multipart/form-data" id="subbook">
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookName">图书名称：</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="bookName" id="bookName" placeholder="请输入图书名称">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookWriter">作者：</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="bookWriter" id="bookWriter" placeholder="请输入作者">
            </div>
        </div>
        <%--<div class="form-group">--%>
            <%--<label class="col-sm-2 control-label" for="bookPeriodicals">书刊号：</label>--%>
            <%--<div class="col-sm-5">--%>
                <%--<select class="form-control" name="bookPeriodicals" id="bookPeriodicals">--%>
                    <%--<option value="34623456">34623456</option>--%>
                    <%--<option value="35246753">35246753</option>--%>
                    <%--<option value="35254321">35254321</option>--%>
                    <%--<option value="36437556">36437556</option>--%>
                    <%--<option value="65325184">65325184</option>--%>
                <%--</select>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookPeriodicals">ISBN：</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="bookPeriodicals" id="bookPeriodicals" placeholder="请输入ISBN">
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookCallnum">索书号：</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="bookCallnum" id="bookCallnum" placeholder="请输入索书号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookPress">出版社：</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="bookPress" id="bookPress" placeholder="请输入出版社">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookCover">图书封面：</label>
            <div class="col-sm-5" >
                <input type="file" id="bookCover" name="bookCover" accept="image/png,image/jpg,image/jpeg" placeholder="选择封面"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookInfo">图书简介：</label>
            <div class="col-sm-5">
                <textarea rows="3" cols="20" class="form-control" type="text" name="bookInfo" id="bookInfo" placeholder="请输入图书简介"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookNumber">库存：</label>
            <div class="col-sm-5">
                <input class="form-control" type="text" name="bookNumber" id="bookNumber" placeholder="请输入库存">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookLabel">标签：</label>
            <div class="col-sm-5">
                <select class="form-control" data-live-search="true" name="bookLabel" id="bookLabel">

                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookTypeValue">图书目录编号：</label>
            <div class="col-sm-5">
                <div class="col-sm-4">
                    <select class="form-control" name="bookTypeValue" id="bookTypeValue">
                        <%--图书部类--%>
                    </select>
                </div>
                <div class="col-sm-4">
                    <select class="form-control" name="typeOneValue" id="typeOneValue">
                        <%--一级目录--%>
                    </select>
                </div>
                <div class="col-sm-4">
                    <select class="form-control" name="typeTwoValue" id="typeTwoValue">
                        <%--二级目录--%>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookState">图书状态：</label>
            <div class="col-sm-5">
                <select class="form-control" name="bookState" id="bookState">
                    <option value="1">可借阅</option>
                    <option value="0">已借阅</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="libraryId">图书馆名：</label>
            <div class="col-sm-5">
                <select class="form-control" name="libraryId" id="libraryId">
                    <%--图书馆--%>
                </select>
            </div>
        </div>
        <input type="submit" class="btn btn-info" id="submitBook" value="提交"/>
    </form>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-select.js"></script>
<script src="js/jquery.validate.min.js"></script>
<%--<script src="js/tab.js"></script>--%>
<script src="js/admin-book.js"></script>
</body>
</html>
