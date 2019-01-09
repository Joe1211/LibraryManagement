<%--
  Created by IntelliJ IDEA.
  User: 邱家锦
  Date: 2019/1/9
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <title>注册</title>
    <style>
        #rightArea{
            padding-top: 50px;
        }
        .afterfix:after{
            content: "";
            clear: both;
            display: block;
        }
        #registerForm>legend{
            font-size: 30px;
        }
        #registerForm>#registerBtn{
            width: 100%;
        }
        #registerForm>div{
            position: relative;
        }
        input.error{
            border:1px solid red;
        }
        label.error{
            color:red;
            position: absolute;
            right: 10px;
            top: 32px;
            font-weight: 100;
        }
    </style>
</head>
<body>
<div class="container afterfix">
    <div class="row">
        <div id="leftArea" class="col-sm-6 hidden-xs"></div>
        <div id="rightArea" class="col-sm-6">
            <form id="registerForm" method="post">
                <legend>注册</legend>
                <div class="form-group">
                    <label for="readerName">姓名</label>
                    <input type="text" class="form-control" id="readerName" name="readerName" placeholder="请输入真实姓名">
                </div>
                <div class="form-group">
                    <label for="readerPhone">手机号</label>
                    <input type="text" class="form-control" id="readerPhone" name="readerPhone" placeholder="请输入手机号">
                </div>
                <div class="form-group">
                    <label for="readerPassword">密码</label>
                    <input type="password" class="form-control" id="readerPassword" name="readerPassword" placeholder="你的密码">
                </div>
                <div class="form-group">
                    <label for="confirmPassword">确认密码</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="再次输入密码">
                </div>
                <div class="form-group">
                    <label for="readerEmail">邮箱</label>
                    <input type="text" class="form-control" id="readerEmail" name="readerEmail" placeholder="请输入正确的邮箱地址">
                </div>
                <input id="registerBtn" type="submit" class="btn btn-primary" value="注册"/>
            </form>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/register.js"></script>
</body>
</html>
