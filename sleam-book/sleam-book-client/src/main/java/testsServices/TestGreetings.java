package testsServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.GreeetingsServicesRemote;

public class TestGreetings {

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			String jndiName = "sleam-book-ear/sleam-book-ejb/GreetingsServices!services.GreeetingsServicesRemote";
			GreeetingsServicesRemote proxy = (GreeetingsServicesRemote) context.lookup(jndiName);

			System.out.println(proxy.tiSallem("salah"));

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
