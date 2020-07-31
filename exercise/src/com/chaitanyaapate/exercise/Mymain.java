package com.chaitanyaapate.exercise;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class Mymain extends Application {
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("INIT");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("exc_layout.fxml"));
		Pane rootNode = fxmlLoader.load();
		MenuBar menuBar = createmenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene =new Scene(rootNode);
		primaryStage.setTitle("Doller");
		primaryStage.setScene(scene);
		primaryStage.show();


	}
	private MenuBar createmenu(){
		Menu fileMenu = new Menu("File");      //File menu
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("new menu item clicked");

		});

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);


		///Help menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		helpMenu.setOnAction(event -> {
			about();
		});
		helpMenu.getItems().addAll(aboutApp);



		//Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void about() {
		Alert alertDialog = new Alert(Alert.AlertType.WARNING);
		alertDialog.setTitle("$ CONVERTOR $");
		alertDialog.setHeaderText("$ Doller Convertor $");
		alertDialog.setContentText("This the java fx app which is used to convert amount doller into rupees and ruppes into doller");
		ButtonType btnyes = new ButtonType("Yes");
		ButtonType btnno = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(btnyes,btnno);
		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if (clickedBtn.isPresent()&&clickedBtn.get()==btnyes){
			System.out.println("  \nYES BUTTON IS CLICKED!");
		}
		if(clickedBtn.isPresent()&&clickedBtn.get() == btnno){
			System.out.println("\nNO BUTTON IS CLICKED!");
		}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}
