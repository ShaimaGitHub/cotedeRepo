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

//import fxmltableview.*;  

public class MainController implements Initializable {

	/*
	 * Login Data From Form
	 */
	
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Label rightLogin;
	@FXML
	private Label wrongLogin;
	 
	/*
	 * Hawia Information From Form.
	 */
	
	@FXML
	private JFXTextField hawiaType;
	@FXML
	private JFXTextField firstName;
	@FXML
	private JFXTextField familyName;
	@FXML
	private JFXTextField fatherName;
	@FXML
	private JFXTextField grandName;
	@FXML
	private JFXTextField motherName;
	@FXML
	private JFXTextField hawiaNumber;
	@FXML
	private JFXTextField prevFamily;
	@FXML
	private JFXTextField pinxNo;
	@FXML
	private JFXTextField currentAddress;
	@FXML
	private JFXDatePicker birthDate;
	@FXML
	private JFXTextField birthPlace;
	@FXML
	private JFXTextField religion;
	@FXML
	private JFXTextField socialStatus;
	@FXML
	private JFXTextField telphNo;
	@FXML
	private JFXTextField phoneNo;
	@FXML
	private JFXTextField gender;
	
	
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
	private JFXTextField cpHawiaNo;
	@FXML
	private JFXTextField cpTasNo;
	@FXML
	private JFXTextField cpPassType;
	@FXML
	private JFXTextField cpFullName;
	@FXML
	private JFXTextField cpPassNo;
	@FXML
	private JFXTextField cpPrevFamily;
	
	/*
	 * Childern Information From Form. 
	*/
	
	@FXML
	private JFXTextField chHawiaNo;
	@FXML
	private JFXTextField chFirstName;
	@FXML
	private JFXTextField chGender;
	@FXML
	private JFXDatePicker chBirthDate;
	
	
	/*
	 * Couple Information From update Form . 
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
	 * Childern Information From upadate Form. 
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
	private Label numbMsgError;
	
	@FXML
	private Label numbMsgErrors;
 
	
	@FXML
	private JFXButton delBtn;
	@FXML
	private JFXButton createBtns;
	@FXML
	private JFXButton enter;
	
	/*
	 *  new child form 
	*/
	
	@FXML
	private JFXTextField newHawChild;
	@FXML
	private JFXTextField newNameChild;
	@FXML
	private JFXTextField newGendChild;
	@FXML
	private JFXDatePicker newBODChild;
	
	
	/*
	 *  new couple form 
	*/
	
	@FXML
	private JFXTextField newHawCouple;
	@FXML
	private JFXTextField newCoupleName;
	@FXML
	private JFXTextField newPassTypeCouple;
	@FXML
	private JFXTextField newPassNoCouple;
	@FXML
	private JFXTextField newTassNoCouple;
	@FXML
	private JFXTextField newPrevFamNameCouple;
	
 	
	/*
	 *  table date view 
	*/
	
	@FXML
	private TableView<ParentForm> dateTableView;
	@FXML
	private TableColumn<ParentForm,String>TreatDate;
	@FXML
	private TableColumn<ParentForm,String>FullName;
	@FXML
	private TableColumn<ParentForm,Integer>no;
	@FXML
	private TableColumn<ParentForm,String>Treatment;
	@FXML
	private TableColumn<ParentForm,String>famName;
	
	public ObservableList<ParentForm> data = FXCollections.observableArrayList();
	
	@FXML
	private JFXButton testLab;
	/*
	 *  app property 
	*/
	
