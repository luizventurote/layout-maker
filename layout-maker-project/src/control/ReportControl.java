package control;

import dao.FileDao;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Arquivo;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportControl {

    public void showReportArquivo() throws Exception {

        FileDao dao = new FileDao();
        List<Arquivo> lista = dao.getAllFiles();

        // Dados para o RELATORIO
        JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(lista);

        // PASSO 1 - Caminho do relatório
        InputStream rel = getClass().getResourceAsStream("../report/Arquivo.jasper");

        // PASSO 2 - Criar parâmetros de Pesquisa 
        Map parametros = new HashMap();

        // PASSO 3 - Carregar o relatório com os dados
        JasperPrint print;
        // Passar o caminho do RELATORIO e os PARAMETROS dos PASSSOS 1 e 2 e os DADOS
        print = JasperFillManager.fillReport(rel, parametros, dados);

        // PASSO 4 - Mostrat em uma JANELA
        JasperViewer janela = new JasperViewer(print, false);
        janela.setVisible(true);

    }

}
