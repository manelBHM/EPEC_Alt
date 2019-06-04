package projet.test.JunitTest2.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUnit {
	
	Calculation calculation = new Calculation();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class Avant la class!");
	}
	
	@Before
	public void setUp() throws Exception{
		System.out.println(" Before Juste avant!");
	}
	
	@Test
	public void testCube() {
		
		System.out.println("test le cube!");
		assertEquals(27,calculation.cube(3));
	}
	
	@Test
	public void testSquare(){
		System.out.println("test le cube!");
		assertEquals(9,calculation.square(3));
	}
	
	@Test
	public void testReverse() {
		System.out.println("test le mot");
		assertEquals("olleh",calculation.reverse("hello").toString());
	}
	
	@Test
	public void testcheckIfPair() {
		System.out.println("test si paire!");
		assertEquals(true,calculation.checkIfPair(4));
		assertEquals(false,calculation.checkIfPair(5));

	}
	
	@Test
	public void checkIfPairPairImpair() {
		System.out.println("test si paire,paire,impaire!");
		assertEquals(true,calculation.checkIfPairPairImpair(2,4,3));
		assertEquals(false,calculation.checkIfPairPairImpair(2,5,3));
	}
	
	@Test
	public void checkIfSumIsPair() {
		System.out.println("test si somme est impaire!");
		assertEquals(true,calculation.checkIfSumIsPair(2,2,2));
		assertEquals(false,calculation.checkIfSumIsPair(2,3,2));

	}
	
	int tab []= {2,4,6,8};
	int tab2[]= {8,2,2,4,3,9};
	
	@Test
	public void checkIfAllElementsPair() {
		System.out.println("test si tous les element sont impaire!");
		assertEquals(true,calculation.checkIfAllElementsPair(tab));
		assertEquals(false,calculation.checkIfAllElementsPair(tab2));
	}
	
	ArrayList<Integer>list2 = new ArrayList<Integer>();
	@Test
	public void exportAllElementsPair() {
		
		list2.add(8);
		list2.add(2);
		list2.add(2);
		list2.add(4);
		System.out.println("un list fait que de nombres paires!");
		assertEquals(list2,calculation.exportAllElementsPair(tab2));
	}
	
	@Test
	public void exportAllUniqueElementsPair() {
		ArrayList<Integer>list3 = new ArrayList<Integer>();
		list3.add(8);
		list3.add(2);
		list3.add(4);
		System.out.println("une list fait que de nombres paires sans doublon!");
		assertEquals(list3,calculation.exportAllUniqueElementsPair(tab2));
	}
	
	@Test
	public void checkSiTuPeuxAcheter() {
		System.out.println("test si j'achete!");
		assertEquals(true,calculation.checkSiTuPeuxAcheter(18));
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("After Après!");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("After Class Après la classe");
	}

}