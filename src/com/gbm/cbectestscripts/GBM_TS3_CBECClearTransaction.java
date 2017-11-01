package com.gbm.cbectestscripts;

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

public class GBM_TS3_CBECClearTransaction {
	public static boolean bStatus;
	protected static String sGBMTempPath = Global.sGBMTempTestDataPath;
	protected static String sGBMTestDataFilepath = "";
	protected static String sTestCaseName = "CBEC_CLEAR_TC3";
	protected static Map<String, String> objTransactionDetails = null;
	public static String sSheetName = "CBEC";

	@BeforeTest
	public static void  preRequisite() 
	{
		Reporting.Functionality = "CBEC";
		sGBMTestDataFilepath = Global.sGBMTestDataPath+File.separator+Global.sTestDataFileName;
		boolean bFileExists;

		// Verify if the testdata file exists in the specified path
		bFileExists = Verify.verifyFileExists(sGBMTestDataFilepath);
		if(!bFileExists){
			//Report Failure
			Assert.fail(Messages.errorMsg);
		}
	}
	@Test (description="Creates and validates the CBEC - Clearing transaction mode")
	public static void CBECClearingTransaction() 
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

			// Read test data and store it in map
			objTransactionDetails = Utilities.readTestData(sGBMTestDataFilepath, sSheetName, sTestCaseName);
			if(objTransactionDetails.size() == 0)
				Assert.fail("No data in testdata file to create transaction");

			// Get 'unused' Instrument Code before creating the transaction
			String sInstrumentId = ApplicationFunc.getUnUsedInstrumentCode(objTransactionDetails.get("AccountNo"));
			if(sInstrumentId == null)
			{
				Reporting.logResults("Fail", "Get the Instrument ID from application", "Instrument ID is null. Error Message:" + Messages.errorMsg);
				Assert.fail("Instrument ID is null. Error Message:" + Messages.errorMsg);
			}			
			Reporting.logResults("Pass", "Get the Instrument ID from application", "Unused Instrument ID is:"+sInstrumentId);

			// Store the unused Instrument id into object Map
			objTransactionDetails.put("InstrumentID", sInstrumentId);

			bStatus = ApplicationFunc.createZone(objTransactionDetails.get("SolID"),objTransactionDetails.get("ZoneCode"),objTransactionDetails.get("ZoneDate"));
			//report fail
			if (!bStatus){
				Reporting.logResults("Fail", "Create a Zone for Clear transaction ", "Failed to create zone. Error Message:" + Messages.errorMsg);
				Assert.fail("Failed to create zone.Error Message:" + Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Create a Zone for Clear transaction ", "Zone Code created:"+Messages.appErrorMsg);

			bStatus = ApplicationFunc.switchToGBMApplicationWithSolID(objTransactionDetails.get("SolID"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Navigate GBM", "GBM Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}

			Reporting.logResults("Pass", " Navigate GBM from finacle", Messages.appErrorMsg);

			bStatus = ApplicationFunc.navigateToTransactionMaintenance(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open create transaction page", "Navigation failed. Error Message:" + Messages.errorMsg+Messages.appErrorMsg);
				Assert.fail( Messages.errorMsg);	
			}

			Reporting.logResults("Pass", " Navigate to create transaction page.","Transaction maintance page is opened to create new transaction.");

			// Create CBEC Clearing transaction by entering data in all mandatory fields
			String sCBCETransactionId= ApplicationFunc.createCBECTransaction(objTransactionDetails);
			if(sCBCETransactionId == null)
			{
				Reporting.logResults("Fail", "Failed to create a Transaction", "Transaction creation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", "Create transaction.","CBEC Transaction created successfully."+Messages.appErrorMsg);

			//Add the Transaction Id  to the map
			objTransactionDetails.put("TransactionId", ApplicationFunc.sTransactionId);

			bStatus = ApplicationFunc.logoutFromFinacle();
			if(!bStatus){
				Reporting.logResults("Fail", "Logout from  application", "Failed to logout");
				//Assert.fail("Log out from maker is failed");
			}
			Reporting.logResults("Pass", "Logout from  application", "maker is successfully loggedout from application");

			//Login to Finacle AS Checker
			bStatus = ApplicationFunc.loginToFinacleAsChecker();
			//report fail
			if (!bStatus){
				Reporting.logResults("Fail", "Login to Finacle application with valid checker credentials", "Unable to login. Error Message:" + Messages.errorMsg);
				Assert.fail("Unable to login. Error Message:" + Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Login to Finacle application with valid checker credentials", "Sucessfully logged in to finacle application with checker credentials");

			bStatus = ApplicationFunc.switchToGBMApplicationWithSolID(objTransactionDetails.get("SolID"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to Navigate GBM", "GBM Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}

			Reporting.logResults("Pass", " Navigate GBM from finacle", Messages.appErrorMsg);

			bStatus = ApplicationFunc.navigateToTransactionMaintenance(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open create transaction page", "Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to create transaction page.","Transaction maintance page is opened to create new transaction.");

			bStatus = ApplicationFunc.verifyTransaction(objTransactionDetails.get("TransactionId"));
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

	@AfterMethod
	public static void closeBrowser()
	{
		bStatus = ApplicationFunc.logoutFromFinacle();
		if(!bStatus)
			Reporting.logResults("Fail", "Logout from  application", "Failed to logout");
		Browser.closeAllBrowsers(Global.wDriver);	
	}
}

