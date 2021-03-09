package com.maveryanova.itmentor;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
