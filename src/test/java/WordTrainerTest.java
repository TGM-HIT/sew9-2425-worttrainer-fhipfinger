import org.fhipfinger.model.WordImage;
import org.fhipfinger.model.WordTrainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * WordTrainerTest class
 * It tests the functionalities of the WordTrainer class
 */
public class WordTrainerTest {
    private WordTrainer wordTrainer;

    @BeforeEach
    void setup() {
        wordTrainer = new WordTrainer();
    }

    @Test
    @DisplayName("Test checkInput method")
    void WordTrainerCheckInput() {
        wordTrainer.setWordImageList(Arrays.asList(
                new WordImage("baum", "https://cdn.pixabay.com/photo/2016/03/31/19/23/plant-1294971_1280.png"),
                new WordImage("apfel", "https://upload.wikimedia.org/wikipedia/commons/a/ad/Apfel-Piktogramm.png")
        ));
        wordTrainer.getRandomWordImage();
        wordTrainer.checkInput("baum");
        wordTrainer.checkInput("apfel");

        assertEquals(2, wordTrainer.getTotalAttempts());
        assertEquals(1, wordTrainer.getCorrectAttempts());
    }

    @Test
    @DisplayName("Test setTotalAttempts method")
    void setTotalAttemptsMethod() {
        assertThrows(IllegalArgumentException.class, () -> {
            wordTrainer.setTotalAttempts(-1);
        });
    }

    @Test
    @DisplayName("Test setCorrectAttempts method")
    void setCorrectAttemptsMethod() {
        assertThrows(IllegalArgumentException.class, () -> {
            wordTrainer.setCorrectAttempts(-1);
        });
    }

    @Test
    @DisplayName("Test setWordImageList")
    void setWordImageList() {
        assertThrows(IllegalArgumentException.class, () -> {
            wordTrainer.setWordImageList(new ArrayList<>());
        });
    }
}
