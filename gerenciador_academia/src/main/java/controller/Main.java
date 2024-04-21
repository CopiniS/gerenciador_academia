
package controller;

import models.ApplicationModel;
import views.ApplicationView;

public class Main {
    public static ControllerManager controllerManager; //Objeto controller.
    
    public static void main(String[] args) {
        ApplicationModel model = new ApplicationModel();  //Objeto do model.
        ApplicationView view = new ApplicationView();     //Objeto da view.
        
        controllerManager = new ControllerManager(model, view); //Inicializa o controller.
        controllerManager.start();  
    }
}
