package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

	//@Test
	void test_hardassertions()
	{
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		//Hard Assertion
		//Assert.assertEquals(1, 2); //fail
		Assert.assertEquals(1, 1); //Pass
		
		System.out.println("Testing..");
		System.out.println("Testing..");
	}
	
	@Test
	void test_softassertions()
	{
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		//Soft Assertion
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(1, 2);
		
		System.out.println("Testing..");
		System.out.println("Testing..");
		
		sa.assertAll(); //mandatory
	}
}
