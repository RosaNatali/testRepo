package services.userManagement;

import java.util.List;

import javax.ejb.Remote;

import entities.GroupOfSleamBooker;
import entities.Photo;
import entities.Publication;
import entities.ReviewType;
import entities.User;

@Remote
public interface UserManagementRemote {
	void addUser(User user);

	User findUserById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);

	void deleteUser(User user);

	void createPublicationByUser(Integer idUser, Publication publication);
	
	void createPublicationByUserNew(Integer idUser, String publication);

	void assignPublicationToUser(Publication publication, Integer idUser);

	List<Publication> findPublicationsByUser(Integer idUser);

	List<Publication> findPublicationsByFriends(Integer idUser);

	void addFriend(User me, User friend);

	void addGroup(GroupOfSleamBooker group);

	void sendMessage(User sender, User receiver, String messageText);

	void commentPublication(User user, Publication publication, String comment);

	void reviewPublication(User user, Publication publication, ReviewType reviewType);

	void subscribeToGroup(User user, GroupOfSleamBooker groupOfSleamBooker);

	void sharePublication(User user, Publication publication);

	User login(String username, String password);

	void deletePublication(Publication publication);

	Publication findPublicationById(Integer id);

	void updatePublication(Publication publication);

	List<User> findAllUsers();

	void createPhoto(Photo photo);

	Photo findPhotoById(Integer id);

	List<Photo> findPhotosByPublication(Integer idPub);

	void deletePhotoById(Integer id);

}
