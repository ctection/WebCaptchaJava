package com.ctection.webcaptcha;

public class CaptchaClient {
	
	private static String captcha_element = "";
	
	private static String required_js = "";
	
	public String getCaptchaElement() {
		return captcha_element;
	}
	
	public String getClientScript() {
		return required_js;
	}
	
}
