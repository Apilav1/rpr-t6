package sample;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
//import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javax.swing.*;
import java.awt.*;
import java.util.List;

@ExtendWith(ApplicationExtension.class)

class MainTest {
    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    @Test
    public void start (FxRobot robot) {
        TextField ime = robot.lookup("#ime").queryAs(TextField.class);
        assertEquals("", ime.getText());
    }
    @Test
    public void imeTest(FxRobot robot){
        TextField ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn("#ime");
        robot.write("Adi2");
        assertEquals("-fx-background-color: red;", ime.getStyle());
    }
    @Test
    public void prezimeTest(FxRobot robot){
        TextField p = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn("#prezime");
        robot.write("Pilav2");
        assertEquals("-fx-background-color: red;", p.getStyle());
    }
    @Test
    public void brojIndexaTest(FxRobot robot){
        TextField b = robot.lookup("#broj_indexa").queryAs(TextField.class);
        robot.clickOn("#broj_indexa");
        robot.write("1");
        assertEquals("-fx-background-color: red;", b.getStyle());
    }
    @Test
    public void JMBGTest(FxRobot robot){
        TextField j = robot.lookup("#JMBG").queryAs(TextField.class);
        robot.clickOn("#JMBG");
        robot.write("111111111111");
        assertEquals("-fx-background-color: red;", j.getStyle());
    }
    @Test
    public void emailTest(FxRobot robot){
        TextField e = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn("#email");
        robot.write("111111111111");
        assertEquals("-fx-background-color: red;", e.getStyle());
    }
    @Test
    public void telefonTest(FxRobot robot){
        TextField t = robot.lookup("#telefon").queryAs(TextField.class);
        robot.clickOn("#telefon");
        robot.write("111111111111");
        assertEquals("-fx-background-color: red;", t.getStyle());
    }
    @Test
    public void zavrsiTest(FxRobot robot){
        Button zavrsi = robot.lookup("#id_button").queryAs(Button.class);
        TextField ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn("#ime");
        robot.write("Adi2");
        TextField p = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn("#prezime");
        robot.write("Pilav2");
        TextField b = robot.lookup("#broj_indexa").queryAs(TextField.class);
        robot.clickOn("#broj_indexa");
        robot.write("1");
        TextField j = robot.lookup("#JMBG").queryAs(TextField.class);
        robot.clickOn("#JMBG");
        robot.write("111111111111");
        TextField e = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn("#email");
        robot.write("111111111111");
        TextField t = robot.lookup("#telefon").queryAs(TextField.class);
        robot.clickOn("#telefon");
        robot.write("111111111111");
        
        assertEquals(true, Controller.neispravanFormular);
    }
}