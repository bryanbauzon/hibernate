Package Structures
====================
Exercise (Hibernate)_Trainee
|-lib
|-nbproject
|-src
|-test

Setup Derby
=============
1. Copy the 'db-derby-10.12.1.1-bin' from the shared drive. Put it in your local drive.
2. Set the environment variables below:
DERBY_INSTALL=C:\Apache\db-derby-10.12.1.1-bin

If you do not have a classpath set before, then create this new variable with the below value:
CLASSPATH=%DERBY_INSTALL%\lib\derby.jar;%DERBY_INSTALL%\lib\derbytools.jar;

However, if you have the classpath set before, you just append the value to the existing classpath.

3. Once the above is set properly, test it by opening a cmd and run this command: java org.apache.derby.tools.sysinfo
You should then see the output like this:
------------------ Java Information ------------------
......

Create a DB
-------------
4. In cmd, go to \db-derby-10.12.1.1-bin\bin, type: setEmbeddedCP.bat

5. After that, type: java org.apache.derby.tools.ij
	You will then see the ij command eg.:
	ij>

6. Create the 'training' db with the following ij command:
	ij> connect 'jdbc:derby:training;create=true';
	
7. Once this is done without error, go to your explorer by navigating to \db-derby-10.12.1.1-bin\bin path, and see if the 'training' folder is been created there.

8. Now run the createtable.sql by:
ij> run '[your location of hibernate exercise]\Exercise (Hibernate)_Trainee\createtable.sql';

9. Once tables are created successfully, exit the ij.


To startup Derby over the network
---------------------------------------
9. Go to \db-derby-10.12.1.1-bin\bin, click on startNetworkServer.bat.

If the derby server is started up successfully, you will see this:
 Apache Derby Network Server - 10.12.1.1 - (1704137) started and ready to accept connections on port 1527


To reconnect to the created db
================================
1. You need to stop the derby network server.
2. Then using ij, issue the command to connect to the DB (without the 'create' param):
	ij> connect 'jdbc:derby:training';
3. Then you can issue select statement.
4. Once done, exit IJ and start the network server again.
 

Working on the project
-----------------------
1. To build, right click on the 'build.xml' > Run As > Ant Build.
2. Once built, the below folders will be generated:
	build
	dist
	
3. All the JUnit Test classes will be run and the test output generated in \build\test\results.
4. The compilation and other error detected during compilation can be seen in the console as well.

8. After each modification, to compile, you must run the Ant Build first. Then, only go to the \build\test\results to see your JUnit Test results.


Notes: 
1. Ensure that the Java Compiler in Eclipse is using JDK 1.7. 
