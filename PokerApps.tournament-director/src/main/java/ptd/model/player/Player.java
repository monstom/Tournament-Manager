package ptd.model.player;

public class Player {
	
	private int player_id;
	private String email; 
	private String firstname;
	private String lastname;
	private String pseudo;
	//private String creationTimestamp;
	//private boolean verified;
	//private String token;
	
	Player() {}
	
	public Player(int pID, String pEmail, String fname, String lname, String nickname) {
		this.setPlayer_id(pID);
		this.setPlayer_email(pEmail);
		this.setPlayer_firstname(fname);
		this.setPlayer_lastname(lname);
		this.setPlayer_pseudo(nickname);
	}
	
	public Player(String pEmail, String fname, String lname, String nickname) {
		this.setPlayer_email(pEmail);
		this.setPlayer_firstname(fname);
		this.setPlayer_lastname(lname);
		this.setPlayer_pseudo(nickname);
	}
	
	
	/* ======= FOR ALL SETTERS ======= */
	/* Exceptions and data type validation to be made at data input (controller part) */
	
	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int pid) {
		this.player_id = pid;
	}

	public String getPlayer_email() {
		return email;
	}

	public void setPlayer_email(String pmail) {
		this.email = pmail;
	}

	public String getPlayer_firstname() {
		return firstname;
	}

	public void setPlayer_firstname(String pfname) {
		this.firstname = pfname;
	}

	public String getPlayer_lastname() {
		return lastname;
	}

	public void setPlayer_lastname(String plname) {
		this.lastname = plname;
	}

	public String getPlayer_pseudo() {
		return pseudo;
	}

	public void setPlayer_pseudo(String pnickname) {
		this.pseudo = pnickname;
	}

	@Override
	public String toString() {
		return "Player [player_id =" + this.getPlayer_id()
				+ ", email =" + this.getPlayer_email()
				+ ", firstname =" + this.getPlayer_firstname()
				+ ", lastname ="+ this.getPlayer_lastname()
				+ ", pseudo =" + this.getPlayer_pseudo() + "]";
	}

	public String toString_JSON() {
		String player_JSON = this.toString().replaceAll("=",":").replaceAll("Player [", "{").replaceAll("]", "}");
		return player_JSON;
	}

}
