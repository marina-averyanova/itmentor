package com.averyanova.itmentor.lesson3;

import com.maveryanova.itmentor.lesson3.task1.MathBox;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Task1Test {

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
}
