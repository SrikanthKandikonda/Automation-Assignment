package com.axios.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.axios.page.CurrencyConverterPage;
import com.axios.utils.ReadAndWriteExcelFiles;

public class CurrecyConverterTestScript extends LaunchBrowser {
	ReadAndWriteExcelFiles readAndWriteFiles = new ReadAndWriteExcelFiles();
	@Test
	public void verifyAcccountDetails() {
		CurrencyConverterPage currencyConverterPage = PageFactory.initElements(driver, CurrencyConverterPage.class);
		currencyConverterPage.closeGetMoreAlert();
		currencyConverterPage.clickOnCurrencyFromDropDown();
		currencyConverterPage.searchIndianRupeeOption();
		for (int i = 1; i < 7; i++) {
			currencyConverterPage.clickOnCurrencyToDropDown();
			String countryCode = readAndWriteFiles.readFile(i,0);
			currencyConverterPage.searchCountry(countryCode);
			if (i == 1) 
				currencyConverterPage.clickOnConvertCurrency();
			readAndWriteFiles.WriteFile(i, 1, currencyConverterPage.getConvertedCurrencyText());
		}
	}

}
