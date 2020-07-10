package nms;
import java.sql.*;
import java.util.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.annotations.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.PublicCloneable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import missing.*;	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
/**
*<h1>Draws the topology chart by accessing the database and drawing the lines and images</h1>
*It marks the lines by calling markLine() and marks images anf txt in chart by calling markComp()
*@author Gurumoorthy.D
*@author Ashwini Sreedhar
*@version 1.0

*/

public class DrawChartTopology extends ActionSupport
{

	private JFreeChart chart;
	private DBUtils utils;
	private Logger logger;
	private String switchIPAddress;
	private ArrayList<Integer> forwardArrayList;
	private ArrayList<Integer> normalArrayList;
	private ArrayList<Integer> hubArrayList;
	private ArrayList<Integer> hubValueArrayList;
	private LinkedHashMap<Integer,Integer>noOfHubConnection;
  
	private  double xAxisOfMainSwitch=300.0;
	private  double yAxisOfMainSwitch=400.0;
	
	public String getSwitchIPAddress()
	{
        return switchIPAddress;
    }
	
	public void setSwitchIPAddress(String value) {
        switchIPAddress = value;
    }
	
	public DrawChartTopology(){
		utils = new DBUtils();
		//logger = Logger.getLogger(Login.class);
	}

	public String execute() throws Exception 
	{
		switchIPAddress=getSwitchIPAddress();
		markLine ml=new markLine();
		markComp mc=new markComp();
		DrawChartTopology eca = new DrawChartTopology();
		XYSeriesCollection dataset= new XYSeriesCollection();
		forwardArrayList=new ArrayList<Integer>();
		normalArrayList=new ArrayList<Integer>();
		hubArrayList=new ArrayList<Integer>();
		hubValueArrayList=new ArrayList<Integer>();
		noOfHubConnection=new LinkedHashMap<Integer,Integer>();
		//portMapping pm=new portMapping();
		String forwardPortQuery="select portNumber from camEntries where portTypeInSwitch='forwarding_port' and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
		String normalPortQuery="select portNumber from camEntries where portTypeInSwitch='normal_port' and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
		String hubPortQuery="select portNumber from camEntries where portTypeInSwitch='hub_port' and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
		Object key;
		
		double xAxisOfLine=xAxisOfMainSwitch-100.0;
		double yAxisOfLine=yAxisOfMainSwitch-100.0;
		double xAxisOfDevices=xAxisOfLine;
		double yAxisOfDevices=yAxisOfLine;
		int countOfHubDevices=0;
		int dynamicCountOfHubDevices=0;

		normalArrayList=eca.retrieveForwardDataBase(normalPortQuery);
		HashSet<Integer> normalPortSet=new HashSet<Integer>(normalArrayList);
		ArrayList<Integer>normalPortList=new ArrayList<Integer>(normalPortSet);
		int normalPortCount=normalPortSet.size();
		Iterator normalPortIt=normalPortSet.iterator(); 
		
		forwardArrayList=eca.retrieveForwardDataBase(forwardPortQuery);
		HashSet<Integer> forwardPortSet=new HashSet<Integer>(forwardArrayList);
		int forwardPortCount=forwardPortSet.size();
		ArrayList<Integer>forwardPortList=new ArrayList<Integer>(forwardPortSet);
		Iterator forwardPortIt=forwardPortSet.iterator(); 
		
		hubArrayList=eca.retrieveForwardDataBase(hubPortQuery);
		HashSet<Integer> hubPortSet=new HashSet<Integer>(hubArrayList);
		ArrayList<Integer> hubPortList=new ArrayList<Integer>(hubPortSet);
		
		for(int hubPort:hubPortSet)
		{
		noOfHubConnection.put(hubPort,Collections.frequency(hubArrayList,hubPort));
		noOfHubConnection.put(hubPort,Collections.frequency(hubArrayList,hubPort));
		}
		//System.out.println(hubPortSet);
		Iterator hubPortIt=hubPortSet.iterator(); 
		Set keySet = noOfHubConnection.keySet();

		int hubPortCount=hubPortSet.size();
		Iterator hubListIt=keySet.iterator(); 
		
		while (hubListIt.hasNext())
		{
			key = hubListIt.next();
			hubValueArrayList.add(noOfHubConnection.get(key));
		}
/**
*Marks line for normal ports.
*/	
	
		for(int i=0;i<normalPortCount;i++)
		{
			dataset=ml.plotLine(xAxisOfMainSwitch,yAxisOfMainSwitch,xAxisOfLine,yAxisOfLine,"1");
			xAxisOfLine=xAxisOfLine+300.0;
		}

		double xAxisOfHubLine=xAxisOfLine-150.0;
		double yAxisOfHubLine=yAxisOfLine-100.0;	
/**
*Marks line for hub ports.
*/
		
		for(int i=0;i<hubPortCount;i++)
		{
			int countOfInnerHubDetails=hubValueArrayList.get(i);
			countOfHubDevices=countOfHubDevices+countOfInnerHubDetails;
		}
/**
*Marks the line for hub interconnection
*/
		for(int i=0;i<hubPortCount;i++)
		{
			dataset=ml.plotLine(xAxisOfMainSwitch,yAxisOfMainSwitch,xAxisOfLine,yAxisOfLine,"1");
			int countOfInnerHubDetails=hubValueArrayList.get(i);
			for(int j=0;j<countOfInnerHubDetails;j++)
			{	
				dynamicCountOfHubDevices++;
				if(dynamicCountOfHubDevices!=countOfHubDevices)
				{
				dataset=ml.plotLine(xAxisOfLine,yAxisOfLine,xAxisOfHubLine,yAxisOfHubLine,"1");
				}
				else{
				dataset=ml.plotLine(xAxisOfLine,yAxisOfLine,xAxisOfHubLine,yAxisOfHubLine,"300");
				}
				xAxisOfHubLine=xAxisOfHubLine+250.0;
			}
				xAxisOfLine=xAxisOfLine+250.0;
		}	
/**
*Marks line for forwarding ports.
*/
		for(int i=0;i<forwardPortCount;i++)
		{
			if(forwardPortCount-1==i)
			{
			dataset=ml.plotLine(xAxisOfMainSwitch,yAxisOfMainSwitch,xAxisOfLine,yAxisOfLine,"100");
			}
			
			else 
			{
			dataset=ml.plotLine(xAxisOfMainSwitch,yAxisOfMainSwitch,xAxisOfLine,yAxisOfLine,"500");
			}
			xAxisOfLine=xAxisOfLine+250.0;
		}

		ValueAxis xAxis = new NumberAxis("");
		ValueAxis yAxis = new NumberAxis("");
		
		// set my chart variable
		chart = new JFreeChart("MAPPING CHART for"+"  "+switchIPAddress,
		JFreeChart.DEFAULT_TITLE_FONT, new XYPlot(dataset, xAxis,
		yAxis, new StandardXYItemRenderer(
		StandardXYItemRenderer.LINES)), false);
		XYPlot plot=(XYPlot)chart.getXYPlot();

		ValueAxis range=plot.getRangeAxis();
		range.setAutoRange(true);
		range.setVisible(false);
		
		ValueAxis domain=plot.getDomainAxis();
		domain.setAutoRange(true);
		domain.setVisible(false);
		
		//XYItemRenderer xyir=plot.getRenderer();
		//xyir.setSeriesPaint(0,Color.BLACK);

/**
Marks the main switch image
*/		
		mc.plotSwitch(xAxisOfMainSwitch,yAxisOfMainSwitch,chart,plot);
/**
Marks the image and textual information for the normal ports
*/

		for(int i=0;i<normalPortCount;i++)
		{
			mc.plotComp(xAxisOfDevices,yAxisOfDevices,chart,plot,dataset);
			int portNumofDevice=normalPortList.get(i);
			String textQuery1="select deviceMACAddress from camEntries where portNumber= "+portNumofDevice+" and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
			String textQuery2="select portNumber from camEntries where portNumber= "+portNumofDevice+" and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
			String textQuery3="select vlanId from camEntries where portNumber= "+portNumofDevice+" and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
			 
			String deviceMACDetails=eca.retrieveMACDetails(textQuery1);
			String textQuery4="select deviceIPAddress from macToIpMap where deviceMACAddress ='"+deviceMACDetails+"'";
			String deviceIPDetails=eca.retrieveMACDetails(textQuery4);
			int devicePortDetails=eca.retrievePortandVlanDetails(textQuery2);
			int deviceVlanIdDetails=eca.retrievePortandVlanDetails(textQuery3);
			
			String textQuery5="select vlanName from vlanInfo where vlanId ='"+deviceVlanIdDetails+"'";
			String deviceVlanName=eca.retrieveMACDetails(textQuery5);
			
			mc.plotText(xAxisOfDevices,yAxisOfDevices-30.0,deviceMACDetails,deviceIPDetails,devicePortDetails,deviceVlanIdDetails,deviceVlanName,chart,plot);
			xAxisOfDevices=xAxisOfDevices+300.0;
		}
		
		double xAxisOfHubDevice=xAxisOfDevices-150.0;
		double yAxisOfHubDevice=yAxisOfDevices-100.0;
/**
Marks the image and textual information for the hub ports
*/		
		
		for(int i=0;i<hubPortCount;i++)
		{
			mc.plotHub(xAxisOfDevices,yAxisOfDevices,chart,plot);
			int portNumofHub=hubPortList.get(i);
			mc.plotHubText(xAxisOfDevices,yAxisOfDevices-20.0,portNumofHub,chart,plot);
		
			int portNumhubDetails=hubPortList.get(i);
			String textQueryHubDetails="select deviceMACAddress,vlanId from camEntries where portNumber= "+portNumhubDetails+" and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
			String hubTextDetails=eca.hubDetails(textQueryHubDetails);
			int countOfHubPorts=hubValueArrayList.get(i);
			mc.plotHubDetailText(xAxisOfHubDevice,yAxisOfHubDevice-20.0,hubTextDetails,chart,countOfHubPorts,plot);
			for(int j=0;j<countOfHubPorts;j++)
			{
				mc.plotComp(xAxisOfHubDevice,yAxisOfHubDevice,chart,plot,dataset);
				xAxisOfHubDevice=xAxisOfHubDevice+250.0;
			}	
			xAxisOfDevices=xAxisOfDevices+250.0;
		}
/**
Marks the image and textual information for the forwarding ports
*/		
		
		for(int i=0;i<forwardPortCount;i++)
		{
			mc.plotSwitch(xAxisOfDevices,yAxisOfDevices,chart,plot);
			int portNumofSwitch=forwardPortList.get(i);
			//System.out.println("nextSwitchIPPort"+portNumofSwitch);
			String textQuery="select switchIPAddress from forwardingPortDetails where switchPortNum="+portNumofSwitch+" and rootSwitchIPAddress='"+switchIPAddress+"'";
			String nextSwitchIP=eca.retrieveMACDetails(textQuery); //retrieves next switch IP address from forwadingPortDetails table
			
			if(nextSwitchIP.contains("10.21.200"))
			{
			String textQuery1="select switchMACAddress from forwardingPortDetails where switchPortNum="+portNumofSwitch+" and rootSwitchIPAddress='"+switchIPAddress+"'";
			String switchMACDetails=eca.retrieveMACDetails(textQuery1);
			mc.plotSwitchText(xAxisOfDevices,yAxisOfDevices,portNumofSwitch,switchMACDetails,nextSwitchIP,chart,plot);
			xAxisOfDevices=xAxisOfDevices+300.0;
			}
			
			else{
			String textQuery1="select deviceMACAddress from camEntries where deviceIPAddress like '10.21.200%' and portNumber="+portNumofSwitch+" and( switchIPAddress='"+switchIPAddress+"'and camEntryStatus='Y')";
			String switchMACDetails=eca.retrieveMACDetails(textQuery1);
			
			String textQuery2="select deviceIPAddress from macToIpMap where deviceMACAddress ='"+switchMACDetails+"'";
			String switchIPDetails=eca.retrieveMACDetails(textQuery2);
			mc.plotSwitchText(xAxisOfDevices,yAxisOfDevices,portNumofSwitch,switchMACDetails,switchIPDetails,chart,plot);
			xAxisOfDevices=xAxisOfDevices+250.0;
			}
		}
		
		chart.setBackgroundPaint(java.awt.Color.white);
		return com.opensymphony.xwork2.ActionSupport.SUCCESS;
	}
	
