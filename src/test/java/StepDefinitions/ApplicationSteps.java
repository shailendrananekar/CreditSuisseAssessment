package StepDefinitions;

import Utility.HSQLDBConnection;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.LogEvent;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;

import static Utility.HSQLDBConnection.con;
import static Utility.HSQLDBConnection.stmt;

public class ApplicationSteps {

    private static Logger Log = Logger.getLogger(ApplicationSteps.class.getName());

    HSQLDBConnection hsqldb = new HSQLDBConnection();
    public static BufferedReader reader;
    public static FileInputStream fstream;

    @Given("^Read the log file$")
    public void ReadLogFile() throws FileNotFoundException {

        String fileName = System.getProperty("fileName");
        Log.info("Reading file: " + fileName);
        fstream = new FileInputStream(fileName);
        reader = new BufferedReader(new InputStreamReader(fstream));

    }

    @When("^Connect to HSQLDatabase and Create table if doesn't exist$")
    public void DBConnection() throws SQLException, ClassNotFoundException {

        hsqldb.connectHSQLDB();
        hsqldb.createTableIFNotExist();

    }

    @Then("^Parse logfile and identify high duration events$")
    public void Parse() throws IOException, SQLException {

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, LogEvent> eventMap = new HashMap<String, LogEvent>();
        String line;
        while ((line = reader.readLine()) != null) {
            LogEvent log = mapper.readValue(line, LogEvent.class);
            String eventId = log.getId();
            if (!eventMap.containsKey(eventId)) {
                eventMap.put(eventId, log);
                continue;
            }
            LogEvent previousLog = eventMap.remove(eventId);
            long duration = Math.abs(log.gettimestamp() - previousLog.gettimestamp());
            boolean alert = false;
            if (duration > 4) {
                alert = true;
            }
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO eventtable VALUES ('" + log.getId() + "','" + duration + "','" + log.gettype() + "','" + log.gethost() + "'," + alert + ")");
            Log.info("Event logged in DB: " + "Event Id: " + log.getId() + ", Duration(ms): " + duration + ", Type:" + log.gettype() + ", Host: " + log.gethost() + ", Alert:" + alert);

        }
        con.commit();
        hsqldb.closeDBConnection();
        fstream.close();

    }

}