	@FXML
	private Label appName;
	@FXML
	private Label remainingDates;
	@FXML
	private Label remainingDates1;
	
	
	@FXML
	public void setPropertApp() throws IOException  {
	File file = new File("FAT_PROPERTY.txt");

	String[] codes = new String[99]; 
	int i = 0;
	BufferedReader br = new BufferedReader(new FileReader(file));
	String line = br.readLine();
	while (line != null) {
		line = br.readLine();
		codes[i] =line;
		i++;
	}

 
	//String versionApp = codes[0].replace("FAT_VERSION=","");
	String nameApp = codes[0].replace("574435_NAME=", "");
	appName.setText(nameApp);	
	
	String startDate = codes[1];
	String strDate = startDate.replace("574435_ENDDATE=", "");
 
    String[] arr = strDate.split("/");
    final Calendar endDate = Calendar.getInstance();
    int day = Integer.parseInt(arr[0]);
    int month = Integer.parseInt(arr[1]);
    int year = Integer.parseInt(arr[2]);
    switch (month) {
    case 1:
     endDate.set(year, Calendar.JANUARY, day);
     break;
    case 2:
     endDate.set(year, Calendar.FEBRUARY, day);
     break;
    case 3:
     endDate.set(year, Calendar.MARCH, day);
     break;
    case 4:
     endDate.set(year, Calendar.APRIL, day);
     break;
    case 5:
     endDate.set(year, Calendar.MAY, day);
     break;
    case 6:
     endDate.set(year, Calendar.JUNE, day);
     break;
    case 7:
     endDate.set(year, Calendar.JULY, day);
     break;
    case 8:
     endDate.set(year, Calendar.AUGUST, day);
     break;
    case 9:
     endDate.set(year, Calendar.SEPTEMBER, day);
     break;
    case 10:
     endDate.set(year, Calendar.OCTOBER, day);
     break;
    case 11:
     endDate.set(year, Calendar.NOVEMBER, day);
     break;
    case 12:
     endDate.set(year, Calendar.DECEMBER, day);
     break;
    }
	
    final Calendar today = Calendar.getInstance();
    final long millis = endDate.getTimeInMillis() - today.getTimeInMillis();
    // Convert to days
    final long days = millis / 86400000;
    final String stringDays = days + " يوم ";
    if (days <= 2) {
    	remainingDates1.setText(stringDays+ " * الرجاء تجديد اشتراكك ");
    	Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("انتهاء الاشتراك");
			 alert.setHeaderText("انتهت فترة اشتراكك الرحاء المسارعة بتجديد اشتراكك ");
			alert.setContentText(" الرجاء تجديد اشتراكك");
			alert.showAndWait();
			 
			    // do what you have to do
			    System.exit(0);
			    
    }else
    remainingDates.setText(stringDays);
   }

	
public void enterToMainPage() throws SQLException {
		
		List<AdminsBean> adminList = com.cotede.MOI.connection.ConnectionDB.adminsList();
		Map<String, String> userNamePasswordMap = new HashMap<>();
		
		for (AdminsBean admin : adminList) {
			userNamePasswordMap.put(admin.getUserName(), admin.getPassword()); }
		
		if (userNamePasswordMap.containsKey(username.getText())) {

			for (Map.Entry entry : userNamePasswordMap.entrySet()) {

				String userNameValue = username.getText();
				String passwordValue = entry.getValue().toString();

				if (passwordValue.equals(password.getText())) {
					//wrongLogin.setText("success login");
					try {
						Parent pane = FXMLLoader.load(getClass().getResource("../gui/mainPage.fxml"));
						Stage primaryStage = new Stage();
						  String applicationName = "Main Page";
							 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
						     primaryStage.setTitle(applicationName);
						     primaryStage.getIcons().add(applicationIcon);
						Scene scene = new Scene(pane);
						primaryStage.resizableProperty().setValue(Boolean.FALSE);
						primaryStage.setScene(scene);
						primaryStage.show();
						wrongLogin.setVisible(false);
					} catch (Exception e) {
						e.printStackTrace();}
					}
				}
		         } else {
			        wrongLogin.setText("فشل الدخول , الرجاء المحاولة مرة أخرى");
		         	}
	         }

	@FXML
	public void goFromLoginToMainPage() throws IOException{
		   Parent pane = FXMLLoader.load(getClass().getResource("../gui/mainPage.fxml"));
		   Stage primaryStage = new Stage();
		   String applicationName = "Main Page";
			 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
		     primaryStage.setTitle(applicationName);
		     primaryStage.getIcons().add(applicationIcon);
		   Scene scene = new Scene( pane);
		   primaryStage.resizableProperty().setValue(Boolean.FALSE);
		   primaryStage.setScene(scene);
		   //primaryStage.setTitle("الصفحة الرئيسية");
		   primaryStage.show();	   

	}
	
