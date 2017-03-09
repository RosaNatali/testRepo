package training.inheritance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: O
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class O implements Serializable {

	@Id
	private Integer idO;
	private String typeOf;
	private static final long serialVersionUID = 1L;

	public O() {
		super();
	}

	public Integer getIdO() {
		return this.idO;
	}

	public void setIdO(Integer idO) {
		this.idO = idO;
	}

	public String getTypeOf() {
		return typeOf;
	}

	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}

}
