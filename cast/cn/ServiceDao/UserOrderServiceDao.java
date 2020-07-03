package cn.ServiceDao;

import java.util.TreeSet;

import cn.VO.CollectForm;

/**
 * 对于dao层的UserOrder接口的用户或订单实现服务类接口，用factory调用
 * 
 * @author 何昱飞
 *
 * @param <V>
 */
public interface UserOrderServiceDao<V> {
	/**
	 * 把账户信息追加到文件 <br>
	 * 使用UserDAO接口中的addFile方法<br>
	 * 
	 * @param u 添加账户
	 * @return 添加是否成功
	 * @throws Exception 抛异常
	 */
	public boolean append(V u) throws Exception;

	/**
	 * 删除文件中单个用户 <br>
	 * 使用UserDAO接口中的remove方法<br>
	 * 
	 * @param account 以账号查找删除用户
	 * @return 删除是否成功
	 * @throws Exception 抛异常
	 */
	public boolean delete(String account) throws Exception;

	/**
	 * 修改昵称 <br>
	 * 使用UserDAO接口中的updateName方法<br>
	 * 
	 * @param account 根据账号
	 * @param name    修改后的昵称
	 * @return 修改是否成功
	 * @throws Exception 抛异常
	 * 
	 */
	public boolean updateName(String account, String name) throws Exception;

	/**
	 * 修改密码 <br>
	 * 使用UserDAO接口中的updatePassword方法<br>
	 * 
	 * @param account  根据账号
	 * @param password 修改后的密码
	 * @return 修改是否成功
	 * @throws Exception 抛异常 抛异常
	 */
	public boolean updatePassword(String account, String password) throws Exception;

	/**
	 * 修改电话 <br>
	 * 使用UserDAO接口中的updatePhone方法<br>
	 * 
	 * @param account     根据账号
	 * @param phoneRegion 号码地域
	 * @param phoneNumber 号码
	 * @return 修改是否成功
	 * @throws Exception 抛异常
	 * 
	 */
	public boolean updatePhone(String account, String phoneRegion, String phoneNumber) throws Exception;

	/**
	 * 注册时判断是否有重复账号 <br>
	 * 使用UserDAO接口中的repetition方法<br>
	 * 
	 * @param account 要判断的账户
	 * @return 重复true; 不重复false
	 * @throws Exception 抛异常
	 * 
	 */
	public boolean repetition(String account) throws Exception;

	/**
	 * 账号密码是否错误 <br>
	 * 使用UserDAO接口中的loginOn方法<br>
	 * 
	 * @param account  登录时输入的账号
	 * @param password 登录时输入的密码
	 * @return 登录是否成功,成功返回true
	 * @throws Exception 抛异常
	 */
	public boolean loginOn(String account, String password) throws Exception;

	/**
	 * 根据账号查找用户 <br>
	 * 使用UserDAO接口中的findUser方法<br>
	 * 
	 * @param account 账号
	 * @return 返回这个用户
	 * @throws Exception 抛异常
	 */
	public V findUser(String account) throws Exception;
	/**
	 * 从文件中读取得到所有V对象信息
	 * @return 返回V对象的集合
	 */
	public TreeSet<V> getOrders();
	
	/**
	 * 得到一个汇总表
	 * @return 返回汇总表
	 */
	public CollectForm getOrdersCollect(); 
	/**
	 * 根据单号查找订单
	 * @param orderId 单号
	 * @return 返回订单
	 */
	public V findOrder(long orderId);
}
