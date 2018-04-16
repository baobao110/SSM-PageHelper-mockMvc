<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/14 0014
  Time: 下午 4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工</title>
</head>

<body>

    <%--显示内容--%>
    <div class="container" id="example-1">
        <%--显示标题--%>
        <div class="row">
            <div class="col-md-12">信息查询</div>
        </div>
        <%--显示按钮--%>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">.
                <button type="button" class="btn btn-success">新增</button>
                <button type="button" class="btn btn-danger">删除</button>
            </div>
        </div>
        <%--显示数据--%>
            <table>
                <tr v-for="item in items">
                <th>
                    {{ item.id }}
                </th>
                    <th>
                        {{ item.name}}
                    </th>
                    <th>
                        {{ item.sex}}
                    </th>
                    <th>
                        {{ item.email}}
                    </th>
                    <th>
                        {{ item.deptId}}
                    </th>
            </tr>
            </table>
            <button onclick="Sub()">上一页 </button>
            <button onclick="Next()">下一页 </button>
            <span>{{pageNum}}/{{page}}</span>
    </div>


    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <script  type="text/javascript"src="/static/js/vue.js"></script>>
    <script>
        var pn=1;
        var example1 = new Vue({
            el: '#example-1',
            data: {
                items: [],
                pages:0,
                pageNum:0,
            },
            created: function () {
                init();
            }
        })

        function init() {
            $.post('/emp/all.do',{}, back);
        }
        /*注意这里的ajax*/
        function back(ajaxDAO){
            if(ajaxDAO.success){
                example1.items=ajaxDAO.data.list;
             example1.page=ajaxDAO.data.pages;
             example1.pageNum=ajaxDAO.data.pageNum;
            }

        }
        function Sub(){
            if(pn==1){
                return false;
             }
             pn=pn-1;
            var param={
                pn:pn,
            };
            $.post('/emp/all.do',param, back);
        }

        function Next(){
            if(pn== example1.pages){
                return false;
            }
            pn=pn+1;
            var param={
                pn:pn,
            };
            $.post('/emp/all.do',param, back);
        }

    </script>
</body>
</html>
