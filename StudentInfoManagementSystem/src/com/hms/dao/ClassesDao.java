package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.Classes;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class ClassesDao {

	// 实例化数据库操作对象
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * 班级信息添加
	 * 
	 * @param classes
	 * @return
	 */
	public boolean doClassesAdd(Classes classes) {
		// 声明sql语句
		String select_sql = "select Cid from t_classes where Cid=?";
		String insert_sql = "insert into t_classes(Cid,Name,People,Phone) values (?,?,?,?)";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, classes.getCid());
		// 存储状态
		boolean classesExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// 班级已存在
				classesExisted = true;
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 判断是否需要添加
		if (!classesExisted) {
			// 班级信息不存在,继续添加
			registerStatus = mhelper.doUpdate(insert_sql, classes.getCid(), classes.getName(),classes.getPeople(),classes.getPhone());
		}
		// 返回结果
		return registerStatus;
	}

	/**
	 * 班级信息列表
	 * 
	 * @return
	 */
	public List<Classes> doClassesList() {
		// 声明sql语句
		String select_sql = "select * from t_classes";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql);
		// 声明班级列表对象
		List<Classes> list = new ArrayList<>();
		try {
			// 获取查询结果
			while (res.next()) {
				list.add(new Classes(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
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
	 * 班级信息删除
	 * 
	 * @param classes
	 * @return
	 */
	public boolean doClassesDelete(Integer id) {
		// 声明sql语句
		String delete_sql = "delete from t_classes where id=?";
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
	 * 班级信息修改
	 * 
	 * @param classes
	 * @return
	 */
	public boolean doClassesModify(Classes classes) {
		// 声明sql语句
		String update_sql = "update t_classes set Name=?,People=?,Phone=? where Id=?";
		// 存储状态
		boolean updateStatus = false;
		try {
			// 开始修改
			updateStatus = mhelper.doUpdate(update_sql, classes.getName(),classes.getPeople(),classes.getPhone(),classes.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return updateStatus;
	}

	/**
	 * 班级信息获取
	 * 
	 * @param classes
	 * @return
	 */
	public Classes doClassesInfo(Integer id) {
		// 声明sql语句
		String select_sql = "select * from t_classes where id=?";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, id);
		// 声明班级对象
		Classes info = null;
		try {
			// 获取查询结果
			if (res.next()) {
				info = new Classes(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
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
