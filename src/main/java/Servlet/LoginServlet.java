package Servlet;

import Dao.AccountDAO;
import Model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDAO adao = new AccountDAO();
        //得到数据
        Account account =  adao.getAccountByNameAndPwd(userName,password);
        if (account!=null){
            //数据库匹配到账号密码
            //将登陆用户对象保存到session
            request.getSession().setAttribute("Account",account);
            try{
                // 判断它有没有设置个人信息
                Integer userId = adao.isExistInformation(account.getUserId());
                System.out.println("LoginServlet;判断有没有设置个人信息；userId:"+userId);
                if (userId == null){
                    //没写简历
                    response.sendRedirect("addInformation.html");//添加个人信息
                }else {
                    //已经写个人信息
                    request.getSession().setAttribute("UserId",userId);
                    request.getRequestDispatcher("AddInformationServlet?method=read").forward(request,response);
//                    response.sendRedirect("");//重定向到读数据
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //用户名密码错误
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('用户名或者密码错误！');");
            writer.write("window.location.href = 'login.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
