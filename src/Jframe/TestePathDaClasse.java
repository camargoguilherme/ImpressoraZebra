/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframe;

import java.io.File;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class TestePathDaClasse {

    public TestePathDaClasse() {
    }

    /**
     * Retorna uma string indicando em que .jar a classe pôde ser encontrada, ou
     * então o diretório a partir do qual a classe foi encontrada. Por exemplo,
     * para java.lang.String, deve retornar algo como "C:/Program
     * Files/Java/jre1.5.0_08/lib/rt.jar" e para esta classe, o diretório onde
     * está a classe.
     */
    public static String pathDaClasse(Class klass) throws Exception {
        String className = "/" + klass.getName().replace('.', '/') + ".class";
        URL u = klass.getResource(className);
        String s = u.toString();

        if (s.startsWith("jar:file:/")) {
            // Deve ser algo como "jar:file:/C:/Program%20Files/Java/jre1.5.0_08/jre/lib/rt.jar!/java/lang/String.class"
            int pos = s.indexOf(".jar!/");
            if (pos != -1) {
                if (File.separator.equals("\\")) {
                    s = s.substring("jar:file:/".length(), pos + ".jar".length());
                } else {
                    s = s.substring("jar:file:".length(), pos + ".jar".length());
                }
                s = s.replaceAll("%20", " ");
            } else {
                s = "?";
            }
        } else if (s.startsWith("file:/")) {
            // Algo como "file:/C:/temp2/java/TestePathDaClasse.class"
            if (File.separator.equals("\\")) {
                s = s.substring("file:/".length());
            } else {
                s = s.substring("file:".length());
            }
            s = s.substring(0, s.lastIndexOf(className)).replaceAll("%20", " ");
        } else {
            s = "?";
            
        }
        s = s.substring(0,s.length()-"ImpressoraZebra.jar".length());
        return s;
        
        
    }

    public static void main(String[] args) throws Exception {
        TestePathDaClasse t = new TestePathDaClasse();
        // Deve mostrar algo como "C:/diretoriodaclasse"
        System.out.println(t.pathDaClasse(t.getClass()));
    }
}
