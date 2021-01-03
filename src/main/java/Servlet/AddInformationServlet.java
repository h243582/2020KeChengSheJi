package Servlet;

import Dao.BasicInfoDAO;
import Model.Account;
import Model.BasicInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AddInformationServlet" )
public class AddInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8" );
        String method = request.getParameter("method" );
        if (method.equals("Compile" )) {
            //有个人信息，第n次添加页面，从Session获取
            BasicInfo info = requestDataObj(request);
            BasicInfoDAO infoDAO = new BasicInfoDAO();
            boolean flag = infoDAO.updateBasicInfo(info);
             request.getSession().setAttribute("BasicInfo",info);

            request.getRequestDispatcher("information.jsp" ).forward(request, response);
        } else if (method.equals("first" )) {
            //没有个人信息，第一次添加页面，从页面获取
            BasicInfo info = requestDataObj(request);
            System.out.println(info);
            BasicInfoDAO infoDAO = new BasicInfoDAO();
            //将对象保存到数据库
            Integer infoID = infoDAO.saveBasicInfo(info);
            System.out.println("infoID:" + infoID);

            //将当前登录用户的信息ID，保存到Session中
            request.getSession().setAttribute("InfoID", infoID);

            //跳转到简历信息页面，展示刚添加的简历信息
            info.setBasicId(infoID);
            //简历放入请求作用域，在简历展示页面显示该对象信息
            request.getSession().setAttribute("BasicInfo", info);
            //请求转发到简历展示页面
            request.getRequestDispatcher("information.jsp" ).forward(request, response);
        }else if (method.equals("read" )) {
            BasicInfoDAO infoDAO = new BasicInfoDAO();
            Integer userId = (Integer) request.getSession().getAttribute("UserId" );
            System.out.println("read;userId"+userId);
            BasicInfo info = infoDAO.getBasicInfoById(userId);
            System.out.println(info);
            request.getSession().setAttribute("BasicInfo", info);
            request.getRequestDispatcher("information.jsp" ).forward(request, response);
        }
    }


    //获取页面数据，封装ResumeBasicInfo
    private BasicInfo requestDataObj(HttpServletRequest request) {
        //获取页面参数
        String realName = request.getParameter("realName" );
        String gender = request.getParameter("gender" );
        String birthday = request.getParameter("birthday" );
        String telephone = request.getParameter("telephone" );
        String qq = request.getParameter("qq" );

        //从session中取出登录用户的id
        Account acc = (Account) request.getSession().getAttribute("Account" );
        BasicInfo info = new BasicInfo(realName, gender, Integer.parseInt(birthday), telephone, qq);
        info.setAccountId(acc.getUserId());
        return info;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
