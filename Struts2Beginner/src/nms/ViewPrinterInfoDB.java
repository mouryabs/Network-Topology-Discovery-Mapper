package nms;
import java.util.ArrayList;
import java.util.ListIterator;
import java.io.*;


public class ViewPrinterInfoDB
{


	private String deviceIPAddress;
	private String deviceTypeInfo;
	private String printerIPAddress;
	private String computerIPAddress,printerName;
	
	public void setDeviceIPAddress(String name) throws IOException
	{
		deviceIPAddress=name;
	}
	
	public String getDeviceIPAddress() throws IOException
	{
		return deviceIPAddress;
	
	}
	
public void setDeviceTypeInfo(String name) throws IOException
{
	deviceTypeInfo=name;

}

public String getDeviceTypeInfo() throws IOException
{
	return deviceTypeInfo;

}

public void setComputerIPAddress(String name) throws IOException
{
	computerIPAddress=name;

}

public String getComputerIPAddress() throws IOException
{
	return computerIPAddress;

}


public void setPrinterIPAddress(String name) throws IOException
{
	printerIPAddress=name;

}

public String getPrinterIPAddress() throws IOException
{
	return printerIPAddress;

}

public void setPrinterName(String name) throws IOException
{
	printerName=name;

}

public String getPrinterName() throws IOException
{
	return printerName;

}


	
}