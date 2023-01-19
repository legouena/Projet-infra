package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.Game;
import model.Model;
import model.AddRequest;
import model.Review;
import model.User;

public class Database {
	public static final String DB_ADRESS = "dbAdress";
	public static final String USER = "user";
	public static final String PASSWORD = "user";
	
	//Connexion
	private Connection connection;
	
	private Model model;
	
	public Database(Model p_model) {
		this.model = p_model;
		this.connection = null;
		
		connectDB();
	}
	
	
	
	public void connectDB() {
		
		try {	        
			
	        connection = DriverManager.getConnection(this.DB_ADRESS, this.USER, this.PASSWORD);
	    
		} catch (SQLException e) {
	    
	    	System.out.println(e.getMessage());
	    }
		
		if(connection != null) {
			
			System.out.println("Connexion to database successful.");
		
		} else {
			
			System.out.println("Connexion to database failed.");
		}
	}
	
	public void getUsers() throws ClassNotFoundException, SQLException{
		
		// Create statement
        Statement statement = connection.createStatement();

        String sql = "Select id, type, pseudo, mail, password, creationDate, lastConnexion, notoriety from User";

        // Execute SQL statement returns a ResultSet object.
        ResultSet rs = statement.executeQuery(sql);
        
        //Close Statement
        statement.close();
        
        Vector<User> l_users = new Vector<User>();
        while (rs.next()) {
            int l_id = rs.getInt("id");
            String l_type = rs.getString("type");
            String l_pseudo = rs.getString("pseudo");
            String l_mail = rs.getString("mail");
            String l_password = rs.getString("password");
            String l_creation_date = rs.getString("creationDate");
            String l_last_connexion = rs.getString("lastConnexion");
            float l_notoriety = rs.getFloat("nototriety");
            User l_user = new User(l_id, l_type, l_pseudo, l_mail, l_password,
            					   l_creation_date, l_last_connexion, l_notoriety);
            l_users.add(l_user);
        }
        
        this.model.setUsers(l_users);
	}
	
	public void removeUser(Game p_user) throws ClassNotFoundException, SQLException{
		
		// SQL statement 
        String sql = "DELETE FROM User WHERE id = ?";

        // Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setInt(1, p_user.getId());
        this.getUsers();
	}
	
	public void getGames() throws ClassNotFoundException, SQLException{
		
		// Create statement
        Statement statement = connection.createStatement();

        String sql = "Select id, name, creationDate, releaseDate, category, studio, averageGrade from Game";

        // Execute SQL statement returns a ResultSet object.
        ResultSet rs = statement.executeQuery(sql);
        
        //Close Statement
        statement.close();
        
        Vector<Game> l_games = new Vector<Game>();
        while (rs.next()) {
            int l_id = rs.getInt("id");
            String l_name = rs.getString("type");
            String l_creation_date = rs.getString("creationDate");
            String l_release_date = rs.getString("releaseDate");
            String l_category = rs.getString("category");
            String l_studio = rs.getString("studio");
            float l_average_grade = rs.getFloat("averageGrade");
            Game l_game = new Game(l_id, l_name, l_creation_date, l_release_date, l_category, l_studio, l_average_grade);
            l_games.add(l_game);
        }
        
        this.model.setGames(l_games);
	}
	
	public void removeGame(Game p_game) throws ClassNotFoundException, SQLException{
		
		// SQL statement 
        String sql = "DELETE FROM Game WHERE id = ?";

        // Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setInt(1, p_game.getId());
        
        ResultSet rs = pstm.executeQuery();

        pstm.close();
        this.getGames();
	}
	
	public void addGame(Game p_game)throws ClassNotFoundException, SQLException{
		
		// SQL statement 
        String sql = "INSERT INTO Game (id, name, creationDate, releaseDate, category, studio, averageGrade) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setInt(1, p_game.getId());
        pstm.setString(2, p_game.getName());
        pstm.setString(3, p_game.getCreationDate());
        pstm.setString(4, p_game.getReleaseDate());
        pstm.setString(5, p_game.getCategory());
        pstm.setString(6, p_game.getStudio());
        pstm.setFloat(7, p_game.getAverageGrade());
        
        ResultSet rs = pstm.executeQuery();
        
        pstm.close();
        this.getGames();


	}
	
	public void getReviews() throws ClassNotFoundException, SQLException{
		
		// Create statement
        Statement statement = connection.createStatement();

        String sql = "Select id, date, game, text, user, image, video, reputation, grade from Review";

        // Execute SQL statement returns a ResultSet object.
        ResultSet rs = statement.executeQuery(sql);
        
        //Close Statement
        statement.close();
        
        Vector<Review> l_reviews = new Vector<Review>();
        while (rs.next()) {
            int l_id = rs.getInt("id");
            String l_date = rs.getString("date");
            String l_text = rs.getString("text");
            int l_game_id = rs.getInt("game");
            int l_user_id = rs.getInt("user");
            String l_media_path = rs.getString("image");
            int l_reputation = rs.getInt("reputation");
            float l_grade = rs.getFloat("grade");
            
            Game l_game = this.model.getGameById(l_game_id);
            User l_user = this.model.getUserById(l_user_id);
            
            Review l_review = new Review(l_id, l_date, l_game, l_text,
            							 l_user, l_media_path, l_reputation, l_grade);
            l_reviews.add(l_review);
        }
        
        this.model.setReviews(l_reviews);
	}
	
	public void removeReview(Review p_review) throws ClassNotFoundException, SQLException{
		
		// SQL statement 
        String sql = "DELETE FROM Review WHERE id = ?";

        // Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setInt(1, p_review.getId());
        
        ResultSet rs = pstm.executeQuery();

        pstm.close();
        this.getReviews();
	}
	
	public void getAddRequests() throws ClassNotFoundException, SQLException{
		// Create statement
        Statement statement = connection.createStatement();

        String sql = "Select id, date, game, text, user, image, video, reputation, grade from AddRequest";

        // Execute SQL statement returns a ResultSet object.
        ResultSet rs = statement.executeQuery(sql);
        
        //Close Statement
        statement.close();
        
        Vector<AddRequest> l_add_requests = new Vector<AddRequest>();
        while (rs.next()) {
            int l_id = rs.getInt("id");
            String l_date = rs.getString("date");
            String l_game = rs.getString("game");
            int l_user_id = rs.getInt("user");
            String l_status = rs.getString("status");
            
            User l_user = this.model.getUserById(l_user_id);
            
            AddRequest l_add_request = new AddRequest(l_id, l_date, l_game, l_user, l_status);
            l_add_requests.add(l_add_request);
        }
        
        this.model.setAddRequests(l_add_requests);
	}
	
	public void validateAddRequest(AddRequest p_add_request) throws ClassNotFoundException, SQLException {
		// SQL statement 
        String sql = "UPDATE table SET status = ? WHERE id = ?";

        // Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, "validée");
        pstm.setInt(2, p_add_request.getId());
        
        ResultSet rs = pstm.executeQuery();

        pstm.close();
        this.getAddRequests();
	}
	
	public void declineAddRequest(AddRequest p_add_request) throws ClassNotFoundException, SQLException {
		// SQL statement 
        String sql = "UPDATE table SET status = ? WHERE id = ?";

        // Create a PreparedStatement object.
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        pstm.setString(1, "refusée");
        pstm.setInt(2, p_add_request.getId());
        
        ResultSet rs = pstm.executeQuery();

        pstm.close();
        this.getAddRequests();
	}
	

}
