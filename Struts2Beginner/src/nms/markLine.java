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
import missing.*;
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
//import sun.misc.CharacterEncoder;
//import sun.misc.BASE64Encoder;	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class markLine
{
	private static XYSeriesCollection dataset= new XYSeriesCollection();
	public void markLine()
	{

	}

	public XYSeriesCollection plotLine(double xAxis1,double yAxis1,double xAxis2,double yAxis2,String i) throws Exception
		{
			markComp mc=new markComp();
			markLine ml=new markLine();
			ExampleChartAction eca = new ExampleChartAction();
			XYSeries series1=new XYSeries(i);
			series1.add(xAxis1,yAxis1);
			series1.add(xAxis2, yAxis2);
			dataset.addSeries(series1);
			return dataset;
		}
		
		
}