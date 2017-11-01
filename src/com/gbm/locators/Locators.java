package com.gbm.locators;

import org.openqa.selenium.By;

public class Locators {

	public static class FinacleLoginPage
	{
		public static class Frame
		{
			public static By sLoginFrameName = By.name("loginFrame");
			public static By sFinacleFrme = By.id("FINW");
		}
		public static class Textbox
		{
			public static By userlogin = By.id("userid");
			public  static By password = By.id("password");				
		}
		public static class Button
		{
			public static By btnSubmit = By.name("form-group login-footer");
		}

		public static class Image 
		{
			public static By imgLoginSuccess = By.xpath("//p/img");
		}
		public static class Label
		{
			public static By lblErrorMsg = By.xpath("//table[@class='resultpage']");
		}
	}

	public static class FinacleBankingPage
	{
		public static class Textbox
		{
			public static  By txtMenuName = By.name("menuName");
		}
		public static class Button
		{
			public static  By btnGotoMenu = By.name("gotomenu");
		}
		public static class Label
		{
			public static By lblHccsSolId = By.xpath("//td[@class='titletxt']/table//td[5]");
		}
		public static class Dropdown
		{
			public static String dwnSelectApp = "//select[@name='appSelect']";
		}
	}

	public static class SolIDPage
	{
		public static class Textbox
		{
			public static By txtSolId = By.id("targetSolId");
		}
		public static class Label
		{
			public static By lblPageHeading = By.xpath("//td[@class='page-heading']");
		}
		public static class Button
		{
			public static By btnBack = By.id("Back");
		}
		public static class Table
		{
			public static By tblCurrentSolId = By.xpath("//table[@class='innertabletop1']//tr[3]/td[5]");
		}
	}

	public static class GBMPage
	{
		public static class Frame{
			public static By sGBMFrmeName = By.name("GBM");
		}
		public static class Table
		{
			public static By tblPageHeader = By.xpath("//table//tr/td[3]//b");
		}
		public static class Link
		{
			public static String lnkModule ="//a[contains(.,'replace')]";
			public static By lnkTerminalTrans = By.xpath("//a[contains(.,'Terminal')]");
			public static By lnkTransaction = By.xpath("//font[contains(.,'Transaction')]");
			public static By lnkAdmin = By.xpath("//a[contains(.,'Admin')]");
			public static By lnkMCP= By.xpath("//a[contains(.,'TB-MCP')]");
			public static By lnkAllModules = By.xpath("//a[contains(.,'All Modules')]");
		}
		public static class Label
		{
			public static By lblErrorDesc = By.xpath("//font[contains(text(),'All Users')]");
			public static By lblBODErrDesc = By.xpath("//font[contains(text(),'BOD')]");
		}
		public static class Button
		{
			public static By btnStartEOD = By.xpath("//input[@value='Start EOD']");	
		}
	}

	public static class TransactionMaintenance
	{

		public static class TextBox
		{
			public static By txtPanNo =  By.xpath("//input[@name='txtPan']");
			public static By txtIncomeTax = By.xpath("//input[@name='txtIncomeTax']");
			public static By txtAstYear = By.xpath("//input[@name='txtAst']");
			public static By txtAccNo = By.xpath("//input[@name='txtAccountNum']");
			public static By txtInstNum = By.xpath("//input[@name='txtInstNum']");
			public static By txtSortCode = By.xpath("//input[@name='txtSortCode']");
			public static By txtInstDate = By.xpath("//input[@name='txtInstDate']");
		}
		public static class Link
		{
			public static By lnkMajorHead =  By.xpath("//input[@name='majorHead']/../a");
			public static By lnkMinorHead =  By.xpath("//input[@name='minorHead']/../a");
			public static By lnkPanNo =  By.xpath("//input[@name='txtPan']/../a");
			public static By lnkAccNo =  By.xpath("//input[@name='txtAccountNum']/../a");
			public static By lnkInstrumentType =  By.xpath("//input[@name='txtInstType']/../a");
			public static By lnkZoneCode = By.xpath("//input[@name='selZoneCode']/../a");
			public static By lnkTranId = By.xpath("//input[@name='txtTranCode']/../a");
			public static String lnkHelpIndex = "//a";
		}

