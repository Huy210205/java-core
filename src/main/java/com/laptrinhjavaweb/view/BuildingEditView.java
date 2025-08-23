package com.laptrinhjavaweb.view;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.dto.BuildingDTO;

public class BuildingEditView {
	
	
	
	public static void main(String[] args) {
		BuildingDTO newBuilding = new BuildingDTO();
		BuildingController buildingController = new BuildingController();
		
		buildingController.insert(newBuilding);
		
		
	}

}
