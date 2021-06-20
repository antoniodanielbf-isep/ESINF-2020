package esinf;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void sameStringTest() {
        assertEquals("Beatriz", Main.sameString("Beatriz"));
    }

    @Test
    void stringInverseOrderTest() {
        assertEquals("zirtaeB", Main.inverseString("Beatriz"));
    }

    @Test
    void findMaxTest() {
        int[] array = {0, 1, 2, 3, 4, 5};
        assertEquals(5, Main.findMax(array, 5));
    }

}