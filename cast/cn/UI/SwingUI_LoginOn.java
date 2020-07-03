package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.ServiceDaoImpl.UserServiceDaoImpl;
import cn.Util.Constant;
import cn.Util.MyBackgound;
import cn.VO.User;
/**
 * 登录界面
 * @author 何昱飞
 *
 */
public class SwingUI_LoginOn {
	private User user;
	/**
	 * 登录界面构造方法
	 * @throws Exception 抛异常
	 */
	public SwingUI_LoginOn() throws Exception {
		// 设置背景
		Constant.pLogin = new MyBackgound("cast\\Image\\pLogin.jpg");
		Constant.pLogin.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pLogin.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pLogin);
		// 账号密码登录标签
		JLabel loginBigLabel = new JLabel("账号密码登录");
		loginBigLabel.setFont(new Font("黑体", Font.BOLD, 26));
		loginBigLabel.setBackground(Color.WHITE);
		loginBigLabel.setBounds(1149, 216, 193, 32);
		Constant.pLogin.add(loginBigLabel);
		// 账号标签
		JLabel accountLabel = new JLabel("账号");
		accountLabel.setBackground(Color.WHITE);
		accountLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		accountLabel.setBounds(1076, 298, 60, 50);
		Constant.pLogin.add(accountLabel);
		// 账号文本框
		JTextField accountTextField = new JTextField();
		accountTextField.setFont(new Font("楷体", Font.PLAIN, 20));
		accountTextField.setBounds(1136, 303, 260, 40);
		Constant.pLogin.add(accountTextField);
		accountTextField.setColumns(10);
		// 密码标签
		JLabel pswLabel = new JLabel("密码");
		pswLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		pswLabel.setBounds(1076, 365, 60, 50);
		Constant.pLogin.add(pswLabel);
		// 密码文本框
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordTextField.setBounds(1136, 370, 260, 40);
		Constant.pLogin.add(passwordTextField);
		// 登录按钮
		JButton loginOnButton = new JButton("登录");
		loginOnButton.setFont(new Font("幼圆", Font.BOLD, 20));
		loginOnButton.setForeground(Color.WHITE);
		loginOnButton.setBackground(Color.GREEN);
		loginOnButton.setBounds(1076, 435, 320, 40);
		Constant.pLogin.add(loginOnButton);
		// 注册新账号链接标签
		JLabel registerLabel = new JLabel("注册新账号");
		registerLabel.setFont(new Font("幼圆", Font.BOLD, 15));
		registerLabel.setBackground(Color.WHITE);
		registerLabel.setBounds(1241, 512, 88, 32);
		Constant.pLogin.add(registerLabel);
		// 中间加个分割线
		JSeparator separator = new JSeparator();
		separator.setOrientation(JSeparator.VERTICAL);
		separator.setBounds(1361, 518, 1, 22);
		Constant.pLogin.add(separator);
		// 返回主界面链接标签
		JLabel returnLabel = new JLabel("返回主界面");
		returnLabel.setFont(new Font("幼圆", Font.BOLD, 15));
		returnLabel.setBackground(Color.WHITE);
		returnLabel.setBounds(1393, 512, 88, 32);
		Constant.pLogin.add(returnLabel);

		// 文本域放它们这些组件
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(1013, 197, 468, 347);
		Constant.pLogin.add(textArea);
		
