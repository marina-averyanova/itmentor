package com.maveryanova.itmentor.lesson3.task2;

import java.util.HashMap;
import java.util.Map;

// Создать класс ObjectBox, который будет хранить коллекцию Object.
//• У класса должен быть метод addObject, добавляющий объект в коллекцию.
//• У класса должен быть метод deleteObject, проверяющий наличие объекта в коллекции и при наличии удаляющий его.
//• Должен быть метод dump, выводящий содержимое коллекции в строку.
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
        System.out.println(res);
    }

    // NOTE for testing
    public String print() {
        StringBuilder res = new StringBuilder();
        for (Object obj: objects.values()) {
            res.append(obj.toString()).append(", ");
        }
        return res.substring(0, res.length() - 2);
    }

    public Map<T, T> getObjects() {
        return objects;
    }
}
