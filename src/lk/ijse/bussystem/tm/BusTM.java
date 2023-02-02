package lk.ijse.bussystem.tm;

public class BusTM {
    private String bid;
    private String capacity;
    private String bnumber;
    private String seat;
    private String seatid;



    public BusTM() {
    }

    public BusTM(String bid, String capacity, String bnumber, String seat, String seatid) {
        this.bid = bid;
        this.capacity = capacity;
        this.bnumber = bnumber;
        this.seat = seat;
        this.seatid = seatid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBnumber() {
        return bnumber;
    }

    public void setBnumber(String bnumber) {
        this.bnumber = bnumber;
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
