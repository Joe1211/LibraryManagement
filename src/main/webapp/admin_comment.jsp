<%--
  Created by IntelliJ IDEA.
  User: 16527
  Date: 2018/12/27
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
</head>
<body>
<h1>所有图书评论</h1>
<div id="bbb">

</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<%--<script src="js/search.js"></script>--%>
<script>
    window.onload=function () {
        $.ajax({
            type:'get',
            url:'api/bookcomment/comment',
            dataType:'json',
            success:function (data){
                if(data.code == 1){
                    loadInfo(data)
                }else {
                    alert(data.msg);
                };
            }
        })
    }

    function loadInfo(data){
        var html = '';
        html+='<table class="table table-hover" id="tab">';
        html+='<tr>';
        html+='<td>图书ID</td>';
        html+='<td>读者ID</td>';
        html+='<td>评论内容</td>';
        html+='<td>评论时间</td>';
        html+='<td>操作</td>';
        html+='</tr>';

        $.each(data.result.list,function (i,item) {
            html+='<tr>';
            html+='<td id="bookId">'+item.bookId+'</td>';
            html+='<td id="readerId">'+item.readerId+'</td>';
            html+='<td>'+item.comment+'</td>';
            html+='<td>'+item.updateTime+'</td>';
            // html+='<li><a href="javascript:loadComm('+(data.result.pageNum+1)+')">'+"下一页"+'</a></li>';
            // html+='<td><button type="button" class="btn btn-info btn-sm" id="repay">删除</button></td>';
            html+='<td><a href="javascript:loadDel('+(item.id)+')">'+"删除"+'</a></td>';
            html+='</tr>';
        })
        html+=' </table>';


        html+='<div class="col-md-12" style="text-align: center;">';
        html+= '当前第'+data.result.pageNum+' 页.总共'+data.result.pages+'页.一共 '+data.result.total+' 条记录';
        html+='';
        html+='<nav aria-label="Page navigation">';
        html+='  <ul class="pagination">';
        // 上一页
        //是否有上一页
        if (test = data.result.hasPreviousPage) {
            html+='<li><a href="javascript:loadComm('+(data.result.pageNum-1)+')">'+"上一页"+'</a></li>';
        }else{
            html+='<li class="disabled"><a href="avascript:void(0))">'+"上一页"+'</a></li>';
        }

        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
        // navigatepageNums所有导航页号
        // pageNum 当前页
        $.each(data.result.navigatepageNums,function (i,n) {
            if (data.result.pageNum == n){
                html+='<li class="active"><a href="avascript:void(0))">'+n+'</a></li> ';
            } else {
                html+='<li><a href="javascript:loadComm('+n+')">'+n+'</a></li> ';
            }
        })

        // 下一页
        //是否有下一页
        if (test = data.result.hasNextPage) {
            html+='<li><a href="javascript:loadComm('+(data.result.pageNum+1)+')">'+"下一页"+'</a></li>';
        }else{
            html+='<li class="disabled"><a href="avascript:void(0))">'+"下一页"+'</a></li>';
        }
        html+='  </ul>';
        html+='   </nav>';
        html+='  </div>';
        $("#bbb").html(html);
    }

    function loadComm(page){
        $.ajax({
            type:'get',
            url:'api/bookcomment/comment?pn='+page,
            dataType:'json',
            success:function (data){
                if(data.code == 1){
                    loadInfo(data)
                }else {
                    alert(data.msg);
                };
            }
        })
    }

    function loadDel(id) {
       $.ajax({
           type:'get',
           url:'api/bookcomment/delete?id='+id,
           success:function (data) {
               alert(data.msg);
               loadComm(1);
           }
       })
    }



</script>

</body>


</html>
