/*
 * Author: 	Omar Al Yousuf
 * Date: 	07/14/2021
 * Course:	CS 320 SNHU
 */

package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
  
	//Creating an Arraylist of contacts
	private List<Contact> contactList = new ArrayList<>();
	
	//Search for contact per ID contact
	private Contact searchForContact(String id) throws Exception {
	    int index = 0;
	    while (index < contactList.size()) {
	      
	    	if (id.equals(contactList.get(index).getContactId())) {
	        return contactList.get(index);
	      }
	      index++;
	    }
	    throw new Exception("Contact does not exist. Try again using different ID");
	 }
	 
	//Create a unique ID utilizing a random
	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
  
	//Add contact
	public void newContact() {
		Contact contact = new Contact(newUniqueId());
		contactList.add(contact);
	}
	
	//Add contact with unique first name
	public void newContact(String firstname) {
		Contact contact = new Contact(newUniqueId(), firstname);
		contactList.add(contact);
	}
	  
	//Add contact with unique first and last name
	public void newContact(String firstname, String lastname) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname);
		contactList.add(contact);
	}
	  
	//Add contact with unique first and last name and phone number
	public void newContact(String firstname, String lastname, String phonenumber) {
		Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber);
		contactList.add(contact);
	}
		
	//Add contact with unique first and last name and phone number and address
	public void newContact(String firstname, String lastname, String phonenumber, String address) {
	Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
	contactList.add(contact);
	}
	
	//Delete contact per contact ID
	public void deleteContact(String id) throws Exception {
		contactList.remove(searchForContact(id));
	}
	
	//Update first name per contact ID
	public void updateFirstName(String id, String firstName) throws Exception {
		searchForContact(id).updateFirstName(firstName);
	}
	
	//Update last name per contact ID
	public void updateLastName(String id, String lastName) throws Exception {
		searchForContact(id).updateLastName(lastName);
	}
	
	//Update phone number per contact ID
	public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
		searchForContact(id).updatePhoneNumber(phoneNumber);
	}
	
	//Update address per contact ID
	public void updateAddress(String id, String address) throws Exception {
		searchForContact(id).updateAddress(address);
	}
	  
	//Method to get contact list
	public List<Contact> getContactList() {
		return contactList; }
	
	
}

