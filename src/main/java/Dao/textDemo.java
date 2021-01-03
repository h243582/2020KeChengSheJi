package Dao;

import Model.Account;
import Model.BasicInfo;
import Model.Problem;
import Utils.DBUtils;
import Utils.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class textDemo {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        GetAnythingDAO gdao = new GetAnythingDAO();
        List<Account> anyUser = gdao.getAnyUser();
        System.out.println(anyUser);
        List<BasicInfo> anyInformation = gdao.getAnyInformation();
        System.out.println(anyInformation);
        List<Problem> anyProblem = gdao.getAnyProblem();
        System.out.println(anyProblem);
        System.out.println(anyProblem.size());
    }
}
