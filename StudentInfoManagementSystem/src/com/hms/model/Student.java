package com.hms.model;

/**
 * 班级信息类
 *
 */
public class Student {
	// 编号
	private Integer id;
	// 学生学号
	private String sid;
	// 学生姓名
	private String name;
	// 学生性别
	private String sex;
	// 学生身份证号码
	private String idcard;
	// 学生籍贯
	private String nplace;
	// 学生专业
	private String major;
	// 学生班级
	private String classes;
	// 学生联系方式
	private String phone;

	public Student(Integer id, String sid, String name, String sex, String idcard, String nplace, String major,
			String classes, String phone) {
		super();
		this.id = id;
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.nplace = nplace;
		this.major = major;
		this.classes = classes;
		this.phone = phone;
	}

	public Student(String sid, String name, String sex, String idcard, String nplace, String major, String classes,
			String phone) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.nplace = nplace;
		this.major = major;
		this.classes = classes;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getNplace() {
		return nplace;
	}

	public void setNplace(String nplace) {
		this.nplace = nplace;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
