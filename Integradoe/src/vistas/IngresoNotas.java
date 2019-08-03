/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Estudiante;
import clases.NotValidGrade;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class IngresoNotas {
    
    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    
    private Label titulo;
    private Label estudiante;
    private Label nota1;
    private Label nota2;
    private Label nota3;
    private TextField testudiante;
    private TextField tnota1;
    private TextField tnota2;
    private TextField tnota3;
    private Button registrar;
    private Button regresar;
    private VBox box1;
    private VBox box2;
    private HBox centerBox;
    private HBox buttonBox;
    private VBox root;
    private Scene notasScene;
    private Stage ventana;
    
    public IngresoNotas(Stage s){
        ventana = s;
        iniciarComponentes();
        giveActions();        
    }
    
    private void iniciarComponentes(){
        titulo = new Label("INGRESO DE NOTAS");
        estudiante = new Label("Nombre del estudiante");
        nota1 = new Label("Nota primer parcial");
        nota2 = new Label("Nota segundo parcial");
        nota3 = new Label("Nota mejoramiento");
        testudiante = new TextField();
        tnota1 = new TextField();
        tnota2 = new TextField();
        tnota3 = new TextField();
        registrar = new Button("Registrar");
        regresar = new Button("Regresar");
        box1 = new VBox(estudiante, testudiante, nota2, tnota2);
        box2 = new VBox(nota1, tnota1, nota3, tnota3);
        centerBox = new HBox(box1, box2);
        buttonBox = new HBox(registrar, regresar);
        root = new VBox(titulo, centerBox, buttonBox);
        notasScene = new Scene(root, 500, 500);
    }

    public Scene getNotasScene() {
        return notasScene;
    }
    
    private void ingresarNotas(){
        try {
            String nombre = testudiante.getText();
            double nota11 = Double.parseDouble(tnota1.getText());
            double nota22 = Double.parseDouble(tnota2.getText());
            double nota33 = Double.parseDouble(tnota3.getText());
            validarNotas(nota11, nota22, nota33);
            Estudiante estudiante1 = new Estudiante(nombre, nota11, nota22, nota33);
            estudiantes.add(estudiante1);
            serializar("estudiantes.ser");        
            mostrarAlerta("Datos del estudiante registrado con éxito","Saving Estudiante");
        } catch (NotValidGrade ex) {
            Logger.getLogger(IngresoNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    private void serializar(String file){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(estudiantes);
        } catch (IOException ex) {
            Logger.getLogger(IngresoNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void mostrarAlerta(String context, String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(context);
        alert.setTitle(title);
        alert.showAndWait();
    }
    
    private void giveActions(){
        registrar.setOnAction(e-> ingresarNotas());
        regresar.setOnAction(e->regresar());
        //Prueba git
        //linea2
        
    }
    
    private void regresar(){
        ventana.setScene(new MenuUser(ventana).getMenuScene());
    }
    
    private void validarNotas(double nota1, double nota2, double nota3) throws NotValidGrade{
        if(nota1>100 || nota1<0 || nota2>100 || nota2<0 || nota3>100 || nota3<0){
            throw new NotValidGrade("La nota no es válida. Sólo puede ingresar notas desde 0 a 100");
        }
    }
}