package Servlet;

import Dao.AccountDAO;
import Dao.GetAnythingDAO;
import Model.Account;
import Model.BasicInfo;
import Model.Problem;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(urlPatterns = "/AjaxGetAnyServlet")
public class AjaxGetAnyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
            GetAnythingDAO gdao = new GetAnythingDAO();
            List<Account> anyUser = gdao.getAnyUser();
            request.getSession().setAttribute("AnyUser", anyUser);
            System.out.println(anyUser);

            List<BasicInfo> anyInformation = gdao.getAnyInformation();
            request.getSession().setAttribute("AnyInformation", anyInformation);
            System.out.println(anyInformation);

            List<Problem> anyProblem = gdao.getAnyProblem();
            request.getSession().setAttribute("AnyProblem", anyProblem);
            System.out.println(anyProblem);

            //设置游客information
            BasicInfo info = new BasicInfo(" ", " ",20 , "  ", "  ");
//        BasicInfo info = new BasicInfo("游客", "未知", -1, "未知", "未知");
        request.getSession().setAttribute("BasicInfo",info);
        request.getSession().setAttribute("Problem",new Problem());

        request.getSession().setAttribute("flag",true);
        request.getSession().setAttribute("flagRun",true);
        request.getSession().setAttribute("flagDivIframe",true);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
