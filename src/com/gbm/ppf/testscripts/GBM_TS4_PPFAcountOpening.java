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


public class GBM_TS4_PPFAcountOpening {
	public static boolean bStatus;

	protected static String sGBMTempPath = Global.sGBMTempTestDataPath;
	protected static String sGBMTestDataFilepath = "";
	protected static String sTestCaseName = "PPF_ACCOUNT_TC4";
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
	@Test (description="Creates and validates the PPF - Account Oprning")
	public static void PPFAcountOpening() 
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
				Assert.fail("No data in testdata file to create transaction");
			
			// Navigate to HCCS from Finacle
			bStatus = ApplicationFunc.switchToHCCSPageAndChangeSolID(objTransactionDetails.get("SolID"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Navigate HCCS", "HCCS Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to HCCS from finacle", Messages.appErrorMsg);

			// Navigate to CBDT Transaction Maintenance page for adding a transaction
			bStatus = ApplicationFunc.navigateToPPFAccountOpen(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open 'create transaction' page", "Navigation failed. Error Message:" + Messages.errorMsg + Messages.appErrorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to create transaction page.","Transaction Maintenance page is opened to create new transaction.");
			String sPPFAccNo  = ApplicationFunc.PPFAccountOpen(objTransactionDetails.get("PPFBarCode"),objTransactionDetails.get("CustId"));
			if(sPPFAccNo == null)
			{
				Reporting.logResults("Fail", "Open PPF account", "PPF Account opening failed. Error Message:" + Messages.errorMsg + Messages.appErrorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Open PPF account", Messages.appErrorMsg);

			objTransactionDetails.put("ppfAccountNumber", sPPFAccNo);

			// Logout from Finacle as Maker
			bStatus = ApplicationFunc.logoutFromFinacle();
			if(!bStatus){
				Reporting.logResults("Fail", "Logout from  application", "Failed to logout");
				//Assert.fail("Log out from maker is failed");
			}
			Reporting.logResults("Pass", "Logout from  application", "Maker has successfully logged out from application");

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
			// Navigate to CBDT Transaction Maintenance page for adding a transaction
			bStatus = ApplicationFunc.navigateToPPFAccountOpen(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open 'create transaction' page", "Navigation failed. Error Message:" + Messages.errorMsg + Messages.appErrorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to create transaction page.","Transaction Maintenance page is opened to create new transaction.");
			// Verify the CBDT- Transfer transaction
			bStatus = ApplicationFunc.VerifyPPFAccountOpen(objTransactionDetails.get("BaseSolID"),objTransactionDetails.get("ppfAccountNumber"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to validate the transaction", "Transaction validation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Validate the Transaction Id",Messages.appErrorMsg);
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
		Browser.closeAllBrowsers(Global.wDriver);	
	}
}