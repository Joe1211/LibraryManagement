<%--
  Created by IntelliJ IDEA.
  User: 16527
  Date: 2018/12/26
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的借阅</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.css"/>
</head>
<body>
    <h1>我的借阅</h1>
    <input type="hidden" id="readerId" value="${reader.readerId}">
    <div id="bod">
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        // 我的借阅记录
        window.onload=function(){
            $.ajax({
                type:'get',
                url:'api/books/record/borrow'+'?bookId='+$("#readerId").val(),
                success:function (data) {
                    loadRecordInfo(data)
                }
            })
        }
        function loadRecordInfo(data){
            if(data.code == 1){
                var html = '';
                $.each(data.result,function (i,item) {
                    html+='<div class="col-md-12 ">';
                    html+=' <div class="panel panel-default panel_1">';
                    html+='<div class="panel-body panel_2 ">';
                    html+='<div class="form-group col-md-1 ">';
                    html+='<div class="picture box tupian ">';
                    html+='<img class="tupian1" src="/bookCover'+item.bookCover+'"/>';
                    html+='</div>';
                    html+='</div>';
                    html+=' <div id="" class="col-md-8 ">';
                    html+='<p>'+item.bookName+'</p>';
                    html+='<p>'+item.bookWriter+'</p>';
                    html+='<p>'+item.bookPress+'</p>';
                    html+='<p>'+item.bookRecordTime+'</p>';
                    // html+='<a href="javascript:loadBorrow('+item.bookId+')">借阅&nbsp&nbsp</a>';
                    html+=' <a href=" ">馆藏信息&nbsp&nbsp</a>';
                    html+='<a href=" ">详细信息&nbsp&nbsp</a>';
                    html+='<a href=" ">评论/标签&nbsp&nbsp</a>';
                    html+='</div>';
                    html+='</div>';
                    html+='</div> ';
                    html+='</div>';
                })
                $("#bod").html(html);
            }else {
                alert(data.msg);
            };
        };

    </script>
</body>
</html>
