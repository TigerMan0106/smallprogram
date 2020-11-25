package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.Student;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class StudentDao {

	// 实例化数据库操作对象
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * 学生信息添加
	 * 
	 * @param student
	 * @return
	 */
	public boolean doStudentAdd(Student student) {
		// 声明sql语句
		String select_sql = "select Sid from t_student where Sid=?";
		String insert_sql = "insert into t_student(Sid,Name,Sex,Idcard,Nplace,Major,Classes,Phone) values (?,?,?,?,?,?,?,?)";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, student.getSid());
		// 存储状态
		boolean studentExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// 学生已存在
				studentExisted = true;
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 判断是否需要添加
		if (!studentExisted) {
			// 学生信息不存在,继续添加
			registerStatus = mhelper.doUpdate(insert_sql, student.getSid(), student.getName(),student.getSex(),student.getIdcard(),student.getNplace(),student.getMajor(),student.getClasses(),student.getPhone());
		}
		// 返回结果
		return registerStatus;
	}

	/**
	 * 学生信息列表
	 * 
	 * @return
	 */
	public List<Student> doStudentList() {
		// 声明sql语句
		String select_sql = "select * from t_student";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql);
		// 声明学生列表对象
		List<Student> list = new ArrayList<>();
		try {
			// 获取查询结果
			while (res.next()) {
				list.add(new Student(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9)));
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return list;
	}

	/**
	 * 学生信息删除
	 * 
	 * @param student
	 * @return
	 */
	public boolean doStudentDelete(Integer id) {
		// 声明sql语句
		String delete_sql = "delete from t_student where id=?";
		// 存储状态
		boolean deleteStatus = false;
		try {
			// 开始删除
			deleteStatus = mhelper.doUpdate(delete_sql, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return deleteStatus;
	}

	/**
	 * 学生信息修改
	 * 
	 * @param student
	 * @return
	 */
	public boolean doStudentModify(Student student) {
		// 声明sql语句
		String update_sql = "update t_student set Name=?,Sex=?,Idcard=?,Nplace=?,Major=?,Classes=?,Phone=? where Id=?";
		// 存储状态
		boolean updateStatus = false;
		try {
			// 开始修改
			updateStatus = mhelper.doUpdate(update_sql,  student.getName(),student.getSex(),student.getIdcard(),student.getNplace(),student.getMajor(),student.getClasses(),student.getPhone(),student.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return updateStatus;
	}

	/**
	 * 学生信息获取
	 * 
	 * @param student
	 * @return
	 */
	public Student doStudentInfo(Integer id) {
		// 声明sql语句
		String select_sql = "select * from t_student where id=?";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, id);
		// 声明学生对象
		Student info = null;
		try {
			// 获取查询结果
			if (res.next()) {
				info = new Student(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9));
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return info;
	}
}
