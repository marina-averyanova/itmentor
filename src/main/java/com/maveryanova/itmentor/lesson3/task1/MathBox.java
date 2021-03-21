package com.maveryanova.itmentor.lesson3.task1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// Написать класс MathBox, реализующий следующий функционал:
// • Конструктор на вход получает массив Number. Элементы не могут повторяться.
// Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
// • Существует метод summator, возвращающий сумму всех элементов коллекции.
// • Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель,
// являющийся аргументом метода. Хранящиеся в объекте данные полностью заменяются результатами деления.
// • Необходимо правильно переопределить методы toString, hashCode, equals,
// чтобы можно было использовать MathBox для вывода данных на экран и хранение
// объектов этого класса в коллекциях (например, hashMap). Выполнение контракта обязательно!
// • Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
public class MathBox {
    Map<Number, Number> values = new HashMap<>();

    public MathBox(Number[] numbers) throws Exception {
        for (Number number: numbers) {
            if (values.get(number) == null) {
                values.put(number, number);
            } else {
                throw new Exception("duplicate value");
            }
        }
    }

    public Double summator() {
        double sum = 0;
        for (Number num: values.values()) {
            sum = sum + num.doubleValue();
        }
        return sum;
    }

    public void splitter(int delimiter) {
        Map<Number, Number> newValues = new HashMap<>();
        for (Number number : values.values()) {
            double newValue = number.doubleValue() / delimiter;
            newValues.put(newValue, newValue);
        }
        values = newValues;
    }

    public void remove(Integer value) {
        if (values.get(value) != null && value.equals(values.get(value).intValue())) {
            values.remove(value);
        }
    }

    public Set<Number> getValues() {
        return new HashSet<>(values.values());
    }

    public String print() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "MathBox{" +
            "values=" + values.values() +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(values, mathBox.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
