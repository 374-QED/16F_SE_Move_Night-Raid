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
	@Given("^the student name \"([^\"]*)\"\\.$")
	public void theStudentName(String name) throws Throwable
	{
		holding = name;
	}

	@Then("^the student need to retake \"([^\"]*)\"\\.$")
	public void theStudentNeedToRetake(String course) throws Throwable
	{
		students = csvParser.parseStudent(holding);
		assertEquals(students.contains(course),false);
	}

	@Then("^\"([^\"]*)\" is required\\.$")
	public void isRequired(String preq) throws Throwable {
		students = csvParser.parsePreReq(holding);
		//assertEquals(students.contains(preq),true);
	}
	@Then("^\"([^\"]*)\" offered in the \"([^\"]*)\" is required\\.$")
	public void offeredInTheIsRequired(String preq, String mester) throws Throwable {
		students = csvParser.parsePreReq(holding);
		pop = csvParser.parseSemester(holding);
		//assertEquals(students.contains(preq),pop.contains(mester));
	}

	@Then("^\"([^\"]*)\" is suppose to be in that course\\.$")
	public void isNotSupposeToBeInThatCourse(String arg1) throws Throwable {
		students = csvParser.parseClass(holding,holding);
	   assertEquals(students.contains(arg1), true);
	
	}

}