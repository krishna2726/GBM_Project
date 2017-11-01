package com.gbm.ppf.testscripts;

import java.io.File;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gbm.lib.ApplicationFunc;
import com.gbm.lib.Global;
import com.tenx.framework.lib.Browser;
import com.tenx.framework.lib.Messages;
import com.tenx.framework.lib.Utilities;
import com.tenx.framework.lib.Verify;
import com.tenx.framework.reporting.Reporting;

public class GBM_TS9_PPF_Reports {
	public static boolean bStatus;

	protected static String sGBMTempPath = Global.sGBMTempTestDataPath;
	protected static String sGBMTestDataFilepath = "";
	protected static String sTestCaseName = "PPF_Reports_TC9";
	protected static Map<String, String> objTransactionDetails = null;
	public static String sSheetName = "PPF";
	@BeforeTest
	public static void  preRequisite() 
	{
		Reporting.Functionality = "PPF";
		sGBMTestDataFilepath = Global.sGBMTestDataPath+File.separator+Global.sTestDataFileName;
		boolean bFileExists;

		// Verify if the testdata file exists in the specified path
		bFileExists = Verify.verifyFileExists(sGBMTestDataFilepath);
		if(!bFileExists){
			//Report Failure
			Assert.fail(Messages.errorMsg);
		}
	}
	@Test (description="PPF Reports")
	public static void PPF_Reports() 
	{
		try
		{
			//Login to Finacle as Maker
			bStatus = ApplicationFunc.loginToFinacleAsMaker();
			Reporting.Testcasename = sTestCaseName;

			// Report fail
			if (!bStatus){
				Reporting.logResults("Fail", "Login to Finacle application with valid credentials", "Unable to login. Error Message: " +Messages.appErrorMsg + Messages.errorMsg);
				Assert.fail("Unable to login. Error Message:" +Messages.appErrorMsg + Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Login to Finacle application with valid credentials", "Sucessfully logged in to finacle application");

			// Read testdata and store it in map
			objTransactionDetails = Utilities.readTestData(sGBMTestDataFilepath, sSheetName, sTestCaseName);
			if(objTransactionDetails.size() == 0)
				Assert.fail("No data in testdata file to create reports");

			// Navigate to GBM from Finacle
			bStatus = ApplicationFunc.switchToGBMApplicationWithSolID(objTransactionDetails.get("SolID"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Navigate GBM", "GBM Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to GBM from finacle", Messages.appErrorMsg);

			// Navigate to CBDT Transaction Maintenance page for adding a transaction
			bStatus = ApplicationFunc.navigateToPPFTransaction(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Navigate the Account Open Report - Range Datewise page", "Navigation failed. Error Message:" + Messages.errorMsg + Messages.appErrorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", "Navigate to  Account Open Report - Range Datewise page.","Transaction Maintenance page is opened to create new transaction.");

			bStatus = ApplicationFunc.getDatewiseReport();
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to get the Account Open Report - Range Datewise", Messages.errorMsg);
				Assert.fail(Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Get the Account Open Report - Range Datewise", "PPF Account Ledger report - Range datewise data is fetched.");
			//Navigate To PPF Statement of Accounts
			bStatus = ApplicationFunc.getStatementsReports(objTransactionDetails.get("SolID"),objTransactionDetails.get("AccountNo"),objTransactionDetails.get("FromDate"),objTransactionDetails.get("ToDate"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open PPF Reports-'Statement of Accounts' page", "Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate To PPF-Statement of Accounts page.","PPF Statement of Accounts page is opened to Generate reports.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@AfterTest
	public static void closeBrowser()
	{
		// Logout from Finacle
		bStatus = ApplicationFunc.logoutFromFinacle();
		if(!bStatus)
			Reporting.logResults("Fail", "Logout from  application", "Failed to logout");
		else
			Reporting.logResults("Pass", "Logout from  application", "User successfully logged out from application");
		Browser.closeAllBrowsers(Global.wDriver);
	}
}
