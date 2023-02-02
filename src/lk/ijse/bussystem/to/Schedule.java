package lk.ijse.bussystem.to;

public class Schedule {
    private String busId;
    private String from;
    private String to;
    private String time;
    private String s_id;

    public Schedule(String busId, String from, String to, String time, String s_id) {
        this.busId = busId;
        this.from = from;
        this.to = to;
        this.time = time;
        this.s_id = s_id;
    }

    public Schedule() {
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "busId='" + busId + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", time='" + time + '\'' +
                ", s_id='" + s_id + '\'' +
                '}';
    }
}
