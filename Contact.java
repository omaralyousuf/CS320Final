/*
 * Author: 	Omar Al Yousuf
 * Date: 	07/14/2021
 * Course:	CS 320 SNHU
 */

package Classes;

public class Contact {
	
	
	  //Variables and constants
	  private String contactId;
	  private String firstName;
	  private String lastName;
	  private String phoneNumber;
	  private String address;
	  private static final byte ID_LENGTH = 10;
	  private static final byte FNAME_LENGTH = 10;
	  private static final byte LNAME_LENGTH = 10;
	  private static final int PHONENUM_LENGTH = 10;
	  private static final byte ADDRESS_LENGTH = 30;
	  private static final String INITIAL_STRING = "INITIAL";
	  private static final String INITIAL_NUM = "1010101010";
	  
	  //Default constructor
	  public Contact() {
	    this.contactId = INITIAL_STRING;
	    this.firstName = INITIAL_STRING;
	    this.lastName = INITIAL_STRING;
	    this.phoneNumber = INITIAL_NUM;
	    this.address = INITIAL_STRING;
	  }
	  
	  //Constructor with contact ID parameter
	  public Contact(String contactId) {
	    updateContactId(contactId);
	    this.firstName = INITIAL_STRING;
	    this.lastName = INITIAL_STRING;
	    this.phoneNumber = INITIAL_NUM;
	    this.address = INITIAL_STRING;
	  }
	  
	  //Constructor with contact ID and first name parameter
	  public Contact(String contactId, String firstName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    this.lastName = INITIAL_STRING;
	    this.phoneNumber = INITIAL_NUM;
	    this.address = INITIAL_STRING;
	  }
	  
	  //Constructor with contact ID, first and last name parameter
	  public Contact(String contactId, String firstName, String lastName) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    this.phoneNumber = INITIAL_NUM;
	    this.address = INITIAL_STRING;
	  }
	  
	  //Constructor with contact ID, first and last name, and phone number parameters
	  public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    this.address = INITIAL_STRING;
	  }
	  
	  //Constructor with contact ID, first and last name, phone number, and address parameters
	  public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
	    updateContactId(contactId);
	    updateFirstName(firstName);
	    updateLastName(lastName);
	    updatePhoneNumber(phoneNumber);
	    updateAddress(address);
	  }
	  
	  //Getters
	  public final String getContactId() { 
		  return contactId; }
	  
	  public final String getFirstName() { 
		  return firstName; }
	  
	  public final String getLastName() { 
		  return lastName; }
	  
	  public final String getPhoneNumber() { 
		  return phoneNumber; }
	  
	  public final String getAddress() { 
		  return address; }
	  
	  //Update first name method
	  public void updateFirstName(String firstName) {
		  if (firstName == null) {
	      throw new IllegalArgumentException("First name cannot be empty");
		  } 
		  else if (firstName.length() > FNAME_LENGTH) {
	      throw new IllegalArgumentException("First name cannot be longer than " + FNAME_LENGTH + " characters");
		  } 
		  else {
	      this.firstName = firstName;
		  }
	  }
	  
	  //Update last name method
	  public void updateLastName(String lastName) {
		  if (lastName == null) {
	      throw new IllegalArgumentException("Last name cannot be empty");
		  } 
		  else if (lastName.length() > LNAME_LENGTH) {
	      throw new IllegalArgumentException("Last name cannot be longer than " + LNAME_LENGTH + " characters");
		  } 
		  else {
	      this.lastName = lastName;
		  }
	  }
	 
	//Update contact ID method
	  public void updateContactId(String contactId) {
		  if (contactId == null) {
	      throw new IllegalArgumentException("Contact ID cannot be empty");
		  } 
		  else if (contactId.length() > ID_LENGTH) {
	      throw new IllegalArgumentException("Contact ID cannot be longer than " + ID_LENGTH + " characters");
		  } 
		  else {
	      this.contactId = contactId;
		  }
	  }
	  
	  //Update phone number method
	  public void updatePhoneNumber(String phoneNumber) {
	    
		  //To keep phone number digit only 0-9
		  String regex = "[0-9]+";
		  
		  if (phoneNumber == null) {
	      throw new IllegalArgumentException("Phone number cannot be empty.");
		  } 
		  else if (phoneNumber.length() != PHONENUM_LENGTH) {
	      throw new IllegalArgumentException("Phone number length invalid. Ensure it is " + PHONENUM_LENGTH + " digits.");
		  } 
		  else if (!phoneNumber.matches(regex)) {
	      throw new IllegalArgumentException("Phone number cannot have anything but numbers");
		  } 
		  else {
	      this.phoneNumber = phoneNumber;
		  }
	  }
	  
	  //Update address method
	  public void updateAddress(String address) {
		  if (address == null) {
	      throw new IllegalArgumentException("Address cannot be empty");
		  } 
		  else if (address.length() > ADDRESS_LENGTH) {
	      throw new IllegalArgumentException("Address cannot be longer than " + ADDRESS_LENGTH + " characters");
		  } 
		  else {
	      this.address = address;
		  }
	  }
	  
	  
	}

