package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity

public class GroupOfSleamBooker implements Serializable {

	@Id
	private Integer id;
	private String name;

	@ManyToMany(mappedBy = "groupsManaged")
	private List<User> listOfAdmins;

	@ManyToMany(mappedBy = "groupsSubscribedIn")
	private List<User> listOfSubscribedUsers;

	private static final long serialVersionUID = 1L;

	public GroupOfSleamBooker() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getListOfAdmins() {
		return listOfAdmins;
	}

	public void setListOfAdmins(List<User> listOfAdmins) {
		this.listOfAdmins = listOfAdmins;
	}

	public List<User> getListOfSubscribedUsers() {
		return listOfSubscribedUsers;
	}

	public void setListOfSubscribedUsers(List<User> listOfSubscribedUsers) {
		this.listOfSubscribedUsers = listOfSubscribedUsers;
	}

}
