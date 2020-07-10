package nms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;

/**
*getters and setters for vlan information which includes vlan id and vlan name
*/

public class ViewVlanInfo
{
	
	private int vlanId;
	private String vlanName;
	
	public void setVlanId(int name) throws IOException
	{
		vlanId=name;

	}

	public int getVlanId() throws IOException
	{
		return vlanId;

	}

	public void setVlanName(String name) throws IOException
	{
		vlanName=name;

	}

	public String getVlanName() throws IOException
	{
		return vlanName;

	}

	

}