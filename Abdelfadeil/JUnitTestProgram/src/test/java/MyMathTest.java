import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MyMathTest {

    // fields used together
    public int[] numbers1 = {3, 5, 7, 9};
    public int[] numbers2= {5, 7, 6, 11};;
     public int[] numbers3 = {7, 13, 4, 8};;
    public int result;





    @Test
    public void testAditionArray1() {
        MyMath tester = new MyMath();
        assertEquals((24),tester.sum(numbers1));
    }
    @Test
    public void testAditionArray2() {
        MyMath tester = new MyMath();
        assertEquals((29),tester.sum(numbers2));

    }
    @Test
    public void testAditionArrayException3() {
        MyMath tester = new MyMath();
        assertEquals((32),tester.sum(numbers3));
    }

}
