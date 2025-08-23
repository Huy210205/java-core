package com.laptrinhjavaweb.oop;

public class CaChuon extends LopCa {

	private String colorEye;
	private String colorSkin;
	
	
	public CaChuon() {}
	
	public CaChuon(String colorEye) {
		this.colorEye = colorEye;
	}
	
	public CaChuon(String colorEye, String colorSkin, String colorEyeParen, String colorSkinParent ) {
		
		this.colorEye = colorEye;
		this.colorSkin = colorSkin;
		super.colorEye = colorEyeParen;
		super.colorSkin = colorSkinParent;
		
		}


	public String getColorEye() {
		//return "Children: "+ colorEye +" parent: "+ super.getColorEye();
		return colorEye;
	}


	public void setColorEye(String colorEye) {
		this.colorEye = colorEye;
	}

	public void setColorSkin(String colorSkin) {
		this.colorSkin = colorSkin;
	}

	public String getColorSkin() {
		return colorSkin;
	}
	
	// Getter cho parent properties
	public String getParentColorEye() {
		return super.colorEye;
	}
	
	public String getParentColorSkin() {
		return super.colorSkin;
	}

	
}
