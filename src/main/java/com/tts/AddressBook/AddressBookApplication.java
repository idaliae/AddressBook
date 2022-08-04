package com.tts.AddressBook;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tts.AddressBook.contact.Contact;
import com.tts.AddressBook.repository.ContactRepository;


@SpringBootApplication
public class AddressBookApplication {

	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);
	
	public static void main(String[] args) {	
		SpringApplication.run(AddressBookApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(ContactRepository repository) {
		return (args) -> {
			Boolean quit = false;
			Scanner scanner = new Scanner(System.in);
//			log.info("Welcome to you AB");
			
			while (!quit) {
				String prompt = "1) Add an entry \n2) Remove an entry \n3) Search for a specific entry \n4) Print Address Book \n5) Delete Book \n6) Quit";
				System.out.println("Welcome to your Address Book. Please make a selection on which action you would like to make using numbers.");
				System.out.println(prompt);
				
				Integer userInput = scanner.nextInt();
				
				System.out.println(userInput);
				
				if (userInput == 1) {
					log.info("Option 1 has been selected: Add an entry.\n");
					Scanner contactInput = new Scanner(System.in);

					log.info("Enter first name: \n");
					String firstName = contactInput.next();
					
					log.info("Enter last name: \n");
					String lastName = contactInput.next();
					
					log.info("Enter phone number: \n");
					String phoneNumber = contactInput.next();
					
					log.info("Enter email address: \n");
					String email = contactInput.next();
					
					repository.save(new Contact(firstName, lastName, phoneNumber, email));
					System.out.printf("New contact has been added: \nFirst Name: %s\n Last Name: %s\n Phone Number: %s\n Email: %s\n", firstName, lastName, phoneNumber, email);
				
//					contactInput.close();
					
				} else if (userInput == 2){
					log.info("Option 2 has been selected: Remove an entry.\n");
					
//					1. Show list of contacts by id (include firstName & lasName)
//					System.out.println(repository.findAll());

//					2. prompt user input for deletion
//					System.out.println("Input contact ID to delete contact:\n");

//					3. delete and "You have successfully deleted w/id contact"
					
//				
				} else if (userInput == 3){
					System.out.println("Option 3 has been selected: Search for a specific entry.\n");
					
					System.out.println("Select the type of search you would like to perform using the corresponding numbers.");
					System.out.println("1). Search by first name \n2). Search by last name \n3). Search by phone number \n4). Search by email\n");
					
					Scanner input = new Scanner(System.in);
					
					log.info("Enter search type number:");
					Scanner searchType = input;
					log.info("Enter your search:");
					Scanner searchEntry = input;
					
//					TODO: Code is breaking here... fix
//					if (searchType.equals(scanner("1"))) {
//						System.out.println(repository.findByFirstName("%s", searchEntry));
//					}
					
					
					
					
				} else if (userInput == 4){
					System.out.println("Option 4 has been selected: Print address book.\n Here is your contacts list");
					System.out.println(repository.findAll());
					
				
//				} else if (userInput == 5){
//					System.out.println("Option 5 has been selected: Delete Book.\n");
//					
//				} else if (userInput == 6){
//					System.out.println("Option 6 has been selected: Quit.\n");
//					quit = true;
//					System.out.println("Goodbye!");
//					continue;
////					System.exit(0);
					
				} else {
					System.out.println("Please enter a valid option.");
				}
			}
			scanner.close();
		};
	}

	private Object scanner(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

