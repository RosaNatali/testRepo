package training.inheritance;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Q
 *
 */
@Entity

public class Q extends O implements Serializable {

	private String nQ;
	private static final long serialVersionUID = 1L;

	public Q() {
		super();
	}

	public String getNQ() {
		return this.nQ;
	}

	public void setNQ(String nQ) {
		this.nQ = nQ;
	}

}
