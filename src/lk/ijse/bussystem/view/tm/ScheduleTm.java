package lk.ijse.bussystem.view.tm;

public class ScheduleTm {
    private String busId;
    private String from;
    private String to;
    private String time;

    public ScheduleTm() {
    }

    public ScheduleTm(String busId, String from, String to, String time) {
        this.busId = busId;
        this.from = from;
        this.to = to;
        this.time = time;
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

    @Override
    public String toString() {
        return "ScheduleTm{" +
                "busId='" + busId + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
