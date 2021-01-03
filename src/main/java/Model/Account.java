package Model;

import java.util.Date;

public class Account {
    private Integer userId;
    private String userName;
    private String userPassWord;
    private Date userRegistdate;
    public Account() {
    }
    public Account(String userName, String userPassWord,Date userRegistdate) {
        this.userId = null;
        this.userName = userName;
        this.userPassWord = userPassWord;
        this.userRegistdate = userRegistdate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public Date getUserRegistdate() {
        return userRegistdate;
    }

    public void setUserRegistdate(Date userRegistdate) {
        this.userRegistdate = userRegistdate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", userRegistdate=" + userRegistdate +
                '}';
    }
}
