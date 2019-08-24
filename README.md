Pre-requisite required:
   Java Jdk  1.8.0_144, Eclipse photon, Test NG for eclipse, Cucumber Eclipse plugin
Download Eclipse from below URL.
https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/photon/R/eclipse-jee-photon-R-win32-x86_64.zip
Steps to install cucumber plugin:
1)	Launch the Eclipse IDE and from Help menu, click “Install New Software”
2)	You will see a dialog window, click “Add” button.
3)	Type name as you wish, let’s take “Cucumber” and type “http://cucumber.github.com/cucumber-eclipse/update-site” as location. Click OK.
4)	you must see Cucumber Eclipse Plugin option in the available software list. Just Check the box and press “Next” button.
5)	Click on Next.
6)	Click “I accept the terms of the license agreement” then click Finish.
7)	 Let it install, it will take few seconds to complete.
8)	You may or may not encounter a Security warning, if in case you do just click OK.
9)	You are all done now, just Click Yes.

Steps to install Test NG plugin:
1)	Launch the Eclipse IDE and from Help menu, click “Eclipse Market place”
2)	Type Test Ng inside Find input field and click on search icon.
3)	Test Ng for Eclipse Option  will display, click install and proceed with the installation.
4)	Restart eclipse once all setup is done.



Steps to import project from GIT to Local Drive:
1)	Go to https://github.com/khalid8899/openWeatherDemo.git
2)	Click on download->Download Zip(project will be download)
3)	Unzip project and save it on your local drive.
4)	Launch Eclipse IDE and select Workspace (Eclipse will open)
5)	Click on File->import->Click on Maven
6)	Select Existing Maven Projects and click on next.
7)	Browse Root Directory and go to the project location.
8)	Click on web folder , projects with POM file is display.
9)	Select POM.XML file and click on finish.
10)	Project will be imported on eclipse(wait until all files are imported)

Steps for Execution:
There are 2 ways for execution.
1)	Explore the project and go to the  Test Runner Class file(src/main/java)
2)	Under tag option you can enter tag details provided in cucumber feature file.
3)	You can run all test cases simultaneously using @smoke common tag or by providing one test case tag detail i.e TC_001 and so on.
4)	Right Click on Test runner class file and select  Run as Test NG Test.
5)	Execution will start for provided test case tag name.
6)	Another way to execute is go to the “openWeather.feature” file(under feature folde)
7)	Right click on feature file and select Run as Cucumber feature
8)	Execution will start and test cases will be executed.

Reports:
1)	After execution all the validation details will be printed on console.
2)	Reports will be generated in Test Ng result format on console.
3)	You can also go to target folder for different reports format.

	




