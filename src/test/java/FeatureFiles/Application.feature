@Applicationlog
Feature: Read logfile and identify Events took high duration

  Scenario: Read logfile and log them in DB
    Given Read the log file
    When Connect to HSQLDatabase and Create table if doesn't exist
    Then Parse logfile and identify high duration events
