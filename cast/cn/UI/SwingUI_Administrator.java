package cn.UI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.ServiceDaoImpl.FoodServiceDaoImpl;
import cn.ServiceDaoImpl.OrderServiceDaoImpl;
import cn.Util.Constant;
import cn.Util.MyBackgound;
import cn.VO.CollectForm;
import cn.VO.Food;
import cn.VO.Order;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 管理员界面
 * 
 * @author 何昱飞
 *
 */
public class SwingUI_Administrator {
	private JButton updateFoodButton;
	private JButton removeFoodButton;
	private JButton addFoodButton;

	private JPanel pTable; // table最大容器
	private JScrollPane scrollPane;// 表格容器
	private JTable table;// 表格框架
	private DefaultTableModel littleTable; // 表格记录小容器

	private JPanel pTableOrder;// 订单表格框架

	public SwingUI_Administrator() {
		// 背景
		Constant.pAdmin = new MyBackgound("cast\\Image\\pLogin.jpg");
		Constant.pAdmin.setBounds(0, 0, Constant.Width, Constant.Heigth);
		Constant.pAdmin.setLayout(null);
		Constant.BOSS.getContentPane().add(Constant.pAdmin);

		// 查看所有订单按钮
		JButton searchOrderButton = new JButton("查看所有订单");
		searchOrderButton.setFont(new Font("幼圆", Font.PLAIN, 28));
		searchOrderButton.setBounds(200, 90, 210, 68);
		Constant.pAdmin.add(searchOrderButton);
		// 查看所有菜谱按钮
		JButton searchFoodButton = new JButton("查看所有菜谱");
		searchFoodButton.setFont(new Font("幼圆", Font.PLAIN, 28));
		searchFoodButton.setBounds(200, 209, 210, 68);
		Constant.pAdmin.add(searchFoodButton);
		// 修改菜谱按钮
		updateFoodButton = new JButton("修改菜谱");
		updateFoodButton.setFont(new Font("幼圆", Font.PLAIN, 28));
		updateFoodButton.setBounds(200, 328, 210, 68);
		Constant.pAdmin.add(updateFoodButton);
		// 删除菜谱事件
		removeFoodButton = new JButton("删除菜谱");
		removeFoodButton.setFont(new Font("幼圆", Font.PLAIN, 28));
		removeFoodButton.setBounds(200, 462, 210, 68);
		Constant.pAdmin.add(removeFoodButton);
		// 增加菜谱按钮
		addFoodButton = new JButton("增加菜谱");
		addFoodButton.setFont(new Font("幼圆", Font.PLAIN, 28));
		addFoodButton.setBounds(200, 591, 210, 68);
		Constant.pAdmin.add(addFoodButton);
		// 返回主菜单按钮
		JButton returnButton = new JButton("返回主菜单");
		returnButton.setFont(new Font("幼圆", Font.PLAIN, 28));
		returnButton.setBounds(200, 722, 210, 68);
		Constant.pAdmin.add(returnButton);
		// 先预加载但不显示
		showAllFood();
		pTable.setVisible(false);
		// 查看所有订单按钮事件
		searchOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pTable.setVisible(false);
				try {
					pTableOrder.setVisible(false);
					Constant.pAdmin.remove(pTableOrder);
				}catch (Exception ee) {
				}
				showOrders();
				pTableOrder.setVisible(true);
			}
		});
		// 查看菜谱表按钮事件
		searchFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pTableOrder.setVisible(false);
				} catch (Exception e2) {
				}
				pTable.setVisible(true);
			}
		});
		// 修改菜谱事件，未显示菜谱时
		updateFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pTable.isVisible())
					JOptionPane.showMessageDialog(null, "请先显示菜品菜单");
			}
		});
		// 删除菜谱事件，未显示菜谱时
		removeFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pTable.isVisible())
					JOptionPane.showMessageDialog(null, "请先显示菜品菜单");
			}
		});
		// 增加菜谱事件，未显示菜谱时,无事件

		// 返回主菜单事件
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Constant.pAdmin.setVisible(false);
				Constant.pMain.setVisible(true);
			}
		});

	}

	/**
	 * 显示右侧菜品表和订单表
	 */
	public void showAllFood() {
		pTable = new MyBackgound("cast\\Image\\pLogin.jpg");

		pTable.setBounds(750, 123, 560, 700);
		Constant.pAdmin.add(pTable);
		pTable.setVisible(false);
		pTable.setLayout(null);
		// 刷新或者读取数据库菜品表内容
		flushFoodTable(1);
		// 刷新按钮
		JButton flushButton = new JButton("刷新");
		flushButton.setBounds(10, 12, 260, 23);
		pTable.add(flushButton);
		// 查询编号按钮
		JButton findButton = new JButton("查询编号");
		findButton.setBounds(290, 12, 260, 23);
		pTable.add(findButton);
		// 编号排序
		JButton idSortButton = new JButton("▽编号");
		idSortButton.setBounds(10, 38, 174, 23);
		pTable.add(idSortButton);
		// 菜名排序
		JButton nameSortButton = new JButton("▽菜名");
		nameSortButton.setBounds(192, 38, 174, 23);
		pTable.add(nameSortButton);
		// 价格排序
		JButton priceSortButton = new JButton("▽价格");
		priceSortButton.setBounds(376, 38, 174, 23);
		pTable.add(priceSortButton);
		// 表格下面的文本域
		JTextField text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("幼圆", Font.PLAIN, 20));
		text.setEditable(false);
		text.setBounds(10, 640, 540, 50);
		StringBuilder sb = new StringBuilder();
		sb.append("您的菜品共有 ").append(new FoodServiceDaoImpl().showFood(1).size()).append("个");
		text.setText(sb.toString());
		pTable.add(text);
		
		// 修改数据按钮事件，已显示菜谱时
		updateFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!pTable.isVisible())
					return;
				int x = table.getSelectedRow();// 行
				int y = table.getSelectedColumn();// 列
				StringBuilder sb = new StringBuilder().append("请输入新的 ");
				switch (y) {
				case (-1): {
					// 未选择单元格
					JOptionPane.showMessageDialog(null, "请选择单元格!", "请啊", JOptionPane.ERROR_MESSAGE);
					return;
				}
				case 0: {
					// 禁止修改编号
					JOptionPane.showMessageDialog(null, "禁止修改编号!", "禁止", JOptionPane.ERROR_MESSAGE);
					return;

				}
				case 1: {
					sb.append("菜名");
					break;
				}
				case 2: {
					sb.append("菜的价格");
					break;
				}
				}
				String strs = JOptionPane.showInputDialog(null, sb.toString());
				if (strs != null) {
					new FoodServiceDaoImpl().update((long) table.getValueAt(x, 0), strs, y);
					table.setValueAt(strs, x, y);
				}
			}
		});
		// 删除数据按钮事件
		removeFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 控件未显示时不启用事件
				if (!pTable.isVisible())
					return;
				int x = table.getSelectedRow();// 行
				if (x == -1) {
					// 未选择单元格
					JOptionPane.showMessageDialog(null, "请选择行!", "请啊", JOptionPane.ERROR_MESSAGE);
					return;
				}
				long id = (long) table.getValueAt(x, 0);
				StringBuilder sb = new StringBuilder();
				sb.append("您确定要删除编号为 ").append(id).append("的（").append((String) table.getValueAt(x, 1)).append("）吗？");
				int sel = JOptionPane.showConfirmDialog(null, sb.toString(), "确认？", JOptionPane.YES_NO_OPTION);
				if (sel == 0) {
					new FoodServiceDaoImpl().delete(id);
					littleTable.removeRow(x);
					JOptionPane.showMessageDialog(null, "删除成功!");
				}
			}
		});
		// 添加数据按钮事件，已显示菜谱时
		addFoodButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = null;
				do {
					name = JOptionPane.showInputDialog(null, "请输入您要添加的菜品的名称：");
					try {
						if (name.equals("")) {
							// 按的确定键，但是没输入值
							JOptionPane.showMessageDialog(null, "请输入数据", "请啊", JOptionPane.ERROR_MESSAGE);
						} else {
							break;
						}
					} catch (Exception ee) {
						// 抛空指针异常
					}
				} while (name != null);
				// 输入价格对话框
				String strPrice = null;
				double price = 0;
				while (name != null) {
					strPrice = JOptionPane.showInputDialog(null, "请输入您要添加的菜品的价格\n\r(建议3元)：",
							JOptionPane.WARNING_MESSAGE);
					if (strPrice == null) {
						// 按的取消键
						break;
					}
					if (strPrice.equals("")) {
						// 按的确定键，但是没输入值
						JOptionPane.showMessageDialog(null, "请输入数据", "请啊", JOptionPane.ERROR_MESSAGE);
						continue;
					}
					try {
						price = Double.parseDouble(strPrice);
						break;
					} catch (Exception e3) {
						// 转数字失败
						JOptionPane.showMessageDialog(null, "请输入数字或小数", "请啊", JOptionPane.ERROR_MESSAGE);
						continue;
					}
				}
				if (name != null && !name.equals("") && price != 0)
					new FoodServiceDaoImpl().append(name, price);
			}
		});

		// 刷新按钮事件
		flushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(1);
			}
		});
		// ID排序按钮事件
		idSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(1);
			}
		});
		// 菜名排序按钮事件
		nameSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(2);
			}
		});
		// 价格排序按钮事件
		priceSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flushFoodTable(3);
			}
		});

		// 查找编号按钮事件
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	/**
	 * 刷新或者排序表格
	 * 
	 * @param temp 要排序的标识符
	 */
	public void flushFoodTable(int temp) {
		// 删除组件重新加载
		try {
			pTable.remove(scrollPane);
		} catch (Exception e) {
		}
		pTable.setVisible(false);
		// 表格容器
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 540, 573);
		pTable.add(scrollPane);

		// 表格
		table = new JTable();
		table.setRowHeight(22);// 设置行高
		table.setFont(new Font("幼圆", Font.BOLD, 18));// 设置字体
		table.setSelectionBackground(Color.GREEN);// 设置选择背景色
		table.setSelectionForeground(Color.blue);// 设置选择字颜色
		// 加入表格标签题
		littleTable = new DefaultTableModel(new Object[][] {}, new String[] { "编号", "名称", "价格" }) {
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
		// 添加所有记录，先导数据到集合
		TreeSet<Food> ts = new FoodServiceDaoImpl().showFood(temp);
		// 全部添加到表格组件中
		for (Food food : ts) {
			littleTable.addRow(new Object[] { food.getId(), food.getName(), food.getPrice() });
		}

		pTable.setVisible(true);

	}

	/**
	 * 订单表格
	 */
	public void showOrders() {
		pTableOrder = new MyBackgound("cast\\Image\\pLogin.jpg");

		pTableOrder.setBounds(650, 123, 700, 695);
		Constant.pAdmin.add(pTableOrder);
		pTableOrder.setVisible(false);
		pTableOrder.setLayout(null);
		// 表格容器
		JScrollPane scrollPaneOrder = new JScrollPane();
		scrollPaneOrder.setBounds(10, 12, 680, 618);
		pTableOrder.add(scrollPaneOrder);
		// 表格
		JTable tableOrder = new JTable();
		tableOrder.setRowHeight(22);// 设置行高
		tableOrder.setFont(new Font("幼圆", Font.BOLD, 18));// 设置字体
		tableOrder.setSelectionBackground(Color.GREEN);// 设置选择背景色
		tableOrder.setSelectionForeground(Color.blue);// 设置选择字颜色
		// 加入表格标签题
		littleTable = new DefaultTableModel(new Object[][] {},
				new String[] { "订单编号", "订单客户账号", "订单详细信息", "订单价格", "订单时间" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;// 返回true表示能编辑，false表示不能编辑
			}
		};
		tableOrder.setModel(littleTable);
		scrollPaneOrder.setViewportView(tableOrder);
		// 设置单元格居中对齐
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		tableOrder.setDefaultRenderer(Object.class, r);
		// 导数据到集合
		TreeSet<Order> ts = new OrderServiceDaoImpl().getOrders();
		// 全部添加到表格组件中
		for (Order o : ts) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm");
			littleTable.addRow(new Object[] { o.getOrderId(), o.getUser() == null ? "游客" : o.getUser().getAccount(),
					"双击查看", o.getSumPrice(), sdf.format(o.getDate()) });
		}
		// 表格下面的文本域
		JTextField text = new JTextField();
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("幼圆", Font.PLAIN, 20));
		text.setEditable(false);
		text.setBounds(10, 630, 680, 55);
		CollectForm cf = new OrderServiceDaoImpl().getOrdersCollect();
		StringBuilder sb = new StringBuilder();
		sb.append("从初始化以来您的订单数目有 ").append(cf.getTsorder().size()).append("个").append(", 总共盈利：")
				.append(cf.getSumPrices()).append("元");
		text.setText(sb.toString());
		pTableOrder.add(text);
		// 表格中单元格事件
		tableOrder.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//点击
				Order o = new OrderServiceDaoImpl().findOrder((long)tableOrder.getValueAt(tableOrder.getSelectedRow(), 0));    
				ArrayList<Food> al = o.getFoods();
				StringBuilder sb = new StringBuilder();
				for (Food f : al) {
					sb.append("\t\t\t编号:"+f.getId()+"\t\t\t    菜名: "+f.getName()+"\t\t\t     单价: "+f.getPrice()+"\n\r");
				}
				JOptionPane.showMessageDialog(null, sb.toString());			
			}
		} );
	}
}