package mspr.iot;

import mspr.iot.Maison;
import mspr.iot.Poudlard;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Bruno
 */
public class PoudlardTest {

    @Test
    @DisplayName("Test de l'initialisation du biniou : ")
    void testInitialisation() {
        // Arrange
        int nbreMaisons = 4;

        // Act
        Poudlard sut = new Poudlard();

        Map v = sut.getMaisonsEleves();
        //System.out.println(v);
        // sut.inscriptionEleve("Michel", Maison.Griffondor); // permet de mettre le test en echec

        // AssertJ
        assertThat(v.size()).isEqualTo(nbreMaisons);  // on verifie la taille de la Map

        // for (Maison m : sut.maisonsEleves.keySet()) {
        for (Maison m : sut.maisonsEleves.keySet()) {
            assertThat(sut.maisonsEleves.get(m)).isNull();
            // System.out.println(sut.maisonsEleves.get(m));
        }
    }

    @Test
    @DisplayName("Test de la Fonction d'inscription d'un élève : ")
    void testerInscriptionEleve() {

        //Arrange
        Poudlard sut = new Poudlard();
        Maison s = Maison.Serpentard;

        //Act
        sut.inscriptionEleve("Lucius Malefoy", Maison.Serpentard);
        List result = sut.maisonsEleves.get(s);
        String r = (String) result.get(0);

        //AssertJ
        System.out.println(r);
        assertThat(r).isEqualTo("Lucius Malefoy");

    }

    @Test
    @DisplayName("Test de l'arrivée des Héros : ")
    void testerArriveDesHeros() {

        // Arrange
        Poudlard sut = new Poudlard();
        Maison s = Maison.Griffondor;

        // Act
        sut.inscriptionEleve("Harry Potter", s);
        sut.inscriptionEleve("Ron Whisley", s);
        sut.inscriptionEleve("Hermionne Granger", s);
        List result = sut.maisonsEleves.get(s);
        String r = result.toString();
        System.out.println(r);
        String v = "Harry Potter, Ron Whisley, Hermionne Granger";

        // AssertJ
        assertThat(r).containsSequence(v);
    }

}
