package cn.ServiceDaoImpl;
import java.util.TreeSet;

import cn.Factory.DaoFactory;
import cn.ServiceDao.UserOrderServiceDao;
import cn.VO.CollectForm;
import cn.VO.User;
/**
 * 对于dao层的UserDao接口服务类接口的实现类
 * @author 何昱飞
 *
 */
public class UserServiceDaoImpl implements UserOrderServiceDao<User> {

	@Override
	public boolean append(User u) throws Exception {
		return new DaoFactory().getUserFactoryInstance().addFile(u);
	}

	@Override
	public boolean delete(String account) throws Exception {
		return new DaoFactory().getUserFactoryInstance().remove(account);
	}

	@Override
	public boolean updateName(String account, String name) throws Exception {
		return new DaoFactory().getUserFactoryInstance().updateName(account, name);
	}

	@Override
	public boolean updatePassword(String account, String password) throws Exception {
		return new DaoFactory().getUserFactoryInstance().updatePassword(account, password);
	}

	@Override
	public boolean updatePhone(String account, String phoneRegion, String phoneNumber)
			throws Exception {
		return new DaoFactory().getUserFactoryInstance().updatePhone(account, phoneRegion, phoneNumber);
	}

	@Override
	public boolean repetition(String account) throws Exception {
		return new DaoFactory().getUserFactoryInstance().repetition(account);
	}

	@Override
	public boolean loginOn(String account, String password) throws Exception {
		return new DaoFactory().getUserFactoryInstance().loginOn(account, password);
	}

	@Override
	public User findUser(String account) throws Exception {
		return new DaoFactory().getUserFactoryInstance().findUser(account);
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
