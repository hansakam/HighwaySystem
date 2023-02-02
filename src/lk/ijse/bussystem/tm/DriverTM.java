package lk.ijse.bussystem.tm;

public class DriverTM {
    private String did;
    private String name;
    private String address;
    private String email;
    private double salary;

    public DriverTM() {
    }

    public DriverTM(String did, String name, String address, String email, double salary) {
        this.did = did;
        this.name = name;
        this.address = address;
        this.email = email;
        this.salary = salary;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
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
        return "DriverTM{" +
                "did='" + did + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
