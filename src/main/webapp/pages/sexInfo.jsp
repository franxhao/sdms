<%--
  Created by IntelliJ IDEA.
  User: yanggege
  Date: 2021/8/17
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>男女占比</title>
    <meta name="description" content="男女占比">
    <meta name="keywords" content="男女占比">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- 引入样式 -->
    <link rel="stylesheet" href="../css/style2.css">
    <script src="../js/echarts.js"></script>
</head>
<body class="hold-transition">
<div id="app">
    <div class="content-header">
        <h1>统计分析<small>男女占比</small></h1>
        <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>学生信息管理</el-breadcrumb-item>
            <el-breadcrumb-item>男女占比</el-breadcrumb-item>
        </el-breadcrumb>
    </div>
    <div class="app-container">
        <div class="box">
            <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
            <div id="chart1" style="height:600px;"></div>
        </div>
    </div>
</div>
</body>
<!-- 引入组件库 -->
<script src="../js/vue.js"></script>
<script src="../js/axios-0.18.0.js"></script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('chart1'));

    // 使用刚指定的配置项和数据显示图表。
    //myChart.setOption(option);

    axios.get("${pageContext.request.contextPath}/stuManagement/sexCount").then((res)=>{
        var option = {
            title : {
                text: '男女占比',
                subtext: '',
                x:'center'
            },
            tooltip : {//提示框组件
                trigger: 'item',//触发类型，在饼形图中为item
                formatter: "{a} <br/>{b} : {c} ({d}%)"//提示内容格式
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['男','女']
            },
            series : [
                {
                    name: '男女占比',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:res.data,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myChart1.setOption(option);
    });
</script>
</html>
