Feature: Testing

Scenario Outline: Asked to change a course to a different time.
	
	Given the days "MWF" and the course "IT410"
	Then the course can be moved to <time>

Examples:
| time |
| "0800" |
| "0900" |
| "1000" |
| "1100" |
| "1200" |

Scenario Outline: Asked what students have class at this time.

	Given the days "TR" and start time "1330"
	Then <Student> has a class at that time

Examples:
| Student |
| "Student1" |
| "Student2" |
| "Student3" |
| "Student4" |
| "Student5" |
| "Student6" |


Scenario: Ask for max enrolled.

	Given the course "CS120"
	Then the max enrolled is "28".
