package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public abstract class ValidationUtil {
	/**
	 * Validates if the provided text contains only letters and whitespace
	 * characters.
	 * 
	 * @param text The text to be validated.
	 * @return True if the text contains only letters and whitespace, false
	 *         otherwise.
	 */
	public static boolean isTextOnly(String text) {
		return text.matches("[a-zA-Z\\s]+"); // Match letters and whitespace only
	}

	public static boolean isValidUsernameLength(String userName) {
		return userName.length() >= 6;
	}

	/**
	 * Validates if the provided text contains only digits (0-9).
	 * 
	 * @param text The text to be validated.
	 * @return True if the text contains only digits, false otherwise.
	 */
	public static boolean isNumbersOnly(String text) {
		return text.matches("\\d+"); // Match digits only
	}

	public static boolean areDifferentSelections(String selection1, String selection2) {
		return !selection1.equals(selection2);
	}

	/**
	 * Validates if the provided text is alphanumeric, containing only letters and
	 * digits.
	 * 
	 * @param text The text to be validated.
	 * @return True if the text is alphanumeric, false otherwise.
	 */
	public static boolean isAlphanumeric(String text) {
		return text.matches("[a-zA-Z0-9]+"); // Match letters and digits only
	}

	public static boolean isValidPhoneNumber(String phoneNumber) {

		String phonePattern = "^\\+[0-9]{13}$";

		// Compile the pattern into a regex Pattern object
		Pattern pattern = Pattern.compile(phonePattern);

		// Use Pattern.matcher() to create a Matcher object for the given input
		return pattern.matcher(phoneNumber).matches();
	}

	/**
	 * Validates if the provided text contains no special characters other than
	 * letters, digits, and whitespace.
	 * 
	 * @param text The text to be validated.
	 * @return True if the text contains no special characters, false otherwise.
	 */
	public static boolean hasNoSpecialCharacters(String text) {
		return text.matches("[a-zA-Z0-9\\s]+"); // Match only letters, digits, and whitespace
	}

	/**
	 * Validates if the provided text has the specified length.
	 * 
	 * @param text   The text to be validated.
	 * @param length The expected length of the text.
	 * @return True if the text has the specified length, false otherwise.
	 */
	public static boolean hasLength(String text, int length) {
		return text.length() == length;
	}

	public static boolean isAdult(LocalDate birthdate) {
		// Get today's date
		LocalDate todayDate = LocalDate.now();

		// Calculate the age
		int age = todayDate.getYear() - birthdate.getYear();

		// Adjust age if the user's birthday hasn't occurred yet this year
		if (birthdate.getDayOfYear() > todayDate.getDayOfYear()) {
			age--;
		}
		return age >= 18;
	}

	public static boolean isImage(String fileName) {
		// Get the file extension
		String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

		return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("gif")
				|| extension.equals("bmp") || extension.equals("svg") || extension.equals("webp");
	}
	
	
	/**
	 * Validates if the provided password meets complexity requirements:
	 * - Contains at least one uppercase letter (A-Z)
	 * - Contains at least one lowercase letter (a-z)
	 * - Contains at least one digit (0-9)
	 * - Contains at least one symbol (@$!%*?&).
	 * 
	 * @param password The password to be validated.
	 * @return True if the password meets complexity requirements, false otherwise.
	 */
	public static boolean isValidPassword(String password) {
		return password.matches("^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]*$");
	}
	
	
	
    public static boolean validateDate(String userInput) {
        try {
            // Parse the user input into a LocalDate object
            LocalDate inputDate = LocalDate.parse(userInput, DateTimeFormatter.ISO_LOCAL_DATE);
            
            // Get the current date
            LocalDate currentDate = LocalDate.now();
            
            // Compare the user input date with the current date
            if (inputDate.isAfter(currentDate)) {
                return true; // User input date is in the future
            } else {
                return false; // User input date is in the past
            }
        } catch (DateTimeParseException e) {
            // Handle invalid date format
            
            return false;
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
