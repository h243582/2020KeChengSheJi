package Servlet;

import Dao.AccountDAO;
import Dao.BasicInfoDAO;
import Dao.ProblemDAO;
import Model.Account;
import Model.BasicInfo;
import Model.Problem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/FirstAddProblemServlet" )
public class FirstAddProblemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8" );
        String method = request.getParameter("method" );
        if (method.equals("new" )) {
            //游客
            response.sendRedirect("addProblem.html" );

        } else if (method.equals("add" )) {
            Problem problem = getProblem(request);
            System.out.println("FirstAddProblemServlet:" + problem);
            ProblemDAO pdao = new ProblemDAO();
            request.getSession().setAttribute("Problem", problem);
            Integer count = pdao.saveProblem(problem);
            System.out.println("FirstAddProblemServlet:有没有保存成功count：" + count);
            if (count > 0) {
                request.getRequestDispatcher("readStartProblem.jsp" ).forward(request, response);
            } else {
                response.sendRedirect("readStartProblem.jsp" );
            }
        } else if (method.equals("read" )) {
            ProblemDAO problemdao = new ProblemDAO();
            Problem problem = problemdao.getProblemById(request.getSession().getAttribute("UserId" ));
            System.out.println("FirstAddProblemServlet:看看有没从数据库取到值problem：" + problem);
            request.getSession().setAttribute("Problem",problem);
            request.getRequestDispatcher("readStartProblem.jsp").forward(request,response);
        }else if (method.equals("youke")){
            Account acc = new Account();
            acc.setUserName("游客");
            acc.setUserPassWord("iuw123qir123wqe2yq98y2412y714hiq");
            new AccountDAO().saveAccount(acc);
            Integer userId = new AccountDAO().getUserId("游客");
            request.getSession().setAttribute("UserId",userId);

            BasicInfo info =new BasicInfo("游客","未知",0,"未知","未知");
            info.setAccountId(userId);
            new BasicInfoDAO().saveBasicInfo(info);
            request.getSession().setAttribute("BasicInfo", info);

            Problem problem = getProblem(request);
            System.out.println("FirstAddProblemServlet:" + problem);
            request.getSession().setAttribute("Problem", problem);
            new ProblemDAO().saveProblem(problem);
            request.getSession().setAttribute("BasicInfo", new BasicInfo());

            request.getRequestDispatcher("readStartProblem.jsp" ).forward(request, response);
        }else if(method.equals("update")){
            Problem problem = getProblem(request);
            System.out.println("FirstAddProblemServlet:update:" + problem);
            ProblemDAO pdao = new ProblemDAO();
            request.getSession().setAttribute("Problem", problem);
            Integer count = pdao.saveProblem(problem);
            request.getRequestDispatcher("readStartProblem.jsp" ).forward(request, response);
        }
    }

    public Problem getProblem(HttpServletRequest request) {
        Problem problem = new Problem();
        problem.setText1(request.getParameter("text1" ));
        problem.setText2(request.getParameter("text2" ));
        problem.setText3(request.getParameter("text3" ));
        problem.setText4(request.getParameter("text4" ));
        problem.setText5(request.getParameter("text5" ));

        problem.setT2(request.getParameter("102" ));
        problem.setT3(request.getParameter("103" ));
        problem.setT4(request.getParameter("104" ));

        problem.setT01(request.getParameterValues("T2_1" ));//复选
        problem.setT01t(request.getParameter("T2_1_t" ));
        problem.setT02(request.getParameter("T2_2" ));
        problem.setT03(request.getParameter("T2_3" ));
        problem.setT04(request.getParameterValues("T2_4" ));//复选
        problem.setT04t(request.getParameter("T2_4_t" ));
        problem.setT05(request.getParameter("T2_5" ));
        problem.setT06(request.getParameterValues("T2_6" ));//复选
        problem.setT06t(request.getParameter("T2_6_t" ));
        problem.setT07(request.getParameter("T2_7" ));
        problem.setT08(request.getParameter("T2_8" ));
        problem.setT09(request.getParameter("T2_9" ));
        problem.setT10(request.getParameter("T2_10" ));
        problem.setT11(request.getParameter("T2_11" ));
        problem.setT12(request.getParameterValues("T2_12" ));
        problem.setT13t(request.getParameter("T2_13_t" ));
        problem.setUserId((Integer) request.getSession().getAttribute("UserId" ));
        return problem;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
