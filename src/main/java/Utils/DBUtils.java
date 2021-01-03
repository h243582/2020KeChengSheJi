package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.*;
import java.util.*;

public class DBUtils {
    /**
     * 返回connection对象
     */
    public static Connection getConnection() throws IOException {
        Connection conn = null;
        try {
            //读取配置文件
            /* 配置文件 */
            Properties pro = new Properties();
            // InputStream inputStream = new FileInputStream("JDBC.properties");
            InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream("JDBC.properties");
            pro.load(inputStream);
            inputStream.close();
            DataSource ds = null;
            try {
                ds = DruidDataSourceFactory.createDataSource(pro);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Class.forName(driver);
            conn = ds.getConnection();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //保存对象到数据库方法
    public static boolean save(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = DBUtils.getConnection();
            pstat = conn.prepareStatement(sql);
            //写入sql参数
            if (args != null && args.length > 0) {
                for (int i = 1; i <= args.length; i++) {
                    //如果是日期类型是不是java.util.Date
                    if(args[i-1] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i-1];
                        //转换成java.sql.Date
                        args[i-1] = new java.sql.Date(date.getTime());
                    }
                    pstat.setObject(i, args[i - 1]);
                }
            }
            //返回更新的纪录数
            count = pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new DatabaseConnection().close();
        }
        return count!=0;
    }

    /**
     * @param <T>   封装对象类型
     * @param clazz 封装对象字节码文件
     * @param sql   查询语句
     * @param args  如果有带输入的sql查询语句，则为里面的参数
     */
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> userList = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);

            //写入sql参数
            if (args != null && args.length > 0) {
                for (int i = 1; i <= args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
            }
            //对sql语句进行查询
            rs = ps.executeQuery();

            //获得查询到的表结构
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int colsnum = rsmd.getColumnCount();
            userList = new ArrayList<T>();

            while (rs.next()) {
                //key存放列名，value存放值，for循环完成后，rowMap存放了一条纪录
                Map<String, Object> rowMap = new TreeMap<>();
                for (int i = 1; i <= colsnum; i++) {
                    String colName = rsmd.getColumnLabel(i);//列的别名
                    Object colValue = rs.getObject(colName);
                    //判断查询出的Date类型
                    if (colValue instanceof Date) {
                        Date date = (Date) colValue;
                        colValue = new java.util.Date(date.getTime());
                    }
                    rowMap.put(colName, colValue);
                }
//                System.out.println(rowMap);
                T bean = clazz.newInstance();

                //循环rowMap给三个属性赋值,entry{key,value}  每个entry保存一列的键值对
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();

                    BeanUtils.setProperty(bean, propertyName, propertyValue);
                }
                userList.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new DatabaseConnection().close();
        }
        return userList;
    }

    //根据数据库获取单个某个对象
    public static <T> T getSingleObject(Class<T> clazz, String sql, Object... args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        T bean = null;//Applicant bean = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            //写入sql参数
            if (args != null && args.length > 0) {
                for (int i = 1; i <= args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
            }
            //对sql语句进行查询
            rs = ps.executeQuery();

            //获得查询到的表结构
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取结果集的列数
            int colsnum = rsmd.getColumnCount();
            //每次循环得到一个结果集，登录时就一个结果集
            while (rs.next()) {
                Map<String, Object> rowMap = new HashMap<String, Object>();

                //成员给rowMap
                for (int i = 1; i <= colsnum; i++) {
                    String colName = rsmd.getColumnLabel(i);//列的别名
                    Object colValue = rs.getObject(colName);
                    //如果是Date类型就转换
                    if (colValue instanceof Date) {
                        Date date = (Date) colValue;
                        colValue = new Date(date.getTime());
                    }
                    rowMap.put(colName, colValue);
                }
//                System.out.println("+++++rowMap:"+rowMap);//-----------------------------------
                //实例化bean对象,
                bean = clazz.newInstance();//bean = new Applicant();
                //循环rowMap给三个属性赋值,entry{key,value}  每个entry保存一列的键值对
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    //给bean对象的propertyName赋值propertyValue
                    BeanUtils.setProperty(bean, propertyName, propertyValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new DatabaseConnection().close();
        }
        return bean;
    }

    //根据某个项查询纪录数量
    public static Integer getCount(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            //写入sql参数
            if (args != null && args.length > 0) {
                for (int i = 1; i <= args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
            }
            //对sql语句进行查询
            rs = ps.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new DatabaseConnection().close();
        return count;
    }

    /**
     * 更新DAO操作
     */
    public static boolean update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = -1;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //写入sql参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    //如果是日期类型是不是java.util.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                         args[i] = new Date(date.getTime());
                    }
                    ps.setObject(i+1, args[i]);
                }
            }
            //对sql语句进行修改
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new DatabaseConnection().close();
        }
        return count>0;
    }

    /**
     *
     * @param sql
     * @param args
     * @return
     */
    public static Integer updateForPrimary(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer count = -1;
        Integer primaryKey = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //写入sql参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    //如果是日期类型是不是java.util.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i] = new Date(date.getTime());
                    }
//                    System.out.println(i+"-----------------------"+args[i]);
                    ps.setObject(i+1, args[i]);
                }
            }
            //对sql语句进行修改
            ps.executeUpdate();

            //得到主键
            rs = ps.getGeneratedKeys();

            if (rs.next()){
                primaryKey = (Integer) rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            new DatabaseConnection().close();
        }
        return primaryKey;
    }

    /**
     * 关闭数据库连接
     */
    public void closeStat(Statement stat) {
        try {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void closeRs(ResultSet rs){
            try {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void closeConn(Connection conn) {
            try {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
