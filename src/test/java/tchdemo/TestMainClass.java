package tchdemo;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import com.tch.demo.MainClass;
import com.tch.demo.beans.Bank;

public class TestMainClass {
	
	MainClass main;
	
	@Before
	public void setup() {
		main = new MainClass();
	}
	
	@After
	public void clear() {
		main.setBankList(new ArrayList<>());
	}
	
	@Test
	public void testMainFileLoad() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		Assert.assertNotNull(main.getBankList());
	}
	
	@Test
	public void testMainSearchForName() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		String[] search = new String[] {"Amazing Bank"};
		List<Bank> result = main.search("name", search);
		Assert.assertNotNull(result);
		Assert.assertEquals(4, result.size());
		
	}
	
	@Test
	public void testMainSearchForZipCode() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		String[] search = new String[] {"75201"};
		List<Bank> result = main.search("zipcode", search);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		
	}

	@Test
	public void testMainSearchForState() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		String[] search = new String[] {"TX"};
		List<Bank> result = main.search("state", search);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		
	}
	@Test
	public void testMainSearchForCity() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		String[] search = new String[] {"Dallas"};
		List<Bank> result = main.search("city", search);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		
	}
	@Test
	public void testMainSearchForType() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		String[] search = new String[] {"ATM"};
		List<Bank> result = main.search("type", search);
		Assert.assertNotNull(result);
		Assert.assertEquals(6, result.size());
		
	}
	@Test
	public void testMainSearchForCityAndState() throws IOException {
		main.readFile("src/test/resources/ProgrammingAssignment.csv");
		String[] search = new String[] {"Dallas","TX"};
		List<Bank> result = main.search("cityandstate", search);
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		
	}

}
