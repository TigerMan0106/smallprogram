package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.User;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class UserDao {

	// ʵ�������ݿ��������
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * �����û���½
	 * 
	 * @param user
	 * @return
	 */
	public User doUserLogin(User user) {
		// ����sql���
		String select_sql = "select Username from t_user where Username=? and Password=?";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, user.getUsername(), user.getPassword());
		// �����û�����
		User lgUser = null;
		try {
			// �жϵ�½���
			if (res.next()) {
				lgUser = new User(res.getString(1), null);
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return lgUser;
	}

	/**
	 * �����û�ע��
	 * 
	 * @param user
	 * @return
	 */
	public boolean doUserRegister(User user) {
		// ����sql���
		String select_sql = "select Username from t_user where Username=?";
		String insert_sql = "insert into t_user(Username,Password) values (?,?)";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, user.getUsername());
		// �洢״̬
		boolean userExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// �û��Ѵ���
				userExisted = true;
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// �ж��Ƿ���Ҫע��
		if (!userExisted) {
			// �û���Ϣ������,����ע��
			registerStatus = mhelper.doUpdate(insert_sql, user.getUsername(), user.getPassword());
		}
		// ���ؽ��
		return registerStatus;
	}

	/**
	 * �û���Ϣ�б�
	 * 
	 * @return
	 */
	public List<User> doUserList() {
		// ����sql���
		String select_sql = "select * from t_user";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql);
		// �����û��б����
		List<User> list = new ArrayList<>();
		try {
			// ��ȡ��ѯ���
			while (res.next()) {
				list.add(new User(res.getInt(1), res.getString(2), res.getString(3)));
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return list;
	}

	/**
	 * �û���Ϣɾ��
	 * 
	 * @param user
	 * @return
	 */
	public boolean doUserDelete(Integer id) {
		// ����sql���
		String delete_sql = "delete from t_user where id=?";
		// �洢״̬
		boolean deleteStatus = false;
		try {
			// ��ʼɾ��
			deleteStatus = mhelper.doUpdate(delete_sql, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return deleteStatus;
	}

	/**
	 * 	�����޸��û�����
	 * @param user
	 * @return
	 */
	public boolean doUserModifyPwd(User user) {
		// ����sql���
		String update_sql = "update t_user set Password=? where username=?";
		// �洢״̬
		boolean updateStatus = false;
		try {
			// ��ʼ����
			updateStatus = mhelper.doUpdate(update_sql, user.getPassword(),user.getUsername());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return updateStatus;
	}

	/**
	 * �û���Ϣ�޸�
	 * 
	 * @param user
	 * @return
	 */
	public boolean doUserModify(User user) {
		// ����sql���
		String update_sql = "update t_user set Password=? where Username=?";
		// �洢״̬
		boolean updateStatus = false;
		try {
			// ��ʼ�޸�
			updateStatus = mhelper.doUpdate(update_sql, user.getPassword(),user.getUsername());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return updateStatus;
	}

	/**
	 * �û���Ϣ��ȡ
	 * 
	 * @param user
	 * @return
	 */
	public User doUserInfo(Integer id) {
		// ����sql���
		String select_sql = "select * from t_user where id=?";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, id);
		// �����û�����
		User info = null;
		try {
			// ��ȡ��ѯ���
			if (res.next()) {
				info = new User(res.getInt(1), res.getString(2), res.getString(3));
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return info;
	}
}
