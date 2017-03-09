package training.manyToManyBi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: N
 *
 */
@Entity

public class N implements Serializable {

	@Id
	private Integer idN;

	@ManyToMany(mappedBy = "ns")
	private List<M> ms;
	private static final long serialVersionUID = 1L;

	public N() {
		super();
	}

	public Integer getIdN() {
		return this.idN;
	}

	public void setIdN(Integer idN) {
		this.idN = idN;
	}

	public List<M> getMs() {
		return ms;
	}

	public void setMs(List<M> ms) {
		this.ms = ms;
	}

}
