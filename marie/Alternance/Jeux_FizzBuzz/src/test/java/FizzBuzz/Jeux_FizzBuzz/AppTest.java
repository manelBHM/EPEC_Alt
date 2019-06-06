package FizzBuzz.Jeux_FizzBuzz;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	classlist fb = new classlist();

	
	@SuppressWarnings("restriction")
	@Test
    public static void test1() {
       assertTrue(classlist.exportNumber(3)=="Fizz");
       }
	@SuppressWarnings("restriction")
	@Test
    public static void test2() {
       assertTrue(classlist.exportNumber(5)=="Buzz");
       }
	@SuppressWarnings("restriction")
	@Test
    public static void test3() {
       assertTrue(classlist.exportNumber(15)=="FizzBuzz");
       }
	@SuppressWarnings("restriction")
	@Test
    public static void test4() {
       assertTrue(classlist.exportNumber(0)==null);
       }
	@SuppressWarnings("restriction")
	@Test
    public static void test5() {

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> classlist.exportNumber(0),
		          "Expected doThing() to throw, but it didn't");    
		   assertTrue(thrown.getMessage().contains("Stuff"));
		}
       }

