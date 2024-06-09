package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.FlightModel;
import model.UserModel;
import util.StringUtil;

/**
 * Servlet implementation class AdminDashboardServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AdminDashboard" })
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DBController dbController = new DBController();
		
		ArrayList<UserModel> user = dbController.getUserData();
		request.setAttribute(StringUtil.USER_LIST, user);

		ArrayList<FlightModel> flights = dbController.getFlightData();
		request.setAttribute(StringUtil.FLIGHT_LIST, flights);

		request.getRequestDispatcher(StringUtil.URL_ADMINDASHBOARD).forward(request,response);
		return;
		
	}

}
