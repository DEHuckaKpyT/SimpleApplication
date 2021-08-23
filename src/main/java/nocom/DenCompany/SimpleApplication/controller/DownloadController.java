package nocom.DenCompany.SimpleApplication.controller;

import net.sf.jasperreports.engine.JRException;
import nocom.DenCompany.SimpleApplication.service.PdfService.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

@RestController
public class DownloadController {

    @Autowired
    PdfService pdfService;

    @GetMapping("/report/{id}")
    public void getPdfService(HttpServletResponse response, @PathVariable String id) throws JRException, SQLException, IOException {
    response.setContentType("application/x-download");
    response.setHeader("Content-Disposition", String.format("attachment; filename=\"log.pdf\""));
        OutputStream outputStream = response.getOutputStream();
        pdfService.ExportReport(id, outputStream);
    }
}
