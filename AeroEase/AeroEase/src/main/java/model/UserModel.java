package model;

import java.io.File;
import java.time.LocalDate;

import javax.servlet.http.Part;

import util.StringUtil;

public class UserModel {

	private String userName;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDate dob;
	private String password;
	private String imageUrlFromPath;

	public UserModel() {

	}

	public UserModel(String userName, String firstName, String lastName, String phoneNumber, LocalDate dob,
			String password, Part imagePart) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.password = password;
		this.imageUrlFromPath = getImageUrl(imagePart);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrlFromPath() {
		return imageUrlFromPath;
	}

	public void setImageUrlFromPath(String imageUrlFromPath) {
		this.imageUrlFromPath = imageUrlFromPath;
	}

	private String getImageUrl(Part part) {
		// Define the directory path to store uploaded user images. This path should be
		// configured elsewhere in the application.
		String savePath = StringUtil.IMAGE_DIR_USERS;

		// Create a File object representing the directory to store uploaded images.
		File fileSaveDir = new File(savePath);

		// Initialize the variable to store the extracted image file name.
		String imageUrlFromPart = null;

		// Check if the directory to store uploaded images already exists.
		if (!fileSaveDir.exists()) {
			// If the directory doesn't exist, create it.
			// user mkdirs() method to create multiple or nested folder
			fileSaveDir.mkdir();
		}

		// Get the Content-Disposition header from the request part. This header
		// contains information about the uploaded file, including its filename.
		String contentDisp = part.getHeader("content-disposition");

		// Split the Content-Disposition header into individual parts based on
		// semicolons.
		String[] items = contentDisp.split(";");

		// Iterate through each part of the Content-Disposition header.
		for (String s : items) {
			// Check if the current part starts with "filename" (case-insensitive trim is
			// used).
			if (s.trim().startsWith("filename")) {
				// Extract the filename from the current part.
				// The filename is assumed to be enclosed in double quotes (").
				// This part removes everything before the equal sign (=) and the double quotes
				// surrounding the filename.
				imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
				break; // Exit the loop after finding the filename
			}
		}

		// If no filename was extracted from the Content-Disposition header, set a
		// default filename.
		if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
			imageUrlFromPart = "default_user.jpg";
		}

		// Return the extracted or default image file name.
		return imageUrlFromPart;
	}

}
