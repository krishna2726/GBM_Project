package com.gbm.testsuite;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNGSuiteMakeUp {

	public static void main(String[] args) throws Exception 
	{		
		//testng CBDT testsuite preparation
		XmlSuite suite = new XmlSuite();
		suite.setName("CBDTSuite");
		XmlTest test = new XmlTest(suite);
		test.setName("CBDTTests");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.gbm.cbdttestsctipts.GBM_TS1_CBDTCashTransaction"));
		classes.add(new XmlClass("com.gbm.cbdttestsctipts.GBM_TS2_CBDTTransferTransaction"));
		classes.add(new XmlClass("com.gbm.cbdttestsctipts.GBM_TS3_CBDTClearTransaction"));
		classes.add(new XmlClass("com.gbm.cbdttestsctipts.GBM_TS4_CBDT_Clearing_Reconciliation"));
		classes.add(new XmlClass("com.gbm.cbdttestsctipts.GBM_TS5_CBDTEOD"));

		test.setXmlClasses(classes);

		//testng CBCE testsuite preparation
		XmlSuite suite1 = new XmlSuite();
		suite1.setName("CBECSuite");
		XmlTest test1 = new XmlTest(suite1);
		test1.setName("CBECTests");
		List<XmlClass> classes1 = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.gbm.cbectestscripts.GBM_TS1_CBECCashTransaction"));
		classes.add(new XmlClass("com.gbm.cbectestscripts.GBM_TS2_CBECTransferTransaction"));
		classes.add(new XmlClass("com.gbm.cbectestscripts.GBM_TS3_CBECClearTransaction"));	
		test1.setXmlClasses(classes1);


		//testng NPS testsuite preparation
		XmlSuite suite2 = new XmlSuite();
		suite2.setName("NPSSuite");
		XmlTest test2 = new XmlTest(suite2);
		test2.setName("NPSTests");
		List<XmlClass> classes2 = new ArrayList<XmlClass>();
		classes2.add(new XmlClass("com.gbm.npstestscripts.GBM_TS1_NPS_CashTransaction"));
		classes2.add(new XmlClass("com.gbm.npstestscripts.GBM_TS2_NPS_TransferTransaction"));
		classes2.add(new XmlClass("com.gbm.npstestscripts.GBM_TS3_NPS_ClearTransaction"));	
		classes2.add(new XmlClass("com.gbm.npstestscripts.GBM_TS4_NPS_ClearingReconciliation"));		
		classes2.add(new XmlClass("com.gbm.npstestscripts.GBM_TS5_NPS_PRAN_MASTERWalkin"));		
		test2.setXmlClasses(classes2);

		//testng SalesTax testsuite preparation
		XmlSuite suite3 = new XmlSuite();
		suite3.setName("SalesTaxSuite");
		XmlTest test3 = new XmlTest(suite3);
		test3.setName("SalesTaxTests");
		List<XmlClass> classes3 = new ArrayList<XmlClass>();
		classes3.add(new XmlClass("com.gbm.salestaxtestcases.GBM_TS1_SalesTaxCashTransaction"));
		classes3.add(new XmlClass("com.gbm.salestaxtestcases.GBM_TS2_SalesTaxTransferTransaction"));
		classes3.add(new XmlClass("com.gbm.salestaxtestcases.GBM_TS3_SalesTaxClearTransaction"));	
		test3.setXmlClasses(classes3);


		//testng PPF testsuite preparation
		XmlSuite suite4 = new XmlSuite();
		suite4.setName("PPFSuite");
		XmlTest test4 = new XmlTest(suite4);
		test4.setName("PPFTests");
		List<XmlClass> classes4 = new ArrayList<XmlClass>();
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS1_PPF_RegistrationCash"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS2_PPF_RegistrationTransfer"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS3_PPF_RegistrationClearing"));	
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS4_PPFAcountOpening"));	
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS5_PPF_DepositCash"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS6_PPFDepositTransfer"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS7_PPFClearingTransaction"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS8_PPF_ClearingReconciliation"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS9_PPF_Reports"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS10_PPFInterSolCash"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS11_PPFInerSolTransfer"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS12_PPFInterSolClearing"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS13_IntersolPPFDepositCash"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS14_IntersolPPFDepositTransfer"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS15_IntersolPPFDepositClearing"));
		classes4.add(new XmlClass("com.gbm.ppf.testscripts.GBM_TS16_IntersolPPFClearingReconciliation"));
		test4.setXmlClasses(classes4);


		//testng State Tax testsuite preparation
		XmlSuite suite5 = new XmlSuite();
		suite4.setName("StateTaxSuite");
		XmlTest test5 = new XmlTest(suite5);
		test4.setName("StateTaxTests");
		List<XmlClass> classes5 = new ArrayList<XmlClass>();
		classes5.add(new XmlClass("com.gbm.statetaxtestscripts.GBM_TS1_StateTaxPhysicalTransaction"));
		test5.setXmlClasses(classes5);

		//set of testsuites to be run
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		suites.add(suite1);
		suites.add(suite2);
		suites.add(suite3);
		suites.add(suite4);
		suites.add(suite5);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}
}