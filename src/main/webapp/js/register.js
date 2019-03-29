$(function(){
    $("#registerForm").validate({
        submitHandler:function(form){
            $.ajax({
                type:"post",
                dataType:"json",
                url:"api/readermanagement/createReader",
                data:$(form).serialize(),
                success:function(data){
                    if(data!=null&&data.code==1){
                        // alert(data.msg);
                        location.href="/login.jsp";
                    }else{
                        alert(data.msg);
                    }
                },
                error:function(){
                    alert("服务器异常");
                }
            });
        },
        rules:{
            readerName:"required",
            readerPhone:{
                required:true,
                checkPhone:true,
                remote:{
                    type:"get",
                    url:"api/readermanagement/isPhoneRegistered",
                    dataType:"json",
                    dataFilter: function(data,type){
                        if(data=='true'){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            },
            readerPassword:{
                required:true,
                rangelength:[6,14],
                checkPassword:true
            },
            confirmPassword:{
                required:true,
                equalTo:"#readerPassword"
            },
            readerEmail:{
                required:true,
                checkEmail:true,
                remote:{
                    type:"get",
                    url:"api/readermanagement/isEmailRegistered",
                    dataType:"json",
                    dataFilter: function(data,type){
                        if(data=='true'){
                            return false;
                        }else{
                            return true;
                        }
                    }
                }
            }
        },
        messages:{
            readerName:"姓名不能为空",
            readerPhone:{
                required:"电话号码不能为空",
                checkPhone:"手机号格式有误",
                remote:"该手机号已被注册"
            },
            readerPassword:{
                required:"密码不能为空",
                rangelength:"密码长度为6到14位",
                checkPassword:"含有非法字符",
            },
            confirmPassword:{
                required:"确认密码不能为空",
                equalTo:"两次密码不一致"
            },
            readerEmail:{
                required:"邮箱地址不能为空",
                checkEmail:"邮箱格式错误",
                remote:"该邮箱已被注册"
            }
        },
        errorPlacement:function(error,element){
            element.parent().append(error);
        }
    });
    $.validator.addMethod("checkPhone",function(value,element){
        var regex=/^1(3|4|5|7|8)\d{9}$/;
        return this.optional(element)||regex.test(value);
    });
    $.validator.addMethod("checkEmail",function(value,element){
        var regex=/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        return this.optional(element)||regex.test(value);
    });
    $.validator.addMethod("checkPassword",function(value,element){
        var regex=/^([a-zA-Z0-9]|<|>|\?|!|\[|\]){6,14}$/;
        return this.optional(element)||regex.test(value);
    });
});