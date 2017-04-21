package com.pesit.eVoting.Util;

import java.util.Calendar;
import java.util.Date;

public class ElectorIdGenerator {

	private static String electorId = "";	
	
	public static String generateElectorId(String state , String district , long aadhar){
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		electorId = (state.substring(0 , 2) + year + district.substring(0 , 2)  + aadhar).toUpperCase() ;
		
		return electorId;
	}
}
