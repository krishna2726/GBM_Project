<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="1.0" encoding="UTF-8" />
<xsl:template match="/">
  <html>
  <head>
<script src="jquery-1.9.1.min.js"></script>
<script src="highcharts.js"></script>
<script src="exporting.js"></script>
<script> 
var pass_count = <xsl:value-of select='count(//TestSuite/Functionality/TestScript[@TC_Status="Pass"])'/>
var fail_count = <xsl:value-of select='count(//TestSuite/Functionality/TestScript[@TC_Status="Fail"])'/>

$(function () {
    $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: true
        },
        title: {
           text:''
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: ' GBM Test Results',
            data: [
                    
					['Pass',   pass_count],
	               ['Fail',fail_count]
            ]
        }]
    });
});
    

$(document).ready(function()
{
  $(".flip").click(function()
  {
	var selector = "#panel"+$(this).attr('id');
	var selector1 = ".panel"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  $(".flip1").click(function()
  {
	var selector = "#panel1"+$(this).attr('id');
	var selector1 = ".panel1"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  $(".flip2").click(function()
  {
	var selector = "#panel2"+$(this).attr('id');
	var selector1 = ".panel2"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  $(".flip3").click(function()
  {
	var selector = "#panel3"+$(this).attr('id');
	var selector1 = ".panel3"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
		$(selector1).hide();
		}
	});
  });
  
  $(".flip4").click(function()
  {
	var selector = "#panel4"+$(this).attr('id');
	var selector1 = ".panel4"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
    $(".flip5").click(function()
  {
	var selector = "#panel5"+$(this).attr('id');
	var selector1 = ".panel5"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  $(".flip6").click(function()
  {
	var selector = "#panel6"+$(this).attr('id');
	var selector1 = ".panel6"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  
  $(".flip7").click(function()
  {
	var selector = "#panel7"+$(this).attr('id');
	var selector1 = ".panel7"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  $(".flip8").click(function()
  {
	var selector = "#panel8"+$(this).attr('id');
	var selector1 = ".panel8"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
  $(".flip9").click(function()
  {
	var selector = "#panel9"+$(this).attr('id');
	var selector1 = ".panel9"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
    $(".flip10").click(function()
  {
	var selector = "#panel10"+$(this).attr('id');
	var selector1 = ".panel10"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip11").click(function()
  {
	var selector = "#panel11"+$(this).attr('id');
	var selector1 = ".panel11"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip12").click(function()
  {
	var selector = "#panel12"+$(this).attr('id');
	var selector1 = ".panel12"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip13").click(function()
  {
	var selector = "#panel13"+$(this).attr('id');
	var selector1 = ".panel13"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip14").click(function()
  {
	var selector = "#panel14"+$(this).attr('id');
	var selector1 = ".panel14"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip15").click(function()
  {
	var selector = "#panel15"+$(this).attr('id');
	var selector1 = ".panel15"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip16").click(function()
  {
	var selector = "#panel16"+$(this).attr('id');
	var selector1 = ".panel16"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip17").click(function()
  {
	var selector = "#panel17"+$(this).attr('id');
	var selector1 = ".panel17"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip18").click(function()
  {
	var selector = "#panel18"+$(this).attr('id');
	var selector1 = ".panel18"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip19").click(function()
  {
	var selector = "#panel19"+$(this).attr('id');
	var selector1 = ".panel19"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip20").click(function()
  {
	var selector = "#panel20"+$(this).attr('id');
	var selector1 = ".panel20"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip21").click(function()
  {
	var selector = "#panel21"+$(this).attr('id');
	var selector1 = ".panel21"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip22").click(function()
  {
	var selector = "#panel22"+$(this).attr('id');
	var selector1 = ".panel22"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip23").click(function()
  {
	var selector = "#panel23"+$(this).attr('id');
	var selector1 = ".panel23"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });

    $(".flip24").click(function()
  {
	var selector = "#panel24"+$(this).attr('id');
	var selector1 = ".panel24"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
      $(".flip25").click(function()
  {
	var selector = "#panel25"+$(this).attr('id');
	var selector1 = ".panel25"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
      $(".flip26").click(function()
  {
	var selector = "#panel26"+$(this).attr('id');
	var selector1 = ".panel26"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
      $(".flip27").click(function()
  {
	var selector = "#panel27"+$(this).attr('id');
	var selector1 = ".panel27"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
   $(".flip28").click(function()
  {
	var selector = "#panel28"+$(this).attr('id');
	var selector1 = ".panel28"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
     $(".flip29").click(function()
  {
	var selector = "#panel29"+$(this).attr('id');
	var selector1 = ".panel29"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
     $(".flip30").click(function()
  {
	var selector = "#panel30"+$(this).attr('id');
	var selector1 = ".panel30"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
       $(".flip31").click(function()
  {
	var selector = "#panel31"+$(this).attr('id');
	var selector1 = ".panel31"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
       $(".flip32").click(function()
  {
	var selector = "#panel32"+$(this).attr('id');
	var selector1 = ".panel32"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
       $(".flip33").click(function()
  {
	var selector = "#panel33"+$(this).attr('id');
	var selector1 = ".panel33"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
       $(".flip34").click(function()
  {
	var selector = "#panel34"+$(this).attr('id');
	var selector1 = ".panel34"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
       $(".flip35").click(function()
  {
	var selector = "#panel35"+$(this).attr('id');
	var selector1 = ".panel35"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
       $(".flip36").click(function()
  {
	var selector = "#panel36"+$(this).attr('id');
	var selector1 = ".panel36"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
		$(".flip37").click(function()
  {
	var selector = "#panel37"+$(this).attr('id');
	var selector1 = ".panel37"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
		$(".flip38").click(function()
  {
	var selector = "#panel38"+$(this).attr('id');
	var selector1 = ".panel38"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
		$(".flip39").click(function()
  {
	var selector = "#panel39"+$(this).attr('id');
	var selector1 = ".panel39"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
  
		$(".flip40").click(function()
  {
	var selector = "#panel40"+$(this).attr('id');
	var selector1 = ".panel40"+$(this).attr('id');
	$(selector1).show();
	$(selector).slideToggle("slow",function()
	{
		if ($(selector).css('display') == 'none')
		{
			$(selector1).hide();
		}
	});
  });
});
function TotalPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
	$("#TOTALFAIL").hide();
	$("#TOTALPASS").show();	
}
function TotalFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();	
	$("#TOTALFAIL").show();
	$("#TOTALPASS").hide();	
}
function Home(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
	$("#TOTALFAIL").hide();
	$("#TOTALPASS").hide();
}

function Total(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
	$("#TOTALFAIL").show();
	$("#TOTALPASS").show();	
}

function CBDT(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#TOTALPASS").hide();
	$("#CBDTFAIL").show();
	$("#CBDTPASS").show();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function CBDTPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#TOTALPASS").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").show();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function CBDTFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").show();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function CBEC(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").show();
	$("#CBECPASS").show();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function CBECPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").show();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function CBECFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").show();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function PPF(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").show();
	$("#PPFPASS").show();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function PPFPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").show();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function PPFFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").show();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function NPS(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").show();
	$("#NPSPASS").show();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function NPSPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").show();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function NPSFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").show();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function SalesTax(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").show();
	$("#SalesTaxPASS").show();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function SalesTaxPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").show();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function SalesTaxFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").show();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").hide();
}

function StateTax(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").show();
	$("#StateTaxPASS").show();
}

function StateTaxPass(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").hide();
	$("#StateTaxPASS").show();
}

function StateTaxFail(){
	$("#TotalCBDT").hide();
	$("#TotalCBEC").hide();
	$("#TotalPPF").hide();
	$("#TotalNPS").hide();
	$("#TotalSalesTax").hide();
	$("#TotalStateTax").hide();
	$("#Total").hide();
	$("#CBDTFAIL").hide();
	$("#CBDTPASS").hide();
	$("#CBECFAIL").hide();
	$("#CBECPASS").hide();
	$("#PPFFAIL").hide();
	$("#PPFPASS").hide();
	$("#NPSFAIL").hide();
	$("#NPSPASS").hide();
	$("#SalesTaxFAIL").hide();
	$("#SalesTaxPASS").hide();
	$("#StateTaxFAIL").show();
	$("#StateTaxPASS").hide();
}

function Fail_Status()
{ 
  $("#fail").toggle();
  $("#Success").hide();
  if ($("#fail").is(":hidden"))
  {
    $("#main").show();
  }
  else 
  {
      $("#main").hide();
  }
}

function Success_Status()
{  
  $("#Success").toggle();
  $("#fail").hide();
  if ($("#Success").is(":hidden")) 
  {
    $("#main").show();
  }
  else 
  {
      $("#main").hide();
  }
}

</script>
<style type="text/css"> 
.panel
{
display:none;
}
.test
 {
	width:989px ;
 } 
 
 .test1
 {
	width:984px ;
 }
 
 th{
	font-family:"Calibri";
	FONT-SIZE: 12pt;
	color:#FFFFFF;
 }
 td{
	font-family:"Calibri";
	FONT-SIZE: 12pt;
 }
  .maintable
 {
  width:1000px;
 }
  .summary
  {
  width:450px;
  }
  .sanity
  {
  width:650px;
  }
  
 .step
 {
	width:50px;
 }
 .Sname
 {
	width:200px;
 }
 
 .Tstamp
 {
	width:120px;
 }

	.frugal
	{
		margin-right:50px;float:right;width:130px;height:90px;
	}
	body
	{
	background:url(BG.gif) no-repeat center center fixed ;
	-webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;
	}
</style>
</head>
  <body >  
  <br></br>
  <br></br>
  <br></br>
  <br></br>
  	<xsl:variable name = "cbdt" select='count(//TestSuite/Functionality[@name="CBDT"]/TestScript)'/> 
	<xsl:variable name = "cbec" select = 'count(//TestSuite/Functionality[@name="CBEC"]/TestScript)'/>
	<xsl:variable name = "ppf" select = 'count(//TestSuite/Functionality[@name="PPF"]/TestScript)'/> 
	<xsl:variable name = "nps" select = 'count(//TestSuite/Functionality[@name="NPS"]/TestScript)'/> 
	<xsl:variable name = "salestax" select = 'count(//TestSuite/Functionality[@name="SalesTax"]/TestScript)'/> 	
	<xsl:variable name = "statetax" select = 'count(//TestSuite/Functionality[@name="StateTax"]/TestScript)'/> 
	
	<xsl:variable name = "cbdtpass" select='count(//TestSuite/Functionality[@name="CBDT"]/TestScript[@TC_Status="Pass"])'/> 
	<xsl:variable name = "cbecpass" select = 'count(//TestSuite/Functionality[@name="CBEC"]/TestScript[@TC_Status="Pass"])'/>
	<xsl:variable name = "ppfpass" select = 'count(//TestSuite/Functionality[@name="PPF"]/TestScript[@TC_Status="Pass"])'/> 
	<xsl:variable name = "npspass" select = 'count(//TestSuite/Functionality[@name="NPS"]/TestScript[@TC_Status="Pass"])'/> 
	<xsl:variable name = "salestaxpass" select = 'count(//TestSuite/Functionality[@name="SalesTax"]/TestScript[@TC_Status="Pass"])'/> 	
	<xsl:variable name = "statetaxpass" select = 'count(//TestSuite/Functionality[@name="StateTax"]/TestScript[@TC_Status="Pass"])'/> 
					
	<xsl:variable name = "cbdtfail" select='count(//TestSuite/Functionality[@name="CBDT"]/TestScript[@TC_Status="Fail"])'/> 
	<xsl:variable name = "cbecfail" select = 'count(//TestSuite/Functionality[@name="CBEC"]/TestScript[@TC_Status="Fail"])'/>
	<xsl:variable name = "ppffail" select = 'count(//TestSuite/Functionality[@name="PPF"]/TestScript[@TC_Status="Fail"])'/> 
	<xsl:variable name = "npsfail" select = 'count(//TestSuite/Functionality[@name="NPS"]/TestScript[@TC_Status="Fail"])'/> 
	<xsl:variable name = "salestaxfail" select = 'count(//TestSuite/Functionality[@name="SalesTax"]/TestScript[@TC_Status="Fail"])'/> 	
	<xsl:variable name = "statetaxfail" select = 'count(//TestSuite/Functionality[@name="StateTax"]/TestScript[@TC_Status="Fail"])'/> 
	
	<table align="center" class="maintable">
		<tr>
			<td>
				<h3 style="" ><span style="margin-left:3%;padding-left:15%;padding-right:15%;background:#808080;color:#FFFFFF;"><font face="Calibri" size="4">Summary</font></span><a href="#" onClick="Home();" style="padding-left:15%;padding-right:15%;background:#808080;color:#FFFFFF;margin-left:10%;"><font face="Calibri" size="4">Home</font></a></h3>
				<table style = "border:1px solid black;" border = "1" cellpadding = "5" align="center" class="summary">
					<tr  bgcolor="#C81B5D" style="height:40px">
						<th>Functionality</th>
						<th>Count</th>		
						<th>Pass</th>
						<th>Fail</th>
					</tr>					
					<tr>
						<td align="center"><font face="Calibri" size="2" color="#000000"><b>CBDT</b></font></td>
						<td align="center"><output><a href="#" onClick="CBDT();"><xsl:value-of select='count(//TestSuite/Functionality[@name="CBDT"]/TestScript)'/></a></output></td>
						<td align="center"><output><a href="#" onClick="CBDTPass();"><xsl:value-of select='count(//TestSuite/Functionality[@name="CBDT"]/TestScript[@TC_Status="Pass"])'/></a></output></td>
						<td align="center"><output><a href="#" onClick="CBDTFail();"><xsl:value-of select='count(//TestSuite/Functionality[@name="CBDT"]/TestScript[@TC_Status="Fail"])'/></a></output></td>
					</tr>
					<tr>
						<td align="center"><font face="Calibri" size="2" color="#000000"><b>CBEC</b></font></td>
						<td align="center"><output><a href="#" onClick="CBEC();"><xsl:value-of select='count(//TestSuite/Functionality[@name="CBEC"]/TestScript)'/></a></output></td>
						<td align="center"><output><a href="#" onClick="CBECPass();"><xsl:value-of select='count(//TestSuite/Functionality[@name="CBEC"]/TestScript[@TC_Status="Pass"])'/></a></output></td>
						<td align="center"><output><a href="#" onClick="CBECFail();"><xsl:value-of select='count(//TestSuite/Functionality[@name="CBEC"]/TestScript[@TC_Status="Fail"])'/></a></output></td>
					</tr>
					<tr>
						<td align="center"><font face="Calibri" size="2" color="#000000"><b>PPF</b></font></td>
						<td align="center"><output><a href="#" onClick="PPF();"><xsl:value-of select='count(//TestSuite/Functionality[@name="PPF"]/TestScript)'/></a></output></td>
						<td align="center"><output><a href="#" onClick="PPFPass();"><xsl:value-of select='count(//TestSuite/Functionality[@name="PPF"]/TestScript[@TC_Status="Pass"])'/></a></output></td>
						<td align="center"><output><a href="#" onClick="PPFFail();"><xsl:value-of select='count(//TestSuite/Functionality[@name="PPF"]/TestScript[@TC_Status="Fail"])'/></a></output></td>
					</tr>
					<tr>
						<td align="center"><font face="Calibri" size="2" color="#000000"><b>NPS</b></font></td>
						<td align="center"><output><a href="#" onClick="NPS();"><xsl:value-of select='count(//TestSuite/Functionality[@name="NPS"]/TestScript)'/></a></output></td>
						<td align="center"><output><a href="#" onClick="NPSPass();"><xsl:value-of select='count(//TestSuite/Functionality[@name="NPS"]/TestScript[@TC_Status="Pass"])'/></a></output></td>
						<td align="center"><output><a href="#" onClick="NPSFail();"><xsl:value-of select='count(//TestSuite/Functionality[@name="NPS"]/TestScript[@TC_Status="Fail"])'/></a></output></td>
					</tr>
					<tr>
						<td align="center"><font face="Calibri" size="2" color="#000000"><b>Sales Tax</b></font></td>
						<td align="center"><output><a href="#" onClick="SalesTax();"><xsl:value-of select='count(//TestSuite/Functionality[@name="SalesTax"]/TestScript)'/></a></output></td>
						<td align="center"><output><a href="#" onClick="SalesTaxPass();"><xsl:value-of select='count(//TestSuite/Functionality[@name="SalesTax"]/TestScript[@TC_Status="Pass"])'/></a></output></td>
						<td align="center"><output><a href="#" onClick="SalesTaxFail();"><xsl:value-of select='count(//TestSuite/Functionality[@name="SalesTax"]/TestScript[@TC_Status="Fail"])'/></a></output></td>
					</tr>
					<tr>
						<td align="center"><font face="Calibri" size="2" color="#000000"><b>State Tax</b></font></td>
						<td align="center"><output><a href="#" onClick="StateTax();"><xsl:value-of select='count(//TestSuite/Functionality[@name="StateTax"]/TestScript)'/></a></output></td>
						<td align="center"><output><a href="#" onClick="StateTaxPass();"><xsl:value-of select='count(//TestSuite/Functionality[@name="StateTax"]/TestScript[@TC_Status="Pass"])'/></a></output></td>
						<td align="center"><output><a href="#" onClick="StateTaxFail();"><xsl:value-of select='count(//TestSuite/Functionality[@name="StateTax"]/TestScript[@TC_Status="Fail"])'/></a></output></td>
					</tr>
					<tr style="background-color:#C81B5D;color:#FFFFFF;">
						<td align="center"><font face="Calibri" size="2" color="#FFFFFF"><b>TOTAL</b></font></td>
						<td align="center"><a href="#" onClick="total();"><output><xsl:value-of select= '$cbdt+$cbec+$ppf+$nps+$salestax+$statetax' /></output></a></td>
						<td align="center"><a href="#" onClick="TotalPass();"><output><xsl:value-of select='$cbdtpass+$cbecpass+$ppfpass+$npspass+$salestaxpass+$statetaxpass'/></output></a></td>
						<td align="center"><a href="#" onClick="TotalFail();"><output><xsl:value-of select='$cbdtfail+$cbecfail+$ppffail+$npsfail+$salestaxfail+$statetaxfail'/></output></a></td>
					</tr>	
				</table>
			</td>
			<td>
				<h3 style="background:#808080;color:#FFFFFF;margin-left:37%;margin-right:37%;text-align:center;"><font face="Calibri" size="4">Pie Chart</font></h3>
				<div id="container" style="min-width: 400px; height:215px;"></div>
			</td>	
		</tr>
	</table>
<br></br>	
<br></br>
<br></br>

<div id="TotalCBDT" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">CBDT Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="CBDT"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num1"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num1" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num3"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip1" ><xsl:attribute name="id"><xsl:value-of select="$num3"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel1<xsl:value-of select="$num3"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel1<xsl:value-of select="$num3"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>	
<div id="TotalCBEC" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">CBEC Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="CBEC"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num4"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num4" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip2"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel2<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel2<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num3"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip3" ><xsl:attribute name="id"><xsl:value-of select="$num3"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel3<xsl:value-of select="$num3"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel3<xsl:value-of select="$num3"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>	
<div id="TotalPPF" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">PPF Test results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="PPF"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num7"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num7" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip4"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel4<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel4<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num8"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip5" ><xsl:attribute name="id"><xsl:value-of select="$num8"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel5<xsl:value-of select="$num8"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel5<xsl:value-of select="$num8"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>	
<div id="TotalNPS" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">NPS Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="NPS"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num9"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num9" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip6"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel6<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel6<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num10"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip7" ><xsl:attribute name="id"><xsl:value-of select="$num10"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel7<xsl:value-of select="$num10"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel7<xsl:value-of select="$num10"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="TotalSalesTax" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">Sales Tax Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="SalesTax"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num43"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num43" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip37"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel37<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel37<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num44"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip38" ><xsl:attribute name="id"><xsl:value-of select="$num44"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel38<xsl:value-of select="$num44"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel38<xsl:value-of select="$num44"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>	
<div id="TotalStateTax" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">State Tax Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="StateTax"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num45"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num45" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip39"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel39<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel39<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num46"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip40" ><xsl:attribute name="id"><xsl:value-of select="$num46"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel40<xsl:value-of select="$num46"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel40<xsl:value-of select="$num46"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="Total" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">GBM TestResults</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num11"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num11" /><xsl:value-of select="position()" /></xsl:variable>
					<tr>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
						<td class="flip6"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
						<xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
							<td align="center"><font face="Calibri" size="2" color="red" ><b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:when>
						<xsl:otherwise>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
						</xsl:otherwise>
						</xsl:choose> 
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
						<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
					</tr>
					<tr style="display:none;"><xsl:attribute name="class">panel6<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel6<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num12"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip7" ><xsl:attribute name="id"><xsl:value-of select="$num12"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel7<xsl:value-of select="$num12"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel7<xsl:value-of select="$num12"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>	
<div id="CBDTFAIL" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">CBDT Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="CBDT"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num35"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num36"><xsl:value-of select="$num35" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip10"><xsl:attribute name="id"><xsl:value-of select="$num36"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="red"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel10<xsl:value-of select="$num36"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel10<xsl:value-of select="$num36"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num38"><xsl:value-of select="$num36"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip28" ><xsl:attribute name="id"><xsl:value-of select="$num38"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel28<xsl:value-of select="$num38"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel28<xsl:value-of select="$num38"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="CBDTPASS" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">CBDT Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="CBDT"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num13"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num13" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip8"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel8<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel8<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num14"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip9" ><xsl:attribute name="id"><xsl:value-of select="$num14"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel9<xsl:value-of select="$num14"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel9<xsl:value-of select="$num14"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="CBECFAIL" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">CBEC Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="CBEC"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num19"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num19" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip14"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="red"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel14<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel14<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num20"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip15" ><xsl:attribute name="id"><xsl:value-of select="$num20"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel15<xsl:value-of select="$num20"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel15<xsl:value-of select="$num20"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="CBECPASS" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">CBEC Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="CBEC"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num17"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num17" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip12"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel12<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel12<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num18"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip13" ><xsl:attribute name="id"><xsl:value-of select="$num18"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel13<xsl:value-of select="$num18"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel13<xsl:value-of select="$num18"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="PPFFAIL" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">PPF Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="PPF"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num23"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num23" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip18"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="red"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel18<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel18<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num24"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip19" ><xsl:attribute name="id"><xsl:value-of select="$num24"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel19<xsl:value-of select="$num24"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel19<xsl:value-of select="$num24"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="PPFPASS" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">PPF Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="PPF"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num21"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num21" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip16"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel16<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel16<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num22"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip17" ><xsl:attribute name="id"><xsl:value-of select="$num22"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel17<xsl:value-of select="$num22"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel17<xsl:value-of select="$num22"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="NPSFAIL" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">NPS Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="NPS"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num27"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num27" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip22"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Red"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel22<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel22<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num28"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip23" ><xsl:attribute name="id"><xsl:value-of select="$num28"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel23<xsl:value-of select="$num28"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel23<xsl:value-of select="$num28"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="NPSPASS" style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">NPS Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="NPS"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num25"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num25" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip20"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel20<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel20<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num26"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip21" ><xsl:attribute name="id"><xsl:value-of select="$num26"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel21<xsl:value-of select="$num26"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel21<xsl:value-of select="$num26"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="TOTALFAIL"  style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">GBM Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num30"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num30" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip26"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Red"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel26<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel26<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num31"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip27" ><xsl:attribute name="id"><xsl:value-of select="$num31"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel27<xsl:value-of select="$num31"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel27<xsl:value-of select="$num31"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="TOTALPASS"  style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">GBM Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num29"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num29" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip24"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel24<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel24<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num30"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip25" ><xsl:attribute name="id"><xsl:value-of select="$num30"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel25<xsl:value-of select="$num30"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel25<xsl:value-of select="$num30"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="SalesTaxPASS"  style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">SalesTax Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="SalesTax"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num35"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num35" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip29"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel29<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel29<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num36"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip30" ><xsl:attribute name="id"><xsl:value-of select="$num36"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel30<xsl:value-of select="$num36"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel30<xsl:value-of select="$num36"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="SalesTaxFAIL"  style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">SalesTax Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="SalesTax"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num37"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num37" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip31"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel31<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel31<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num38"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip32" ><xsl:attribute name="id"><xsl:value-of select="$num38"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel32<xsl:value-of select="$num38"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel32<xsl:value-of select="$num38"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="StateTaxPASS"  style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">StateTax Pass Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="StateTax"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num41"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num41" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Pass'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip35"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel35<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel35<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num42"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip36" ><xsl:attribute name="id"><xsl:value-of select="$num42"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel36<xsl:value-of select="$num42"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel36<xsl:value-of select="$num42"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
<div id="StateTaxFAIL"  style="display:none;">
	<h3 style="background:#808080;color:#FFFFFF;margin-left:12%;margin-right:12%;text-align:center"><font face="Calibri" size="4">StateTax Fail Test Results</font></h3>
	<table  border="1" align="center" class="maintable">
		<tr bgcolor="#C81B5D" style="height:40px">
			<th align="center" width="100px"><b>Functionality</b></th>
			<th align="center"><b>TestScript</b></th>
			<th align="center" width="50px"><b>Status</b></th>
			<th align="center" width="150px"><b>Start Time</b></th>
			<th align="center" width="150px"><b>End Time</b></th>
		</tr>
		<xsl:for-each select='TestSuite/Functionality[@name="StateTax"]'>
		<xsl:variable name="functionalityName"><xsl:value-of select="@name"/></xsl:variable>
		<xsl:variable name="num39"><xsl:value-of select="position()"/></xsl:variable>
			<xsl:for-each select="TestScript">
				<xsl:variable name="num2"><xsl:value-of select="$num39" /><xsl:value-of select="position()" /></xsl:variable>
					  <xsl:choose>
						<xsl:when test="@TC_Status='Fail'">
						<tr>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="$functionalityName"/></b></font></td>
							<td class="flip33"><xsl:attribute name="id"><xsl:value-of select="$num2"/></xsl:attribute><font face="Calibri" size="2"><b><xsl:value-of select="@name"/></b></font></td>
							<td align="center"><font face="Calibri" size="2" color="Green"> <b><xsl:value-of select="@TC_Status"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@StartTime"/></b></font></td>
							<td align="center"><font face="Calibri" size="2"><b><xsl:value-of select="@EndTime"/></b></font></td>
						</tr>
						</xsl:when>
					</xsl:choose> 
					<tr style="display:none;"><xsl:attribute name="class">panel33<xsl:value-of select="$num2"/></xsl:attribute>
						<td colspan="5">
						<div style="display:none;"><xsl:attribute name="id">panel33<xsl:value-of select="$num2"/></xsl:attribute>
						<xsl:for-each select="Iterator">
							<xsl:variable name="num40"><xsl:value-of select="$num2"/><xsl:value-of select="position()" /></xsl:variable>
							<table border=".5" align="center" class="test">
								<tr>
									<td align="center" colspan="5" class="flip34" ><xsl:attribute name="id"><xsl:value-of select="$num40"/></xsl:attribute><font face="Calibri" size="2" color="#000000"><b>Iteration : <xsl:value-of select="@no"/></b></font></td>
								</tr>
							</table>
							<tr style="display:none;"><xsl:attribute name="class">panel34<xsl:value-of select="$num40"/></xsl:attribute>
								<td colspan="5">
								<div style="display:none;"><xsl:attribute name="id">panel34<xsl:value-of select="$num40"/></xsl:attribute>
								<table border="1" align="center" class="test1" >
									<tr bgcolor="#DCDCDC">
										<th><font face="Calibri" size="2" color="#000000">Step No</font></th>
										<th><font face="Calibri" size="2" color="#000000">Step Name</font></th>
										<th><font face="Calibri" size="2" color="#000000">Description</font></th>
										<th><font face="Calibri" size="2" color="#000000">Status</font></th>
										<th><font face="Calibri" size="2" color="#000000">Timestamp</font></th>
									</tr>
									<xsl:for-each select="step">	
										<tr>
											<td align="center" class="step" ><font face="Calibri" size="2"><xsl:value-of select="@no"/></font></td>
											<td class="Sname"><font face="Calibri" size="2"><xsl:value-of select="stepname" /></font></td>
											<td><font face="Calibri" size="2"><xsl:value-of select="Description"/></font></td>
											<xsl:choose>
												<xsl:when test="status='Fail'">
													<td width="5%" align="center"><font face="Calibri" size="2" color="red"><b><xsl:value-of select="status"/></b></font></td>
												</xsl:when>
											<xsl:otherwise>
												<td width="5%" align="center"><font face="Calibri" size="2" color="green"><b><xsl:value-of select="status"/></b></font></td>
											</xsl:otherwise>
											</xsl:choose> 
											<td class="Tstamp"><font face="Calibri" size="2"><xsl:value-of select="timestamp"/></font></td>
										</tr>
									</xsl:for-each>
								</table>
								</div>
								</td>  
							</tr>
						</xsl:for-each>  	
						</div>
						</td>
					</tr>
			</xsl:for-each>
    </xsl:for-each>
    </table>
</div>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
