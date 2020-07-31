package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    private final int MIN = 1;
    private final int MAX = 99;

    private List<Integer> generatedNumbers;
    private Set<Integer> numbersSet;
    private List<Integer> chosenNumbers;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;

    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;

    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Label alertText;
    @FXML
    private Button alertButton;
    @FXML
    private Label resultText;

    @FXML
    public void handleButtonAction(ActionEvent actionEvent) {
        generateNumbers();

        label1.setText(String.valueOf(generatedNumbers.get(0)));
        label2.setText(String.valueOf(generatedNumbers.get(1)));
        label3.setText(String.valueOf(generatedNumbers.get(2)));
        label4.setText(String.valueOf(generatedNumbers.get(3)));
        label5.setText(String.valueOf(generatedNumbers.get(4)));

        collectNumbers();
        setResult();
    }

    private void generateNumbers() {
        generatedNumbers = new ArrayList<>();
        while(generatedNumbers.size() < 5) {
            int i = (int) (Math.random() * MAX) + MIN;
            if(!generatedNumbers.contains(i)) generatedNumbers.add(i);
        }
        generatedNumbers.sort(null);
    }

    private void collectNumbers() {
        numbersSet = new HashSet<>();
        try {
            numbersSet.add(Integer.parseInt(input1.getText()));
            numbersSet.add(Integer.parseInt(input2.getText()));
            numbersSet.add(Integer.parseInt(input3.getText()));
            numbersSet.add(Integer.parseInt(input4.getText()));
            numbersSet.add(Integer.parseInt(input5.getText()));
        } catch(Exception e) {
            alert("Nem jó számokat adtál meg!");
            return;
        }

        for(Integer number : numbersSet) {
            if (number < 1 || 99 < number) {
                alert("A számoknak 1 és 99 között kell lenniük!");
                return;
            }
        }

        if(numbersSet.size() != 5) {
            alert("A számoknak különbözőnek kell lenniük!");
            return;
        }
    }

    private void setResult() {
        int score = 0;
        chosenNumbers = new ArrayList<>(numbersSet);
        for(int i : generatedNumbers) {
            for(int j : chosenNumbers) {
                if (i == j) score++;
            }
        }
        resultText.setText("Eredmény: " + score);
    }

    private void alert(String text) {
        basePane.setOpacity(0.3);
        basePane.setDisable(true);
        alertPane.setVisible(true);
        alertText.setText(text);
    }

    @FXML
    public void handleAlertButton(ActionEvent actionEvent) {
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
        alertText.setText("");
    }

    // Mindig lefut
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
