package lk.ijse.bussystem.to;

public class Bus {
private String id;
private String capasity;
private String busnumber;
private String seat;
private String seatid;

    public Bus() {
    }

    public Bus(String id, String capasity, String busnumber, String seat, String seatid) {
        this.id = id;
        this.capasity = capasity;
        this.busnumber = busnumber;
        this.seat = seat;
        this.seatid = seatid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCapasity() {
        return capasity;
    }

    public void setCapasity(String capasity) {
        this.capasity = capasity;
    }

    public String getBusnumber() {
        return busnumber;
    }

    public void setBusnumber(String busnumber) {
        this.busnumber = busnumber;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }
}
