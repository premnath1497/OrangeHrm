package com.PropertiesHandle;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ProertiesUtility {
	
	public static String fromProperties(String key)
	{
		String value = null;
		try
		{
			//File f = new  File("./config/"+fileName+".properties");
			File f=new File("C:\\Users\\1\\Automation\\OrangeHrm\\Config\\config.properties");
		//	System.out.println(f.exists());
			FileInputStream fis = new FileInputStream(f);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return value;
	}

}
