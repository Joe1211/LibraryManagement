// 显示所有标签（打开页面自动执行）
window.onload=function(){
    $.ajax({
        type:'get',
        url:'api/labels',
        dataType:'json',
        success:function (data) {
            if(data.code == 1){
                var html = '';
                $.each(data.result,function (i,item) {
                    html+='<label>';
                    html+='<input type="checkbox" name="lab" value='+item.bookLabelId+'>'+item.bookLabel;
                    html+='</label>';
                })
                $("#lab").html(html);
            }
        }
    })
}

// 根据书名模糊查询
// 搜索框搜索
$('#select').click(function () {
    $.ajax({
        type: 'get',
        url: 'api/books/books/' +'?bookname='+$('#content').val(),
        dataType: 'json',
        success: function (data) {
            loadInfo(data);
        }
    })
})
//加载图书信息
function loadInfo(data){
    if(data.code == 1){
        var html = '';
        $.each(data.result.list,function (i,item) {
            html+='<div class="col-md-12 ">';
            html+=' <div class="panel panel-default panel_1">';
            html+='<div class="panel-body panel_2 ">';
            html+='  <div class="form-group col-md-1 ">';
            html+='<div class="picture box tupian ">';
            html+='<img src=""/>';
            html+='</div>';
            html+='</div>';
            html+=' <div id="" class="col-md-8 ">';
            html+='<p>'+item.bookName+'</p>';
            html+='<p>'+item.bookWriter+'</p>';
            html+='<p>'+item.bookPress+'</p>';
            html+='<a href=" ">预约请求</a>';
            html+=' <a href=" ">馆藏信息</a>';
            html+='<a href=" ">详细信息</a>';
            html+='<a href=" ">评论/标签</a>';
            html+='</div>';
            html+='</div>';
            html+='</div> ';
            html+='</div>';
        })
        html+= '当前第'+data.result.pageNum+' 页.总共'+data.result.pages+'页.一共 '+data.result.total+' 条记录'

        html+='<div class="col-md-12">';
        html+='';
        html+='<nav aria-label="Page navigation">';
        html+='  <ul class="pagination">';
        // 上一页
        //是否有上一页
        if (test = data.result.hasPreviousPage) {
            html+='<li><a href="javascript:loadData('+(data.result.pageNum-1)+')">'+"上一页"+'</a></li>';
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
                        html+='<li><a href="javascript:loadData('+n+')">'+n+'</a></li> ';
                }
        })

        // 下一页
        //是否有上一页
        if (test = data.result.hasNextPage) {
            html+='<li><a href="javascript:loadData('+(data.result.pageNum+1)+')">'+"上一页"+'</a></li>';
        }else{
            html+='<li><a href="avascript:void(0))">'+"下一页"+'</a></li>';
        }

        html+='  </ul>';
        html+='   </nav>';
        html+='  </div>';
        $("#bod").html(html);
    }else {
        data.msg();
    }
}
// 加载分页
function loadData(page) {
    $.ajax({
        type: 'get',
        url: 'api/books/books' + '?bookname=' +$('#content').val() + '&pn=' + page,
        dataType: 'json',
        success: function (data) {
            loadInfo(data);
        }
    })
}


// 标签查询
$('#labelsubmit').click(function(){
    var data = $("form").serialize(); // 表单序列化
    alert(data)
    $.ajax({
        type : 'get',
        url : 'api/books/label'+'?'+data,
        success : function(data) {
            if(data.code == 1){
                var html = '';
                $.each(data.result,function (i,item) {
                    html+='<div class="col-md-12 ">';
                    html+=' <div class="panel panel-default ">';
                    html+='<div class="panel-body ">';
                    html+='  <div class="form-group col-md-1 ">';
                    html+='<div class="picture box ">';
                    html+='<img src=""/>';
                    html+='</div>';
                    html+='</div>';
                    html+=' <div id="" class="col-md-8 ">';
                    html+='<p>'+item.bookName+'</p>';
                    html+='<p>'+item.bookWriter+'</p>';
                    html+='<p>'+item.bookPress+'</p>';
                    html+='<a href=" ">预约请求</a>';
                    html+=' <a href=" ">馆藏信息</a>';
                    html+='<a href=" ">详细信息</a>';
                    html+='<a href=" ">评论/标签</a>';
                    html+='</div>';
                    html+='</div>';
                    html+='</div> ';
                    html+='</div>';
                })
                $("#bod").html(html);
            }else {
                alert(data.msg);
            }
        }
    });
});