package cn.Dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import cn.Dao.UserOrderDao;
import cn.Util.Constant;
import cn.VO.CollectForm;
import cn.VO.Order;
/**
 * 对于订单的操作实现类
 * @author 何昱飞
 *
 */
public class OrderDaoImpl implements UserOrderDao<Order> {
	@Override
	public long getOrderId() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(Constant.OrderId));
			String str = br.readLine();
			br.close();
			if (str == null || str.equals("")) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.OrderId));
				bw.write("11111");
				bw.close();
				return 11111;
			} else {
				long id = Integer.parseInt(str);
				id += 1;
				BufferedWriter bw = new BufferedWriter(new FileWriter(Constant.OrderId));
				bw.write(String.valueOf(id));
				bw.close();
				return id;
			}
		} catch (IOException e) {
		}
		return -1;

	}

	@Override
	public boolean addFile(Order u) throws Exception {
		File f = new File(Constant.Order);
		ObjectOutputStream oos;
		u.setOrderId(getOrderId()) ;
		try {
			if (f.length() < 1) {
				oos = new ObjectOutputStream(new FileOutputStream(f, true));

			} else {
				oos = new ObjectOutputStream(new FileOutputStream(f, true)) {
					public void writeStreamHeader() {
						return;
					}
				};
			}
			oos.writeObject(u);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("null")
	@Override
	public TreeSet<Order> getOrders() {
		TreeSet<Order> ts = new TreeSet<Order>(new Comparator<Order>() {
			@Override
			public int compare(Order o1, Order o2) {
				long o = o2.getDate().getTime() - o1.getDate().getTime();
				return o > 0 ? 1 : -1;
			}
		});
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.Order));
			Order o;
			while ((o = (Order) ois.readObject()) != null) {
				ts.add(o);
			}
		} catch (EOFException e) {
			// 捕捉特定异常
			try {
				ois.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return ts;

		} catch (Exception e1) {
		}
		return null;

	}

	@Override
	public CollectForm getOrdersCollect() {
		TreeSet<Order> ts = getOrders();
		double sumPrices = 0;
		for (Order o : ts) {
			sumPrices+=o.getSumPrice();
		}
		CollectForm cf = new CollectForm(ts, sumPrices);
		return cf;
	}
	
	@Override
	public Order findOrder(long orderId) {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.Order));
			Order u;
			while ((u = (Order) ois.readObject()) != null) {
				if (u.getOrderId()==orderId) {
					ois.close();
					return u;
				}
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			try {
				ois.close();
			} catch (IOException e1) {
			}
		}catch (Exception e) {
		}	
		return null;		
	}
	@Override
	public boolean addAll(ArrayList<Order> list) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void showAll() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constant.Order))) {
			Order u;
			System.out.println("\t    所有用户信息");
			while ((u = (Order) ois.readObject()) != null) {
				System.out.println(u.getOrderId() + "\t" + u.getUser().getAccount() + "\t\t" + u.getFoods()
						+ "\t\t" + u.getSumPrice() + "-" + u.getDate());
			}
			ois.close();
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
		}
	}

	@Override
	public boolean remove(String account) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateName(String account, String name) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassword(String account, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePhone(String account, String phoneRegion, String phoneNumber) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVIP(String account, boolean vip) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean repetition(String account) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginOn(String account, String password) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order findUser(String account) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}