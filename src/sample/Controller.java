package sample;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.sun.prism.paint.Color;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.event.PaintEvent.PAINT;

public class Controller {

    public TextField ime;
    public TextField prezime;
    public TextField broj_indexa;
    public TextField JMBG;
    public TextField mjesto_rodjenja;
    public TextField adresa;
    public TextField telefon;
    public TextField email;
    public DatePicker datum_rodjenja;
    public Date datumRodjenja;
    public boolean imeChecked=false, prezimeChecked=false, broj_indexaChecked=false, JBMGChecked=false, mjesto_rodjenjaChecked=false, adresaChecked=false;
    public boolean telefonChecked=false, emailChecked=false, datum_rodjenjaChecked=false;
    public void initialize(){
        ime.setStyle("-fx-background-color: lightgreen;");;
        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches(".*\\d+.*")){
                    imeChecked = true;
                    ime.setStyle("-fx-background-color: red;");;
                }
                else{
                    ime.setStyle("-fx-background-color: lightgreen;");;
                }
            }
        });
        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.matches(".*\\d+.*")){
                    prezimeChecked = true;
                    prezime.setStyle("-fx-background-color: red;");;
                }
                else{
                    prezime.setStyle("-fx-background-color: lightgreen;");;
                }
            }
        });
        broj_indexa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() > 5){
                    broj_indexaChecked = true;
                    broj_indexa.setStyle("-fx-background-color: red;");;
                }
                else{
                    broj_indexa.setStyle("-fx-background-color: lightgreen;");;
                }
            }
        });
        JMBG.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() > 13){
                    JBMGChecked = true;
                    JMBG.setStyle("-fx-background-color: red;");;
                }
                else{
                    JMBG.setStyle("-fx-background-color: lightgreen;");;
                }
            }
        });
        telefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() > 9){
                    telefonChecked = true;
                    telefon.setStyle("-fx-background-color: red;");;
                }
                else{
                    telefon.setStyle("-fx-background-color: lightgreen;");;
                }
            }
        });
        email.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!(newValue.contains("@hotmail.com") || newValue.contains("@outlook.com") || newValue.contains("@yahoo.com") || newValue.contains("@gmail.com"))){
                    emailChecked = true;
                    email.setStyle("-fx-background-color: red;");;
                }
                else{
                    email.setStyle("-fx-background-color: lightgreen;");;
                }
            }
        });
    }

    public void dateHandler(ActionEvent actionEvent) {
        LocalDate temp = datum_rodjenja.getValue();
    }
}
