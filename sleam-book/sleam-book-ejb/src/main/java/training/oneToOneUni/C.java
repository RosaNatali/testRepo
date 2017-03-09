package training.oneToOneUni;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: C
 *
 */
@Entity

public class C implements Serializable {

	   
	@Id
	private Integer idC;
	
	@OneToOne
	private D d;
	private static final long serialVersionUID = 1L;

	public C() {
		super();
	}   
	public Integer getIdC() {
		return this.idC;
	}

	public void setIdC(Integer idC) {
		this.idC = idC;
	}
	public D getD() {
		return d;
	}
	public void setD(D d) {
		this.d = d;
	}
   
}
