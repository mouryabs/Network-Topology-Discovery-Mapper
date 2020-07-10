package nms;
import java.io.*;
import java.util.*;
import java.sql.*;
////////////////////////////////////////////////////////////////////////////////
// JAVA - MYSQL CONNECTIVITY COMPONENT
// 
// Design Pattern : Singleton
// /////////////////////////////////////////////////////////////////////////////

public class ConToDB
{

    static Connection con  = null;
    static String user     = "root";
    static String password = "";
    static String server   = "jdbc:mysql://localhost:3306/project";

    public static void setConnection() throws SQLException
    {
        try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
		catch (InstantiationException   e)
		{
			System.out.println("ERROR " + e);
        }
		catch (ClassNotFoundException   e)
		{
			System.out.println("ERROR " + e);
        }
		catch (IllegalAccessException   e)
		{
			System.out.println("ERROR " + e);
		}
		
			con = DriverManager.getConnection(server,user,password);
		
		
		
    }//setConnection
}

