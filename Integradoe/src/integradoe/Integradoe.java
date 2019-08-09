/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradoe;

import clases.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Login;
import javafx.application.Application;
import javafx.stage.Stage;
import vistas.IngresoNotas;

/**
 *
 * @author FIMCP
 */
public class Integradoe extends Application {
    
    public static ArrayList<User> profesores = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
//        profesores.add(new User("Jaime28","2020"));
//        profesores.add(new User("Patricia43","4040"));
//        profesores.add(new User("Miranda20","5050"));
//        profesores.add(new User("Paula30","6060"));
//        serializar("users.ser");
        primaryStage.setTitle("Sistema de ingreso de notas");
        primaryStage.setScene(new Login(primaryStage).getLogScene());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void serializar(String file){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(profesores);
        } catch (IOException ex) {
            Logger.getLogger(IngresoNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
