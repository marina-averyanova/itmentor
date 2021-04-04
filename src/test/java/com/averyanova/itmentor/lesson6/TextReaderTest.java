package com.averyanova.itmentor.lesson6;

import com.maveryanova.itmentor.lesson6.task1.TextReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TextReaderTest {
    private static final String READER_DIR = "reader";
    private static final String PATH = "src/test/resources/" + READER_DIR;
    private final TextReader textReader = new TextReader();

    @Test
    public void readTextFileAndSortContentTest() throws IOException {
        boolean result = textReader.readTextFileAndSortContent(PATH, "text.txt");
        assertTrue(result);

        Path resultPath = Paths.get(PATH + "/" + "result.txt");

        List<String> expected  = Files.readAllLines(Paths.get(PATH + "/" + "expected.txt"));
        List<String> sortedResult  = Files.readAllLines(resultPath);

        assertEquals(expected.size(), sortedResult.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(sortedResult.get(i), expected.get(i));
        }

        Files.delete(resultPath);
    }
}
