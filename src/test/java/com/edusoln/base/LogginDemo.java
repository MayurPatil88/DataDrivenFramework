package com.edusoln.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogginDemo {
	
	// Logger level - all Level Prioritize and include everything into the log
	//trace
	//Debug-this level will lo debugging information
	//Info- this will log the Progress Of Application
	//Warn-This Level Will Show Information Regarding Warnings,That May Not Stop The Execution,But May Still Cause Problem
	//error-This Level Will Show Massage That informs users about Error events,that May Not stop The Application.
	//Fatal-This Will Print Critical information To the system,that may even crash the application.
	
	static Logger log=LogManager.getLogger(LogginDemo.class);
	
	public static void main(String[]args) {
		
		log.info("this is sample info");
		log.info("this is info logger");
		log.debug("this is Debug logger");
		log.error("this is Error logger");
		log.warn("this is warn logger");
		log.fatal("this is warn logger");
	}

}
