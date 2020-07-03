package cn.VO;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

/**
 * 订单表
 * 
 * @author 何昱飞
 *
 */
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private long orderId;// 自动生成
	private User user;
	private ArrayList<Food> foods;
	private double sumPrice;
	private Date date;//初始化时得到时间

	public Order() {
		super();
	}

	public Order(User user, ArrayList<Food> foods) {
		super();
		this.orderId = -1;
		this.user = user;
		this.foods = foods;
		this.sumPrice = 0;
		
		try {
			for (Food f : foods ) {
				sumPrice += f.getPrice();
			}
		} catch (Exception e) {
		}
		this.date = new Date(System.currentTimeMillis());
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}

	public double getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}