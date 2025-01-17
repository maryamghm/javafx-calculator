package dci.javafx.javafxcalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField resultTextField;
    @FXML
    private TextField arg2TextField;
    @FXML
    private TextField arg1TextField;

    private double arg1;
    private double arg2;
    private double result;

    @FXML
    public void onAddButtonClick(ActionEvent actionEvent) {
        performOperation(Operation.ADDITION);
    }

    @FXML
    public void onSubtractButtonClick(ActionEvent actionEvent) {
        performOperation(Operation.SUBTRACTION);
    }

    @FXML
    public void onMultiplyButtonClick(ActionEvent actionEvent) {
        performOperation(Operation.MULTIPLICATION);
    }

    @FXML
    public void onDivideButtonClick(ActionEvent actionEvent) {
        performOperation(Operation.DIVISION);
    }

    private void setArguments() {
        try {
            arg1 = Double.parseDouble(arg1TextField.getText());
            arg2 = Double.parseDouble(arg2TextField.getText());
            errorLabel.setText("");
        } catch (NumberFormatException e) {
            resultTextField.setText("");
            errorLabel.setText("Error: Invalid input.");
            throw new IllegalArgumentException("Invalid input", e);
        }
    }

    private void performOperation(Operation operation) {
        try {
            setArguments();
            switch (operation) {
                case ADDITION -> result = arg1 + arg2;
                case SUBTRACTION -> result = arg1 - arg2;
                case MULTIPLICATION -> result = arg1 * arg2;
                case DIVISION -> {
                    if (arg2 == 0) {
                        errorLabel.setText("Error: Division by zero.");
                        resultTextField.setText("");
                        return;
                    }
                    result = arg1 / arg2;
                }
            }
            resultTextField.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {

            resultTextField.setText("");
        }
    }

    private enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }
}
