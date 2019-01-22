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
$("#returnTop").on("click",function(){
    isReturnToping=true;
    if ($('html').scrollTop()) {
        $('html').animate({ scrollTop: 0 }, 600);
        $("#returnTop").fadeOut(600,function(){
            isReturnToping=false;
        });
        return;
    }
    $('body').animate({ scrollTop: 0 }, 600);
    $("#returnTop").fadeOut(600,function(){
        isReturnToping=false;
    });
    return;
});
var currentPage=2;//当前页
var index=8;//当前排名
var isScrollEnd=false;
var isReturnToping=false;//是否正在返回顶部
var isShowReturnTop=false;//'返回顶部'是否显示
window.onscroll=function(){
    if(isReturnToping==false){
        if(getScrollTop()>10&&isShowReturnTop==false){
            $("#returnTop").fadeIn(600,function(){
                isShowReturnTop=true;
            });
        }else if(getScrollTop()<10&&isShowReturnTop==true){
            $("#returnTop").fadeOut(600,function(){
                isShowReturnTop=false;
            });
        }
    }
    if(getScrollTop()+getClientHeight()+10>getScrollHeight()&&!isScrollEnd){
        $.ajax({
            type:"get",
            dataType:"json",
            timeout:3000,
            async:false,
            url:"api/books/borrowtop",
            data:{currentPage:currentPage,pageSize:8},
            success:function(data){
                if(data!=null&&data.code==1){
                    var html = '';
                    $.each(data.result.list,function (i,item) {
                        html+='<div class="col-md-12">';
                        html+='<div class="col-md-1">';
                        ++index;
                        html+='<p class="top">'+index+'</p>';
                        html+='<p class="num">'+"借阅次数："+item.bookBorrow+'</p>';
                        html+='</div>';
                        html+='<div class="col-md-11 tuijian">';
                        html+='<div class="col-md-2">';
                        html+='<a href="javascript:load('+item.bookId+')">';
                        html+='<img class="tupian2"src="/api/books/findBookCover?id='+item.bookId+'"/>';
                        html+='</a>';
                        html+='</div>';
                        html+='<div class="col-md-10 info">';
                        html+='<a href="javascript:load('+item.bookId+')">';
                        html+='<h3>'+item.bookName+'</h3>';
                        html+='</a>';
                        html+='<p>'+item.bookWriter+'</p>';
                        html+='<p>'+item.bookPress+'</p>';
                        html+='<p>'+item.bookInfo+'</p>';
                        html+='</div>';
                        html+='</div>';
                        html+='</div>';
                    });
                    html+='<div style="clear: both;"></div>';
                    $("#bod1").append(html);
                    ++currentPage;
                }else{
                    $("#bod1").append("<h3 style='text-align: center;'>---到底了---</h3>");
                    isScrollEnd=true;
                }
            },
            error:function(){
                alert("服务器异常");
            },
            complete:function(XMLHttpRequest,status){
            if(status=='timeout'){
                alert("请求超时");
            }
        }
        });
    }
};