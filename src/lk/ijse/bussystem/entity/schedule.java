/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:30 PM
 */
package lk.ijse.bussystem.entity;

import java.sql.Time;

public class schedule {
    private String Bus_Id;
    private Time time;
    private String from;
    private String to;
    private String schedule_id;

    public schedule(String bus_Id, Time time, String from, String to, String schedule_id) {
        this.Bus_Id = bus_Id;
        this.time = time;
        this.from = from;
        this.to = to;
        this.schedule_id = schedule_id;
    }

    public String getBus_Id() {
        return Bus_Id;
    }

    public void setBus_Id(String bus_Id) {
        Bus_Id = bus_Id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public String getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(String schedule_id) {
        this.schedule_id = schedule_id;
    }
}
