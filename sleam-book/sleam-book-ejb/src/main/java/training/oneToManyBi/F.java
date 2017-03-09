package training.oneToManyBi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: F
 *
 */
@Entity

public class F implements Serializable {

	@Id
	private Integer idF;

	@ManyToOne
	private E e;
	private static final long serialVersionUID = 1L;

	public F() {
		super();
	}

	public Integer getIdF() {
		return this.idF;
	}

	public void setIdF(Integer idF) {
		this.idF = idF;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

}
