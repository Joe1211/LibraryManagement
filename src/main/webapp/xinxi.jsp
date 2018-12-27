<%--
  Created by IntelliJ IDEA.
  User: 16527
  Date: 2018/12/26
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
    <h1>个人信息</h1>
    <div class="col-md-12 ">
    <div class="panel panel-default panel_1">
    <div class="panel-body panel_2 ">
     <div id="" class="col-md-8 ">
    <div class="form-group">
    <label class="col-sm-2 control-label">姓&nbsp名：</label>
    ${reader.readerName}
    </div>
    <div class="form-group">
    <label class="col-sm-2 control-label">手机号：</label>
    ${reader.readerPhone}
    </div>
    <div class="form-group">
    <label class="col-sm-2 control-label">邮&nbsp箱：</label>
    ${reader.readerEmail}
    </div>
    <div class="form-group">
    <label class="col-sm-2 control-label">余&nbsp额：</label>
    ${reader.readerBalance}
    </div>
    </div>
    </div>
    </div>
    </div>
</body>
</html>
