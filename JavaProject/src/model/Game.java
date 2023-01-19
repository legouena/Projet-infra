package model;


public class Game {
	
	private int id;
	private String name;
	private String creationDate;
	private String releaseDate;
	private String category;
	private String studio;
	private float averageGrade;
	
	public Game(int id,
				String name,
				String creationDate,
				String releaseDate,
				String category,
				String studio,
				float averageGrade) {
		setId(id);
		setName(name);
		setCreationDate(creationDate);
		setReleaseDate(releaseDate);
		setCategory(category);
		setStudio(studio);
		setAverageGrade(averageGrade);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public float getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(float averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	
}