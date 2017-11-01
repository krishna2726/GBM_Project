package com.gbm.npstestscripts;

import java.io.File;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gbm.lib.ApplicationFunc;
import com.gbm.lib.Global;
import com.tenx.framework.lib.Browser;
import com.tenx.framework.lib.Messages;
import com.tenx.framework.lib.Utilities;
import com.tenx.framework.lib.Verify;
import com.tenx.framework.reporting.Reporting;

public class GBM_TS5_NPS_PRAN_MASTERWalkin {
	public static boolean bStatus;
	protected static String sGBMTempPath = Global.sGBMTempTestDataPath;
	protected static String sGBMTestDataFilepath = "";
	protected static String sTestCaseName = "PRAN_MASTER_TC1";
	protected static Map<String, String> objTransactionDetails = null;
	public static String sSheetName = "NPS";

	@BeforeTest
	public static void  preRequisite() 
	{
		Reporting.Functionality = "NPS";
		sGBMTestDataFilepath = Global.sGBMTestDataPath+File.separator+Global.sTestDataFileName;
		boolean bFileExists;

		// Verify if the testdata file exists in the specified path
		bFileExists = Verify.verifyFileExists(sGBMTestDataFilepath);
		if(!bFileExists){
			//Report Failure
			Assert.fail(Messages.errorMsg);
		}
	}
	@Test (description="Creates and Verify the PRAN Number")
	public static void NPS_PRAN_MASTERWalkin() 
	{
		try
		{
			//Login to Finacle as Maker
			bStatus = ApplicationFunc.loginToFinacleAsMaker();
			Reporting.Testcasename = sTestCaseName;

			// Report fail
			if (!bStatus){
				Reporting.logResults("Fail", "Login to Finacle application with valid Maker credentials", "Unable to login. Error Message: " +Messages.appErrorMsg + Messages.errorMsg);
				Assert.fail("Unable to login. Error Message:" +Messages.appErrorMsg + Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Login to Finacle application with valid maker credentials", "Sucessfully logged in to finacle application with maker credentials");

			// Read testdata and store it in map
			objTransactionDetails = Utilities.readTestData(sGBMTestDataFilepath, sSheetName, sTestCaseName);
			if(objTransactionDetails.size() == 0)
			{
				Assert.fail("No data in testdata file to create transaction");
			}
			// Navigate to GBM from Finacle
			bStatus = ApplicationFunc.switchToGBMApplicationWithSolID(objTransactionDetails.get("SolID"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Navigate GBM", "GBM Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to GBM from finacle", Messages.appErrorMsg);

			// Navigate to NPS PRAN MASTER Walkin customer page as Maker
			bStatus = ApplicationFunc.navigateToPPFTransaction(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open 'NPS PRAN MASTER Walkin' page", "Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to NPS PRAN MASTER Walkin customer page.","NPS PRAN MASTER Walkin customer page is opened to create new PRAN Number.");
			//Create PRAN Number
			bStatus= ApplicationFunc.createPRANNoTransaction(objTransactionDetails);
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Create PRAN Number", "Create PRAN Number failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", "Create PRAN Nubmer","PRAN Number created successfully.");

			// Logout from Finacle as Maker
			bStatus = ApplicationFunc.logoutFromFinacle();
			if(!bStatus){
				Reporting.logResults("Fail", "Logout from  application", "Failed to logout");
				//Assert.fail("Log out from maker is failed");
			}
			Reporting.logResults("Pass", "Logout from  application", "Maker has successfully logged out from application");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//*************** LOGIN TO FINACLE AS CHECKER ***********************//

		bStatus = ApplicationFunc.loginToFinacleAsChecker();
		//report fail
		if (!bStatus){
			Reporting.logResults("Fail", "Login to Finacle application with valid checker credentials", "Unable to login. Error Message:" + Messages.errorMsg);
			Assert.fail("Unable to login. Error Message:" + Messages.errorMsg);
		}
		Reporting.logResults("Pass", "Login to Finacle application with valid checker credentials", "Sucessfully logged in to finacle application with checker credentials");

		// Navigate to GBM from Finacle
		bStatus = ApplicationFunc.switchToGBMApplicationWithSolID(objTransactionDetails.get("SolID"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Failed to Navigate GBM", "GBM Navigation failed. Error Message:" + Messages.errorMsg);
			Assert.fail( Messages.errorMsg);	
		}
		Reporting.logResults("Pass", " Navigate GBM from finacle", Messages.appErrorMsg);
		//// Navigate to NPS PRAN MASTER Walkin customer page as Checker
		bStatus = ApplicationFunc.navigateToPPFTransaction(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Failed to open 'PRAN MASTERWalkin customer page' page", "Navigation failed. Error Message:" + Messages.errorMsg);
			Assert.fail( Messages.errorMsg);	
		}
		Reporting.logResults("Pass", " Navigate to PRAN MASTER Walkin customer page.","PRAN MASTER Walkin customer page is opened to create new PRAN Number.");

		// Verify the NPS PRAN Number as Checker
		bStatus = ApplicationFunc.VerifyNPS_PRANNo(objTransactionDetails.get("PRANNUMBER"));
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Failed to validate the transaction", "Transaction validation failed. Error Message:" + Messages.errorMsg);
			Assert.fail( Messages.errorMsg);
		}
		Reporting.logResults("Pass", "Validate the NPS PRAN Number",Messages.appErrorMsg);
	}
	@AfterMethod
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
