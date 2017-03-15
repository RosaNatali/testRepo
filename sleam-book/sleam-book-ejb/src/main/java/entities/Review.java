package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Review
 *
 */
@Entity

public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReviewId id;
	@Enumerated(EnumType.STRING)
	private ReviewType reviewType;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idPublication", referencedColumnName = "id", insertable = false, updatable = false)
	private Publication publication;

	public Review() {
		super();
	}

	public Review(ReviewType reviewType, User user, Publication publication) {
		super();
		this.reviewType = reviewType;
		this.user = user;
		this.publication = publication;
		this.id = new ReviewId(user.getId(), publication.getId());
	}

	public ReviewType getReviewType() {
		return reviewType;
	}

	public void setReviewType(ReviewType reviewType) {
		this.reviewType = reviewType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}
