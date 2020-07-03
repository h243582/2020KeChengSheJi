package cn.Util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 自定义容器工具类，自带背景图
 * 
 * @author 何昱飞
 *
 */
public class MyBackgound extends JPanel {
	private static final long serialVersionUID = 1L;
	private String imgStr;// 图片路径
	private int x;
	private int y;
	private int width;
	private int height;

	/**
	 * 设置自定义背景铺满屏幕
	 * @param imgStr 图片路径
	 */
	public MyBackgound(String imgStr) {
		this.imgStr = imgStr;
		this.y = 0;
		this.width = -1;
		this.height = -1;
	}

	/**
	 * 设置自定义背景位置大小
	 * 
	 * @param imgStr 图片路径
	 * @param x      横坐标
	 * @param y      纵坐标
	 * @param width  长
	 * @param height 高
	 */
	public MyBackgound(String imgStr, int x, int y, int width, int height) {
		this.imgStr = imgStr;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setBoundh(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// int width = this.getWidth();
		// int height = this.getHeight();
		// 清除显示
		g.clearRect(0, 0, width, height);
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(imgStr));
			//Image image = ImageIO.read(new File(imgStr));
			if (this.width == -1 && this.height == -1) {
				// 占满整个控件
				g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
			} else {
				// 自定义图片占多少位置
				g.drawImage(image, x, y, this.width, this.height, null);
			}
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}