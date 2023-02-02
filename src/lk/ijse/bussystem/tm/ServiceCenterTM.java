package lk.ijse.bussystem.tm;

public class ServiceCenterTM {
    private String Sid;
    private String name;
    private String location;
    private String contact;
    private double task;
    private String Date;
    private String bid;

    public ServiceCenterTM() {
    }

    public ServiceCenterTM(String sid, String name, String location, String contact, double task, String date, String bid) {
        Sid = sid;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.task = task;
        this.Date = date;
        this.bid = bid;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        this.Sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getTask() {
        return task;
    }

    public void setTask(double task) {
        this.task = task;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "ServiceCenterTM{" +
                "Sid='" + Sid + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                ", task=" + task +
                ", Date='" + Date + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }
}
