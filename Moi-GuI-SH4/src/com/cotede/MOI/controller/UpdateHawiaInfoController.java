package com.cotede.MOI.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
 
import com.cotede.MOI.bo.AdminsBean;
import com.cotede.MOI.bo.ChildUnder16;
import com.cotede.MOI.bo.Couple;
import com.cotede.MOI.bo.HawiyaForm;
import com.cotede.MOI.bo.ParentForm;
import com.cotede.MOI.connection.ConnectionDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class UpdateHawiaInfoController implements Initializable {

	 
	/*
	 * Hawia Information From Update Form.
	 */
	
	@FXML
	private JFXTextField hawiaType2;
	@FXML
	private JFXTextField firstName2;
	@FXML
	private JFXTextField familyName2;
	@FXML
	private JFXTextField fatherName2;
	@FXML
	private JFXTextField grandName2;
	@FXML
	private JFXTextField motherName2;
	@FXML
	private JFXTextField hawiaNumber2;
	@FXML
	private JFXTextField prevFamily2;
	@FXML
	private JFXTextField pinxNo2;
	@FXML
	private JFXTextField currentAddress2;
	@FXML
	private JFXDatePicker birthDate2;
	@FXML
	private JFXTextField birthPlace2;
	@FXML
	private JFXTextField religion2;
	@FXML
	private JFXTextField socialStatus2;
	@FXML
	private JFXTextField telphNo2;
	@FXML
	private JFXTextField phoneNo2;
	@FXML
	private JFXTextField gender2;
	
	
	/*
	 * Couple Information From Form. 
	*/
	
	@FXML
	private JFXTextField cpHawiaNo2;
	@FXML
	private JFXTextField cpTasNo2;
	@FXML
	private JFXTextField cpPassType2;
	@FXML
	private JFXTextField cpFullName2;
	@FXML
	private JFXTextField cpPassNo2;
	@FXML
	private JFXTextField cpPrevFamily2;
	
	/*
	 * Childern Information From Form. 
	*/
	
	@FXML
	private JFXTextField chHawiaNo2;
	@FXML
	private JFXTextField chFirstName2;
	@FXML
	private JFXTextField chGender2;
	@FXML
	private JFXDatePicker chBirthDate2;
	
	/*
	 * key typed Form. 
	*/
	 
	@FXML
	private Label numbMsgErrors2;
	
	
	/*
	 *  new child form 
	*/
	
	@FXML
	private JFXTextField newHawChild2;
	@FXML
	private JFXTextField newNameChild2;
	@FXML
	private JFXTextField newGendChild2;
	@FXML
	private JFXDatePicker newBODChild2;
	
	
	/*
	 *  new couple form 
	*/
	
	@FXML
	private JFXTextField newHawCouple2;
	@FXML
	private JFXTextField newCoupleName2;
	@FXML
	private JFXTextField newPassTypeCouple2;
	@FXML
	private JFXTextField newPassNoCouple2;
	@FXML
	private JFXTextField newTassNoCouple2;
	@FXML
	private JFXTextField newPrevFamNameCouple2;
	
 	 
 
	  @FXML
	 public void setInfoText( String hawiaNo)throws IOException {
		  this.hawiaNumber2.setText(hawiaNo);
 			}
 
	    
	  @FXML
		public void keyTyped(KeyEvent evt) {
			String ch = evt.getCharacter();
			if(!ch.matches("^[0-9]*\\.?[0-9]*$") /* && !evt.getCode().toString().equals("ENTER")*/) {
				numbMsgErrors2.setText("المدخل يجب أن يكون رقم ، أعد المحاولة");
				evt.consume();
				
			}else {
				
				 numbMsgErrors2.setText(hawiaNumber2.getText());
			}
		} 
		
		
		@FXML
		public void cancelLogin() {	
			System.exit(0);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
		 
			
		}

 

}
