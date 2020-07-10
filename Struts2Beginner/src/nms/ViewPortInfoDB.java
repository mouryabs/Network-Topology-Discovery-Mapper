package nms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;


public class ViewPortInfoDB
{

	private int portNum;
	private String portStatus;
	private String switchIPAddress;
	private String deviceIPAddress;
	private String deviceMACAddress;
	private String portTypeInSwitch;
	private String switchMACAddress,deviceTypeInfo;

	private String switchName;
	private int numOfPorts,vlanId;
	private String location;

	public void setPortNum(int port) throws IOException
	{
		portNum=port;
		
	}
	
	public int getPortNum() throws IOException
	{
	
		return portNum;
	
	}
	
	public void setPortStatus(String name) throws IOException
	{
		portStatus=name;
	}
	
	public String getPortStatus() throws IOException
	{
		return portStatus;
	
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
	
	
	public void setSwitchMACAddress(String name) throws IOException
{
	switchMACAddress=name;

}

public String getSwitchMACAddress() throws IOException
{
	return switchMACAddress;

}



public void setSwitchName(String name) throws IOException
{
	switchName=name;

}

public String getSwitchName() throws IOException
{
	return switchName;

}

public void setNumOfPorts(int name) throws IOException
{
	numOfPorts=name;

}

public int getNumOfPorts() throws IOException
{
	return numOfPorts;

}

public void setLocation(String name) throws IOException
{
	location=name;

}

public String getLocation() throws IOException
{
	return location;

}


public void setDeviceTypeInfo(String name) throws IOException
{
	deviceTypeInfo=name;

}

public String getDeviceTypeInfo() throws IOException
{
	return deviceTypeInfo;

}


public int getVlanId() throws IOException
{
	return vlanId;

}

public void setVlanId(int name) throws IOException
{
	vlanId=name;

}
	
}