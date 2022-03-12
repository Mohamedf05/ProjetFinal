package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.Context;


public class LaunchTomcat implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
       Context.getSingleton().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Context.getSingleton();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
    	
    }
	
}
