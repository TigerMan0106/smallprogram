package com.hms.model;

/**
 * 专业信息类
 *
 */
public class Major {
	// 编号
	private Integer id;
	// 专业编号
	private String mid;
	// 专业名称
	private String name;
	// 专业负责人
	private String people;
	// 专业负责人联系方式
	private String phone;

	public Major(Integer id, String mid, String name, String people, String phone) {
		super();
		this.id = id;
		this.mid = mid;
		this.name = name;
		this.people = people;
		this.phone = phone;
	}

	public Major(String mid, String name, String people, String phone) {
		super();
		this.mid = mid;
		this.name = name;
		this.people = people;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
