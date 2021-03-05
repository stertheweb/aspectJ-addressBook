package addresses;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public aspect UpdateContact {
	pointcut updateAddressCheck(): execution (String updateAddress(String, String)) && within(Contacts);
	
	after() returning(String contact): updateAddressCheck() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("contactinfo.txt", true))) {
			writer.println("Record Updated " + contact);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	pointcut deleteContactCheck() : execution (String deleteContact(String)) && within(Contacts);
	
	after() returning(String contact): deleteContactCheck() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("contactinfo.txt", true))) {
			writer.println("Record Deleted " + contact);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}