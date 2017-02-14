package services;

import javax.ejb.Remote;

@Remote
public interface ContactManRemote {
	void addContact(String num, String name);

	Integer findNbContacts();
}
