<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="Model.Problem" %>
<%@ page import="Model.BasicInfo" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>小学生心理健康状况调查问卷_问卷星</title>
    <link rel="stylesheet" href="css/startPorblem/readProblem.css">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="js/startPorblem/startPorblem.js"></script>
    <script src="js/login/用户已存在.js"></script>
    <link rel="stylesheet" href="css/startPorblem/Problem.css">

    <style>
        input{
            width: 152px;
        }
    </style>
</head>
<body>
<%BasicInfo info = (BasicInfo) request.getSession().getAttribute("BasicInfo");%>
<%Problem problem = (Problem) request.getSession().getAttribute("Problem");%>

<div class="backImg"></div>
<div class="mainBack">
    <div class="Top">
        <div>小学生心理健康状况调查问卷</div>
        <div>
            亲爱的同学:<br>
            &nbsp;&nbsp;&nbsp;&nbsp;你好！<br>
            我们是即将为你们服务的长沙市心家园公益人服务中心的心理志愿者，为了更好地设计你们的心理课程，我们进行了此次问卷调查。本次调查为匿名方式，因此希望你能够认真、真实地填答，回答无对错之分。
            你的帮助对我们很重要，衷心感谢你的合作！
        </div>

            <div class="start">
                <div class="bigTitle">
                    <table id="information" cellspacing="10" bgcolor="#EEEEEE" style="border-radius: 10px">
                        <tr>
                            <th width="90px" align="right" bgcolor="#F8F8F8">姓名：</th>
                            <td border="0"><input type="text" name="realName" value="<%=info.getBasicInfoName()%>" disabled></td>
                        </tr>

                        <tr>
                            <th width="90px" align="right" bgcolor="#F8F8F8">性别：</th>
                            <td border="0"><input type="text" name="realName" value="<%=info.getBasicInfoGender()%>" disabled></td>

                        </tr>
                        <tr>
                            <th width="90px" align="right">年龄：</th>
                            <td><input type="text" name="birthday" value="<%=info.getBasicInfoAge()%>" disabled></td>
                        </tr>
                        <tr>
                            <th width="90px" align="right">手机号：</th>
                            <td><input type="text" name="telephone" value="<%=info.getBasicInfoTelephone()%>" disabled></td>
                        </tr>
                        <tr>
                            <th width="90px" align="right">QQ：</th>
                            <td><input type="text" name="qq" value="<%=info.getBasicInfoQQ()%>" disabled></td>
                        </tr>
                    </table>

                    <div class="title">一、基本情况:</div>

                    <div class="littleTitleTop">
                        <p>1、基本信息&nbsp;</p>
                        <div>性别&nbsp;</div>
                        <input name="text1" type="text" class="101" value="<%=problem.getText1()==null?"未填":problem.getText1()%>" disabled><br>
                        <div>年龄（周岁）&nbsp;</div>
                        <input name="text2" type="text" class="101" value="<%=problem.getText2()==null?"未填":problem.getText2()%>" disabled><br>
                        <div>学校&nbsp;</div>
                        <input name="text3" type="text" class="101" value="<%=problem.getText3()==null?"未填":problem.getText3()%>" disabled><br>
                        <div>年级&nbsp;</div>
                        <input name="text4" type="text" class="101" value="<%=problem.getText4()==null?"未填":problem.getText4()%>" disabled><br>
                        <div>班级&nbsp;</div>
                        <input name="text5" type="text" class="101" value="<%=problem.getText5()==null?"未填":problem.getText5()%>" disabled><br>
                    </div>
                    <div class="littleTitle">
                        <!--第1.2题-->
                        <div class="text2" class="t2" >
                            <p>2.爸爸的最高学历是？&nbsp;</p>
                            <input name="102" type="text" class="101" value="<%=problem.getT2()==null?"未填":problem.getT2()%>" disabled><br>
                        </div>
                        <!--第1.3题-->
                        <div class="text3">
                            <p>3.妈妈的最高学历是？&nbsp;</p>
                            <input name="103" type="text" class="101" value="<%=problem.getT3()==null?"未填":problem.getT3()%>" disabled><br>
                        </div>
                        <!--第1.4题-->
                        <div class="text4">
                            <p>4.你有多少个兄弟姐妹&nbsp;</p>
                            <input name="104" type="text" class="101" value="<%=problem.getT4()==null?"未填":problem.getT4()%>" disabled><br>
                        </div>


                        <% String[] T2_1 = problem.getT01();String T2_1t = problem.getT01t();%>
                        <div class="title">二、具体情况:</div>
                        <!--第2.1题-->
                        <div class="t1">
                            <p>1．你现在和谁住在一起?（多选）&nbsp;</p>
                            <c:if  test="problem">

                            </c:if><%--                            <%=Arrays.toString(problem.getT01())%>--%>

                            <input name="T2_1" type="text" class="T2_1 checkbox" value="<%=problem.getT01()==null?(problem.getT01t()==null?"未填":problem.getT01t()):(Arrays.toString(problem.getT01())+' '+problem.getT01t() )%>" disabled><br>
                            <%--                           <% if (T2_1!=null){for(String str:T2_1){%><%=str+"  "%><%}} if (T2_1t!=null){<%=T2_1t%><%}%>--%>


                        </div>
                        <!--第2.2题-->
                        <div class="t2">
                            <p>2.平时和你住在一起的人对你的态度是怎样的?&nbsp;</p>
                            <input name="T2_2" type="text" class="T2_2" value="<%=problem.getT02()==null?"未填":problem.getT02()%>" disabled><br>
                        </div>
                        <!--第2.3题-->
                        <div class="t3">
                            <p>3.平时照顾你的人对你的管教是什么样子的?&nbsp;</p>
                            <input name="T2_3" type="text" class="T2_3" value="<%=problem.getT03()==null?"未填":problem.getT03()%>" disabled><br>
                        </div>
                        <!--第2.4题-->
                        <div class="t4">
                            <p>4.爸爸（妈妈）平时跟你聊天的内容主要是什么?（多选）&nbsp;</p>
                            <input name="T2_4" type="text" class="T2_4 checkbox" value="<%=problem.getT04()==null?(problem.getT04t()==null?"未填":problem.getT04t()):(Arrays.toString(problem.getT04())+' '+problem.getT04t() )%>" disabled><br>
                        </div>
                        <!--第2.5题-->
                        <div class="t5">
                            <p>5.你觉得爸爸妈妈爱你吗？（ ）&nbsp;</p>
                            <input name="T2_5" type="text" class="T2_5" value="<%=problem.getT05()==null?"未填":problem.getT05()%>" disabled><br>
                        </div>
                        <!--第2.6题-->
                        <div class="t6">
                            <p>6．你有心事或者遇到困难时一般向谁诉说（多选）&nbsp;</p>
                            <input name="T2_6" type="text" class="T2_6 checkbox" value="<%=problem.getT06()==null?(problem.getT06t()==null?"未填":problem.getT06t()):(Arrays.toString(problem.getT06())+' '+problem.getT06t() )%>" disabled><br>

                        </div>
                        <!--第2.7题-->
                        <div class="t7">
                            <p>7.老师对你的态度怎么样?&nbsp;</p>
                            <input name="T2_7" type="text" class="T2_7" value="<%=problem.getT07()==null?"未填":problem.getT07()%>" disabled><br>
                        </div>
                        <!--第2.8题-->
                        <div class="t8">
                            <p>8.你是否愿意主动与老师交谈心里话?&nbsp;</p>
                            <input name="T2_8" type="text" class="T2_8" value="<%=problem.getT08()==null?"未填":problem.getT08()%>" disabled><br>
                        </div>
                        <!--第2.9题-->
                        <div class="t9">
                            <p>9.你对班集体的态度？</p>
                            <input name="T2_9" type="text" class="T2_9" value="<%=problem.getT09()==null?"未填":problem.getT09()%>" disabled><br>
                        </div>
                        <!--第2.10题-->
                        <div class="t10">
                            <p>10.你在学校里，有朋友吗?</p>
                            <input name="T2_10" type="text" class="T2_10" value="<%=problem.getT10()==null?"未填":problem.getT10()%>" disabled><br>
                        </div>

                        <!--第2.29题-->
                        <div class="t11" id="yyy">
                            <p>11.你对自己有不满意的地方吗?</p>
                            <input name="T2_11" type="text" class="T2_11" value="<%=problem.getT11()==null?"未填":problem.getT11()%>" disabled><br>

                        </div>
                        <!--第2.30题-->
                        <div class="t12">
                            <p>12．你对自己哪里不满意呢?（多选）</p>
                            <input name="T2_12" type="text" class="T2_12 checkbox" value="<%=problem.getT12()==null?(problem.getT12t()==null?"未填":problem.getT12t()):(Arrays.toString(problem.getT12())+' '+problem.getT06t() )%>" disabled><br>
                        </div>
                        <!--第2.35题-->
                        <div class="T2_13">
                            <p>13.目前，你最大的烦恼是什么？</p>
                            <div><label>
                                <textarea name="T2_13_t" class="T2_13_t" cols="80" rows="5" disabled><%=problem.getT13t()==null?"未填":problem.getT13t()%></textarea>
                            </label></div>
                        </div>
                    </div>
                </div>
            </div>

    </div>
</div>


<div class="black_overlay_0" id="black" style="display: none"></div>

<div class="window_0" id="window" style="display: none">
    <button onclick="outChange()"></button>
    <a href="login.html"><br><br>您还没登录，您要先登录吗?</a>
</div>
</body>

</html>



