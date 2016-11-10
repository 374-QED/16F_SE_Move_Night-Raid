Feature: Testing

Scenario Outline: Find the max enrolled in a class.
	
	Given the class <course>.
	Then the max enrolled number is <maxNum>.

Examples:
| course | maxNum |
| "ACCT410" | 118 |
| "BLAW461" | 201 |
| "CORE110" | 115 |
| "CS120" | 318 |
| "IT220" | 216 |


Scenario: Get Students in a class.

	Given the course "CS120"
	Then "Adam Barakat" is in the course.
	And "Adrienne Stones" is in the course.
	And "Ana Wilson" is in the course.
	And "Bernard Fisherman" is in the course.
	And "Bettie Cormany" is in the course.


Scenario: Get the classes of a student.

	Given the student "John Joseph Lampl"
	Then this student is taking "CS120"
	And this student is taking "DET410"