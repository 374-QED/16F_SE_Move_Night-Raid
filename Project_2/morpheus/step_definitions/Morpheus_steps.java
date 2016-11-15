package step_definitions;
import java.util.*;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import implementation.nrLib;
import java.sql.ResultSet;

public class Morpheus_steps {
	static nrLib library = new nrLib();
	List<String> list;
	String student_id;


	@Given("^the class \"([^\"]*)\"\\.$")
	public void theClass(String course) throws Throwable {
		list = library.getDataFromCourse(course);
	}

	@Then("^the room number is (\\d+)\\.$")
	public void theMaxEnrolledNumberIs(String num) throws Throwable {
	    assertEquals(list.contains(num), true);
	}

	@Given("^the course \"([^\"]*)\"$")
	public void theCourse(String course) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    list = library.getStudentFromCourse(course);
	}

	@Then("^\"([^\"]*)\" is in the course\\.$")
	public void isInTheCourse(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    assertEquals(list.contains(library.findStudent(name)),true);
	}

	@Given("^the student \"([^\"]*)\"$")
	public void theStudent(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    student_id = library.findStudent(name);
	}

	@Then("^this student is taking \"([^\"]*)\"$")
	public void thisStudentIsTaking(String course) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    list = library.getStudentFromCourse(course);
	    assertEquals(list.contains(student_id),true);

	}

	@Given("^the day \"([^\"]*)\" and time \"([^\"]*)\"$")
	public void theDayAndTime(String day, String time) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    List<String> not_room = library.notavailableRoom(time,day);
	    List<String> room = library.allRoom();
	    list = library.comparing(not_room,room);
	    //list.sort();
	 	//System.out.println(list);
	}

	@Then("^room number \"([^\"]*)\" is available$")
	public void roomNumberIsAvailable(String room) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(list.contains(room),true);
	}

}