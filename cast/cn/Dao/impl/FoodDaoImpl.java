package cn.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import cn.Dao.FoodDao;
import cn.Util.DatabaseConnection;
import cn.VO.Food;
import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * 对于食物具体类的操作实现类
 * 
 * @author 何昱飞
 *
 */
public class FoodDaoImpl implements FoodDao<Food> {
	public FoodDaoImpl() {
	}

	@Override
	public TreeSet<Food> showFood(int temp) {
		DatabaseConnection JDBC = new DatabaseConnection();
		Connection conn = JDBC.getConnection();
		TreeSet<Food> ts = new TreeSet<Food>(new Comparator<Food>() {
			@Override
			public int compare(Food f1, Food f2) {
				switch (temp) {
				default: {
					// id排序
					return (int) (f1.getId() - f2.getId());
				}
				case 2: {
					// 名字排序
					// Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
					// com.compare(f1, f2);
					int temppy = ToPinYinString(f1.getName()).compareTo(ToPinYinString(f2.getName()));
					if (temppy > 0) {
						return 1;
					} else if (temppy < 0) {
						return -1;
					} else {
						// 次要排序以id
						return (int) (f1.getId() - f2.getId());
					}

				}
				case 3: {
					// 价格降排序
					double p = f2.getPrice() - f1.getPrice();
					// p = (p*100+50)/100;//四舍五入
					if (p > 0) {
						return 1;
					} else {
						return -1;
					}

				}
				}
			}

			/**
			 * 拼音排序比较器
			 * 
			 * @param str 要转换的中文
			 * @return 转换为字符后
			 */
			private String ToPinYinString(String str) {

				StringBuilder sb = new StringBuilder();
				String[] arr = null;
				for (int i = 0; i < str.length(); i++) {
					// 拼音排序插件
					arr = PinyinHelper.toHanyuPinyinStringArray(str.charAt(i));
					if (arr != null && arr.length > 0) {
						for (String string : arr) {
							sb.append(string);
						}
					}
				}

				return sb.toString();
			}

		});

		try {
			String sql = "select * from 菜品表;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Food food = new Food(rs.getLong(1), rs.getString(2), rs.getDouble(3));
				ts.add(food);
			}
			JDBC.close();
		} catch (Exception e) {
		}
		return ts;
	}

	public TreeMap<Long, Food> showFood2() {
		TreeMap<Long, Food> tm = new TreeMap<Long, Food>();
		DatabaseConnection JDBC = new DatabaseConnection();
		Connection conn = JDBC.getConnection();
		try {
			String sql = "select * from 菜品表;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Food food = new Food(rs.getLong(1), rs.getString(2), rs.getDouble(3));
				tm.put(rs.getLong(1), food);
			}
			JDBC.close();
		} catch (Exception e) {
		}
		return tm;
	}

	@Override
	public boolean update(long id, String strs, int y) {
		DatabaseConnection JDBC = new DatabaseConnection();
		Connection conn = JDBC.getConnection();
		String sql;
		if (y == 1) {
			sql = "update 菜品表  set name = ? where id = ?;";
		} else {
			sql = "update 菜品表  set price = ? where id = ?;";
		}
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if (y == 1) {
				pstmt.setString(1, strs);
			} else {
				pstmt.setDouble(1, Double.parseDouble(strs));
			}
			pstmt.setLong(2, id);
			boolean temp = pstmt.executeUpdate() > 0;
			JDBC.close();
			return temp;
		} catch (Exception e) {
			return false;

		}
	}

	@Override
	public boolean remove(long id) {
		DatabaseConnection JDBC = new DatabaseConnection();
		Connection conn = JDBC.getConnection();
		String sql = "delete from 菜品表 where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			boolean temp = pstmt.executeUpdate() > 0;
			JDBC.close();
			return temp;

		} catch (Exception e) {
			return false;

		}
	}

	@Override
	public boolean add(String name, double price) {
		DatabaseConnection JDBC = new DatabaseConnection();
		Connection conn = JDBC.getConnection();
		String sql = "insert into 菜品表 values(?,?,?);";
		long id = 0;
		try {
			// 先查有没有空位编号
			TreeMap<Long, Food> ts = showFood2();
			Set<Long> idset = ts.keySet();
			@SuppressWarnings("deprecation") // 不检测它是否被弃用
			Long lastid = new Long(0);
			for (Long ldL : idset) {
				if (ldL - lastid > 1) {
					// 有空位，新记录就插在这
					id = Long.parseLong(lastid.toString()) + 1;
					break;
				}
				lastid = ldL;
			}
			// 执行
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.setString(2, name);
			pstmt.setDouble(3, price);
			boolean temp = pstmt.executeUpdate() > 0;
			JDBC.close();
			return temp;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public Food find(long id) {
		DatabaseConnection JDBC = new DatabaseConnection();
		Connection conn = JDBC.getConnection();
		String sql = "select * from 菜品表 where id = ? ;";

		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setLong(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Food f = new Food(rs.getLong(1), rs.getString(2), rs.getDouble(3));
				JDBC.close();
				return f;
			}

		} catch (Exception e) {
		}

		return null;
	}
}
