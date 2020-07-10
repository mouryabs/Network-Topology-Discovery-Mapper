package net.codejava.struts;

public class AddressHolder {
public String MacAddress;
public String IPAddress;

public AddressHolder(String mac, String ip)
{
	MacAddress = mac;
	IPAddress = ip;
}
public String getIPAddress() {
	return IPAddress;
}
public void setIPAddress(String iPAddress) {
	IPAddress = iPAddress;
}
public String getMacAddress() {
	return MacAddress;
}
public void setMacAddress(String macAddress) {
	MacAddress = macAddress;
}

}
