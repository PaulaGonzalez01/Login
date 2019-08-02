/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author user
 */
public class MostrarEstudiante {
    private ObservableList<Estudiante> usersList = FXCollections.observableArrayList();
    
    private TableView table; 
}
