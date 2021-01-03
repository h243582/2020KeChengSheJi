package Servlet;

import Dao.AccountDAO;
import Dao.ProblemDAO;
import Model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/AjaxProblemServlet")
public class AjaxProblemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Integer userId = (Integer) request.getSession().getAttribute("UserId");
        System.out.println("AjaxProblemServlet;userId:"+userId);
        //创建操作数据库类
        ProblemDAO ad = new ProblemDAO();
        Integer count = ad.isExistProblem(userId);
        Map<String,Boolean> map = new HashMap<String, Boolean>() ;
        System.out.print("填过问卷了：");
        if (count != null){
            //已弄过了
            System.out.println(true);
            map.put("flag",true);
        }else {
            System.out.println(false);
            map.put("flag",false);
        }
        ObjectMapper om = new ObjectMapper();
        om.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
