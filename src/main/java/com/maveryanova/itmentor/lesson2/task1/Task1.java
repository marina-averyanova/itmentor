package com.maveryanova.itmentor.lesson2.task1;

public class Task1 {
    public void generateException(int exType) throws Exception {
        // 1. Написать программу ”Hello, World!”.
        // В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой:
        // Смоделировав ошибку «NullPointerException»
        // Смоделировав ошибку «ArrayIndexOutOfBoundsException»
        // Вызвав свой вариант ошибки через оператор throw

        if (exType == 1) {
            Object n = null;
            System.out.println(n.toString());
        } else if (exType == 2) {
            int[] arr = new int[1];
            System.out.println(arr[42]);
        } else {
            throw new Exception("42");
        }
    }
}
