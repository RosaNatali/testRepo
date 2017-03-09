package training.oneToOneBi;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: A
 *
 */
@Entity

public class A implements Serializable {

	   
	@Id
	private Integer idA;
	
	@OneToOne
	private B b;
	private static final long serialVersionUID = 1L;

	public A() {
		super();
	}   
	public Integer getIdA() {
		return this.idA;
	}

	public void setIdA(Integer idA) {
		this.idA = idA;
	}
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
   
}
