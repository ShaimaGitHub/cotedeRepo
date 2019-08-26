
package com.cotede.MOI.bo;
import java.util.ArrayList;

public class HawiyaForm extends ParentForm{

	private ArrayList<Couple> CoupleInformation;
	private ArrayList<ChildUnder16> childInformation;
	
	public ArrayList<Couple> getCoupleInformation() {
		return CoupleInformation;
	}
	public void setCoupleInformation(ArrayList<Couple> coupleInformation) {
		CoupleInformation = coupleInformation;
	}
	public ArrayList<ChildUnder16> getChildInformation() {
		return childInformation;
	}
	public void setChildInformation(ArrayList<ChildUnder16> childInformation) {
		this.childInformation = childInformation;
	}
}