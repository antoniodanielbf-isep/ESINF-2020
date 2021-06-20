import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testCalcSumTest() {
        assertEquals(3, Main.calcSum(1, 2));
    }

    @Test
    void convertTintegerToBinaryTest() {
        assertEquals("100", Main.convertIntegerBinary(4));
    }

    @Test
    void calcFactorialTest() {
        assertEquals(6, Main.calcFactorial(3));
    }

    @Test
    void calcDifferenceTest() {
        assertEquals(2, Main.calcDifference(3, 5));
    }

    @Test
    void calcProductTest() {
        assertEquals(15, Main.calcProduct(3, 5));
    }

    @Test
    void checkIfIsPrimeTest() {
        assertEquals(true, Main.checkIfIsPrime(5));
    }

    @Test
    void verifyIfIsPalindomeTest(){
        assertEquals(true,Main.checkIfIsPalindrome("ANA"));
    }
}