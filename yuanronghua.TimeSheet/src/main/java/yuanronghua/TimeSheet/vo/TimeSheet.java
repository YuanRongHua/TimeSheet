package yuanronghua.TimeSheet.vo;

import java.io.Serializable;

/**
 * @Title: TimeSheet.java
 * @Package yuanronghua.TimeSheet.vo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年1月11日 下午5:06:53
 **/

public class TimeSheet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8188229706453113528L;

	public int id;

	public String dateTime;

	public String address;

	public int time_hour;

	public int salary;

	public String name;

	public String remark;

	public int account_id;

	public int boss_id;

	/***
	 * 
	 * Boos
	 */
	public String boss_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTime_hour() {
		return time_hour;
	}

	public void setTime_hour(int time_hour) {
		this.time_hour = time_hour;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getBoss_id() {
		return boss_id;
	}

	public void setBoss_id(int boss_id) {
		this.boss_id = boss_id;
	}

	public String getBoss_name() {
		return boss_name;
	}

	public void setBoss_name(String boss_name) {
		this.boss_name = boss_name;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

}
