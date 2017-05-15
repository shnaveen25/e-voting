package com.pesit.eVoting.Util;

import java.util.Random;
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
	
	public static char[] generateOTP(int length){
		
		String numbers = "0123456789";

        Random rndm_method = new Random();
 
        char[] otp = new char[length];
 
        for (int i = 0; i < length; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            otp[i] =
             numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
	}
	
}  // End class
