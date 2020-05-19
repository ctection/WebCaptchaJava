package com.ctection.webcaptcha.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ctection.webcaptcha.CaptchaVerifier;

public class WebCaptchaTest {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter Captcha ID:");
		
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String captcha_id = reader.readLine();
        
        System.out.println("Enter Captcha Code:");
		
        String captcha_code = reader.readLine();
        
        CaptchaVerifier ver = new CaptchaVerifier(captcha_id.trim(), captcha_code.trim());
        ver.callAPI();
        if(ver.isValid()) {
        	System.out.println("Captcha is valid");
        }else {
        	System.out.println("Captcha is invalid");
        }
        
		
	}

}
