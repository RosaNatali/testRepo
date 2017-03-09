package training.oneToManyUniMasterSide;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: K
 *
 */
@Entity

public class K implements Serializable {

	   
	@Id
	private Integer idK;
	
	@OneToMany
	private List<L> ls;
	private static final long serialVersionUID = 1L;

	public K() {
		super();
	}   
	public Integer getIdK() {
		return this.idK;
	}

	public void setIdK(Integer idK) {
		this.idK = idK;
	}
	public List<L> getLs() {
		return ls;
	}
	public void setLs(List<L> ls) {
		this.ls = ls;
	}
   
}
