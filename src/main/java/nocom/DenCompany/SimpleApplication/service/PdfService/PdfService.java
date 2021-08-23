package nocom.DenCompany.SimpleApplication.service.PdfService;

import net.sf.jasperreports.engine.JRException;

import java.io.OutputStream;
import java.sql.SQLException;

public interface PdfService {
    void ExportReport(String id, OutputStream outputStream) throws SQLException, JRException;
}
