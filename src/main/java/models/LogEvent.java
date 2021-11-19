package models;

public class LogEvent {

    private String Id;
    private String state;
    private String type;
    private String host;
    private long timestamp;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String gethost() {
        return host;
    }

    public void sethost(String host) {
        this.host = host;
    }

    public long gettimestamp() {
        return timestamp;
    }

    public void settimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
