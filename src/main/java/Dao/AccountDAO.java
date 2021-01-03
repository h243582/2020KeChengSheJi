package Dao;

import Model.Account;
import Utils.DBUtils;

public class AccountDAO {
    /**
     *       保存注册对象
     * @param acc 账户
     * @return 成功
     */
    public boolean saveAccount(Account acc) {
        String sql = "insert into account(userName,userPassWord,userRegistdate)" +
                "values(?,?,?)";
        return DBUtils.save(sql, acc.getUserName(), acc.getUserPassWord(), acc.getUserRegistdate());
    }

    //根据账户和密码查询用户
    public Account getAccountByNameAndPwd(String userName, String passUserWord) {
        //加上别名
        String sql = "select userId,userName,userPassWord,userRegistdate " +
                " from account where userName=? and userPassWord=?";
        return DBUtils.getSingleObject(Account.class, sql, userName, passUserWord);
    }

    /**
     * 看账号在数据库里面有没有存在
     * @param userName 账号
     * @return 个数
     */
    public Integer selectUserEmailCount(String userName) {
        String sql = "select count(*) from account \n" +
                "where userName=?";
        return DBUtils.getCount(sql, userName);
    }

    //判断用户是否有个人信息
    public Integer isExistInformation(Integer userId){
        String sql = "select userId from basicInfo where userId=?";
        return DBUtils.getCount(sql, userId);
    }

    //判断用户是否有个人信息
    public Integer getUserId(String userName) {
        String sql = "select userId from account where userName=?";
        return DBUtils.getCount(sql, userName);
    }
}
