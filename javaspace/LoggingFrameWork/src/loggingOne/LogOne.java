package loggingOne;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.logging.log4j.core.BasicConfigurationFactory.BasicConfiguration;

public class LogOne {

	
	
	
	public static void main(String[] args){
		
		BasicConfigurator.configure();
		Logger log = Logger.getLogger(LogOne.class);
		
		log.error("Happy birthday");
	}
}
