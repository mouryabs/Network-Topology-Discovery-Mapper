package nms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;



public class ViewSwitchInfoDB
{
	private String switchMACAddress;
	private String switchIPAddress;
	private String switchName;
	private int numOfPorts;
	private String location;
	private String resetDateTime;
	private String contactPerson;
	
public void setSwitchMACAddress(String name) throws IOException
{
	switchMACAddress=name;

}

public String getSwitchMACAddress() throws IOException
{
	return switchMACAddress;

}

public void setSwitchIPAddress(String name) throws IOException
{
	switchIPAddress=name;

}

public String getSwitchIPAddress() throws IOException
{
	return switchIPAddress;

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

public String getContactPerson()throws IOException
{
	return contactPerson;

}

public void setContactPerson(String name)throws IOException
{
	contactPerson=name;

}

public String getResetDateTime()throws IOException
{
	return resetDateTime;

}

public void setResetDateTime(String name)throws IOException
{
	resetDateTime=name;

}


}