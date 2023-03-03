package ptd.model.table;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Table_UnitTest {

	private final int maxPlayers_table = 10;
	
	private Table table_test;
	
	@BeforeEach
	public void init_Table() {
		System.out.println("Table_UnitTest - Call before each test");
		table_test = new Table();
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
	
	@ParameterizedTest(name = "A Table id [{0}] must be a positive number")
	@ValueSource(ints = { -2, 0, 5, 123 })
	public void invalidValueOf_ID(int arg1) {
		// Arrange
		
		// Act
		table_test.setTable_id(arg1);
		
		// Assert
		assertTrue(table_test.getTable_id() > 0);
	}
	
	@ParameterizedTest(name = "A Table capacity [{0}] must be from 1 to 10 seats")
	@ValueSource(ints = { -2, 0, 6, 123})
	public void invalidValueOf_maxCapacity(int arg1) {
		// Arrange
		
		// Act
		table_test.setTable_MaxCapacity(arg1);
		
		// Assert
		assertTrue(table_test.getTable_MaxCapacity() > 0 &&
				   table_test.getTable_MaxCapacity() < this.maxPlayers_table);
	}	
	
	@ParameterizedTest(name = "A Table capacity [{0}] must match with the number of seats")
	@ValueSource(ints = { 0, 2, 4, 6, 9, 10, 15 })
	public void invalidValueOf_pokerTable(int arg1) {
		// Arrange
		this.table_test.setTable_MaxCapacity(arg1);
		
		// Act
		boolean noplayers = true;
		int i = 1;
		while(noplayers == true && i <= this.maxPlayers_table) {
			if(this.table_test.getTable_players().get(i) != null) 
				noplayers = false;
			i++;				
		}
		
		// Assert
		assertTrue(table_test.getTable_HashMapSize() > 0
				&& table_test.getTable_HashMapSize() <= this.maxPlayers_table
				&& table_test.getTable_HashMapSize() == arg1
				&& noplayers == true);
	}
}
