package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class MessageId implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private Integer idSender;
	private Integer idReciver;
	private Date dateOf;

	public MessageId() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReciver == null) ? 0 : idReciver.hashCode());
		result = prime * result + ((idSender == null) ? 0 : idSender.hashCode());
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
		MessageId other = (MessageId) obj;
		if (idReciver == null) {
			if (other.idReciver != null)
				return false;
		} else if (!idReciver.equals(other.idReciver))
			return false;
		if (idSender == null) {
			if (other.idSender != null)
				return false;
		} else if (!idSender.equals(other.idSender))
			return false;
		return true;
	}

	public MessageId(Integer idSender, Integer idReciver) {
		super();
		this.idSender = idSender;
		this.idReciver = idReciver;
		this.dateOf = new Date();
	}

	public Integer getIdSender() {
		return idSender;
	}

	public void setIdSender(Integer idSender) {
		this.idSender = idSender;
	}

	public Integer getIdReciver() {
		return idReciver;
	}

	public void setIdReciver(Integer idReciver) {
		this.idReciver = idReciver;
	}

	public Date getDateOf() {
		return dateOf;
	}

	public void setDateOf(Date dateOf) {
		this.dateOf = dateOf;
	}

}
