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
*Program to retrieve Vlan connected devices information from the database
*/
public class doVlanConnectedRetrieval extends ActionSupport
{
	private DBUtils utils;
	private Logger logger;
	private int vlanId;
	private ResultSet rs;
	private String vlanName;
	private ArrayList<ViewVlanConnectedInfo> list=null;
	//private Vector portVector;

public doVlanConnectedRetrieval()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
public void setVlanId(int name) 
	{
		vlanId=name;

	}

	public int getVlanId() 
	{
		return vlanId;

	}
	
public void setList(ArrayList<ViewVlanConnectedInfo> list)
{
	this.list=list;

}

public ArrayList<ViewVlanConnectedInfo> getList()
{
	return list;
}

	public String execute() throws Exception 
	{
		list=new ArrayList<ViewVlanConnectedInfo>();
		ViewVlanConnectedInfo vvci;
		utils = new DBUtils();	
		rs = null;
		int vlanId=getVlanId();
		String query=" select * from camEntries where vlanId='"+vlanId+"' and (portTypeInSwitch='normal_port' or portTypeInSwitch='hub_port')";
		//logger.info("query = "+query);
		rs=utils.executeDBQuery(query);
		String listStatus="successful";
		System.out.println();

		
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
								
								vvci=new ViewVlanConnectedInfo();
								vvci.setPortNumber(rs.getInt("portNumber"));
								vvci.setSwitchIPAddress(rs.getString("switchIPAddress"));
								vvci.setDeviceMACAddress(rs.getString("deviceMACAddress"));
								vvci.setDeviceIPAddress(rs.getString("deviceIPAddress"));
								vvci.setPortTypeInSwitch(rs.getString("portTypeInSwitch"));
								list.add(vvci);
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
	