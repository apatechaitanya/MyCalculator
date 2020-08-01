package com.internshala.javafxapp;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox <String>choiceBox;
	@FXML
	public TextField userInput;
	@FXML
	public javafx.scene.control.Button convertBtn;

	private static final String C_To_F_TEXT = "Celsius To Fahrenheit";
	private static final String F_To_C_TEXT = "Fahrenheit To Celsius";
	public boolean isC_TO_F = true;


	@Override
	public void initialize(URL location, ResourceBundle resources) {



			choiceBox.getItems().add(C_To_F_TEXT);
			choiceBox.getItems().add(F_To_C_TEXT);

			choiceBox.setValue(C_To_F_TEXT);
			choiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) ->{ 
				
				if(newValue.equals(C_To_F_TEXT)){
					isC_TO_F = true;


				}
				else {
					isC_TO_F = false;

				}
			});
			convertBtn.setOnAction(event ->
					convert()
			);
	}
	private void convert() {
		String input =userInput.getText();
		float enteredTemprature = 0.0f;
		try{
			 enteredTemprature = Float.parseFloat(input);
		}catch (Exception e)    {
			warnUser();
			return;
		}

		float newTemprature = 0.0f;

		if (isC_TO_F){
			newTemprature= (enteredTemprature*9/5)+32;
		}else{
			newTemprature = (enteredTemprature-32)*5/9;
		}
		display(newTemprature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Syntax error");
		alert.setContentText("Please enter a valid temprature");
		alert.show();
	}

	private void display(float newTemprature) {
		String unit = isC_TO_F? "F":"C";
		System.out.println("The new temprature is "+newTemprature + unit);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temprature is "+newTemprature+unit);
		alert.show();
	}


}

