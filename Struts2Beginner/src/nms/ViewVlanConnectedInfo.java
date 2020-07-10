package nms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;

/**
*getters and setters for vlan information which includes vlan id and vlan name
*/

public class ViewVlanConnectedInfo
{
	
	private int portNumber;
	private String deviceMACAddress,deviceIPAddress,switchIPAddress,portTypeInSwitch;
	
	

	public void setPortNumber(int name) throws IOException
	{
		portNumber=name;

	}

	public int getPortNumber() throws IOException
	{
		return portNumber;

	}

	public void setSwitchIPAddress(String name) throws IOException
	{
		switchIPAddress=name;

	}

	public String getSwitchIPAddress() throws IOException
	{
		return switchIPAddress;

	}
public void setDeviceMACAddress(String name) throws IOException
	{
		deviceMACAddress=name;
	}
	
public String getDeviceMACAddress() throws IOException
	{
		return deviceMACAddress;
	
	}

	
public void setDeviceIPAddress(String name) throws IOException
	{
		deviceIPAddress=name;
	}
	
public String getDeviceIPAddress() throws IOException
	{
		return deviceIPAddress;
	
	}	
public void setPortTypeInSwitch(String name) throws IOException
	{
		portTypeInSwitch=name;
	}
	
public String getPortTypeInSwitch() throws IOException
	{
		return portTypeInSwitch;
	
	}

}