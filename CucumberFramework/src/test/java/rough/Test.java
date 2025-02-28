package rough;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import pageObjects.HomePage;
import utilities.DataReader;

public class Test {
	static List<HashMap<String, String>> datamap;
	public static void main(String[] args) {
		 try {
			 datamap =DataReader.data(System.getProperty("user.dir")+"\\excel\\Testdata.xlsx", "Login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   // int index=Integer.parseInt(row)-1;
	        String email= datamap.get(0).get("username");
	        String pwd= datamap.get(0).get("password");
	        String exp_res= datamap.get(0).get("res");
	        System.out.println(email+pwd+exp_res);
	}
}

