<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="shortcut icon" href="img/icon/favicon.ico"/>
    <link rel="bookmark" href="img/icon/favicon.ico"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <%--<link rel="stylesheet" href="css/app1.css"/>--%>
    <style>
        html {
            background: -webkit-linear-gradient(45deg, #0e90d2 20%, #cad8df 50%,#cad8df 70%,#96b6c5);
            background: -o-linear-gradient(45deg, #0e90d2 20%, #cad8df 50%,#cad8df 70%,#96b6c5);
            background: -moz-linear-gradient(45deg, #0e90d2 20%, #cad8df 50%,#cad8df 70%,#96b6c5);
            background: linear-gradient(45deg, #0e90d2 20%, #cad8df 50%,#cad8df 70%,#96b6c5);
        }

        .log {
            top: 100px;
        }

        .clearfix:after {
            content: "";
            display: block;
            clear: both;
            height: 0;
            visibility: hidden;
        }

        #roleDiv {
            padding: 0 15px;
        }

        #roleDiv > label {
            margin: 0;
        }

        /*body{*/
        /*background: -webkit-linear-gradient(45deg, #0e90d2,rgba(14,144,210,0.5), white);*/
        /*background: -o-linear-gradient(45deg, #0e90d2,rgba(14,144,210,0.5), white);*/
        /*background: -moz-linear-gradient(45deg, #0e90d2,rgba(14,144,210,0.5), white);*/
        /*background: linear-gradient(45deg, #0e90d2,rgba(14,144,210,0.5), white);*/
        /*}*/
    </style>
</head>
<body>
<div class="am-g am-u-md-6 am-u-md-offset-5 log">
    <!-- LOGO -->
    <div class="am-u-sm-12 am-text-center ">
        <img src="img/logo.jpg" alt=""/>
    </div>
    <!-- 登陆框 -->
    <div class="am-u-sm-11 am-u-md-8  am-u-sm-centered">
        <form id="loginForm" class="am-form">
            <!-- 隐藏域 -->
            <fieldset class="myapp-login-form am-form-set">
                <!--手机号 -->
                <div class="am-form-group am-form-icon">
                    <i class="am-icon-phone"></i>
                    <input type="text" name="readerPhone" id="phone" class="myapp-login-input-text am-form-field"
                           required placeholder="请输入您的手机号">
                </div>
                <span id="d1" style="color:red;font-size:13px;"></span>
                <!--密码 -->
                <div class="am-form-group am-form-icon">
                    <i class="am-icon-lock"></i>
                    <input type="password" name="readerPassword" id="password"
                           class="myapp-login-input-text am-form-field" required placeholder="至少6个字符">
                </div>
                <span id="d2" style="text-align:right; color:red;font-size:13px;"></span>
                <div id="roleDiv">
                    <label for="reader" style="margin: 0 10px 0 0">
                        <input id="reader" type="radio" name="role" value="0" checked="checked"/>
                        我是读者
                    </label>
                    <label for="manager">
                        <input id="manager" type="radio" name="role" value="1"/>
                        我是管理员
                    </label>
                </div>
            </fieldset>
            <input type="button" class="myapp-login-form-submit am-btn am-btn-primary am-btn-block " id="denglu"
                   onclick="login()" value="登 录"/>
        </form>
        <div class="form-group text-right">
            <span>还没有账号？立即<a href="register.jsp">注册</a></span>
        </div>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script>
    //手机号验证
    $('#phone').on('blur', function () {
        var html;
        if (!((/^1[34578]\d{9}$/).test(this.value))) {
            $('#d1').text("");
            $('#d1').append('电话号码格式输入错误');
            return false;
        } else {
            $('#d1').remove();
        }
    })
    //密码验证
    $('#password').on('blur', function () {
        var html;
        if (!((/^[a-z0-9]{6,18}$/).test(this.value))) {
            $('#d2').text("");
            $('#d2').append('密码为6~18位字母或数字');
            $("#denglu").attr("disabled", true);
            return false;
        } else {
            $('#d2').remove();
            $("#denglu").attr("disabled", false);
        }
    })

    function login() {
        $.ajax({
            type: "get",
            dataType: "json",
            url: "api/readermanagement/login",
            data: $("#loginForm").serialize(),
            success: function (data) {
                if (data != null && data.code == 1 && data.result != null) {
                    switch (data.result.role) {
                        case 0:
                            location.href = "/index.jsp";
                            break;
                        case 1:
                            location.href = "/admin.jsp";
                            break;
                        case 2:
                            if ($("input#reader").prop("checked")) {
                                location.href = "/index.jsp";
                            } else {
                                location.href = "/admin.jsp";
                            }
                            break;
                        default:
                            alert("身份错误");
                            break;
                    }
                } else {
                    alert(data.msg);
                }
            },
            error: function () {
                console.log("请求失败");
                alert("服务器异常");
            }
        });
    }
</script>
</body>
</html>