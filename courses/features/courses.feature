Feature: Courses

  Scenario Outline: Give names of people who are suppose to be in the course
    Given the course <course>.
    Then <student> is suppose to be in that course.

    Examples: Demo 1
    | course | student |
    | "CS374" | "Aldo Anaya" |
    | "CS120" | "Darius Bell" |
    | "IT220" | "James Cold" |
    | "BMIS420" | "Shawn Newman" |
    | "ART101" | "Jan Myers" |
    | "ART331" | "David himps" |
    | "BIBD620" | "Carey Posh" |
    | "BIOL312" | "Brent Revees" |

<<<<<<< HEAD
   Scenario: finding prerequesite of a class
		Given the course "CS374".
		Then "CS120" is required.
		And "CS130" is required.
		And "CS220" is required.
		And "CS230" is required.

	Scenario: Given the student name and return the classes that student need to retake.
		Given the student name "Aldo Anaya".
		Then the student need to retake "CS120".
=======
  Scenario Outline: finding prerequesite of a class
    Given the course <class>.
    Then <preq1> offered in the <sem1> is required.
    And <preq2> offered in the <sem2> is required.
    And <preq3> offered in the <sem3> is required.
    And <preq4> offered in the <sem4> is required.

     Examples:  Demo_1
    | class | preq1 | sem1 | preq2 | sem2 | preq3 | sem3 | preq4 | sem4 |
    |"CS374"|"CS120"|"Fall"|"CS130"|"Spring"|"CS220"|"Fall"|"CS230"|"Summer"|
>>>>>>> 14dc4347e67622f3d7e821f0cfc1826efe51d2e3
