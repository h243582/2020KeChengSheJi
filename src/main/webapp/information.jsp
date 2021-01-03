<%--<jsp:useBean id="InfoID" scope="request" type=""/>--%>
<%--<jsp:useBean id="BasicInfo" scope="request" type="Model.BasicInfo"/>--%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="Model.BasicInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/addInformation/addInformation.css">
    <link rel="stylesheet" href="css/addInformation/information.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script>
        function logout(){
            $.post("AjaxDeleteSessionServlet",null,null,"ajax");
            window.location.href="index.html";
        }
    </script>
</head>
<body>
<%--<form>--%>
<img src="image/information/bacg.jpg" alt="" width="100%" class="backImg">
<div class="mainBack">
    <div class="resume_left">
        <div class="all_resume">
            <div class="table_style" style="width: 80%; background-color: rgb(238, 238, 238)">
                <div class="star" style="padding-top: 10px;padding-right: 5%">
                    <img src="image/information/star.png" alt="" class="" width="100px" height="100px">
                    在线问卷调查<br>系统
                </div>
                <div class="resume_title">
                    <div>我的个人信息</div>
                </div>
                <table cellspacing="10" bgcolor="#EEEEEE">
                    <tr>
                        <th width="90px" align="right" bgcolor="#F8F8F8">姓名：</th>
                        <td border="0"><input type="text" name="realName" value="${BasicInfo.basicInfoName}" disabled></td>
                    </tr>
                    <tr>
<%--                        <th>性别：</th>--%>
                        <th width="90px" align="right" bgcolor="#F8F8F8">性别：</th>
                        <td border="0"><input type="text" name="realName" value="${BasicInfo.basicInfoGender}" disabled></td>

                    </tr>
                    <tr>
                        <th width="90px" align="right">年龄：</th>
                        <td><input type="text" name="birthday" value="${BasicInfo.basicInfoAge}" disabled></td>
                    </tr>
                    <tr>
                        <th width="90px" align="right">手机号：</th>
                        <td><input type="text" name="telephone" value="${BasicInfo.basicInfoTelephone}" disabled></td>
                    </tr>
                    <tr>
                        <th width="90px" align="right">QQ：</th>
                        <td><input type="text" name="qq" value="${BasicInfo.basicInfoQQ}" disabled></td>
                    </tr>
                </table>
                <div style="margin-left:100px;">
                    <a href="addInformation.jsp"><button name="" class="button1" value="">编辑个人信息</button></a>
                    <form  method="post" id="submitButton2">
                        <button name="" class="button2" id="button2" value="">查看自己的问卷</button>
                    </form>
<%--                    <form action="FirstAddProblemServlet?method=update" method="post" id="submitButton3">--%>
<%--                        <a href="javascript:;"><button name="" id="submitUpdate" class="button2" value="" style="display: none">修改问卷</button></a>--%>
<%--                    </form>--%>
                    <a href="javascript:logout()"><button name="" class="button3" value="">注销登录</button></a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

</div>

<%--</form>--%>
<script>
    $(function (){
        $.post("AjaxProblemServlet",{},function (result){
        console.log(result);
        if (result.flag){
            //已弄过了
            $("#submitButton2").attr("action","FirstAddProblemServlet?method=read");
            // $("#submitUpdate").css("display","inline");

        }else{
            $("#submitButton2").attr("action","FirstAddProblemServlet?method=new");
            $("#button2").text("填写问卷")

        }
        },"json")
    })
</script>
</body>
</html>