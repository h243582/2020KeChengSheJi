package cn.Util;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 静态变量工具类
 * 
 * @author 何昱飞
 *
 */
public class Constant {
	public static final String File = "cast\\configuration\\User.txt"; // 用户txt文件保存地址
	public static final String OrderId = "cast\\configuration\\OrderId.txt"; //自动生成订单号txt文件地址
	public static final String Order = "cast\\configuration\\Order.txt"; //订单文件保存地址

	public static final int Width = 1540; // 规定界面长
	public static final int Heigth = 870; // 规定界面宽
	public static final String gifBoy = "cast\\Image\\GifBoy.gif"; 
	public static final String gifExit = "cast\\Image\\GifExit.gif";//退出时
	public static final String gifBuy = "cast\\Image\\GifBuy.png"; //购买时
	public static final String gifGood = "cast\\Image\\GifGood.jpg"; //注册成功
	public static final String gifSed = "cast\\Image\\GifSed.gif"; //伤心时
	public static final String gifReturn = "cast\\Image\\GifReturn.gif"; //返回时


	public static JFrame BOSS = new JFrame(); // 系统主容器
	public static JPanel pMain; // 主窗口
	public static JPanel pLogin;// 系统登录界面
	public static JPanel pRegister;// 系统注册界面
	public static JPanel pEat;// 系统吃饭界面
	public static JPanel pAdmin;// 管理员界面

	public static String Administrator = "123";// 系统系统管理员


	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String DBURL = "jdbc:sqlserver://;DataBaseName=2020课程设计";// 指定数据库
	public static final String DBUSER = "sa"; // 数据用户名
	public static final String PASSWORD = "123";// 密码
}
