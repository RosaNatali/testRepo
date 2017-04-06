package services.userManagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Publication;
import entities.User;

/**
 * Session Bean implementation class UserManagement
 */
@Stateless
public class UserManagement implements UserManagementRemote, UserManagementLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagement() {
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		entityManager.remove(findUserById(id));

	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));

	}

	@Override
	public void createPublicationByUser(Integer idUser, Publication publication) {
		User owner = findUserById(idUser);

		publication.setOwner(owner);

		entityManager.merge(publication);

	}

	@Override
	public void assignPublicationToUser(Publication publication, Integer idUser) {
		User user = findUserById(idUser);

		List<Publication> publicationsOld = user.getPublications();
		publicationsOld.add(publication);

		user.linkPublicationsToThisUser(publicationsOld);

		updateUser(user);

	}

	@Override
	public List<Publication> findPublicationsByUser(Integer idUser) {
		return entityManager.createQuery("SELECT p FROM Publication p WHERE p.owner.id=:param", Publication.class)
				.setParameter("param", idUser).getResultList();
	}

	@Override
	public List<Publication> findPublicationsByFriends(Integer idUser) {
		User user = findUserById(idUser);

		List<User> friends = user.getFriends();

		List<Publication> publications = new ArrayList<>();
		for (User f : friends) {
			List<Publication> publicationsByFriend = findPublicationsByUser(f.getId());
			for (Publication p : publicationsByFriend) {
				publications.add(p);
			}
		}
		return publications;
	}

}
