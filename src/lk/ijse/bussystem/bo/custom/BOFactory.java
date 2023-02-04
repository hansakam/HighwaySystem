/**
 * @author :Hansaka Malshan
 * created 2/4/2023---11:13 AM
 */
package lk.ijse.bussystem.bo.custom;

import lk.ijse.bussystem.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    public BOFactory() {
    }
   public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
   }
    public enum BOTypes{
        CUSTOMER,BUS,DRIVER,EMPLOYEE,PAYMENT,SCHEDULE,SEATBOOKING,SEAT,SERVICECENTER,QUERY
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case BUS:
                return new BusBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case DRIVER:
                return new DriverBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case SCHEDULE:
                return new ScheduleBOImpl();
            case SEATBOOKING:
                return new SeatBookingBOImpl();
            case SEAT:
                return new SeatBOImpl();
            case SERVICECENTER:
                return new ServiceCenterBOImpl();
            case QUERY:
                return new QueryBOImpl();
            default:
                return null;

        }

    }
}
