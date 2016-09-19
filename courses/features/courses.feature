Feature: Courses

  Scenario: Give names of people who are not suppose to be in the course
    Given the course "CS374".
    Then "Aldo Anaya" is not suppose to be in that course.