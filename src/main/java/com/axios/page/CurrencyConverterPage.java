package com.axios.page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.axios.utils.Scroll;
import com.axios.utils.Wait;

public class CurrencyConverterPage {
	Wait wait = new Wait();
	Scroll scroll = new Scroll();
	WebDriver driver;
	public CurrencyConverterPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath = "//button[@id='yie-close-button-8689540e-42a7-5929-810d-356d38669b5c']")
	private WebElement getMoreAlertCloseButton;
	
    @FindBy(xpath = "//input[@id='midmarketFromCurrency']")
    private WebElement currencyFromDropDownButton;
    
    @FindBy(xpath = "//input[@id='midmarketFromCurrency']//ul//li[7]")
    private WebElement indianRupeeOptionInCurrrecyFromDropdown;
    
    @FindBy(xpath = "//input[@id='midmarketToCurrency']")
    private WebElement currencyToDropDownButton;
    
    @FindBys(@FindBy(xpath = "//li[contains(@id,'midmarketToCurrency')]//div"))
    private List<WebElement> listOfCountriesInCurrencyToDropdown;
    
    @FindBy(xpath="//div[@class='currency-converter__SubmitZone-zieln1-3 eIzYlj']//button[@class='button__BaseButton-sc-1qpsalo-0 clGTKJ']" )
    private WebElement convertButton;
    
    @FindBy(xpath="//p[@class='result__ConvertedText-sc-1bsijpp-0 gwvOOF']" )
    private WebElement indianRupeeText;

    @FindBy(xpath = "//p[@class='result__BigRate-sc-1bsijpp-1 iGrAod']")
    private WebElement convertedValueText;
    
    @FindBy(xpath = "//p[@class='result__BigRate-sc-1bsijpp-1 iGrAod']//span")
    private WebElement fadedValuText;
    
    @FindBy(xpath ="//table[@class='currency-conversion-tables__ConverterTable-sc-3fg8ob-5 jESrzS']//td//a[text() ='1' and text()='INR']//ancestor::tr//td[2]")
    private WebElement convertedValue;
    
    public void closeGetMoreAlert() {
		wait.waitForElementToBeVisible(driver,getMoreAlertCloseButton , 30);
		getMoreAlertCloseButton.click();
	}
    
    public void clickOnCurrencyFromDropDown() {
		wait.waitForElementToBeVisible(driver,currencyFromDropDownButton , 30);
		currencyFromDropDownButton.click();
	}
    
    public void selectIndianRupeeOption() {
		wait.waitForElementToBeVisible(driver,indianRupeeOptionInCurrrecyFromDropdown , 30);
		scroll.scrollUpToWebElement(driver,indianRupeeOptionInCurrrecyFromDropdown);
		indianRupeeOptionInCurrrecyFromDropdown.click();
	}
    
    public void clickOnCurrencyToDropDown() {
    	wait.waitForElementToBeVisible(driver,currencyToDropDownButton , 30);
    	currencyToDropDownButton.click();
	}
    
    public void selectCountry(int index ) {
		wait.waitForElementToBeClickable(driver,listOfCountriesInCurrencyToDropdown.get(index) , 30);
		scroll.scrollUpToWebElement(driver,listOfCountriesInCurrencyToDropdown.get(index));
		listOfCountriesInCurrencyToDropdown.get(index).click();
	}
    
    public void clickOnConvertCurrency() {
		wait.waitForElementToBeVisible(driver,convertButton , 30);
		convertButton.click();
	}
    
    public String getConvertedCurrencyText() {
    	wait.waitForElementToBeVisible(driver,indianRupeeText , 30);
    	String convertedCurrency = indianRupeeText.getText()+convertedValue.getText();
    	return convertedCurrency;
    	
    }
    
    public void searchIndianRupeeOption() {
    	wait.waitForElementToBeVisible(driver,currencyFromDropDownButton , 30);
    	currencyFromDropDownButton.sendKeys("INR");
    	currencyFromDropDownButton.sendKeys(Keys.ENTER);
    	
    }
    
    public void searchCountry(String country) {
    	wait.waitForElementToBeVisible(driver,currencyToDropDownButton , 30);
    	currencyToDropDownButton.sendKeys(country);
    	currencyToDropDownButton.sendKeys(Keys.ENTER);
    	
    }
    
    
    
}
