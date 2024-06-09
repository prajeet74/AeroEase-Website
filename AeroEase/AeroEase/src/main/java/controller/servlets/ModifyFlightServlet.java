package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DBController;
import model.FlightModel;
import util.StringUtil;

/**
 * Servlet implementation class ModifyUsersServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { StringUtil.SERVLET_URL_MODIFY_FLIGHTS })
public class ModifyFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBController dbController = new DBController();
		String updateID = request.getParameter(StringUtil.UPDATE_ID);
		
		FlightModel flightDetail = dbController.getFlightInfoByID(Integer.parseInt(updateID));
		if (flightDetail != null) {
		   
		    
		} else {
		    
		}
		request.setAttribute("flight", flightDetail);
		request.getRequestDispatcher(StringUtil.URL_UPDATE_FORM).forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String updateId = request.getParameter(StringUtil.UPDATE_ID);
		String deleteId = request.getParameter(StringUtil.DELETE_ID);
		

		if (updateId != null && !updateId.isEmpty()) {
			doPut(request, response);
		}

		if (deleteId != null && !deleteId.isEmpty()) {
			doDelete(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String updatedflightID = request.getParameter(StringUtil.FLIGHT_ID);
		String updatedAircraft = request.getParameter(StringUtil.AIRCRAFT);
		
		String updatedOrigin = request.getParameter(StringUtil.ORIGIN);
		String updatedDestination = request.getParameter(StringUtil.DESTINATION);
		LocalDate updatedDate = LocalDate.parse(request.getParameter(StringUtil.DATE));
		String updatedPrice = request.getParameter(StringUtil.PRICE);
		String updatedDepartureTime = request.getParameter(StringUtil.DEPARTURE_TIME);
		String updatedArrivalTime = request.getParameter(StringUtil.ARRIVAL_TIME);
		String updatedAvailableSeat = request.getParameter(StringUtil.SEATS_AVAIBALE);

		FlightModel updatedFlight = new FlightModel();
		updatedFlight.setFlightID(updatedflightID);
		updatedFlight.setAircraft(updatedAircraft);
		updatedFlight.setOrigin(updatedOrigin);
		updatedFlight.setDestination(updatedDestination);
		updatedFlight.setDate(updatedDate);
		updatedFlight.setPrice(updatedPrice);
		updatedFlight.setDepartureTime(updatedDepartureTime);
		updatedFlight.setArrivalTime(updatedArrivalTime);
		updatedFlight.setAvailableSeat(updatedAvailableSeat);

		DBController dbController = new DBController();
		if (dbController.updateFlight(updatedFlight) == 1) {
			//request.setAttribute(StringUtil.MESSAGE_SUCCESS, StringUtil.MESSAGE_SUCCESS_UPDATE);
		} else {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_UPDATE);
		}
		response.sendRedirect(request.getContextPath() + StringUtil.URL_ADMINDASHBOARD);
		return;
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBController dbController = new DBController();

		System.out.println("delete triggered");
		
		if (dbController.deleteFlightInfo(Integer.parseInt(request.getParameter(StringUtil.DELETE_ID))) == 1) {
			request.setAttribute(StringUtil.MESSAGE_SUCCESS, StringUtil.MESSAGE_SUCCESS_DELETE);
			response.sendRedirect(request.getContextPath() + StringUtil.URL_ADMINDASHBOARD);
			return;
		} else {
			request.setAttribute(StringUtil.MESSAGE_ERROR, StringUtil.MESSAGE_ERROR_DELETE);
			response.sendRedirect(request.getContextPath() + StringUtil.URL_ADMINDASHBOARD);
			return;
		}
	}

}
