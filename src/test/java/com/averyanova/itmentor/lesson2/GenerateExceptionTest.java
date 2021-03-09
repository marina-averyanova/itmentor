package com.averyanova.itmentor.lesson2;

import com.maveryanova.itmentor.lesson2.task1.Task1;
import org.junit.jupiter.api.Test;

public class GenerateExceptionTest {
    private final Task1 task1 = new Task1();

    @Test
    public void nullPointerTest() throws Exception {
        try {
            task1.generateException(1);
        } catch (NullPointerException np) {
            System.out.println(np);
        }
    }

    @Test
    public void arrayIndexOutOfBoundsExceptionTest() throws Exception {
        try {
            task1.generateException(2);
        } catch (ArrayIndexOutOfBoundsException ao) {
            System.out.println(ao);
        }
    }

    @Test
    public void otherExceptionTest() {
        try {
            task1.generateException(42);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
