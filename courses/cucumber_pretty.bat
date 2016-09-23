javac -cp "jars/*" step_definitions/CoursesTest.java  implementation/CSVparser.java 
java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features 
