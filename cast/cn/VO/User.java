package cn.VO;
import java.io.Serializable;
/**
 * 具体类，暂存用户信息
 * <br>实现接口Serializable 作用是把对象直接以二进制写入到文件，且不损坏结构
 * 
 * @author 何昱飞
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;// 昵称
	private String account;// 账号
	private String password;// 密码
	private String phoneRegion;// 号码地区
	private String phoneNumber;// 号码
	private boolean vip;// VIP

	public User() {
	}

	public User(String name, String account, String password, String phoneRegion, String phoneNumber) {
		this.name = name;
		this.account = account;
		this.password = password;
		this.phoneRegion = phoneRegion;
		this.phoneNumber = phoneNumber;
		this.vip = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneRegion() {
		return phoneRegion;
	}

	public void setPhoneRegion(String phoneRegion) {
		this.phoneRegion = phoneRegion;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}