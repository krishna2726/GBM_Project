package com.gbm.cbdttestsctipts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gbm.lib.ApplicationFunc;
import com.gbm.lib.Global;
import com.tenx.framework.lib.Browser;
import com.tenx.framework.lib.Messages;
import com.tenx.framework.reporting.Reporting;

public class GBM_TS5_CBDTEOD {
	public static boolean bStatus;
	public static String sSolid = "004";


	@Test
	public static void CBDTEODTransaction()
	{
		Reporting.Functionality = "CBDT";
		Reporting.Testcasename = "CBDT_EOD";
		//Login to Finacle as Maker
		bStatus = ApplicationFunc.loginToFinacleAsMaker();
		// Report fail
		if (!bStatus){
			Reporting.logResults("Fail", "Login to Finacle application with valid Maker credentials", "Unable to login. Error Message: " +Messages.appErrorMsg + Messages.errorMsg);
			Assert.fail("Unable to login. Error Message:" +Messages.appErrorMsg + Messages.errorMsg);
		}
		Reporting.logResults("Pass", "Login to Finacle application with valid maker credentials", "Sucessfully logged in to finacle application with maker credentials");

		bStatus = ApplicationFunc.switchToGBMApplicationWithSolID(sSolid);
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Failed to Navigate GBM", "GBM Navigation failed. Error Message:" + Messages.errorMsg);
			Assert.fail( Messages.errorMsg);	
		}

		Reporting.logResults("Pass", " Navigate GBM from finacle", Messages.appErrorMsg);

		bStatus = ApplicationFunc.getEODTransactionStatus();
		if(!bStatus)
		{
			Reporting.logResults("Fail", "Failed to get EOD Transaction status", " Get EOD Transaction status failed. Error Message:" + Messages.errorMsg  + Messages.appErrorMsg);
			Assert.fail( Messages.errorMsg + Messages.appErrorMsg);	
		}

		Reporting.logResults("Pass", " Get EOD transaction status", "The EOD Transaction status:"+ Messages.appErrorMsg);
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
