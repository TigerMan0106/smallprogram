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
				// 用户登陆
				doUserLogin(request, response);
				break;
			case "doUserAdd":
			case "doUserRegister":
				// 用户注册
				doUserRegister(request, response);
				break;
			case "doUserLogout":
				// 用户注销
				doUserLogout(request, response);
				break;
			case "doUserModifyPwd":
				// 用户密码修改
				doUserModifyPwd(request, response);
				break;
			case "doUserList":
				// 用户信息列表
				doUserList(request, response);
				break;
			case "doUserDelete":
				// 用户信息删除
				doUserDelete(request, response);
				break;
			case "doUserModify":
				// 用户信息修改
				doUserModify(request, response);
				break;
			case "doUserInfo":
				// 用户信息获取
				doUserInfo(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			response.getWriter().print(false);
		}
	}

	/**
	 * 用户登陆
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
	 * 用户注册
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
	 * 用户密码修改
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
	 * 进行用户注销
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
	 * 用户信息列表
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
	 * 用户信息删除
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doUserDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().print(udao.doUserDelete(Integer.parseInt(request.getParameter("id"))));
	}

	/**
	 * 用户信息修改
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
	 * 用户信息获取
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
