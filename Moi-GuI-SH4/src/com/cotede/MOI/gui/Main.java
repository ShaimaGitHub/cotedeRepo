package com.cotede.MOI.gui;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
 


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			File file = new File("FAT_PROPERTY.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			Scanner readCodes;
			readCodes = new Scanner(file);
			String[] codes = new String[99]; 
			int i = 0;
			while(readCodes.hasNext()) {
				codes[i] = readCodes.next();
				//System.out.println(codes[i]);
				i++;
			}
			String versionApp = codes[0].replace("FAT_VERSION=","");
			
			String applicationName = "FAT_V "+versionApp;
			 Image applicationIcon = new Image(getClass().getResourceAsStream("icon2.png"));
		     primaryStage.setTitle(applicationName);
  		     primaryStage.getIcons().add(applicationIcon);
			Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
			Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("/loginCss.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setResizable(false);
			//primaryStage.setTitle("الصفحة الرئيسية");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
 