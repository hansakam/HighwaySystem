package lk.ijse.bussystem.to;

public class Employee {
    private String Emp_id;
    private String Name;
    private String Address;
    private String E_mail;
    private double Salary;
    private String Sid;

    public Employee() {
    }

    public Employee(String emp_id, String name, String address, String e_mail, double salary, String sid) {
        this.setEmp_id(emp_id);
        this.setName(name);
        this.setAddress(address);
        this.setE_mail(e_mail);
        this.setSalary(salary);
        this.setSid(sid);
    }

    public Employee(String emp_id, String name, String address, String e_mail, double salary) {
        this.setEmp_id(emp_id);
        this.setName(name);
        this.setAddress(address);
        this.setE_mail(e_mail);
        this.setSalary(salary);
    }
    public String getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.Emp_id = emp_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        this.E_mail = e_mail;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        this.Sid = sid;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "Emp_id='" + getEmp_id() + '\'' +
                ", Name='" + getName() + '\'' +
                ", Address='" + getAddress() + '\'' +
                ", E_mail='" + getE_mail() + '\'' +
                ", Salary=" + getSalary() +
                ", Sid='" + getSid() + '\'' +
                '}';
    }

}
