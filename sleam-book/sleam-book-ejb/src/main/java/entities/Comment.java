package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {
	@EmbeddedId
	private CommentId id;
	private String text;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "idPublication", referencedColumnName = "id", insertable = false, updatable = false)
	private Publication publication;
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	public Comment(String text, User user, Publication publication) {
		super();
		this.text = text;
		this.user = user;
		this.publication = publication;
		this.id = new CommentId(user.getId(), publication.getId());
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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
