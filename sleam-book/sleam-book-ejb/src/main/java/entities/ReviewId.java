package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ReviewId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idUser;
	private Integer idPublication;
	private Date dateOfReview;

	public ReviewId() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfReview == null) ? 0 : dateOfReview.hashCode());
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
		ReviewId other = (ReviewId) obj;
		if (dateOfReview == null) {
			if (other.dateOfReview != null)
				return false;
		} else if (!dateOfReview.equals(other.dateOfReview))
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

	public ReviewId(Integer idUser, Integer idPublication) {
		super();
		this.idUser = idUser;
		this.idPublication = idPublication;
		this.dateOfReview = new Date();
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdPublication() {
		return idPublication;
	}

	public void setIdPublication(Integer idPublication) {
		this.idPublication = idPublication;
	}

	public Date getDateOfReview() {
		return dateOfReview;
	}

	public void setDateOfReview(Date dateOfReview) {
		this.dateOfReview = dateOfReview;
	}

}
