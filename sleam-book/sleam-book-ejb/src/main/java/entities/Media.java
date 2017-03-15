package entities;

import entities.Publication;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Media
 *
 */
@Entity

public class Media extends Publication implements Serializable {

	
	private String link;
	private static final long serialVersionUID = 1L;

	public Media() {
		super();
	}   
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}
   
}
