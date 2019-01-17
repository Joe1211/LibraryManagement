<%--
  Created by IntelliJ IDEA.
  User: 韩佳奇
  Date: 2018/12/17
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/img/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <style>
        body{
            background: rgba(255,255,255,0);
        }
    </style>
</head>

<body data-type="index">

<div class="container">
    <!-- 内容区域 -->
    <div class="container-fluid am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 图表统计
                    <small>LibraryManagement</small>
                </div>
            </div>
        </div>
    </div>


    <div id="main1" style="width: 1000px;height:400px;">

    </div>

    <div id="main2" style="width: 1000px;height:400px;">

    </div>

    <div id="main3" style="width: 1000px;height:400px;">

    </div>

</div>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"></script>

<script type="text/javascript">

    $.post('${pageContext.request.contextPath}/admin/findhostbook', function (data) {
        // console.info(data[0]);
        var xA = [];
        var yA = [];
        for (var i = 0; i < data.length; i++) {
            xA.push(data[i].bookName);
            yA.push(data[i].bookBorrow);
        }
        var myChart = echarts.init(document.getElementById('main1'));
        var option = {
            title: {
                text: '被借阅图书排名'
            },
            tooltip: {},
            legend: {
                data: ['被借阅次数']
            },
            xAxis: {
                data: xA,
                axisLabel: {
                    interval: 0,
                    rotate: -25
                }
            },
            yAxis: {},
            series: [{
                name: '次数',
                type: 'bar',
                data: yA,
                itemStyle:{
                    normal:{
                        color:function(params){
                            var colorList=['#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'];
                            return colorList[params.dataIndex];
                        }
                    }
                }
            }]
        };
        myChart.setOption(option);
    });

    $.post('${pageContext.request.contextPath}/admin/findclickbook', function (data) {
        console.info(data[0]);
        var xA = [];
        var yA = [];
        for (var i = 0; i < data.length; i++) {
            xA.push(data[i].bookName);
            yA.push(data[i].bookClick);
        }
        var myChart = echarts.init(document.getElementById('main2'));
        var option = {
            title: {
                text: '点击图书排名榜'
            },
            tooltip: {},
            legend: {
                data: ['被点击次数']
            },
            xAxis: {
                data: xA,
                axisLabel: {
                    interval: 0,
                    rotate: -25
                }
            },
            yAxis: {},
            series: [{
                name: '次数',
                type: 'bar',
                data: yA,
                itemStyle:{
                    normal:{
                        color:function(params){
                            var colorList=['#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'];
                            return colorList[params.dataIndex];
                        }
                    }
                }
            }]
        };
        myChart.setOption(option);
    });

    $.post("${pageContext.request.contextPath}/admin/findBookTypeBorrowSum",function(data){
        var legendArr=[];
        var dataArr=[];
        for(var i=0;i<data.length;i++){
            legendArr.push(data[i].bookTypeName);
            dataArr.push({name:data[i].bookTypeName,value:data[i].borrowSum});
        }
        var myChart=echarts.init(document.getElementById("main3"));
        var option={
            title:{
                text:"各类图书借阅情况"
            },
            tooltip:{},
            legend:{
                type:"scroll",
                data:legendArr,
                orient: 'vertical',
                left: 10,
                top: 30,
            },
            series:[{
                type:"pie",
                name:"类别",
                data:dataArr
            }]
        }
        myChart.setOption(option);
    });


</script>
</body>

</html>
