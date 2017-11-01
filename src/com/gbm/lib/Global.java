package com.gbm.lib;

import org.openqa.selenium.WebDriver;

public class Global {
	
	public static WebDriver wDriver = null;
	
	public static String sVPNURL ="https://59.144.108.8/eph";
	public static String sVPNUserName ="tenx1";
	public static String sVPNUserPassword ="tenx@123";
	
	public static String sGBMURL ="http://blrqavm3/meridium/index.html";
	public static String sMakerUserName ="bl";
	public static String sMakerUserPassword ="bl";
	
	public static String sCheckerUserName ="TP000407";
	public static String sCheckerUserPassword ="Axis@1234";

	public static String sBrowserType = "Chrome";
	public static String sIEDriverPath = "drivers//IEDriverServer.exe";	
	public static String sGBMTestDataPath = "testdata//gbm";
	public static String sGBMTempTestDataPath = "temp";
	public static String sGBMTXMLTestDataPath = "XMLMessages";
	public static String sTestDataFileName = "gbmtestdata_format.xls";
	public static String sSheetName = "TransactionDetails";
	public static String sUploadFilePath = System.getProperty("user.dir");

}