		public static class Dropdown
		{
			public static String dwnTransMode = "//select[@name='selTranMode']";
		}
		public static class Button
		{
			public static By btnSubmit = By.xpath("//input[@name='btnSubmit']");
			public static By btnBack  = By.xpath("//a[contains(.,'Back')]");
			public static By btnHome  = By.xpath("//a[contains(.,'Home')]");
		}

		public static class Label
		{
			public static By lblMessageDesc = By.xpath("//font[contains(text(),'Transaction Created Successfully')]");
		}
	}

	public static class Logout
	{
		public static class Button
		{
			public static By btnLogout = By.xpath("//a[@class='topnavi']/img[@alt='Log out']");
			public static By btnCheckerLogin = By.name("Submit2");
		}
	}

	public static class VerifyTransactionPage
	{
		public static class TextBox
		{
			public static By txtTransId = By.xpath("//input[@name='txtGBMTranId']");
		}
		public static class Button
		{
			public static By btnSubmit = By.xpath("//input[@value='Submit']");
		}
		public static class Table
		{
			public static By tblInquiryTable = By.xpath("//form[@name='frm_tm_verify']/table//table//tr[3]//td[2]");
		}
		public static class Link
		{
			public static By lnkVerify = By.xpath("//a[contains(.,'Verify')]");
			public static By lnkTranId = By.xpath("//input[@name='txtGBMTranId']/../a");
		}
		public static class Label
		{
			public static By lblMessageDescription = By.xpath("//font[contains(text(),'The Challan Number')]");
			public static By lblErrMessage = By.xpath("//font[contains(text(),'Transaction')]");
		}
	}

	public static class ReconcilePage
	{
		public static class Button
		{
			public static By btnStart = By.xpath("//input[@name='butSubmit']");
		}
		public static class Table
		{
			public static By TblReconcile = By.xpath("//table[@name='qHostName']");
		}
	}

	//For Transfer
	public static class HCHBMPage
	{
		public static class Dropdown
		{
			public static String dwnFunction = "//select[@id='funcCode']";
			public static String dwnChqStatus = "//select[@id='inqChqStatus']";
		}
		public static class Textbox
		{
			public static By txtAccId = By.xpath("//input[@id='acctId']");
		}
		public static class Button
		{
			public static By btnAccept = By.xpath("//input[@id='Accept']");
		}
		public static class Link
		{
			public static By lnkViewDetails = By.xpath("//a[contains(@id,'anc_exp')]/img");
		}
		public static class Table
		{
			public static By tblChqNo = By.xpath("//tr[@class='searclist1a']/td");
			public static By tblChqDetails = By.xpath("//table[@class='innertabletop1']/following-sibling::table//tr[2]/td[1]");
			public static By tblUnusedInstrCodeList = By.xpath("//table[@class='innertable']//table[2]");
		}
	}

	public static class HMCLZOHPage
	{
		public static class Textbox
		{
			public static By txtZoneDate = By.id("zoneDate_ui");
			public static By txtZoneCode = By.id("zoneCode");
		}
		public static class Dropdown
		{
			public static String dwnFunCode = "//select[@name='mclz.funcCode']";
		}
		public static class Label
		{
			public static By lblClearingZone = By.xpath("//label[@id='compField']");
		}
		public static class Table
		{
			public static By tblZoneCodeList = By.xpath("////table[@class='innertable']//table[2]");
			public static By tblErrRecord = By.xpath("//tr[@class='alert']");
		}
	}

	//For CBCE
	public static class CBECTransaction
	{
		public static class Textbox
		{
			public static By txtAssessCode = By.xpath("//input[@name='txtAssesseeCode']");
			public static By txtAmount = By.xpath("//input[@name='txtAmount']");
		}
		public static class Link
		{
			public static By lnkTaxHead = By.xpath("//input[@name='txtTaxHead']/../a");
			public static By lnlAssesscode = By.xpath("//input[@name='txtAssesseeCode']/../a");
		}
	}

	//For SalesTax
	public static class SalesTaxTransaction
	{
		public static class Textbox
		{
			public static By txtName = By.xpath("//input[@name='txtName']");
			public static By txtTinNo = By.xpath("//input[@name='txtPANNo']");
			public static By txtFromDate = By.xpath("//input[@name='txtFromPeriod']");
			public static By txtToDate = By.xpath("//input[@name='txtToPeriod']");
			public static By txtAmount = By.xpath("//input[@name='txtAmount']");
			public static By txtAccNo = By.xpath("//input[@name='txtAccountNum']");
			public static By txtInstDate = By.xpath("//input[@name='txtInstDate']");
		}
	}

