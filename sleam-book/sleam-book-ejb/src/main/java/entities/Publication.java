package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Publication
 *
 */
@Entity

public class Publication implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;

	@OneToMany(mappedBy = "publication")
	private List<Comment> comments;
	@OneToMany(mappedBy = "publication")
	private List<Review> reviews;
	@ManyToOne
	private User owner;

	@ManyToMany(mappedBy = "publicationsShared")
	private List<User> usersThatSharedThis;
	private static final long serialVersionUID = 1L;

	public Publication() {
		super();
	}

	public Publication(String title) {
		super();
		this.title = title;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<User> getUsersThatSharedThis() {
		return usersThatSharedThis;
	}

	public void setUsersThatSharedThis(List<User> usersThatSharedThis) {
		this.usersThatSharedThis = usersThatSharedThis;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
