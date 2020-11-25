package com.hms.dao;

import java.sql.ResultSet;

import java.util.List;

import com.hms.model.Student;
import com.hms.utils.MySQLHelper;

import java.util.ArrayList;

public class StudentDao {

	// ʵ�������ݿ��������
	private MySQLHelper mhelper = new MySQLHelper();

	/**
	 * ѧ����Ϣ���
	 * 
	 * @param student
	 * @return
	 */
	public boolean doStudentAdd(Student student) {
		// ����sql���
		String select_sql = "select Sid from t_student where Sid=?";
		String insert_sql = "insert into t_student(Sid,Name,Sex,Idcard,Nplace,Major,Classes,Phone) values (?,?,?,?,?,?,?,?)";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, student.getSid());
		// �洢״̬
		boolean studentExisted = false;
		boolean registerStatus = false;
		try {
			if (res.next()) {
				// ѧ���Ѵ���
				studentExisted = true;
			}
			// �ر�ResultSet
			res.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// �ж��Ƿ���Ҫ���
		if (!studentExisted) {
			// ѧ����Ϣ������,�������
			registerStatus = mhelper.doUpdate(insert_sql, student.getSid(), student.getName(),student.getSex(),student.getIdcard(),student.getNplace(),student.getMajor(),student.getClasses(),student.getPhone());
		}
		// ���ؽ��
		return registerStatus;
	}

	/**
	 * ѧ����Ϣ�б�
	 * 
	 * @return
	 */
	public List<Student> doStudentList() {
		// ����sql���
		String select_sql = "select * from t_student";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql);
		// ����ѧ���б����
		List<Student> list = new ArrayList<>();
		try {
			// ��ȡ��ѯ���
			while (res.next()) {
				list.add(new Student(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9)));
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
	 * ѧ����Ϣɾ��
	 * 
	 * @param student
	 * @return
	 */
	public boolean doStudentDelete(Integer id) {
		// ����sql���
		String delete_sql = "delete from t_student where id=?";
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
	 * ѧ����Ϣ�޸�
	 * 
	 * @param student
	 * @return
	 */
	public boolean doStudentModify(Student student) {
		// ����sql���
		String update_sql = "update t_student set Name=?,Sex=?,Idcard=?,Nplace=?,Major=?,Classes=?,Phone=? where Id=?";
		// �洢״̬
		boolean updateStatus = false;
		try {
			// ��ʼ�޸�
			updateStatus = mhelper.doUpdate(update_sql,  student.getName(),student.getSex(),student.getIdcard(),student.getNplace(),student.getMajor(),student.getClasses(),student.getPhone(),student.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ؽ��
		return updateStatus;
	}

	/**
	 * ѧ����Ϣ��ȡ
	 * 
	 * @param student
	 * @return
	 */
	public Student doStudentInfo(Integer id) {
		// ����sql���
		String select_sql = "select * from t_student where id=?";
		// �������ݿ��ѯ
		ResultSet res = mhelper.doQuery(select_sql, id);
		// ����ѧ������
		Student info = null;
		try {
			// ��ȡ��ѯ���
			if (res.next()) {
				info = new Student(res.getInt(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9));
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
