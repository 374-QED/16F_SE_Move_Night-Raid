package step_definitions;
import implementation.AccessSQL_CSV;
import java.io.*;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import java.util.*;


public class CoursesTest {

	private AccessSQL_CSV lookup = new AccessSQL_CSV();
	List<String> student;
	List<String> unnStudent;
	String class_;
	String result;
	@Given("^the course \"([^\"]*)\" and the term \"([^\"]*)\"\\.$")
	public void theCourseAnd(String course, String semester) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 	student = lookup.getStudent(semester,course);
	 	class_ = course;
	}
	@Then("^\"([^\"]*)\" had taken that course already\\.$")
	public void hadThatCourseAlready(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete action
	    //System.out.println(course_1+" "+semester_1);
		String[] splited = name.split("\\s+");
		result = lookup.findStudent(splited[0],splited[1],splited[2]);
	    assertEquals(student.contains(result),true);
	}

	@Then("^\"([^\"]*)\" will take this course\\.$")
	public void CourseAlready(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete action
	    //System.out.println(course_1+" "+semester_1);
		String[] splited = name.split("\\s+");
		result = lookup.findStudent(splited[0],splited[1],splited[2]);
	    assertEquals(student.contains(result),true);
	}
	@Then("^\"([^\"]*)\" should not be in the course\\.$")
	public void shouldNotBeInTheCourse(String name) throws Throwable {
	    unnStudent = lookup.takeOutStudent(student, class_);
	    String[] splited = name.split("\\s+");
		result = lookup.findStudent(splited[0],splited[1],splited[2]);
	    assertEquals(unnStudent.contains(result), true);
	}
}