package com.cotede.MOI.bo;
import java.sql.Date;

public class ParentForm {
	
	private int id;
	private int hawiaNo;
	private String formType;
	private String firstName;  
	private String fatherName;  
	private String grandFatherName;
	private String familyName;
	private String pervFamilyName;
	private String motherName;
	private String gender;
	private String bod;
	private String socialStatus;
	private String placeOfBirth;
	private String currentAddress;
	private int telephoneNumber;
	private int cellPhone;
	private String timeStamp;
	private String hawiaType;
	private String pinxNo;
	private String religion;
	private String operation;
	private int coupleID;
	
	
//	public ParentForm(String firstName, String fatherName, String familyName, String currentAddress, int cellPhone) {
//		super();
//		this.firstName = firstName;
//		this.fatherName = fatherName;
//		this.familyName = familyName;
//		this.currentAddress = currentAddress;
//		this.cellPhone = cellPhone;
//	}

	public String getHawiaType() {
		return hawiaType;
	}
	public int getCoupleID() {
		return coupleID;
	}
	public void setCoupleID(int coupleID) {
		this.coupleID = coupleID;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setHawiaType(String hawiaType) {
		this.hawiaType = hawiaType;
	}
	public String getPinxNo() {
		return pinxNo;
	}
	public void setPinxNo(String pinxNo) {
		this.pinxNo = pinxNo;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getHawiaNo() {
		return hawiaNo;
	}
	public void setHawiaNo(int hawiaNo) {
		this.hawiaNo = hawiaNo;
	}
	 
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public String getBod() {
		return bod;
	}
	public void setBod(String bod) {
		this.bod = bod;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getGrandFatherName() {
		return grandFatherName;
	}
	public void setGrandFatherName(String grandFatherName) {
		this.grandFatherName = grandFatherName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getPervFamilyName() {
		return pervFamilyName;
	}
	public void setPervFamilyName(String pervFamilyName) {
		this.pervFamilyName = pervFamilyName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBOD() {
		return bod;
	}
	public void setBOD(String bOD) {
		bod = bOD;
	}
	public String getSocialStatus() {
		return socialStatus;
	}
	public void setSocialStatus(String socialStatus) {
		this.socialStatus = socialStatus;
	}
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	public String getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public int getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(int cellPhone) {
		this.cellPhone = cellPhone;
	}

}
