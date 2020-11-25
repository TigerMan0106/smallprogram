package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.Major;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class MajorDao {

	// 实例化数据库操作对象
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * 专业信息添加
	 * 
	 * @param major
	 * @return
	 */
	public boolean doMajorAdd(Major major) {
		// 声明sql语句
		String select_sql = "select Mid from t_major where Mid=?";
		String insert_sql = "insert into t_major(Mid,Name,People,Phone) values (?,?,?,?)";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, major.getMid());
		// 存储状态
		boolean majorExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// 专业已存在
				majorExisted = true;
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 判断是否需要添加
		if (!majorExisted) {
			// 专业信息不存在,继续添加
			registerStatus = mhelper.doUpdate(insert_sql, major.getMid(), major.getName(),major.getPeople(),major.getPhone());
		}
		// 返回结果
		return registerStatus;
	}

	/**
	 * 专业信息列表
	 * 
	 * @return
	 */
	public List<Major> doMajorList() {
		// 声明sql语句
		String select_sql = "select * from t_major";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql);
		// 声明专业列表对象
		List<Major> list = new ArrayList<>();
		try {
			// 获取查询结果
			while (res.next()) {
				list.add(new Major(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
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
	 * 专业信息删除
	 * 
	 * @param major
	 * @return
	 */
	public boolean doMajorDelete(Integer id) {
		// 声明sql语句
		String delete_sql = "delete from t_major where id=?";
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
	 * 专业信息修改
	 * 
	 * @param major
	 * @return
	 */
	public boolean doMajorModify(Major major) {
		// 声明sql语句
		String update_sql = "update t_major set Name=?,People=?,Phone=? where Id=?";
		// 存储状态
		boolean updateStatus = false;
		try {
			// 开始修改
			updateStatus = mhelper.doUpdate(update_sql, major.getName(),major.getPeople(),major.getPhone(),major.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return updateStatus;
	}

	/**
	 * 专业信息获取
	 * 
	 * @param major
	 * @return
	 */
	public Major doMajorInfo(Integer id) {
		// 声明sql语句
		String select_sql = "select * from t_major where id=?";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, id);
		// 声明专业对象
		Major info = null;
		try {
			// 获取查询结果
			if (res.next()) {
				info = new Major(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
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
