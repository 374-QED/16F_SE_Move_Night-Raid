Feature: Testing

Scenario Outline: Find the room number for a class.
	
	Given the class <course>.
	Then the room number is <room>.

Examples:
| course | room |
| "ACCT410" | 118 |
| "BLAW461" | 201 |
| "CORE110" | 115 |
| "CS120" | 318 |
| "IT220" | 216 |


Scenario: Get Students in a class.

	Given the course "CS120"
	Then "Rose Thomas Lopez" is in the course.
	And "Sheri Ruby Begay" is in the course.
	And "Troy Hannah Frazier" is in the course.
	And "Christopher Lyle Curry" is in the course.
	And "Carol Rhonda Mefford" is in the course.


Scenario: Get the classes of a student.

	Given the student "Rose Thomas Lopez"
	Then this student is taking "CS120"
	And this student is taking "ITC460"


Scenario: Get distinct start time for classes.
	
	Given the days "MWF"
	Then a class start time is "800"
	And a class start time is "900"
	And a class start time is "1000"
	And a class start time is "1200"
	And a class start time is "1300"


Scenario Outline: Room available in given time day
	Given the day <days> and time <time>
	Then room number <room> is available

Examples:
| days | time | room |
| "MWF"| "900"| "301"|
| "MWF"| "900"| "214"|
| "MWF"| "900"| "235"|
| "TR"| "800"| "235"|
| "TR"| "1000"| "301"|
