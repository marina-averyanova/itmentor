package com.maveryanova.itmentor.lesson2.task1;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(-100500, 100500 + 1);
    }
}
