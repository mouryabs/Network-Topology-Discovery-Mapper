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


public class doPrinterConnectivityInfoRetrieval extends ActionSupport
{
	
	private DBUtils utils;
	private Logger logger;
	private String computerIPAddress,deviceIPAddress,printerIPAddress;
	private ResultSet rs;
	private Vector dbVector;
	private ArrayList<ViewPrinterInfoDB> listOfSwitchDetails=null;
	
public doPrinterConnectivityInfoRetrieval()
	{
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}
	
 public String getPrinterIPAddress() {
        return printerIPAddress;
    }
	
public void setPrinterIPAddress(String value) {
        printerIPAddress = value;
    } 

public void setListOfSwitchDetails(ArrayList<ViewPrinterInfoDB> list)
{
	this.listOfSwitchDetails=list;

}

public ArrayList<ViewPrinterInfoDB> getListOfSwitchDetails()
{
	return listOfSwitchDetails;
}
	

	public String execute() throws Exception 
	{

		String printerIPAddress = getPrinterIPAddress();
		utils = new DBUtils();	
		rs = null;
		listOfSwitchDetails=new ArrayList<ViewPrinterInfoDB>();
		ViewPrinterInfoDB vpidb=new ViewPrinterInfoDB();
		String query="select * from printerConnection where printerIPAddress='"+printerIPAddress+"'";
		
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
						vpidb=new ViewPrinterInfoDB();
						vpidb.setComputerIPAddress(rs.getString("computerIPAddress"));
						listOfSwitchDetails.add(vpidb);
						System.out.println(rs.getString("computerIPAddress"));
						
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
