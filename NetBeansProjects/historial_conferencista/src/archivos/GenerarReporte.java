/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import db.Mysql;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pc
 */
public class GenerarReporte {
    
    public void reporteEstu(){
    
        try {
            JasperReport reporte = (JasperReport)JRLoader.loadObject("tabla.jasper");
            
            Map parametro= new HashMap();
            JasperPrint j = JasperFillManager.fillReport(reporte, null,Mysql.getConnection());
            JasperViewer jv = new JasperViewer(j,false);
             jv.setTitle("Reporte Ganadores");
             jv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al mostrar el reporte"+e);
        }
    }
  
    public void pdf1(){
    try {
            JasperReport reporte = (JasperReport)JRLoader.loadObject("tabla.jasper");
            
            Map parametro= new HashMap();
            JasperPrint j = JasperFillManager.fillReport(reporte, null,Mysql.getConnection());
            JasperViewer jv = new JasperViewer(j,false);
          JasperExportManager.exportReportToPdfFile( j, "src/docs/Primera Etapa/reporte.pdf");

           //  jv.setTitle("Reporte Ganadores");
            // jv.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al mostrar el reporte"+e);
        }     
  }
  
}
