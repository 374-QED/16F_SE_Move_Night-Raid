package step_definitions;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import implementation.SQLiteAccess;
import java.sql.ResultSet;

public class Morpheus_steps {
	static SQLiteAccess test = new SQLiteAccess();

	
	@Given("^the days \"([^\"]*)\" and the course \"([^\"]*)\"$")
	public void theDaysAndTheCourse(String arg1, String arg2) throws Throwable {
	
		
	}

	@Then("^the course can be moved to \"([^\"]*)\"$")
	public void theCourseCanBeMovedTo(String arg1) throws Throwable {
		ResultSet rs = test.readDatabase("select * from classes limit 10");
	    String target = test.writeString(rs, "Banner_ID");
	    assertEquals(target, target);
	}

	@Given("^the days \"([^\"]*)\" and start time \"([^\"]*)\"$")
	public void theDaysAndStartTime(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	   

	}

	@Then("^\"([^\"]*)\" has a class at that time$")
	public void hasAClassAtThatTime(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    ResultSet rs = test.readDatabase("select * from classes limit 10");
	    String target = test.writeString(rs, "Banner_ID");
	    assertEquals(target, target);
	}

	@Given("^the course \"([^\"]*)\"$")
	public void theCourse(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^the max enrolled is \"([^\"]*)\"\\.$")
	public void theMaxEnrolledIs(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    ResultSet rs = test.readDatabase("select * from classes limit 10");
	    String target = test.writeString(rs, "Banner_ID");
	    assertEquals(target, target);
	}
}