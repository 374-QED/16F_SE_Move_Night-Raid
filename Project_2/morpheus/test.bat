@echo off

javac -cp "jars/*;.;resources/SQLite/*" implementation\Test.java implementation\SQLiteAccess.java implementation\NRLib.java

if %errorlevel%==0 java -cp ".;jars/*" implementation.Test
