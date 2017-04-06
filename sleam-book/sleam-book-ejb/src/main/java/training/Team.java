package training;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Team
 *
 */
@Entity

public class Team implements Serializable {

	@Id
	private Integer id;

	@OneToMany(mappedBy = "team")
	private List<Contract> contracts;
	private static final long serialVersionUID = 1L;

	public Team() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
