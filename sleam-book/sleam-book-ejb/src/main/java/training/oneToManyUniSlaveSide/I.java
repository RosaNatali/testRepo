package training.oneToManyUniSlaveSide;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: I
 *
 */
@Entity

public class I implements Serializable {

	   
	@Id
	private Integer idI;
	private static final long serialVersionUID = 1L;

	public I() {
		super();
	}   
	public Integer getIdI() {
		return this.idI;
	}

	public void setIdI(Integer idI) {
		this.idI = idI;
	}
   
}
