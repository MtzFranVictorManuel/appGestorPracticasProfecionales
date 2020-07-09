/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales.profesor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLIndexProfesorController implements Initializable {
    
    @FXML
    private Label txtCoordinado;
    @FXML
    private void cerrarSesion(ActionEvent event){
        salir();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void salir(){
    try {
        Stage stage = (Stage) txtCoordinado.getScene().getWindow();

        Scene peregil = new Scene(FXMLLoader.load(getClass().getResource("/appgestorpracticasprofecionales/FXMLindexNew.fxml")));
        stage.setScene(peregil);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLIndexProfesorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
