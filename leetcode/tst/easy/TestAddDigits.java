package easy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestAddDigits {
    AddDigits addDigits;
    @Before
    public void setup() {
        addDigits = new AddDigits();
    }
    
    @Test
    public void testAddDigits() {
        int num = 123456789;
        int res = 9;
        assertEquals(res, addDigits.addDigits(num));
        //assertEquals(3, addDigits.addDigits(12));
    }
    
    @Test
    public void testZeroInput() {
        int num = 0;
        int res = 0;
        assertEquals(res, addDigits.addDigits(num));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNegativeInput() {
        int num = -111;
        addDigits.addDigits(num);
    }
}
