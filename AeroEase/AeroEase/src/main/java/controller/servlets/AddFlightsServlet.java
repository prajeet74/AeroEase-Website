package controller.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.FlightModel;
import model.UserModel;
import util.StringUtil;
import util.ValidationUtil;

/**
 * Servlet implementation class AddFlightsServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AddFlights" })
public class AddFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flightID = request.getParameter(StringUtil.FLIGHT_ID);

		String aircraft = request.getParameter(StringUtil.AIRCRAFT);

		String price = request.getParameter(StringUtil.PRICE);

		String DATE = request.getParameter(StringUtil.DATE);
		LocalDate date = LocalDate.parse(DATE);

		String departureTimeString = request.getParameter(StringUtil.DEPARTURE_TIME);

		String arrivalTimeString = request.getParameter(StringUtil.ARRIVAL_TIME);

		String origin = request.getParameter(StringUtil.ORIGIN);

		String destination = request.getParameter(StringUtil.DESTINATION);

		String seatsAvailable = request.getParameter(StringUtil.SEATS_AVAIBALE);

		if (!ValidationUtil.isNumbersOnly(flightID)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_INVALID_FLIGHTID_FORMAT);
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);
			return;
		}

		if (!ValidationUtil.isNumbersOnly(price)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_INVALID_PRICE);
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);
			return;
		}
		if (!ValidationUtil.areDifferentSelections(origin, destination)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_ORIGIN_DESTINATION);
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);
			return;
		}
		if (!ValidationUtil.isNumbersOnly(seatsAvailable)) {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_INVALID_AVAILABLE_SEAT);
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);
			return;
		}
		/*
		 * if (!ValidationUtil.validateDate(DATE)) {
		 * request.setAttribute(StringUtil.MESSAGE_ERROR,
		 * StringUtil.MESSAGE_ERROR_INVALID_DATE);
		 * request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request,
		 * response); return; }
		 */

		FlightModel flightModel = new FlightModel(flightID, aircraft, price, date, departureTimeString,
				arrivalTimeString, origin, destination, seatsAvailable);

		DBController dbController = new DBController();
		int result = dbController.AddFlights(flightModel);

		if (result == 1) {
			response.sendRedirect(request.getContextPath() + StringUtil.URL_ADMINDASHBOARD);
		} else if (result == 0) {
		
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);
		} else if (result == -2) {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_FLIGHT);
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);

		} else {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_SERVER);
			request.getRequestDispatcher(StringUtil.URL_FLIGHT_ADD).forward(request, response);
		}
	}

}
