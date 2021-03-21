package com.maveryanova.itmentor.lesson3.task3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Доработать классы MathBox и ObjectBox таким образом, чтобы MathBox был наследником ObjectBox.
// Необходимо сделать такую связь, правильно распределить поля и методы.
// Функциональность в целом должна сохраниться.
// При попытке положить Object в MathBox должно создаваться исключение.
public class ObjectBox<T> {
    Map<T, T> objects = new HashMap<>();

    public void addObject(T obj) throws Exception {
        if (objects.get(obj) == null) {
            objects.put(obj, obj);
        } else {
            throw new Exception("duplicate value");
        }
    }

    public void deleteObject(T obj) {
        objects.remove(obj);
    }

    public void dump() {
        StringBuilder res = new StringBuilder();
        for (Object obj: objects.values()) {
            res.append(obj.toString());
        }
        System.out.println(res.substring(0, res.length() - 2));
    }

    // NOTE for dump testing
    public String print() {
        StringBuilder res = new StringBuilder();
        for (Object obj: objects.values()) {
            res.append(obj.toString()).append(", ");
        }
        return res.substring(0, res.length() - 2);
    }

    public Set<T> getValues() {
        return new HashSet<>(objects.values());
    }
}
