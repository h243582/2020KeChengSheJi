<%@ page import="Model.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="Model.Problem" %>
<%@ page import="Dao.ProblemDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="css/startPorblem/管理员.css">

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="js/startPorblem/显示所有用户.js"></script>

    <script>
        var flagRunn = true;
        var flag = true;
        $(function () {
            <%
                boolean flag = (boolean) request.getSession().getAttribute("flag");
                boolean flagRun = (boolean) request.getSession().getAttribute("flagRun");
                boolean flagDivIframe = (boolean)request.getSession().getAttribute("flagDivIframe");
            %>
            $(".userList").click(function (){
                console.log("<%=flag%>,<%=flagRun%>,<%=flagDivIframe%>")

                if (flag){
                    ttt();
                    flag=false;
                }
                if (flagRunn){
<%--                    <%flagRun =false;%>--%>
                    flagRunn=false;
                    $(".userList").html("用户列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击收起");
                    $(".run").fadeIn;
                    $(".run").fadeIn("show");
                    $(".run").fadeIn(1000);
                }else {
                    flagRunn=true;
<%--                    <%flagRun =true;%>--%>
                    $(".userList").html("用户列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击展开");
                    $(".run").fadeOut;
                    $(".run").fadeOut("show");
                    $(".run").fadeOut(1000);

                }

            })
        })
        function ttt(){
                <%List<Account> accountList =  (List<Account>) request.getSession().getAttribute("AnyUser");%>
                <% for(Account acc:accountList){%>
                $(".list-group").append('<a href="javascript:changeProblem(<%=acc.getUserId()%>);"  class="<%=acc.getUserId()%> run list-group-item list-group-item-action" style="display:none"><%=acc.getUserName()%></a>')
                <%}%>
        }
        function changeProblem(userid) {
            console.log(userid);
            $.ajax({
                url: "AjaxChangeProblemServlet",
                async: false,
                data: "userid=" + userid,
                // cache: false,  // 是否缓存
                type: 'POST',
                success:function (){
                    document.getElementById('iframeId').contentWindow.location.reload();
                    // window.location.reload();
                }
            })

            document.getElementById('iframeId').contentWindow.location.reload();
            document.getElementById('iframeId').contentWindow.location.reload();
            document.getElementById('iframeId').contentWindow.location.reload();

            // var flagDivIframe=true;
            <%--if (<%=flagDivIframe%>){--%>
            <%--    <%flagDivIframe=false;%>--%>
                $("#iframeId").attr("class","iframe active")
            <%--}else {--%>
            <%--    <%flagDivIframe=true;%>--%>
            <%--    $("#iframeId").attr("class","iframe")--%>
            <%--}--%>

        }
    </script>
</head>
<body>
<div class="divIframe">
    <iframe class="iframe" src="Problem.jsp" frameborder="0" seamless id="iframeId"></iframe>
</div>
<div class="jumbotron jumbotron-fluid"  style="padding-top: 20px;padding-bottom: 20px;padding-left:0px;text-align: left;">
    <div class="container" style="margin-left: 0px">
        <h4 class="display-4" style="font-size: 36px;text-align: left;">管理员界面</h4>
        <p class="lead">这是个管理员界面</p>

    </div>
</div>
<div class="list-group">
    <a href="#" class="userList list-group-item list-group-item-action active">
        用户列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击展开
    </a>
</div>



</body>
</html>