package training.oneToManyUniMasterSide;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: L
 *
 */
@Entity

public class L implements Serializable {

	   
	@Id
	private Integer idL;
	private static final long serialVersionUID = 1L;

	public L() {
		super();
	}   
	public Integer getIdL() {
		return this.idL;
	}

	public void setIdL(Integer idL) {
		this.idL = idL;
	}
   
}
