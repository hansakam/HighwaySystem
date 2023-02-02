package lk.ijse.bussystem.controller;

import javafx.event.ActionEvent;
import lk.ijse.bussystem.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportFormController {
    public void btnCustomerReport(ActionEvent actionEvent) {

        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/bussystem/view/report/Customer.jrxml");
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("date", "2022-12%");

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(print, false);

        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnBookingReport(ActionEvent actionEvent) {
        InputStream resource = this.getClass().getResourceAsStream("/lk/ijse/bussystem/view/report/Boocking_Report.jrxml");
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("Date", "2022-12%");

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(resource);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(print, false);

        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
