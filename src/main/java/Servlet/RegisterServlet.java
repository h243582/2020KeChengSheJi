package Servlet;

import Dao.AccountDAO;
import Model.Account;
import Model.BasicInfo;
import Model.Problem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/RegisterServlet" )
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8" );
        String userName = request.getParameter("username" );
        String password = request.getParameter("password" );
        Account account = new Account(userName, password, new Date());
        AccountDAO adao = new AccountDAO();
        //得到数据
        int count = adao.selectUserEmailCount(userName);
        if (count > 0) {
            //说明数据库里面已经有了这个账号
            PrintWriter writer = response.getWriter();
            writer.write("<script>" );
            writer.write("alert('用户已存在，请重新输入！');" );
            writer.write("window.location.href = 'login.html'" );
            writer.write("</script>" );
            //            writer.write("panDuan();");
            writer.flush();
            writer.close();
        } else {
            //数据库没有这个数据，可以注册
            boolean flag = adao.saveAccount(account);
            if (flag) {
                //注册成功
                Integer userId = adao.getUserId(account.getUserName());
                System.out.println("RegisterServlet;userId:" + userId);
                request.getSession().setAttribute("UserId", userId);

                request.getSession().setAttribute("BasicInfo", new BasicInfo());
                request.getSession().setAttribute("Problem", new Problem());
                PrintWriter writer = response.getWriter();
                writer.write("<script>" );
                writer.write("alert('注册成功！');" );
                writer.write("window.location.href = 'login.html'" );
                writer.write("</script>" );
                writer.flush();
                writer.close();
//                response.sendRedirect("login.html");
            } else {
                //注册失败
                //注册失败则返回注册页面请求转发
                RequestDispatcher rd = request.getRequestDispatcher("login.html" );
                rd.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
