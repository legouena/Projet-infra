package model;

import java.util.Vector;

public class Model {
	
	private Vector<User> users;
	private Vector<Game> games;
	private Vector<Review> reviews;
	private Vector<AddRequest> add_requests;

	public Model() {
		
		users = new Vector<User>();
		games = new Vector<Game>();
		reviews = new Vector<Review>();
		add_requests = new Vector<AddRequest>();
		
		// Mocking data
		User l_user1 = new User(1, "administrateur", "pseudo1", "mail1", 
								"password1", "14/01/2023", "15/01/2023", (float)2.56);
		User l_user2 = new User(2, "utilisateur", "pseudo2", "mail2", 
				"password2", "14/01/2023", "15/01/2023", (float)2.56);
		User l_user3 = new User(3, "utilisateur", "pseudo3", "mail3", 
				"password3", "14/01/2023", "15/01/2023", (float)2.56);
		User l_user4 = new User(4, "utilisateur", "pseudo4", "mail4", 
				"password4", "14/01/2023", "15/01/2023", (float)2.56);
		users.add(l_user1);
		users.add(l_user2);
		users.add(l_user3);
		users.add(l_user4);
		
		Game l_game1 = new Game(1, "game1", "16/01/2023", "15/01/2023",
								"jeux d'horreur", "Blizzard", (float)2.5 );
		Game l_game2 = new Game(2, "game2", "16/01/2023", "15/01/2023",
				"jeux d'horreur", "Blizzard", (float)2.5 );
		Game l_game3 = new Game(3, "game3", "16/01/2023", "15/01/2023",
				"jeux d'horreur", "Blizzard", (float)2.5 );
		Game l_game4 = new Game(4, "game4", "16/01/2023", "15/01/2023",
				"jeux d'horreur", "Blizzard", (float)2.5 );
		Game l_game5 = new Game(5, "game5", "16/01/2023", "15/01/2023",
				"jeux d'horreur", "Blizzard", (float)2.5 );
		games.add(l_game1);
		games.add(l_game2);
		games.add(l_game3);
		games.add(l_game4);
		games.add(l_game5);
		
		Review l_review1 = new Review(1, "15/01/2023", l_game1, 
				"le jeu est vraiment très cool", l_user2, "", 12, (float)9.5);
		Review l_review2 = new Review(2, "15/01/2023", l_game2, 
				"le jeu est vraiment cool", l_user3, "", 12, (float)8.5);
		Review l_review3 = new Review(3, "15/01/2023", l_game3, 
				"le jeu est vraiment très cool", l_user2, "", 12, (float)9.5);
		Review l_review4 = new Review(4, "15/01/2023", l_game1, 
				"le jeu est vraiment très cool", l_user4, "", 12, (float)9.5);
		Review l_review5 = new Review(5, "15/01/2023", l_game3, 
				"le jeu est vraiment très cool", l_user4, "", 12, (float)5.5);
		Review l_review6 = new Review(6, "15/01/2023", l_game1, 
				"le jeu est vraiment pas cool", l_user2, "", 12, (float)0.5);
		Review l_review7 = new Review(7, "15/01/2023", l_game4, 
				"le jeu est vraiment trop cool", l_user3, "", 12, (float)4.5);
		reviews.add(l_review1);
		reviews.add(l_review2);
		reviews.add(l_review3);
		reviews.add(l_review4);
		reviews.add(l_review5);
		reviews.add(l_review6);
		reviews.add(l_review7);
		
		AddRequest l_add_request1 = new AddRequest(1, "15/01/2023", "Overwatch2", l_user3, "en attente");
		AddRequest l_add_request2 = new AddRequest(2, "15/01/2023", "Valorant", l_user2, "en attente");
		AddRequest l_add_request3 = new AddRequest(3, "15/01/2023", "Apex Legend", l_user4, "en attente");
		AddRequest l_add_request4 = new AddRequest(4, "15/01/2023", "COD", l_user2, "en attente");
		AddRequest l_add_request5 = new AddRequest(5, "15/01/2023", "MineCraft", l_user3, "en attente");
		AddRequest l_add_request6 = new AddRequest(6, "15/01/2023", "Rocket League", l_user3, "en attente");
		add_requests.add(l_add_request1);
		add_requests.add(l_add_request2);
		add_requests.add(l_add_request3);
		add_requests.add(l_add_request4);
		add_requests.add(l_add_request5);
		add_requests.add(l_add_request6);
		
		
	}
	
