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

/**
*Each port information is retrieved
*/

public class doOnePortRetrieval extends ActionSupport
{
	private DBUtils utils;
	private Logger logger;
	private int portNum;
	private ResultSet rs;
	private String switchIPAddress;
	private ArrayList<ViewEachPortInfoDB> list=null;
	//private Vector portVector;

public doOnePortRetrieval()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
public int getPortNum() {
        return portNum;
    }
	
public void setPortNum(int value)
{
	this.portNum=value;

} 

public void setSwitchIPAddress(String name)
	{
		switchIPAddress=name;

	}

	public String getSwitchIPAddress() 
	{
		return switchIPAddress;

	}
	
public void setList(ArrayList<ViewEachPortInfoDB> list)
{
	this.list=list;

}

public ArrayList<ViewEachPortInfoDB> getList()
{
	return list;
}

	public String execute() throws Exception 
	{
		list=new ArrayList<ViewEachPortInfoDB>();
		ViewEachPortInfoDB vepdb;
		int portNum = getPortNum();
		String switchIPAddress=getSwitchIPAddress();
		utils = new DBUtils();	
		rs = null;
		String query=" select * from portDetails where portNumber='"+portNum+"' and switchIPAddress='"+switchIPAddress+"'";
		//String queryOfSwitch="select switchMACAddress,switchName,numOfPorts,resetNoOfDaysTime,location from switchInfo where switchIpAddress='"+switchIPAddress+"'";
		//String portDetailsQuery="null";
		//logger.info("query = "+query);
		System.out.println("query of port Details= "+query);
		rs=utils.executeDBQuery(query);
		String listStatus="successful";

		
		int i=0;
		try{
				if(!rs.next()) 
				{
					System.out.println(" No  data  available in database");
					listStatus="unsuccessful";
					
				}else 
				{
					//System.out.println("hi");
					do
					{
						try {
								
								vepdb=new ViewEachPortInfoDB();
								vepdb.setPortNum(portNum);
								vepdb.setSwitchIPAddress(rs.getString("switchIPAddress"));
								vepdb.setNumOfInPackets(rs.getString("numOfInPackets"));
								vepdb.setNumOfOutPackets(rs.getString("numOfOutPackets"));
								vepdb.setPortStatus(rs.getString("portStatus"));
								System.out.println(rs.getString("numOfOutPackets"));
								list.add(vepdb);
								System.out.println(list);

							}
							catch(NullPointerException e)
							{
								listStatus="unsuccessful";
							}//catch	
					}while(rs.next());	

			    }	
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	//System.out.println("portVector"+listOfPorts.get("portStatus"));
	return listStatus;
	}
}	
	