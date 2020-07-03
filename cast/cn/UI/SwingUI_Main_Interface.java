package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import cn.Util.Constant;
import cn.Util.MyBackgound;

/**
 * 是进入系统的主界面
 * 
 * @author 何昱飞
 *
 */
public class SwingUI_Main_Interface {
	public SwingUI_Main_Interface() {
		Constant.pMain = new MyBackgound("cast/Image/pMainPlane.jpg");
		Constant.pMain.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pMain.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pMain);

		// 登录系统按钮
		JButton loginButton = new JButton("登录系统");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		loginButton.setFont(new Font("幼圆", Font.BOLD, 22));
		loginButton.setBounds(380, 640, 150, 60);
		Constant.pMain.add(loginButton);
		// 游客登录按钮
		JButton intoButton = new JButton("游客登录");
		intoButton.setBackground(Color.BLACK);
		intoButton.setForeground(Color.WHITE);
		intoButton.setFont(new Font("幼圆", Font.BOLD, 22));
		intoButton.setBounds(700, 640, 150, 60);
		Constant.pMain.add(intoButton);
		// 退出系统按钮
		JButton closeButton = new JButton("退出系统");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.BLACK);
		closeButton.setFont(new Font("幼圆", Font.BOLD, 22));
		closeButton.setBounds(1020, 640, 150, 60);
		Constant.pMain.add(closeButton);
		// 进入管理员界面
		JButton Administrator = new JButton("管理员");
		Administrator.setForeground(Color.WHITE);
		Administrator.setFont(new Font("幼圆", Font.BOLD, 12));
		Administrator.setBackground(Color.BLACK);
		Administrator.setBounds(1468, 840, 70, 25);
		Constant.pMain.add(Administrator);
		// 登录系统事件
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Constant.pMain.setVisible(false);
				Constant.pLogin.setVisible(true);
				// login();
			}
		});
		// 游客登录事件
		intoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "是否确认使用游客登录?", "确认", 0, 0,
						new ImageIcon(Constant.gifBoy));

				// select 为用户点的第几个按钮
				if (select == 0) {
					new SwingUI_EatGoGoGo(null);
					Constant.pMain.setVisible(false);
					// Constant.pEat.setVisible(true);
				}
			}
		});
		// 管理员按钮增加事件
		Administrator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password;
				do {
				password = JOptionPane.showInputDialog(null, "请输入你的管理员密码", "0000");
				if (password != null) {
					try {
						//使用配置文件得到正确的密码
						Properties prop = new Properties();
						InputStream inputStream = new FileInputStream("cast\\configuration\\AdministratorPassword.properties");
						prop.load(inputStream);
						inputStream.close();
						//根据键获取值,判断密码是否正确
						if(password.equals(prop.getProperty("Administrator"))) {
							//进入管理员界面
							JOptionPane.showMessageDialog(null,"密码正确哟~~~~~~~");
							Constant.pMain.setVisible(false);
							Constant.pAdmin.setVisible(true);
							break;
						}else {
							JOptionPane.showMessageDialog(null,"密码错误，请重新输入！","错误", 0);
						}

					} catch (Exception e2) {
					}
				}else {
					break;
				}
				}while(password!=null);
			}
		});

		// 退出系统事件
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "是否确认退出系统?", "确认", 0, 0,
						new ImageIcon(Constant.gifExit));
				// select 为用户点的第几个按钮
				if (select == 0) {
					System.exit(0);
				}
			}
		});
	}

}