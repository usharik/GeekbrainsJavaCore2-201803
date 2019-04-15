package ru.geekbrains.hw4.sample;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    TextArea textAreaField;

    @FXML
    TextField textField;

    @FXML
    ToggleGroup style;

    @FXML
    RadioButton RadioBtnPink;

    @FXML
    RadioButton RadioBtnBlue;

    @FXML
    RadioButton RadioBtnGreen;

    @FXML
    RadioButton RadioBtnGrey;

    @FXML
    RadioButton RadioBtnYellow;

    @FXML
    RadioButton RadioBtnNone;

    @FXML
    VBox test;

    public void SendMsg() {
        textAreaField.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }

    public void NewStyle() {
        if(RadioBtnPink.isSelected()){
            test.getStylesheets().clear();
            test.getStylesheets().add("ru/geekbrains/hw4/sample/css/Style_pink.css");
        }
        else if(RadioBtnBlue.isSelected()){
            test.getStylesheets().clear();
            test.getStylesheets().add("ru/geekbrains/hw4/sample/css/Style_blue.css");
        }
        else if(RadioBtnGreen.isSelected()){
            test.getStylesheets().clear();
            test.getStylesheets().add("ru/geekbrains/hw4/sample/css/Style_green.css");
        }
        else if(RadioBtnGrey.isSelected()){
            test.getStylesheets().clear();
            test.getStylesheets().add("ru/geekbrains/hw4/sample/css/Style_grey.css");
        }
        else if(RadioBtnYellow.isSelected()){
            test.getStylesheets().clear();
            test.getStylesheets().add("ru/geekbrains/hw4/sample/css/Style_yellow.css");
        }
        else {
            test.getStylesheets().clear();
            test.getStylesheets().add("ru/geekbrains/hw4/sample/css/Style.css");
        }
    }
}
