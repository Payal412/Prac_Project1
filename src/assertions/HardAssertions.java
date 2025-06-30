package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void test()
	{
		//Assert.assertEquals("xyz","xyz"); //Passed
		//Assert.assertEquals("xyz","xyz1"); //Failed
		
		//Assert.assertEquals(123 , 345); //Failed
		
		//Assert.assertEquals("abc" , 123); //Failed
		//Assert.assertEquals("123", 123); //Failed
		
		//Assert.assertNotEquals(123, 123); //Failed
		//Assert.assertNotEquals(123, 345); //Passed
		
		//Assert.assertTrue(true); //Pass
		//Assert.assertTrue(false); //fail
		//Assert.assertTrue(1==2); //fail
		//Assert.assertTrue(1==1); //Pass
		
		//Assert.assertFalse(1==2); //Pass
		//Assert.assertFalse(1==1); //fail
		
		Assert.fail(); //fail
	}
}
