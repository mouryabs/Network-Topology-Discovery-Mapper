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
import java.util.ListIterator;
import java.util.ArrayList;



public class doPortRetrieval extends ActionSupport
{
	private String username;
	private DBUtils utils;
	private Logger logger;
	private String switchIPAddress;
	private ResultSet rs;
	private ArrayList<ViewPortInfoDB> list=null;
	//private Vector portVector;

	public doPortRetrieval()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
		
	public String getSwitchIPAddress() 
	{
		return switchIPAddress;
	}
		
	public void setSwitchIPAddress(String value) 
	{
		switchIPAddress = value;
	}
		
	public void setList(ArrayList<ViewPortInfoDB> list)
	{
		this.list=list;

	}

	public ArrayList<ViewPortInfoDB> getList()
	{
		return list;
	}

	public String execute() throws Exception 
	{
		list=new ArrayList<ViewPortInfoDB>();
		ViewPortInfoDB vpidb;
		String switchIPAddress = getSwitchIPAddress();
		utils = new DBUtils();	
		rs = null;
		String query=" select * from camEntries where switchIPAddress='"+switchIPAddress+"' and camEntrystatus='Y' order by portNumber";
		//String queryOfSwitch="select switchMACAddress,switchName,numOfPorts,resetNoOfDaysTime,location from switchInfo where switchIpAddress='"+switchIPAddress+"'";
		//String portDetailsQuery="null";
		//logger.info("query = "+query);
		System.out.println("query of port Details= "+query);
		rs=utils.executeDBQuery(query);
		String listStatus="successful";
		//vpidb=new ViewPortInfoDB();
		
		int i=0;
		try{
				if(!rs.next()) 
				{
					System.out.println(" No  data  available in database");
					listStatus="unsuccessful";
					
				}else 
				{
					System.out.println("hi");
					do
					{
						try {
								if(!rs.getString("portTypeInSwitch").contains("forwarding_port"))
								{
								vpidb=new ViewPortInfoDB();
								vpidb.setPortNum(rs.getInt("portNumber"));
								//vpidb.setPortStatus(rs.getString("portStatus"));
								vpidb.setSwitchIPAddress(switchIPAddress);
								vpidb.setDeviceMACAddress(rs.getString("deviceMACAddress"));
								vpidb.setDeviceIPAddress(rs.getString("deviceIPAddress"));
								vpidb.setPortTypeInSwitch(rs.getString("portTypeInSwitch"));
								list.add(vpidb);
								}
							}
							catch(NullPointerException e)
							{
								listStatus="unsuccessful";
							}//catch	
					}while(rs.next());	
					
					ListIterator itr=list.listIterator();
					while(itr.hasNext())
					{
						System.out.println(itr.next());
					}
			
			    }	
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		//System.out.println("portVector"+listOfPorts.get("portStatus"));
		return listStatus;
	}
}
