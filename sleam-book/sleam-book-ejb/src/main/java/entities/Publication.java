package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//
//import org.hibernate.annotations.DiscriminatorFormula;

import org.hibernate.annotations.DiscriminatorFormula;

/**
 * Entity implementation class for Entity: Publication
 *
 */
@Entity
@DiscriminatorFormula("0")
@DiscriminatorValue("0")
public class Publication implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String photoLibelle;
	private byte[] photoPath;

	@OneToMany(mappedBy = "publication")
	private List<Comment> comments;
	@OneToMany(mappedBy = "publication")
	private List<Review> reviews;
	@ManyToOne
	private User owner;

	@ManyToMany(mappedBy = "publicationsShared")
	private List<User> usersThatSharedThis;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "publication", cascade=CascadeType.REMOVE)
	private Set<Photo> photos = new HashSet<Photo>();
	

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

	public String getPhotoLibelle() {
		return photoLibelle;
	}

	public void setPhotoLibelle(String photoLibelle) {
		this.photoLibelle = photoLibelle;
	}

	public byte[] getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(byte[] photoPath) {
		this.photoPath = photoPath;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}


	
}
