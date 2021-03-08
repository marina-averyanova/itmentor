package com.averyanova.algorithms;

import com.maveryanova.itmentor.lesson2.task2.Task2;
import org.junit.jupiter.api.Test;

public class SquareRootTest {
    private final Task2 task2 = new Task2();

    @Test
    public void squareRootsTest() {
        int[] arr = new int[] {1, 2, 4, 0, -1};
        try {
            task2.doSquarePower(arr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
