package nms;
import java.util.*;
import java.sql.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public  class DBUtils {

	
	private Statement stmt;
	private ConToDB mkConnection;
	
	private Logger logger;
	
	public DBUtils(){
		logger = Logger.getLogger(DBUtils.class);
	}
	
	public Statement getStatement(){

		mkConnection =  new ConToDB();
		
		try {	
			if(mkConnection.con == null) 
			{ //connection doesn't exist, create Connection
				logger.info(" First Connection "); 
				//int errorCode = 	
				mkConnection.setConnection(); 
			}//if
			stmt = mkConnection.con.createStatement();   
		}
		catch(com.mysql.jdbc.CommunicationsException cex)
		{
				logger.error("Connection got closed. Re-connecting again.");
				
				try {
					mkConnection.setConnection();
		 		    stmt = mkConnection.con.createStatement();   
				}
				catch(SQLException ex)
				{
					logger.error(" Could not create statement from Connection "+ex);
					logger.error(" Error code"+ex.getErrorCode());
				}//catch
		}
		catch(SQLException e)
		{
			logger.error(" Could not create statement from Connection "+e);
			//logger.log(Level.TRACE);
			//System.out.println();
			System.out.println(" Could not create statement from Connection"+e);
		}
		
		return stmt;
	}
	
	
	public void setStatement(Statement value){
		this.stmt = value;
	}

	
	
    public boolean insertIntoDBWithCommit(String query) {

		boolean operationSuccess=false;
		int noOfRowsInserted = 0;
		
		logger.info(query);
		//System.out.println(query);
		stmt = getStatement();
		try 
		{
			//logger.info(query);
			noOfRowsInserted = stmt.executeUpdate(query); 
			if (noOfRowsInserted > 0)
			{
				operationSuccess = true;
				//mkConnection.con.commit();
			}
		}catch(SQLException e){
			logger.error(" Could not execute Query "+query+" "+e); 
			System.out.println(" Could not execute Query "+query+" "+e); 
			
			//logger.log(Level.TRACE);
			//System.out.println(" Could not execute Query in DBUtils.java "+query+" : "+e);
		}//catch
		
		return operationSuccess;
		
	}//insertIntoDBWithCommit
	
	 public boolean insertIntoDBWithOutCommit(String query) {

		boolean operationSuccess=false;
		int noOfRowsInserted = 0;
		
		//System.out.println(query);
		logger.info(query);
		stmt = getStatement();
		try 
		{
			noOfRowsInserted = stmt.executeUpdate(query); 
			if (noOfRowsInserted > 0)
						operationSuccess = true;
			//mkConnection.con.commit();
		}catch(SQLException e){
			logger.error(" Could not execute Query "+query+" "+e); 
			
			//logger.log(Level.TRACE);
			//System.out.println(" Could not execute Query in DBUtils.java "+query+" : "+e); 
		}//catch
		
		return operationSuccess;
		
	}//insertIntoDBWithOutCommit
	
	public ResultSet executeDBQuery(String query)
	{
	
		stmt = getStatement();
		ResultSet rs = null;
	
		//System.out.println(query);
		logger.info("Query ="+query);
		
		try 
		{
			rs = stmt.executeQuery(query);
		}
		catch(com.mysql.jdbc.CommunicationsException cex)
		{
				logger.error("Connection got closed. Re-connecting again.");
				
				try {
					mkConnection.setConnection();
		 		    stmt = mkConnection.con.createStatement();   
					rs = stmt.executeQuery(query);
				}
				catch(SQLException ex)
				{
					logger.error(" Could not execute inside re-connection at dbUtils "+ex);
					logger.error(" Error code"+ex.getErrorCode());
				}//catch
		}
		catch(SQLException e){
			logger.error(" Could not execute Query "+query+" "+e);
			System.out.println(" Could not execute Query "+query+" "+e);
			//logger.log(Level.TRACE);
			//System.out.println(" Could not execute Query in DBUtils.java "+query+" : "+e);
		}
		return rs;
		
	}//executeDBQuery
	
	
	
	
	
	public boolean insertIntoDBBulk(String[] query) {

		boolean operationSuccess=false;
		int noOfRowsInserted = 0;
		stmt = getStatement();
		setCommit(false);
		for(int i=0; i<query.length; i++)
		{
			//logger.info("Query ="+query[i]);
			//System.out.println(query[i]);
	
			try 
			{
				//stmt = getStatement();
				noOfRowsInserted = stmt.executeUpdate(query[i]); 
				//logger.info("Query successful="+query[i]);
				//System.out.println("Query successful "+query[i]);
				if (noOfRowsInserted > 0)
						operationSuccess = true;
				//stmt = null;
				
			}catch(SQLException e){
					logger.error(" Could not execute Query "+query[i]+" "+e);
					//logger.log(Level.TRACE);
					//System.out.println(" Could not execute Query in DBUtils.java "+query[i]+" : "+e);
				operationSuccess = false;
				break;
			}//catch
			
		}//for
		try {
			if (operationSuccess)
					mkConnection.con.commit();
			else
				mkConnection.con.rollback();
		}catch(SQLException ex){
			logger.error(" Could not be commit/rollback "+ex);
			
			//logger.log(Level.TRACE);
			//System.out.println("Could not be commit/rollback in DBUtils.java"+ex);
		}//catch
		setCommit(true);
		return operationSuccess;
		
	}//insertIntoDBWithCommit
	
	public void setCommit(boolean flag)
	{
		try {
			mkConnection.con.setAutoCommit(flag);
		}catch(SQLException ex){
			logger.error(" Could not set Commit flag "+ex); 
			//logger.log(Level.TRACE);
			//System.out.println("Could not set Commit flag"+ex);
		}
	}

	public String removeDoubleQuotes(String quotedText)
	{
		String removedText = quotedText.replace('"','\'');
		return removedText;
	}
	
	
}
