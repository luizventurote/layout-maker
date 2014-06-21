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

        /*
         * Obtendo o arquivo do relatório.
         * Note que estamos utilizando um InputStream para obter o arquivo que
         * está dentro do nosso projeto. Fazendo isso, não teremos problema
         * quando nosso projeto for empacotado em um .jar.
         *
         * Note que o caminho do .jasper inicia com /, ou seja, a raiz da
         * localização das classes compiladas do nosso projeto
         * (o pacote default).
         *
         * Utilize a aba Files (canto superior esquerdo) e veja que os arquivos
         * .jasper e .jrxml são copiados para o diretório /build/classes
         * e por consequencia para o .jar que for criado.
         *
         * Se não os estiver vendo, mande dar um Clean and Build no projeto
         * (botão direito no nó raiz do projeto, Clean and Build (Limpar e Construir)
         *
         */
        InputStream inputStream = getClass().getResourceAsStream("/report/Arquivos.jasper");

        // mapa de parâmetros do relatório (ainda vamos aprender a usar)
        Map parametros = new HashMap();
        
        // abre o relatório
        ReportUtils.openReport("Arquivos", inputStream, parametros, ConnectMySQL.startConnection());

    }

}
