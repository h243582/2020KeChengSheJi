package Model;

import java.util.Arrays;
import java.util.Objects;

public class Problem {
    private Integer problemId;
    private Integer userId;
    private String text1;
    private String text2;
    private String text3;
    private String text4;
    private String text5;

    private String t2;
    private String t3;
    private String t4;

    private String[] t01;//复选
    private String t01t;

    private String t02;
    private String t03;
    private String[] t04;//复选
    private String t04t;

    private String t05;
    private String[] t06;//复选
    private String t06t;

    private String t07;
    private String t08;
    private String t09;
    private String t10;
    private String t11;
    private String[] t12;
    private String t12t;

    private String t13t;
    private Integer sum;

    public Problem() {
    }


    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + problemId +
                ", userId=" + userId +
                ", text1='" + text1 + '\'' +
                ", text2='" + text2 + '\'' +
                ", text3='" + text3 + '\'' +
                ", text4='" + text4 + '\'' +
                ", text5='" + text5 + '\'' +
                ", t2='" + t2 + '\'' +
                ", t3='" + t3 + '\'' +
                ", t4='" + t4 + '\'' +
                ", t01=" + Arrays.toString(t01) +
                ", t01t='" + t01t + '\'' +
                ", t02='" + t02 + '\'' +
                ", t03='" + t03 + '\'' +
                ", t04=" + Arrays.toString(t04) +
                ", t04t='" + t04t + '\'' +
                ", t05='" + t05 + '\'' +
                ", t06=" + Arrays.toString(t06) +
                ", t06t='" + t06t + '\'' +
                ", t07='" + t07 + '\'' +
                ", t08='" + t08 + '\'' +
                ", t09='" + t09 + '\'' +
                ", t10='" + t10 + '\'' +
                ", t11='" + t11 + '\'' +
                ", t12=" + Arrays.toString(t12) +
                ", t12t='" + t12t + '\'' +
                ", t13t='" + t13t + '\'' +
                ", sum=" + sum +
                '}';
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String[] getT01() {
        return t01;
    }

    public void setT01(String[] t01) {
        this.t01 = t01;
    }

    public String getT01t() {
        return t01t;
    }

    public void setT01t(String t01t) {
        this.t01t = t01t;
    }

    public String getT02() {
        return t02;
    }

    public void setT02(String t02) {
        this.t02 = t02;
    }

    public String getT03() {
        return t03;
    }

    public void setT03(String t03) {
        this.t03 = t03;
    }

    public String[] getT04() {
        return t04;
    }

    public void setT04(String[] t04) {
        this.t04 = t04;
    }

    public String getT04t() {
        return t04t;
    }

    public void setT04t(String t04t) {
        this.t04t = t04t;
    }

    public String getT05() {
        return t05;
    }

    public void setT05(String t05) {
        this.t05 = t05;
    }

    public String[] getT06() {
        return t06;
    }

    public void setT06(String[] t06) {
        this.t06 = t06;
    }

    public String getT06t() {
        return t06t;
    }

    public void setT06t(String t06t) {
        this.t06t = t06t;
    }

    public String getT07() {
        return t07;
    }

    public void setT07(String t07) {
        this.t07 = t07;
    }

    public String getT08() {
        return t08;
    }

    public void setT08(String t08) {
        this.t08 = t08;
    }

    public String getT09() {
        return t09;
    }

    public void setT09(String t09) {
        this.t09 = t09;
    }

    public String getT10() {
        return t10;
    }

    public void setT10(String t10) {
        this.t10 = t10;
    }

    public String getT11() {
        return t11;
    }

    public void setT11(String t11) {
        this.t11 = t11;
    }

    public String[] getT12() {
        return t12;
    }

    public void setT12(String[] t12) {
        this.t12 = t12;
    }

    public String getT12t() {
        return t12t;
    }

    public void setT12t(String t12t) {
        this.t12t = t12t;
    }

    public String getT13t() {
        return t13t;
    }

    public void setT13t(String t13t) {
        this.t13t = t13t;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(problemId, problem.problemId) && Objects.equals(userId, problem.userId) && Objects.equals(text1, problem.text1) && Objects.equals(text2, problem.text2) && Objects.equals(text3, problem.text3) && Objects.equals(text4, problem.text4) && Objects.equals(text5, problem.text5) && Objects.equals(t2, problem.t2) && Objects.equals(t3, problem.t3) && Objects.equals(t4, problem.t4) && Arrays.equals(t01, problem.t01) && Objects.equals(t01t, problem.t01t) && Objects.equals(t02, problem.t02) && Objects.equals(t03, problem.t03) && Arrays.equals(t04, problem.t04) && Objects.equals(t04t, problem.t04t) && Objects.equals(t05, problem.t05) && Arrays.equals(t06, problem.t06) && Objects.equals(t06t, problem.t06t) && Objects.equals(t07, problem.t07) && Objects.equals(t08, problem.t08) && Objects.equals(t09, problem.t09) && Objects.equals(t10, problem.t10) && Objects.equals(t11, problem.t11) && Arrays.equals(t12, problem.t12) && Objects.equals(t12t, problem.t12t) && Objects.equals(t13t, problem.t13t) && Objects.equals(sum, problem.sum);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(problemId, userId, text1, text2, text3, text4, text5, t2, t3, t4, t01t, t02, t03, t04t, t05, t06t, t07, t08, t09, t10, t11, t12t, t13t, sum);
        result = 31 * result + Arrays.hashCode(t01);
        result = 31 * result + Arrays.hashCode(t04);
        result = 31 * result + Arrays.hashCode(t06);
        result = 31 * result + Arrays.hashCode(t12);
        return result;
    }
}
