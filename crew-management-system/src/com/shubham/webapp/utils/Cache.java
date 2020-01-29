package com.shubham.webapp.utils;

import java.util.ArrayList;
import java.util.HashMap;

import com.shubham.webapp.dto.cityDTO;
import com.shubham.webapp.dto.rightsDTO;
import com.shubham.webapp.dto.roleDTO;

public interface Cache {

	HashMap<String, ArrayList<roleDTO>> roleMap = new HashMap<>();
	HashMap<String, ArrayList<rightsDTO>> rightMap = new HashMap<>();
	HashMap<String,ArrayList<cityDTO>> cityMap = new HashMap<>();
	
}


