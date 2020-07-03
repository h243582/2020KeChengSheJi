package cn.VO;

import java.io.Serializable;

/**
 * 具体类，用于暂存数据库菜品表单条记录
 * @author 何昱飞
 *
 */
public class Food implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private double price;
	public Food() {
		super();
	}
	public Food(long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}