	public static class StateTaxTransaction
	{
		public static class Textbox
		{
			public static By txtTinNo = By.xpath("//input[@name='txtTINNo']");
			public static By txtTaxPeriodFrom = By.xpath("//input[@name='txtTaxPeriodFrom']");
			public static By txtTaxPeriodTo = By.xpath("//input[@name='txtTaxPeriodTo']");
			public static By txtVoluntryTax = By.xpath("//input[@name='txtComponentValue0']");
			public static By txtAdditionalDemand = By.xpath("//input[@name='txtComponentValue1']");
			public static By txtPenality = By.xpath("//input[@name='txtComponentValue2']");
			public static By txtInterest = By.xpath("//input[@name='txtComponentValue3']");
			public static By txtOtherDeposits = By.xpath("//input[@name='txtComponentValue4']");
			public static By txtRefNo = By.xpath("//input[@name='txtReferenceNumber']");
			public static By txtChallanNo = By.xpath("//input[@name='txtChallanNumber']");
		}
		public static class Link
		{
			public static By lnkStateTax = By.xpath("//tr[@class='RowColor']//a");
			public static By lnkMajorHead =  By.xpath("//input[@name='txtMajorHeadCode']/../a");
			public static By lnkMinorHead =  By.xpath("//input[@name='txtMinorHeadCode']/../a");
			public static By lnkReturnType = By.xpath("//input[@name = 'txtReturntype']/../a");
			public static By lnkDistCode =  By.xpath("//input[@name='txtDistrictCode']/../a");
			public static By lnkSubTreasury = By.xpath("//input[@name='txtSubTreasuryCode']/../a");

		}
		public static class Label
		{
			public static By lblMessageDesc = By.xpath("//font[contains(text(),'Transaction Details Inserted Successfully.')]");
			public static By lblErrorDesc = By.xpath("//tr[@class='RowColor']/td[2]");
		}

		public static class Table
		{
			public static By tblVerifyTrans = By.xpath("//form[@name='gbm_transaction_add1']/table//table//table//tr[4]/td[2]");
		}
	}
	//For NPS Transaction
	public static class NPSTransaction
	{

		public static class TextBox
		{
			public static By txtPranNo =  By.xpath("//input[@name='txtPranNum']");
			public static By txtAmnount =  By.xpath("//input[@name='txtTotal']");
			public static By txtRemarks =  By.xpath("//input[@name='txtRemarks']");
		}
		public static class Link
		{
			public static By lnkPRANNoTorch =  By.xpath("//input[@name='txtPranNum']/../a");
			public static By lnkInstrumentType =  By.xpath("//input[@name='selInstType']/../a");
		}

		public static class Dropdown
		{	
			public static String dwnServiceType = "//select[@name='selService']";
			public static String dwnTierType = "//select[@name='selTierType']";
		}
		public static class Button
		{
			public static By btnSubmit = By.xpath("//input[@class='formbutton']");

		}
		public static class Label
		{
			public static By lblMessageDesc = By.xpath("//font[contains(text(),'The Receipt Number is')]");
			public static By lblPRANMessageDesc = By.xpath("//font[contains(text(),'PRAN Number')]");
			public static By lblVerifyPRANMessageDesc = By.xpath("//font[contains(text(),'Addition Failed')]");

		}
	}
	public static class PRANMASTERWalkin
	{
		public static class TextBox
		{
			public static By txtPranNo =  By.xpath("//input[@name='txtPRANNumber']");
			public static By SubcriberFirstName =  By.xpath("//input[@name='txtSubFirstName']");		
			public static By FatherFirstName =  By.xpath("//input[@name='txtFFirstName']");		
			public static By DateOfBirth =  By.xpath("//input[@name='txtDOB']");	
			public static By MobileNumber =  By.xpath("//input[@name='txtMobileNumber']");	
		}
		public static class Dropdown
		{	
			public static String dwnGovEmpl = "//select[@name='selGovEmp']";
			public static String dwnTitle = "//select[@name='selTitle']";
		}
	}

