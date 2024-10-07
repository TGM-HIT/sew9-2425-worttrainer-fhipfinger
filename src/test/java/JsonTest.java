import org.fhipfinger.model.WordImage;
import org.fhipfinger.model.WordTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    @Test
    void testLoad() {
        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.load();
        assertEquals(7, wordTrainer.getCorrectAttempts());
    }

    @Test
    void testSave() {
        WordTrainer wordTrainer = new WordTrainer();
        wordTrainer.setWordImageList(
                Arrays.asList(
                        new WordImage("baum", "https://cdn.pixabay.com/photo/2016/03/31/19/23/plant-1294971_1280.png"),
                        new WordImage("apfel", "https://upload.wikimedia.org/wikipedia/commons/a/ad/Apfel-Piktogramm.png")
                )
        );
        wordTrainer.setTotalAttempts(10);
        wordTrainer.setCorrectAttempts(7);
        wordTrainer.store();

        WordTrainer wordTrainer1 = new WordTrainer();
        wordTrainer1.load();

        assertEquals(10, wordTrainer1.getTotalAttempts());
        assertEquals(7, wordTrainer1.getCorrectAttempts());
        assertEquals("baum", wordTrainer1.getWordImageList().get(0).getWord());
    }
}
