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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public final class MostrarEstudiante implements Preparable {

    private ObservableList<Estudiante> usersList;

    private TableView table;
    private ComboBox<Estudiante> cFilter;
    private Label title;
    private Label text;
    private Label message;
    private Button regresar;
    private BorderPane root;
    private Scene mScene;
    private final Stage stage;

    public MostrarEstudiante(Stage s){
        stage = s;
        initializeComponents();
        giveActions();
        giveStyle();
        configTable();
    }

    public Scene getmScene() {
        return mScene;
    }
    

    @Override
    public void initializeComponents() {
        usersList = FXCollections.observableArrayList(IngresoNotas.estudiantes);
        table = new TableView();
        cFilter = new ComboBox<>(usersList);
        title = new Label("Listado de estudiantes");
        text = new Label("Seleccione el filtro de búsqueda:");
        message = new Label();
        regresar = new Button("Regresar");
        root = new BorderPane(table, title, root, root, root);
    }

    @Override
    public void giveStyle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void giveActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configTable() {
        TableColumn<String, Estudiante> nameCol = new TableColumn<>("Nombres");
        TableColumn<Double, Estudiante> nota1Col = new TableColumn<>("Primer parcial");
        TableColumn<Double, Estudiante> nota2Col = new TableColumn<>("Segundo parcial");
        TableColumn<Double, Estudiante> nota3Col = new TableColumn<>("Mejoramiento");
        
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nota1Col.setCellValueFactory(new PropertyValueFactory<>("nota1"));
        nota2Col.setCellValueFactory(new PropertyValueFactory<>("nota2"));
        nota3Col.setCellValueFactory(new PropertyValueFactory<>("nota3"));
        
        table.getColumns().add(nameCol);
        table.getColumns().add(nota1Col);
        table.getColumns().add(nota2Col);
        table.getColumns().add(nota3Col);
        
        
        
//        table.getItems().add();
//        table.getItems().add();
        
               

    }
}
