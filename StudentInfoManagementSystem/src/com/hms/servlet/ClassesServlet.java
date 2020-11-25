package com.hms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.ClassesDao;
import com.hms.model.Classes;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ClassesServlet
 */
@WebServlet("/ClassesServlet")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassesDao mdao = new ClassesDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String method = request.getParameter("method");
			switch (method) {
			case "doClassesAdd":
				// �༶��Ϣ���
				doClassesAdd(request, response);
				break;
			case "doClassesList":
				// �༶��Ϣ�б�
				doClassesList(request, response);
				break;
			case "doClassesDelete":
				// �༶��Ϣɾ��
				doClassesDelete(request, response);
				break;
			case "doClassesModify":
				// �༶��Ϣ�޸�
				doClassesModify(request, response);
				break;
			case "doClassesInfo":
				// �༶��Ϣ��ȡ
				doClassesInfo(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.getWriter().print(false);
		}
	}

	/**
	 * �༶��Ϣ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doClassesAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Classes classes = new Classes(request.getParameter("cid"),request.getParameter("name"),request.getParameter("people"),request.getParameter("phone"));
		response.getWriter().print(mdao.doClassesAdd(classes));
	}
	
	/**
	 * �༶��Ϣ�б�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doClassesList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Classes> list=mdao.doClassesList();
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().print(json);
	}
	
	/**
	 * �༶��Ϣɾ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doClassesDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print(mdao.doClassesDelete(Integer.parseInt(request.getParameter("id"))));
	}

	/**
	 * �༶��Ϣ�޸�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doClassesModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Classes classes = new Classes(Integer.parseInt(request.getParameter("id")),request.getParameter("cid"),request.getParameter("name"),request.getParameter("people"),request.getParameter("phone"));
		response.getWriter().print(mdao.doClassesModify(classes));
	}

	/**
	 * �༶��Ϣ��ȡ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doClassesInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Classes classes = mdao.doClassesInfo(Integer.parseInt(request.getParameter("id")));
		JSONObject json = new JSONObject();
		json.put("classes", classes);
		response.getWriter().print(json);
	}
}
