
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ApplicationModel;
import views.ApplicationView;

public class Main {
    public static ControllerManager controllerManager; //Objeto controller.
    
    public static void main(String[] args) {
        String idioma;
        String pais;
 
        if(args.length != 2){ 
            idioma = System.getProperty("user.language"); //idioma na config do sistema operacional
            pais = System.getProperty("user.country"); //pais na config do sistema operacional
        }else{ 
            idioma = args[0]; //idioma enviado por cli
            pais = args[1]; //pais enviado por cli
        }
        
        String busca = idioma + "_" + pais;
        boolean temTraducao = false;
        File diretorio = new File("idiomas");
        File[] listagemDiretorio = diretorio.listFiles();
        if (listagemDiretorio != null) { //lista de arquivos encontrados
            for (File arquivo : listagemDiretorio) {
                if(arquivo.getName().contains(busca)){
                    temTraducao = true;
                    break;
                } 
            }
        }
        if(!temTraducao){ 
            idioma = "pt";
            pais = "BR";
        }
        
        Locale localCorrente;
        ResourceBundle traducoes = null;
        
        InputStream newInputStream;
        String nomeArquivo = "./idiomas/MessagesBundle_"+idioma+"_"+pais+".properties";
        System.out.println("Carregando arquivo de propriedades: " + nomeArquivo);
        try {
            newInputStream = Files.newInputStream(Paths.get(nomeArquivo));
            traducoes = new PropertyResourceBundle(newInputStream);
            System.out.println("Arquivo de propriedades carregado com sucesso.");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        ApplicationModel model = new ApplicationModel();  //Objeto do model.
        ApplicationView view = new ApplicationView();     //Objeto da view.
        
        controllerManager = new ControllerManager(model, view, traducoes); //Inicializa o controller.
        controllerManager.start();  
    }
}
