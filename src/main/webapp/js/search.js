window.onload=function(){
    // 显示所有标签（打开页面自动执行）
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

    // 显示中图法类型搜索(部类)
    $.ajax({
        type:'get',
        url:'api/booktypes',
        dataType:'json',
        success(data){
                var html = '';
                html+='<option>请选择</option>';
                $.each(data,function (i,item) {
                    html+='<option value="'+item.bookTypeId+'">'+item.bookTypeName+'</option>'
                })
                $("#type0").html(html);
        }
    })
}


//显示模糊查询图书信息并加载分页
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
        //是否有下一页
        if (test = data.result.hasNextPage) {
            html+='<li><a href="javascript:loadData('+(data.result.pageNum+1)+')">'+"下一页"+'</a></li>';
        }else{
            html+='<li><a href="avascript:void(0))">'+"下一页"+'</a></li>';
        }

        html+='  </ul>';
        html+='   </nav>';
        html+='  </div>';
        $("#bod").html(html);
    }else {
        alert(data.msg);
    };
};

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
    });
});
// 模糊查询加载分页
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



//显示标签图书信息并加载分页
function loadLabelInfo(data){
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
            html+='<li><a href="javascript:loadLabelData('+(data.result.pageNum-1)+')">'+"上一页"+'</a></li>';
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
                html+='<li><a href="javascript:loadLabelData('+n+')">'+n+'</a></li> ';
            }
        })

        // 下一页
        //是否有下一页
        if (test = data.result.hasNextPage) {
            html+='<li><a href="javascript:loadLabelData('+(data.result.pageNum+1)+')">'+"下一页"+'</a></li>';
        }else{
            html+='<li><a href="avascript:void(0))">'+"下一页"+'</a></li>';
        }

        html+='  </ul>';
        html+='   </nav>';
        html+='  </div>';
        $("#bod").html(html);
    }else {
        alert(data.msg);
    };
};
// 标签查询
$('#labelsubmit').click(function(){
    var data = $("form").serialize(); // 表单序列化
    $.ajax({
        type : 'get',
        url : 'api/books/label'+'?'+data,
        success : function(data) {
            // 显示图书信息
            loadLabelInfo(data);
        }
    });
});
// 标签查询加载分页
function loadLabelData(page) {
    var data = $("form").serialize(); // 表单序列化
    $.ajax({
        type: 'get',
        url: 'api/books/label'+'?'+data+ '&pn=' + page,
        dataType: 'json',
        success: function (data) {
            // 显示图书信息
            loadLabelInfo(data);
        }
    })
}

// 根据部类id查询一级分类
$("#type0").change(function () {
    $.ajax({
        type:'get',
        url:'api/typeones/'+$(this).val(),
        dataType:'json',
        success:function (data) {
            var html = '';
            html+='<option>请选择一级分类</option>';
            $.each(data,function (i,item) {
                html+='<option value="'+item.typeOneValue+'">'+item.typeOneType+'</option>'
            })
            $("#type1").html(html);
        }
    })
})

// 根据一级分类值查询二级分类
$("#type1").change(function () {
    $.ajax({
        type:'get',
        url:'api/typetwos/'+$(this).val(),
        dataType:'json',
        success:function (data) {
            var html = '';
            html+='<option>请选择二级分类</option>';
            $.each(data,function (i,item) {
                html+='<option value="'+item.typeTwoValue+'">'+item.typeTwoType+'</option>'
            })
            $("#type2").html(html);
        }
    })
})

//根据二级分类查询图书
$("#selectType").click(function () {
    var two = $("#type2").val();
    $.ajax({
        type:'get',
        url:'api/books/type'+'?booktype='+two,
        dataType:'json',
        success:function (data) {
            loadTypeInfo(data);
        }
    })
})

//分类查询加载分页
function loadTypeData(page) {
    var two = $("#type2").val();
    $.ajax({
        type: 'get',
        url: 'api/books/type'+'?booktype='+two+ '&pn=' + page,
        dataType: 'json',
        success: function (data) {
            // 显示图书信息
            loadTypeInfo(data);
        }
    })
}

//显示分类图书信息并加载分页
function loadTypeInfo(data){
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
        $("#bod").html(html);
    }else {
        alert(data.msg);
    };
};
