package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "user")
	private List<Comment> comments;

	@OneToMany(mappedBy = "user")
	private List<Review> reviews;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.MERGE)
	private List<Publication> publications;

	@ManyToMany
	private List<Publication> publicationsShared;

	@OneToMany
	@JoinTable(name = "friendsTable")
	private List<User> friends;

	@OneToMany(mappedBy = "sender")
	private List<Message> messagesSent;

	@OneToMany(mappedBy = "reciver")
	private List<Message> messagesRecived;

	@ManyToMany
	private List<GroupOfSleamBooker> groupsManaged;

	@ManyToMany
	private List<GroupOfSleamBooker> groupsSubscribedIn;

	public User() {
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

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Message> getMessagesSent() {
		return messagesSent;
	}

	public void setMessagesSent(List<Message> messagesSent) {
		this.messagesSent = messagesSent;
	}

	public List<GroupOfSleamBooker> getGroupsManaged() {
		return groupsManaged;
	}

	public void setGroupsManaged(List<GroupOfSleamBooker> groupsManaged) {
		this.groupsManaged = groupsManaged;
	}

	public List<GroupOfSleamBooker> getGroupsSubscribedIn() {
		return groupsSubscribedIn;
	}

	public void setGroupsSubscribedIn(List<GroupOfSleamBooker> groupsSubscribedIn) {
		this.groupsSubscribedIn = groupsSubscribedIn;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public List<Publication> getPublicationsShared() {
		return publicationsShared;
	}

	public void setPublicationsShared(List<Publication> publicationsShared) {
		this.publicationsShared = publicationsShared;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void linkPublicationsToThisUser(List<Publication> publications) {
		this.publications = publications;
		for (Publication p : publications) {
			p.setOwner(this);
		}
	}
}
