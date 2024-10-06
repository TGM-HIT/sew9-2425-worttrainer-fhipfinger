import org.fhipfinger.model.WordImage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WordImageTest class
 * It tests the use-cases of the WordImage class
 */
public class WordImageTest {
    @Test
    @DisplayName("Test WordImage creation")
    void testWordImageCreation() {
        WordImage wordImage = new WordImage("baum", "https://cdn.pixabay.com/photo/2016/03/31/19/23/plant-1294971_1280.png");
        assertEquals("baum", wordImage.getWord());
        assertEquals("https://cdn.pixabay.com/photo/2016/03/31/19/23/plant-1294971_1280.png", wordImage.getUrl());
    }

    @Test
    @DisplayName("Test WordImage creation without a word")
    void testWordImageCreationWithoutAWord() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("","https://cdn.pixabay.com/photo/2016/03/31/19/23/plant-1294971_1280.png");
        });
    }

    @Test
    @DisplayName("Test WordImage creation without a url")
    void testWordImageCreationWithoutAURL() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("baum","");
        });
    }

    @Test
    @DisplayName("Test WordImage creation with a invalid url")
    void testWordImageCreationInvalidURL() {
        assertThrows(IllegalArgumentException.class, () -> {
            WordImage wordImage = new WordImage("baum","test123");
        });
    }
}
