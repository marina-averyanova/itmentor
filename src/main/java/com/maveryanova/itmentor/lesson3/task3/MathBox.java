package com.maveryanova.itmentor.lesson3.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
// Необходимо сделать такую связь, правильно распределить поля и методы.
// Функциональность в целом должна сохраниться.
// При попытке положить Object в MathBox должно создаваться исключение.
public class MathBox extends ObjectBox<Number> {

    public MathBox(Number[] numbers) throws Exception {
        for (Number number: numbers) {
            addObject(number);
        }
    }

    public Double summator() {
        double sum = 0;
        for (Number num: objects.values()) {
            sum = sum + num.doubleValue();
        }
        return sum;
    }

    public void splitter(int delimiter) {
        Map<Number, Number> newValues = new HashMap<>();
        for (Number number : objects.values()) {
            double newValue = number.doubleValue() / delimiter;
            newValues.put(newValue, newValue);
        }
        objects = newValues;
    }

    public void remove(Integer value) {
        deleteObject(value);
    }

    @Override
    public String print() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "MathBox{" +
            "values=" + objects.values() +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(objects, mathBox.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }
}
