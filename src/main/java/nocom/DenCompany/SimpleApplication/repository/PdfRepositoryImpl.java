package nocom.DenCompany.SimpleApplication.repository;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.xml.ws.soap.Addressing;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PdfRepositoryImpl implements PdfRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public JasperPrint exportPDF(String id) throws SQLException {
        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            File file = ResourceUtils.getFile("classpath:Report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("logID", id);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            return jasperPrint;

        } catch (Exception exception) {
            return null;
        }
    }
}
