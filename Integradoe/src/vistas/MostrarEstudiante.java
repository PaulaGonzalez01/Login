<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Estudiante;
import clases.Preparable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 *
 * @author user
 */
public class MostrarEstudiante implements Preparable{
    private ObservableList<Estudiante> usersList = FXCollections.observableArrayList();
    
    private TableView table;
    private ComboBox<Estudiante> cFilter;
    private Label title;
    private Button regresar;

    @Override
    public void initializeComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void giveStyle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void giveActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MostrarEstudiante {
    private ObservableList<Estudiante> usersList = FXCollections.observableArrayList();
    
    private VBox root= new VBox();
    private Label titulo= new Label("Mostrar Estudiante");
    private TableView tabla = new TableView();
    private Button regresar = new Button("Regresar");
    private Scene escena= new Scene(root, 500, 500);
    private Stage ventana = new Stage();
    
    public MostrarEstudiante(Stage s){
        ventana=s;
        ConfiTable();
        giveActions();
    }

    public Scene getEscena() {
        return escena;
    }
    
    public void ConfiTable(){
        TableColumn<String,Estudiante> ColNombre= new TableColumn<>("Nombre");
        TableColumn<Double,Estudiante> ColNota1= new TableColumn<>("Nota Parcial");
        TableColumn<Double,Estudiante> ColNota2= new TableColumn<>("Nota Final");
        TableColumn<Double,Estudiante> ColNota3= new TableColumn<>("Mejoramineto");
        
        ColNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        ColNota1.setCellValueFactory(new PropertyValueFactory<>("Parcial"));
        ColNota2.setCellValueFactory(new PropertyValueFactory<>("Final"));
        ColNota3.setCellValueFactory(new PropertyValueFactory<>("Mejoramiento"));
        
        tabla.getColumns().add(ColNombre);
        tabla.getColumns().add(ColNota1);
        tabla.getColumns().add(ColNota2);
        tabla.getColumns().add(ColNota3);
        
        for (Estudiante e: IngresoNotas.estudiantes){
            tabla.getItems().add(e);
        }
        
    }
    
     private void giveActions(){
        regresar.setOnAction(e-> regresar());
        
    }
    private void regresar(){
        ventana.setScene(new MenuUser(ventana).getMenuScene()); 
        
    }
}
>>>>>>> 7006e7c62b08bde4394f1a155fc1ed950a63949d
