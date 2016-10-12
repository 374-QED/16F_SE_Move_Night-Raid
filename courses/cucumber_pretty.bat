javac -cp "jars/*" step_definitions/CoursesTest.java  implementation/AccessSQL_CSV.java implementation/CSVparser.java implementation/MySQLAccess.java
java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features 
