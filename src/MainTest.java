import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {
	double res=2046;
	@Test
	public void testKeyboard() {
		//n=10 p=6
		double res1=Main.count(false);
		double res2=Main.count(true);
		assertTrue(res1==res  && res2==res);
	}
	@Test
	public void testFile() {
		//n=120 p=6
		double res3=Main.count("data.txt", true);
		double res4=Main.count("data.txt", false);
		assertTrue(res3==res && res4==res );
	}

}
