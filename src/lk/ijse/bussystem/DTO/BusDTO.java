package lk.ijse.bussystem.DTO;

public class BusDTO {
private String id;
private String capasity;
private String busnumber;
private int seat;
private String seatid;

    public BusDTO() {
    }

    public BusDTO(String id, String capasity, String busnumber, int seat, String seatid) {
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

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }
}
