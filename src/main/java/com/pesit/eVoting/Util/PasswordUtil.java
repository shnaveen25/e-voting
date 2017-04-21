package com.pesit.eVoting.Util;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author ranjan
 *
 */
public class PasswordUtil {

	
	public static int randomNumber(int min, int max)  {
		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		
		return randomNum;
		
	}  // End method
	
	public static String randomAplhaNumGen(int length) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = length; i > 0; i -= 12) {
	      int n = Math.min(12, Math.abs(i));
	      sb.append(StringUtils.leftPad(Long.toString(Math.round(Math.random() * Math.pow(36, n)), 36), n, '0'));
	    }
	    
	    return sb.toString();
	  }
	
	
}  // End class
