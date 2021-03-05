package addresses;
import java.util.*;

public class Contacts {
	private Map<String, String> addressBook = new HashMap<>();
	private String leftAlignFormat = "| %-20s | %-60s |%n";
	private String tempValue = "temp";
	private String contact = "Bob 456 Way DC";
	
	//default constructor
	public Contacts() {
		addressBook.put("Bill Smith", "123 Main St, Coolsville MD 20876 301-555-1234");
		addressBook.put("Sally Jones", "1 Here Dr, Rockville MD 1111 240-888-3400");
		addressBook.put("Mohamad Smith", "333 Elm St, Largo MD 21726 240-777-9999");
	}
	
	//add contact
	public void addContact(String name, String address) {
		addressBook.put(name, address);
	}
	
	//delete contact
	public String deleteContact(String name) {
		contact = name + " " + addressBook.get(name);
		addressBook.remove(name);
		return contact;
	}
	
	//update name
	public void updateName(String name, String newName) {
		tempValue = addressBook.get(name);
		addressBook.remove(name);
		addressBook.put(newName, tempValue);
	}
	
	//update address
	public String updateAddress(String name, String address) {
		addressBook.put(name, address);
		contact = name + " " + addressBook.get(name);
		return contact;
	}

	//display contacts
	public void display() {
		System.out.format("---------------------------------------------------------------------------------------%n");
		System.out.format("| Name                 | Address                                                      |%n");
		System.out.format("---------------------------------------------------------------------------------------%n");
		for (Map.Entry<String, String> addressBook : addressBook.entrySet()) {
		    System.out.format(leftAlignFormat, addressBook.getKey(), addressBook.getValue());
		}
		System.out.format("---------------------------------------------------------------------------------------%n");
	}
	
}
