package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import util.StringUtil;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/LoginUser" })
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	public LoginUserServlet() {
		this.dbController = new DBController();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String userName = request.getParameter("usernameLogin");
		String password = request.getParameter("passwordLogin");

		int loginResult = dbController.getUserLoginInfo(userName, password);
		
		if (loginResult == 1) {
		    HttpSession userSession = request.getSession();
		    userSession.setAttribute("userName", userName);
		    userSession.setMaxInactiveInterval(15 * 60);

		    Cookie userCookie = new Cookie("user", userName);
		    userCookie.setMaxAge(30 * 60);
		    response.addCookie(userCookie);

		    boolean isAdmin = dbController.isAdmin(userName);
		    if (isAdmin) {
		        response.sendRedirect(request.getContextPath() + StringUtil.URL_ADMINDASHBOARD);
		    } else {
		        response.sendRedirect(request.getContextPath() + StringUtil.PAGE_URL_HOME);
		    }
		} else if (loginResult == 0) {
		    request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNIN, StringUtil.MESSAGE_ERROR_LOGIN);
		    request.getRequestDispatcher(StringUtil.PAGE_URL_LOGIN).forward(request, response);
		} else if (loginResult == -1) {
		    request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNIN, StringUtil.MESSAGE_ERROR_CREATE_ACCOUNT);
		    request.getRequestDispatcher(StringUtil.PAGE_URL_LOGIN).forward(request, response);
		} else {
		    request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_SERVER);
		    request.getRequestDispatcher(StringUtil.PAGE_URL_LOGIN).forward(request, response);
		}
	}

}
