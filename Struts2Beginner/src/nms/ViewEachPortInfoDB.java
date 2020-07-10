package nms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;

/**
*Getters and setters for each port details of switch is obtained
*/

public class ViewEachPortInfoDB
{
	private String switchIPAddress;
	private String numOfInPackets;
	private int portNumber,portNum;
	private String numOfOutPackets;
	private String portStatus;
	
	public void setSwitchIPAddress(String name) throws IOException
	{
		switchIPAddress=name;

	}

	public String getSwitchIPAddress() throws IOException
	{
		return switchIPAddress;

	}

	public void setNumOfInPackets(String name) throws IOException
	{
		numOfInPackets=name;

	}

	public String getNumOfInPackets() throws IOException
	{
		return numOfInPackets;

	}

	public void setNumOfOutPackets(String name) throws IOException
	{
		numOfOutPackets=name;

	}

	public String getNumOfOutPackets() throws IOException
	{
		return numOfOutPackets;

	}

	public void setPortNumber(int name) throws IOException
	{
		portNumber=name;

	}

	public int getPortNumber() throws IOException
	{
		return portNumber;

	}

	public String getPortStatus()throws IOException
	{
		return portStatus;

	}

	public void setPortStatus(String name)throws IOException
	{
		portStatus=name;

	}
	
	public int getPortNum() {
        return portNum;
    }
	
public void setPortNum(int value)
{
	this.portNum=value;

} 


}