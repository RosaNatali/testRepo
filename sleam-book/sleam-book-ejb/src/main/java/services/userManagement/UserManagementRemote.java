package services.userManagement;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserManagementRemote {
	void addUser(User user);

	User findUserById(Integer id);

	void updateUser(User user);

	void deleteUserById(Integer id);

	void deleteUser(User user);

}
