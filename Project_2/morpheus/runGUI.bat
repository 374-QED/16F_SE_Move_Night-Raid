@echo off

javac -cp "jars/*;.;resources/SQLite/*" implementation\GUI.java implementation\GUI2.java implementation\GUI3.java implementation\GUI4.java implementation\SQLiteAccess.java implementation\nrLib.java
java -cp ".;jars/*" implementation.GUI