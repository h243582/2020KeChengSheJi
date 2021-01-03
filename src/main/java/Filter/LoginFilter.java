package Filter;

import Model.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "*.jsp")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;

        request.setCharacterEncoding("UTF-8");

        //把用户从session中取出
        HttpSession session=request.getSession();
        Account acc = (Account) session.getAttribute("Account");

        //首页，登录界面，处理登录的servlet放行
        String path=request.getServletPath();
//        System.out.println("path: "+path);

        if(acc!=null||path.contains("login.html")||path.contains("LoginServlet")||path.contains("index.html")||
                path.contains("readUserInformation.jsp")||path.contains("Problem.jsp")){
            chain.doFilter(req, resp);
        }else {
            //还没登录，进入登录界面
            response.sendRedirect("login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
