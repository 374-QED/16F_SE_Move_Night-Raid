package step_definitions;


import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import java.util.*;

import implementation.CSVparser;

public class CoursesTest {

	CSVparser csvParser = new CSVparser();
	List<String> students = new ArrayList<String>();

	@Given("^the course \"([^\"]*)\"\\.$")
	public void theCourse(String arg1) throws Throwable {
	    students = csvParser.parseClass(arg1);
	}

	@Then("^\"(.+)\" is not suppose to be in that course\\.$")
	public void isNotSupposeToBeInThatCourse(String arg1) throws Throwable {
	    if(students.contains(arg1)) {
	    	assertEquals(arg1, arg1);
	    }
	    else
	    	assertEquals(arg1, "s");
	}
}