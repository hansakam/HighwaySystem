package lk.ijse.bussystem.DTO;

public class DriverDTO {
    private String eid;
    private String name;
    private String address;
    private String email;
    private double salary;

    public DriverDTO(String id) {
    }

    public DriverDTO(String eid, String name, String address, String email, double salary) {
        this.eid = eid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.salary = salary;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "eid='" + eid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
