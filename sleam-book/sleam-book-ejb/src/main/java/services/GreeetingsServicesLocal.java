package services;

import javax.ejb.Local;

@Local
public interface GreeetingsServicesLocal {
	String tiSallem(String esm);
}
