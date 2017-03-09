package training.manyToManyBi;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: M
 *
 */
@Entity

public class M implements Serializable {

	   
	@Id
	private Integer idM;
	
	@ManyToMany
	private List<N>ns;
	private static final long serialVersionUID = 1L;

	public M() {
		super();
	}   
	public Integer getIdM() {
		return this.idM;
	}

	public void setIdM(Integer idM) {
		this.idM = idM;
	}
	public List<N> getNs() {
		return ns;
	}
	public void setNs(List<N> ns) {
		this.ns = ns;
	}
   
}
