package services.userManagement;

import java.util.List;

import javax.ejb.Remote;

import entities.Publication;
import entities.User;

@Remote
public interface UserManagementRemote {
	void addUser(User user);

	User findUserById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);

	void deleteUser(User user);

	void createPublicationByUser(Integer idUser, Publication publication);

	void assignPublicationToUser(Publication publication, Integer idUser);

	List<Publication> findPublicationsByUser(Integer idUser);

	List<Publication> findPublicationsByFriends(Integer idUser);

}
