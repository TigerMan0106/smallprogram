package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.User;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class UserDao {

	// 实例化数据库操作对象
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * 进行用户登陆
	 * 
	 * @param user
	 * @return
	 */
	public User doUserLogin(User user) {
		// 声明sql语句
		String select_sql = "select Username from t_user where Username=? and Password=?";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, user.getUsername(), user.getPassword());
		// 声明用户对象
		User lgUser = null;
		try {
			// 判断登陆结果
			if (res.next()) {
				lgUser = new User(res.getString(1), null);
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return lgUser;
	}

	/**
	 * 进行用户注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean doUserRegister(User user) {
		// 声明sql语句
		String select_sql = "select Username from t_user where Username=?";
		String insert_sql = "insert into t_user(Username,Password) values (?,?)";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, user.getUsername());
		// 存储状态
		boolean userExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// 用户已存在
				userExisted = true;
			}
			// 关闭ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 判断是否需要注册
		if (!userExisted) {
			// 用户信息不存在,继续注册
			registerStatus = mhelper.doUpdate(insert_sql, user.getUsername(), user.getPassword());
		}
		// 返回结果
		return registerStatus;
	}

	/**
	 * 用户信息列表
	 * 
	 * @return
	 */
	public List<User> doUserList() {
		// 声明sql语句
		String select_sql = "select * from t_user";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql);
		// 声明用户列表对象
		List<User> list = new ArrayList<>();
		try {
			// 获取查询结果
			while (res.next()) {
				list.add(new User(res.getInt(1), res.getString(2), res.getString(3)));
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
	 * 用户信息删除
	 * 
	 * @param user
	 * @return
	 */
	public boolean doUserDelete(Integer id) {
		// 声明sql语句
		String delete_sql = "delete from t_user where id=?";
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
	 * 	进行修改用户密码
	 * @param user
	 * @return
	 */
	public boolean doUserModifyPwd(User user) {
		// 声明sql语句
		String update_sql = "update t_user set Password=? where username=?";
		// 存储状态
		boolean updateStatus = false;
		try {
			// 开始更新
			updateStatus = mhelper.doUpdate(update_sql, user.getPassword(),user.getUsername());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return updateStatus;
	}

	/**
	 * 用户信息修改
	 * 
	 * @param user
	 * @return
	 */
	public boolean doUserModify(User user) {
		// 声明sql语句
		String update_sql = "update t_user set Password=? where Username=?";
		// 存储状态
		boolean updateStatus = false;
		try {
			// 开始修改
			updateStatus = mhelper.doUpdate(update_sql, user.getPassword(),user.getUsername());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 返回结果
		return updateStatus;
	}

	/**
	 * 用户信息获取
	 * 
	 * @param user
	 * @return
	 */
	public User doUserInfo(Integer id) {
		// 声明sql语句
		String select_sql = "select * from t_user where id=?";
		// 进行数据库查询
		ResultSet res = mhelper.doQuery(select_sql, id);
		// 声明用户对象
		User info = null;
		try {
			// 获取查询结果
			if (res.next()) {
				info = new User(res.getInt(1), res.getString(2), res.getString(3));
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
