package cn.Dao.impl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;

import cn.Dao.UserOrderDao;
import cn.Util.Constant;
import cn.VO.CollectForm;
import cn.VO.User;
/**
 * 对于用户具体类的操作实现类
 * @author 何昱飞
 *
 */
public class UserDaoImpl implements UserOrderDao<User> {

	@Override
	public boolean addFile(User u) throws Exception {
		File f = new File(Constant.File);
		ObjectOutputStream oos;
		try {
			if (f.length() < 1) {
				oos = new ObjectOutputStream(new FileOutputStream(f, true));

			} else {
				oos = new ObjectOutputStream(new FileOutputStream(f, true)) {
					public void writeStreamHeader(){
						return;
					}
				}; 
			}
			oos.writeObject(u);
			oos.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addAll(ArrayList<User> list) throws Exception {
		File f = new File(Constant.File);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			for (User u : list) {
				oos.writeObject(u);
			}
			oos.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public void showAll() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constant.File))) {
			User u;
			System.out.println("\t    所有用户信息");
			while ((u = (User) ois.readObject()) != null) {
				System.out.println(u.getName() + "\t" + u.getAccount() + "\t\t" + u.getPassword() + "\t\t"
						+ u.getPhoneRegion() + "-" + u.getPhoneNumber());
			}
			ois.close();
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
		}
	}

	@SuppressWarnings("null")
	@Override
	public boolean remove(String account) throws Exception, ClassNotFoundException {
		boolean temp = false;
		ArrayList<User> li = new ArrayList<User>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (!(u.getAccount().equals(account))) {
					li.add(u);
				}else {
					temp = true;
				}
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		addAll(li);
		return temp;
	}

	@SuppressWarnings("null")
	@Override
	public boolean updateName(String account, String name) throws Exception, ClassNotFoundException {
		boolean temp = false;
		ArrayList<User> li = new ArrayList<User>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)) {
					u.setName(name);
					temp = true;
				}
				li.add(u);
				u = null;
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		 addAll(li);
		 return temp;
	}

	@SuppressWarnings("null")
	@Override
	public boolean updatePassword(String account, String password) throws Exception, ClassNotFoundException {
		boolean temp = false;
		ArrayList<User> li = new ArrayList<User>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)) {
					u.setPassword(password);
					temp = true;
				}
				li.add(u);
				u = null;
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		addAll(li);
		 return temp;

	}

	@SuppressWarnings("null")
	@Override
	public boolean updatePhone(String account, String phoneRegion, String phoneNumber)
			throws Exception, ClassNotFoundException {
		boolean temp = false;
		ArrayList<User> li = new ArrayList<User>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)) {
					u.setPhoneRegion(phoneRegion);
					u.setPhoneNumber(phoneNumber);
					temp = true;
				}
				li.add(u);
				u = null;
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		addAll(li);
		 return temp;

	}

	@SuppressWarnings("null")
	@Override
	public boolean updateVIP(String account, boolean vip) throws Exception, ClassNotFoundException {
		boolean temp = false;
		ArrayList<User> li = new ArrayList<User>();
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)) {
					u.setVip(vip);
					temp = true;
				}
				li.add(u);
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		addAll(li);
		 return temp;

	}

	@Override
	public boolean repetition(String account) throws Exception, ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)) {
					ois.close();
					return true;
				}
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		return false;
	}

	@Override
	public boolean loginOn(String account, String password) throws Exception, ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)&&u.getPassword().equals(password)) {
					ois.close();
					return true;
				}
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}
		return false;
	}

	@Override
	public User findUser(String account) throws Exception, ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(Constant.File));
			User u;
			while ((u = (User) ois.readObject()) != null) {
				if (u.getAccount().equals(account)) {
					ois.close();
					return u;
				}
			}
		} catch (EOFException e) {
			// 一定要捕捉这个异常，文件其实已经关闭，但是readObject还在查询
			ois.close();
		}		
		return null;
	}

	@Override
	public long getOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeSet<User> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectForm getOrdersCollect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOrder(long orderId) {
		// TODO Auto-generated method stub
		return null;
	}
}
