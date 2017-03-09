package training.oneToManyUniSlaveSide;

import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: J
 *
 */
@Entity

public class J implements Serializable {

	   
	@Id
	private Integer idJ;
	
	@ManyToOne
	private I i;
	private static final long serialVersionUID = 1L;

	public J() {
		super();
	}   
	public Integer getIdJ() {
		return this.idJ;
	}

	public void setIdJ(Integer idJ) {
		this.idJ = idJ;
	}
	public I getI() {
		return i;
	}
	public void setI(I i) {
		this.i = i;
	}
   
}
