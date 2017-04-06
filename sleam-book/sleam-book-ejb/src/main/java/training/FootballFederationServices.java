package training;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class FootballFederationServices
 */
@Stateless
public class FootballFederationServices implements FootballFederationServicesRemote, FootballFederationServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public FootballFederationServices() {
	}

	@Override
	public void createContract(Integer idPlayer, Integer idTeam, Integer duration, Double salary) {
		Team team = entityManager.find(Team.class, idTeam);

		Player player = entityManager.find(Player.class, idPlayer);

		Contract contract = new Contract(duration, salary, team, player);

		entityManager.merge(contract);
	}

}
