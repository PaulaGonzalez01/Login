/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Preparable;
import clases.User;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author FIMCP
 */
public class Login implements Preparable{
    
    private Label titulo;
    private Label user;
    private Label pass;
    private TextField t1;
    private PasswordField t2;
    private Button enter;
    private HBox container1;
    private HBox container2;
    private VBox root;
    private Scene logScene;
    private Stage ventana;
    
    public Login(Stage s){
        ventana = s;
        initializeComponents();
        giveStyle();
        giveActions();
    }
    
 
    public Scene getLogScene() {
        return logScene;
    }
    
    private void ingresar(){
        String username = t1.getText();
        String password = t2.getText();
        User teacher = new User(username, password);
        ArrayList<User> users = deserializar("users.ser");
        boolean isUser = false;
        System.out.println(teacher);
        for(User u: users){
            System.out.println(u);
            if(u.equals(teacher)){
                isUser = true;
                ventana.setScene(new MenuUser(ventana).getMenuScene());
            }
        }
        System.out.println(isUser);
        if(!isUser)IngresoNotas.mostrarAlerta("No se encuentra registrado como profesor actualmente", "Ingreso denegado");
    }
    
    private ArrayList<User> deserializar(String filename){
        ArrayList<User> allusers = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            
            allusers = (ArrayList<User>) ois.readObject();
            
        }catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allusers;
    }
    
    
    @Override
    public void giveActions(){
        enter.setOnAction(e->ingresar());
    }

    @Override
    public void initializeComponents() {
        titulo = new Label("LOGIN PROFESORES");
        user = new Label("Nombre de usuario: ");
        pass = new Label("Contraseña: ");
        t1 = new TextField();
        t2 = new PasswordField();
        enter = new Button("Ingresar");
        container1 = new HBox(user, t1);
        container2 = new HBox(pass, t2);
        root = new VBox(titulo, container1, container2, enter);
        logScene = new Scene(root, 500, 300);
    }

    @Override
    public void giveStyle() {
        root.setPadding(new Insets(50));
        root.setSpacing(20);
        root.setId("rootLogin");
        titulo.setId("title");
        container2.setSpacing(63.3333333333333333);
        root.setAlignment(Pos.CENTER);
        container1.setAlignment(Pos.BOTTOM_LEFT);
        container2.setAlignment(Pos.BOTTOM_LEFT);
        enter.setId("dark-blue");
        logScene.getStylesheets().add("/integradoe/stylesDef.css");
    }
    
}
