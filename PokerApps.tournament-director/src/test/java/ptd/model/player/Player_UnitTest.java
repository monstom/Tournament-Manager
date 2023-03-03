package ptd.model.player;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Player_UnitTest {
	
	private final int maxLength_string = 20;
	
	private Player player_test;
	
	@BeforeEach
	public void init_Player() {
		System.out.println("Player_UnitTest - Call before each test");
		player_test = new Player();
	}
	
	@AfterEach
	public void kill_Player() {
		System.out.println("Player_UnitTest - Call after each test");
		player_test = null;
	}
	
	@BeforeAll
	public static void init_PlayerTest() {
		System.out.println("Player_UnitTest - Start of the Player class' unite testing");
	}
	
	@AfterAll
	public static void kill_PlayerTest() {
		System.out.println("Player_UnitTest - End of the Player class' unite testing");
	}
	
	@ParameterizedTest(name = "A Player's ID must be a positive number")
	@ValueSource(ints = { -2, 0, 5, 123 })
	public void invalidValueOf_ID(int arg1) {
		// Arrange
		
		// Act
		player_test.setPlayer_id(arg1);
		
		// Assert
		assertTrue(player_test.getPlayer_id() > 0);
	}
	
	@ParameterizedTest(name = "Firstname param [{0}] must contains from 1 to 20 letters")
	@ValueSource(strings = { "", "Jean-Claude-Marie-Bertrand", "Thomas", "Daniel" })
	public void invalidValueOf_Firstname(String arg1) {
		// Arrange
		
		// Act
		player_test.setPlayer_firstname(arg1);
		
		// Assert
		assertTrue(!player_test.getPlayer_firstname().isBlank() 
				&& !player_test.getPlayer_firstname().isEmpty() 
				&& player_test.getPlayer_firstname().length() < this.maxLength_string);
	}

	@ParameterizedTest(name = "Lastname param [{0}] must contains from 1 to 20 letters")
	@ValueSource(strings = { "", "Dufleau-De La Montagne", "Boullé", "Negreanu" })
	public void invalidValueOf_Lastname(String arg1) {
		// Arrange
		
		// Act
		player_test.setPlayer_lastname(arg1);
		
		// Assert
		assertTrue(!player_test.getPlayer_lastname().isBlank() 
				&& !player_test.getPlayer_lastname().isEmpty() 
				&& player_test.getPlayer_lastname().length() < this.maxLength_string);
	}
	
	@ParameterizedTest(name = "Pseudo param [{0}] must contains from 1 to 20 letters")
	@ValueSource(strings = { "", "The world best poker to ever lived", "monstom", "Kid Poker" })
	public void invalidValueOf_Pseudo(String arg1) {
		// Arrange
		
		// Act
		player_test.setPlayer_pseudo(arg1);
		
		// Assert
		assertTrue(!player_test.getPlayer_pseudo().isBlank() 
				&& !player_test.getPlayer_pseudo().isEmpty() 
				&& player_test.getPlayer_pseudo().length() < this.maxLength_string);
	}
}
