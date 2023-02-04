/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:28 PM
 */
package lk.ijse.bussystem.entity;

public class EmployeeEntity {
    private String Emp_Id;
    private String Name;
    private String Address;
    private String E_mail;
    private double Salary;
    private String Service_Id;

    public EmployeeEntity(String emp_Id, String name, String address, String e_mail, double salary, String service_Id) {
        this.Emp_Id = emp_Id;
        this.Name = name;
        this.Address = address;
        this.E_mail = e_mail;
        this.Salary = salary;
        this.Service_Id = service_Id;
    }

    public String getEmp_Id() {
        return Emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        Emp_Id = emp_Id;
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

    public String getService_Id() {
        return Service_Id;
    }

    public void setService_Id(String service_Id) {
        Service_Id = service_Id;
    }
}
