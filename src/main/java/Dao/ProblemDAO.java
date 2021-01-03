package Dao;

import Model.BasicInfo;
import Model.Problem;
import Utils.DBUtils;

import java.util.Arrays;

public class ProblemDAO {
    public Integer saveProblem(Problem p) {
        String sql = "insert into problem\n" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        return DBUtils.updateForPrimary(sql, p.getUserId(), p.getText1(), p.getText2(), p.getText3(), p.getText4(), p.getText5(), p.getT2(), p.getT3(), p.getT4(), Arrays.toString(p.getT01()), p.getT01t(), p.getT02(), p.getT03(), Arrays.toString(p.getT04()), p.getT04t(), p.getT05(), Arrays.toString(p.getT06()), p.getT06t(), p.getT07(), p.getT08(), p.getT09(), p.getT10(), p.getT11(), Arrays.toString(p.getT12()), p.getT12t(), p.getT13t(),p.getSum());
    }
    public Problem getProblemById(Object userId) {
        String sql = "select * from problem where userId = ?";
        return  DBUtils.getSingleObject(Problem.class,sql,userId);
    }


    //判断用户是否有填题目
    public Integer isExistProblem(Integer userId) {
        String sql = "select userId from problem where userId=?";
        return DBUtils.getCount(sql, userId);
    }
}
