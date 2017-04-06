package tests.userManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Publication;
import services.userManagement.UserManagementRemote;

public class TestCreatePublication {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("sleam-book-ear/sleam-book-ejb/UserManagement!services.userManagement.UserManagementRemote");

		Publication publication = new Publication("ahla w sahla ");

		userManagementRemote.createPublicationByUser(1, publication);

	}

}
