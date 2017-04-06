package tests.contractManagement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.FootballFederationServicesRemote;

public class TestAddContract {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		FootballFederationServicesRemote footballFederationServicesRemote = (FootballFederationServicesRemote) context
				.lookup("sleam-book-ear/sleam-book-ejb/FootballFederationServices!training.FootballFederationServicesRemote");
		
		footballFederationServicesRemote.createContract(1, 1, 10, 100D);

	}

}
