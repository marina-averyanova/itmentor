package com.maveryanova.itmentor.lesson2.task2;

import com.maveryanova.itmentor.lesson2.task1.Randomizer;

public class Task2 {
    // 2. Составить программу, генерирующую N случайных чисел.
    // Для каждого числа k вычислить квадратный корень q.
    // Если квадрат целой части q числа равен k, то вывести это число на экран.
    // Предусмотреть что первоначальные числа могут быть отрицательные,
    // в этом случае генерировать исключение.

    private final Randomizer randomizer = new Randomizer();

    public void squareRoots(int n) throws Exception {
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = randomizer.getRandomNumber();
        }
        doSquarePower(arr);
    }

    public void doSquarePower(int[] arr) throws Exception {
        for (int j : arr) {
            if (j >= 0) {
                double q = Math.sqrt(j);
                if ((int) Math.pow((int) q, 2) == j) {
                    System.out.println(q);
                }
            } else {
                throw new Exception("element < 0");
            }
        }
    }
}
