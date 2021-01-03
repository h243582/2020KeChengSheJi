package Dao;

import Model.Account;
import Model.BasicInfo;
import Model.Problem;
import Utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class GetAnythingDAO {
    //获取所有用户
    public List<Account> getAnyUser() {
        //加上别名
        String sql = "select userId,userName,userPassWord from account";
        return DBUtils.getList(Account.class, sql);
    }
    //获取所有用户信息
    public List<BasicInfo> getAnyInformation() {
        //加上别名
        String sql = "select * from basicInfo";
        return DBUtils.getList(BasicInfo.class, sql);
    }
    //获取所有问卷
    public List<Problem> getAnyProblem() {
        //加上别名
        String sql = "select * from problem";
        return DBUtils.getList(Problem.class, sql);
    }
}
