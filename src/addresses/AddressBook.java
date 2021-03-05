package addresses;
import java.util.*;

public class AddressBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contacts contacts = new Contacts();
		int menuOption = 0;
		boolean program = true;
		char yesOrNo = 'o';
		String name = "John Doe";
		String newName = "Jane Doe";
		boolean newNameValue = false;
		String address = "1009 Firestone Way Gilbert, AZ 85224 480-555-9810";
		
		//Greeting
		System.out.println("Hello! Welcome to the Address Book application.");
		
		//Loop through the program
		while(program) {
			//Pick an option
			System.out.println("Please select from one of the following options:");
			System.out.println("Press 1: Add a contact");
			System.out.println("Press 2: Delete a contact");
			System.out.println("Press 3: Update a contact");
			System.out.println("Press 4: Display address book");
			System.out.println("Press 5: Exit the program");
			menuOption = sc.nextInt();
			
			//Add contact
			if(menuOption == 1) {
				System.out.println("Name:");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Address:");
				address = sc.nextLine();
				contacts.addContact(name, address);
			}
			
			//Delete contact
			else if(menuOption == 2) {
				System.out.println("Enter the name of the contact you want to delete:");
				sc.nextLine();
				name = sc.nextLine();
				contacts.deleteContact(name);
			}
			
			//Update contact
			else if(menuOption == 3) {
				System.out.println("Enter the name of the contact you want to update:");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Do you want to update the name? (Y/N)");
				yesOrNo = sc.next().charAt(0);
				if(yesOrNo == 'Y' || yesOrNo == 'y') {
					System.out.println("What is the new name?");
					sc.nextLine();
					newName = sc.nextLine();
					contacts.updateName(name, newName);
					newNameValue = true;
				}
				System.out.println("Do you want to update the address? (Y/N)");
				yesOrNo = sc.next().charAt(0);
				if(yesOrNo == 'Y' || yesOrNo == 'y') {
					if(newNameValue) {
						System.out.println("What is the new address?");
						sc.nextLine();
						address = sc.nextLine();
						contacts.updateAddress(newName, address);
					} else {
						System.out.println("What is the new address?");
						sc.nextLine();
						address = sc.nextLine();
						contacts.updateAddress(name, address);
					}
				}
				newNameValue = false;
			}
			
			//Display address book
			else if(menuOption == 4) {
				contacts.display();
			}
			
			//Quit program
			else if(menuOption == 5) {
				System.out.println("GOODBYE");
				break;
			}
		}
		sc.close();
	}
}