	public Vector<User> getUsers() {
		return this.users;
	}
	
	public User getUserById(int p_id) {
		User l_user = null;
		
		for(User i: this.users) {
			if(p_id == i.getId()) {
				l_user = i;
				break;
			}
		}
		
		return l_user;
	}

	public void setUsers(Vector<User> p_users) {
		this.users = p_users;
	}
	
	//meant to be removed when bdd ready
	public void removeUser(User p_user) {
		int l_id_user = p_user.getId();
		for (int i=0; i< users.size(); i++) {
			if(l_id_user == users.get(i).getId()) {
				users.remove(i);
				break;
			}
		}
		
	}
	
	public Vector<Game> getGames(){
		return this.games;
	}
	
	public Game getGameById(int p_id) {
		Game l_game = null;
		
		for(Game i: this.games) {
			if(p_id == i.getId()) {
				l_game = i;
				break;
			}
		}
		
		return l_game;
	}
	
	public void setGames(Vector<Game> p_games) {
		this.games = p_games;
	}
	
	//meant to be removed when bdd ready
	public void removeGame(Game p_game) {
		int l_id_game = p_game.getId();
		for (int i=0; i< games.size(); i++) {
			if(l_id_game == games.get(i).getId()) {
				games.remove(i);
				break;
			}
		}
		
	}
	
	//meant to be removed when bdd ready
	public void addGame(Game p_game) {
		this.games.add(p_game);
	}
	
	public int getLastIndexGame() {
		int l_last_index = 0;
		for (int i=0; i< games.size(); i++) {
			if(l_last_index < games.get(i).getId()) {
				l_last_index = games.get(i).getId();
			}
		}
		return l_last_index;
	}
	
	public Vector<Review> getReviews(){
		return this.reviews;
	}
	
	public Vector<Review> getReviewForAUser(User p_user){
		Vector<Review> l_review_filtred = new Vector<Review>();
		
		for (int i=0; i< reviews.size(); i++) {
			if(p_user.getId() == reviews.get(i).getUser().getId()) {
				l_review_filtred.add(reviews.get(i));
			}
		}
		
		return l_review_filtred;
	}
	
	public Vector<Review> getReviewForAGame(Game p_game){
		Vector<Review> l_review_filtred = new Vector<Review>();
		
		for (int i=0; i< reviews.size(); i++) {
			if(p_game.getId() == reviews.get(i).getGame().getId()) {
				l_review_filtred.add(reviews.get(i));
			}
		}
		
		return l_review_filtred;
	}
	
	public void setReviews(Vector<Review> p_reviews) {
		this.reviews = p_reviews;
	}
	
	// meant to be removed when bdd ready
	public void removeReview(Review p_review) {
		int l_id_review = p_review.getId();
		for (int i=0; i< reviews.size(); i++) {
			if(l_id_review == reviews.get(i).getId()) {
				reviews.remove(i);
				break;
			}
		}
		
	}
	
	public Vector<AddRequest> getAddRequests(){
		return this.add_requests;
	}
	
	public void setAddRequests(Vector<AddRequest> p_add_requests) {
		this.add_requests = p_add_requests;
	}
	
	// meant to be remove when bdd ready
	public void validateAddRequest(AddRequest p_add_request) {
		for(int i=0; i< this.add_requests.size(); i++) {
			if(p_add_request.getId() == add_requests.get(i).getId()) {
				add_requests.get(i).setSatus("validated");
			}
		}
	}
	
	// meant to be remove when bdd ready
	public void declineAddRequest(AddRequest p_add_request) {
		for(int i=0; i< this.add_requests.size(); i++) {
			if(p_add_request.getId() == add_requests.get(i).getId()) {
				add_requests.get(i).setSatus("declined");
			}
		}
	}
	
	
}
