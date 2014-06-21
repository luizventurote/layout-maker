package control;

import dao.FileDao;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Arquivo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.ConnectMySQL;
import util.ConnectionFactory;
import util.ReportUtils;

public class ReportControl {
    
    private String report;
    
    public void abrirRelatorio() throws SQLException, Exception {
        InputStream inputStream = getClass().getResourceAsStream("/report/"+this.report+".jasper");

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        
        // abre o relatório
        ReportUtils.openReport(this.report, inputStream, parametros, ConnectMySQL.startConnection());

    }

    public void abrirRelatorioArquivos() throws SQLException, Exception {
        
        this.report = "Arquivos";
        this.abrirRelatorio();

    }
    
    public void abrirRelatorioComponentes() throws SQLException, Exception {

        this.report = "Componentes";
        this.abrirRelatorio();

    }
    
    public void abrirRelatorioFrameworks() throws SQLException, Exception {

        this.report = "Frameworks";
        this.abrirRelatorio();

    }
    
    public void abrirRelatorioBibliotecas() throws SQLException, Exception {

        this.report = "Bibliotecas";
        this.abrirRelatorio();

    }

}
