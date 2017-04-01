/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

/**
 *
 * @author Guilherme
 */
import Jframe.TestePathDaClasse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Início da classe de conexão//
public class ConexaoBD {

    static String status = "Não Conectou...";

    Connection con;
    String user;    
    String banco;
    String host;
    String porta;
    
    String url;
    String driver = "org.postgresql.Driver";

    String password = "1";

    public ConexaoBD() {
        conectar();    
    }

    public Connection conectar() {
        try {
            lerArquivo();
        } catch (Exception ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Class.forName(driver);
            if(host.equals("localhost")){
                password = "root";
                
            }
            con = DriverManager.getConnection(url, user, password);
            status = "Concetado...";

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível encontrar o Driver!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Não foi possível conectar ao banco!");
        }
        return con;
    }

    public Connection getConexao() {
        return con;
    }

    public void desconectar() {
        try {
            con.close();
            status = "Desconectado...";
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String statusConection() {
        return status;
    }

    static class Filprdcp {

        public Filprdcp() {
        }
    }

    public void lerArquivo() throws IOException, Exception {
        String[] linha = new String[5];
        String nomeArquivo = TestePathDaClasse.pathDaClasse(TestePathDaClasse.class) + 
                "SERVER.txt";
        nomeArquivo = nomeArquivo.replace("/", "\\");
        try {

            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            
            for(int i=0; i < linha.length ; i++){
                linha[i] = lerArq.readLine();
                
            }
                        
            iniciarVariaveis(linha);
            
            arq.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na abertura do arquivo: %s.\n" +
                    e.getMessage());
        }
        url = "jdbc:postgresql://" + host + ":" + porta + "/" + banco;
        
    }
    
    public void iniciarVariaveis(String[] SERVER){
        
        user = SERVER[0].substring(SERVER[0].indexOf("'"), SERVER[0].length());
        banco = SERVER[1].substring(SERVER[1].indexOf("'"), SERVER[1].length());
        host = SERVER[2].substring(SERVER[2].indexOf("'"), SERVER[2].length());
        porta = SERVER[3].substring(SERVER[3].indexOf("'"), SERVER[3].length());
        
        user = user.replace("'", "");
        banco = banco.replace("'", "");
        host = host.replace("'", "");
        porta = porta.replace("'", "");
        
        
        
    }

    

}
