/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:30 PM
 */
package lk.ijse.bussystem.entity;

import java.sql.Time;

public class ScheduleEntity {
    private String Bus_Id;
    private String time;
    private String from;
    private String to;
    private String schedule_id;

    public ScheduleEntity(String bus_Id, String time, String from, String to, String schedule_id) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
