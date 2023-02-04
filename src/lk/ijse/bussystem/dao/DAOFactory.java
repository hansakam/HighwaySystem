/**
 * @author :Hansaka Malshan
 * created 2/4/2023---10:30 AM
 */
package lk.ijse.bussystem.dao;

import lk.ijse.bussystem.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory= new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,BUS,DRIVER,EMPLOYEE,PAYMENT,SCHEDULE,SEATBOOKING,SEAT,SERVICECENTER
    }
    public SuperDAO getDao(DAOTypes types){
        switch(types){
            case BUS:
                return new BusDAOImpl();
            case CUSTOMER:
                return new CustomerDAOImpl();
            case DRIVER:
                return new DriverDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case SCHEDULE:
                return new ScheduleDAOImpl();
            case SEATBOOKING:
                return new SeatBookingDAOImpl();
            case SEAT:
                return new SeatDAOImpl();
            case SERVICECENTER:
                return new ServicecenterDAOImpl();
            default:
                return null;
        }
    }
}
