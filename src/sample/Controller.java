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
import javafx.scene.input.MouseEvent;
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
    public RadioButton RI;
    public RadioButton AE;
    public RadioButton TK;
    public RadioButton EE;
    public RadioButton Da;
    public RadioButton Ne;
    public RadioButton Prva;
    public RadioButton Druga;
    public RadioButton Treca;
    public RadioButton redovan_samofinansirajuci;
    public RadioButton redovan;
    public ComboBox ciklus_studija;
    String odsjek, godina, status, pripadnikBorOrg, ciklus, kime, kprezime, kbrindexa, kjmbg, kdatum, kmjesto, kadresa,ktelefon, kmail;
    public DatePicker datum_rodjenja;
    public Date datumRodjenja;
    public String d;
    public boolean imeChecked=false, prezimeChecked=false, broj_indexaChecked=false, JBMGChecked=false, mjesto_rodjenjaChecked=false, adresaChecked=false;
    public boolean telefonChecked=false, emailChecked=false, datum_rodjenjaChecked=false;

    public void pogasiSveSem(){
        ime.setStyle("-fx-background-color: white;");;;
         prezime.setStyle("-fx-background-color: white;");;;
         broj_indexa.setStyle("-fx-background-color: white;");;;
        JMBG.setStyle("-fx-background-color: white;");;;
         mjesto_rodjenja.setStyle("-fx-background-color: white;");;;
        adresa.setStyle("-fx-background-color: white;");;;
        telefon.setStyle("-fx-background-color: white;");;;
        email.setStyle("-fx-background-color: white;");;;
    }
    public void initialize(){
        ToggleGroup toggleGroup = new ToggleGroup();
        RI.setToggleGroup(toggleGroup);
        AE.setToggleGroup(toggleGroup);
        EE.setToggleGroup(toggleGroup);
        TK.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                if(String.valueOf(new_toggle).contains("RI")) odsjek = "RI";
                else if(String.valueOf(new_toggle).contains("AE")) odsjek = "AE";
                else if(String.valueOf(new_toggle).contains("EE")) odsjek = "EE";
                else if(String.valueOf(new_toggle).contains("TK")) odsjek = "TK";
                System.out.println(odsjek);
            }
        });

        ToggleGroup toggleGroup2 = new ToggleGroup();
        Da.setToggleGroup(toggleGroup2);
        Ne.setToggleGroup(toggleGroup2);
        toggleGroup2.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                if(String.valueOf(new_toggle).contains("Da")) pripadnikBorOrg = "da";
                else if(String.valueOf(new_toggle).contains("Ne")) pripadnikBorOrg = "ne";
                System.out.println(pripadnikBorOrg);
            }
        });

        ToggleGroup toggleGroup3 = new ToggleGroup();
        Prva.setToggleGroup(toggleGroup3);
        Druga.setToggleGroup(toggleGroup3);
        Treca.setToggleGroup(toggleGroup3);
        toggleGroup3.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                if(String.valueOf(new_toggle).contains("Prva")) godina = "prva";
                else if(String.valueOf(new_toggle).contains("Druga")) godina = "druga";
                else if(String.valueOf(new_toggle).contains("Treca")) godina = "treca";
                System.out.println(godina);
            }
        });

        ToggleGroup toggleGroup4 = new ToggleGroup();
        redovan_samofinansirajuci.setToggleGroup(toggleGroup4);
        redovan.setToggleGroup(toggleGroup4);
        toggleGroup4.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                                Toggle toggle, Toggle new_toggle) {
                if(String.valueOf(new_toggle).contains("'redovan samofinancirajuci'")) status = "redovan samofinansirajuci";
                else if(String.valueOf(new_toggle).contains("redovan")) status = "redovan";

                System.out.println(status);
            }
        });


        ime.setStyle("-fx-background-color: lightgreen;");;
        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                pogasiSveSem();
                if(newValue.matches(".*\\d+.*")){
                    imeChecked = true;
                    ime.setStyle("-fx-background-color: red;");;
                }
                else{
                    ime.setStyle("-fx-background-color: lightgreen;");;
                    imeChecked = false;
                    kime = newValue;
                }
            }
        });
        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                pogasiSveSem();
                if(newValue.matches(".*\\d+.*")){
                    prezimeChecked = true;
                    prezime.setStyle("-fx-background-color: red;");;
                }
                else{
                    prezime.setStyle("-fx-background-color: lightgreen;");;
                    prezimeChecked = false;
                    kprezime = newValue;
                }
            }
        });
        broj_indexa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                pogasiSveSem();
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() != 5){
                    broj_indexaChecked = true;
                    broj_indexa.setStyle("-fx-background-color: red;");;
                }
                else{
                    broj_indexa.setStyle("-fx-background-color: lightgreen;");;
                    broj_indexaChecked = false;
                    kbrindexa = newValue;
                }
            }
        });
        JMBG.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                pogasiSveSem();
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() != 13){
                    JBMGChecked = true;
                    JMBG.setStyle("-fx-background-color: red;");;
                }
                else{
                    JMBG.setStyle("-fx-background-color: lightgreen;");;
                    JBMGChecked = false;
                    kjmbg = newValue;
                }
            }
        });
        telefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                pogasiSveSem();
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() != 9){
                    telefonChecked = true;
                    telefon.setStyle("-fx-background-color: red;");;
                }
                else{
                    telefon.setStyle("-fx-background-color: lightgreen;");;
                    ktelefon = newValue;
                }
            }
        });
        email.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                pogasiSveSem();
                if(!(newValue.contains("@hotmail.com") || newValue.contains("@outlook.com") || newValue.contains("@yahoo.com") || newValue.contains("@gmail.com"))){
                    emailChecked = true;
                    email.setStyle("-fx-background-color: red;");;
                }
                else{
                    email.setStyle("-fx-background-color: lightgreen;");;
                    emailChecked = false;
                    kmail = newValue;
                }
            }
        });
        mjesto_rodjenja.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String temp = newValue.substring(newValue.length()-1);
                pogasiSveSem();
                if(newValue.matches(".*\\d+.*")){
                    mjesto_rodjenjaChecked = true;
                    mjesto_rodjenja.setStyle("-fx-background-color: red;");;
                }
                else{
                    mjesto_rodjenja.setStyle("-fx-background-color: lightgreen;");;
                    kmjesto = newValue;
                }
            }
        });

    }

    public void dateHandler(ActionEvent actionEvent) {
        LocalDate temp = datum_rodjenja.getValue();
        LocalDate temp2;
        String temp3 = JMBG.getText();
        String date = "";
        if(temp3.length() > 9) date = "1"+temp3.substring(4, 7)+"-"+temp3.substring(2, 4)+"-"+temp3.substring(0, 2);
        LocalDate localDate = LocalDate.parse(date);
        System.out.println((String.valueOf(temp)));
        System.out.println(date);

        if(JBMGChecked || !date.equals(String.valueOf(temp))){
            datum_rodjenjaChecked = true;
            datum_rodjenja.setStyle("-fx-background-color: red;");;
        }
        else{
            datum_rodjenja.setStyle("-fx-background-color: lightgreen;");;
        }
        d = date;
    }
   

    public void ciklusKliknut(ActionEvent actionEvent) {
        String tr = "";
        tr = String.valueOf(ciklus_studija.getValue());
        if(String.valueOf(tr).contains("bachelor")) ciklus = "bachelor";
        else if(String.valueOf(tr).contains("master")) ciklus = "master";
        else if(String.valueOf(tr).contains("doktorski studij")) ciklus = "doktorski studij";
        else if(String.valueOf(tr).contains("strucni studij")) ciklus = "strucni studij";
        System.out.println(tr);
    }

    public void upisZavrsen(ActionEvent actionEvent) {
        //System.out.println(kime);
        if((imeChecked || prezimeChecked || broj_indexaChecked || JBMGChecked || mjesto_rodjenjaChecked || adresaChecked ||
        telefonChecked || emailChecked ||datum_rodjenjaChecked))
        System.out.println("Ime "+ime.getText()+" prezime " +prezime.getText() + " broj indexa " + broj_indexa.getText()
                            +" JMBG " +JMBG.getText() + " datum rodjenja "+ d + " mjesto rodjenja "+mjesto_rodjenja.getText()
                            + " adresa "+adresa.getText()+ " telefon "+telefon.getText()+ " email "+email.getText()
                            + " odsjek" + odsjek + " godina "+godina + " status "+status+ " ciklus studija "+ciklus
                            + "pripadnost borackim kategorijama "+pripadnikBorOrg);
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Nije validno");
            alert.setHeaderText("Popunjeni formular nije validan");
            alert.show();
        }
    }
}
