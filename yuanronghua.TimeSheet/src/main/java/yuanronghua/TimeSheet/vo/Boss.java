package yuanronghua.TimeSheet.vo;

import java.io.Serializable;

/**
 * @Title: Boss.java
 * @Package yuanronghua.TimeSheet.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年2月2日 下午4:21:48
 **/

public class Boss implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453058685017645852L;
	private int id;
	private String name;
	private String phone;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
