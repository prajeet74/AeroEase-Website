package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DBController;
import model.UserModel;
import util.StringUtil;
import util.ValidationUtil;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterUser" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBController dbController;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserServlet() {
		this.dbController = new DBController();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter(StringUtil.USERNAME);
		String firstName = request.getParameter(StringUtil.FIRST_NAME);
		String lastName = request.getParameter(StringUtil.LAST_NAME);
		String dobString = request.getParameter(StringUtil.DOB);
		LocalDate dob = LocalDate.parse(dobString);
		String phoneNumber = request.getParameter(StringUtil.PHONE_NUMBER);
		String password = request.getParameter(StringUtil.PASSWORD);
		String retypePassword = request.getParameter(StringUtil.RETYPE_PASSWORD);
		Part imagePart = request.getPart("image");

		if (!ValidationUtil.isAlphanumeric(userName)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_INVALID_USERNAME);
			request.setAttribute("goTo", "register");
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			
			return;
		}
		if (!ValidationUtil.isValidUsernameLength(userName)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_SHORT_USERNAME);
			request.setAttribute("goTo", "register");
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			return;
		}
		if (!ValidationUtil.isTextOnly(firstName)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_INVALID_FIRST_NAME);
			request.setAttribute("goTo", "register");
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			return;
		}
		if (!ValidationUtil.isTextOnly(lastName)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_INVALID_LAST_NAME);
			request.setAttribute("goTo", "register");
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			return;
		}
		if (!ValidationUtil.isValidPhoneNumber(phoneNumber)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_INVALID_PHONE_NUMBER);
			request.setAttribute("goTo", "register");
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			return;
		}
		/*
		 * if (!ValidationUtil.isValidPassword(password)) {
		 * request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP,
		 * StringUtil.MESSAGE_ERROR_PASSWORD);
		 * request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request,
		 * response); return; }
		 */
		if (!ValidationUtil.isAdult(dob)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_INVALID_BIRTHDAY);
			request.setAttribute("goTo", "register");
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			return;
		}

		UserModel userModel = new UserModel(userName, firstName, lastName, phoneNumber, dob, password, imagePart);

		int result = dbController.registerUser(userModel);
		System.out.println(result);
		if (password.equals(retypePassword)) {
			switch (result) {
			case 1 -> {
			
				String fileName = userModel.getImageUrlFromPath();

				if (!ValidationUtil.isImage(fileName)) {
					request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_INVALID_IMAGE_TYPE);
					request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
					return;
				}

				if (!fileName.isEmpty() && fileName != null) {

					String savePath = StringUtil.IMAGE_DIR_USERS;
					imagePart.write(savePath + fileName);
					

					response.sendRedirect(request.getContextPath() + StringUtil.PAGE_URL_REGISTER);
					return;
				}

	
				
			}
			case 0 -> {
				request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_REGISTER);
				request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			}
			case -1 -> {
				request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_SERVER);
				request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			}
			case -2 -> {
				request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_USERNAME);
				request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			}
			case -3 -> {
				request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_PHONE_NUMBER);
				request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			}
			default -> {
				request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_SERVER);
				request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
			}
			}
		} else {
			request.setAttribute(StringUtil.MESSAGE_ERROR_SIGNUP, StringUtil.MESSAGE_ERROR_PASSWORD_UNMATCHED);
			request.getRequestDispatcher(StringUtil.PAGE_URL_REGISTER).forward(request, response);
		}

	}

}
