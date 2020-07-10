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


public class doNodeConnectivity extends ActionSupport
{
	private String username;
	private DBUtils utils;
	private Logger logger;
	private String deviceIPAddress;
	private ResultSet rs;
	private Vector dbVector;
	private ArrayList<ViewPortInfoDB> listOfNodeDetails=null;
	
public doNodeConnectivity()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
public String getDeviceIPAddress() {
        return deviceIPAddress;
    }
	
public void setDeviceIPAddress(String value) {
        deviceIPAddress = value;
    }

public void setListOfNodeDetails(ArrayList<ViewPortInfoDB> list)
{
	this.listOfNodeDetails=list;

}

public ArrayList<ViewPortInfoDB> getListOfNodeDetails()
{
	return listOfNodeDetails;
}
	
/*  public Vector getDbVector() {
        return dbVector;
    }

public void setDbVector(Vector vector) {
        dbVector = dbVector;
    } */

	
	public String execute() throws Exception 
	{

		String deviceIPAddress = getDeviceIPAddress();
		utils = new DBUtils();	
		rs = null;
		listOfNodeDetails=new ArrayList<ViewPortInfoDB>();
		ViewPortInfoDB vpidb;
		String query="select * from camEntries where deviceIpAddress='"+deviceIPAddress+"' and (portTypeInSwitch='normal_port' or portTypeInSwitch='hub_port')";
		//logger.info("query = "+query);
		System.out.println(query);
		rs=utils.executeDBQuery(query);
		Vector dbVector=new Vector();
		String vectorStatus="success";
		int i=0;
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database 1");
				vectorStatus="unsuccess";
			}else 
			{
				try {
						vpidb=new ViewPortInfoDB();
						vpidb.setPortNum(rs.getInt("portNumber"));
						//vpidb.setPortStatus(rs.getString("portStatus"));
						vpidb.setSwitchIPAddress(rs.getString("switchIPAddress"));
						vpidb.setDeviceMACAddress(rs.getString("deviceMACAddress"));
						vpidb.setDeviceIPAddress(rs.getString("deviceIPAddress"));
						vpidb.setPortTypeInSwitch(rs.getString("portTypeInSwitch"));
						vpidb.setVlanId(rs.getInt("vlanId"));
						System.out.println(rs.getString("portTypeInSwitch"));
						
						
						listOfNodeDetails.add(vpidb);
						System.out.println(listOfNodeDetails);
						
					}catch(NullPointerException e)
					{
						addActionError("Invalid user name or password! Please try again!");
						
					vectorStatus="unsuccess";
					}//catch	
			}	
				
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	//System.out.println("dbVector"+dbVector);
	return vectorStatus;
	}
}
