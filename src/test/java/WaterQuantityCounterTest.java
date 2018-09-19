import javafx.beans.binding.Bindings;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaterQuantityCounterTest {

    private static int[] generateLandscape(int n) {
        int[] landscape = new int[n];

        for (int i = 0; i < landscape.length; i++) {
            landscape[i] = (int) (Math.random() * n);
        }
        return landscape;
    }

    @Test
    public void arrayFromTaskTest() {
        int[] testArray = {5, 2, 3, 4, 5, 4, 1, 3, 1};
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        int expected = 8;
        assertEquals(actual, expected);
    }

    @Test
    public void simpleArrayTest() {
        int[] testArray = {1, 0};
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void simpleArrayTest1() {
        int[] testArray = {2, 0, 2};
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void simpleArrayTest2() {
        int[] testArray = {1, 5, 1, 4, 1};
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void oneElementArrayTest() {
        int[] testArray = generateLandscape(1);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertNotNull(actual);
    }

    @Test
    public void maxInputValueTest() {       // max landscapeWidth can be 32000 by taskDescription
        int[] testArray = generateLandscape(32000);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertTrue(actual >= 0);
    }

    @Test
    public void intInputValueTest() {
        int[] testArray = generateLandscape(27000);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertTrue(actual >= 0);
    }

    @Test
    public void intInputValueTest1() {
        int[] testArray = generateLandscape(15000);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertNotNull(actual);
    }

    @Test
    public void intInputValueTest2() {
        int[] testArray = generateLandscape(5000);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertTrue(actual >= 0);
    }

    @Test
    public void intInputValueTest3() {
        int[] testArray = generateLandscape(400);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertTrue(actual >= 0);
    }

    @Test
    public void intInputValueTest4() {
        int[] testArray = generateLandscape(50);
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        assertTrue(actual >= 0);
    }

    @Test(expected = java.lang.ArrayIndexOutOfBoundsException.class)
    public void ArrayIndexOutOfBoundsTest() {
        int[] testArray = generateLandscape(0);
        WaterQuantityCounter.countWaterQuantity(testArray);
    }

    @Test(expected = java.lang.NegativeArraySizeException.class)
    public void NegativeArraySizeTest() {
        generateLandscape(-1);
    }

}

