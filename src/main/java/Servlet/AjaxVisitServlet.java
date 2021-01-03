package Servlet;

import Dao.AccountDAO;
import Dao.ProblemDAO;
import Model.Account;
import Model.BasicInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/AjaxVisitServlet")
public class AjaxVisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //把这个设置为null，没登录的时候就可以显示是否登录的对话框了
        request.getSession().setAttribute("UserId",null);
        BasicInfo info = new BasicInfo("游客","未知",-1,"未知","未知");
        request.getSession().setAttribute("BasicInfo",info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
