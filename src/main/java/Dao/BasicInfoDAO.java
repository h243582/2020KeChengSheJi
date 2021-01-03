package Dao;

import Model.BasicInfo;
import Utils.DBUtils;

/**
 * 基本信息caoUzo
 */
public class BasicInfoDAO {

    public Integer saveBasicInfo(BasicInfo info) {
        String sql = "insert into basicInfo(userId,basicInfoName,basicInfoGender,basicInfoAge,basicInfoTelephone,basicInfoQQ)\n" +
                "values(?,?,?,?,?,?);";
        return DBUtils.updateForPrimary(sql, info.getAccountId(), info.getBasicInfoName(), info.getBasicInfoGender(), info.getBasicInfoAge(),info.getBasicInfoTelephone(),info.getBasicInfoQQ());
    }

    public void updateHeadShot(int accountId, String headShot) {
        String sql = "update basicInfo set head_shot = ? where basicInfoId = ? ";
        DBUtils.update(sql, headShot, accountId);
    }

    public BasicInfo getBasicInfoById(Integer userId) {
        String sql = "select * from basicInfo where userId = ?";
        return  DBUtils.getSingleObject(BasicInfo.class,sql,userId);
    }

    public boolean updateBasicInfo(BasicInfo info ) {
        String sql = "update basicInfo set  \n" +
                "basicInfoName = ?,\n" +
                "basicInfoGender = ?, \n" +
                "basicInfoAge = ?, \n" +
                "basicInfoTelephone = ?, \n" +
                "basicInfoQQ = ? \n"+
                "where userId = ? ";
        return DBUtils.update(sql, info.getBasicInfoName(), info.getBasicInfoGender(), info.getBasicInfoAge(),info.getBasicInfoTelephone(),info.getBasicInfoQQ(),info.getAccountId());
    }
}