	public JFreeChart getChart() 
	{
	
		return chart;
	}
/**
*Retrieves the MACAddress of the devices from data base
*/	
	public String retrieveMACDetails(String query)   //,double xAxis,double yAxis)
	{
		Statement stmt = null;
		ResultSet rs = null;
		utils = new DBUtils();	
		rs=utils.executeDBQuery(query);
		int i=1; 
        boolean fullDetails = true;	
		String device_MAC_Address="";
		int device_details=0;
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database");
			}else 
			{
			
				try {
						device_MAC_Address =rs.getString(i);
						System.out.println(device_MAC_Address);
					}catch(NullPointerException e1)
					{
						System.out.println("mac_address is null");
						device_MAC_Address = "";
					}//catch
              		
			}
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
	
	 return device_MAC_Address;	
}
/**
*Retrieves the port numbers and vlan ids of the devices from data base
*/
public int retrievePortandVlanDetails(String query)   //,double xAxis,double yAxis)
	{
		Statement stmt = null;
		ResultSet rs = null;
		utils = new DBUtils();	
		rs=utils.executeDBQuery(query);
		int i=1; 
		String DATA="	";
        boolean fplotSwitchTextullDetails = true;	
		int device_details=0;
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database");
			}else 
			{

							try {
									device_details =rs.getInt(i);
								}catch(NullPointerException e)
								{
									System.out.println("mac_address is null");
								}//catch
                                         
					    
						
			}
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	 return device_details;	

}
/**
*Retrieves the the list of normal ports from data base and stores in the arraylist
*/
 public ArrayList retrieveForwardDataBase(String query)   //,double xAxis,double yAxis)
	{
		int data=0;
		ArrayList<Integer> al=new ArrayList<Integer>();
		Statement stmt = null;
		ResultSet rs = null;
		utils = new DBUtils();	
		rs=utils.executeDBQuery(query);
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database");
			}else 
			{
				do
				{
				data=rs.getInt("portNumber");
				al.add(data);				
			    }while(rs.next());
			
			}
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	 return al;	

} 

