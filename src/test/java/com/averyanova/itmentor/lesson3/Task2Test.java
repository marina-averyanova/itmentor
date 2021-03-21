package com.averyanova.itmentor.lesson3;

import com.maveryanova.itmentor.lesson3.task2.ObjectBox;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    public void addObjectTest() throws Exception {
        ObjectBox<Error> objectBox = new ObjectBox<>();
        assertEquals(0, objectBox.getObjects().size());

        objectBox.addObject(new Error("test1"));
        objectBox.addObject(new Error("test2"));

        assertEquals(2, objectBox.getObjects().size());

        try {
            ObjectBox<Integer> objectBox2 = new ObjectBox<>();
            objectBox2.addObject(Integer.valueOf(1));
            objectBox2.addObject(Integer.valueOf(1));

        } catch (Exception e) {
            assertEquals("duplicate value", e.getMessage());
        }
    }

    @Test
    public void deleteObjectTest() throws Exception {
        ObjectBox<Error> objectBox = new ObjectBox<>();
        Error first = new Error("test1");
        Error second = new Error("test2");

        objectBox.addObject(first);
        objectBox.addObject(second);
        assertEquals(2, objectBox.getObjects().size());

        objectBox.deleteObject(first);
        assertEquals(1, objectBox.getObjects().size());
        assertEquals(second, objectBox.getObjects().get(second));
    }

    @Test
    // NOTE test dump using print which contains the same logic
    public void dumpTest() throws Exception {
        ObjectBox<Integer> objectBox = new ObjectBox<>();

        objectBox.addObject(Integer.valueOf(42));
        objectBox.addObject(Integer.valueOf(100500));

        assertEquals("100500, 42", objectBox.print());
    }
}
