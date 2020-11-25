package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.Classes;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class ClassesDao {

	// ʵ�������ݿ��������
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * �༶��Ϣ���
	 * 
	 * @param classes
	 * @return
	 */
	public boolean doClassesAdd(Classes classes) {
		// ����sql���
		String select_sql = "select Cid from t_classes where Cid=?";
		String insert_sql = "insert into t_classes(Cid,Name,People,Phone) values (?,?,?,?)";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, classes.getCid());
		// �洢״̬
		boolean classesExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// �༶�Ѵ���
				classesExisted = true;
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// �ж��Ƿ���Ҫ���
		if (!classesExisted) {
			// �༶��Ϣ������,�������
			registerStatus = mhelper.doUpdate(insert_sql, classes.getCid(), classes.getName(),classes.getPeople(),classes.getPhone());
		}
		// ���ؽ��
		return registerStatus;
	}

	/**
	 * �༶��Ϣ�б�
	 * 
	 * @return
	 */
	public List<Classes> doClassesList() {
		// ����sql���
		String select_sql = "select * from t_classes";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql);
		// �����༶�б����
		List<Classes> list = new ArrayList<>();
		try {
			// ��ȡ��ѯ���
			while (res.next()) {
				list.add(new Classes(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
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
	 * �༶��Ϣɾ��
	 * 
	 * @param classes
	 * @return
	 */
	public boolean doClassesDelete(Integer id) {
		// ����sql���
		String delete_sql = "delete from t_classes where id=?";
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
	 * �༶��Ϣ�޸�
	 * 
	 * @param classes
	 * @return
	 */
	public boolean doClassesModify(Classes classes) {
		// ����sql���
		String update_sql = "update t_classes set Name=?,People=?,Phone=? where Id=?";
		// �洢״̬
		boolean updateStatus = false;
		try {
			// ��ʼ�޸�
			updateStatus = mhelper.doUpdate(update_sql, classes.getName(),classes.getPeople(),classes.getPhone(),classes.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return updateStatus;
	}

	/**
	 * �༶��Ϣ��ȡ
	 * 
	 * @param classes
	 * @return
	 */
	public Classes doClassesInfo(Integer id) {
		// ����sql���
		String select_sql = "select * from t_classes where id=?";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, id);
		// �����༶����
		Classes info = null;
		try {
			// ��ȡ��ѯ���
			if (res.next()) {
				info = new Classes(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
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
