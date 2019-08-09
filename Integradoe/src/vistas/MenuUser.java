/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Preparable;
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
public final class MenuUser implements Preparable {
    
    private Button registro;
    private Button mostrar;
    private Button salir;
    private VBox root;
    private Scene menuScene;
    private final Stage ventana;
    
    public MenuUser(Stage s){
        ventana = s;
        initializeComponents();
        giveStyle();
        giveActions();
    }
    
   

    public Scene getMenuScene() {
        return menuScene;
    }
    
    private void registrar(){
        ventana.setScene(new IngresoNotas(ventana).getNotasScene());
    }
    
    private void mostrar(){
        ventana.setScene(new MostrarEstudiante(ventana).getmScene());
    }
    
    private void salir(){
       Platform.exit();
    }
    
    @Override
    public void giveActions(){
        registro.setOnAction(e->registrar());
        mostrar.setOnAction(e->mostrar());
        salir.setOnAction(e->salir());
    }

    @Override
    public void initializeComponents() {
        registro = new Button("Registro de estudiantes");
        mostrar = new Button("Mostrar estudiantes");
        salir = new Button("Salir");
        root = new VBox(registro, mostrar, salir);
        menuScene = new Scene(root, 400, 400);
        menuScene.getStylesheets().add("/integradoe/stylesDef.css");
    }

    @Override
    public void giveStyle() {
        registro.setId("shiny-orange");
        mostrar.setId("shiny-orange");
        salir.setId("shiny-orange");
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setId("rootMenu");
    }
    
}
