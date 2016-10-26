Feature: Testing

Scenario Outline: Given course and term find the student
    Given the course "BHEB472" and the term "201320".
    Then <name> will take this course.
Examples: 
| name |
|"Archie John Murray"|
|"Alice David Finan"|
|"Amy Patrick Cahoon"|
|"Horace Louis Evans"|
|"Randy Serena Hashimoto"|

Scenario Outline: Given course and term find the student
    Given the course "ACCT324" and the term "201320".
    Then <name> had taken that course already.
Examples: 
| name |
|"Bernard Bonnie Duffy"|
|"Carmen Orville Arnhart"|
|"Nellie Josefina Livingston"|
|"Allen Kenneth Holmes"|
|"Martha Kenny Davis"|
|"Kip Patrick Harrison"|
|"Daniel Glenn Dodson"|
|"Charlotte Hildegarde Davidson"|
|"Keith Marvin Dunn"|
|"Gladys Frederick Breeden"|
|"Gilbert Nicholas Reno"|
|"Hazel Elizabeth Goulette"|
|"David Randy Wideman"|

Scenario Outline: Given course and term find the student
    Given the course "ART106" and the term "201320".
    Then <name> had taken that course already.
Examples:
| name |
|"Frederick Edward Taylor"|
|"Susan Larry Vanscoy"|
|"Sarah Howard Grigsby"|
|"Louis Robert Fulbright"|
|"Eloise Tamara Stout"|
|"Oscar Doris Spencer"|
|"Jeremy Tara Santiago"|


Scenario Outline: Gives names of students that should not be in the course
	Given the course "BHEB472" and the term "201320".
	Then <name> should not be in the course.

Examples: 
| name |
|"Archie John Murray"|
|"Alice David Finan"|
|"Amy Patrick Cahoon"|
|"Horace Louis Evans"|
|"Randy Serena Hashimoto"|