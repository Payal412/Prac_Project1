package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

	@Test
	void testTitle()
	{
		String exp_title="OpenCart";
		String act_title="OpenShop";
		
		/*if(exp_title.equals(act_title))
		{
		    System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}*/
		
		//Assert.assertEquals(exp_title, act_title); //This assertion will compare 2 values
		
		if(exp_title.equals(act_title))
		{
		    System.out.println("test passed");
		    Assert.assertTrue(true); //This assertion will take boolean value as a parameter
		}
		else
		{
			System.out.println("test failed");
			Assert.assertTrue(false);
		}
	}
}
