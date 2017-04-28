package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author ESSID Saria
 *
 */
@Entity
public class Photo implements Serializable
{
	@Id
	@Column(name="photoId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int photoId;

	@Column(name="photoLibelle", length = 250)
	private String photoLibelle;
	
	@Column(name="photoPath", length = 250)
	private String photoPath;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Publication publication;
	
	
	
	public Photo() {}

	
	public Photo(int photoId, String photoLibelle, String photoPath, Publication publication) {
		super();
		this.photoId = photoId;
		this.photoLibelle = photoLibelle;
		this.photoPath = photoPath;
		this.publication = publication;
	}

	
	/************************************* Setters & Getters *************************************/
	
	
	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoLibelle() {
		return photoLibelle;
	}

	public void setPhotoLibelle(String photoLibelle) {
		this.photoLibelle = photoLibelle;
	}

	public String getPhotoPath() {
		return photoPath;
	}
	
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

		
}
