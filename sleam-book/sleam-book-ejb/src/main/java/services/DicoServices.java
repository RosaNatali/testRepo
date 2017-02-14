package services;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class DicoServices
 */
@Singleton
@Startup
public class DicoServices implements DicoServicesRemote, DicoServicesLocal {
	private Map<String, String> mapOfWords = new HashMap<>();

	@PostConstruct
	public void initWords() {
		System.out.println("hi there i am alive : from singleton");
		mapOfWords.put("add", "ajouter");
		mapOfWords.put("hi", "salut");
	}

	/**
	 * Default constructor.
	 */
	public DicoServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String translate(String englishWord) {
		return mapOfWords.get(englishWord);
	}

}
