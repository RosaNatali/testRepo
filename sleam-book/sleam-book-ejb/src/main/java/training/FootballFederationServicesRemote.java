package training;

import javax.ejb.Remote;

@Remote
public interface FootballFederationServicesRemote {
	void createContract(Integer idPlayer, Integer idTeam, Integer duration, Double salary);
}
