package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Controller {

    private String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button shifroButton;

    @FXML
    private Button deSifroButton;

    @FXML
    private TextField massField;

    @FXML
    private PasswordField keyField;

    @FXML
    private Button delete;

    @FXML
    private TextField shifrFieldMass;

    @FXML
    void initialize() {
        shifroButton.setOnAction(event -> {
            if (keyField.getText().trim().length() == 0) {
                keyField.setText("0"); // keyField not null
            }
            String keyFieldStr = keyField.getText();
            int keyFieldInt = Integer.parseInt(keyFieldStr); //keyField in Int
            System.out.println(keyFieldInt);
            String massFieldStr = massField.getText(); //massField in String

            char[] alphabetChar = alphabet.toCharArray();
            char[] massFieldStrChar = massFieldStr.toCharArray();
            String shMass = "";

            for (int i = 0; i < massFieldStrChar.length; i++) {

                int flag = 0;
                for (int j = 0; j < alphabetChar.length; j++) {
                    if (massFieldStrChar[i] == alphabetChar[j]) {
                        flag++;
                        if (flag == 1) {
                            shMass += alphabetChar[j + (keyFieldInt % 32)];

                        }
                    }
                }
            }
            System.out.println(keyFieldInt % 32);
            shifrFieldMass.setText(shMass);
        });

        deSifroButton.setOnAction(event -> {
            if (keyField.getText().trim().length() == 0) {
                keyField.setText("0"); // keyField not null
            }
            String keyFieldStr = keyField.getText();
            int keyFieldInt = Integer.parseInt(keyFieldStr); //keyField in Int

            String massFieldStr = massField.getText(); //massField in String

            char[] alphabetChar = alphabet.toCharArray();
            char[] massFieldStrChar = massFieldStr.toCharArray();
            String shMass = "";

            for (int i = 0; i < massFieldStrChar.length; i++) {

                int flag = 0;

                for (int j = 33; j < alphabetChar.length; j++) {
                    if (massFieldStrChar[i] == alphabetChar[j]) {
                        flag++;
                        if (flag == 1) {
                            shMass += alphabetChar[j - (keyFieldInt % 32)];
                        }
                    }
                }
            }

            shifrFieldMass.setText(shMass);
        });

        delete.setOnAction(event -> {
            massField.setText(null);
            keyField.setText(null);
            shifrFieldMass.setText(null);
        });
    }
}