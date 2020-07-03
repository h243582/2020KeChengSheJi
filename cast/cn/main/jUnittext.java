package cn.main;

import java.util.ArrayList;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;

import cn.Factory.DaoFactory;
import cn.ServiceDaoImpl.OrderServiceDaoImpl;
import cn.ServiceDaoImpl.UserServiceDaoImpl;
import cn.UI.SwingUI_Main_Interface;
import cn.VO.Food;
import cn.VO.Order;
import cn.VO.User;
/**
 * jUnit测试类
 * @author 何昱飞
 *
 */
class jUnittext {
	//@Test
	void addFile10000() throws Exception {
		//添加一万个账户
		for (long i = 22222; i < 33333; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("w");
			sb.append(i);
			User u = new User("你好特别"+String.valueOf(i), sb.toString(), "123", "+86", "18680435149");
			new UserServiceDaoImpl().append(u);
		}
	}

	@Test
	void foodFind() throws Exception {
		//找一个菜
		Food f = new DaoFactory().getFoodFactoryInstance().find(3);
		System.out.println(f.getId() + "--" + f.getName() + "--" + f.getPrice());
	}

	@Test
	void foodAppend() throws Exception {
		
		new SwingUI_Main_Interface();
	}

	@Test
	void orderGetId() throws Exception {
		//自动获取订单id
		long id = new DaoFactory().getOrderFactoryInstance().getOrderId();
		System.out.println(id);
	}

	@Test
	void orderAddFile() throws Exception {
		//订单添加到文件测试
		//long id = new DaoFactory().getOrderFactoryInstance().getOrderId();
		ArrayList<Food> al = new ArrayList<Food>();
		al.add(new Food(11112, "大盘鸡", 110));
		al.add(new Food(11113, "大盘鸡", 110));
		boolean t = new DaoFactory().getOrderFactoryInstance()
				.addFile(new Order(new User("何昱飞哈哈", "h1868041", "1", "+86", "55555"), al));
		System.out.println(t);
		new DaoFactory().getOrderFactoryInstance().showAll();
	}
	
	@Test
	void orderGetOrders() throws Exception {
		//输出文件中订单
		TreeSet<Order> ts= new OrderServiceDaoImpl().getOrders();
		for (Order o : ts) {
			System.out.println(o);

		}
	}
	@Test
	void removeUser() throws Exception {
		//删除某个账户
		System.out.println(new UserServiceDaoImpl().delete("w22222"));
	}
	
}
