package com.hms.model;

/**
 * 班级信息类
 *
 */
public class Classes {
	// 编号
	private Integer id;
	// 班级编号
	private String cid;
	// 班级名称
	private String name;
	// 班级辅导员
	private String people;
	// 班级辅导员联系方式
	private String phone;

	public Classes(Integer id, String cid, String name, String people, String phone) {
		super();
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.people = people;
		this.phone = phone;
	}

	public Classes(String cid, String name, String people, String phone) {
		super();
		this.cid = cid;
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

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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
