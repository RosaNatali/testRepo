package com.esprit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.primefaces.showcase.service.Car;

import entities.Photo;
import entities.Publication;
import entities.User;
import services.userManagement.UserManagementRemote;

/**
 * @author Saria ESSID
 *
 */
@ManagedBean
@SessionScoped
public class UserBean
{
	private String username;
	private String password;
	private String publicationContent;
	private List<Publication> lps;
	private Publication selectedPublication;
	private Car selectedCar;
	private Publication publication;
	private User connectedUser;
	private List<Publication> filteredPublications;
	private File file;
	private UploadedFile photo;
	private UploadedFile photo1;
	private String publicationTitle;
	private List<Photo> lphs;
	private String id;
    private String photoLibelle;
    private String title;
    private Integer owner_id;
    private List<UploadedFile> uploadedFiles;
    
    Connection MySQLcon = null;
    Statement stmt = null;
    PreparedStatement ps;
    ResultSet rs;
    
	
	@EJB
	private UserManagementRemote umr;

	@PostConstruct
	public void init()
	{
		publication = new Publication();
		selectedPublication = new Publication();
		selectedCar = new Car();
		connectedUser = new User();
		lphs = new ArrayList<Photo>();
		uploadedFiles = new ArrayList<UploadedFile>();
		
		if (!FacesContext.getCurrentInstance().isPostback())
		{
			filteredPublications = lps;
		}
	}
	
	
	//********************************************************************************************************************

	
	
