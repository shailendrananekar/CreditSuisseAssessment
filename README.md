**Description**
--------------------------------------------------------------------------------------
This is maven command line project which takes the file path as input and parse it to identify the events details.
This project also writes the events to HSQLDB under which sampledb database present.

**Requirement**
--------------------------------------------------------------------------------------
1.Java 8

2.Maven ( for resolving dependancy and test)

3.HSQLDB (for database inserts)


**Running Test**
--------------------------------------------------------------------------------------

**mvn clean test -DfileName=logfile path**

Example:-

mvn clean test -DfileName=C:\Users\user\Desktop\logfile.txt

Open command prompt and navigate to your project working directory and run above mvn command.

**Project Structure explainaion**
--------------------------------------------------------------------------------------
**test** folder
1. FeatureFiles: For writing test scenario we have used cucumber feature files, which contain scenarios in "Given" "When" "Then" gherkin format.
2. RunnerFiles: This is for running the test scenarios which we written in feature files.
3. StepDefinitions: This is where bacekend code of feature files sits.

**main** folder
1. HSQLDB : This folder gets created when we run the test. This is for database creation and to write the event details.
2. model: This is for getter setter fields of log events.
3. TestData: we have kept one sample logfile.txt file inside it for reference purpose. otherwise this file does not interact with project run.
4. Utility: This contain HSQLDB connections, creation, closeing.

**resources**: This contains log4j.xml which helps to log the info.

**pom.xml**: This file contains the all the dependancies which are reequired for running the project,
        which gets downloaded automatically when you run the mvn command.
