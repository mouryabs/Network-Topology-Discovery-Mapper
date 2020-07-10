package net.codejava.struts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SumAction extends ActionSupport {

public List<AddressHolder> addresses = new ArrayList<AddressHolder>();
private ArrayList<Integer> counter = new ArrayList<Integer>();
	
	/**
	 * The action method
	 * @return name of view
	 */
	public String calculate() {
		//sum = x + y;// TODO Auto-generated method stub
	       MySQLConnector msc = new MySQLConnector();
	       msc.openConnection();
	       Statement statement=null;
	       Connection conn = msc.getConnection();
	       try {
		    statement = conn.createStatement();
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM camentries;");
		    int i=0;
		    while(resultSet.next())
		    {
                addresses.add(new AddressHolder(resultSet.getString("MACaddress"),resultSet.getString("IPaddress")));
                System.out.println(addresses.get(i).IPAddress+" "+addresses.get(i).MacAddress);
		    	counter.add(++i);
		    }
		    
		    return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
		
		return "FAILURE";
	}

}