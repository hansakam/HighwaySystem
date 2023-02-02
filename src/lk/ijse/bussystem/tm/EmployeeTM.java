package lk.ijse.bussystem.tm;

public class EmployeeTM {
    private String Empid;
    private String name;
    private String address;
    private String email;
    private double salary;
    private String serviceid;

    public EmployeeTM() {
    }

    public EmployeeTM(String empid, String name, String address, String email, double salary, String serviceid) {
        this.Empid = empid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.salary = salary;
        this.serviceid = serviceid;
    }

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String empid) {
        Empid = empid;
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

    public String getServiceid() {
        return serviceid;
    }

    public void setServiceid(String serviceid) {
        this.serviceid = serviceid;
    }
}
