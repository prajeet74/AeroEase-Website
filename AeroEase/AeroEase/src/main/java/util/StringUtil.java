package util;

public class StringUtil {

	// Start: DB Connection
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/aeroease";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	// End: DB Connection

	// Start: Queries
	public static final String QUERY_REGISTER_USER = "INSERT INTO user ("
			+ "userName, firstName, lastName,  password, phoneNumber, dob ,image) "
			+ "VALUES (?, ?, ?, ?, ?,?,?)";
	public static final String QUERY_ADD_FLIGHT = "INSERT INTO flight ("
			+ "flightID, date, originAirport, destinationAirport, departureTime, arrivalTime, aircraftName, availableSeat, ticketPrice) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";

	// Start: Parameter names
	public static final String USERNAME = "userName";
	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String DOB = "dob";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String PASSWORD = "password";
	public static final String RETYPE_PASSWORD = "retypePassword";
	public static final String IMAGE = "image";
	// End: Parameter names

	// Start: Parameter names
	public static final String FLIGHT_ID = "flightID";
	public static final String AIRCRAFT = "aircraftName";
	public static final String PRICE = "ticketPrice";
	public static final String DATE = "date";
	public static final String DEPARTURE_TIME = "departureTime";
	public static final String ARRIVAL_TIME = "arrivalTime";
	public static final String ORIGIN = "originAirport";
	public static final String DESTINATION = "destinationAirport";
	public static final String SEATS_AVAIBALE = "availableSeat";
	// End: Parameter names
	// Start: parameter name for images

	public static final String IMAGE_ROOT_PATH = "Eclipse\\AeroEase\\AeroEase (2)\\AeroEase\\src\\main\\webapp\\resources\\images\\";
	public static final String IMAGE_DIR_USERS = "C:/" + IMAGE_ROOT_PATH + "users\\";

	// Start: Parameter names for query
	public static final String QUERY_LOGIN_USER_CHECK = "SELECT * FROM user WHERE userName = ?";
	public static final String QUERY_GET_ALL_USER_INFO = "SELECT * FROM user";
	public static final String QUERY_GET_ALL_FLIGHT_INFO = "SELECT * FROM flight";
	public static final String QUERY_GET_USERNAME = "SELECT COUNT(*) FROM user WHERE userName = ?";
	
	public static final String QUERY_GET_PHONE = "SELECT COUNT(*) FROM user WHERE phoneNumber = ?";
	public static final String QUERY_GET_FLIGHTID = "SELECT COUNT(*) FROM flight WHERE flightID = ?";
	public static final String QUERY_DELETE_USER = "DELETE FROM flight WHERE flightID = ?";
	public static final String QUERY_UPDATE_FLIGHT = "UPDATE flight SET date=?,originAirport=?,destinationAirport=?, departureTime=?, arrivalTime=?, aircraftName=?, availableSeat=?, ticketPrice=? WHERE flightID=?";
	public static final String QUERY_UPDATE_PROFILE = "UPDATE user SET firstName=?, lastName=?, phoneNumber=?, dob=?  WHERE userName=?";
	public static final String QUERY_FLIGHT_INFO = "SELECT * FROM FLIGHT WHERE flightID=?";
	public static final String QUERY_ROLE = "SELECT role FROM user WHERE userName=?";
	// Start: Validation Messages
	// Register Page Messages
	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
	public static final String MESSAGE_ERROR_LONG_NAME = "Name is too long. Maximum length allowed is 30 characters.";
	public static final String MESSAGE_ERROR_SHORT_USERNAME = "Username is too short. Minimum length is 6 characters.";
	public static final String MESSAGE_ERROR_INVALID_FIRST_NAME = "Invalid format for first name. Enter alphabets only.";
	public static final String MESSAGE_ERROR_INVALID_USERNAME = "Invalid username. Eenter alphabets and numbers only.";
	public static final String MESSAGE_ERROR_INVALID_LAST_NAME = "Invalid format for last name. Enter alphabets only.";
	public static final String MESSAGE_ERROR_INVALID_USER_NAME = "Invalid format for username. Enter alphabets only.";
	public static final String MESSAGE_ERROR_INVALID_PHONE_NUMBER = "Invalid phone number.";
	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
	public static final String MESSAGE_ERROR_PASSWORD = "Password invalid.";
	public static final String MESSAGE_ERROR_INVALID_BIRTHDAY = "Please confirm that you are 18 years old or older.";
	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";
	public static final String MESSAGE_ERROR_INVALID_IMAGE_TYPE = "Please make sure to upload picture in supported format .";

