package lk.ijse.bussystem.tm;

public class BookingTM {
    private String cusid;
    private String busid;

    public BookingTM() {
    }

    public BookingTM(String cusid, String busid) {
        this.cusid = cusid;
        this.busid = busid;
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    @Override
    public String toString() {
        return "BookingTM{" +
                "cusid='" + cusid + '\'' +
                ", busid='" + busid + '\'' +
                '}';
    }
}
