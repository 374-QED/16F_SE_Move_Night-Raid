Feature: Courses

  Scenario: Give names of people who are suppose to be in the course
    Given the course "CS374".
    Then "Aldo Anaya" is suppose to be in that course.

  Scenario: Give names of people who are suppose to be in the course
    Given the course "IT110".
    Then "Aldo Anaya" is suppose to be in that course.

   Scenario: finding prerequesite of a class
		Given the course "CS374".
		Then "CS120" is required.
		And "CS130" is required.
		And "CS220" is required.
		And "CS230" is required.

	Scenario: Given the student name and return the classes that student need to retake.
		Given the student name "Aldo Anaya".
		Then the student need to retake "CS120".