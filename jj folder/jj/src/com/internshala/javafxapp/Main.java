package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Optional;

public class Main extends Application {


	public static void main(String[]args){
		launch(args);
	}

	@Override
	public  void init() throws Exception{
		System.out.printf("Init");
		super.init();
	}
	@Override
		public void start(Stage primaryStage) throws Exception {
		System.out.printf("Start");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
			VBox rootNode = loader.load();

			MenuBar menuBar = createMenu();
			rootNode.getChildren().add(0,menuBar);


			Scene scene = new Scene(rootNode);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Temprature Convertor Tool");
			primaryStage.show();

		}
		private  MenuBar createMenu(){
			Menu fileMenu = new Menu("File");      //File menu
			MenuItem newMenuItem = new MenuItem("New");

			newMenuItem.setOnAction(event -> System.out.println("new menu item clicked"));

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
				aboutApp();
			});
			helpMenu.getItems().addAll(aboutApp);



			//Menu Bar
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu,helpMenu);
			return menuBar;

		}


		public static void aboutApp(){

			Alert alertDialog = new Alert(Alert.AlertType.WARNING);
			alertDialog.setTitle("My First Desktop App");
			alertDialog.setHeaderText("Learning JavaFX");
			alertDialog.setContentText("I am just a beginner but soon i will be pro and start developing awesome apps");
			ButtonType btnyes = new ButtonType("Yes");
			ButtonType btnno = new ButtonType("No");
			alertDialog.getButtonTypes().setAll(btnyes,btnno);
			Optional<ButtonType>clickedBtn = alertDialog.showAndWait();

			if (clickedBtn.isPresent()&&clickedBtn.get()==btnyes){
				System.out.println("  \nYES BUTTON IS CLICKED!");
			}
			if(clickedBtn.isPresent()&&clickedBtn.get() == btnno){
				System.out.println("\nNO BUTTON IS CLICKED!");
			}


		}

	@Override
	public void stop() throws Exception {
		System.out.printf("Stop");
		super.stop();
	}
}