/**
*Retrieves the textual format of hub-connected devices
*/
	public String hubDetails(String hubQuery)
	{
		ExampleChartAction eca = new ExampleChartAction();
		Statement stmt = null;
		ResultSet rs = null;
		utils = new DBUtils();	
		String device_MAC_Address,port_type, vlan_id ="		";
	    int i=0; 
		String DATA="		";
		String DATA1="		";
        boolean fullDetails = true;	
		String valueFromDB = "";
		String fullData="";
		rs=utils.executeDBQuery(hubQuery);
		
		try {
			if(!rs.next()) {
				 System.out.println(" No  data  available in database");
			}else {
				do
				{
						valueFromDB="";
							try {
							    
								String hubMACAddress=(String)rs.getString("deviceMACAddress");
								String textQuery1="select deviceIPAddress from macToIpMap where deviceMACAddress ='"+hubMACAddress+"'";
								String hubIPAddress=eca.retrieveMACDetails(textQuery1);
								
								int hubVlanId=(int)rs.getInt("vlanId");
								System.out.println("hub vlan id"+hubVlanId);
								
								String textQuery2="select vlanName from vlanInfo where vlanId ="+hubVlanId+"";
								String hubVlanName=eca.retrieveMACDetails(textQuery2);
								valueFromDB = rs.getString("deviceMACAddress")+"|"+hubIPAddress+"|"+rs.getString("vlanId") +"("+hubVlanName+");";
							
								}catch(NullPointerException e)
								{
								System.out.println("mac_address is null");
								device_MAC_Address = "";
								fullDetails = false;
								}

					fullData += valueFromDB;
				}while(rs.next());
				
			}
			}catch(SQLException e6)
		{
			System.out.println(e6);
		}
		//System.out.println("data "+fullData);
			return fullData;
	}

}
