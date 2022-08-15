package com.edusoln.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

  
static String homepath=System.getProperty("user.dir");
  static File file=new File(homepath+"\\src\\test\\resources\\Config.properties");
  static Properties prop=new Properties();
  
  public static String getProperty(String key)  {
	 
	  Properties prop=new Properties();
	  FileInputStream inputstream;
	try {
		inputstream = new FileInputStream(file);
		 prop.load(inputstream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	  String value=(String) prop.getProperty(key);
	  return value;
  }
}
