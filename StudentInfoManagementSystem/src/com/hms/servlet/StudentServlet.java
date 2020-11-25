package com.hms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.StudentDao;
import com.hms.model.Student;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDao mdao = new StudentDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String method = request.getParameter("method");
			switch (method) {
			case "doStudentAdd":
				// ѧ����Ϣ���
				doStudentAdd(request, response);
				break;
			case "doStudentList":
				// ѧ����Ϣ�б�
				doStudentList(request, response);
				break;
			case "doStudentDelete":
				// ѧ����Ϣɾ��
				doStudentDelete(request, response);
				break;
			case "doStudentModify":
				// ѧ����Ϣ�޸�
				doStudentModify(request, response);
				break;
			case "doStudentInfo":
				// ѧ����Ϣ��ȡ
				doStudentInfo(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.getWriter().print(false);
		}
	}

	/**
	 * ѧ����Ϣ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doStudentAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student(request.getParameter("sid"),request.getParameter("name"),request.getParameter("sex"),request.getParameter("idcard"),request.getParameter("nplace"),request.getParameter("major"),request.getParameter("classes"),request.getParameter("phone"));
		response.getWriter().print(mdao.doStudentAdd(student));
	}
	
	/**
	 * ѧ����Ϣ�б�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Student> list=mdao.doStudentList();
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().print(json);
	}
	
	/**
	 * ѧ����Ϣɾ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doStudentDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print(mdao.doStudentDelete(Integer.parseInt(request.getParameter("id"))));
	}

	/**
	 * ѧ����Ϣ�޸�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doStudentModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student student = new Student(Integer.parseInt(request.getParameter("id")),request.getParameter("sid"),request.getParameter("name"),request.getParameter("sex"),request.getParameter("idcard"),request.getParameter("nplace"),request.getParameter("major"),request.getParameter("classes"),request.getParameter("phone"));
		response.getWriter().print(mdao.doStudentModify(student));
	}

	/**
	 * ѧ����Ϣ��ȡ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doStudentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Student student = mdao.doStudentInfo(Integer.parseInt(request.getParameter("id")));
		JSONObject json = new JSONObject();
		json.put("student", student);
		response.getWriter().print(json);
	}
}
