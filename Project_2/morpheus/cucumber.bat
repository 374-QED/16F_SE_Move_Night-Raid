javac -cp "jars/*" step_definitions/Morpheus_steps.java
java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features 