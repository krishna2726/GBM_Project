package com.gbm.lib;

import java.io.File;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;

import com.gbm.locators.Locators;
import com.tenx.framework.lib.Alerts;
import com.tenx.framework.lib.Browser;
import com.tenx.framework.lib.Elements;
import com.tenx.framework.lib.Messages;
import com.tenx.framework.lib.Wait;
import com.tenx.framework.lib.Webtable;

public class ApplicationFunc {

	public static boolean bStatus;
	public static Map<String, String> objTestDataMap;
	public static String sGBMDataXMLFilePath = "";
	public static String sTransactionId;

	//Login to GBM-Finacle
	public static boolean loginToFinacleAsMaker() {

		Global.wDriver = Browser.openBrowser(Global.sBrowserType,
				Global.sGBMURL, Global.sIEDriverPath);
		// Switch To login Frame
		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus){
			Messages.errorMsg = "Login page is not visible";
			return false;
		}
		// Enter Username
		bStatus = Elements.enterText(Global.wDriver,
				Locators.FinacleLoginPage.Textbox.userlogin,Global.sMakerUserName);
		if (!bStatus) 
			return false;

		// Enter Password
		bStatus = Elements.enterText(Global.wDriver,
				Locators.FinacleLoginPage.Textbox.password,
				Global.sMakerUserPassword);
		if (!bStatus) 
			return false;

		// Click Submit button
		bStatus = Elements.clickButton(Global.wDriver,
				Locators.FinacleLoginPage.Button.btnSubmit);
		if (!bStatus) 
			return false;

