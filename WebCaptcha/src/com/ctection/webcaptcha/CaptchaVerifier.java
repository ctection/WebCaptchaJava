package com.ctection.webcaptcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class CaptchaVerifier {

	private String check_url = "https://ctection.com/api/v1/check_captcha.php";

	private String c_id = "";
	private String c_text = "";

	private boolean valid = false;

	public CaptchaVerifier(String pid, String ptext) {
		c_id = pid;
		c_text = ptext;
	}

	public void callAPI() throws IOException {
		StringBuilder content = new StringBuilder();
		URL url = new URL(check_url+"?c="+URLEncoder.encode(c_text)+"&uid="+URLEncoder.encode(c_id));
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("User-Agent", "WebCaptchaJava/1.0 InlineJavaWebEngine/20200519 WebCaptchaJava/1.0");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		while ((line = bufferedReader.readLine()) != null)
		{
			content.append(line + "\n");
		}
		bufferedReader.close();
		
		
		
		String api_ret = content.toString();
		System.out.println(api_ret);
		String[] elements = api_ret.replace("{", "").replace("}", "").split(",");
		for(int i=0;i<elements.length;i++) {
			if(elements[i].split(":")[0].replace("\"", "").trim().equals("valid")) {
				if(elements[i].split(":")[1].replace("\"", "").trim().equals("true")) {
					valid = true;
				}
			}
		}
	}
	
	public boolean isValid() {
		return valid;
	}

}
