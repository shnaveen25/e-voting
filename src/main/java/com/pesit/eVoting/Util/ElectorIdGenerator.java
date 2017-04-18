package com.pesit.eVoting.Util;

import java.util.Date;

import com.pesit.eVoting.sql.domain.VotersApplications;

public class ElectorIdGenerator {

	private static String electorId = "";	
	
	public static String generateElectorId(String state , String district , long aadhar){
		
		Date currentDate =  new Date();
		int year = currentDate.getYear();
		
		electorId = (state.substring(0 , 3) + year + district.substring(0 , 3)  + aadhar).toUpperCase() ;
		
		return electorId;
	}
}
