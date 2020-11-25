package com.hms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.MajorDao;
import com.hms.model.Major;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class MajorServlet
 */
@WebServlet("/MajorServlet")
public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MajorDao mdao = new MajorDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String method = request.getParameter("method");
			switch (method) {
			case "doMajorAdd":
				// רҵ��Ϣ���
				doMajorAdd(request, response);
				break;
			case "doMajorList":
				// רҵ��Ϣ�б�
				doMajorList(request, response);
				break;
			case "doMajorDelete":
				// רҵ��Ϣɾ��
				doMajorDelete(request, response);
				break;
			case "doMajorModify":
				// רҵ��Ϣ�޸�
				doMajorModify(request, response);
				break;
			case "doMajorInfo":
				// רҵ��Ϣ��ȡ
				doMajorInfo(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.getWriter().print(false);
		}
	}

	/**
	 * רҵ��Ϣ���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doMajorAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Major major = new Major(request.getParameter("mid"),request.getParameter("name"),request.getParameter("people"),request.getParameter("phone"));
		response.getWriter().print(mdao.doMajorAdd(major));
	}
	
	/**
	 * רҵ��Ϣ�б�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doMajorList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Major> list=mdao.doMajorList();
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().print(json);
	}
	
	/**
	 * רҵ��Ϣɾ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doMajorDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print(mdao.doMajorDelete(Integer.parseInt(request.getParameter("id"))));
	}

	/**
	 * רҵ��Ϣ�޸�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doMajorModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Major major = new Major(Integer.parseInt(request.getParameter("id")),request.getParameter("mid"),request.getParameter("name"),request.getParameter("people"),request.getParameter("phone"));
		response.getWriter().print(mdao.doMajorModify(major));
	}

	/**
	 * רҵ��Ϣ��ȡ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doMajorInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Major major = mdao.doMajorInfo(Integer.parseInt(request.getParameter("id")));
		JSONObject json = new JSONObject();
		json.put("major", major);
		response.getWriter().print(json);
	}
}
