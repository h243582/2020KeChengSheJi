package cn.Dao;

import java.util.ArrayList;
import java.util.TreeSet;

import cn.VO.CollectForm;

/**
 * 用户、订单操作接口
 * @author 何昱飞
 *
 * @param <V> 操作的对象
 */
public interface UserOrderDao<V> {
	/**
	 * 把V对象信息追加到文件
	 * 由于用FileInputStream(文件名,true)向同一个文件中序列化对象，每次都会向文件中序列化一个header。在反序列化的时候每个
	 * ObjectInputStream 对象只会读取一个header 此处重写writeStreamHeader方法
	 * @param u 要写入的对象
	 * @return 添加是否成功
	 * @throws Exception 抛异常
	 */
	public boolean addFile(V u) throws Exception;
	/**
	 * 覆盖式 集合形式添加V对象
	 * @return 添加是否成功
	 * @param list 要添加的V集合
	 * @throws Exception 抛异常
	 */
	public boolean addAll(ArrayList<V> list) throws Exception;
	/**
	 * 输出
	 * @throws Exception 抛异常
	 */
	public void showAll() throws Exception;
	/**
	 * 删除文件中单个用户
	 * 
	 * @param account 以账号查找删除用户
	 * @return 删除是否成功
	 * @throws Exception 抛异常
	 */
	public boolean remove(String account) throws Exception;
	/**
	 * 修改昵称
	 * @param account 根据账号
	 * @param name 修改后的昵称
	 * @return 修改是否成功
	 * @throws Exception 抛异常
	 */
	public boolean updateName(String account,String name)throws Exception;
	/**
	 * 修改密码
	 * @param account 根据账号
	 * @param password 修改后的密码
	 * @return 修改是否成功
	 * @throws Exception 抛异常
	 */
	public boolean updatePassword(String account,String password)throws Exception;
	/**
	 * 修改电话
	 * @param account 根据账号
	 * @param phoneRegion 号码地域
	 * @param phoneNumber 号码
	 * @return 修改是否成功
	 * @throws Exception 抛异常
	 */
	public boolean updatePhone(String account,String phoneRegion,String phoneNumber)throws Exception;
 
	/**
	 * 把这个人变成VIP
	 * 
	 * @param account 账号
	 * @param vip vip
	 * @return 修改是否成功
	 */
	public boolean updateVIP(String account,boolean vip)throws Exception;
	/**
	 * 注册时判断是否有重复账号
	 * @param account 要判断的账户
	 * @return 重复true; 不重复false
	 * @throws Exception 抛异常
	 */
	public boolean repetition(String account) throws Exception;
	/**
	 * 账号密码是否错误
	 * @param account 登录时输入的账号
	 * @param password 登录时输入的密码
	 * @return 登录是否成功,成功返回true
	 * @throws Exception 抛异常
	 */
	public boolean loginOn(String account,String password)throws Exception;
	/**
	 * 根据账号查找用户
	 * @param account 账号
	 * @return 返回这个用户
	 * @throws Exception 抛异常
	 */
	public V findUser(String account)throws Exception;
	
	/**
	 * 自动化获取订单id
	 * @return 订单号
	 */
	public long getOrderId();
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
