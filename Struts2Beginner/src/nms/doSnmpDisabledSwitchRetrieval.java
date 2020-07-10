package nms;
import java.util.Map;
import java.util.Vector;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.ListIterator;


public class doSnmpDisabledSwitchRetrieval extends ActionSupport
{
	
	private DBUtils utils;
	private Logger logger;
	private String switchIPAddress;
	private ResultSet rs;
	private Vector dbVector;
	private ArrayList<ViewSwitchInfoDB> listOfSwitchDetails=null;
	
public doSnmpDisabledSwitchRetrieval()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
/* public String getSwitchIPAddress() {
        return switchIPAddress;
    }
	
public void setSwitchIPAddress(String value) {
        switchIPAddress = value;
    } */

public void setListOfSwitchDetails(ArrayList<ViewSwitchInfoDB> list)
{
	this.listOfSwitchDetails=list;

}

public ArrayList<ViewSwitchInfoDB> getListOfSwitchDetails()
{
	return listOfSwitchDetails;
}
	

	public String execute() throws Exception 
	{

		//String switchIPAddress = getSwitchIPAddress();
		utils = new DBUtils();	
		rs = null;
		listOfSwitchDetails=new ArrayList<ViewSwitchInfoDB>();
		ViewSwitchInfoDB vsidb=new ViewSwitchInfoDB();
		String query="select * from switchInfo where switchMACAddress='null'";
		//logger.info("query = "+query);
		System.out.println(query);
		rs=utils.executeDBQuery(query);
		Vector dbVector=new Vector();
		String vectorStatus="successful";
		int i=0;
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database 1");
				vectorStatus="unsuccessful";
			}else 
			{
				do{
				try {	
						vsidb=new ViewSwitchInfoDB();
						vsidb.setSwitchIPAddress(rs.getString("switchIPAddress"));
						listOfSwitchDetails.add(vsidb);
						System.out.println(rs.getString("switchIPAddress"));
						
					}catch(NullPointerException e)
					{
						addActionError("Invalid user name or password! Please try again!");
						
					vectorStatus="unsuccessful";
					}//catch	
				}while(rs.next());
			}	
				
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	//System.out.println("dbVector"+dbVector);
	return vectorStatus;
	}
}
