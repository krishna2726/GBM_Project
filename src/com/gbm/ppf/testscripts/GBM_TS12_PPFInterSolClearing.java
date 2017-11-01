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

public class GBM_TS12_PPFInterSolClearing {
	public static boolean bStatus;
	static String sGBMTempPath = Global.sGBMTempTestDataPath;
	static String sGBMTestDataFilepath = "";
	static Map<String, String> objTransactionDetails = null;
	static String sTestCaseName = "PPF_INTERSOL_CLEARING_TC12";
	public static String sSheetName = "PPF";
	@BeforeTest
	public static void  preRequisite() 
	{
		Reporting.Functionality = "PPF";
		sGBMTestDataFilepath = Global.sGBMTestDataPath+File.separator+Global.sTestDataFileName;
		boolean bFileExists;
		bFileExists = Verify.verifyFileExists(sGBMTestDataFilepath);
		if(!bFileExists){
			//Report Failure
			Assert.fail(Messages.errorMsg);
		}
	}
	@Test
	public static void PPFInterSolClearingTransaction() 
	{
		try
		{	
			//Login to Finacle AS Maker
			bStatus = ApplicationFunc.loginToFinacleAsMaker();
			Reporting.Testcasename = sTestCaseName;

			//report fail
			if (!bStatus){
				Reporting.logResults("Fail", "Login to Finacle application with valid maker credentials", "Unable to login. Error Message:" + Messages.errorMsg);
				Assert.fail("Unable to login. Error Message:" + Messages.errorMsg);
			}
			Reporting.logResults("Pass", "Login to Finacle application with valid maker credentials", "Sucessfully logged in to finacle application with maker credentials");

			objTransactionDetails = Utilities.readTestData(sGBMTestDataFilepath, sSheetName, sTestCaseName);
			if(objTransactionDetails.size() == 0)
				Assert.fail("No data in testdata file to create transaction");
			// Get 'unused' Instrument Code before creating the transaction
			String sInstrumentId = ApplicationFunc.getUnUsedInstrumentCode(objTransactionDetails.get("AccountNo"));
			if(sInstrumentId == null)
			{
				Reporting.logResults("Fail", "Get the Instrument id from application", "Instrument id is null. Error Message:" + Messages.errorMsg);
				Assert.fail("Instrument id is null. Error Message:" + Messages.errorMsg);
			}

			Reporting.logResults("Pass", "Get the Instrument id from application", "Unused Instrument id is:"+sInstrumentId);

			//put the id into object Map
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

			bStatus = ApplicationFunc.navigateToPPFTransaction(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintenanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open create transaction page", "Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}

			Reporting.logResults("Pass", " Navigate to create transaction page.","Transaction maintance page is opened to create new transaction.");

			String sTransactionId = ApplicationFunc.createPPFTransaction(objTransactionDetails);
			if(sTransactionId == null)
			{
				Reporting.logResults("Fail", "Failed to create a Transaction", "Transaction creation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", "Create transaction.","Transaction created successfully."+Messages.appErrorMsg);

			//Add the Transaction Id  to the map
			objTransactionDetails.put("TransactionId", sTransactionId);

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

			bStatus = ApplicationFunc.navigateToPPFTransaction(objTransactionDetails.get("ScenarioType"), objTransactionDetails.get("TransactionMaintanceType"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to open create transaction page", "Navigation failed. Error Message:" + Messages.errorMsg);
				Assert.fail( Messages.errorMsg);	
			}
			Reporting.logResults("Pass", " Navigate to create transaction page.","Transaction maintance page is opened to create new transaction.");

			bStatus = ApplicationFunc.VerifyPPFTransaction(objTransactionDetails.get("BarCode"),objTransactionDetails.get("TransactionId"));
			if(!bStatus)
			{
				Reporting.logResults("Fail", "Failed to validate the transaction", Messages.errorMsg + Messages.appErrorMsg);
				Assert.fail( Messages.errorMsg  + Messages.appErrorMsg);
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
		bStatus = ApplicationFunc.logoutFromFinacle();
		if(!bStatus)
			Reporting.logResults("Fail", "Logout from  application", "Failed to logout");
		Browser.closeAllBrowsers(Global.wDriver);	
	}
}
