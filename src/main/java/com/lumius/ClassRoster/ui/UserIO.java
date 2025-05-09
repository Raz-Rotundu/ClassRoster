package com.lumius.ClassRoster.ui;

public interface UserIO {
	
	/**
	 * Prints the given message to screen
	 * @param msg the message to be printed
	 */
	void print(String msg);
	
	
	/**
	 * Prompts the user to enter a double, then returns the number entered
	 * @param prompt the message displayed to the user
	 * @return the double the user entered
	 */
	double readDouble(String prompt);
	
	/**
	 * Verifies that the entered double is within a certain range, and repeatedly prompts the user to enter number if not in range
	 * @param prompt the message prompting the user
	 * @param min the upper bound of the range
	 * @param max the lower bound of the range
	 * @return the double the user entered
	 */
	double readDouble(String prompt, double min, double max);
	
	/**
	 * Prompts the user to enter a float, then returns the number entered
	 * @param prompt the message displayed to the user
	 * @return the float the user entered
	 */
	float readFloat(String prompt);
	
	/**
	 * Verifies that the entered float is within a certain range, and repeatedly prompts the user to enter number if not in range
	 * @param prompt the message prompting the user
	 * @param min the upper bound of the range
	 * @param max the lower bound of the range
	 * @return the float the user entered
	 */
	float readFloat(String prompt, float min, float max);
	
	/**
	 * Prompts the user to enter an integer, then returns the number entered
	 * @param prompt the message prompting the user
	 * @return the integer the user entered
	 */
	int readInt(String prompt);
	
	/**
	 * Verifies that the entered integer is within a certain range, and repeatedly prompts the user to enter number if not in range
	 * @param prompt the message prompting the user
	 * @param min the upper bound of the range
	 * @param max the lower bound of the range
	 * @return the integet the user entered
	 */
	int readInt(String prompt, int min, int max);
	
	/**
	 * 
	 * @param prompt
	 * @return
	 */
	long readLong(String prompt);
	
	/**
	 * 
	 * @param prompt
	 * @param min
	 * @param max
	 * @return
	 */
	long readLong(String prompt, long min, long max);
	
	/**
	 * 
	 * @param prompt
	 * @return
	 */
	String readString(String prompt);
	
	/**
	 * Closes the application
	 */
	public void close();
}
