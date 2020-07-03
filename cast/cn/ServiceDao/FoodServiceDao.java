package cn.ServiceDao;

import java.util.TreeSet;
/**
 * 对于dao层的FoodDao接口的实现服务类接口，用factory调用
 * @author 何昱飞
 *
 * @param <V>	对象
 */
public interface FoodServiceDao<V> {
	/**
	 * 把数据库菜品表记录写入set集合
	 * <br>使用FoodDAO接口中的showFood方法<br>
	 * @param temp 排序方式 1:id、2:name、3:price
	 * @return	写入后的集合 返回
	 */
	public TreeSet<V> showFood(int temp);
	/**
	 * 修改数据库单元格内容，不能修改编号
	 * <br>使用FoodDAO接口中的update方法<br>
	 * @param id 编号为主键
	 * @param strs 修改后的数据
	 * @param y 修改的列标识符
	 * @return	成功返回true
	 */
	public boolean update(long id,String strs,int y);
	/**
	 * 以id删除行
	 * <br>使用FoodDAO接口中的remove方法<br>
	 * @param id 要删除的号
	 * @return 成功返回true
	 */
	public boolean delete(long id);
	/**
	 * 在数据库添加记录
	 * <br>使用FoodDAO接口中的add方法<br>
	 * @param name
	 * @param price
	 * @return	成功返回true
	 */
	public boolean append(String name, double price);
	/**
	 * 编号查找菜
	 * <br>使用FoodDAO接口中的find方法<br>
	 * @param id 编号
	 * @return	返回菜
	 */
	public V find(long id);
}