		//登录按钮增加事件
		loginOnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 判断要输入账号并且 账号是否规范
				String account = accountTextField.getText().trim();
				if (account.matches("")) {
					JOptionPane.showMessageDialog(null, "请输入账号");
					return;
				}
				// 判断要输入密码
				String password = new String(passwordTextField.getPassword());
				if (password.matches("")) {
					JOptionPane.showMessageDialog(null, "请输入密码");
					return;
				}
				//判断账号密码是否正确
				try {
					if(new UserServiceDaoImpl().loginOn(account,password)) {
						JOptionPane.showMessageDialog(null, "登录成功！",null, 0, new ImageIcon(Constant.gifGood));
						user = new UserServiceDaoImpl().findUser(account);
						//打开界面
						new SwingUI_EatGoGoGo(user);// 吃饭点餐界面
						Constant.pLogin.setVisible(false);
						Constant.pEat.setVisible(true);
						return;
					}else {
						JOptionPane.showMessageDialog(null, "账号或密码错误，请重新输入！","账号密码错误",0,new ImageIcon(Constant.gifSed));
						return;
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	
		//返回主界面事件
		returnLabel.addMouseListener(new MouseAdapter() {
			//鼠标点击标签事件
			public void mouseClicked(MouseEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "您确定要取消登录并 返回主界面吗?", "确认", 0, 0, new ImageIcon(Constant.gifReturn));
				// select 为用户点的第几个按钮
				if (select == 0) {
					Constant.pLogin.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}
			//鼠标移至标签事件
			@Override
			public void mouseEntered(MouseEvent e) {
				returnLabel.setText("<html><u>返回主界面</u><html>");
			}
			//鼠标离开标签事件
			public void mouseExited(MouseEvent e) {
				returnLabel.setText("返回主界面");
			}
		});
		//注册新账号标签事件
		registerLabel.addMouseListener(new MouseAdapter() {
			//点击标签事件
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "今天注册有惊喜哟~~~",null, 0, new ImageIcon(Constant.gifBoy));
				Constant.pLogin.setVisible(false);
				Constant.pRegister.setVisible(true);
				// 设置左侧背景
				new Thread() {
					@Override
					public void run() {
						// 第1张图预先缓存
						JPanel pRegisterJPG0 = new MyBackgound("cast\\Image\\pRegister0.jpg", 0, 0, 600, 865);
						pRegisterJPG0.setBounds(0, 0, 600, 865);
						Constant.BOSS.getContentPane().add(pRegisterJPG0);
						// 第2张图预先缓存
						JPanel pRegisterJPG1 = new MyBackgound("cast\\Image\\pRegister1.jpg", 0, 0, 600, 865);
						pRegisterJPG1.setBounds(0, 0, 600, 865);
						Constant.BOSS.getContentPane().add(pRegisterJPG1);
						// 第3张图预先缓存
						JPanel pRegisterJPG2 = new MyBackgound("cast\\Image\\pRegister2.jpg", 0, 0, 600, 865);
						pRegisterJPG2.setBounds(0, 0, 600, 865);
						Constant.BOSS.getContentPane().add(pRegisterJPG2);

						// 开始自动切换
						for (int i = 0; Constant.pRegister.isVisible(); i++) {
							switch ((i % 3)) {
							case 0: {
								pRegisterJPG0.setVisible(true);
								pRegisterJPG1.setVisible(false);
								pRegisterJPG2.setVisible(false);
								break;
							}
							case 1: {
								pRegisterJPG0.setVisible(false);
								pRegisterJPG1.setVisible(true);
								pRegisterJPG2.setVisible(false);
								break;
							}
							case 2: {
								pRegisterJPG0.setVisible(false);
								pRegisterJPG1.setVisible(false);
								pRegisterJPG2.setVisible(true);
								break;
							}
							}
							try {
								// 此处为了减少进入其他界面产生的线程延迟
								for (int j = 0; j <= 2000; j += 100) {
									sleep(100);
									if (!Constant.pRegister.isVisible()) {
										pRegisterJPG0.setVisible(false);
										pRegisterJPG1.setVisible(false);
										pRegisterJPG2.setVisible(false);
										break;
									}
								}
							} catch (InterruptedException e) {
							}
						}
					}
				}.start();
			}
			//鼠标移至标签事件
			@Override
			public void mouseEntered(MouseEvent e) {
				registerLabel.setText("<html><u>注册新账号</u><html>");
			}
			//鼠标离开标签事件
			public void mouseExited(MouseEvent e) {
				registerLabel.setText("注册新账号");
			}
		});
	}

}