package services;

import javax.ejb.Remote;

@Remote
public interface DicoServicesRemote {
	String translate(String englishWord);
}
