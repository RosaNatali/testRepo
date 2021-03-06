package tests.userManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.userManagement.UserManagementRemote;

public class TestAddUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserManagementRemote userManagementRemote = (UserManagementRemote) context
				.lookup("sleam-book-ear/sleam-book-ejb/UserManagement!services.userManagement.UserManagementRemote");
		User user = new User();
		user.setId(1);
		user.setName("Cristiano Ronaldo");
		user.setUsername("cristiano.ronaldo@real.com");
		user.setPassword("HELLOWORLDCRISTIANO");
		userManagementRemote.addUser(user);
	}
}
