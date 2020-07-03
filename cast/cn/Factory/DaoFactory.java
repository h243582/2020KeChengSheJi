package cn.Factory;

import cn.Dao.FoodDao;
import cn.Dao.UserOrderDao;
import cn.Dao.impl.FoodDaoImpl;
import cn.Dao.impl.OrderDaoImpl;
import cn.Dao.impl.UserDaoImpl;
import cn.VO.Food;
import cn.VO.Order;
import cn.VO.User;
/**
 * 这是个工厂类，执行实现类的内容，返回实现类
 * @author 何昱飞
 *
 */
public class DaoFactory {
	/**
	 * 获取用户操作的实现类
	 * @return 用户操作的实现类
	 */
	public UserOrderDao<User> getUserFactoryInstance() {
		return new UserDaoImpl();
	}
	/**
	 * 获取食品操作的实现类
	 * @return 食品操作的实现类
	 */
	public FoodDao<Food>  getFoodFactoryInstance() {
		return new FoodDaoImpl();
	}
	/**
	 * 获取订单操作的实现类
	 * @return 订单操作的实现类
	 */
	public UserOrderDao<Order>  getOrderFactoryInstance() {
		return new OrderDaoImpl();
	}
	
}
