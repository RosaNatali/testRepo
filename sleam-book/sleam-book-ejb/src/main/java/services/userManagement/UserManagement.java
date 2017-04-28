package services.userManagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.GroupOfSleamBooker;
import entities.Message;
import entities.Photo;
import entities.Publication;
import entities.ReviewType;
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
	public Publication findPublicationById(Integer id) {
		return entityManager.find(Publication.class, id);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}
	
	@Override
	public void updatePublication(Publication publication) {
		entityManager.merge(publication);
	}

	@Override
	public void deleteUserById(Integer id) {
		entityManager.remove(findUserById(id));

	}
	
	@Override
	public void deletePhotoById(Integer id) {
		entityManager.remove(findPhotoById(id));

	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(entityManager.merge(user));

	}
	
	@Override
	public void deletePublication(Publication publication) {
		entityManager.remove(entityManager.merge(publication));

	}

	@Override
	public void createPublicationByUser(Integer idUser, Publication publication) {
		User owner = findUserById(idUser);

		publication.setOwner(owner);

		entityManager.merge(publication);

	}
	
	@Override
	public void createPhoto(Photo photo) {
		entityManager.merge(photo);

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
	public List<User> findAllUsers() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
	}
	
	@Override
	public List<Publication> findPublicationsByUser(Integer idUser) {
		return entityManager.createQuery("SELECT p FROM Publication p WHERE p.owner.id=:param", Publication.class)
				.setParameter("param", idUser).getResultList();
	}
	
	@Override
	public List<Photo> findPhotosByPublication(Integer idPub) {
		return entityManager.createQuery("SELECT p FROM Photo p WHERE p.publication.id=:param", Photo.class)
				.setParameter("param", idPub).getResultList();
	}
	
	@Override
	public Photo findPhotoById(Integer id) {
		return entityManager.createQuery("SELECT p FROM Photo p WHERE p.photoId=:param", Photo.class)
				.setParameter("param", id).getSingleResult();
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

	@Override
	public void addFriend(User me, User friend) {
		me.getFriends().add(friend);
		entityManager.merge(me);
	}

	@Override
	public void addGroup(GroupOfSleamBooker group) {
		entityManager.persist(group);
	}

	@Override
	public void sendMessage(User sender, User receiver, String messageText) {
		Message message = new Message(messageText, sender, receiver);
		entityManager.persist(message);
	}

	@Override
	public void commentPublication(User user, Publication publication, String comment) {
			
	}

	@Override
	public void reviewPublication(User user, Publication publication, ReviewType reviewType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeToGroup(User user, GroupOfSleamBooker groupOfSleamBooker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sharePublication(User user, Publication publication) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public User login(String username, String password) {
		return entityManager.createQuery("SELECT u FROM User u WHERE u.username=:param1 AND u.password=:param2", User.class)
				.setParameter("param1", username).setParameter("param2", password).getSingleResult();
	}

	@Override
	public void createPublicationByUserNew(Integer idUser, String publication) {
		// TODO Auto-generated method stub
		
	}

}
