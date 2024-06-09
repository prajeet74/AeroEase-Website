package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DBController;
import model.UserModel;
import util.StringUtil;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Profile" })
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DBController dbContoller = new DBController();
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userName") != null) {
			String username = (String) session.getAttribute("userName");
			
			UserModel userInfo = dbContoller.getUserDetails(username);

			request.setAttribute("userModel", userInfo);
			request.getRequestDispatcher(StringUtil.URL_USER_PROFILE).forward(request, response);
			return;
			
			  } else { response.sendRedirect(request.getContextPath() +
			  StringUtil.PAGE_URL_REGISTER); return;
			 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updateId = request.getParameter(StringUtil.UPDATE_ID);
		System.out.println(updateId);

		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updatedPhoneNumber = request.getParameter(StringUtil.PHONE_NUMBER);
	
		String updatedFirstName = request.getParameter(StringUtil.FIRST_NAME);
		String updatedLastName = request.getParameter(StringUtil.LAST_NAME);
		LocalDate updatedDob = LocalDate.parse(request.getParameter(StringUtil.DATE));
		String updatedusername = request.getParameter(StringUtil.USERNAME);

		UserModel updatedUser = new UserModel();
		updatedUser.setPhoneNumber(updatedPhoneNumber);
		updatedUser.setFirstName(updatedFirstName);
		updatedUser.setLastName(updatedLastName);
		updatedUser.setDob(updatedDob);
		updatedUser.setUserName(updatedLastName);
		updatedUser.setUserName(updatedusername);
		
		
		DBController dbController = new DBController();
		if (dbController.updateUserProfile(updatedUser) == 1) {
			request.setAttribute(StringUtil.MESSAGE_SUCCESS, StringUtil.MESSAGE_SUCCESS_UPDATE);
		} else {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_USER_UPDATE);
		}
		response.sendRedirect(request.getContextPath() + StringUtil.PAGE_URL_HOME);
		return;
	}

}