	// Start: Validation Messages
	// AddFlight Page Messages
	public static final String MESSAGE_ERROR_INVALID_FLIGHTID_FORMAT = "Invalid FlightID format.";
	public static final String MESSAGE_ERROR_INVALID_FLIGHT_NAME ="Invalid flight name. Please enter alphabets and numbers only.";
	public static final String MESSAGE_ERROR_INVALID_PRICE ="Invalid price format or negative value.";
	public static final String MESSAGE_ERROR_ORIGIN_DESTINATION ="Origin and Destination cannot be same.";
	public static final String MESSAGE_ERROR_INVALID_AVAILABLE_SEAT = "Invalid seat format or negatve value.";
	public static final String MESSAGE_ERROR_INVALID_DATE= "Date is not valid. Don't enter past date!";
	public static final String MESSAGE_ERROR_FLIGHT = "FlightID  already exist.";
	
	
	
	// Login Page Messages
	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";

	// Other Messages
	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the flight!";
	public static final String MESSAGE_SUCCESS_SIGNIN = "successMessageSignin";
	public static final String MESSAGE_SUCCESS_SIGNUP = "successMessageSignup";
	public static final String MESSAGE_ERROR_SIGNIN = "errorMessageSignin";
	public static final String MESSAGE_ERROR_SIGNUP = "errorMessageSignup";
	public static final String MESSAGE_SUCCESS = "successMessage";
	public static final String MESSAGE_ERROR = "errorMessage";
	public static final String MESSAGE_SUCCESS_UPDATE = "Successfully Updated!";
	public static final String MESSAGE_ERROR_UPDATE = "Cannot update the flight!";
	public static final String MESSAGE_ERROR_USER_UPDATE = "Cannot update the user!";
	// End: Validation Messages

	// Start: JSP Route
	public static final String PAGE_URL_LOGIN = "/pages/register.jsp";
	public static final String PAGE_URL_REGISTER = "/pages/register.jsp";

	public static final String PAGE_URL_HOME = "/pages/home.jsp";
	public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
	public static final String PAGE_URL_HEADER = "pages/header.jsp";
	public static final String URL_LOGIN = "/login.jsp";
	public static final String URL_ADMINDASHBOARD = "/pages/adminDashboard.jsp";
	public static final String URL_FLIGHT_UPDATE = "/pages/updateFligts.jsp";
	public static final String URL_FLIGHT_ADD = "/pages/addFlight.jsp";
	public static final String URL_USER_PROFILE = "/pages/profilePage.jsp";
	public static final String URL_UPDATE_FORM = "/pages/updateFlight.jsp";
	// End: JSP Route

	// Start: Servlet Route
	public static final String SERVLET_URL_LOGIN = "/login";
	public static final String SERVLET_URL_REGISTER = "/registerstudent";
	public static final String SERVLET_URL_LOGOUT = "/Logout";
	public static final String SERVLET_URL_PROFILE = "/Profile";
	public static final String SERVLET_URL_MODIFY_FLIGHTS = "/ModifyFlights";
	public static final String SERVLET_URL_ADMIN_DASHBOARD = "/AdminDashboard";
	public static final String SERVLET_URL_HOME = "/Home";
	// End: Servlet Route

	// Start: Normal Text
	public static final String USER = "user";
	public static final String SUCCESS = "success";
	public static final String TRUE = "true";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "SIGN IN";
	public static final String LOGOUT = "SIGN OUT ";

	public static final String SLASH = "/";
	public static final String DELETE_ID = "deleteId";
	public static final String UPDATE_ID = "updateId";
	public static final String USER_LIST = "userList";
	public static final String FLIGHT_LIST = "flightList";
	// End: Normal Text

}	
