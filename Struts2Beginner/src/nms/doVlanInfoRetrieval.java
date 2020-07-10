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
*Program to retrieve Vlan information from the database
*/
public class doVlanInfoRetrieval extends ActionSupport
{
	private DBUtils utils;
	private Logger logger;
	private int vlanId;
	private ResultSet rs;
	private String vlanName;
	private ArrayList<ViewVlanInfo> list=null;
	//private Vector portVector;

public doVlanInfoRetrieval()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
/* public int getPortNum() {
        return portNum;
    }
	
public void setPortNum(int value)
{
	this.portNum=value;

} 

public void setSwitchIPAddress(String name)
	{
		vlanName=name;

	}

	public String getSwitchIPAddress() 
	{
		return vlanName;

	}
	 */
public void setList(ArrayList<ViewVlanInfo> list)
{
	this.list=list;

}

public ArrayList<ViewVlanInfo> getList()
{
	return list;
}

	public String execute() throws Exception 
	{
		list=new ArrayList<ViewVlanInfo>();
		ViewVlanInfo vvi;
		utils = new DBUtils();	
		rs = null;
		String query=" select * from vlanInfo";
		//logger.info("query = "+query);
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
								
								vvi=new ViewVlanInfo();
								vvi.setVlanId(rs.getInt("vlanId"));
								vvi.setVlanName(rs.getString("vlanName"));
								list.add(vvi);
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
	