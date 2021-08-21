/*
 * Author: 	Omar Al Yousuf
 * Date: 	07/14/2021
 * Course:	CS 320 SNHU
 */

package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Classes.ContactService;

public class ContactServiceTest {
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
  
  //Testing adding new contact method
  @Test
  void newContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getContactId()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(0).getLastName()),
        ()
            -> assertEquals("1010101010", service.getContactList().get(0).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));
    
    service.newContact(firstNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(1).getContactId()),
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(1).getLastName()),
        ()
            -> assertEquals("1010101010", service.getContactList().get(1).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));
    
    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(2).getContactId()),
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
        ()
            -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
        ()
            -> assertEquals("1010101010", service.getContactList().get(2).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));
    
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(3).getContactId()),
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
        ()
            -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
        ()
            -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
        ()
            -> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));
    
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(4).getContactId()),
        ()
            -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
        ()
            -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
        ()
            -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
        ()
            -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
  }
  
  //Testing delete contact method
  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    
    assertThrows(Exception.class, 
    			() 
    			  -> service.deleteContact(contactId));
    assertAll(
    			()
                  -> service.deleteContact(service.getContactList().get(0).getContactId()));
  }
  
  //Testing update first name method
  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
    
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () 
                 	 -> service.updateFirstName(contactId, firstNameTest));
  }
  
  //Testing update last name method
  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
    
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () 
                 	 -> service.updateLastName(contactId, lastNameTest));
  }
  
  //Testing update phone number method
  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
    
    assertEquals(phoneNumberTest,
                 service.getContactList().get(0).getPhoneNumber());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(),tooShortPhoneNumber));
    assertThrows(
        IllegalArgumentException.class,
        		 ()
        			 -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
    assertThrows(IllegalArgumentException.class,
                 ()
                 	 -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () 
                     -> service.updatePhoneNumber(contactId, lastNameTest));
  }
  
  //Testing update address method
  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactId(), addressTest);
    
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(service.getContactList().get(0).getContactId(), tooLongAddress));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () 
                 	 -> service.updateAddress(contactId, addressTest));
  }
}


