package training.inheritance;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: P
 *
 */
@Entity

public class P  extends O implements Serializable {

	
	private String nP;
	private static final long serialVersionUID = 1L;

	public P() {
		super();
	}   
	public String getNP() {
		return this.nP;
	}

	public void setNP(String nP) {
		this.nP = nP;
	}
   
}
