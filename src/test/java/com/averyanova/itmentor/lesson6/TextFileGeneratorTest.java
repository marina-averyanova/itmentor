package com.averyanova.itmentor.lesson6;

import com.maveryanova.itmentor.Randomizer;
import com.maveryanova.itmentor.lesson6.task2.TextFileGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TextFileGeneratorTest {
    private static final String GENERATOR_DIR = "generator";
    private static final String PATH = "src/test/resources/" + GENERATOR_DIR;
    private final Randomizer randomizer = new Randomizer();
    private final TextFileGenerator generator = new TextFileGenerator();

    @Test
    public void getFilesTest() throws IOException {
        int size = randomizer.getRandomNumber(3, 10000);
        boolean result = generator.getFiles(PATH, 5, size);
        assertTrue(result);

        for (int i = 0; i < 5; i++) {
            Path path = Paths.get(formatPath(i));
            String content = new String(Files.readAllBytes(path));
            assertEquals(size, content.length());
            Files.delete(path);
        }
    }

    @Test
    public void generateSentenceTest()  {
        for (int i = 0; i < 10000; i++) {
            int maxSize = randomizer.getRandomNumber(2, 1000);
            String sentence = generator.generateSentence(maxSize);

            assertTrue(sentence.length() <= maxSize);
            assertTrue(Character.isUpperCase(sentence.charAt(0)));

            String sentenceEnd = Character.toString(sentence.charAt(sentence.length() - 1));
            assertTrue(sentenceEnd.equals(".") || sentenceEnd.equals("!") || sentenceEnd.equals("?"));

            char sentencePreEnd = sentence.charAt(sentence.length() - 2);
            assertTrue(Character.isLowerCase(sentencePreEnd) || sentence.length() == 2);

            String[] words = sentence.split(" ");
            assertTrue(words.length <= 15);
        }
    }

    @Test
    public void generateParagraphTest() {
        for (int i = 0; i < 10000; i++) {
            int maxSize = randomizer.getRandomNumber(3, 10000);
            String paragraph = generator.generateParagraph(maxSize);

            assertTrue(paragraph.length() <= maxSize);

            String end = paragraph.substring(paragraph.length() - 1);
            assertEquals("\n", end);

            String[] sentences = paragraph.split("([!.?]) ");
            assertTrue(sentences.length <= 20);
        }
    }

    @Test
    public void generateTextTest() {
        for (int i = 0; i < 5; i++) {
            int maxSize = randomizer.getRandomNumber(3, 10000);
            String text = generator.generateText(maxSize);

            assertEquals(maxSize, text.length());

            String end = text.substring(text.length() - 1);
            assertEquals("\n", end);

            String[] paragraphs = text.split("\n");
            assertTrue(paragraphs.length >= 1);
        }
    }

    private String formatPath(int number) {
        return PATH + "/" + number + ".txt";
    }
}
