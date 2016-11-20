@echo off

javac -cp "jars/*;.;resources/SQLite/*" implementation\ClassMove.java implementation\SQLiteAccess.java implementation\nrLib.java

if %errorlevel%==0 java -cp ".;jars/*" implementation.ClassMove