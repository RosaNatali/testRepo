package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommentId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idUser;
	private Integer idPublication;
	private Date dateOfComment;

	public CommentId() {
	}

	public CommentId(Integer idUser, Integer idPublication) {
		super();
		this.idUser = idUser;
		this.idPublication = idPublication;
		this.dateOfComment = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfComment == null) ? 0 : dateOfComment.hashCode());
		result = prime * result + ((idPublication == null) ? 0 : idPublication.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentId other = (CommentId) obj;
		if (dateOfComment == null) {
			if (other.dateOfComment != null)
				return false;
		} else if (!dateOfComment.equals(other.dateOfComment))
			return false;
		if (idPublication == null) {
			if (other.idPublication != null)
				return false;
		} else if (!idPublication.equals(other.idPublication))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

	public CommentId(Integer idUser, Integer idPublication, Date dateOfComment) {
		super();
		this.idUser = idUser;
		this.idPublication = idPublication;
		this.dateOfComment = dateOfComment;
	}

}
