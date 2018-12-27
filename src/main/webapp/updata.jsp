<%--
  Created by IntelliJ IDEA.
  User: 16527
  Date: 2018/12/26
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-select.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.css"/>
</head>
<body>
    <h1>修改密码</h1>
    <form class="form-horizontal" id="pass">
        <input type="hidden" name="readerPhone" value="${reader.readerPhone}"/>
        <div class="form-group">
            <label class="col-sm-2 control-label" for="bookName1">原密码：</label>
            <div class="col-sm-5">
                <input class="form-control" type="password" name="readerPassword" id="bookName1" placeholder="请输入原密码">
                </div>
             </div>
        </br>
       <div class="form-group">
            <label class="col-sm-2 control-label" for="bookName2">新密码：</label>
            <div class="col-sm-5">
              <input class="form-control" type="password" name="readerPassword1" id="bookName2" placeholder="请输入新密码" >
                </div>
            </div>
        </br>
      <div class="form-group">
            <label class="col-sm-2 control-label" for="bookName3">确认密码：</label>
            <div class="col-sm-5">
                <input class="form-control" type="password" name="readerPassword2" id="bookName3" placeholder="请输入再次输入">
                </div>
            </div>
        </br>
        <button type="button" class="btn btn-info" id="upPwd">提交</button>
        </form>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/defaults-zh_CN.min.js"></script>
    <script src="js/search.js"></script>
</body>
</html>
