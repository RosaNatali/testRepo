package services;

import javax.ejb.Remote;

@Remote
public interface GreeetingsServicesRemote {
	String tiSallem(String esm);

}
