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

    public void abrirRelatorioArquivos() throws SQLException, Exception {
        InputStream inputStream = getClass().getResourceAsStream("/report/Arquivos.jasper");

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        
        // abre o relatório
        ReportUtils.openReport("Arquivos", inputStream, parametros, ConnectMySQL.startConnection());

    }
    
    public void abrirRelatorioComponentes() throws SQLException, Exception {
        InputStream inputStream = getClass().getResourceAsStream("/report/Componentes.jasper");

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        
        // abre o relatório
        ReportUtils.openReport("Componentes", inputStream, parametros, ConnectMySQL.startConnection());

    }

}
