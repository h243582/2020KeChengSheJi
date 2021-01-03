package Servlet;

import Dao.AccountDAO;
import Dao.BasicInfoDAO;
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

@WebServlet(urlPatterns = "/AjaxPanDanLoginServlet")
public class AjaxPanDanLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        BasicInfo info = (BasicInfo) request.getSession().getAttribute("BasicInfo");
//        BasicInfo info = new BasicInfoDAO().getBasicInfoById((Integer) request.getSession().getAttribute("UserId"));
        System.out.println("AjaxPanDanLoginServlet;BasicInfo:"+info);
        Map<String,Boolean> map = new HashMap<String, Boolean>() ;

        if (info.getBasicInfoName() == null||info.getBasicInfoName().equals("游客")){
            //没有注册
            System.out.println(false);
            map.put("flag",false);
        }else {
            System.out.println(true);
            map.put("flag",true);
        }
        ObjectMapper om = new ObjectMapper();
        om.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
