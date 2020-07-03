package cn.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.ServiceDaoImpl.FoodServiceDaoImpl;
import cn.ServiceDaoImpl.OrderServiceDaoImpl;
import cn.Util.Constant;
import cn.Util.MyBackgound;
import cn.VO.Food;
import cn.VO.Order;
import cn.VO.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 吃饭点餐界面
 * 
 * @author 何昱飞
 *
 */
public class SwingUI_EatGoGoGo {
	private User user;

	public SwingUI_EatGoGoGo(User user) {
		this.user = user;
		// 设置背景
		Constant.pEat = new MyBackgound("cast\\Image\\pEatGoGoGo.jpg");
		Constant.pEat.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pEat.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pEat);
		// 菜品表标签
		JLabel loginBigLabel1 = new JLabel("请选择您要点的菜品哟 ~ ");
		loginBigLabel1.setForeground(Color.MAGENTA);
		loginBigLabel1.setFont(new Font("幼圆", Font.BOLD, 50));
		loginBigLabel1.setBounds(49, 30, 660, 100);
		Constant.pEat.add(loginBigLabel1);
		// 加入表格边
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 136, 545, 635);
		Constant.pEat.add(scrollPane);
		// 表格容器
		JTable table = new JTable();
		table.setRowHeight(22);// 设置行高
		table.setFont(new Font("幼圆", Font.BOLD, 18));// 设置字体
		table.setSelectionBackground(Color.GREEN);// 设置选择背景色
		table.setSelectionForeground(Color.blue);// 设置选择字颜色
		// 表格标签
		DefaultTableModel littleTable = new DefaultTableModel(new Object[][] {}, new String[] { "编号", "名称", "价格" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// 返回true表示能编辑，false表示不能编辑
			}
		};
		table.setModel(littleTable);
		scrollPane.setViewportView(table);
		// 设置单元格居中对齐
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
		// 添加所有记录，先导数据
		TreeSet<Food> al = new FoodServiceDaoImpl().showFood(1);
		// 全部添加到表格组件中
		for (Food objFood : al) {
			littleTable.addRow(new Object[] { objFood.getId(), objFood.getName(), objFood.getPrice() });
		}
		// 加入购物车按钮
		JButton eatButton = new JButton("加入购物车");
		eatButton.setFont(new Font("幼圆", Font.PLAIN, 16));
		eatButton.setBounds(164, 781, 545, 23);
		Constant.pEat.add(eatButton);
		// 文本域放它们这些组件
		JTextArea Area = new JTextArea();
		Area.setEditable(false);
		Area.setBounds(155, 125, 564, 688);
		Constant.pEat.add(Area);

		// 您已点的菜单：标签
		JLabel loginBigLabel2 = new JLabel("您已点的菜单：");
		loginBigLabel2.setForeground(Color.MAGENTA);
		loginBigLabel2.setFont(new Font("幼圆", Font.BOLD, 50));
		loginBigLabel2.setBounds(770, 159, 546, 100);
		Constant.pEat.add(loginBigLabel2);
		// 加入表格边
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(790, 280, 406, 491);
		Constant.pEat.add(scrollPane2);
		// 表格容器
		JTable table2 = new JTable();
		table2.setRowHeight(22);// 设置行高
		table2.setFont(new Font("幼圆", Font.BOLD, 18));// 设置字体
		table2.setSelectionBackground(Color.GREEN);// 设置选择背景色
		table2.setSelectionForeground(Color.blue);// 设置选择字颜色
		// 表格shux
		DefaultTableModel littleTable2 = new DefaultTableModel(new Object[][] {}, new String[] { "编号", "名称", "价格" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// 返回true表示能编辑，false表示不能编辑
			}
		};
		table2.setModel(littleTable2);
		scrollPane2.setViewportView(table2);
		// 设置单元格居中对齐
		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		table2.setDefaultRenderer(Object.class, r2);
		// 删除购物车的某些行
		JButton removeButton = new JButton("删除行");
		removeButton.setFont(new Font("幼圆", Font.PLAIN, 16));
		removeButton.setBounds(790, 781, 406, 24);
		Constant.pEat.add(removeButton);
		// 文本域放右侧这些组件
		JTextArea Area_1 = new JTextArea();
		Area_1.setEditable(false);
		Area_1.setBounds(780, 269, 428, 544);
		Constant.pEat.add(Area_1);

		// 欢迎账户标签
		StringBuilder sb = new StringBuilder();
		if (user != null) {
			sb.append("欢迎回来~ ").append(user.getName());
		} else {
			sb.append("你就是个游客哟~");
		}
		JLabel meLabel = new JLabel(sb.toString());
		meLabel.setForeground(Color.BLUE);
		meLabel.setFont(new Font("幼圆", Font.BOLD, 32));
		meLabel.setBounds(1237, 64, 289, 70);
		Constant.pEat.add(meLabel);
		// 确定购买按钮
		JButton SureButton = new JButton("确定订单");
		SureButton.setFont(new Font("幼圆", Font.BOLD, 20));
		// SureButton.setForeground(Color.WHITE);
		// SureButton.setBackground(Color.RED);
		SureButton.setBounds(1253, 331, 177, 45);
		Constant.pEat.add(SureButton);
		// 返回主界面按钮
		JButton returnButton = new JButton("返回主界面");
		// returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("幼圆", Font.BOLD, 20));
		// returnButton.setBackground(Color.BLUE);
		returnButton.setBounds(1253, 496, 177, 45);
		Constant.pEat.add(returnButton);
		// 退出系统
		JButton exitButton = new JButton("退出系统");
		// exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("幼圆", Font.BOLD, 20));
		// exitButton.setBackground(Color.BLUE);
		exitButton.setBounds(1253, 673, 177, 45);
		Constant.pEat.add(exitButton);

		// 加入购物车事件
		eatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = table.getSelectedRows();// 获取选定的一行或多行
				if (rows.length < 0) {
					return;
				}

				for (int i : rows) {
					Food fd = new Food((long) table.getValueAt(i, 0), (String) table.getValueAt(i, 1),
							(double) table.getValueAt(i, 2));
					littleTable2.addRow(new Object[] { fd.getId(), fd.getName(), fd.getPrice() });
				}
			}
		});
		// 删除购物车的某些行
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] rows = table2.getSelectedRows();// 获取选定的一行或多行
				if (rows.length < 0) {
					return;
				}
				// 我在这里加个中间变量，因为每次删除行，下面的行会上移，所以我就每删除一行，我就要多减个 1
				int temp = 0;
				for (int rowi : rows) {
					littleTable2.removeRow(rowi - temp);
					temp++;
				}
			}
		});
		// 给确认订单按钮添加事件
		SureButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long i = table2.getRowCount();
				float sum = 0;
				ArrayList<Food> al = new ArrayList<Food>();
				for (int x = 0; x < i; x++) {
					Food f = new FoodServiceDaoImpl().find((long) table2.getValueAt(x, 0));
					if (user == null) {
						f.setPrice(f.getPrice() * 0.7);
					}
					sum += f.getPrice();
					al.add(f);
				}
				StringBuilder sb = new StringBuilder();
				// 如果是个游客
				if (user == null) {
					sb.append("一共是：");
				} else {
					sb.append("您是有身份的人哟！给您打7折~\n\r一共是：");
				}
				sb.append(String.valueOf(sum)).append("元,\n\r").append("是否确认购买?");
				int select = JOptionPane.showConfirmDialog(null, sb.toString(), "确认", 0, 0,
						new ImageIcon(Constant.gifBuy));
				// select 为用户点的第几个按钮
				if (select == 0) {
					JOptionPane.showMessageDialog(null, "购买成功！点击确认退出返回主界面。", null, 0, new ImageIcon(Constant.gifBuy));
					// 写入文件
						// 如果是个游客//是个有身份的人
						try {
							new OrderServiceDaoImpl().append(new Order(user, al));
						} catch (Exception e1) {
					}
					Constant.pEat.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}
		});
		// 返回主界面事件
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "您确定要取消购买并 返回主界面吗?", "确认", 0, 0,
						new ImageIcon(Constant.gifReturn));
				// select 为用户点的第几个按钮
				if (select == 0) {
					Constant.pEat.setVisible(false);
					Constant.pMain.setVisible(true);
				}
			}
		});
		// 退出事件
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "您确定要取消购买并 退出系统吗?", "确认", 0, 0,
						new ImageIcon(Constant.gifExit));
				// select 为用户点的第几个按钮
				if (select == 0) {
					System.exit(0);
				}
			}
		});
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}