package training.oneToOneBi;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: B
 *
 */
@Entity

public class B implements Serializable {

	@Id
	private Integer idB;

	@OneToOne(mappedBy="b")
	private A a;
	private static final long serialVersionUID = 1L;

	public B() {
		super();
	}

	public Integer getIdB() {
		return this.idB;
	}

	public void setIdB(Integer idB) {
		this.idB = idB;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

}
