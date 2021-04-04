package com.maveryanova.itmentor.lesson6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

// 1. Написать программу, читающую текстовый файл.
// Программа должна составлять отсортированный по алфавиту список слов, найденных в файле и сохранять его в файл-результат.
// Найденные слова не должны повторяться, регистр не должен учитываться. Одно слово в разных падежах – это разные слова.
public class TextReader {
    private final String CHARS = "[A-Za-zА-Яа-я-]";
    public boolean readTextFileAndSortContent(String path, String fileName) {
        String content;
        try {
           content  = new String(Files.readAllBytes(Paths.get(path + "/" + fileName)));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        String result = Arrays.stream(content.split(" |([!.,:;?]) "))
            .map(this::clean)
            .filter(w -> w.length() > 0)
            .map(String::toLowerCase)
            .collect(Collectors.toSet())
            .stream().sorted()
            .collect(Collectors.joining("\n"));

        try {
            Files.writeString(Paths.get(path + "/result.txt"), result);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String clean(String word) {
        return Arrays.stream(word.split(""))
            .filter(ch -> ch.matches(CHARS))
            .collect(Collectors.joining(""));
    }
}
