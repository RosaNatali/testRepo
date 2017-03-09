package training.oneToManyBi;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: E
 *
 */
@Entity

public class E implements Serializable {

	   
	@Id
	private Integer idE;
	
	@OneToMany(mappedBy="e")
	private List<F> fs;
	private static final long serialVersionUID = 1L;

	public E() {
		super();
	}   
	public Integer getIdE() {
		return this.idE;
	}

	public void setIdE(Integer idE) {
		this.idE = idE;
	}
	public List<F> getFs() {
		return fs;
	}
	public void setFs(List<F> fs) {
		this.fs = fs;
	}
   
}
