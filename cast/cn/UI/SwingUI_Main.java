package cn.UI;
import javax.swing.JFrame;
import cn.Util.Constant;
/**
 * 加载主容器用于使用其他容器
 * @author 何昱飞
 *
 */
public class SwingUI_Main   {
	/**
	 * 加载主容器用于使用其他容器构造方法
	 * @throws Exception 抛异常
	 */
	public SwingUI_Main() throws Exception {
		Constant.BOSS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constant.BOSS.setSize(Constant.Width, Constant.Heigth);
		Constant.BOSS.setTitle("课程设计");
		Constant.BOSS.getContentPane().setLayout(null);
		fullScreen();// 全屏
		
		new SwingUI_Main_Interface();// 预加载主界面
		new SwingUI_LoginOn(); // 预加载登录界面
		new SwingUI_RegisterLogin();// 注册界面
		//new SwingUI_EatGoGoGo();// 吃饭点餐界面
		new SwingUI_Administrator(); //管理员界面
		//先只显示进入系统界面
		Constant.BOSS.setVisible(true);
		Constant.pMain.setVisible(true);
		Constant.pLogin.setVisible(false);
		Constant.pRegister.setVisible(false);
		Constant.pAdmin.setVisible(false);
		//Constant.pEat.setVisible(false);
	}
	/**
	 * 设置全屏
	 */
	public void fullScreen() {
		Constant.BOSS.setUndecorated(true);// 去处边框
		Constant.BOSS.setExtendedState(JFrame.MAXIMIZED_BOTH); // 最大化
		// this.setAlwaysOnTop(true); // 总在最前面
		Constant.BOSS.setResizable(false); // 不能改变大小
	}
}