	//For PPF
	public static class PPFTransaction
	{
		public static class Textbox
		{
			public static By txtBarcode = By.xpath("//input[@name='txtBarCode']");
			public static By txtCustName = By.xpath("//input[@name='txtCustName']");
			public static By txtAmount = By.xpath("//input[@name='txtPPFInitAmount']");
			public static By txtValDate = By.xpath("//input[@name='txtValueDate']");
		}
		public static class Label
		{
			public static By lblErrMsgDesc = By.xpath("//font[contains(text(),'Account')]");
			public static By lblMsgDesc = By.xpath("//font[contains(text,'Registration Master')]");
		}
		public static class Table
		{
			public static By tblVerifyTrans = By.xpath("//td[contains(text(),'Tran ID')]/following-sibling::td");
			public static By tblCreateTrans = By.xpath("//font[contains(text(),'PPF')]");
			public static By tblAccountOpen = By.xpath("//font[contains(text(),'Account Opening')]");
		}
	}
	public static class PPFReports
	{
		public static class TextBox
		{
			public static By txtSolID =  By.xpath("//input[@name='selSolId']");
			public static By txtPPFAccNo =  By.xpath("//input[@name='txtPPFAcctNum']");		
			public static By txtFromDate =  By.xpath("//input[@name='txtFromDate']");		
			public static By txtToDate =  By.xpath("//input[@name='txtDOB']");	
		}
		public static class Link
		{
			public static By lnkSolIDTorch =  By.xpath("//input[@name='selSolId']/../a");
			public static By txtPPFAccNoTorch =  By.xpath("//input[@name='txtPPFAcctNum']/../a");
			public static By lnkStatementofAccounts  = By.xpath("//a[contains(.,'Statement of Accounts')]");
		}
		public static class Dropdown
		{	
			public static String dwnGovEmpl = "//select[@name='selGovEmp']";
			public static String dwnTitle = "//select[@name='selTitle']";
		}
		public static class Button
		{
			//public static By btnSubmit = By.xpath("//input[@value='Submit']");
			public static By btnStart = By.xpath("//input[@name='butSubmit']");
			public static By back = By.xpath("//font[contains(text(),'Back')]");
			public static By home = By.xpath("//b[contains(text(),'Home')]");

		}

	}

	public static class PPFDeposit
	{
		public static class TextBox
		{
			public static By txtPPFAccnum = By.xpath("//input[@name='txtPPFAccountNumber']");
			public static By txtSubscriptionAmount = By.xpath("//input[@name='txtSubscriptionAmount']");
			public static By txtTotalDepositAmount = By.xpath("//input[@name='txtTotalTransactionAmount']");
			public static By txtCustId = By.xpath("//input[@name='txtCustId']");

		}
		public static class Link
		{
			public static By lnkPPFAccTorch = By.xpath("//input[@name='txtPPFAccountNumber']/../a");
			public static By lnkGBMTranID = By.xpath("//input[@name='txtGBMTranId']/../a/img");
		}
		public static class Button
		{
			public static By btnNext = By.xpath("//input[@name='btnTranLeg']");
			public static By btnFetchBtn = By.xpath("//input[@name='btnsubmit' and @value='Fetch Details CBS']");
		}

		public static class Label
		{
			public static By lblErrorCode = By.xpath("//font[starts-with(.,'E') and 'E' = translate(.,'0123456789','')]");
			public static By lblErrorDesc = By.xpath("//font[contains(text(),'Unverified transaction')]");
		}
	}

	public static class PPFVerifyTransaction
	{
		public static class Button
		{
			public static By btnSubmit = By.xpath("//input[@name='btnsubmit']");
			public static By btnTransNext = By.xpath("//input[@name='btnNext']");

		}
		public static class Table
		{
			public static By tblAccOpen = By.xpath("//td[contains(@text(),'Account Number')]/following-sibling::td");
		}
		public static class Label
		{
			public static By lblAccMesage = By.xpath("//font[contains(text(),'PPF Account')]");
			public static By lblMessageDesc = By.xpath("//font[contains(text(),'Registration Master Verified Successfully')]");
			public static By lblMessageDescription = By.xpath("//font[contains(text(),'The Challan Number')]");
			public static By lblErrMessage = By.xpath("//font[contains(text(),'Transaction')]");
			public static By lblPPFVerifyMessageDesc = By.xpath("//font[contains(text(),'verified successfully')]");
		}
	}
}
