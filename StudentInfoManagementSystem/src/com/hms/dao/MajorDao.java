package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.Major;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class MajorDao {

	// ʵ�������ݿ��������
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * רҵ��Ϣ���
	 * 
	 * @param major
	 * @return
	 */
	public boolean doMajorAdd(Major major) {
		// ����sql���
		String select_sql = "select Mid from t_major where Mid=?";
		String insert_sql = "insert into t_major(Mid,Name,People,Phone) values (?,?,?,?)";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, major.getMid());
		// �洢״̬
		boolean majorExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// רҵ�Ѵ���
				majorExisted = true;
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// �ж��Ƿ���Ҫ���
		if (!majorExisted) {
			// רҵ��Ϣ������,�������
			registerStatus = mhelper.doUpdate(insert_sql, major.getMid(), major.getName(),major.getPeople(),major.getPhone());
		}
		// ���ؽ��
		return registerStatus;
	}

	/**
	 * רҵ��Ϣ�б�
	 * 
	 * @return
	 */
	public List<Major> doMajorList() {
		// ����sql���
		String select_sql = "select * from t_major";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql);
		// ����רҵ�б����
		List<Major> list = new ArrayList<>();
		try {
			// ��ȡ��ѯ���
			while (res.next()) {
				list.add(new Major(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
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
	 * רҵ��Ϣɾ��
	 * 
	 * @param major
	 * @return
	 */
	public boolean doMajorDelete(Integer id) {
		// ����sql���
		String delete_sql = "delete from t_major where id=?";
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
	 * רҵ��Ϣ�޸�
	 * 
	 * @param major
	 * @return
	 */
	public boolean doMajorModify(Major major) {
		// ����sql���
		String update_sql = "update t_major set Name=?,People=?,Phone=? where Id=?";
		// �洢״̬
		boolean updateStatus = false;
		try {
			// ��ʼ�޸�
			updateStatus = mhelper.doUpdate(update_sql, major.getName(),major.getPeople(),major.getPhone(),major.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return updateStatus;
	}

	/**
	 * רҵ��Ϣ��ȡ
	 * 
	 * @param major
	 * @return
	 */
	public Major doMajorInfo(Integer id) {
		// ����sql���
		String select_sql = "select * from t_major where id=?";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, id);
		// ����רҵ����
		Major info = null;
		try {
			// ��ȡ��ѯ���
			if (res.next()) {
				info = new Major(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
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
