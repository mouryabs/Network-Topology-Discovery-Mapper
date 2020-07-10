package nms;
import java.sql.*;
import java.util.*;

import org.apache.commons.lang.math.RandomUtils;
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
//import sun.misc.CharacterEncoder;
//import sun.misc.BASE64Encoder;	
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class createChart
{

	private JFreeChart chart;
	
	public void createChart()
	{


	}

	public void createChart(XYSeriesCollection dataset)
	{
		ValueAxis xAxis = new NumberAxis("");
		ValueAxis yAxis = new NumberAxis("");
		
		// set my chart variable
		chart = new JFreeChart("MAPPING CHART",
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
		chart.setBackgroundPaint(java.awt.Color.white);

	}



}