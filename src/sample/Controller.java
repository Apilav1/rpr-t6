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
    public static boolean neispravanFormular = true;
    String odsjek, godina, status, pripadnikBorOrg, ciklus, kime, kprezime, kbrindexa, kjmbg, kdatum, kmjesto, kadresa,ktelefon, kmail;
    public DatePicker datum_rodjenja;
    public Date datumRodjenja;
    public String d;
    public boolean imeChecked=false, prezimeChecked=false, broj_indexaChecked=false, JBMGChecked=false, mjesto_rodjenjaChecked=false, adresaChecked=false;
    public boolean telefonChecked=false, emailChecked=false, datum_rodjenjaChecked=false, datePickedCheched=false;

    public boolean getNeispravnaFormular(){
        return neispravanFormular;
    }
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
                //javafx.scene.paint.Paint fx = ime.getBackground().getFills().get(0).getFill();
                //if(ime.getBackground().isEmpty()) ime.getBackground().;//  .getFills().get(0).getFill();
                //System.out.println(ime.getStyle());
                //Paint color3 = new java.awt.Color(255, 0, 0);
                //System.out.println("bojaaaaaaa jedannnnn: "+ Color.decode(String.valueOf(fx)));
                //System.out.println("bojaaaaaaa dvaaaaa:::"+color3);
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
                //provjera JMBG
                //DD MM GGG RR BBB K
                //za RR
                String nastavakZaGrad="";
                if(mjesto_rodjenja.getText().toLowerCase().equals("sarajevo")) nastavakZaGrad = "17";
                if(mjesto_rodjenja.getText().toLowerCase().equals("banja luka")) nastavakZaGrad = "10";
                if(mjesto_rodjenja.getText().toLowerCase().equals("bihac")) nastavakZaGrad = "11";
                if(mjesto_rodjenja.getText().toLowerCase().equals("doboj")) nastavakZaGrad = "11";
                if(mjesto_rodjenja.getText().toLowerCase().equals("gorazde")) nastavakZaGrad = "13";
                if(mjesto_rodjenja.getText().toLowerCase().equals("moastar")) nastavakZaGrad = "15";
                //10-19 – Bosna i Hercegovina
                //             o 10 - Banja Luka
                //             o 11 - Bihać
                //             o 12 - Doboj
                //             o 13 - Goražde
                //             o 14 - Livno
                //             o 15 - Mostar
                //             o 16 - Prijedor
                //             o 17 - Sarajevo
                //             o 18 - Tuzla
                //             o 19 - Zenica
                //K - kontrolna cifra
                //                                                            abcdefghijklm
                //Kontrolna cifra se izračunava formulom gdje DDMMGGGRRBBBK = ABVGDĐEŽZIJKL
                int m=0, kontrola=1;
                if(JMBG.getText().length() == 13) {
                    int a = Integer.parseInt(newValue.charAt(0) + "");
                    int b = Integer.parseInt(newValue.charAt(1) + "");
                    int c = Integer.parseInt(newValue.charAt(2) + "");
                    int d = Integer.parseInt(newValue.charAt(3) + "");
                    int e = Integer.parseInt(newValue.charAt(4) + "");
                    int f = Integer.parseInt(newValue.charAt(5) + "");
                    int g = Integer.parseInt(newValue.charAt(6) + "");
                    int h = Integer.parseInt(newValue.charAt(7) + "");
                    int i = Integer.parseInt(newValue.charAt(8) + "");
                    int j = Integer.parseInt(newValue.charAt(9) + "");
                    int k = Integer.parseInt(newValue.charAt(10) + "");
                    int l = Integer.parseInt(newValue.charAt(11) + "");
                     m = Integer.parseInt(newValue.charAt(12) + "");
                    kontrola = 11 - ((7 * (a + g) + 6 * (b + h) + 5 * (c + i) + 4 * (d + j) + 3 * (e + k) + 2 * (f + l)) % 11);
                    if(m == kontrola) System.out.println("---------------------tacnooo--------------------------------------------");
                    System.out.println("------------------------"+newValue.substring(7, 9)+"-----------------------------------------");
                    System.out.println("---------------------------"+b+"--------------------------------------");
                    System.out.println("------------------------"+c+"-----------------------------------------");
                    System.out.println("---------------------------"+d+"--------------------------------------");
                    System.out.println("------------------------"+e+"-----------------------------------------");
                    System.out.println("---------------------------"+f+"--------------------------------------");
                    System.out.println("------------------------"+g+"-----------------------------------------");
                    System.out.println("---------------------------"+h+"--------------------------------------");
                    System.out.println("------------------------"+i+"-----------------------------------------");
                    System.out.println("---------------------------"+j+"--------------------------------------");
                    System.out.println("------------------------"+k+"-----------------------------------------");
                    System.out.println("---------------------------"+l+"--------------------------------------");
                    System.out.println("------------------------"+m+"-----------------------------------------");
                    System.out.println("--------------------------"+kontrola+"---------------------------------------");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("-----------------------------------------------------------------");
                }
                // % predstavlja MOD ili ostatak deljenja a ne / ili znak za deljenje
                //Izraz u zagradi deli se sa 11. Pri deljenju se dobija ostatak koji se oduzima od 11 i tako se dobija L
                //
                //ako je kontrolna cifra između 1 i 9, ostaje ista (L = K)
                //ako je kontrolna cifra veća od 9, postaje nula (L = 0)
                if(Pattern.matches("[a-zA-Z]+", temp) || newValue.length() != 13 ||
                    !nastavakZaGrad.equals(newValue.substring(7, 9)) ||
                    m!=kontrola){
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
        if(temp3.length() > 0) {
            datum_rodjenjaChecked = false;
            datePickedCheched = false;
            date = "1" + temp3.substring(4, 7) + "-" + temp3.substring(2, 4) + "-" + temp3.substring(0, 2);
            LocalDate localDate = LocalDate.parse(date);
            System.out.println((String.valueOf(temp)));
            System.out.println(date);

            if(JBMGChecked || !date.equals(String.valueOf(temp))){
                datum_rodjenjaChecked = true;
                datum_rodjenja.setStyle("-fx-background-color: red;");;
                datePickedCheched = true;
            }
            else{
                datum_rodjenja.setStyle("-fx-background-color: lightgreen;");;
                datum_rodjenjaChecked = false;
                datePickedCheched = false;
            }
        }
        else{
            datum_rodjenja.setStyle("-fx-background-color: red;");;
            datum_rodjenjaChecked = true;
            datePickedCheched = true;
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

    public void upisZavrsen(ActionEvent actionEvent) throws IllegalStateException{
        //System.out.println(kime);
        try {
            neispravanFormular = false;
            if (ime.getText().equals("")) imeChecked = true;
            if (prezime.getText().equals("")) prezimeChecked = true;
            if (broj_indexa.getText().equals("")) broj_indexaChecked = true;
            if (JMBG.getText().equals("")) JBMGChecked = true;
            if (mjesto_rodjenja.getText().equals("")) mjesto_rodjenjaChecked = true;
            if (adresa.getText().equals("")) adresaChecked = true;
            if (telefon.getText().equals("")) telefonChecked = true;
            if (email.getText().equals("")) emailChecked = true;
            if (!(imeChecked || prezimeChecked || broj_indexaChecked || JBMGChecked || mjesto_rodjenjaChecked || adresaChecked ||
                    telefonChecked || emailChecked || datum_rodjenjaChecked))
                System.out.println("Ime " + ime.getText() + " prezime " + prezime.getText() + " broj indexa " + broj_indexa.getText()
                        + " JMBG " + JMBG.getText() + " datum rodjenja " + d + " mjesto rodjenja " + mjesto_rodjenja.getText()
                        + " adresa " + adresa.getText() + " telefon " + telefon.getText() + " email " + email.getText()
                        + " odsjek" + odsjek + " godina " + godina + " status " + status + " ciklus studija " + ciklus
                        + "pripadnost borackim kategorijama " + pripadnikBorOrg);
            else {
                neispravanFormular = false;
                System.out.println(neispravanFormular);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nije validno");
                alert.setHeaderText("Popunjeni formular nije validan");
                alert.show();
                throw new IllegalStateException();
            }
        }
        catch (Exception e){

        }
    }
}
