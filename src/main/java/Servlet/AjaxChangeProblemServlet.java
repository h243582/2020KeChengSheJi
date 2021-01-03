package Servlet;

import Dao.BasicInfoDAO;
import Dao.ProblemDAO;
import Model.BasicInfo;
import Model.Problem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AjaxChangeProblemServlet")
public class AjaxChangeProblemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8" );
        Integer userid = Integer.valueOf(request.getParameter("userid" ));
        System.out.println("AjaxChangeProblemServlet管理员：userid:"+userid);

        BasicInfo info = new BasicInfoDAO().getBasicInfoById(userid);
        info.setAccountId(userid);
        System.out.println(info);
        request.getSession().setAttribute("BasicInfo",info);

        Problem pro = new ProblemDAO().getProblemById(userid);
        request.getSession().setAttribute("Problem",pro);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
