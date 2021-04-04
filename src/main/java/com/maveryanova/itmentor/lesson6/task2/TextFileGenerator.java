package com.maveryanova.itmentor.lesson6.task2;

import com.maveryanova.itmentor.Randomizer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// 2. Создать генератор текстовых файлов, работающий по следующим правилам:
//• Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
//• Слово состоит из 1<=n2<=15 латинских букв
//• Слова разделены одним пробелом
//• Предложение начинается с заглавной буквы
//• Предложение заканчивается (.|!|?)+" "
//• Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
// В конце абзаца стоит разрыв строки и перенос каретки.
// Необходимо написать метод getFiles(String path, int n, int size, String[] words),
// который создаст n файлов размером size в каталоге path. words - массив слов.
// *** Условие с массивом слов заменено на генерацию слова из латиницы
public class TextFileGenerator {
    private static final int WORD_MIN_CHARS = 1;
    private static final int WORD_MAX_CHARS = 15;
    private static final int SENTENCE_MIN_CHARS = 2;
    private static final int SENTENCE_MIN_WORDS = 1;
    private static final int SENTENCE_MAX_WORDS = 15;
    private static final int PARAGRAPH_MIN_CHARS = 3;
    private static final int PARAGRAPH_MIN_SENTENCES = 1;
    private static final int PARAGRAPH_MAX_SENTENCES = 20;
    private static final String EMPTY = "";
    private static final String[] SEPARATORS = new String[] {" ", ","};
    private static final String[] SENTENCE_END = new String[] {".", "!", "?"};
    private static final String PARAGRAPH_SEPARATOR = "\n";
    private static final String[] CHARS = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                                                        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private final Randomizer randomizer = new Randomizer();

    public boolean getFiles(String path, int n, int size) {
        if (size < 3) {
            System.out.println("Size is small");
            return false;
        }

        for (int i = 0; i < n; i++) {
            try {
                String text = generateText(size);
                Files.writeString(Paths.get(formatPath(path, i)), text);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private String formatPath(String path, int number) {
        return path + "/" + number + ".txt";
    }

    public String generateText(int estimateBytes) {
        if (estimateBytes < PARAGRAPH_MIN_CHARS) {
            return EMPTY;
        }
        int currentEstimateBytes = estimateBytes;
        StringBuilder text = new StringBuilder();
        while (currentEstimateBytes > 0) {
            text.append(generateParagraph(currentEstimateBytes));
            currentEstimateBytes = estimateBytes - text.length();
        }
        return text.toString();
    }

    public String generateParagraph(int estimateBytes) {
        if (estimateBytes < PARAGRAPH_MIN_CHARS) {
            return EMPTY;
        }
        int size = randomizer.getRandomNumber(PARAGRAPH_MIN_SENTENCES, PARAGRAPH_MAX_SENTENCES);
        int currentEstimateBytes = estimateBytes;
        StringBuilder paragraph = new StringBuilder();
        while (size > 0 && currentEstimateBytes > 2) {
            // NOTE generate sentence, use "-1" because of appending separator
            paragraph.append(generateSentence(currentEstimateBytes - 1));
            currentEstimateBytes = estimateBytes - paragraph.length();
            size--;

            // NOTE append sentence separator if need
            if (size != 0 && currentEstimateBytes > PARAGRAPH_MIN_CHARS) {
                paragraph.append(SEPARATORS[0]);
                currentEstimateBytes = estimateBytes - paragraph.length();
            }
        }
        return paragraph.append(PARAGRAPH_SEPARATOR).toString();
    }

    public String generateSentence(int estimateBytes) {
        if (estimateBytes < SENTENCE_MIN_CHARS) {
            return EMPTY;
        }
        int size = randomizer.getRandomNumber(SENTENCE_MIN_WORDS, SENTENCE_MAX_WORDS);
        int currentEstimateBytes = estimateBytes;
        StringBuilder sentence = new StringBuilder();
        while (size > 0 && currentEstimateBytes > 1) {
            // NOTE generate word, use "-1" because of appending separator
            sentence.append(generateWord(currentEstimateBytes - 1));
            currentEstimateBytes = estimateBytes - sentence.length();
            size--;

            // NOTE generate comma if the position fits
            if (size > 0 && currentEstimateBytes > 3) {
                sentence.append(generateComma());
                currentEstimateBytes = estimateBytes - sentence.length();
            }

            // NOTE append word separator if need
            if (size != 0 && currentEstimateBytes > SENTENCE_MIN_CHARS) {
                sentence.append(SEPARATORS[0]);
                currentEstimateBytes = estimateBytes - sentence.length();
            }
        }
        // NOTE append sentence end
        sentence.append(getSentenceEnd());
        return sentence.replace(0, 1, Character.toString(sentence.charAt(0)).toUpperCase()).toString();
    }

    private String generateWord(int maxLength) {
        if (maxLength < WORD_MIN_CHARS) {
            return EMPTY;
        }
        int size = randomizer.getRandomNumber(WORD_MIN_CHARS, Math.min(maxLength, WORD_MAX_CHARS));
        String[] word = new String[size];
        for (int i = 0; i < size; i++) {
            String ch = CHARS[randomizer.getRandomNumber(1, 25)];
            word[i] = ch;
        }

        return String.join(EMPTY, word);
    }

    private String generateComma() {
        return Math.random() > 0.9 ? SEPARATORS[1] : EMPTY;
    }

    private String getSentenceEnd() {
        int index = randomizer.getRandomNumber(0, 2);
        return SENTENCE_END[index];
    }
}
