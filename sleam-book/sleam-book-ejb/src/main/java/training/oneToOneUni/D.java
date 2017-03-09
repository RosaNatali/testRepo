package training.oneToOneUni;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: D
 *
 */
@Entity

public class D implements Serializable {

	   
	@Id
	private Integer idD;
	private static final long serialVersionUID = 1L;

	public D() {
		super();
	}   
	public Integer getIdD() {
		return this.idD;
	}

	public void setIdD(Integer idD) {
		this.idD = idD;
	}
   
}
