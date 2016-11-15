@echo off
javac -cp "jars/*;implementation/*;." step_definitions/Morpheus_steps.java
java -cp "jars/*;.;implementation/*" cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features 
