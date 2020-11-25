package com.hms.model;

/**
 * רҵ��Ϣ��
 *
 */
public class Major {
	// ���
	private Integer id;
	// רҵ���
	private String mid;
	// רҵ����
	private String name;
	// רҵ������
	private String people;
	// רҵ��������ϵ��ʽ
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
