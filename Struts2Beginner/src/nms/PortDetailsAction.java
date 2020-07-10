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
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.annotations.*;

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
	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class PortDetailsAction extends ActionSupport 
{
	public String execute() throws Exception 
	{
		Statement stmt = null;
		ResultSet rs = null;
		DBUtils utils = new DBUtils();	
		String ipAddress="10.21.200.1";
		String valueFromDB = "";
		String selectQuery="select portNumber,portStatus from portDetails where switchIPAddress=";
		rs=utils.executeDBQuery(selectQuery);
		try{
			if(!rs.next()) 
			{
				System.out.println(" No  data  available in database");
			}else 
			{
				do
				{
				valueFromDB=rs.getInt("portNumber") + rs.getString("portStatus");
				System.out.println(valueFromDB);			
			    }while(rs.next());
			
			}
			
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	//	chart.setBackgroundPaint(java.awt.Color.white);
		return com.opensymphony.xwork2.ActionSupport.SUCCESS;
	
	}


}