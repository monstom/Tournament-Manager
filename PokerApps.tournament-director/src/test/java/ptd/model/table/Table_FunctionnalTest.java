package ptd.model.table;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ptd.model.player.Player;

public class Table_FunctionnalTest {
	
	private final int maxPlayers_table = 10;
	
	private Table table_test;
	
	private Player playertoAdd; 
	
	@BeforeEach
	public void init_Table() {
		System.out.println("Table_UnitTest - Call before each test");
		table_test = new Table();
		playertoAdd = new Player("t.boulle@icloud.com","Thomas","Boullé","monstom");
	}
	
	@AfterEach
	public void kill_Table() {
		System.out.println("Table_UnitTest - Call after each test");
		table_test = null;
	}
	
	@BeforeAll
	public static void init_TableTest() {
		System.out.println("Table_UnitTest - Start of the Table class' unite testing");
	}
	
	@AfterAll
	public static void kill_TableTest() {
		System.out.println("Table_UnitTest - End of the Table class' unite testing");
	}
	
	
	@Test
	@Order(value = 1)
	public void invalidBehaviorOf_fillTable() {
		// Arrange
		Player dnegs = new Player("dnegs@gmail.com","Daniel","Negreanu","Kid Poker");
		Player brat = new Player("itsphil@gmail.com","Phil","Hellmuth","Poker Brat");
		Player dolly = new Player("doylerooms@gmail.com","Doyle","Brunson","Texas Dolly");
		
		Player[] players = new Player[3];
		players[0] = dnegs;
		players[1] = brat;
		players[2] = dolly;
		
		this.table_test.setTable_MaxCapacity(maxPlayers_table);
		
		// Act
		boolean placed = true;
		this.table_test.fillTable(players);
		int j = 0;
		while(placed == true && j < players.length) {
			if(!this.table_test.getTable_players().get(j+1).equals(players[j])) 
				placed = false;
			j++;
		}
		System.out.println(table_test.getTable_display());
		
		// Assert
		assertTrue(placed == true);
	}
	
	
	@ParameterizedTest(name = "A player must be put in a valid empty seat of the table")
	@ValueSource(ints = { -2, 0, 123, 1, 5 })
	@Order(value = 2) 
	public void invalidBehaviorOf_addPlayer(int arg1) {
		// Arrange
		
		// Act
		int return_value = this.table_test.addPlayer(arg1, this.playertoAdd);
		System.out.println(return_value);
		System.out.println(table_test.getTable_display());
		
		// Assert
		assertTrue(return_value == arg1);
	}
	
	
	@Test
	@Order(value = 3)
	public void invalidBehaviorOf_tableOrganization() {
		// Arrange
		
		// Act
		//int return_value = table_test.addPlayer(10, this.playertoAdd);
		boolean validTable = true;
		//if(return_value > 0)
			validTable = this.table_test.checkTable();
		System.out.println(validTable);
		System.out.println(table_test.getTable_display());
		
		// Assert
		assertTrue(validTable == true);
	}
	
	
	@Test
	@Order(value = 4)
	public void invalidBehaviorOf_removePlayer() {
		// Arrange
		
		// Act
		int return_value = table_test.removePlayer(this.playertoAdd);
		System.out.println(return_value);
		System.out.println(table_test.getTable_display());
		
		// Assert
		assertTrue(return_value == 5);
	}
}
