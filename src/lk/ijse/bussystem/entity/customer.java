/**
 * @author :Hansaka Malshan
 * created 2/4/2023---5:28 PM
 */
package lk.ijse.bussystem.entity;

public class customer {
   private String Customer_Id;
    private String Name;
    private String Address;
    private String E_mail;

    public customer(String customer_Id, String name, String address, String e_mail) {
        this.Customer_Id = customer_Id;
        this.Name = name;
        this.Address = address;
        this.E_mail = e_mail;
    }

    public String getCustomer_Id() {
        return Customer_Id;
    }

    public void setCustomer_Id(String customer_Id) {
        Customer_Id = customer_Id;
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
}
