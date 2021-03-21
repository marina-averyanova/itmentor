package com.averyanova.itmentor.lesson3;

import com.maveryanova.itmentor.lesson3.task3.ObjectBox;
import com.maveryanova.itmentor.lesson3.task3.MathBox;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    public void createMathBoxTest() throws Exception {
        Number[] arr = new Number[] {1, 2, 4, 0, -1.25};
        MathBox mathBox = new MathBox(arr);

        assertEquals(Set.of(1, 2, 4, 0, -1.25), mathBox.getValues());

        try {
            new MathBox(new Number[] {1, 1});
        } catch (Exception e) {
            assertEquals("duplicate value", e.getMessage());
        }
    }

    @Test
    public void summatorTest() throws Exception {
        Number[] arr = new Number[] {1, 2, 4, 0, -1.25};
        MathBox mathBox = new MathBox(arr);

        assertEquals(5.75, mathBox.summator());
    }

    @Test
    public void splitterTest() throws Exception {
        Number[] arr = new Number[] {1, 2, 4, 0, -1.25};
        MathBox mathBox = new MathBox(arr);
        mathBox.splitter(2);

        assertEquals(Set.of(0.5, 1.0, 2.0, 0.0, -0.625), mathBox.getValues());
    }

    @Test
    public void removeTest() throws Exception {
        Number[] arr = new Number[] {1, 2, 4, 0, -1.25};
        MathBox mathBox = new MathBox(arr);

        mathBox.remove(100500);
        assertEquals(Set.of(1, 2, 4, 0, -1.25), mathBox.getValues());

        mathBox.remove(2);
        assertEquals(Set.of(1, 4, 0, -1.25), mathBox.getValues());
    }

    @Test
    public void toStringTest() throws Exception {
        Number[] arr = new Number[] {1, 2, 4, 0, -1.25};
        MathBox mathBox = new MathBox(arr);

        assertEquals("MathBox{values=[0, 1, 2, 4, -1.25]}", mathBox.print());
    }

    @Test
    public void collectionTest() throws Exception {
        Number[] arr = new Number[] {1, 2};
        MathBox mathBox1 = new MathBox(arr);
        MathBox mathBox2 = new MathBox(arr);

        Map<MathBox, MathBox> mapOfMathBoxes = new HashMap<>();
        mapOfMathBoxes.put(mathBox1, mathBox1);
        mapOfMathBoxes.put(mathBox2, mathBox2);

        assertEquals(mathBox1, mapOfMathBoxes.get(mathBox1));
        assertEquals(mathBox2, mapOfMathBoxes.get(mathBox2));
        assertEquals(1, mapOfMathBoxes.size());
    }

    @Test
    public void addObjectTest() throws Exception {
        ObjectBox<Error> objectBox = new ObjectBox<>();
        assertEquals(0, objectBox.getValues().size());

        objectBox.addObject(new Error("test1"));
        objectBox.addObject(new Error("test2"));

        assertEquals(2, objectBox.getValues().size());

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
        assertEquals(2, objectBox.getValues().size());

        objectBox.deleteObject(first);
        assertEquals(1, objectBox.getValues().size());
        assertEquals(Set.of(second), objectBox.getValues());
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
