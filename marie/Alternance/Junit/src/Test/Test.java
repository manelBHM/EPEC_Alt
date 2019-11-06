package Test;
import Junit.Calculation;
import junit.framework.*;
import org.junit.*;

public class Test {

	@BeforeClass
    public static void setUpClass() throws Exception {
               
    }


    @Before
    public void setUp() throws Exception {
           
    }

    @Test
    public void testSquare() {
       System.out.println("Puissance");
       assertEquals(9,Calculation.square(3));
    }

    private void assertEquals(int i, int square) {
		// TODO Auto-generated method stub
    	 
	}


	@Test
    public void testCube() {
    	System.out.println("Volume");
        assertEquals(27,Calculation.cube(3));
    }


    @After
    public void tearDown() throws Exception {
      
    }
    

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }
}




