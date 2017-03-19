package TestCases;

import java.util.List;

import org.testng.annotations.Test;

import com.intusurg.windchill.WindChillTest;

public class ServiceTestClass {

	@SuppressWarnings("static-access")
	@Test
	public static void testMethod(){
		
		WindChillTest wcTest = new WindChillTest();
		String objName="551182-06A da Vinci S and Si QRG for The Vessel Sealer";
		
		List<String> objs = wcTest.GetEarlierVersions(objName);
		
		for(String obj:objs){
			System.out.println(obj);
		}
	}
	
}
