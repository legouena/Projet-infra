package model;


public class Review {
	
	private int id;
	private String date;
	private Game game;
	private String text;
	private User user;
	private String media_path;
	private int reputation;
	private float grade;

	
	public Review (int id,
				   String date,
				   Game game,
				   String text,
				   User user,
				   String mediaPath,
				   int reputation,
				   float grade) {
		setId(id);
		setDate(date);
		setGame(game);
		setText(text);
		setUser(user);
		setMediaPath(mediaPath);
		setReputation(reputation);
		setGrade(grade);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;	
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getMediaPath() {
		return media_path;
	}


	public void setMediaPath(String mediaPath) {
		this.media_path = mediaPath;
	}


	public int getReputation() {
		return reputation;
	}


	public void setReputation(int reputation) {
		this.reputation = reputation;
	}


	public float getGrade() {
		return grade;
	}


	public void setGrade(float grade) {
		this.grade = grade;
	}
}




