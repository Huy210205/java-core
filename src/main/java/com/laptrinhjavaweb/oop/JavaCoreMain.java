package com.laptrinhjavaweb.oop;

public class JavaCoreMain {

	public static void main(String[] args) {
		CaChuon caChuon1 = new CaChuon("white children","yellow children", "white parent", " yellow parent");
		CaChuon caChuon2 = new CaChuon();
		//CaBayMau caBayMau = new CaBayMau();
		
		// In ra thông tin caChuon1 để thể hiện constructor có tham số
		
		System.out.println("Color Eye Children: " + caChuon1.getColorEye());
		System.out.println("Color Skin Children: " + caChuon1.getColorSkin());
		System.out.println("Color Eye Parent: " + caChuon1.getParentColorEye());
		System.out.println("Color Skin Parent: " + caChuon1.getParentColorSkin());
		
		caChuon2.boi();
		//caChuon2.boi("Cá chuồn bơi theo kiểu cá chuồn");
		//caBayMau.boi(" Cá bảy màu bơi theo kiểu cá bảy màu");
		//TestMain test1 = new TestMain();
		
		ILopCaChuon iLopCaChuon = new CaChuonImpl();
		
		iLopCaChuon.bay();
		
		 iLopCaChuon.boi();
		
		}
	
	
}
