$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Application.feature");
formatter.feature({
  "line": 2,
  "name": "Read logfile and identify Events took high duration",
  "description": "",
  "id": "read-logfile-and-identify-events-took-high-duration",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Applicationlog"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Read logfile and log them in DB",
  "description": "",
  "id": "read-logfile-and-identify-events-took-high-duration;read-logfile-and-log-them-in-db",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Read the log file",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Connect to HSQLDatabase and Create table if doesn\u0027t exist",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Parse logfile and identify high duration events",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.ReadLogFile()"
});
formatter.result({
  "duration": 227289900,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.DBConnection()"
});
formatter.result({
  "duration": 642839200,
  "status": "passed"
});
formatter.match({
  "location": "ApplicationSteps.Parse()"
});
formatter.result({
  "duration": 408760900,
  "status": "passed"
});
});