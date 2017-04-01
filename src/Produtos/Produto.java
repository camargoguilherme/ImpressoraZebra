package Produtos;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guilherme
 */
public class Produto implements Serializable {

    private String referencia;
    private String ean;
    private String descricao;
    private String preco;
    private String facebook;
    private String whatsapp;
    private String instagram;

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public Produto() {
    }

    public String getReferencia() {
        return referencia;
    }

    public String getEan() {
        return ean;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setFerencia(String referencia) {
        this.referencia = referencia;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public boolean imprimeDuasEtiquetas(PrintService printService) {
        String[] substring = new String[2];
        substring[1] = "";
        if (descricao.length() > 40) {
            substring[0] = descricao.substring(0, descricao.indexOf(" ", 35));
            substring[1] = descricao.substring(descricao.indexOf(" ", 35) + 1, descricao.length());
        } else {
            substring[0] = descricao;
        }

        String command
                = "^XA~TA000~JSN^LT0^MNW^MTD^PON^PMN^LH0,0^JMA^PR4,4~SD30^JUS^LRN^CI0^XZ"
                + "^XA"
                + "^MMT"
                + "^PW719"
                + "^LL0168"
                + "^LS0"
                + "^FO224,64^GFA,01536,01536,00016,:Z64:"
                + "eJztk7FOwzAQhs8k1BUD6QSVkOJudEBirYSJs/EILEgdy8jAwBBIoAMSA1lh4kFYMtHHqCWQuqEMIGUICU7ttke6wYIQpwz5/Of3f2c5AP/1F2ulxvRn7FNoYZYN6CEkKYUA61kDzjAHlKTmdQ2g2+UNIg27Sg0YpYlhTz3cARoZZpVOFw2p7zm3FgNO/ShK+YEjZlU8Yhe8LgchnYQlWr9Q/jB3ZJhof845lAWVQvtJHgSkLK001H6SqXzpkSzXTFPVX9InH5o9R3LuRA6Emfb3EzVfxCDUJ8DKaKpHQhqu5oe5Lgo1nwNLeiS07oqvfpdV+/tz/yw/Kk2+7o/N+nOtjHtW4lya/qv5BH3v07fQnF/BxbCMr1MzfxVPynGc6vNyocfXQcSxiqh4A1qnDTg82PSpD9+vuneJCTQTxJ3h1V2EeDAZ32N9e/LwiNhmo/0ttKe9M9q76Sx49XwyeELXhD4Xu6/oitNxELwgtm7bveM20o/sEx//Is1a/2DXF35FfQLA9Id0:F396"
                //
                + "^FO0,64^GFA,00512,00512,00008,:Z64:"
                + "eJxjYBj+YBGEEg0VANNcqxrANEuoA0RCSQEiLxoApjW0VoBpkVAIX0lpAYQPldfigMiLMkD4TApQ/YEQPscqiHpWqPlMShBrBEKo4hvqAgC85gth:0932"
                + "^FO0,96^GFA,00512,00512,00008,:Z64:"
                + "eJxjYBgyIDw0AUwrKT0A04GhNyASHR1gyhXKV2JaAaYdrkCkObsgtOM1BwhjFZT/RwBMM76A8F2/Qy1aApWfApFn0IBQLiEBUAUcYFJQMADKayDXSwMPACv5EbI=:7268"
                + "^FO0,128^GFA,00256,00256,00008,:Z64:"
                + "eJxjYKAb0Fq1AEyLhjpA+E0QvggDlN8FlWdF5bMwQvlM2OVFWAjod3VAsR8FAADeIg7X:EB40"
                //
                + "^FO608,64^GFA,01536,01536,00016,:Z64:"
                + "eJztk7FOwzAQhs8k1BUD6QSVkOJudEBirYSJs/EILEgdy8jAwBBIoAMSA1lh4kFYMtHHqCWQuqEMIGUICU7ttke6wYIQpwz5/Of3f2c5AP/1B2ulxvRn7FNoYZYN6CEkKYUA61kDzjAHlKTmdQ2g2+UNIg27Sg0YpYlhTz3cARoZZpVOFw2p7zm3FgNO/ShK+YEjZlU8Yhe8LgchnYQlWr9Q/jB3ZJhof845lAWVQvtJHgSkLK001H6SqXzpkSzXTFPVX9InH5o9R3LuRA6Emfb3EzVfxCDUJ8DKaKpHQhqu5oe5Lgo1nwNLeiS07oqvfpdV+/tz/yw/Kk2+7o/N+nOtjHtW4lya/qv5BH3v07fQnF/BxbCMr1MzfxVPynGc6vNyocfXQcSxiqh4A1qnDTg82PSpD9+vuneJCTQTxJ3h1V2EeDAZ32N9e/LwiNhmo/0ttKe9M9q76Sx49XwyeELXhD4Xu6/oitNxELwgtm7bveM20o/sEx//Is1a/2DXF35HfQJIdod0:26B4"
                //
                + "^FO384,64^GFA,00512,00512,00008,:Z64:"
                + "eJxjYBj2YBGEEg0VANNcqxrANEuoA0RCSQEiLxoApjW0VoBpkVAIX0lpAYQPldfigMiLMkD4TApQ/YEQPscqiHpWqPlMShBrBEKo4hsqAwDIRgth:17F7"
                + "^FO384,96^GFA,00512,00512,00008,:Z64:"
                + "eJxjYBgqIDw0AUwrKT0A04GhNyASHR1gyhXKV2JaAaYdrkCkObsgtOM1BwhjFZT/RwBMM76A8F2/Qy1aApWfApFn0IBQLiEBUAUcYFJQMADKayDXS4MAAAA9qhGy:AB82"
                + "^FO384,128^GFA,00256,00256,00008,:Z64:"
                + "eJxjYKAX0Fq1AEyLhjpA+E0QvggDlN8FlWdF5bMwQvlM2OVFWAjod3VAsR8VAADs+A7X:E3D1"
                //
                + "^FT6,67^A0N,48,64^FH\\^FDR$ " + preco + "^FS"
                + "^FT65,109^A0N,20,16^FH\\^FD" + whatsapp + "^FS"
                + "^FT65,133^A0N,20,16^FH\\^FD" + instagram + "^FS"
                + "^FT65,157^A0N,20,16^FH\\^FD" + facebook + "^FS"
                + "^FT243,61^A0N,28,14^FH\\^FD" + ean + "^FS"
                + "^FT30,14^A0N,10,14^FH\\^FD" + substring[0] + "^FS"
                + "^FT30,27^A0N,10,14^FH\\^FD" + substring[1] + "^FS"
                
                + "^FT380,67^A0N,48,64^FH\\^FDR$ " + preco + "^FS"
                + "^FT441,109^A0N,20,16^FH\\^FD" + whatsapp + "^FS"
                + "^FT441,133^A0N,20,16^FH\\^FD" + instagram + "^FS"
                + "^FT441,157^A0N,20,16^FH\\^FD" + facebook + "^FS"
                /*
                + "^FT441,109^A0N,20,16^FH\\^FDWhatsapp: " + whatsapp + "^FS"
                + "^FT441,133^A0N,20,16^FH\\^FDInstagran: " + instagram + "^FS"
                + "^FT411,157^A0N,20,16^FH\\^FDFacebook: " + facebook + "^FS"
                */
                + "^FT619,61^A0N,28,14^FH\\^FD" + ean + "^FS"
                + "^FT398,14^A0N,10,14^FH\\^FD" + substring[0] + "^FS"
                + "^FT398,27^A0N,10,14^FH\\^FD" + substring[1] + "^FS"
                + "^PQ1,0,1,Y^XZ";

        byte[] data;
        data = command.getBytes(StandardCharsets.US_ASCII);
        Doc doc = new SimpleDoc(data, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);

        try {
            printService.createPrintJob().print(doc, null);
            return true;
        } catch (PrintException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean imprimeUmaEtiquetas(PrintService printService) {
        String[] substring = new String[2];
        if (descricao.length() > 40) {
            substring[0] = descricao.substring(0, descricao.indexOf(" ", 35));
            substring[1] = descricao.substring(descricao.indexOf(" ", 35) + 1, descricao.length());
        } else {
            substring[0] = descricao;
        }
        String command1
                = "^XA~TA000~JSN^LT0^MNW^MTD^PON^PMN^LH0,0^JMA^PR4,4~SD30^JUS^LRN^CI0^XZ"
                + "^XA"
                + "^MMT"
                + "^PW719"
                + "^LL0168"
                + "^LS0"
                + "^FO224,64^GFA,01536,01536,00016,:Z64:"
                + "eJztk7FOwzAQhs8k1BUD6QSVkOJudEBirYSJs/EILEgdy8jAwBBIoAMSA1lh4kFYMtHHqCWQuqEMIGUICU7ttke6wYIQpwz5/Of3f2c5AP/1F2ulxvRn7FNoYZYN6CEkKYUA61kDzjAHlKTmdQ2g2+UNIg27Sg0YpYlhTz3cARoZZpVOFw2p7zm3FgNO/ShK+YEjZlU8Yhe8LgchnYQlWr9Q/jB3ZJhof845lAWVQvtJHgSkLK001H6SqXzpkSzXTFPVX9InH5o9R3LuRA6Emfb3EzVfxCDUJ8DKaKpHQhqu5oe5Lgo1nwNLeiS07oqvfpdV+/tz/yw/Kk2+7o/N+nOtjHtW4lya/qv5BH3v07fQnF/BxbCMr1MzfxVPynGc6vNyocfXQcSxiqh4A1qnDTg82PSpD9+vuneJCTQTxJ3h1V2EeDAZ32N9e/LwiNhmo/0ttKe9M9q76Sx49XwyeELXhD4Xu6/oitNxELwgtm7bveM20o/sEx//Is1a/2DXF35FfQLA9Id0:F396"
                //
                + "^FO0,64^GFA,00512,00512,00008,:Z64:"
                + "eJxjYBj+YBGEEg0VANNcqxrANEuoA0RCSQEiLxoApjW0VoBpkVAIX0lpAYQPldfigMiLMkD4TApQ/YEQPscqiHpWqPlMShBrBEKo4hvqAgC85gth:0932"
                + "^FO0,96^GFA,00512,00512,00008,:Z64:"
                + "eJxjYBgyIDw0AUwrKT0A04GhNyASHR1gyhXKV2JaAaYdrkCkObsgtOM1BwhjFZT/RwBMM76A8F2/Qy1aApWfApFn0IBQLiEBUAUcYFJQMADKayDXSwMPACv5EbI=:7268"
                + "^FO0,128^GFA,00256,00256,00008,:Z64:"
                + "eJxjYKAb0Fq1AEyLhjpA+E0QvggDlN8FlWdF5bMwQvlM2OVFWAjod3VAsR8FAADeIg7X:EB40"
                //
                + "^FT6,67^A0N,48,64^FH\\^FDR$ " + preco + "^FS"
                + "^FT65,109^A0N,20,16^FH\\^FD" + whatsapp + "^FS"
                + "^FT65,133^A0N,20,16^FH\\^FD" + instagram + "^FS"
                + "^FT65,157^A0N,20,16^FH\\^FD" + facebook + "^FS"
                + "^FT243,61^A0N,28,14^FH\\^FD" + ean + "^FS"
                + "^FT30,14^A0N,10,14^FH\\^FD" + substring[0] + "^FS"
                + "^FT30,27^A0N,10,14^FH\\^FD" + substring[1] + "^FS"
                + "^PQ1,0,1,Y^XZ";
        byte[] data;
        data = command1.getBytes(StandardCharsets.US_ASCII);
        Doc doc = new SimpleDoc(data, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);

        try {
            printService.createPrintJob().print(doc, null);
            return true;
        } catch (PrintException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean imprimirEtiqueta(PrintService printService, String qtdEtiqueta) {
        boolean result = false;
        if (printService == null) {
            System.err.println("[Print Label] print service or label is invalid.");
            return false;
        }
        if (Integer.parseInt(qtdEtiqueta) % 2 == 0) {
            for (int i = 0; i < (Integer.parseInt(qtdEtiqueta) / 2); i++) {
                result = imprimeDuasEtiquetas(printService);
            }

        } else {
            for (int i = 0; i < (Integer.parseInt(qtdEtiqueta) / 2); i++) {
                result = imprimeDuasEtiquetas(printService);
            }
            result = imprimeUmaEtiquetas(printService);

        }
        return result;
    }

}
