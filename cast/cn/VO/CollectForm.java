package cn.VO;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * 汇总表,序列化接口
 */
public class CollectForm implements Serializable {
	private static final long serialVersionUID = 1L;
	private TreeSet<Order> tsorder;
	private double sumPrices;

	public CollectForm() {
		super();
	}

	public CollectForm(TreeSet<Order> tsorder, double sumPrices) {
		super();
		this.tsorder = tsorder;
		this.sumPrices = sumPrices;
	}

	public TreeSet<Order> getTsorder() {
		return tsorder;
	}

	public void setTsorder(TreeSet<Order> tsorder) {
		this.tsorder = tsorder;
	}

	public double getSumPrices() {
		return sumPrices;
	}

	public void setSumPrices(double sumPrices) {
		this.sumPrices = sumPrices;
	}

}
