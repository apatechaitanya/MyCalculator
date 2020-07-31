package com.chaitanyaapate.exercise;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller<String> implements Initializable {
	@FXML
	public  TextField  textField;
	@FXML
	public Button clickbtn;
	@FXML
	private ImageView imageView;
	@FXML
	private ImageView imageView2;
	@FXML
	private ImageView imageView3;
	@FXML
	public ChoiceBox<java.lang.String> choiceBox;
	private static final java.lang.String d_to_r_Text = "Doller to Rupay";
	private static final java.lang.String r_to_d_Text = "Rupay to Doller";
	public boolean isD_TO_R = true;




	@Override

	public void initialize(URL location, ResourceBundle resources) {
		File file = new File("src/images.jpg");
		Image image = new Image(file.toURI().toString());
		imageView.setImage(image);

		File file1 = new File("src/download.png");
		Image image1 = new Image(file1.toURI().toString());
		imageView2.setImage(image1);

		File file2 = new File("src/bull.png");
		Image image2 = new Image(file2.toURI().toString());
		imageView3.setImage(image2);


			choiceBox.getItems().add(d_to_r_Text);
			choiceBox.getItems().add(r_to_d_Text);
			choiceBox.setValue(d_to_r_Text);
			choiceBox.getSelectionModel().selectedIndexProperty().addListener(((observable, oldValue, newValue) -> {
				if(newValue.equals(d_to_r_Text)){
					isD_TO_R = true;


				}
				else {
					isD_TO_R = false;

				}
			}));
		clickbtn.setOnAction(event -> {
			convert();
		});
	}

	private void convert() {

			long input = Long.parseUnsignedLong(textField.getText());


			long doller1 =  0l;
			try{
				doller1 =(input);
			}catch (Exception e){
				warnuser();
			}

			long b = 0;
			if (isD_TO_R){
				b = doller1*74;
				doo(b);
			}else {
				b = (long) (doller1*0.013);
				dooo(b);
			}
		}

	private void dooo(double b) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);

		alert.setTitle("$ Convertor :");
		alert.setHeaderText("$ UNITED STATE DOLLER $ ");
		alert.setContentText("USD is : "+(b));
		alert.show();
	}

	private void doo(double b) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);

		alert.setTitle("$ Convertor :");
		alert.setHeaderText("* INDIAN RUPEES *");
		alert.setContentText("ISD is : "+(b));
		alert.show();

	}


	private void warnuser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Syntax Error");
		alert.setContentText("Please enter the valid input");

		alert.show();
	}
}
