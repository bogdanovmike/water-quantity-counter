import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterQuantityCounterTest {


    @Test
    public void countWaterQuantityTest() {
        WaterQuantityCounter waterQuantityCounter = new WaterQuantityCounter();
        int[] testArray = new int[1];
        int actual = WaterQuantityCounter.countWaterQuantity(testArray);
        int expected = 0;
        assertEquals(actual, expected);
    }
}