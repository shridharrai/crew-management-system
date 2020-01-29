package com.shubham.webapp.listener;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.shubham.webapp.dao.WebappDAO;
import com.shubham.webapp.dao.rightsDAO;
import com.shubham.webapp.dao.roleDAO;
import com.shubham.webapp.dto.cityDTO;
import com.shubham.webapp.dto.rightsDTO;
import com.shubham.webapp.dto.roleDTO;
import com.shubham.webapp.utils.Cache;

/**
 * Application Lifecycle Listener implementation class ServerStartAndDown
 *
 */
@WebListener
public class ServerStartAndDown implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServerStartAndDown() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
			ArrayList<roleDTO> rolelist = roleDAO.existingrole();
			Cache.roleMap.put("roles", rolelist);
			System.out.println(rolelist);
			
			ArrayList<rightsDTO> rightlist = rightsDAO.existingright();
			Cache.rightMap.put("rights", rightlist);
			System.out.println(rightlist);
			
			ArrayList<cityDTO> clist = WebappDAO.getCity();
			Cache.cityMap.put("city", clist);
			System.out.println(clist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
	
}
