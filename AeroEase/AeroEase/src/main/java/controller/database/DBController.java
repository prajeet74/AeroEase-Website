package controller.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import model.FlightModel;
import model.PasswordEncryptionWithAes;
import model.UserModel;
import util.StringUtil;


public class DBController {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(StringUtil.DRIVER_NAME);
		return DriverManager.getConnection(StringUtil.LOCALHOST_URL, StringUtil.LOCALHOST_USERNAME,
				StringUtil.LOCALHOST_PASSWORD);
	}

	public int registerUser(UserModel user) {
		try { 
				  { PreparedStatement checkUserNameSt =
				  getConnection().prepareStatement(StringUtil.QUERY_GET_USERNAME);
				  checkUserNameSt.setString(1, user.getUserName()); ResultSet checkUserNameRs =
				  checkUserNameSt.executeQuery(); checkUserNameRs.next(); if
				  (checkUserNameRs.getInt(1) > 0) { return -2; }
				  
				  PreparedStatement checkPhoneSt =
				  getConnection().prepareStatement(StringUtil.QUERY_GET_PHONE);
				  checkPhoneSt.setString(1, user.getPhoneNumber()); ResultSet checkPhoneRs =
				  checkPhoneSt.executeQuery(); checkPhoneRs.next(); if (checkPhoneRs.getInt(1)
				  > 0) { return -3; } 

			PreparedStatement stmt = getConnection().prepareStatement(StringUtil.QUERY_REGISTER_USER);

			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, PasswordEncryptionWithAes.encrypt(user.getUserName(), user.getPassword()));
			stmt.setString(5, user.getPhoneNumber());
			stmt.setDate(6, Date.valueOf(user.getDob()));
			stmt.setString(7, user.getImageUrlFromPath());

			// Statement Run
			int result = stmt.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				return 1;
			} else {
				return 0;
			}
		}}
				  
		 catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQlException");
			return -1;
		}
	}

	public int getUserLoginInfo(String userName, String password) {
		try {
			PreparedStatement st = getConnection().prepareStatement(StringUtil.QUERY_LOGIN_USER_CHECK);
			st.setString(1, userName);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				// User name and password match in the database
				String userDb = result.getString(StringUtil.USERNAME);
				String passwordDb = result.getString(StringUtil.PASSWORD);

				String decryptedPwd = PasswordEncryptionWithAes.decrypt(passwordDb, userDb);

				System.out.println(decryptedPwd);
				if (decryptedPwd != null && userDb.equals(userName) && decryptedPwd.equals(password))
					return 1;
				else
					return 0;
			} else {
				return -1;
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -2;
		}
	}

	public int AddFlights(FlightModel flight) {
		try {
			
			  { PreparedStatement checkUserNameSt =
					  getConnection().prepareStatement(StringUtil.QUERY_GET_FLIGHTID );
					  checkUserNameSt.setString(1, flight.getFlightID()); ResultSet checkFlightIDRs =
					  checkUserNameSt.executeQuery(); checkFlightIDRs.next(); if
					  (checkFlightIDRs.getInt(1) > 0) { return -2; }

			PreparedStatement stmt = getConnection().prepareStatement(StringUtil.QUERY_ADD_FLIGHT);

			stmt.setString(1, flight.getFlightID());
			stmt.setDate(2, Date.valueOf(flight.getDate()));
			stmt.setString(3, flight.getOrigin());
			stmt.setString(4, flight.getDestination());
			stmt.setString(5, flight.getDepartureTime());
			stmt.setString(6, flight.getArrivalTime());
			stmt.setString(7, flight.getAircraft());
			stmt.setString(8, flight.getAvailableSeat());
			stmt.setString(9, flight.getPrice());

	

			// Statement Run
			int result = stmt.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				return 1;
			} else {
				return 0;
			}}
			} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.out.println("SQlException");
			return -1;
		}
	}

	public int deleteFlightInfo(int flightID) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtil.QUERY_DELETE_USER);
			st.setInt(1, flightID);
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public int updateFlight(FlightModel updatedFlightModel) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtil.QUERY_UPDATE_FLIGHT);

			st.setDate(1, Date.valueOf(updatedFlightModel.getDate()));
			st.setString(2, updatedFlightModel.getOrigin());
			st.setString(3, updatedFlightModel.getDestination());
			st.setString(4, updatedFlightModel.getDepartureTime());
			st.setString(5, updatedFlightModel.getArrivalTime());
			st.setString(6, updatedFlightModel.getAircraft());
			st.setString(7, updatedFlightModel.getAvailableSeat());
			st.setString(8, updatedFlightModel.getPrice());
			st.setString(9, updatedFlightModel.getFlightID());
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public FlightModel getFlightInfoByID(int flightID) {

		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtil.QUERY_FLIGHT_INFO);
			st.setInt(1, flightID);
			ResultSet rs = st.executeQuery();
			FlightModel flightInfo = new FlightModel();

			while (rs.next()) {
				flightInfo.setFlightID(rs.getString(StringUtil.FLIGHT_ID));
				flightInfo.setAircraft(rs.getString(StringUtil.AIRCRAFT));
				flightInfo.setPrice(rs.getString(StringUtil.PRICE));
				flightInfo.setDate(rs.getDate(StringUtil.DATE).toLocalDate());
				flightInfo.setDepartureTime(rs.getString(StringUtil.DEPARTURE_TIME));
				flightInfo.setArrivalTime(rs.getString(StringUtil.ARRIVAL_TIME));
				flightInfo.setOrigin(rs.getString(StringUtil.ORIGIN));
				flightInfo.setDestination(rs.getString(StringUtil.DESTINATION));
				flightInfo.setAvailableSeat(rs.getString(StringUtil.SEATS_AVAIBALE));

			}
			return flightInfo;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;

		}
	}



	public UserModel getUserDetails(String username) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtil.QUERY_LOGIN_USER_CHECK);
			st.setString(1, username);
			ResultSet result = st.executeQuery();
			UserModel userInfo = new UserModel();
			while (result.next()) {

				userInfo.setUserName(result.getString(StringUtil.USERNAME));
				userInfo.setPhoneNumber(result.getString(StringUtil.PHONE_NUMBER));
				userInfo.setFirstName(result.getString(StringUtil.FIRST_NAME));
				userInfo.setLastName(result.getString(StringUtil.LAST_NAME));
				userInfo.setDob(result.getDate(StringUtil.DOB).toLocalDate());
				userInfo.setImageUrlFromPath(result.getString(StringUtil.IMAGE));
			}
			return userInfo;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;

		}
	}

	public ArrayList<UserModel> getUserData() {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtil.QUERY_GET_ALL_USER_INFO);
			ResultSet result = stmt.executeQuery();

			ArrayList<UserModel> users = new ArrayList<UserModel>();

			while (result.next()) {
				UserModel user = new UserModel();
				user.setUserName(result.getString(StringUtil.USERNAME));
				user.setPhoneNumber(result.getString(StringUtil.PHONE_NUMBER));
				user.setFirstName(result.getString(StringUtil.FIRST_NAME));
				user.setLastName(result.getString(StringUtil.LAST_NAME));
				user.setDob(result.getDate(StringUtil.DOB).toLocalDate());
				user.setImageUrlFromPath(result.getString(StringUtil.IMAGE));
				users.add(user);

			}
			return users;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public ArrayList<FlightModel> getFlightData() {
		try (Connection con = getConnection()) {
		
			
			PreparedStatement st = con.prepareStatement(StringUtil.QUERY_GET_ALL_FLIGHT_INFO);
			ResultSet rs = st.executeQuery();
			ArrayList<FlightModel> flightArray = new ArrayList<FlightModel>();

			while (rs.next()) {
				FlightModel flight = new FlightModel();

				flight.setFlightID(rs.getString(StringUtil.FLIGHT_ID));
				flight.setAircraft(rs.getString(StringUtil.AIRCRAFT));
				flight.setPrice(rs.getString(StringUtil.PRICE));
				flight.setDate(rs.getDate(StringUtil.DATE).toLocalDate());
				flight.setDepartureTime(rs.getString(StringUtil.DEPARTURE_TIME));
				flight.setArrivalTime(rs.getString(StringUtil.ARRIVAL_TIME));
				flight.setOrigin(rs.getString(StringUtil.ORIGIN));
				flight.setDestination(rs.getString(StringUtil.DESTINATION));
				flight.setAvailableSeat(rs.getString(StringUtil.SEATS_AVAIBALE));

				flightArray.add(flight);

			}
			return flightArray;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;

		}
	}



	public int updateUserProfile(UserModel updatedUserProfile) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtil.QUERY_UPDATE_PROFILE);

			st.setString(1, updatedUserProfile.getFirstName());
			st.setString(2, updatedUserProfile.getLastName());
			st.setString(3, updatedUserProfile.getPhoneNumber());
			st.setDate(4, Date.valueOf(updatedUserProfile.getDob()));
			//st.setString(5, updatedUserProfile.getImageUrlFromPath());
			st.setString(5, updatedUserProfile.getUserName());
			return st.executeUpdate();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1;
		}
	}
	
	
	public  boolean isAdmin(String username) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(StringUtil.QUERY_ROLE);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String role = rs.getString("role");
				System.out.println(role);
				return  role != null && role.equals("admin");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
