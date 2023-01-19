package model;

public class User {
	
	private int id;
	private String type;
	private String pseudo;
	private String mail;
	private String password;
	private String creationDate;
	private String lastConnection;
	private float notoriety;
	
	public User (int id, 
				 String type, 
				 String pseudo, 
				 String mail, 
				 String password, 
				 String creationDate, 
				 String lastConnection, 
				 float notoriety) {
		setId(id);
		setType(type);
		setPseudo(pseudo);
		setMail(mail);
		setPassword(password);
		setCreationDate(creationDate);
		setNotoriety(notoriety);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(String lastConnection) {
		this.lastConnection = lastConnection;
	}

	public float getNotoriety() {
		return notoriety;
	}

	public void setNotoriety(float notoriety) {
		this.notoriety = notoriety;
	}		
}
