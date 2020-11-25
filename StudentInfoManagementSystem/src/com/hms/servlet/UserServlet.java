package com.hms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hms.dao.UserDao;
import com.hms.model.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao udao = new UserDao();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			String method = request.getParameter("method");
			switch (method) {
			case "doUserLogin":
				// �û���½
				doUserLogin(request, response);
				break;
			case "doUserAdd":
			case "doUserRegister":
				// �û�ע��
				doUserRegister(request, response);
				break;
			case "doUserLogout":
				// �û�ע��
				doUserLogout(request, response);
				break;
			case "doUserModifyPwd":
				// �û������޸�
				doUserModifyPwd(request, response);
				break;
			case "doUserList":
				// �û���Ϣ�б�
				doUserList(request, response);
				break;
			case "doUserDelete":
				// �û���Ϣɾ��
				doUserDelete(request, response);
				break;
			case "doUserModify":
				// �û���Ϣ�޸�
				doUserModify(request, response);
				break;
			case "doUserInfo":
				// �û���Ϣ��ȡ
				doUserInfo(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.getWriter().print(false);
		}
	}

	/**
	 * �û���½
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doUserLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User lgUser = udao.doUserLogin(new User(request.getParameter("username"), request.getParameter("password")));
		if (null != lgUser) {
			request.getSession().setAttribute("lgUser", lgUser);
		}
		response.getWriter().print(null != lgUser);
	}

	/**
	 * �û�ע��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doUserRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(request.getParameter("username"),request.getParameter("password"));
		response.getWriter().print(udao.doUserRegister(user));
	}
	
	/**
	 * �û������޸�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doUserModifyPwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User lgUser = (User)request.getSession().getAttribute("lgUser");
		lgUser.setPassword(request.getParameter("password"));
		response.getWriter().print(udao.doUserModifyPwd(lgUser));
	}
	
	
	/**
	 * �����û�ע��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doUserLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().setAttribute("lgUser", null);
		response.getWriter().print(true);
	}

	/**
	 * �û���Ϣ�б�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doUserList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<User> list=udao.doUserList();
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().print(json);
	}
	
	/**
	 * �û���Ϣɾ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doUserDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print(udao.doUserDelete(Integer.parseInt(request.getParameter("id"))));
	}

	/**
	 * �û���Ϣ�޸�
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doUserModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User(request.getParameter("username"), request.getParameter("password"));
		response.getWriter().print(udao.doUserModify(user));
	}

	/**
	 * �û���Ϣ��ȡ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = udao.doUserInfo(Integer.parseInt(request.getParameter("id")));
		JSONObject json = new JSONObject();
		json.put("user", user);
		response.getWriter().print(json);
	}
}
