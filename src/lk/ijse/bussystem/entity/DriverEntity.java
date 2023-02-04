/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:28 PM
 */
package lk.ijse.bussystem.entity;

public class DriverEntity {
    private String Driver_Id;
    private String Name;
    private String Address;
    private String E_mail;
    private double Salary;

    public DriverEntity(String driver_Id, String name, String address, String e_mail, double salary) {
        this.Driver_Id = driver_Id;
        this.Name = name;
        this.Address = address;
        this.E_mail = e_mail;
        this.Salary = salary;
    }

    public String getDriver_Id() {
        return Driver_Id;
    }

    public void setDriver_Id(String driver_Id) {
        Driver_Id = driver_Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}
