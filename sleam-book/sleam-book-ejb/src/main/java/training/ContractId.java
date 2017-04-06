package training;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ContractId implements Serializable {
	private Integer idPlayer;
	private Integer idTeam;
	private Date dateOfContract;

	public ContractId() {
		// TODO Auto-generated constructor stub
	}

	public ContractId(Integer idPlayer, Integer idTeam) {
		super();
		this.idPlayer = idPlayer;
		this.idTeam = idTeam;
		this.dateOfContract = new Date();
	}

	public Integer getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(Integer idPlayer) {
		this.idPlayer = idPlayer;
	}

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlayer == null) ? 0 : idPlayer.hashCode());
		result = prime * result + ((idTeam == null) ? 0 : idTeam.hashCode());
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
		ContractId other = (ContractId) obj;
		if (idPlayer == null) {
			if (other.idPlayer != null)
				return false;
		} else if (!idPlayer.equals(other.idPlayer))
			return false;
		if (idTeam == null) {
			if (other.idTeam != null)
				return false;
		} else if (!idTeam.equals(other.idTeam))
			return false;
		return true;
	}

	public Date getDateOfContract() {
		return dateOfContract;
	}

	public void setDateOfContract(Date dateOfContract) {
		this.dateOfContract = dateOfContract;
	}

}
