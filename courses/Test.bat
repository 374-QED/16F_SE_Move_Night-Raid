@echo off
cd implementation
javac Test.java CSVparser.java
cd ..
java -cp . implementation.Test