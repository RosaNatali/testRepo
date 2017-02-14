package services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ContactMan
 */
@Stateless
public class ContactMan implements ContactManRemote, ContactManLocal {
	private Map<String, String> mapOfContacts = new HashMap<>();

	/**
	 * Default constructor.
	 */
	public ContactMan() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initContacts() {
		System.out.println("hello from the other side");
		mapOfContacts.put("197", "police");
		mapOfContacts.put("198", "fireMan");
		mapOfContacts.put("196", "doc");
	}

	@Override
	public void addContact(String num, String name) {
		mapOfContacts.put(num, name);
	}

	@Override
	public Integer findNbContacts() {
		return mapOfContacts.size();
	}
}
