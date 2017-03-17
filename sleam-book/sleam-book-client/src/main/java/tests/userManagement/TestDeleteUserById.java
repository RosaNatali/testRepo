package tests.userManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.userManagement.UserManagementRemote;

public class TestDeleteUserById {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("sleam-book-ear/sleam-book-ejb/UserManagement!services.userManagement.UserManagementRemote");

		userManagementRemote.deleteUserById(1);
	}

}