		//Redirect to default application alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(!bStatus){
			//Check for invalid user name /password message
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.FinacleLoginPage.Label.lblErrorMsg);
			Messages.errorMsg ="Invalid user details";
			return false;			
		}
		bStatus = Alerts.acceptAlert(Global.wDriver);
		if(!bStatus)
			return false;
		// Wait for CoreServer1 frame to load in the webpage
		bStatus = Wait.waitForElementVisibility(Global.wDriver, By.name("CoreServer1"), Constants.lFrameTimedout);
		if(!bStatus)
		{
			Messages.errorMsg = "Frame: CoreServer1 is not visible";
			return false;
		}
		// Switch focus to multiple frames
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		// Get the Login status 
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.FinacleBankingPage.Textbox.txtMenuName, Constants.lTimeOut);
		if(!bStatus){
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.FinacleLoginPage.Label.lblErrorMsg);
			Messages.errorMsg ="Invalid user details";
			return false;
		}		
		return true;
	}

	// Navigate to HCCS page to change the SolID
	public static boolean switchToHCCSPageAndChangeSolID(String sSolID)
	{
		bStatus = Elements.enterText(Global.wDriver, Locators.FinacleBankingPage.Textbox.txtMenuName, "HCCS");
		if(!bStatus)
		{
			Messages.errorMsg = "Menu select text field is not visible";
			return false;
		}	
		bStatus = Elements.clickButton(Global.wDriver, Locators.FinacleBankingPage.Button.btnGotoMenu);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.SolIDPage.Label.lblPageHeading, Constants.lPageLoadTimedOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Page is does not redirect in to change sol id page";
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.SolIDPage.Label.lblPageHeading) + "page is displayed";
		bStatus = changeSolID(sSolID);
		if(!bStatus)
			return false;
		return true;
	}

	// Navigate to GBM Application from Finacle Core Banking page by changing SolID
	public static boolean switchToGBMApplicationWithSolID(String sSolID)
	{
		// Get current Sol ID from the application header and compare it with expected
		String sCurrentId = Elements.getText(Global.wDriver, Locators.FinacleBankingPage.Label.lblHccsSolId);
		if(!sSolID.equalsIgnoreCase(sCurrentId))
		{
			bStatus = switchToHCCSPageAndChangeSolID(sSolID);
			if(!bStatus)
				return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.FinacleBankingPage.Textbox.txtMenuName,"GBM");
		if(!bStatus)
		{
			Messages.errorMsg = "Menu select text field is not visible";
			return false;
		}	
		bStatus = Elements.clickButton(Global.wDriver, Locators.FinacleBankingPage.Button.btnGotoMenu);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus){
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}
		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lFrameTimedout);
		if(!bStatus)
		{
			Messages.errorMsg = "GBM application page is not visible";
			return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Table.tblPageHeader, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "User not redirected to GBM page";
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.GBMPage.Table.tblPageHeader) + "page is displayed";
		return true;
	}

	// Change the Sol ID 
	public static boolean changeSolID(String sSolID)
	{
		bStatus = Elements.enterText(Global.wDriver, Locators.SolIDPage.Textbox.txtSolId, sSolID);
		if(!bStatus)
		{
			Messages.errorMsg = "New context SolID text box is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.FinacleLoginPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		//accept alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus){
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.FinacleLoginPage.Label.lblErrorMsg, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "SolID is not changing to "+sSolID;
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.FinacleLoginPage.Label.lblErrorMsg);

		bStatus = Elements.clickButton(Global.wDriver, Locators.SolIDPage.Button.btnBack);
		if(!bStatus)
			return false;
		bStatus =Wait.waitForElementVisibility(Global.wDriver, Locators.SolIDPage.Table.tblCurrentSolId, Constants.lTimeOut);
		if(bStatus)
		{
			String sChangedID = Elements.getText(Global.wDriver, Locators.SolIDPage.Table.tblCurrentSolId);
			sChangedID = sChangedID.trim();
			if(sSolID.equalsIgnoreCase(sChangedID))
				return true;
			else
			{
				Messages.errorMsg = "Sol ID was not changed to"+sSolID+"."+"Current SolID is"+sChangedID;
				return false;
			}
		}
		return true;
	}

	//Navigate to the transaction maintenance page
	public static boolean navigateToTransactionMaintenance(String sModuleName,String sTransactionMaintenance)
	{
		Messages.appErrorMsg = "";
		Messages.errorMsg = "";
		String sModule = Locators.GBMPage.Link.lnkModule.replace("replace", sModuleName);
		By objModuleName = By.xpath(sModule);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Module"+sModuleName+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Link.lnkTerminalTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Navigation failed.Error Msg:";
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Label.lblBODErrDesc, Constants.lTimeOut);
			if(bStatus)
				Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.GBMPage.Label.lblBODErrDesc);
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.GBMPage.Link.lnkTerminalTrans);
		if(!bStatus)
			return false;

		String sTransactionModuleName = Locators.GBMPage.Link.lnkModule.replace("replace", sTransactionMaintenance);
		By objTransactionModuleName = By.xpath(sTransactionModuleName);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objTransactionModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg =  "Navigation failed.Error Msg:";
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Label.lblBODErrDesc, Constants.lTimeOut);
			if(bStatus)
				Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.GBMPage.Label.lblBODErrDesc);
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTransactionModuleName);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Link.lnkTransaction, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance page is not visible";
			return false;
		}
		return true;
	}

	// Create a CBDT Transaction
	public static boolean createCBDTTransaction(Map<String, String> objTransData)
	{
		// Wait for Major Head link
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Link.lnkMajorHead, Constants.lTimeOut);
		if(!bStatus)
			return false;

		String sBaseWindow = Global.wDriver.getWindowHandle();

		// Click Major Head link
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkMajorHead);
		if(!bStatus)
			return false;

		// Wait for Major Head webpage dialog
		String sMajorWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sMajorWindow == null)
		{
			Messages.errorMsg = "Major Head Help Desk window is not opened.";
			return false;
		}

		// Switch focus to Major Head webpage dialog
		Global.wDriver.switchTo().window(sMajorWindow);

		// Select any transaction from Major Head webpage dialog
		By objMajorHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+objTransData.get("MajorHeaderType")+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objMajorHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Major header val:"+objTransData.get("MajorHeaderType")+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objMajorHeadVal);
		if(!bStatus)
			return false;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		// Minor head help desk window
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Link.lnkMinorHead, Constants.lWindowTimedOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Minor head help desk link is not visible";
			return false;
		}
		// Click Minor Head link
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkMinorHead);
		if(!bStatus)
			return false;

		// Wait for Minor Head webpage dialog
		String sMinorWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);
		if(sMinorWindow == null)
		{
			Messages.errorMsg = "Minor header help desk window ia  not opened.";
			return false;
		}

		// Switch focus to Minor Head webpage dialog
		Global.wDriver.switchTo().window(sMinorWindow);

		By objMinorHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+objTransData.get("MinorHeaderType")+"')]");
		bStatus = Wait.waitForElementVisibility(Global.wDriver, objMinorHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Minor header val:"+objTransData.get("MinorHeaderType")+" is not visible";
			return false;
		}

		bStatus = Elements.clickButton(Global.wDriver, objMinorHeadVal);
		if(!bStatus)
			return false;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		// Wait for PAN number link 
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtPanNo, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PAN No. help desk link is not visible";
			return false;
		}

		// Enter PAN number
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtPanNo, objTransData.get("PanNo"));
		if(!bStatus)
			return false;

		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkPanNo);
		if(!bStatus)
			return false;

		String sPanWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);
		if(sPanWindow == null)
		{
			Messages.errorMsg = "Minor Head help desk window is not opened.";
			return false;
		}
		// Switch the focus to PAN selection window
		Global.wDriver.switchTo().window(sPanWindow);
		By objPanHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"/b[contains(text(),'"+objTransData.get("PanNo")+"')]");
		bStatus = Wait.waitForElementVisibility(Global.wDriver, objPanHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PAN val:"+objTransData.get("PanNo")+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objPanHeadVal);
		if(!bStatus)
			return false;

		// Switch the focus back to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		// Wait for Assessment Year text field
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtAstYear, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Assessment Year text field is not visible";
			return false;
		}
		// Enter Assessment Year
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtAstYear, objTransData.get("AssessmentYear"));
		if(!bStatus)
			return false;

		//Enter Tax Amount 
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtIncomeTax, objTransData.get("TaxAmount"));
		if(!bStatus)
			return false;

		// Select Transaction Mode from dropdown
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransData.get("TransactionType"));
		if(!bStatus)
			return false;

		if(objTransData.get("TransactionType").equalsIgnoreCase("Transfer"))
		{
			bStatus = TransferTransaction(objTransData.get("AccountNo"),objTransData.get("InstrumentID"));
			if(!bStatus)
			{
				Messages.errorMsg = "Transfer details are not entered.";
				return false;
			}
		}
		if(objTransData.get("TransactionType").equalsIgnoreCase("Clearing"))
		{
			bStatus = clearTransaction(objTransData.get("ZoneCode"), objTransData.get("InstrumentID"),objTransData.get("TranCode"), objTransData.get("SortCode"));
			if(!bStatus)
			{
				Messages.errorMsg = "clearing details are not enterd.";
				return false;
			}
		}
		// Submit the transaction
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnSubmit);
		if(!bStatus)
			return false;

		// Wait for confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus){
			// Accept alert
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}

		// Wait for 2nd confirmation alert and accept it
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
			bStatus = Alerts.acceptAlert(Global.wDriver);
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction could not be created";
			return false;
		}
		// Capture message description and store the Transaction ID
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc);
		sTransactionId = getTransId(sMessageDesc);
		Messages.appErrorMsg = sMessageDesc;
		return true;
	}

	// Logout from application
	public static boolean logoutFromFinacle()
	{
		Global.wDriver.switchTo().defaultContent();
		// Switch focus to LoginFrame
		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.Logout.Button.btnLogout, Constants.lTimeOut);
		if(!bStatus)
			return false;
		// Click logout link
		bStatus = Elements.clickButton(Global.wDriver, Locators.Logout.Button.btnLogout);
		if(!bStatus)
			return false;
		// Click Ok on the confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus){
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}
		return true;
	}

	// Login to Finacle application as checker
	public static boolean loginToFinacleAsChecker(){

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.Logout.Button.btnCheckerLogin, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.Logout.Button.btnCheckerLogin);
		if(!bStatus)
		{
			Messages.errorMsg = "Login page is not visible";
			return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.FinacleLoginPage.Textbox.userlogin, Constants.lTimeOut);
		if(!bStatus)
			return false;
		// Enter username
		bStatus = Elements.enterText(Global.wDriver,
				Locators.FinacleLoginPage.Textbox.userlogin,Global.sCheckerUserName);
		if (!bStatus) 
			return false;

		// Enter password
		bStatus = Elements.enterText(Global.wDriver,
				Locators.FinacleLoginPage.Textbox.password,
				Global.sCheckerUserPassword);
		if (!bStatus) 
			return false;

		bStatus = Elements.clickButton(Global.wDriver,
				Locators.FinacleLoginPage.Button.btnSubmit);
		if (!bStatus) 
			return false;
		/*By objSelectApp = By.xpath(Locators.FinacleBankingPage.Dropdown.dwnSelectApp);
		bStatus = Wait.waitForElementVisibility(Global.wDriver, objSelectApp, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Finacle-core page is not present";
			return false;
		}
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.FinacleBankingPage.Dropdown.dwnSelectApp, "Finacle CORE1");
		if(!bStatus)
			return false;*/

		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(!bStatus){
			//Check for invalid user name /password message
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.FinacleLoginPage.Label.lblErrorMsg);
			Messages.errorMsg ="Invalid user details";
			return false;			
		}

		bStatus = Alerts.acceptAlert(Global.wDriver);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, By.name("CoreServer1"), Constants.lTimeOut);
		if(!bStatus)
			return false;

		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		//get the login status 
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.FinacleBankingPage.Textbox.txtMenuName, Constants.lTimeOut);
		if(!bStatus){
			Messages.errorMsg ="Welcome to Finacle Account screen/frame is not displayed";
			return false;
		}		
		return true;	
	}

	//Verify CBCE,CBDT and sales tax transaction
	public static boolean verifyTransaction(String sTransId)
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify Transaction page is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId, sTransId);
		if(!bStatus)
			return false;

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.Table.tblInquiryTable, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = " Transaction enquiry page is not visible";
			return false;
		}
		String sEnquiryTansId = Elements.getText(Global.wDriver, Locators.VerifyTransactionPage.Table.tblInquiryTable);
		if(!sTransId.equalsIgnoreCase(sEnquiryTansId))
		{
			Messages.errorMsg = "Verified Exp Transaction id is :" +sTransId+ "Act id is:"+ sEnquiryTansId;
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.Label.lblMessageDescription, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Error message  for transaction id: "+sTransId;
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.VerifyTransactionPage.Label.lblErrMessage);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.VerifyTransactionPage.Label.lblMessageDescription);
		return true;
	}

	//Reconcile the clear transaction
	public static boolean reconcileClearTransaction(String sReconcileLink,String sTransId)
	{
		Messages.appErrorMsg = "";
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Button.btnBack, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction is not submitted by checker successfully.";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnBack);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Button.btnHome, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Home page is not displayed.";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnHome);
		if(!bStatus)
			return false;

		//click on ReconcileClearTransaction  link
		String sTransactionModuleName = Locators.GBMPage.Link.lnkModule.replace("replace", sReconcileLink);
		By objTransactionModuleName = By.xpath(sTransactionModuleName);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objTransactionModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance"+ sReconcileLink +"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTransactionModuleName);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.ReconcilePage.Button.btnStart, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Reconcile clear transaction page is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.ReconcilePage.Button.btnStart);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.ReconcilePage.Table.TblReconcile, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Start reconcile is not clicked";
			return false;
		}
		String sClearDesc = Elements.getText(Global.wDriver, Locators.ReconcilePage.Table.TblReconcile);
		if(sClearDesc.contains("No Instrument cleared for CBDT today."))
		{
			Messages.appErrorMsg = sClearDesc;
			return false;
		}
		Messages.appErrorMsg = sClearDesc;
		return true;

	}

	//Get unused Instrument code from application
	public static String getUnUsedInstrumentCode(String sAccNo)
	{
		bStatus = Elements.enterText(Global.wDriver, Locators.FinacleBankingPage.Textbox.txtMenuName,"HCHBM");
		if(!bStatus)
		{
			Messages.errorMsg = "Menu select text field is not visible";
			return null;
		} 
		bStatus = Elements.clickButton(Global.wDriver, Locators.FinacleBankingPage.Button.btnGotoMenu);
		if(!bStatus)
			return null;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HCHBMPage.Textbox.txtAccId, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Account number text field is not visible";
			return null;
		}
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.HCHBMPage.Dropdown.dwnFunction, "I - Inquiry");
		if(!bStatus)
			return null;

		bStatus = Elements.enterText(Global.wDriver, Locators.HCHBMPage.Textbox.txtAccId, sAccNo);
		if(!bStatus)
			return null;
		bStatus = Elements.clickButton(Global.wDriver, Locators.HCHBMPage.Button.btnAccept);
		if(!bStatus)
			return null;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HCHBMPage.Table.tblUnusedInstrCodeList, Constants.lWindowTimedOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Account details Table is not visible for unused instrument code";
			return null;
		}

		int iRowCnt = Webtable.getRowCount(Global.wDriver ,Locators.HCHBMPage.Table.tblUnusedInstrCodeList);
		int iCnt;
		for (iCnt = 2; iCnt <= iRowCnt; iCnt++) {
			String sCode = Elements.getText(Global.wDriver, By.xpath("//table[@class='innertable']//table[2]//tr["+iCnt+"]/td[6]"));
			if(!sCode.equalsIgnoreCase("0"))
			{
				bStatus = Elements.clickButton(Global.wDriver, By.xpath("//table[@class='innertable']//table[2]//tr["+iCnt+"]/td[13]/a"));
				if(!bStatus)
					return null;
				break;
			}
		}
		if(iCnt>iRowCnt)
		{
			Messages.errorMsg = "there is no unused instrument code for the account no." +sAccNo ;
			return null;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HCHBMPage.Table.tblChqNo, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg  = "Cheque details are not visible";
			return null;
		}
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.HCHBMPage.Dropdown.dwnChqStatus, "Unused");
		if(!bStatus)
			return null;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HCHBMPage.Table.tblChqDetails, Constants.lTimeOut);
		if(!bStatus)
			return null;
		String sUnusedId = Elements.getText(Global.wDriver, Locators.HCHBMPage.Table.tblChqDetails);
		if(sUnusedId == null)
		{
			Messages.errorMsg = "Unused transaction id is not retrived from application";
			return null;
		}
		return sUnusedId;
	}

	//Create CBDT Transfer Transaction
	public static boolean TransferTransaction(String sAccno,String sInstrNo)
	{
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtAccNo, sAccno);
		if(!bStatus)
			return false;
		String sBaseWindow = Global.wDriver.getWindowHandle();

		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkAccNo);
		if(!bStatus)
			return false;

		String sAccHelpWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);
		if(sAccHelpWindow == null)
		{
			Messages.errorMsg = "Account number help desk window is  not opened.";
			return false;
		}
		Global.wDriver.switchTo().window(sAccHelpWindow);

		By objAccNoDtls = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sAccno+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objAccNoDtls, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Account number:"+sAccno+" details are not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objAccNoDtls);
		if(!bStatus)
			return false;

		//switch to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		//select instrument Type
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkInstrumentType);
		if(!bStatus)
			return false;

		String sInstTypeHelpWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);
		if(sInstTypeHelpWindow == null)
		{
			Messages.errorMsg = "Instrument type help desk window ia  not opened.";
			return false;
		}

		Global.wDriver.switchTo().window(sInstTypeHelpWindow);

		By objInstrType  = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'CHQ')]");
		bStatus = Wait.waitForElementVisibility(Global.wDriver, objInstrType, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Instrument Type 'CHQ' is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objInstrType);
		if(!bStatus)
			return false;

		//switch to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtInstNum, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtInstNum, sInstrNo);
		if(!bStatus)
			return false;
		return true;
	}

	//Create Zone code for Clearing Transaction
	public static boolean createZone(String sSolID,String sZoneCode,String sZoneDate)
	{
		Messages.errorMsg = "";
		Messages.appErrorMsg = "";
		String sCurrentId = Elements.getText(Global.wDriver, Locators.FinacleBankingPage.Label.lblHccsSolId);
		if(!sSolID.equalsIgnoreCase(sCurrentId))
		{
			switchToHCCSPageAndChangeSolID(sSolID);
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.FinacleBankingPage.Textbox.txtMenuName, "HMCLZOH");
		if(!bStatus)
		{
			Messages.errorMsg = "Menu select text field is not visible";
			return false;
		}	
		bStatus = Elements.clickButton(Global.wDriver, Locators.FinacleBankingPage.Button.btnGotoMenu);
		if(!bStatus)
			return false;

		//accept alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HMCLZOHPage.Textbox.txtZoneDate, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.HMCLZOHPage.Dropdown.dwnFunCode, "O-Open Zone");
		if(!bStatus)
			return false;
		bStatus = Elements.enterText(Global.wDriver, Locators.HMCLZOHPage.Textbox.txtZoneDate, sZoneDate);
		if(!bStatus)
			return false;
		bStatus = Elements.enterText(Global.wDriver, Locators.HMCLZOHPage.Textbox.txtZoneCode, sZoneCode);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.HCHBMPage.Button.btnAccept);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.FinacleLoginPage.Button.btnSubmit, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Zone creation failed.Error Msg:";
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HMCLZOHPage.Table.tblErrRecord, Constants.lTimeOut);
			if(bStatus){
				Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.HMCLZOHPage.Table.tblErrRecord);
				return false;
			}
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.FinacleLoginPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.HMCLZOHPage.Label.lblClearingZone, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "No zone is created for clearing transaction";
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.HMCLZOHPage.Label.lblClearingZone);
		return true;
	}

	//Create a CBDT Clear Transaction
	public static boolean clearTransaction(String sZoneCode,String sInstrumentID,String sTranID,String sSortCode)
	{
		//Enter Instrument num
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtInstNum, sInstrumentID);
		if(!bStatus)
			return false;

		String sBaseWindow = Global.wDriver.getWindowHandle();
		//Enter Zone code
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkZoneCode);
		if(!bStatus)
			return false;

		String sZoneCodeHelpWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);
		if(sZoneCodeHelpWindow == null)
		{
			Messages.errorMsg = "Zone Code help desk window ia  not opened.";
			return false;
		}
		Global.wDriver.switchTo().window(sZoneCodeHelpWindow);

		By objZoneCode = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sZoneCode+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objZoneCode, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Zone code:"+sZoneCode+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objZoneCode);
		if(!bStatus)
			return false;
		//switch to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		//select Tran ID
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Link.lnkTranId);
		if(!bStatus)
			return false;

		String sTranIDHelpWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);
		if(sTranIDHelpWindow == null)
		{
			Messages.errorMsg = "Tran ID help desk window ia  not opened.";
			return false;
		}
		Global.wDriver.switchTo().window(sTranIDHelpWindow);

		By objTranID = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sTranID+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objTranID, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Trand ID:"+sTranID+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTranID);
		if(!bStatus)
			return false;
		//switch to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtSortCode, sSortCode);
		if(!bStatus)
			return false;
		return true;
	}

	//Create CBCE Transaction
	public static String createCBECTransaction(Map<String, String> objTransData)
	{
		// Wait for Tax Head link
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.CBECTransaction.Link.lnkTaxHead, Constants.lTimeOut);
		if(!bStatus)
			return null;

		String sBaseWindow = Global.wDriver.getWindowHandle();

		// Click Tax Head link
		bStatus = Elements.clickButton(Global.wDriver, Locators.CBECTransaction.Link.lnkTaxHead);
		if(!bStatus)
			return null;

		// Wait for Tax Head webpage dialog
		String sTaxHeadWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sTaxHeadWindow == null)
		{
			Messages.errorMsg = "Tax Head Help Desk window is not opened.";
			return null;
		}

		// Switch focus to Major Head webpage dialog
		Global.wDriver.switchTo().window(sTaxHeadWindow);

		// Select any transaction from Major Head webpage dialog
		By objTaxHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+objTransData.get("TaxHeadType")+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objTaxHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Tax Head val:"+objTransData.get("TaxHeadType")+" is not visible";
			return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTaxHeadVal);
		if(!bStatus)
			return null;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return null;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return null;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.CBECTransaction.Textbox.txtAssessCode, Constants.lTimeOut);
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.CBECTransaction.Textbox.txtAssessCode, objTransData.get("AssesseeCode "));
		if(!bStatus)
			return null;

		// Click Assess Code link
		bStatus = Elements.clickButton(Global.wDriver, Locators.CBECTransaction.Link.lnlAssesscode);
		if(!bStatus)
			return null;

		// Wait for Tax Head webpage dialog
		String sAssessCodeWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sAssessCodeWindow == null)
		{
			Messages.errorMsg = "AssessCode Help Desk window is not opened.";
			return null;
		}

		// Switch focus to Major Head webpage dialog
		Global.wDriver.switchTo().window(sAssessCodeWindow);

		// Select any transaction from Major Head webpage dialog
		By objAssessCode = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+objTransData.get("AssesseeCode")+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objAssessCode, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "AssessCode:"+objTransData.get("AssesseeCode")+" is not visible";
			return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, objAssessCode);
		if(!bStatus)
			return null;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return null;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return null;

		//Enter Tax Amount 
		bStatus = Elements.enterText(Global.wDriver, Locators.CBECTransaction.Textbox.txtAmount, objTransData.get("TaxAmount"));
		if(!bStatus)
			return null;

		// Select Transaction Mode from dropdown
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransData.get("TransactionType"));
		if(!bStatus)
			return null;

		if(objTransData.get("TransactionType").equalsIgnoreCase("Transfer"))
		{
			bStatus = TransferTransaction(objTransData.get("AccountNo"),objTransData.get("InstrumentID"));
			if(!bStatus)
			{
				Messages.errorMsg = "Transfer details are not entered.";
				return null;
			}
		}
		if(objTransData.get("TransactionType").equalsIgnoreCase("Clearing"))
		{
			bStatus = clearTransaction(objTransData.get("ZoneCode"), objTransData.get("InstrumentID"),objTransData.get("TranCode"), objTransData.get("SortCode"));
			if(!bStatus)
			{
				Messages.errorMsg = "clearing details are not enterd.";
				return null;
			}
		}

		// Submit the transaction
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnSubmit);
		if(!bStatus)
			return null;

		// Wait for confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		// Wait for 2nd confirmation alert and accept it
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction could not be created";
			return null;
		}
		// Capture message description and store the Transaction ID
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc);
		String sCBECTransactionId = getTransId(sMessageDesc);
		Messages.appErrorMsg = sMessageDesc;
		return sCBECTransactionId;
	}

	//Create Sales Transaction
	public static String createSalesTaxTransaction(Map<String, String> objTransData)
	{
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.SalesTaxTransaction.Textbox.txtTinNo, Constants.lTimeOut);
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.SalesTaxTransaction.Textbox.txtTinNo, objTransData.get("TinNo"));
		if(!bStatus)
			return null;
		// Select Transaction Mode from drop down
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransData.get("TransactionType"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.SalesTaxTransaction.Textbox.txtFromDate, objTransData.get("FromDate"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.SalesTaxTransaction.Textbox.txtToDate, objTransData.get("ToDate"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.SalesTaxTransaction.Textbox.txtAmount, objTransData.get("TotalAmount"));
		if(!bStatus)
			return null;

		if(objTransData.get("TransactionType").equalsIgnoreCase("Transfer"))
		{
			bStatus = TransferTransaction(objTransData.get("AccountNo"),objTransData.get("InstrumentID"));
			if(!bStatus)
			{
				Messages.errorMsg = "Transfer details are not entered.";
				return null;
			}
		}
		if(objTransData.get("TransactionType").equalsIgnoreCase("Clearing"))
		{
			bStatus = clearTransaction(objTransData.get("ZoneCode"), objTransData.get("InstrumentID"),objTransData.get("TranCode"), objTransData.get("SortCode"));
			if(!bStatus)
			{
				Messages.errorMsg = "clearing details are not enterd.";
				return null;
			}
		}

		// Submit the transaction
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnSubmit);
		if(!bStatus)
			return null;
		// Wait for confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		// Wait for 2nd confirmation alert and accept it
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction could not be created";
			return null;
		}
		// Capture message description and store the Transaction ID
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc);
		String sSalesTaxTransactionId = getTransId(sMessageDesc);
		Messages.appErrorMsg = sSalesTaxTransactionId;
		return sSalesTaxTransactionId;
	}

	//Admin - EOD
	public static boolean getEODTransactionStatus()
	{
		Messages.appErrorMsg = "";
		Messages.errorMsg = "";
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.GBMPage.Link.lnkAdmin, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Admin link is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.GBMPage.Link.lnkAdmin);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Link.lnkMCP, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "TB-MCP link is not visible in Admin";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.GBMPage.Link.lnkMCP);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.GBMPage.Link.lnkAllModules, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "All Modules link is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.GBMPage.Link.lnkAllModules);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Button.btnStartEOD, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Start EOD link is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.GBMPage.Button.btnStartEOD);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Label.lblErrorDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg ="EOD failed. Error Message:";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.GBMPage.Label.lblErrorDesc);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.GBMPage.Label.lblErrorDesc);
		return true;
	}

	//StateTax
	//Navigate to State tax Create transaction page
	public static boolean navigateToStateTax(String sModuleName,String sTransactionMaintenance)
	{
		Messages.appErrorMsg = "";
		Messages.errorMsg = "";

		String sModule = Locators.GBMPage.Link.lnkModule.replace("replace", sModuleName);
		By objModuleName = By.xpath(sModule);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Module"+sModuleName+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Link.lnkStateTax, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "State link is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.StateTaxTransaction.Link.lnkStateTax);
		if(!bStatus)
			return false;
		String sTransactionModuleName = Locators.GBMPage.Link.lnkModule.replace("replace", sTransactionMaintenance);
		By objTransactionModuleName = By.xpath(sTransactionModuleName);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objTransactionModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance"+ sTransactionMaintenance +"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTransactionModuleName);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Link.lnkMajorHead, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "Create Transaction page in state tax is not in Add mode";
				return false;
			}
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
			return false;
		}
		return true;
	}

	//Add transaction for create transaction
	public static boolean addTransactionDetails(String sMajorHead,String sMinorHead,String sTinNo,String sReturnType)
	{
		Messages.appErrorMsg = "";
		Messages.errorMsg = "";
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Link.lnkMajorHead, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintance page for state tax is not visible";
			return false;
		}
		String sBaseWindow = Global.wDriver.getWindowHandle();

		bStatus = Elements.clickButton(Global.wDriver, Locators.StateTaxTransaction.Link.lnkMajorHead);
		if(!bStatus)
			return false;

		// Wait for Major Head web page dialog
		String sMajorWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sMajorWindow == null)
		{
			Messages.errorMsg = "Major Head Help Desk window is not opened.";
			return false;
		}

		// Switch focus to Major Head web page dialog
		Global.wDriver.switchTo().window(sMajorWindow);

		// Select any transaction from Major Head web page dialog
		By objMajorHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sMajorHead+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objMajorHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Major header val:"+sMajorHead+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objMajorHeadVal);
		if(!bStatus)
			return false;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		// Minor head help desk window
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Link.lnkMinorHead, Constants.lWindowTimedOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Minor head help desk link is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.StateTaxTransaction.Link.lnkMinorHead);
		if(!bStatus)
			return false;

		// Wait for Minor Head web page dialog
		String sMinorWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sMinorWindow == null)
		{
			Messages.errorMsg = "Minor Head Help Desk window is not opened.";
			return false;
		}
		// Switch focus to Minor Head web page dialog
		Global.wDriver.switchTo().window(sMinorWindow);

		// Select any transaction from Minor Head web page dialog
		By objMinorHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sMinorHead+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objMinorHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Minor header val:"+sMinorHead+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objMinorHeadVal);
		if(!bStatus)
			return false;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		//Enter Return Type code for Ap State
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Link.lnkReturnType, Constants.lTimeOut);
		if(bStatus)
		{
			bStatus = Elements.clickButton(Global.wDriver, Locators.StateTaxTransaction.Link.lnkReturnType);
			if(!bStatus)
				return false;
			// Wait for Minor Head web page dialog
			String sReturnTypeWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

			if(sReturnTypeWindow == null)
			{
				Messages.errorMsg = "Return type code Help Desk window is not opened.";
				return false;
			}
			// Switch focus to Minor Head web page dialog
			Global.wDriver.switchTo().window(sReturnTypeWindow);

			// Select any transaction from Minor Head web page dialog
			By objReturnTypeVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sReturnType+"')]");

			bStatus = Wait.waitForElementVisibility(Global.wDriver, objReturnTypeVal, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "Return Type val:"+sReturnType+" is not visible";
				return false;
			}
			bStatus = Elements.clickButton(Global.wDriver, objReturnTypeVal);
			if(!bStatus)
				return false;

			// Switch back the focus to parent window and frames
			Global.wDriver.switchTo().window(sBaseWindow);

			Global.wDriver.switchTo().defaultContent();

			bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
			if(!bStatus)
				return false;
			Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

			bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
			if(!bStatus)
				return false;
		}
		// Enter Tin/Registration number
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtTinNo, Constants.lWindowTimedOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Tin/Registration number textbox is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtTinNo, sTinNo);
		if(!bStatus)
			return false;

		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Table.tblVerifyTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc, Constants.lTimeOut);
			if(bStatus)
			{
				Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
				return false;
			}
			Messages.errorMsg = "Transaction Maintance _Add page is not visible";
			return false;
		}
		return true;
	}

	//create State tax transaction
	public static String createStateTaxTransaction(Map<String, String>objTransData)
	{
		bStatus = addTransactionDetails(objTransData.get("MajorHeaderType"),objTransData.get("MinorHeaderType"),objTransData.get("TINNo"),objTransData.get("ReturnTypeCode"));
		if(!bStatus)
			return null;
		String sBaseWindow = Global.wDriver.getWindowHandle();

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtRefNo, Constants.lTimeOut);
		if(bStatus)
		{
			bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtRefNo, objTransData.get("Referenceno"));
			if(!bStatus)
				return null;
		}
		//Enter district code
		bStatus = Elements.clickButton(Global.wDriver, Locators.StateTaxTransaction.Link.lnkDistCode);
		if(!bStatus)
			return null;

		// Wait for Major Head web page dialog
		String sDistCodeWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sDistCodeWindow == null)
		{
			Messages.errorMsg = "District code Head Help Desk window is not opened.";
			return null;
		}
		// Switch focus to Major Head web page dialog
		Global.wDriver.switchTo().window(sDistCodeWindow);

		// Select any transaction from Major Head web page dialog
		By objDistCodeVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+objTransData.get("DistrictCode")+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objDistCodeVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "District code value:"+objTransData.get("DistrictCode")+" is not visible";
			return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, objDistCodeVal);
		if(!bStatus)
			return null;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return null;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return null;

		//Enter Sub treasury code
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Link.lnkSubTreasury, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Sub Treasury text field is not visible";
			return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.StateTaxTransaction.Link.lnkSubTreasury);
		if(!bStatus)
			return null;

		// Wait for Major Head web page dialog
		String sSubTreasuryWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sSubTreasuryWindow == null)
		{
			Messages.errorMsg = "Sub treasury Head Help Desk window is not opened.";
			return null;
		}
		// Switch focus to Major Head web page dialog
		Global.wDriver.switchTo().window(sSubTreasuryWindow);

		// Select any transaction from Major Head web page dialog
		By objSubTreasurVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+objTransData.get("SubTreasury")+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objSubTreasurVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Sub Treasury value:"+objTransData.get("SubTreasury")+" is not visible";
			return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, objSubTreasurVal);
		if(!bStatus)
			return null;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return null;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return null;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtTaxPeriodFrom, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Tax period from date text field is not visible";
			return null;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtTaxPeriodFrom, objTransData.get("FromDate"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtTaxPeriodTo, objTransData.get("ToDate"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtVoluntryTax, objTransData.get("VoluntaryTax"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtAdditionalDemand, objTransData.get("AdditionalDemand"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtPenality, objTransData.get("Penality"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtInterest, objTransData.get("Interest"));
		if(!bStatus)
			return null;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtOtherDeposits, Constants.lTimeOut);
		if(bStatus){
			bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtOtherDeposits, objTransData.get("OtherDeposits"));
			if(!bStatus)
				return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnSubmit);
		if(!bStatus)
			return null;
		// Wait for confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		// Wait for 2nd confirmation alert and accept it
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Tranaction Id is not created - ";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
			return null;
		}
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblMessageDesc);

		Messages.appErrorMsg = sMessageDesc;
		String sTransactionId = getTransId(sMessageDesc);
		return sTransactionId;
	}

	//create transaction for AP and Telengana states
	public static String createAPStateTransaction(Map<String, String> objTransData){
		bStatus = addTransactionDetails(objTransData.get("MajorHeaderType"),objTransData.get("MinorHeaderType"),objTransData.get("TINNo"),objTransData.get("ReturnTypeCode"));
		if(!bStatus)
			return null;

		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtChallanNo, objTransData.get("ChallanNumber"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.StateTaxTransaction.Textbox.txtVoluntryTax, objTransData.get("VoluntaryTax"));
		if(!bStatus)
			return null;
		bStatus = Elements.clickButton(Global.wDriver, Locators.TransactionMaintenance.Button.btnSubmit);
		if(!bStatus)
			return null;
		// Wait for confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		// Wait for 2nd confirmation alert and accept it
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
			return null;
		}
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblMessageDesc);
		Messages.appErrorMsg = sMessageDesc;
		String sTransactionId = getTransId(sMessageDesc);
		return sTransactionId;
	}

	//Verify state tax transaction
	public static boolean VerifyStateTaxTransaction(String sTransId)
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify transaction page is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId, sTransId);
		if(!bStatus)
			return false;

		String sBaseWindow = Global.wDriver.getWindowHandle();

		// Click Major Head link
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkTranId);
		if(!bStatus)
			return false;

		// Wait for Major Head webpage dialog
		String sMajorWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sMajorWindow == null)
		{
			Messages.errorMsg = "Major Head Help Desk window is not opened.";
			return false;
		}

		// Switch focus to Major Head webpage dialog
		Global.wDriver.switchTo().window(sMajorWindow);

		// Select any transaction from Major Head webpage dialog
		By objMajorHeadVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sTransId+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objMajorHeadVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction id:"+sTransId+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objMajorHeadVal);
		if(!bStatus)
			return false;

		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Table.tblVerifyTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "State Tax verify Transaction page is not visible";
			return false;
		}
		String sEnquiryTansId = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Table.tblVerifyTrans);
		if(!sTransId.equalsIgnoreCase(sEnquiryTansId))
		{
			Messages.errorMsg = "Verified Exp Transaction id is :" +sTransId+ "Act id is:"+ sEnquiryTansId;
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.Label.lblMessageDescription, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Error message for transaction id: "+sTransId;
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.VerifyTransactionPage.Label.lblMessageDescription);
		return true;
	}

	//Get test cases list
	public static String[][] getTestcaseList(String sFilePath)
	{
		String[][] sTestCaseList = null;

		try {
			Workbook objWorkbook = Workbook.getWorkbook(new File(sFilePath));
			Sheet objSheet = objWorkbook.getSheet("TestCaseList");
			int iRowCount = objSheet.getRows();
			int iColCount = objSheet.getColumns();
			System.out.println(iRowCount +iColCount );
			sTestCaseList = new String[iRowCount-1][iColCount];
			for (int iRowCounter = 1; iRowCounter < iRowCount; iRowCounter++) {
				for (int iColCounter = 0; iColCounter < iColCount; iColCounter++) {
					sTestCaseList[iRowCounter-1][iColCounter] = objSheet.getCell(iColCounter, iRowCounter).getContents();
					System.out.println("TCName "+sTestCaseList[iRowCounter-1][iColCounter]);
				}
			}
		}
		catch(Exception e)
		{
			Messages.errorMsg = e.getMessage();
			e.printStackTrace();
		}

		return sTestCaseList;
	}

	//For PPF
	public static boolean navigateToPPFTransaction(String sModuleName,String sTransactionMaintenance) 
	{
		String sModule = Locators.GBMPage.Link.lnkModule.replace("replace", sModuleName);
		By objModuleName = By.xpath(sModule);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Module"+sModuleName+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;

		String sTransactionModuleName = Locators.GBMPage.Link.lnkModule.replace("replace", sTransactionMaintenance);
		By objTransactionModuleName = By.xpath(sTransactionModuleName);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objTransactionModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance"+ sTransactionMaintenance +"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTransactionModuleName);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblCreateTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "Create Transaction page in PPF is not in Add mode";
				return false;
			}
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
			return false;
		}
		return true;
	}

	//create PPF Transaction
	public static String createPPFTransaction(Map<String, String> objTransData)
	{
		Messages.appErrorMsg = "";
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFTransaction.Textbox.txtBarcode, objTransData.get("BarCode"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFTransaction.Textbox.txtCustName, objTransData.get("CustName"));
		if(!bStatus)
			return null;
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFTransaction.Textbox.txtAmount, objTransData.get("TotalAmount"));
		if(!bStatus)
			return null;
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransData.get("TransactionType"));
		if(!bStatus)
			return null;
		if(objTransData.get("TransactionType").equalsIgnoreCase("Transfer"))
		{
			bStatus = TransferTransaction(objTransData.get("AccountNo"), objTransData.get("InstrumentID"));
			if(!bStatus)
				return null;
			bStatus = Elements.enterText(Global.wDriver, Locators.PPFTransaction.Textbox.txtValDate, "21/04/2014");
			if(!bStatus)
				return null;
		}
		if(objTransData.get("TransactionType").equalsIgnoreCase("Clearing"))
		{
			bStatus = clearTransaction(objTransData.get("ZoneCode"), objTransData.get("InstrumentID"), objTransData.get("TranCode"), objTransData.get("SortCode"));
			if(!bStatus)
				return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return null;
		// Wait for confirmation alert
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			// Accept alert
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		// Wait for 2nd confirmation alert and accept it
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus){
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return null;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Label.lblMsgDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Failed to create transaction.Error msg:";
			Messages.appErrorMsg = Elements.getText(Global.wDriver,Locators.PPFTransaction.Label.lblErrMsgDesc);
			return null;
		}
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.PPFTransaction.Label.lblMsgDesc);
		Messages.appErrorMsg = sMessageDesc;
		sTransactionId = getTransId(sMessageDesc);
		return sTransactionId;
	}

	//verify PPF transaction
	public static boolean VerifyPPFTransaction(String sBarCode,String STransId)
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Textbox.txtBarcode, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify transaction page is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFTransaction.Textbox.txtBarcode, sBarCode);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Vertify transaction Page  is not visible";
			return false;
		}
		String sActTranId  = Elements.getText(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans);
		if(!STransId.equalsIgnoreCase(sActTranId.trim()))
		{
			Messages.errorMsg = "Failed toValidate TransID. Act Trans Id: "+sActTranId + " and the exp Trans Id:"+STransId;
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Label.lblMsgDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Failed to submit Transaction. Error msg: ";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFTransaction.Label.lblErrMsgDesc);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFTransaction.Label.lblMsgDesc);
		return true;
	}

	//For NPS Transaction

	//Navigate to the transaction maintenance page(CBDT)
	public static boolean navigateToNPSTransactionMaintenance(String sModuleName,String sTransaction,String sTransactionMaintenance)
	{
		String sModule = Locators.GBMPage.Link.lnkModule.replace("replace", sModuleName);
		By objModuleName = By.xpath(sModule);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Module"+sModuleName+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;

		String sPopupOperation = Locators.GBMPage.Link.lnkModule.replace("replace", sTransaction);
		By objPopupOperation = By.xpath(sPopupOperation);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objPopupOperation, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Popup Operation"+sTransaction+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;

		String sTransactionModuleName = Locators.GBMPage.Link.lnkModule.replace("replace", sTransactionMaintenance);
		By objTransactionModuleName = By.xpath(sTransactionModuleName);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objTransactionModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance"+sTransactionMaintenance+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.GBMPage.Link.lnkTransaction, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance page is not visible";
			return false;
		}
		return true;
	}

	//Create a NPS transaction
	public static boolean createServiceRequestHandlingTransaction(String sServiceType,String sPranNo,String sTiretype)
	{	
		// Select ServiceRequestType from dropdown
		bStatus = Wait.waitForElementVisibility(Global.wDriver,By.xpath(Locators.NPSTransaction.Dropdown.dwnServiceType), Constants.lTimeOut);
		if(!bStatus)
			return false;

		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.NPSTransaction.Dropdown.dwnServiceType, sServiceType);
		if(!bStatus)
			return false;
		//Enter PRANNo
		bStatus = Elements.enterText(Global.wDriver, Locators.NPSTransaction.TextBox.txtPranNo, sPranNo);
		if(!bStatus)
			return false;

		// Select Tier Type from dropdown
		bStatus = Wait.waitForElementVisibility(Global.wDriver,By.xpath(Locators.NPSTransaction.Dropdown.dwnTierType), Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.NPSTransaction.Dropdown.dwnTierType, sTiretype);
		if(!bStatus)
			return false;
		// Submit the transaction
		bStatus = Elements.clickButton(Global.wDriver, Locators.NPSTransaction.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.NPSTransaction.TextBox.txtRemarks, Constants.lTimeOut);
		if(!bStatus)
		{ 
			Messages.errorMsg = "Service Request Handling Transaction Contribution page is not opened";
			return false;
		}
		return true;
	}
	public static String createNPSServiceReqestHandlingTransactionContribution(Map<String, String> objTransData)
	{
		Messages.appErrorMsg = "";
		Messages.errorMsg = "";
		bStatus = createServiceRequestHandlingTransaction(objTransData.get("ServiceRequestType"),objTransData.get("PRANNo"),objTransData.get("TierType"));
		if(!bStatus)
			return null;
		//Enter Remarks
		bStatus = Elements.enterText(Global.wDriver, Locators.NPSTransaction.TextBox.txtRemarks,objTransData.get("Remarks"));
		if(!bStatus)
			return null;
		//Enters Amount
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.NPSTransaction.TextBox.txtAmnount, Constants.lTimeOut);
		if(!bStatus)
		{ 
			return null;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.NPSTransaction.TextBox.txtAmnount, objTransData.get("Amount"));
		if(!bStatus)
			return null;

		// Select Transaction Mode from dropdown
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransData.get("TransactionType"));
		if(!bStatus)
			return null;

		if(objTransData.get("TransactionType").equalsIgnoreCase("Transfer"))
		{
			bStatus = TransferTransaction(objTransData.get("AccountNo"),objTransData.get("InstrumentNo"));
			if(!bStatus)
			{
				Messages.errorMsg = "NPS Transfer details are not entered.";
				return null;
			}
		}
		if(objTransData.get("TransactionType").equalsIgnoreCase("Clearing"))
		{
			bStatus = clearTransaction(objTransData.get("ZoneCode"),objTransData.get("InstrumentNumber"),objTransData.get("TranCode"), objTransData.get("SortCode"));
			if(!bStatus)
			{
				Messages.errorMsg = "clearing details are not enterd.";
				return null;
			}
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus){	
			return null;
		}
		// Capture message description and store the Transaction ID
		String sMessageDesc = Elements.getText(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc);
		String sTransId = getTransId(sMessageDesc);
		Messages.appErrorMsg = sMessageDesc;
		return sTransId;
	}

	public static boolean VerifyNPSTransaction(String sTransId,String sServiceRtype)
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;
		// Select ServiceRequestType from dropdown

		bStatus = Wait.waitForElementVisibility(Global.wDriver, By.xpath(Locators.NPSTransaction.Dropdown.dwnServiceType), Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify transaction page is not visible";
			return false;
		}
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.NPSTransaction.Dropdown.dwnServiceType, sServiceRtype);
		if(!bStatus)
			return false;

		bStatus = Elements.enterText(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId, sTransId);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Vertify transaction Page  is not visible";
			return false;
		}
		String sActTranId  = Elements.getText(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans);
		if(!sTransId.equalsIgnoreCase(sActTranId.trim()))
		{
			Messages.errorMsg = "Failed toValidate TransID. Act Trans Id: "+sActTranId + " and the exp Trans Id:"+sTransId;
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.NPSTransaction.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "failed to submit the transaction.Error Msg:";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.VerifyTransactionPage.Label.lblErrMessage);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.NPSTransaction.Label.lblMessageDesc);
		return true;
	}

	public static boolean createPRANNoTransaction(Map<String, String> objTransData) 
	{
		//Enter PRAN No
		bStatus = Elements.enterText(Global.wDriver, Locators.PRANMASTERWalkin.TextBox.txtPranNo, objTransData.get("PRANNUMBER"));
		if(!bStatus)
			return false;
		// Select Government Employee(YES/NO) from dropdown
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.PRANMASTERWalkin.Dropdown.dwnGovEmpl, objTransData.get("GovernmentEmployee"));
		if(!bStatus)
			return false;
		// Select Title from dropdown
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.PRANMASTERWalkin.Dropdown.dwnTitle, objTransData.get("Title"));
		if(!bStatus)
			return false;
		//Enter Subscriber First Name
		bStatus = Elements.enterText(Global.wDriver, Locators.PRANMASTERWalkin.TextBox.SubcriberFirstName, objTransData.get("SubscriberFirstName"));
		if(!bStatus)
			return false;
		//Enter Father's First Name
		bStatus = Elements.enterText(Global.wDriver, Locators.PRANMASTERWalkin.TextBox.FatherFirstName, objTransData.get("Father'sFirstName"));
		if(!bStatus)
			return false;
		//Enter Date Of Birth (DD/MM/YYYY)
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.PRANMASTERWalkin.TextBox.DateOfBirth, Constants.lTimeOut);
		if(!bStatus)
			return false;

		bStatus = Elements.enterText(Global.wDriver, Locators.PRANMASTERWalkin.TextBox.DateOfBirth, objTransData.get("DOB"));
		if(!bStatus)
			return false;
		//Enter Phone Number
		bStatus = Elements.enterText(Global.wDriver, Locators.PRANMASTERWalkin.TextBox.MobileNumber,objTransData.get("MobileNo"));
		if(!bStatus)
			return false;

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.NPSTransaction.Label.lblPRANMessageDesc,  Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = Elements.getText(Global.wDriver, Locators.NPSTransaction.Label.lblVerifyPRANMessageDesc); 
			return false;
		}
		// Capture message description and store the Transaction ID
		Messages.errorMsg = Elements.getText(Global.wDriver, Locators.NPSTransaction.Label.lblPRANMessageDesc);
		return true;
	}

	public static boolean VerifyNPS_PRANNo(String sPRANNo )
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.NPSTransaction.TextBox.txtPranNo, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PRANNo is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.NPSTransaction.TextBox.txtPranNo, sPRANNo);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Vertify transaction Page  is not visible";
			return false;
		}
		String sActPranNo  = Elements.getText(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans);
		if(!sPRANNo.equalsIgnoreCase(sActPranNo.trim()))
		{
			Messages.errorMsg = "Failed toValidate TransID. Act Trans Id: "+sActPranNo + " and the exp Trans Id:"+sPRANNo;
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.NPSTransaction.Label.lblPRANMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.VerifyTransactionPage.Label.lblErrMessage);
			return false;
		}

		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.NPSTransaction.Label.lblPRANMessageDesc);

		return true;
	}

	public static String getTransId(String sMsgdesc)
	{
		String sTrans[] = sMsgdesc.split("-");
		String[] sTransId = sTrans[1].split("\\s");
		String sTransactionId = sTransId[1].trim();
		System.out.println(sTransactionId);
		return sTransactionId;

	}

	//Crate a PPF DepositCashTransaction
	public static boolean createDepositTransaction(Map<String, String> objTransData)
	{
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.PPFDeposit.TextBox.txtPPFAccnum, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PPF Account number is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtPPFAccnum, objTransData.get("PPFAccountNo"));
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.VerifyTransactionPage.Button.btnSubmit, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Submit button is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;		

		bStatus = Wait.waitForElementVisibility(Global.wDriver,By.xpath(Locators.TransactionMaintenance.Dropdown.dwnTransMode), Constants.lTimeOut);
		if(!bStatus){
			Messages.errorMsg = "ERROR CODE:"+Elements.getText(Global.wDriver, Locators.PPFDeposit.Label.lblErrorCode)+" and "+"Error Description:"+Elements.getText(Global.wDriver, Locators.PPFDeposit.Label.lblErrorDesc);
			return false;
		}
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransData.get("TransactionType"));
		if(!bStatus)
			return false;

		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtTotalDepositAmount, objTransData.get("TaxAmount"));
		if(!bStatus)
			return false;

		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtSubscriptionAmount, objTransData.get("TaxAmount"));
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Submit button is not displayed";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
		{
			Messages.errorMsg = "Submit button is not clickable";
			return false;
		}

		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus){
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.TransactionMaintenance.Label.lblMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction is not created";
			return false;
		}
		String sMessageDesc = Elements.getText(Global.wDriver,  Locators.TransactionMaintenance.Label.lblMessageDesc);
		Messages.appErrorMsg = sMessageDesc;
		sTransactionId = getTransId(sMessageDesc);
		return true;
	}

	public static boolean verifyPPFTransactionMaintenance(String sTranId)
	{

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.VerifyTransactionPage.TextBox.txtTransId, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Tran ID link is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId, sTranId);
		if(!bStatus)
			return false;

		// Get base window handle
		String sBaseWindow = Global.wDriver.getWindowHandle();

		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFDeposit.Link.lnkGBMTranID);
		if(!bStatus)
			return false;

		String sBarCodeWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sBarCodeWindow == null)
		{
			Messages.errorMsg = "GBM Tran ID window is not opened.";
			return false;
		}

		// Switch focus to GBM Tran IDwebpage dialog
		Global.wDriver.switchTo().window(sBarCodeWindow);

		// Select any transaction from Major Head webpage dialog
		By PPFAccVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sTranId+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, PPFAccVal, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Bar code val:"+sTranId+" is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, PPFAccVal);
		if(!bStatus)
			return false;
		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);
		Global.wDriver.switchTo().defaultContent();
		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFDeposit.Button.btnNext, Constants.lTimeOut);
		if(!bStatus)
			return false;
		// Click Next button
		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFDeposit.Button.btnNext);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit, Constants.lTimeOut);
		if(!bStatus)
			return false; 

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
			bStatus = Alerts.acceptAlert(Global.wDriver);

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblPPFVerifyMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction could not be created";
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblPPFVerifyMessageDesc);

		return true;
	}

	//Add inter sol ppf receipts maintenance 
	public static boolean addPPFReceipts(String ppfAcNumber,String solId)
	{
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFReports.TextBox.txtSolID, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Create deposit cash page is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtSolID, solId);
		if(!bStatus)
			return false;
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtPPFAccnum,ppfAcNumber);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForAlert(Global.wDriver, Constants.lAlertTimeout);
		if(bStatus)
		{
			bStatus = Alerts.acceptAlert(Global.wDriver);
			if(!bStatus)
				return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblCreateTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PPF receipts maintance page is not visible to add transaction details";
			return false;
		}
		return true;
	}

	//Create to Deposit Cash
	public static String CreatePPFDepositCashTransaction(Map<String,String> objTransDetails)
	{
		bStatus = addPPFReceipts(objTransDetails.get("AccountNo"), objTransDetails.get("BaseSolID"));
		if(!bStatus)
			return null;
		bStatus = Elements.selectOptionByVisibleText(Global.wDriver, Locators.TransactionMaintenance.Dropdown.dwnTransMode, objTransDetails.get("TransactionType"));
		if(!bStatus)
			return null;

		if(objTransDetails.get("TransactionType").equalsIgnoreCase("Transfer"))
		{
			bStatus = TransferTransaction(objTransDetails.get("AccountNo"),objTransDetails.get("InstrumentID"));
			if(!bStatus)
			{
				Messages.errorMsg = "Transfer details are not entered.";
				return null;
			}
		}
		if(objTransDetails.get("TransactionType").equalsIgnoreCase("Clearing"))
		{
			bStatus = clearTransaction(objTransDetails.get("ZoneCode"), objTransDetails.get("InstrumentID"),objTransDetails.get("TranCode"), objTransDetails.get("SortCode"));
			if(!bStatus)
			{
				Messages.errorMsg = "clearing details are not enterd.";
				return null;
			}
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.CBECTransaction.Textbox.txtAmount,objTransDetails.get("TotalAmount"));
		if(!bStatus)
			return null;

		bStatus = Elements.enterText(Global.wDriver, Locators.TransactionMaintenance.TextBox.txtAccNo, objTransDetails.get("OperativeAccountNo"));
		if(!bStatus)	
			return null;

		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtSubscriptionAmount, objTransDetails.get("TotalAmount"));
		if(!bStatus)
			return null;
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return null;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Label.lblMsgDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Label.lblErrMsgDesc, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "InterSol deposit transaction is not created";
				return null;
			}
			Messages.errorMsg = "InterSol deposit transaction is not created.Error is:";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFTransaction.Label.lblErrMsgDesc);
			return null;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFTransaction.Label.lblMsgDesc);
		String sTransId = getTransId(Messages.appErrorMsg);
		return sTransId;
	}

	//verify intersol deposit transaction
	public static boolean verifyInterSolDepositTransaction(String sSolId,String sTranId)
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify transaction page is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtSolID, sSolId);
		if(!bStatus)
			return false;

		bStatus = Elements.enterText(Global.wDriver, Locators.VerifyTransactionPage.TextBox.txtTransId,sTranId);
		if(!bStatus)
			return false;
		String sBaseWindow = Global.wDriver.getWindowHandle();

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Link.lnkTranId);
		if(!bStatus)
			return false;

		String sTranIdWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sTranIdWindow == null)
		{
			Messages.errorMsg = "PPF intersol deposit TranId Help Desk window is not opened.";
			return false;
		}
		// Switch focus to Head webpage dialog
		Global.wDriver.switchTo().window(sTranIdWindow);

		By objTransIdVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sTranId+"')]");
		bStatus = Wait.waitForElementVisibility(Global.wDriver, objTransIdVal, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, objTransIdVal);
		if(!bStatus)
			return false;
		// Switch the focus back to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.FinacleLoginPage.Frame.sLoginFrameName, Constants.lTimeOut);
		if(!bStatus)
			return false;
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW")));

		bStatus = Wait.waitForFrameAndSwithToFrame(Global.wDriver, Locators.GBMPage.Frame.sGBMFrmeName, Constants.lTimeOut);

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify InbterSol Deposit Transaction table is not visible";
			return false;
		}
		String sActTranId  = Elements.getText(Global.wDriver, Locators.PPFTransaction.Table.tblVerifyTrans);
		if(!sTranId.equalsIgnoreCase(sActTranId.trim()))
		{
			Messages.errorMsg = "Failed toValidate TransID. Act Trans Id: "+sActTranId + " and the exp Trans Id:"+sTranId;
			return false;
		}
		bStatus =Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblPPFVerifyMessageDesc, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblErrMessage, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "Transaction is not submitted.";
				return false;
			}
			Messages.errorMsg = "Transaction is not submitted.Error msg:";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblErrMessage);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblPPFVerifyMessageDesc);
		return true;
	}

	//PPF account open

	public static boolean navigateToPPFAccountOpen(String sModuleName,String sTransactionMaintenance) 
	{
		String sModule = Locators.GBMPage.Link.lnkModule.replace("replace", sModuleName);
		By objModuleName = By.xpath(sModule);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Module"+sModuleName+"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objModuleName);
		if(!bStatus)
			return false;

		String sTransactionModuleName = Locators.GBMPage.Link.lnkModule.replace("replace", sTransactionMaintenance);
		By objTransactionModuleName = By.xpath(sTransactionModuleName);

		bStatus = Wait.waitForElementVisibility(Global.wDriver,objTransactionModuleName, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Transaction maintenance"+ sTransactionMaintenance +"is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, objTransactionModuleName);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFTransaction.Table.tblAccountOpen, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "PPF Account opening page is not in Add mode";
				return false;
			}
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.StateTaxTransaction.Label.lblErrorDesc);
			return false;
		}
		return true;
	}
	public static String PPFAccountOpen(String sBarCode,String sCustId)
	{

		bStatus = Elements.enterText(Global.wDriver, Locators.PPFTransaction.Textbox.txtBarcode,sBarCode);
		if(!bStatus)
			return null;

		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtCustId,sCustId);
		if(!bStatus)
			return null;

		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFDeposit.Button.btnFetchBtn);

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Submit Button is not visible";
			return null;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return null;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblAccMesage,Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PPF Success Message is not displayed";
			return null;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblAccMesage); 
		String AcNumber[] = Messages.appErrorMsg.split(": ");
		String ppfAccountNumber = AcNumber[1].trim();
		return ppfAccountNumber;
	}

	public static boolean VerifyPPFAccountOpen(String sBaseSolId,String sPPFAccountNumber)
	{
		bStatus = Elements.clickButton(Global.wDriver,Locators.VerifyTransactionPage.Link.lnkVerify);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver , Locators.PPFReports.TextBox.txtSolID, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "PPF account opening verify transaction page is not visible";
			return false;
		}
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtSolID,sBaseSolId);
		if(!bStatus)
			return false;

		bStatus = Elements.enterText(Global.wDriver, Locators.PPFDeposit.TextBox.txtPPFAccnum,sPPFAccountNumber);
		if(!bStatus)
			return false;

		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;
		//navigate to Account Opening -Verify
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Table.tblAccOpen, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Verify InbterSol Deposit Transaction table is not visible";
			return false;
		}
		String sActAccNo  = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Table.tblAccOpen);
		if(!sPPFAccountNumber.equalsIgnoreCase(sActAccNo.trim()))
		{
			Messages.errorMsg = "Failed toValidate TransID. Act Trans Id: "+sActAccNo + " and the exp Trans Id:"+sPPFAccountNumber;
			return false;
		}
		bStatus =Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblAccMesage, Constants.lTimeOut);
		if(!bStatus)
		{
			bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblErrMessage, Constants.lTimeOut);
			if(!bStatus)
			{
				Messages.errorMsg = "PPF Account open is not submitted.";
				return false;
			}
			Messages.errorMsg = "PPF Account open is not submitted.Error msg:";
			Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblErrMessage);
			return false;
		}
		Messages.appErrorMsg = Elements.getText(Global.wDriver, Locators.PPFVerifyTransaction.Label.lblAccMesage);
		return true;
	}

	//PPF Reports

	//navigate To PPF Account Open Report-Range Date wise
	public static boolean getDatewiseReport()
	{	
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.VerifyTransactionPage.Button.btnSubmit,Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver,Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.PPFReports.Button.back, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Date wise report is not fetched.";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFReports.Button.back);
		if(!bStatus)
			return false;

		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.PPFReports.Button.home, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Home button is not visible";
			return false;
		}
		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFReports.Button.home);
		if(!bStatus)
			return false;
		bStatus = Wait.waitForElementVisibility(Global.wDriver, Locators.PPFReports.Link.lnkStatementofAccounts, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "StatementofAccounts link is not visible in PPF Reports ";
			return false;
		}
		return true;
	}

	//navigate To PPF Statement of Accounts
	public static boolean getStatementsReports(String sSolID,String sPPFAccNo,String sFromDate,String sToDate)
	{
		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFReports.Link.lnkStatementofAccounts);
		if(!bStatus)
		{
			Messages.errorMsg = "StatementofAccounts page is not visible";
			return false;
		}
		//Enter SolID
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.PPFReports.TextBox.txtSolID, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtSolID, sSolID);

		//Enter PPF Account No
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtPPFAccNo, sPPFAccNo);

		if(!bStatus)
			return false;
		String sBaseWindow = Global.wDriver.getWindowHandle();

		bStatus = Elements.clickButton(Global.wDriver, Locators.PPFReports.Link.txtPPFAccNoTorch);
		if(!bStatus)
			return false;

		String sPPFAccNoHelpWindow = Wait.waitForWindow(Global.wDriver, Constants.lWindowTimedOut);

		if(sPPFAccNoHelpWindow == null)
		{
			Messages.errorMsg = "PPF AccNo HelpWindow Inquiry Table Help Desk window is not opened.";
			return false;
		}
		Global.wDriver.switchTo().window(sPPFAccNoHelpWindow);
		// Select any transaction from HelpWindow web page dialog 
		By objPPFAccNoVal = By.xpath(Locators.TransactionMaintenance.Link.lnkHelpIndex+"[contains(text(),'"+sPPFAccNo+"')]");

		bStatus = Wait.waitForElementVisibility(Global.wDriver, objPPFAccNoVal, Constants.lTimeOut);
		if(!bStatus)
			return false;
		bStatus = Elements.clickButton(Global.wDriver, objPPFAccNoVal);
		if(!bStatus)
			return false;
		// Switch back the focus to parent window and frames
		Global.wDriver.switchTo().window(sBaseWindow);

		Global.wDriver.switchTo().defaultContent();

		// Switch focus to multiple frames
		Global.wDriver.switchTo().frame(Global.wDriver.findElement(By.name("loginFrame"))).switchTo().frame(Global.wDriver.findElement(By.name("CoreServer1"))).switchTo().frame(Global.wDriver.findElement(By.id("FINW"))).switchTo().frame(Global.wDriver.findElement(By.name("GBM")));

		//Enter FromDate
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtFromDate, sFromDate);

		//Enter ToDate
		bStatus = Elements.enterText(Global.wDriver, Locators.PPFReports.TextBox.txtToDate, sToDate);

		//Click On Submit
		bStatus = Elements.clickButton(Global.wDriver, Locators.VerifyTransactionPage.Button.btnSubmit);
		if(!bStatus){
			return false;
		}
		bStatus = Wait.waitForElementVisibility(Global.wDriver,Locators.PPFReports.Button.back, Constants.lTimeOut);
		if(!bStatus)
		{
			Messages.errorMsg = "Statements of accounts report is not fetched.";
			return false;
		}
		return true;
	}

}
