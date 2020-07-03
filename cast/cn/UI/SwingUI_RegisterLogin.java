package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import cn.ServiceDaoImpl.UserServiceDaoImpl;
import cn.Util.Constant;
import cn.VO.User;

/**
 * 用户注册界面
 * 
 * @author 何昱飞
 *
 */
public class SwingUI_RegisterLogin {
	/**
	 * 用户注册界面构造方法
	 */
	public SwingUI_RegisterLogin() {
		// 设置右侧文本
		Constant.pRegister = new JPanel();
		Constant.pRegister.setBackground(Color.WHITE);
		Constant.pRegister.setBounds(600, 0, Constant.Width, Constant.Heigth);
		Constant.BOSS.getContentPane().add(Constant.pRegister);
		Constant.pRegister.setLayout(null);
		// 加个小动图
		JLabel gif = new JLabel();
		gif.setBounds(609, 121, 100, 100);
		gif.setIcon(new ImageIcon("cast\\Image\\11.gif"));
		Constant.pRegister.add(gif);
		// 账号密码登录标签1
		JLabel loginBigLabel1 = new JLabel("欢迎注册账户");
		loginBigLabel1.setFont(new Font("黑体", Font.BOLD, 50));
		loginBigLabel1.setBackground(Color.WHITE);
		loginBigLabel1.setBounds(231, 68, 357, 100);
		Constant.pRegister.add(loginBigLabel1);
		// 账号密码登录标签
		JLabel loginBigLabel2 = new JLabel("每一天，乐在吃饭");
		loginBigLabel2.setFont(new Font("黑体", Font.BOLD, 26));
		loginBigLabel2.setBackground(Color.WHITE);
		loginBigLabel2.setBounds(230, 171, 250, 66);
		Constant.pRegister.add(loginBigLabel2);
		// 昵称标签
		JLabel nameLabel = new JLabel("昵称");
		nameLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		nameLabel.setBackground(Color.WHITE);
		nameLabel.setBounds(252, 278, 60, 50);
		Constant.pRegister.add(nameLabel);
		// 昵称文本框
		JTextField nameTextField = new JTextField();
		nameTextField.setFont(new Font("楷体", Font.PLAIN, 20));
		nameTextField.setColumns(10);
		nameTextField.setBounds(311, 283, 368, 40);
		Constant.pRegister.add(nameTextField);
		// 账号标签
		JLabel accountLabel = new JLabel("账号");
		accountLabel.setBackground(Color.WHITE);
		accountLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		accountLabel.setBounds(252, 333, 60, 50);
		Constant.pRegister.add(accountLabel);
		// 账号文本框
		JTextField accountTextField = new JTextField();
		accountTextField.setFont(new Font("楷体", Font.PLAIN, 20));
		accountTextField.setBounds(311, 338, 368, 40);
		Constant.pRegister.add(accountTextField);
		accountTextField.setColumns(10);
		// 密码标签
		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		passwordLabel.setBounds(252, 393, 60, 50);
		Constant.pRegister.add(passwordLabel);
		// 密码文本框
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordTextField.setBounds(311, 398, 368, 40);
		Constant.pRegister.add(passwordTextField);
		// 注册按钮
		JButton loginOnButton = new JButton("立即注册");
		loginOnButton.setFont(new Font("幼圆", Font.BOLD, 20));
		loginOnButton.setForeground(Color.WHITE);
		loginOnButton.setBackground(Color.BLUE);
		loginOnButton.setBounds(251, 532, 428, 50);
		Constant.pRegister.add(loginOnButton);
		// 中间加个分割线
		JSeparator separator = new JSeparator();
		separator.setOrientation(JSeparator.VERTICAL);
		separator.setBounds(616, 685, 1, 22);
		Constant.pRegister.add(separator);
		// 返回主界面链接标签
		JLabel returnLabel = new JLabel("返回主界面");
		returnLabel.setFont(new Font("幼圆", Font.BOLD, 15));
		returnLabel.setBackground(Color.WHITE);
		returnLabel.setBounds(645, 675, 88, 32);
		Constant.pRegister.add(returnLabel);

		// 手机号标签
		JLabel phoneLabel = new JLabel("手机号");
		phoneLabel.setFont(new Font("幼圆", Font.BOLD, 20));
		phoneLabel.setBackground(Color.WHITE);
		phoneLabel.setBounds(361, 451, 70, 50);
		Constant.pRegister.add(phoneLabel);
		// 手机号文本框
		JTextField phoneTextField = new JTextField();
		phoneTextField.setFont(new Font("楷体", Font.PLAIN, 20));
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(429, 456, 250, 40);
		Constant.pRegister.add(phoneTextField);
		// 手机号地区下拉选项卡
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("幼圆", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "+86", "+852", "+853", "+886" }));
		comboBox.setBounds(251, 456, 100, 40);
		Constant.pRegister.add(comboBox);
		// 复选框要选政策
		JCheckBox CheckBox = new JCheckBox("我已阅读并同意相关服务条款和隐私政策");
		CheckBox.setBackground(Color.WHITE);
		CheckBox.setBounds(252, 605, 264, 23);
		Constant.pRegister.add(CheckBox);

		JLabel functionLabel = new JLabel("Copyright  1998-2020Tencent All Rights Reserved");
		functionLabel.setBounds(293, 805, 386, 22);
		Constant.pRegister.add(functionLabel);

		// 给注册按钮增加事件
		loginOnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 判断要输入昵称
				String name = nameTextField.getText().trim();
				if (!name.matches(".{1,20}")) {
					JOptionPane.showMessageDialog(null, "请输入昵称(最大长度20)");
					return;
				}
				// 判断要输入账号并且 账号是否规范
				String account = accountTextField.getText().trim();
				if (account.matches("")) {
					JOptionPane.showMessageDialog(null, "请输入账号");
					return;
				} else if (!account.matches("[a-zA-Z]{1}[\\w]{5,9}")) {
					JOptionPane.showMessageDialog(null, "账号开头必须是字母且长度6-10");
					return;
				}
				// 判断账号是否已存在
				try {
					if (new UserServiceDaoImpl().repetition(account)) {
						JOptionPane.showMessageDialog(null, "账号已存在");
						accountTextField.requestFocus();
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// 判断要输入密码
				String password = new String(passwordTextField.getPassword());
				if (password.matches("")) {
					JOptionPane.showMessageDialog(null, "请输入密码");
					return;
				}
				// 判断手机号
				String phoneNumber = phoneTextField.getText().trim();
				if (!phoneNumber.matches("\\d{11}")) {
					JOptionPane.showMessageDialog(null, "请输入正确的手机号");
					return;
				}
				// 如果复选框没勾就出现提示框
				if (!CheckBox.isSelected()) {
					JOptionPane.showMessageDialog(null, "请勾选我已阅读协议");
					return;
				}
				// 若以上全部满足,则开始写入到文件
				User u = new User(name, account, password, (String) comboBox.getSelectedItem(), phoneNumber);
				try {
					new UserServiceDaoImpl().append(u);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "恭喜您，注册成功！ ", "恭喜恭喜", 0, new ImageIcon(Constant.gifGood));
				Constant.pRegister.setVisible(false);
				Constant.pLogin.setVisible(true);
			}
		});
		// 返回主界面事件
		returnLabel.addMouseListener(new MouseAdapter() {
			// 鼠标点击标签事件
			public void mouseClicked(MouseEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "您确定要取消注册并 返回主界面吗?", "确认", 0, 0,
						new ImageIcon(Constant.gifReturn));
				// select 为用户点的第几个按钮
				if (select == 0) {
					Constant.pRegister.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}

			// 鼠标移至标签事件
			@Override
			public void mouseEntered(MouseEvent e) {
				returnLabel.setText("<html><u>返回主界面</u><html>");
			}

			// 鼠标离开事件
			public void mouseExited(MouseEvent e) {
				returnLabel.setText("返回主界面");
			}
		});

	}

}
