package services;

import javax.ejb.Stateless;

@Stateless
public class GreetingsServices implements GreeetingsServicesRemote, GreeetingsServicesLocal {

	@Override
	public String tiSallem(String esm) {
		return "ahla w sahla ya :" + esm;
	}

}
