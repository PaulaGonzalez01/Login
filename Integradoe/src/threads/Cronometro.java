/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author user
 */
public class Cronometro implements Runnable{
    private Label label;
    private int segundos;
    private int limite;

    public Cronometro(Label label, int limite) {
        this.label = label;
        this.limite = limite;
        this.segundos = 0;
    }
    
    
    
    @Override
    public void run() {
        while(segundos<limite){
            try {
                Thread.sleep(1000);
                segundos++;
                Platform.runLater(()->cambiarLabel());
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void cambiarLabel(){
        label.setText(String.valueOf(segundos));
    }
    
}
