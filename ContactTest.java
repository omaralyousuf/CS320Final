/*
 * Author: 	Omar Al Yousuf
 * Date: 	07/14/2021
 * Course:	CS 320 SNHU
 */
package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.Contact;

public class ContactTest {
	
  protected String contactId;
  protected String firstNameTest;
  protected String lastNameTest;
  protected String phoneNumberTest;
  protected String addressTest;
  protected String tooLongContactId;
  protected String tooLongFirstName;
  protected String tooLongLastName;
  protected String tooLongPhoneNumber;
  protected String tooShortPhoneNumber;
  protected String tooLongAddress;
  
  @BeforeEach
  void setUp() {
    contactId = "1332A887C7";
    firstNameTest = "Omar";
    lastNameTest = "Al";
    phoneNumberTest = "4807774444";
    addressTest = "1221 Dunlap Ave AZ 85051";
    tooLongContactId = "112233445566778899";
    tooLongFirstName = "Allan Morris Allan";
    tooLongLastName = "Caprio Baca";
    tooLongPhoneNumber = "61977789787";
    tooShortPhoneNumber = "619232";
    tooLongAddress = "1221 West Dunlap Ave, Phoenix, AZ 85051";
  }
  
  //Testing default constructor
  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("default constructor",
              ()
                  -> assertNotNull(contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () 
              	  -> assertNotNull(contact.getAddress()));
  }
  
  //Testing constructor with contact ID
  @Test
  void contactIdConstructorTest() {
    Contact contact = new Contact(contactId);
    assertAll(
    		"Constructor with contact ID",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () 
              	  -> assertNotNull(contact.getAddress()));
  }
  
  //Testing constructor with contact ID and first name
  @Test
  void contactIdAndFirstNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll(
    		"Constructor with contact ID and first name",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
              	  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () 
              	  -> assertNotNull(contact.getAddress()));
  }
  
  //Testing constructor with contact ID, first and last name
  @Test
  void contactIdAndFullNameConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll(
    		"Constructor with contact ID, first and last name",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () 
              	  -> assertNotNull(contact.getAddress()));
  }
  
  //Testing constructor with contact ID, first and last name, and phone number 
  @Test
  void contactIdFullNamePhoneNumberConstructorTest() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
    		"Constructor with contact ID, first and last name, and phone number",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () 
                  -> assertNotNull(contact.getAddress()));
  }
  @Test
  void allDataConstructorTest() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll(
    		"Constructor with contact ID, first and last name, phone number, and address",
              ()
                  -> assertEquals(contactId, contact.getContactId()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () 
                  -> assertEquals(addressTest, contact.getAddress()));
  }
  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
        	-> assertThrows(IllegalArgumentException.class,
                            () 
                            	-> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () 
                            	-> contact.updateFirstName(tooLongFirstName)));
  }
  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () 
                            	-> contact.updateLastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () 
                            	-> contact.updateLastName(tooLongFirstName)));
  }
  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll(
    		"phone number",
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () 
                                  	-> contact.updatePhoneNumber(null)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () 
                      	-> contact.updatePhoneNumber(tooLongPhoneNumber)),
              ()
                  -> assertThrows(
                      IllegalArgumentException.class,
                      () 
                      	-> contact.updatePhoneNumber(tooShortPhoneNumber)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () 
                                  	-> contact.updatePhoneNumber(contactId)));
  }
  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll(
    		"address",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () 
                                  	-> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () 
                                  	-> contact.updateAddress(tooLongAddress)));
  }
  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
contact.updateContactId(contactId);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(contactId, contact.getContactId()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () 
                            	-> contact.updateContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () 
                            	-> contact.updateContactId(tooLongContactId)));
  }
}


