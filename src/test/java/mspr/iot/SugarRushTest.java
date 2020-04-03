package mspr.iot;

import mspr.iot.Joueur;
import mspr.iot.SugarRush;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SugarRushTest {

	@Test
	void testSelectionJoueur() {
		
		SugarRush rush= new SugarRush();
		
		assertEquals(new Joueur("Sa sucrerie"), rush.selectionJoueur("Sa sucrerie"));
		assertNull(rush.selectionJoueur("Ralph"));		
		assertEquals(new Joueur("Vaneloppe"), rush.selectionJoueur("Vaneloppe"));
	}

}
