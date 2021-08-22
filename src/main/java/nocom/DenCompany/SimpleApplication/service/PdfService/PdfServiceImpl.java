package nocom.DenCompany.SimpleApplication.service.PdfService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import nocom.DenCompany.SimpleApplication.repository.PdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.sql.SQLException;

@Service
public class PdfServiceImpl implements PdfService{

    @Autowired
    PdfRepository pdfRepository;

    public void ExportReport(String id, OutputStream outputStream) throws SQLException, JRException {
        JasperPrint jasperPrint = pdfRepository.exportPDF(id);
        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
    }
}
