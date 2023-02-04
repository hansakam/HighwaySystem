/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:32 PM
 */
package lk.ijse.bussystem.entity;

import java.sql.Date;

public class service_center {
    private String Service_Id;
    private String Name;
    private String Location;
    private String Contact;
    private Double Task_Total_Cost;
    private Date date;
    private String Bus_Id;

    public service_center(String service_Id, String name, String location, String contact, Double task_Total_Cost, Date date, String bus_Id) {
        this.Service_Id = service_Id;
        this.Name = name;
        this.Location = location;
        this.Contact = contact;
        this.Task_Total_Cost = task_Total_Cost;
        this.date = date;
        this.Bus_Id = bus_Id;
    }

    public String getService_Id() {
        return Service_Id;
    }

    public void setService_Id(String service_Id) {
        Service_Id = service_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public Double getTask_Total_Cost() {
        return Task_Total_Cost;
    }

    public void setTask_Total_Cost(Double task_Total_Cost) {
        Task_Total_Cost = task_Total_Cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBus_Id() {
        return Bus_Id;
    }

    public void setBus_Id(String bus_Id) {
        Bus_Id = bus_Id;
    }
}
