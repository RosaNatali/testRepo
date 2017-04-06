package tests.userManagement;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Publication;
import services.userManagement.UserManagementRemote;

public class TestFindPublicationsByUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("sleam-book-ear/sleam-book-ejb/UserManagement!services.userManagement.UserManagementRemote");

		List<Publication> publications = userManagementRemote.findPublicationsByUser(1);

		for (Publication p : publications) {
			System.out.println(p.getTitle());
		}
	}

}
