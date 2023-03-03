package ptd.model.table;

import ptd.model.player.Player;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;

public class Table {
	
	private int table_id;
	private int max_capacity;
	private HashMap<Integer, Player> pokerTable;
	
	Table() {
		this.pokerTable = new HashMap<Integer, Player>();
	}
	
	public Table(int tID, int nbplayers) {
		this.setTable_id(tID);
		this.pokerTable = new HashMap<Integer, Player>();
		this.setTable_MaxCapacity(nbplayers);
	}
	
	public Table(int tID, int nbplayers, Player[] players) {
		this.setTable_id(tID);
		this.pokerTable = new HashMap<Integer, Player>();
		this.setTable_MaxCapacity(nbplayers);
		this.fillTable(players);		
	}
	
	private void init_pokerTable() {
		for(int i=1; i <= this.getTable_MaxCapacity(); i++) {
			this.pokerTable.put(i, null);
		}
	}
	
	public void fillTable(Player[] players) {
		if(players.length > 0 && players.length <= this.getTable_MaxCapacity()) {
			for(int i=0; i < players.length; i++) {
				this.pokerTable.replace(i+1,players[i]);
			}
		}
	}
	
	public int addPlayer(int position, Player player) {
		int return_value = -1;
		if(this.pokerTable.containsValue(player)) 
			return_value = -2;
		else {
			if(this.pokerTable.containsKey(position)) {
				if(this.pokerTable.get(position) == (Player)null) {
					this.pokerTable.replace(position,player);
					return_value = position;
				} else 
					return_value = 0;
			}
		}
		return return_value;
	}
	
	public int removePlayer(Player player) {
		int position = -1;
		for(Entry<Integer, Player> entry : this.pokerTable.entrySet()) {
			if(entry.getValue().equals(player))
				position = entry.getKey();
		}
		if(position > 0) 
			this.pokerTable.replace(position,null);
		
		return position;
	}
	
	public boolean checkTable() {
		boolean noDuplicate = true;
		HashSet<Player> players = new HashSet<Player>(this.pokerTable.values());
		if(players.size() != this.pokerTable.size()) 
			noDuplicate = false;
		return noDuplicate;
	}

	public int getTable_id() {
		return table_id;
	}

	public void setTable_id(int tID) {
		this.table_id = tID;
	}

	public int getTable_MaxCapacity() {
		return max_capacity;
	}

	public void setTable_MaxCapacity(int maxPlayersPer) {
		this.max_capacity = maxPlayersPer;
		this.init_pokerTable();
	}
	
	HashMap<Integer, Player> getTable_players() {
		return pokerTable;
	}
	
	public int getTable_HashMapSize() {
		return pokerTable.size();
	}
	
	public String getTable_display() {
		return this.pokerTable.toString();
	}

	public String toString_JSON() {
		String pokerTable_JSON = "{ number : " + this.getTable_id() + ", seats : [";
		for(Entry<Integer, Player> entry : this.pokerTable.entrySet()) {
			pokerTable_JSON += "{ position : " + entry.getKey() + ", player : ";
			if(entry.getValue() != null) {
				pokerTable_JSON += entry.getValue().toString_JSON();
			}
			pokerTable_JSON += ((Integer)entry.getKey() == this.getTable_MaxCapacity()) ? "}" : "},";
		}
		pokerTable_JSON += "]}}";
		return pokerTable_JSON;
	}
}
