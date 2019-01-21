//获取滚动条当前位置
function getScrollTop(){
    var scrollTop = 0;
    if(document.documentElement && document.documentElement.scrollTop) {
        scrollTop = document.documentElement.scrollTop;
    } else if(document.body) {
        scrollTop = document.body.scrollTop;
    }
    return scrollTop;
}
//设置滚动条位置
function setScrollTop(offset){
    if(offset>=0){
        if(document.documentElement && document.documentElement.scrollTop) {
            document.documentElement.scrollTop=offset;
        } else if(document.body) {
            document.body.scrollTop=offset;
        }
    }else{
        if(document.documentElement && document.documentElement.scrollTop) {
            document.documentElement.scrollTop=getClientHeight()-Math.abs(offset);
        } else if(document.body) {
            document.body.scrollTop=getClientHeight()-Math.abs(offset);
        }
    }

}
//获取当前可视范围高度
function getClientHeight(){
    var clientHeight = 0;
    if(document.body.clientHeight && document.documentElement.clientHeight) {
        clientHeight = Math.min(document.body.clientHeight, document.documentElement.clientHeight);
    } else {
        clientHeight = Math.max(document.body.clientHeight, document.documentElement.clientHeight);
    }
    return clientHeight;
}
//获取文档完整的高度
function getScrollHeight() {
    return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight);
}
window.onscroll=function(){
    if(getScrollTop()+getClientHeight()+10>getScrollHeight()){
        $.ajax({
            type:"get",
            dataType:"json",
            url:"api/books/borrowtop",
            success:function(data){
                if(data!=null&&data.code==1){
                    var html = '';
                    $.each(data.result,function (i,item) {
                        html+='<div class="col-md-12">';
                        html+='<div class="col-md-1">';
                        html+='<p class="top top-'+(i+1)+'">'+(i+1)+'</p>'
                        html+='<p class="num top-'+(i+1)+'">'+"借阅次数："+item.bookBorrow+'</p>';
                        html+='</div>';
                        html+='<div class="col-md-11 tuijian">';
                        html+='<div class="col-md-2">';
                        html+='<a href="javascript:load('+item.bookId+')">';
                        html+='<img class="tupian2"src="/api/books/findBookCover?id='+item.bookId+'"/>';
                        html+='</a>'
                        html+='</div>';
                        html+='<div class="col-md-10 info">';
                        html+='<a href="javascript:load('+item.bookId+')">';
                        html+='<h3>'+item.bookName+'</h3>';
                        html+='</a>'
                        html+='<p>'+item.bookWriter+'</p>';
                        html+='<p>'+item.bookPress+'</p>';
                        html+='<p>'+item.bookInfo+'</p>';
                        html+='</div>';
                        html+='</div>';
                        html+='</div>';
                    });
                    html+='<div style="clear: both;"></div>';
                    $("#bod1").append(html);
                }
            },
            error:function(){
                alert("服务器异常");
            }
        });
    }
}