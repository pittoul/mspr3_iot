/*
 * Nous faisons ici des tests unitaires avec 2 libraries différentes afin de comparer nos résultats.
 * On s'aperçoit ainsi que la lecture de ASSERTJ est plus évidente dans le code
 */
package mspr.iot;

import mspr.iot.Thanos;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Bruno
 */
public class ThanosTest {

    @Test
    void initThanos0pierre() { // on va ici tester le constructeur (c pour ca qu'il n'est pas dans Arrange !)
        // Arrange
        int nbPierre = 0;

        // Act
        Thanos sut = new Thanos(nbPierre);

        // Assert (valeur souhaitee, valeur trouvee)
        assertEquals(0, sut.getNbPierreInfinite(), "message lu en cas d'erreur");
        assertFalse(sut.isMissionReussi());

        // Avec la library ASSERTJ
        assertThat(sut.getNbPierreInfinite()).isEqualTo(nbPierre);

    }

    @Test
    void gagnePierre() {
        // Arrange
        int nbPierre = 5;
        Thanos sut = new Thanos(nbPierre);

        // Act
        sut.gagnePierre();

        // Assert
        assertEquals(5, sut.getNbPierreInfinite());

        // Avec la library ASSERTJ
        assertThat(sut.getNbPierreInfinite()).isEqualTo(nbPierre);
    }

    // FONCTION A DECORTIQUER ;)
    @RepeatedTest(6)
    void testGagnePlusDe5Pierres(RepetitionInfo testInfo) {
        Thanos sut = new Thanos(testInfo.getCurrentRepetition() - 1);

        sut.gagnePierre();

        assertTrue(sut.getNbPierreInfinite() - 1 < 5);

        if (testInfo.getCurrentRepetition() - 1 < 5) {
            assertEquals(testInfo.getCurrentRepetition(), sut.getNbPierreInfinite());
        } else {
            assertEquals(5, sut.getNbPierreInfinite());
        }
    }

    @Test
    void testerClaquementDeDoigt() {
        // Arrange
        Thanos sut = new Thanos(5);

        // Act
        int result = sut.claquementDeDoigts(7700000);

        // Assert
        assertEquals(7700000 / 2, result);
    }

    @Test
    void testerToString() {
        // Arrange
        Thanos sut = new Thanos(0);

        // Act
        String result = sut.toString();

        // Assert
        assertEquals("Thanos [nbPierreInfinite=0, missionReussi=false]", result);
    }

    @Test
    void egaliteDesThanos() {
        // Arrange

        // Act
        Thanos t1 = new Thanos(0);
        Thanos t2 = new Thanos(0);

        // Assert
        // Lorsque la methode equals (qui se trouve dans la classe Thanos) n'a pas été générée, le test ne fonctionne pas
        assertEquals(t1, t2);

        // AssertJ
        assertThat(t1).hasSameClassAs(t2);
    }
}
