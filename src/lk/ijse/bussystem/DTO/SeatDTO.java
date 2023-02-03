package lk.ijse.bussystem.DTO;

public class SeatDTO {
    private String Seatid;
    private String busid;
    private double seatprice;


    public SeatDTO() {
    }

    public SeatDTO(String seatid, String busid, double seatprice) {
        this.Seatid = seatid;
        this.busid = busid;
        this.seatprice = seatprice;
    }

    public String getSeatid() {
        return Seatid;
    }

    public void setSeatid(String seatid) {
        this.Seatid = seatid;
    }

    public String getBusid() {
        return busid;
    }

    public void setBusid(String busid) {
        this.busid = busid;
    }

    public double getSeatprice() {
        return seatprice;
    }

    public void setSeatprice(double seatprice) {
        this.seatprice = seatprice;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "Seatid='" + Seatid + '\'' +
                ", busid='" + busid + '\'' +
                ", seatprice=" + seatprice +
                '}';
    }
}