	@FXML
	public void goToSetting() throws IOException {
	   Parent settingPane = FXMLLoader.load(getClass().getResource("../gui/settingPage.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "Setting Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	     primaryStage.getIcons().add(applicationIcon);
	   Scene scene = new Scene( settingPane,757,656 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();
	  	   
	}
	
	@FXML
	public void goToDatePage() throws IOException {	
	   Parent datePane = FXMLLoader.load(getClass().getResource("../gui/DatePage.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "Date Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	     primaryStage.getIcons().add(applicationIcon);
	   Scene scene = new Scene( datePane,757,656 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();
	      
	}
	
	@FXML
	public void goToHawiaPage() throws IOException {	
	   Parent hawiaPane = FXMLLoader.load(getClass().getResource("../gui/HawiaPage.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "Hawia Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	     primaryStage.getIcons().add(applicationIcon);
	     
	   Scene scene = new Scene( hawiaPane,757,656 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();
	     
	}
	
	@FXML
	public void goToTreatmentsPage() throws IOException {		
	   Parent treatmentPane = FXMLLoader.load(getClass().getResource("../gui/TreatmentsPage.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "treatments Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	     primaryStage.getIcons().add(applicationIcon);
	   Scene scene = new Scene( treatmentPane,757,656 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();	   
	   
	}
	
	@FXML
	public void goToPassportPage() throws IOException {		
	   Parent passportPane = FXMLLoader.load(getClass().getResource("../gui/passportPage.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "Passport Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	     primaryStage.getIcons().add(applicationIcon);
	   Scene scene = new Scene( passportPane,757,656 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();	   
	   
	}
	
	@FXML
	public void goToBirthPage() throws IOException {		
	   Parent birthPane = FXMLLoader.load(getClass().getResource("../gui/birthPage.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "Birth Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	     primaryStage.getIcons().add(applicationIcon);
	   Scene scene = new Scene( birthPane,757,656 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();	   
	   
	}

	
	public void insertInformationToDataBase(ActionEvent e) {
		final ArrayList<JFXTextField> jfxtextFields = new ArrayList<>();
		
		//  for (JFXTextField textbox : jfxtextFields) {
	              if (hawiaType.getText().trim().isEmpty() || firstName.getText().trim().isEmpty() || cpPassNo.getText().trim().isEmpty() ||
	        		  cpPrevFamily.getText().trim().isEmpty() || chFirstName.getText().trim().isEmpty() || chGender.getText().trim().isEmpty() ||
	        		  chHawiaNo.getText().trim().isEmpty() || familyName.getText().trim().isEmpty() || fatherName.getText().trim().isEmpty() || 
	        		  grandName.getText().trim().isEmpty() || motherName.getText().trim().isEmpty() || hawiaNumber.getText().trim().isEmpty() ||
	        		  prevFamily.getText().trim().isEmpty() || pinxNo.getText().trim().isEmpty() || currentAddress.getText().trim().isEmpty()  ||
	        		  birthPlace.getText().trim().isEmpty() || religion.getText().trim().isEmpty() || socialStatus.getText().trim().isEmpty() ||
	        		  telphNo.getText().trim().isEmpty() || phoneNo.getText().trim().isEmpty() || gender.getText().trim().isEmpty() || 
	        		  cpHawiaNo.getText().trim().isEmpty() || cpTasNo.getText().trim().isEmpty() || cpPassType.getText().trim().isEmpty() ||
	        		  cpFullName.getText().trim().isEmpty()) {
		 //  if (hawiaType.getText().trim().isEmpty()) {
 	            	//createBtns.setDisable(false);
 	            	//createBtns.setVisible(false);
			 
	            	numbMsgError.setText("الرجاء ملئ  كافة الحقول ...");
	             }
		 
		 else {
		// }
		String type = hawiaType.getText();
		String fName = firstName.getText();
		String famName = familyName.getText();
		String fathName = fatherName.getText();
		String grName = grandName.getText();
		String mothName = motherName.getText();
		String hawiaNo = hawiaNumber.getText();
		String prevFam = prevFamily.getText();
		String pxNo = pinxNo.getText();
		String currAddress = currentAddress.getText();
	    LocalDate birDate = birthDate.getValue();
		String birPlace = birthPlace.getText();
		String rel = religion.getText();
		String socStatus = socialStatus.getText();
		String telNo = telphNo.getText();
		String phNo = phoneNo.getText();
		String gend  = gender.getText();
			
		String cpHaNo = cpHawiaNo.getText();
		String cpTaNo = cpTasNo.getText();
		String cpPaType = cpPassType.getText();
		String cpFuName = cpFullName.getText();
		String cpPaNo = cpPassNo.getText();
		String cpPrFamily = cpPrevFamily.getText();
		
		
		String chHaNo = chHawiaNo.getText();
		String chfirName = chFirstName.getText();
		String chGend = chGender.getText();
		LocalDate chBirDate = chBirthDate.getValue();
			
		String stringBOD = birDate.toString();
		
		int haNo = Integer.parseInt(hawiaNo);
		int cellPhone = Integer.parseInt(phNo);
		int tel = Integer.parseInt(phNo);
		int passNo = Integer.parseInt(cpPaNo);
		int tassNo = Integer.parseInt(cpTaNo);
		int chhawiaNo = Integer.parseInt(chHaNo);
		int cphawiaNo = Integer.parseInt(cpHaNo);
		
		ParentForm pf = new ParentForm();
		ChildUnder16 cu = new ChildUnder16();
		Couple c = new Couple();
		
		 pf.setBod(stringBOD);
		 pf.setCellPhone(cellPhone);
		 pf.setCurrentAddress(currAddress);
		 pf.setFamilyName(famName);
		 pf.setFatherName(fathName);
		 pf.setFirstName(fName);
		 pf.setGender(gend);
		 pf.setHawiaNo(haNo);
		 pf.setMotherName(mothName);
		 pf.setHawiaType(type);
		 pf.setPervFamilyName(prevFam);
		 pf.setPinxNo(pxNo);
		 pf.setPlaceOfBirth(birPlace);
		 pf.setReligion(rel);
		 pf.setSocialStatus(socStatus);
		 pf.setTelephoneNumber(tel);
		 pf.setGrandFatherName(grName);
		 
		 cu.setBOD(stringBOD);
		 cu.setFirstName(chfirName);
		 cu.setGender(chGend);
		 cu.setChHawiaNO(chhawiaNo);
	  
		 c.setFullName(cpFuName);
		 c.setcHawiaNO(cphawiaNo);
		 c.setPassportNumber(passNo);
		 c.setTasrehNumber(tassNo);
		 c.setPrevFamilyName(cpPrFamily);
		 c.setPassportType(cpPaType);
	 
		int status =  com.cotede.MOI.connection.ConnectionDB.saveHawiaInfo(pf,cu,c);
		if(status>2)
 		{
 			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Done SaVe Person");
 			alert.setHeaderText("Information Dialoge");
 			alert.setContentText("Saved Successfullly");
 			alert.showAndWait();
 			
 		}else {
 			Alert alert = new Alert(AlertType.ERROR);
 			alert.setTitle("Insert data");
 			alert.setHeaderText("ERROR Dialoge");
 			alert.setContentText("Unable save Person !!");
 			alert.showAndWait();
 					
 		}
		 }	 	
	}
		
	//if (user_name.getText() == null || user_name.getText().trim().isEmpty()) {
		
	@FXML
	public void addNewCouple() throws IOException {		
	   Parent settingPane = FXMLLoader.load(getClass().getResource("../gui/newCouple.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "New Couple Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	   Scene scene = new Scene( settingPane,700,600 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();	   
	   
	}
	
	@FXML
	public void addNewChild() throws IOException {		
	   Parent settingPane = FXMLLoader.load(getClass().getResource("../gui/newChild.fxml"));
	   Stage primaryStage = new Stage();
	   String applicationName = "new child Page";
		 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
	     primaryStage.setTitle(applicationName);
	   Scene scene = new Scene( settingPane,700,600 );
	   primaryStage.resizableProperty().setValue(Boolean.FALSE);
	   primaryStage.setScene(scene);
	   primaryStage.show();	   
	   
	}
	
	  @FXML
      public void insertNewChild(ActionEvent e) {
 
		String newHaw = newHawChild.getText();
		String newChildName = newNameChild.getText();
		String newChildGend = newGendChild.getText();
		LocalDate newBOD = newBODChild.getValue();
		
		
		String stringNewBOD = newBOD.toString();
		
		int newHawiaNo = Integer.parseInt(newHaw);
		 
		ChildUnder16 cu = new ChildUnder16();
  
		 cu.setBOD(stringNewBOD);
		 cu.setFirstName(newChildName);
		 cu.setGender(newChildGend);
	//	 cu.setHawiaNO(newHawiaNo);
	 
//		int status =  ConnectionDB.saveNewChildInfo(cu);
//		if(status>0)
// 		{
// 			Alert alert = new Alert(AlertType.INFORMATION);
// 			alert.setTitle("Done SaVe Person");
// 			alert.setHeaderText("Information Dialoge");
// 			alert.setContentText("Saved Successfullly");
// 			alert.showAndWait();
// 			
// 			
// 		}else {
// 			Alert alert = new Alert(AlertType.ERROR);
// 			alert.setTitle("Insert data");
// 			alert.setHeaderText("ERROR Dialoge");
// 			alert.setContentText("Unable save Person !!");
// 			alert.showAndWait();
// 					
// 		}
	}
	  
	  @FXML
      public void insertNewCouple(ActionEvent e) {
			
		String newHawC = newHawCouple.getText();
		String newCName = newCoupleName.getText();
		String newPassTypeC = newPassTypeCouple.getText();
		String newPassNoC = newPassNoCouple.getText();
		String newTassNoC = newTassNoCouple.getText();
		String newPrevFamNameC = newPrevFamNameCouple.getText();

		int newHC = Integer.parseInt(newHawC);
		int newPNoC = Integer.parseInt(newPassNoC);
		int newTNoC = Integer.parseInt(newTassNoC);
		 
		Couple c = new Couple();
  
		 c.setFullName(newCName);
//		 c.setHawiaNO(newHC);
		 c.setPassportNumber(newPNoC);
		 c.setTasrehNumber(newTNoC);
		 c.setPrevFamilyName(newPrevFamNameC);
		 c.setPassportType(newPassTypeC);
	 
		int status =   com.cotede.MOI.connection.ConnectionDB.saveNewCoupleInfo(c);
		if(status>0)
 		{
 			Alert alert = new Alert(AlertType.INFORMATION);
 			alert.setTitle("Done SaVe Person");
 			alert.setHeaderText("Information Dialoge");
 			alert.setContentText("Saved Successfullly");
 			alert.showAndWait();
 			
 			
 		}else {
 			Alert alert = new Alert(AlertType.ERROR);
 			alert.setTitle("Insert data");
 			alert.setHeaderText("ERROR Dialoge");
 			alert.setContentText("Unable save Person !!");
 			alert.showAndWait();
 					
 		}
		 	
	}
	  
	  
//	  @FXML
//		public void changeBackgroundColor(Event event) {
//			Paint fill = colorPicker.getValue();
//			BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
//			Background background = new Background(backgroundFill);
//			test.setBackground(background);
//		}
//	  
//	  @FXML
//		private TableView<HawiyaForm> dateTableView;
//		@FXML
//		private TableColumn<HawiyaForm, String> firstName;
//		@FXML
//		private TableColumn<HawiyaForm, String> timeStamp;
//		@FXML
//		private TableColumn<HawiyaForm, Integer> ID_NO;
//		@FXML
//		private TableColumn<HawiyaForm, Integer> formID;
//		public ObservableList<HawiyaForm> data = FXCollections.observableArrayList();
//		
		
//	  @Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//			String sql = "Select ID_NO,firstName,formID,timeStamp from HawiaForm";
//			// String sql = "Select ID_NO,firstName,formID,timeStamp,formName from HawiaForm
//			// inner join Forms on HawiaForm.formID = ID ";
//			Connection conn = ConnectionDB.getConnections();
//			try {
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ResultSet result = ps.executeQuery();
//
//				while (result.next()) {
//					data.add(new HawiyaForm(result.getInt(1), result.getString(2), result.getInt(3), result.getString(4)));
//
//				}
//				conn.close();
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//			firstName.setCellValueFactory(new PropertyValueFactory<HawiyaForm, String>("firstName"));
//			ID_NO.setCellValueFactory(new PropertyValueFactory<HawiyaForm, Integer>("ID_NO"));
//			formID.setCellValueFactory(new PropertyValueFactory<HawiyaForm, Integer>("formID"));
//			timeStamp.setCellValueFactory(new PropertyValueFactory<HawiyaForm, String>("timeStamp"));
//			dateTableView.setItems(data);
//		}
//	  
 
		public void updateHawiaInformation(ActionEvent e) {
			
			String type2 = hawiaType2.getText();
			String fName2 = firstName2.getText();
			String famName2 = familyName2.getText();
			String fathName2 = fatherName2.getText();
			String grName2 = grandName2.getText();
			String mothName2 = motherName2.getText();
			String hawiaNo2 = hawiaNumber2.getText();
			String prevFam2 = prevFamily2.getText();
			String pxNo2 = pinxNo2.getText();
			String currAddress2 = currentAddress2.getText();
		    LocalDate birDate2 = birthDate2.getValue();
			String birPlace2 = birthPlace2.getText();
			String rel2 = religion2.getText();
			String socStatus2 = socialStatus2.getText();
			String telNo2 = telphNo2.getText();
			String phNo2 = phoneNo2.getText();
			String gend2  = gender2.getText();
				
			String cpHaNo2 = cpHawiaNo2.getText();
			String cpTaNo2 = cpTasNo2.getText();
			String cpPaType2 = cpPassType2.getText();
			String cpFuName2 = cpFullName2.getText();
			String cpPaNo2 = cpPassNo2.getText();
			String cpPrFamily2 = cpPrevFamily2.getText();
			
			
			String chHaNo2 = chHawiaNo2.getText();
			String chfirName2 = chFirstName2.getText();
			String chGend2 = chGender2.getText();
			LocalDate chBirDate2 = chBirthDate2.getValue();
				
			String stringBOD2 = birDate2.toString();
			
			int haNo2 = Integer.parseInt(hawiaNo2);
			int cellPhone2 = Integer.parseInt(phNo2);
			int tel2 = Integer.parseInt(phNo2);
			int passNo2 = Integer.parseInt(cpPaNo2);
			int tassNo2 = Integer.parseInt(cpTaNo2);
			int chhawiaNo2 = Integer.parseInt(chHaNo2);
			int cphawiaNo2 = Integer.parseInt(cpHaNo2);
			
			ParentForm pf = new ParentForm();
			ChildUnder16 cu = new ChildUnder16();
			Couple c = new Couple();
			
			 pf.setBod(stringBOD2);
			 pf.setCellPhone(cellPhone2);
			 pf.setCurrentAddress(currAddress2);
			 pf.setFamilyName(famName2);
			 pf.setFatherName(fathName2);
			 pf.setFirstName(fName2);
			 pf.setGender(gend2);
			 pf.setHawiaNo(haNo2);
			 pf.setMotherName(mothName2);
			 pf.setHawiaType(type2);
			 pf.setPervFamilyName(prevFam2);
			 pf.setPinxNo(pxNo2);
			 pf.setPlaceOfBirth(birPlace2);
			 pf.setReligion(rel2);
			 pf.setSocialStatus(socStatus2);
			 pf.setTelephoneNumber(tel2);
			 pf.setGrandFatherName(grName2);
			 
//			 cu.setBOD(stringBOD2);
//			 cu.setFirstName(chfirName2);
//			 cu.setGender(chGend2);
//			 cu.setChHawiaNO(chhawiaNo2);
//		  
//			 c.setFullName(cpFuName2);
//			 c.setcHawiaNO(cphawiaNo2);
//			 c.setPassportNumber(passNo2);
//			 c.setTasrehNumber(tassNo2);
//			 c.setPrevFamilyName(cpPrFamily2);
//			 c.setPassportType(cpPaType2);
		 
			int status =  com.cotede.MOI.connection.ConnectionDB.updateHawiaInfo(pf,haNo2 );
			if(status>0)
	 		{
	 			Alert alert = new Alert(AlertType.INFORMATION);
	 			alert.setTitle("Done update Person");
	 			alert.setHeaderText("Information");
	 			alert.setContentText("Update Successfullly");
	 			alert.showAndWait();
	 			  Stage stage = (Stage) createBtns.getScene().getWindow();
	 			    // do what you have to do
	 			    stage.close();
	 			
	 		}else {
	 			Alert alert = new Alert(AlertType.ERROR);
	 			alert.setTitle("Update data");
	 			alert.setHeaderText("ERROR");
	 			alert.setContentText("Unable update Person !!");
	 			alert.showAndWait();
	 					
	 		}	
}
	@FXML
	public void deleteHawiaInfo(){
		
		String hawiaNo = hawiaNumber2.getText();
		int hawiaNoInt = Integer.parseInt(hawiaNo);
		 int hawiaNoID = com.cotede.MOI.connection.ConnectionDB.delHawiaNo(hawiaNoInt);
		 if(hawiaNoID > 0) {
			 Alert alert = new Alert(AlertType.INFORMATION);
	 			alert.setTitle("Done Delete Person");
	 			alert.setHeaderText("Information");
	 			alert.setContentText("Delete Successfullly");
	 			alert.showAndWait();
	 			  Stage stage = (Stage) delBtn.getScene().getWindow();
	 			    // do what you have to do
	 			    stage.close();
		 }else {
			 
			 Alert alert = new Alert(AlertType.ERROR);
	 			alert.setTitle("Delete data");
	 			alert.setHeaderText("ERROR");
	 			alert.setContentText("Unable Delete Person !!");
	 			alert.showAndWait();
		 }
	}
		
	@FXML
	public void updateHawiaNumberInfo(KeyEvent evt) throws IOException {

		String hawiaNo = hawiaNumber.getText();
		int hawiaNoInt = Integer.parseInt(hawiaNo);
		 int hawiaCount = com.cotede.MOI.connection.ConnectionDB.getHawiaNo(hawiaNoInt);
		 
		if (evt.getCode().equals(KeyCode.ENTER)) {
			if(hawiaCount >0 ) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../gui/UpdateHawiaPage.fxml"));
			try {
				loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MainController display = loader.getController();
			display.setInfoText(hawiaNoInt);
			Parent updateInfoPane = loader.getRoot();
			Stage primaryStage = new Stage();
			 String applicationName = "Update Page";
			 Image applicationIcon = new Image(getClass().getResourceAsStream("../gui/icon2.png"));
		     primaryStage.setTitle(applicationName);		 
		   primaryStage.resizableProperty().setValue(Boolean.FALSE);
			primaryStage.setScene(new Scene(updateInfoPane, 700, 600));
			primaryStage.showAndWait();
			
		}else {  Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("There No Data");
			alert.setHeaderText("ERROR ");
			alert.setContentText(" Please add This Number !!");
			alert.showAndWait();  }
			
		}

	}
	 
	  @FXML
		 public void setInfoText( int hawiaNo)throws IOException {
		  ParentForm pf = com.cotede.MOI.connection.ConnectionDB.getInfoByHawiaNo(hawiaNo);
		  
		   this.currentAddress2.setText(pf.getFamilyName());
		   this.hawiaNumber2.setText(String.valueOf(pf.getHawiaNo()));
		   this.hawiaType2.setText(pf.getHawiaType());
		   this.firstName2.setText(pf.getFirstName());
		   this.familyName2.setText(pf.getFamilyName());
		   this.fatherName2.setText(pf.getFatherName());
		   this.grandName2.setText(pf.getGrandFatherName());
		   this.motherName2.setText(pf.getMotherName());
		   this.prevFamily2.setText(pf.getPervFamilyName());
		   this.pinxNo2.setText(String.valueOf(pf.getPinxNo()));
		   this.birthDate2.setValue(LocalDate.parse(pf.getBOD()));
		   this.birthPlace2.setText(pf.getPlaceOfBirth());
		   this.religion2.setText(pf.getReligion());
		   this.socialStatus2.setText(pf.getSocialStatus());
		   this.telphNo2.setText(String.valueOf(pf.getTelephoneNumber()));
		   this.phoneNo2.setText(String.valueOf(pf.getCellPhone()));
		   this.gender2.setText(pf.getGender());
		   
		   
		//   this.cpHawiaNo2.setText(String.valueOf(pf.getChildInformation()));
		   
	 			}
	 	
 
	    
	  @FXML
		public void keyTyped(KeyEvent evt) {
			String ch = evt.getCharacter();
			if(!ch.matches("^[0-9]*\\.?[0-9]*$") /* && !evt.getCode().toString().equals("ENTER")*/) {
				numbMsgError.setText("المدخل يجب أن يكون رقم ، أعد المحاولة");
				evt.consume();
				
			}else {
				
				 numbMsgError.setText("");
			}
		} 
		
		
		@FXML
		public void cancelLogin() {	
			System.exit(0);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		//	 TODO Auto-generated method stub
			try {
				
				setPropertApp();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			 
//			Connection conn = com.cotede.MOI.connection.ConnectionDB.getConnections();
//			
//			String sql = "Select C_CURRENT_ADDRESS,C_FAM_NAME,I_CELL_PHONE,C_FATH_NAME,C_FIRST_NMAE from hawiaForm";
//			
//			try {
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ResultSet result = ps.executeQuery();
//				
//				while(result.next()) {
//					ParentForm  pf = new ParentForm();
//					 
//					 pf.setCurrentAddress(result.getString(1));
//					 pf.setFamilyName(result.getString(2));
//					 pf.setCellPhone(result.getInt(3));
//					 pf.setFatherName(result.getString(4));
//					 pf.setFirstName(result.getString(5));
//					//  testLab.setText(result.getString(5));
//					// System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getInt(3)+" "+result.getString(4)+" "+result.getString(5));
//					 
//					//data.add(new ParentForm(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5)));
//					 data.add(pf);
//					// System.out.println(data);
//				//	 for(int i=0;i<data.size();i++){
//				//		    System.out.println(data.get(i).toString());
//						   // System.out.println("sad");
//				//		} 
//					 
//				}
//				conn.close();
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		//	 testLab.setText("SDGFSD");
			
//			TreatDate.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("currentAddress"));
//			FullName.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("firstName"));
//			no.setCellValueFactory(new PropertyValueFactory<ParentForm, Integer>("cellPhone"));
//			Treatment.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("fatherName"));
//			action.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("familyName"));
//			dateTableView.setItems(data);
		
		}

//		@Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//			// TODO Auto-generated method stub
//			
//		}

public void getAllHawiNos() {
	Connection conn = com.cotede.MOI.connection.ConnectionDB.getConnections();
	int index = 0;
	//String sql = "Select C_CURRENT_ADDRESS,C_FAM_NAME,I_CELL_PHONE,C_FATH_NAME,C_FIRST_NMAE from hawiaForm order by I_HAW_NO LIMIT 18";
	String sql = "Select I_HAW_ID,C_FIRST_NMAE,C_CREATED_AT,C_FORM_TYPE,C_FAM_NAME   from hawiaForm order by C_CREATED_AT";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			ParentForm  pf = new ParentForm();
			 index++;
			 pf.setId(index);
			 pf.setFirstName(result.getString(2));
			 pf.setTimeStamp(result.getString(3));
			 pf.setFormType(result.getString(4));
			 pf.setFamilyName(result.getString(5));
			
			// testLab.setText(result.getString(5));
			// System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getInt(3)+" "+result.getString(4)+" "+result.getString(5));
			 
			//data.add(new ParentForm(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5)));
			 data.add(pf);
			// System.out.println(data);
		//	 for(int i=0;i<data.size();i++){
		//		    System.out.println(data.get(i).toString());
				   // System.out.println("sad");
		//		} 
			 
		}
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
 //   testLab.setText("SDGFSD");
	TreatDate.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("timeStamp"));
	FullName.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("firstName"));
	no.setCellValueFactory(new PropertyValueFactory<ParentForm, Integer>("id"));
	Treatment.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("formType"));
	famName.setCellValueFactory(new PropertyValueFactory<ParentForm, String>("familyName"));
	dateTableView.setItems(data);
}
}
