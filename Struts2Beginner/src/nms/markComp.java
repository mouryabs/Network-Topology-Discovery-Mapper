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
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.urls.*;
//import org.jfree.chart.annotations.XYTextAnnotation.Font;
import org.jfree.chart.annotations.*;
import org.jfree.chart.urls.*;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.entity.*;
import org.jfree.chart.entity.XYItemEntity;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.RectangleAnchor;
import org.jfree.util.PublicCloneable;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jfree.chart.annotations.TextAnnotation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import java.awt.*;
//import sun.misc.CharacterEncoder;
//import sun.misc.BASE64Encoder;	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class markComp
{
	public void markComp()
	{

	}
	public void plotSwitch(double xAxis,double yAxis, JFreeChart chart,XYPlot plot) throws Exception
		{		

			final BufferedImage myPicture1 = ImageIO.read(new File("E:\\ashwini1\\pics\\switch3.png"));
			XYImageAnnotation img= new XYImageAnnotation(xAxis,yAxis, myPicture1);

			plot.addAnnotation(img);
			
		}
		
		
	public void plotHub(double xAxis,double yAxis, JFreeChart chart,XYPlot plot) throws Exception
		{		
			final BufferedImage myPicture1 = ImageIO.read(new File("E:\\ashwini1\\pics\\hub1.png"));
			XYImageAnnotation img= new XYImageAnnotation(xAxis,yAxis, myPicture1);
			
			plot.addAnnotation(img);
		}
	public void plotComp(double xAxis,double yAxis,JFreeChart chart,XYPlot plot,XYDataset dataset) throws Exception
		{		
			final BufferedImage myPicture = ImageIO.read(new File("E:\\ashwini1\\pics\\PC.png"));
			XYImageAnnotation img= new XYImageAnnotation(xAxis,yAxis, myPicture);
			plot.addAnnotation(img);

		
		}

	public void plotText(double xAxis,double yAxis,String deviceMacInfo,String deviceIPInfo,int devicePortInfo,int deviceVlanInfo, String deviceVlanName,JFreeChart chart,XYPlot plot) throws Exception
		{
			String macInfo=deviceMacInfo;
			String ipInfo="IP"+":"+deviceIPInfo;
			String portInfo="Port"+":"+Integer.toString(devicePortInfo);
			String vlanInfo="VLANID"+":"+Integer.toString(deviceVlanInfo)+"("+deviceVlanName+")";
			
			XYTextAnnotation txt1=new XYTextAnnotation(macInfo,xAxis,yAxis-20.0);
			txt1.setFont(new Font("TimesNewRoman",Font.BOLD,10)); //java.awt.
			XYTextAnnotation txt2=new XYTextAnnotation(ipInfo,xAxis,yAxis-25.0);
			XYTextAnnotation txt3=new XYTextAnnotation(portInfo,xAxis,yAxis-30.00);
			XYTextAnnotation txt4=new XYTextAnnotation(vlanInfo,xAxis,yAxis-35.00);
			
			plot.addAnnotation(txt1);
			plot.addAnnotation(txt2);
			plot.addAnnotation(txt3);
			plot.addAnnotation(txt4);
		}
		
		public void plotHubDetailText(double xAxis,double yAxis,String deviceInfo,JFreeChart chart,int countOfHubPorts,XYPlot plot) throws Exception
		{
			StringTokenizer str = new StringTokenizer(deviceInfo.trim(),";");
			StringTokenizer innerString;
			String dataTemp = "",innerDataTemp="";
			double yAxisAdjustment = 10.00;
			while (str.hasMoreTokens())
			{
				dataTemp = str.nextToken();
				if (countOfHubPorts < 6) //less number of ports, adjust printing labels
				{
					innerString = new StringTokenizer(dataTemp,"|");
					while(innerString.hasMoreTokens())
					{
						innerDataTemp = innerString.nextToken();
						XYTextAnnotation txt1=new XYTextAnnotation(innerDataTemp,xAxis+50.0,yAxis-yAxisAdjustment);
						plot.addAnnotation(txt1);
						yAxisAdjustment += 5.0;
					}
				}else
				{
					XYTextAnnotation txt1=new XYTextAnnotation(dataTemp,xAxis+20.0,yAxis-yAxisAdjustment);
					plot.addAnnotation(txt1);
					yAxisAdjustment += 5.0;
				}
			}
		}
		
		public void plotHubText(double xAxis,double yAxis,int deviceInfo,JFreeChart chart,XYPlot plot) throws Exception
		{
			String portInfo="Port"+":"+Integer.toString(deviceInfo);
			XYTextAnnotation txt1=new XYTextAnnotation(portInfo,xAxis+20.0,yAxis-10.00);
			plot.addAnnotation(txt1);

		}
		
		public void plotSwitchText(double xAxis,double yAxis,int devicePortInfo, String switchMACDetails, String switchIPDetails, JFreeChart chart,XYPlot plot) throws Exception
		{
			String portInfo="Port"+":"+Integer.toString(devicePortInfo);
			String switchMACInfo=switchMACDetails;
			String switchIpInfo="IP"+":"+switchIPDetails;
			
			XYTextAnnotation txt1=new XYTextAnnotation(switchMACInfo,xAxis+10.0,yAxis-20.00);
			XYTextAnnotation txt2=new XYTextAnnotation(switchIpInfo,xAxis+10.0,yAxis-25.00);
			XYTextAnnotation txt3=new XYTextAnnotation(portInfo,xAxis+10.0,yAxis-30.00);
			
			plot.addAnnotation(txt1);
			plot.addAnnotation(txt2);
			plot.addAnnotation(txt3);

		}
		
		
		
}