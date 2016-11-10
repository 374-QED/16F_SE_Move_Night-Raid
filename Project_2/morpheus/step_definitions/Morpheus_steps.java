package step_definitions;
import java.util.*;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;
import implementation.SQLiteAccess;
import java.sql.ResultSet;

public class Morpheus_steps {
	static SQLiteAccess sqlite = new SQLiteAccess();
	List<String> list;


	@Given("^the class \"([^\"]*)\"\\.$")
	public void theClass(String course) throws Throwable {
	    String[] crs = sqlite.parseCourse(course);
	    list = sqlite.writeResultSet(sqlite.readDatabase("select distinct Subject_Code, Course_Number, Room_Code1 from classes where Term_Code = 201510 and Subject_Code = '" + crs[0] + "' and Course_Number = '" + crs[1] + "'"), "Room_Code1");

	}

	@Then("^the max enrolled number is (\\d+)\\.$")
	public void theMaxEnrolledNumberIs(String num) throws Throwable {
	    assertEquals(list.contains(num), true);
	}
}