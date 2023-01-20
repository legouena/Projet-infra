package model;

public class AddRequest {

	private int id;
	private String date;
	private String game_to_add;
	private User user;
	private String status;
	
	public AddRequest(int p_id,
					String p_date,
					String p_game_to_add,
					User p_user,
					String p_status) {
		this.id = p_id;
		this.date = p_date;
		this.game_to_add = p_game_to_add;
		this.user = p_user;
		this.status = p_status;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int p_id) {
		this.id = p_id;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String p_date) {
		this.date = p_date;
	}
	
	public String getGameToAdd() {
		return this.game_to_add;
	}
	
	public void setGameToAdd(String p_game_to_add) {
		this.game_to_add = p_game_to_add;
	}
	
	public  User getUser() {
		return this.user;
	}
	
	public void setUser(User p_user) {
		this.user = p_user;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setSatus(String p_status) {
		this.status = p_status;
	}
	
	
}
