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