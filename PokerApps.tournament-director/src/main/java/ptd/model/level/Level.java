package ptd.model.level;

public class Level {
	
	private int level_id;
	private int duration;
	private int small_blind;
	private int big_blind;
	
	//private enum Ante { NONE, ALL, BTN, BB };
	private int ante_amount;
	
	Level() {}

	public Level(int lID, int timer, int sb_amt, int bb_amt, int ante_amt) {
		this.setLevel_id(lID);
		this.setLevel_duration(timer);
		this.setLevel_smallblind(sb_amt);
		this.setLevel_bigblind(bb_amt);
		this.setLevel_anteamount(ante_amt);
	}
	
	public Level(int timer, int sb_amt, int bb_amt, int ante_amt) {
		this.setLevel_duration(timer);
		this.setLevel_smallblind(sb_amt);
		this.setLevel_bigblind(bb_amt);
		this.setLevel_anteamount(ante_amt);
	}
	
	public Level(int timer, int sb_amt, int bb_amt) {
		this.setLevel_duration(timer);
		this.setLevel_smallblind(sb_amt);
		this.setLevel_bigblind(bb_amt);
	}
	
	public Level(int timer, int ante_amt) {
		this.setLevel_duration(timer);
		this.setLevel_anteamount(ante_amt);
	}

	public int getLevel_id() {
		return level_id;
	}

	public void setLevel_id(int lid) {
		this.level_id = lid;
	}

	public int getLevel_duration() {
		return duration;
	}

	public void setLevel_duration(int timer) {
		this.duration = timer;
	}

	public int getLevel_smallblind() {
		return small_blind;
	}

	public void setLevel_smallblind(int sb_amount) {
		this.small_blind = sb_amount;
	}

	public int getLevel_bigblind() {
		return big_blind;
	}

	public void setLevel_bigblind(int bb_amount) {
		this.big_blind = bb_amount;
	}

	public int getLevel_anteamount() {
		return ante_amount;
	}

	public void setLevel_anteamount(int ante_amt) {
		this.ante_amount = ante_amt;
	}

	@Override
	public String toString() {
		return "Level [level_id =" + this.getLevel_id() 
				+ ", duration =" + this.getLevel_duration() 
				+ ", small_blind =" + this.getLevel_smallblind()
				+ ", big_blind =" + this.getLevel_bigblind() 
				+ ", ante_amount =" + this.getLevel_anteamount() + "]";
	}
	
	public String toString_JSON() {
		String level_JSON = this.toString().replaceAll("=",":").replaceAll("Level [", "level : {").replaceAll("]", "}");
		return level_JSON;
	}
	
}
