package nocom.DenCompany.SimpleApplication.repository;

import net.sf.jasperreports.engine.JasperPrint;

import java.sql.SQLException;

public interface PdfRepository {
    JasperPrint exportPDF(String id) throws SQLException;
}
