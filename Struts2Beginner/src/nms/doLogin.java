package nms;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
*Login user name and password is checked in this program and returns the type of user-information
*/
public class doLogin extends ActionSupport
{
	private String username;
	private DBUtils utils;
	private Logger logger;
	private String name;
	private String password = null;
	private ResultSet rs;

public doLogin(){
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
public String getUsername() {
        return username;
    }
	
public void setUsername(String value) {
        username = value;
    }

public String getPassword() {
        return password;
    }

public void setPassword(String value) {
        password = value;
    }	

	public String execute() throws Exception 
	{

	String userName = getUsername();
	String password=getPassword();

		utils = new DBUtils();	
		rs = null;
		String role = "User";
		String query="select userType from userInfo where userName='"+userName+"' and password='"+password+"'";
		logger.info("query = "+query);
		//System.out.println("query = "+query);
		rs=utils.executeDBQuery(query);
		int i=1; 
		String userType="	";
        boolean fplotSwitchTextullDetails = true;	
		
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database 1");
				userType="unsuccessful";
			}else 
			{
				try {
						userType =rs.getString("userType");
					}catch(NullPointerException e)
					{
						addActionError("Invalid user name or password! Please try again!");
						userType="unsuccessful";
					}//catch	
			}	
			
			switch (userType)
			{
				case "a" :	role = "Admin"; 
							break;
				case "u" :	role = "User"; 
							break;
			}
							
							
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	//if(userType.contains("u"))
	//{
		//Timer tm=new Timer();
	//}
	return userType;
	}
}
