package yuanronghua.TimeSheet.vo;

import java.io.Serializable;

/**
 * @Title: Account.java
 * @Package yuanronghua.TimeSheet.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年2月1日 下午12:48:27
 **/

public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2417229164993310732L;
	private int id;
	private String name;
	private String phone;
	private String password;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
