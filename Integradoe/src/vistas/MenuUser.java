/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MenuUser {
    
    private Button registro;
    private Button mostrar;
    private Button salir;
    private VBox root;
    private Scene menuScene;
    private Stage ventana;
    
    public MenuUser(Stage s){
        ventana = s;
        iniciarComponentes();
        giveStyles();
        giveActions();
    }
    
    private void iniciarComponentes(){
        registro = new Button("Registro de estudiantes");
        mostrar = new Button("Mostrar estudiantes");
        salir = new Button("Salir");
        root = new VBox(registro, mostrar, salir);
        menuScene = new Scene(root, 400, 400);
        menuScene.getStylesheets().add("/integradoe/stylesDef.css");
    }
    
    private void giveStyles(){
        
        registro.setId("shiny-orange");
        mostrar.setId("shiny-orange");
        salir.setId("shiny-orange");
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setId("rootMenu");
        
    }

    public Scene getMenuScene() {
        return menuScene;
    }
    
    private void registrar(){
        ventana.setScene(new IngresoNotas(ventana).getNotasScene());
    }
    
    private void mostrar(){
        
    }
    
    private void salir(){
       ventana.close();
    }
    
    private void giveActions(){
        registro.setOnAction(e->registrar());
        mostrar.setOnAction(e->mostrar());
        salir.setOnAction(e->salir());
    }
    
}