	public void uploadPhoto() {
        System.out.println("sssss");
        if (photo != null) {
            try {
                System.out.println(photo.getFileName());
                InputStream fin2 = photo.getInputstream();
                Connection con = Database.getConnection();
                PreparedStatement pre = con.prepareStatement("insert into publication (photoLibelle,photoPath,title,owner_id) values(?,?,?,?)");
                pre.setString(1, photo.getFileName().toString());
                pre.setBinaryStream(2, fin2, photo.getSize());
                pre.setString(3, publicationTitle);
                pre.setInt(4, connectedUser.getId());
                pre.executeUpdate();
                System.out.println("Inserting Successfully!");
                pre.close();
                lps = umr.findPublicationsByUser(connectedUser.getId());
                FacesMessage msg = new FacesMessage("Congratulations, your publication is posted with success !.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                lphs.clear();
            } catch (Exception e) {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else{
        FacesMessage msg = new FacesMessage("Please select image!!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
	public void clearPhotoList()
	{
		System.out.println("--------------------------------------AZ1: " + lphs.size());
		lphs.clear();
		System.out.println("--------------------------------------AZ2: " + lphs.size());
	}
	
	public void createP(Integer connectedUserId)
	{
		Publication publication = new Publication();
		User user = new User();
		user = umr.findUserById(connectedUserId);

		publication.setOwner(user);
		publication.setTitle(publicationContent);
		System.out.println("----------------------------------------PublicationContent: " + publicationContent);
		umr.createPublicationByUser(connectedUserId, publication);

		lps = umr.findPublicationsByUser(connectedUserId);
		
		Integer currentPublicationId = lps.get(lps.size()-1).getId();
		System.out.println("Create----------------------------------------Added Publication: " + currentPublicationId);
	}
	
	public void uploadPhotoNew()
	{
		try 
        {
			Integer currentPublicationId = lps.get(lps.size()-1).getId();
			System.out.println("ADD ----------------------------------------Added Publication: " + currentPublicationId);
			
			/***********************************************************/
			
			File f = new File("C:\\TOTO");
        	if(f.mkdir())
        	{
        	    System.out.println("Directory Created");
        	} 
        	else
        	{
        		System.out.println("Directory is not created");
        	}
        	
            System.out.println(photo.getFileName());
            InputStream fin2 = photo.getInputstream();
            Connection con = Database.getConnection();
                
            String path = f.getAbsolutePath()+ "\\" + photo.getFileName().toString();
            
            final Path destination = Paths.get(path);
            InputStream bytes=null;
            if (null!=photo)
            {
            	bytes = photo.getInputstream();
                Files.copy(bytes, destination);
            }
        
            PreparedStatement pre = con.prepareStatement("insert into photo (photoLibelle,photoPath,id) values(?,?,?)");
            pre.setString(1, photo.getFileName().toString());
            pre.setString(2, path);
            pre.setInt(3, currentPublicationId);
            pre.executeUpdate();
            System.out.println("Inserting Successfully!");
            pre.close();
            
            lps = umr.findPublicationsByUser(connectedUser.getId());
            lphs = umr.findPhotosByPublication(publication.getId());
            FacesMessage msg = new FacesMessage("Congratulations, your picture is selected with success !.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
		catch (Exception e) 
		{
			System.out.println("Exception-File Upload." + e.getMessage());
        }
    }
	
	public void clearListPhotos(Integer publicationId)
	{
		List<Photo> photos = umr.findPhotosByPublication(publicationId);
		System.out.println("Clear----------------------------------------Size 1: " + photos.size());
		for(Photo p : photos)
		{
			umr.deletePhotoById(p.getPhotoId());
		}
		System.out.println("Clear----------------------------------------Size 2: " + photos.size());
	}
	
	public void addPhoto(Integer publicationId)
	{
		try 
        {
			System.out.println("ADD ----------------------------------------Added Publication: " + publicationId);
			
			/***********************************************************/
			
			File f = new File("C:\\TOTO");
        	if(f.mkdir())
        	{
        	    System.out.println("Directory Created");
        	} 
        	else
        	{
        		System.out.println("Directory is not created");
        	}
        	
            System.out.println(photo.getFileName());
            InputStream fin2 = photo.getInputstream();
            Connection con = Database.getConnection();
                
            String path = f.getAbsolutePath()+ "\\" + photo.getFileName().toString();
            
            final Path destination = Paths.get(path);
            InputStream bytes=null;
            if (null!=photo)
            {
            	bytes = photo.getInputstream();
                Files.copy(bytes, destination);
            }
        
            PreparedStatement pre = con.prepareStatement("insert into photo (photoLibelle,photoPath,id) values(?,?,?)");
            pre.setString(1, photo.getFileName().toString());
            pre.setString(2, path);
            pre.setInt(3, publicationId);
            pre.executeUpdate();
            System.out.println("Inserting Successfully!");
            pre.close();
            
            lps = umr.findPublicationsByUser(connectedUser.getId());
            lphs = umr.findPhotosByPublication(publication.getId());
            FacesMessage msg = new FacesMessage("Congratulations, your picture is selected with success !.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } 
		catch (Exception e) 
		{
			System.out.println("Exception-File Upload." + e.getMessage());
        }
    }
	
	public void editPublication(Integer pubId)
	{
        if (photo1 != null)
        {
            try
            {
                System.out.println(photo1.getFileName());
                InputStream fin2 = photo1.getInputstream();
                Connection con = Database.getConnection();
                PreparedStatement pre = con.prepareStatement("update publication set photoLibelle=?, photoPath=?, title =?, owner_id=? where id=?");
                pre.setString(1, photo1.getFileName().toString());
                pre.setBinaryStream(2, fin2, photo1.getSize());
                pre.setString(3, selectedPublication.getTitle());
                pre.setInt(4, connectedUser.getId());
                pre.setInt(5, pubId);
                pre.executeUpdate();
                System.out.println("Inserting Successfully!");
                pre.close();
                lps = umr.findPublicationsByUser(connectedUser.getId());
                FacesMessage msg = new FacesMessage("Congratulations, your publication is updated with success !.");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } 
            catch (Exception e)
            {
                System.out.println("Exception-File Upload." + e.getMessage());
            }
        }
        else
        {
        	FacesMessage msg = new FacesMessage("Please select image!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
	public List<Photo> listPhotos(int publicationId)
	{
		List<Photo> photos = umr.findPhotosByPublication(publicationId);
		return photos;		
	}
	
	
	public List<UserBean> getAllImage()
	{
		List<UserBean> imageInfo = new ArrayList<UserBean>();
	    Connection con = Database.getConnection();
	    try
	    {
	    	stmt = con.createStatement();
	        String strSql = "select id, photoLibelle, title, owner_id from publication order by id ";
	        rs = stmt.executeQuery(strSql);
	        while (rs.next())
	        {
	        	UserBean tbl = new UserBean();
	            tbl.setId(rs.getString("id"));
	            tbl.setPhotoLibelle(rs.getString("photoLibelle"));
	            tbl.setTitle(rs.getString("title"));
	            tbl.setOwner_id(rs.getInt("owner_id"));
	            imageInfo.add(tbl);
	        }
	    }
	    catch (SQLException e)
	    {
	    	System.out.println("Exception in getAllImage::" + e.getMessage());
	    }
	        return imageInfo;
	}
	
	
	public String azerty(int a)
	{
		return umr.findPhotoById(a).getPhotoLibelle();
	}

	
	public StreamedContent getImage() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Pictures/", filename)));
	    }
	}
	
	
	public StreamedContent getPhotos() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Pictures/", filename)));
	    }
	}
	
	
	public StreamedContent getImagechj() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();
	    
	    

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Desktop/WFL/wildfly-10.0.0.Final/standalone/deployments/sleam-book-ear.ear/sleam-book-web.war/uploadFiles/MarcelHirscher.jpg", filename)));
	    }
	}
	
	
	public StreamedContent getImageee() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
//	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Pictures/ss.jpg")));
	    }
	}
	
	
	public StreamedContent getNewImage() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
//	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Pictures/Person/cr.jpg")));
	    }
	}
	
	
	public StreamedContent getNewImage1() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
//	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        
	    	/********************************/
	    	File f = new File("C:\\TEST");
	    	try{
	    	    if(f.mkdir()) { 
	    	        System.out.println("Directory Created");
	    	    } else {
	    	        System.out.println("Directory is not created");
	    	    }
	    	} catch(Exception e){
	    	    e.printStackTrace();
	    	} 
	    	/********************************/
	    	
//	    	System.out.println("--------------------------------------------AZERT: " + writer.);
	    	return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Desktop/WFL/wildfly-10.0.0.Final/standalone/deployments/sleam-book-ear.ear/sleam-book-web.war/uploadFiles/DonaldTrump.jpg")));
	    }
	}
	
	
	public StreamedContent getImagee() throws IOException
	{
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        // So, we're rendering the view. Return a stub StreamedContent so that it will generate right URL.
	        return new DefaultStreamedContent();
	    }
	    else {
	        // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
	        String filename = context.getExternalContext().getRequestParameterMap().get("filename");
	        return new DefaultStreamedContent(new FileInputStream(new File("C:/Users/SARSOURA/Pictures", filename)));
	    }
	}
	
	
	public void hello()
	{
		System.out.println("--------------------------------------------------- YES");
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Sorry, your identication has been failed. Please retry again !.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Publication) event.getObject()).getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	
	public void logIn() throws IOException {
		User user = umr.login(username, password);
		if (user != null) {
			connectedUser = user;
			lps = umr.findPublicationsByUser(connectedUser.getId());
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		}
	}

	
	public void createPublication(Integer userId) {
		Publication publication = new Publication();
		User user = new User();
		user = umr.findUserById(userId);

		publication.setOwner(user);
		publication.setTitle(publicationContent);
		umr.createPublicationByUser(userId, publication);

		lps = umr.findPublicationsByUser(userId);
	}

	
	public Publication findPublicationById(Integer publicationId)
	{
		return umr.findPublicationById(publicationId);
	}
	
	
	public void deletePublication(Integer userId, Integer idPublication) {
		Publication publication = umr.findPublicationById(idPublication);
		umr.deletePublication(publication);
		lps = umr.findPublicationsByUser(userId);
	}

	
	public void updatePublication(Integer id) {
		Publication publication = umr.findPublicationById(id);
		publication.setTitle(selectedPublication.getTitle());
		umr.updatePublication(publication);
	}

	
	public List<Publication> updateListPublications(Integer userId) {
		lps = umr.findPublicationsByUser(userId);
		return lps;
	}

	
	public void quit() throws IOException {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
	}
	
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println("---------------------------------LOL: " + file.getAbsolutePath());
        }
    }

	/************************************** Getters & Setters *************************************/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPublicationContent() {
		return publicationContent;
	}

	public void setPublicationContent(String publicationContent) {
		this.publicationContent = publicationContent;
	}

	public UserManagementRemote getUmr() {
		return umr;
	}

	public void setUmr(UserManagementRemote umr) {
		this.umr = umr;
	}

	public List<Publication> getLps() {
		return lps;
	}

	public void setLps(List<Publication> lps) {
		this.lps = lps;
	}

	public Publication getSelectedPublication() {
		return selectedPublication;
	}

	public void setSelectedPublication(Publication selectedPublication) {
		this.selectedPublication = selectedPublication;
	}

	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}

	public List<Publication> getFilteredPublications() {
		return filteredPublications;
	}

	public void setFilteredPublications(List<Publication> filteredPublications) {
		this.filteredPublications = filteredPublications;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

    public String getImageLength() {
        return imageLength;
    }

    public void setImageLength(String imageLength) {
        this.imageLength = imageLength;
    }
    private String imageLength;

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPhotoLibelle() {
		return photoLibelle;
	}


	public void setPhotoLibelle(String photoLibelle) {
		this.photoLibelle = photoLibelle;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getOwner_id() {
		return owner_id;
	}


	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}


	public UploadedFile getPhoto() {
		return photo;
	}


	public void setPhoto(UploadedFile photo) {
		this.photo = photo;
	}


	public String getPublicationTitle() {
		return publicationTitle;
	}


	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}


	public UploadedFile getPhoto1() {
		return photo1;
	}


	public void setPhoto1(UploadedFile photo1) {
		this.photo1 = photo1;
	}


	public List<Photo> getLphs() {
		return lphs;
	}


	public void setLphs(List<Photo> lphs) {
		this.lphs = lphs;
	}


	public List<UploadedFile> getUploadedFiles() {
		return uploadedFiles;
	}


	public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}

	
}
