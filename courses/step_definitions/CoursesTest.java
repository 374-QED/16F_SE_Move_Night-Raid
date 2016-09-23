package step_definitions;

import java.io.*;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import java.util.*;

import implementation.CSVparser;

public class CoursesTest {

	CSVparser csvParser = new CSVparser();
	List<String> students = new ArrayList<String>();
	List<String> pop = new ArrayList<String>();
	String holding;

	@Given("^the course \"([^\"]*)\"\\.$")
	public void theCourse(String course) throws Throwable {
	   	holding = course;
	}

	@Then("^\"([^\"]*)\" offered in the \"([^\"]*)\" is required\\.$")
	public void offeredInTheIsRequired(String preq, String mester) throws Throwable {
		students = csvParser.parsePreReq("\"CS374\"");
		pop = csvParser.parseSemester("\"CS374\"");
		assertEquals(students.contains(preq),true);
		assertEquals(pop.contains(mester),true);
	}

	@Then("^\"(.+)\" is suppose to be in that course\\.$")
	public void isNotSupposeToBeInThatCourse(String arg1) throws Throwable {
		students = csvParser.parseClass(holding);
	    assertEquals(students.contains(arg1), true);
	
	}

}