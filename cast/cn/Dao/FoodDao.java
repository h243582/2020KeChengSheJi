package cn.Dao;

import java.util.TreeMap;
import java.util.TreeSet;

import cn.VO.Food;
/**
 * 食品的一些操作接口
 * @author 何昱飞
 *
 * @param <V> VO类型
 */
public interface FoodDao<V>{
	/**
	 * 把数据库菜品表记录写入set集合
	 * @param temp 排序方式 1:id、2:name、3:price
	 * @return	写入后的集合 返回
	 */
	public TreeSet<V> showFood(int temp);
	/**
	 * 把数据库菜品表记录写入map集合
	 * @return 写入后的集合 返回
	 */
	public TreeMap<Long,Food> showFood2();

	/**
	 * 修改数据库单元格内容，不能修改编号
	 * @param id 编号为主键
	 * @param strs 修改后的数据
	 * @param y 修改的列标识符
	 * @return	成功返回true
	 */
	public boolean update(long id,String strs,int y);
	/**
	 * 以id删除行
	 * @param id 要删除的号
	 * @return 成功返回true
	 */
	public boolean remove(long id);
	/**
	 * 在数据库添加记录
	 * @param name
	 * @param price
	 * @return	成功返回true
	 */
	public boolean add(String name, double price);
	/**
	 * 编号查找菜
	 * @param id 编号
	 * @return	返回菜
	 */
	public V find(long id);
	
}
