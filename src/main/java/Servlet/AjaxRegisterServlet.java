package Servlet;

import Dao.AccountDAO;
import Model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/AjaxRegisterServlet")
public class AjaxRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("username");

        //System.out.println("接受到前台请求.........");

        //创建操作数据库类
        AccountDAO ad = new AccountDAO();
        Integer count = ad.selectUserEmailCount(userName);
        if (count > 0){
            //已有用户名
            response.getWriter().print("已存在"); // 将结果返回到前端
//            System.out.println("不合法");
        }else {
            response.getWriter().print("不存在"); // 将结果返回到前端
//            System.out.println("合法");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
