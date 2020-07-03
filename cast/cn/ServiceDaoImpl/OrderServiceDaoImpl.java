package cn.ServiceDaoImpl;

import java.util.TreeSet;

import cn.Factory.DaoFactory;
import cn.ServiceDao.UserOrderServiceDao;
import cn.VO.CollectForm;
import cn.VO.Order;
/**
 * 订单的服务接口实现类
 * @author 何昱飞
 *
 */
public class OrderServiceDaoImpl implements UserOrderServiceDao<Order> {

	@Override
	public boolean append(Order u) throws Exception {
				return new DaoFactory().getOrderFactoryInstance().addFile(u);
	}

	@Override
	public TreeSet<Order> getOrders() {
				return new DaoFactory().getOrderFactoryInstance().getOrders();
	}
	@Override
	public CollectForm getOrdersCollect() {
		return new DaoFactory().getOrderFactoryInstance().getOrdersCollect();
	}
	@Override
	public Order findOrder(long orderId) {
		return new DaoFactory().getOrderFactoryInstance().findOrder(orderId);
	}
	
	@Override
	public boolean delete(String account) throws Exception {
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