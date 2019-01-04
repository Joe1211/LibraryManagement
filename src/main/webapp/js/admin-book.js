$(function () {
    //表单验证
    $("#subbook").validate({
        submitHandler:function(form){
            var formData = new FormData(form);
            $.ajax({
                type: "post",
                cache: false,
                contentType: false,
                processData: false,
                url: "api/books/add",
                data: formData,
                dataType: "json",
                success: function (data) {
                    if (data != null && data.code == 1) {
                        // 上传成功
                        form.reset();
                        alert(data.msg);
                    } else {
                        //上传失败
                        alert(data.msg);
                    }
                },
                error: function () {
                    alert("服务器错误");
                }
            });
        },
        rules:{
            bookName: "required",
            bookWriter:"required",
            bookCallnum:{
                required:true,
                checkBookCallnum:true,
                maxlength:25
            },
            bookPress:"required"
        },
        messages:{
            bookName:"书名不能为空",
            bookWriter:"作者不能为空",
            bookCallnum:{
                required:"索书号不能为空",
                maxlength:"超过最大长度(25)"
            },
            bookPress:"出版社不能为空"
        }
    });
    //正则验证索书号
    $.validator.addMethod("checkBookCallnum",function(value,element){
        var regex=/^[A-Z][0-9\.]+\/[0-9:/.-]+$/;
        return this.optional(element)||regex.test(value);
    },"索书号格式错误");
    //加载图书部类目录
    $.ajax({
        type: "GET",
        url: "api/booktypes",
        success: function (data) {
            if (data != null && data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    $("#bookTypeValue").append("<option value='" + data[i].bookTypeId + "'>" + data[i].bookTypeName + "</option>");
                }
            }
            changeTypeOne();
        }
    });
    //加载图书馆
    $.ajax({
        type: "GET",
        url: "api/library/selectAll",
        success: function (data) {
            if (data != null && data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    // console.log(data[i].libraryName);
                    $("#libraryId").append("<option value='" + data[i].libraryId + "'>" + data[i].libraryName + "</option>");
                }
            }
        }
    });
});

//修改一级目录
function changeTypeOne() {
    // if($("#bookTypeValue").val()==null){
    //     return;
    // }
    $("#typeOneValue").empty();
    $.ajax({
        type: "GET",
        url: "api/typeones/" + $("#bookTypeValue").val(),
        success: function (data) {
            if (data != null && data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    $("#typeOneValue").append("<option value='" + data[i].typeOneId + "'>" +"["+ data[i].typeOneValue+"]"+data[i].typeOneType + "</option>");
                }
            }
            changeTypeTwo();
        }
    });
}

//修改二级目录
function changeTypeTwo() {
    // if($("#typeOneValue").val()==null){
    //     return;
    // }
    $("#typeTwoValue").empty();
    $.ajax({
        type: "GET",
        url: "api/typetwos/" + $("#typeOneValue").val(),
        success: function (data) {
            if (data != null && data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    $("#typeTwoValue").append("<option value='" + data[i].typeTwoId + "'>" +"["+ data[i].typeTwoValue+"]"+data[i].typeTwoType + "</option>");
                }
            }
        }
    });
}

$("#bookTypeValue").change(function(){changeTypeOne()});
$("#typeOneValue").change(function(){changeTypeTwo()});