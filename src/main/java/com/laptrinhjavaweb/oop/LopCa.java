 	package com.laptrinhjavaweb.oop;

public class LopCa {
	
	protected String colorEye;
	protected String colorSkin;
	protected void boi() {
		System.out.println("Cá nào mà chả biết bơi");
	}
	
	
	protected void boi(String Style) {
		
		System.out.println(Style);
	}
	
	
	public String getColorEye() {
		return colorEye;
	}
	public void setColorEye(String colorEye) {
		this.colorEye = colorEye;
	}
	public String getColorSkin() {
		return colorSkin;
	}
	public void setColorSkin(String colorSkin) {
		this.colorSkin = colorSkin;
	}

}
