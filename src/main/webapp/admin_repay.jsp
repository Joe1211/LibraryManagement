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
    <h1>所有待还图书</h1>
    <div id="bbb">

    </div>

    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%--<script src="js/search.js"></script>--%>
    <script>
        window.onload=function () {
            $.ajax({
                type:'get',
                url:'api/books/borrowall',
                dataType:'json',
                success:function (data) {
                    if(data.code == 1){
                        var html = '';
                        html+='<table class="table table-hover" id="tab">';
                        html+='<tr>';
                        html+=' <td>图书ID</td>';
                        html+='<td>书名</td>';
                        html+='<td>作者</td>';
                        html+='   <td>索书号</td>';
                        html+='    <td>读者ID</td>';
                        html+='<td>读者名</td>';
                        html+='  <td>读者手机号</td>';
                        html+='  <td>借书时间</td>';
                        html+='<td>操作</td>';
                        html+=' </tr>';

                        $.each(data.result.list,function (i,item) {
                            html+='<tr>';
                            html+='<td id="bookId">'+item.bookId+'</td>';
                            html+='<td>'+item.bookName+'</td>';
                            html+='<td>'+item.bookWriter+'</td>';
                            html+='<td>'+item.bookCallnum+'</td>';
                            html+='<td id="readerId">'+item.readerId+'</td>';
                            html+='<td>'+item.readerName+'</td>';
                            html+='<td>'+item.readerPhone+'</td>';
                            html+='<td>'+item.bookRecordTime+'</td>';
                            html+='<td><button type="button" class="btn btn-info btn-sm" id="repay">还书</button></td>';
                            html+='</tr>';
                        })
                        html+=' </table>';
                        html+= '当前第'+data.result.pageNum+' 页.总共'+data.result.pages+'页.一共 '+data.result.total+' 条记录'

                        html+='<div class="col-md-12">';
                        html+='';
                        html+='<nav aria-label="Page navigation">';
                        html+='  <ul class="pagination">';
                        // 上一页
                        //是否有上一页
                        if (test = data.result.hasPreviousPage) {
                            html+='<li><a href="javascript:loadTypeData('+(data.result.pageNum-1)+')">'+"上一页"+'</a></li>';
                        }else{
                            html+='<li><a href="avascript:void(0))">'+"上一页"+'</a></li>';
                        }

                        <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                        // navigatepageNums所有导航页号
                        // pageNum 当前页
                        $.each(data.result.navigatepageNums,function (i,n) {
                            if (data.result.pageNum == n){
                                html+='<li class="active"><a href="avascript:void(0))">'+n+'</a></li> ';
                            } else {
                                html+='<li><a href="javascript:loadTypeData('+n+')">'+n+'</a></li> ';
                            }
                        })

                        // 下一页
                        //是否有下一页
                        if (test = data.result.hasNextPage) {
                            html+='<li><a href="javascript:loadTypeData('+(data.result.pageNum+1)+')">'+"下一页"+'</a></li>';
                        }else{
                            html+='<li><a href="avascript:void(0))">'+"下一页"+'</a></li>';
                        }
                        html+='  </ul>';
                        html+='   </nav>';
                        html+='  </div>';
                        $("#bbb").html(html);
                    }else {
                        alert(data.msg);
                    };
                }
            })
        }
        // 动态加载还书功能
        $(document).on("click","#repay",function () {
            alert("还书")
            $.ajax({
                type:'get',
                url:'api/books/repay'+'?bookId='+$("#bookId").text()+"&readerId="+$("#readerId").text(),
                dataType:'json',
                success:function (data) {
                    alert(data.msg);
                }
            })
        })



    </script>

</body>


</html>
