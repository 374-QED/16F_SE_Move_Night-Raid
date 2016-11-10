Feature: Testing

Scenario Outline: Find the max enrolled in a class.
	
	Given the class <course>.
	Then the max enrolled number is <maxNum>.

Examples:
| course | maxNum |
| "ACCT410" | 117 |
| "BLAW461" | 301 |
| "CORE110" | 115 |
| "CS120" | 314 |
| "IT220" | 216 |


Scenario: Get Students in a class.

	Given the course "CS120"
	Then "Adam Barakat" is in the course.
	And "Adrienne Stones" is in the course.
	And "Ana Wilson" is in the course.
	And "Bernard Fisherman" is in the course.
	And "Bettie Cormany" is in the course.