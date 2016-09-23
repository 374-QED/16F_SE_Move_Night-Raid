::Nattapat White
::Due date: September 19, 2016
::Turn in: September 18, 2016
::CS374 Software Engineering
::Cucumber Quiz 
javac -cp "jars/*" step_definitions/CoursesTest.java  implementation/CSVparser.java 
java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features 
