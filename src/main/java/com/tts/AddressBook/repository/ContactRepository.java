package com.tts.AddressBook.repository;

import java.util.List;
//import java.util.Scanner;

import org.springframework.data.repository.CrudRepository;
import com.tts.AddressBook.contact.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	List<Contact> findByLastName(String lastName);
//	List<Contact> findById(Long id);

//	char[] findByFirstName(String firstName, Scanner searchEntry);

}
