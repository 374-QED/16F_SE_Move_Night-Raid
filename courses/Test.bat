@echo off

javac -cp "jars/*;." implementation/Test.java implementation/MySQLAccess.java
java -cp ".;jars/*" implementation.Test