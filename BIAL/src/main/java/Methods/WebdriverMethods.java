package Methods;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverMethods 
{
	WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    String alertMessage;
    String parentWindowHandler = null; 
    
	public WebdriverMethods(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void ImplicitlyWait(WebDriver driver, int waitTimeInSec)
	{
		driver.manage().timeouts().implicitlyWait(waitTimeInSec, TimeUnit.SECONDS);	
	}
	
	public void InvisibilityOfElementExplicityWait(WebDriver driver, WebElement element, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.invisibilityOf(element));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void ElementAttributeContainsExplicityWait(WebDriver driver, WebElement element, String attributename, String attributevalue, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.attributeContains(element, attributename, attributevalue));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void ExplicityWaitForElementTobeClickable(WebDriver driver, WebElement element, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.elementToBeClickable(element));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void VisibilityOfElementExplicityWait(WebDriver driver, List<WebElement> Element, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.visibilityOfAllElements(Element));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public void VisibilityOfElementExplicityWait(WebDriver driver, WebElement element, int timeInSec)
	{
		try
        {
			WebDriverWait wait = new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.visibilityOf(element));
        }
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
	
	public String[] handleWindows(WebDriver driver)
	{
		  Set<String> set =driver.getWindowHandles();
		  Iterator<String> itr= set.iterator();
		  String[] win=new String[5];
		  int i=0;
		  while (itr.hasNext()) 
		  {
			win[i]=itr.next();
			i++;
		  }
		  return win;
	}
	
	public Boolean isElementEnable(WebDriver driver, By Element)
    {
		WebElement element = null;
		boolean isEnable = false;
        try
        {
            element = driver.findElement(Element);
            if(element.isEnabled() == true && element.isDisplayed() == true)
            {
            	isEnable = true;
            }
            else
            {
            	isEnable = false;
            }
        }
        catch (Exception ex)
        {
        	isEnable = false;
        	System.out.println(ex.toString());
        }
        
        return isEnable;
    }
	
	public  Boolean isElementPresent(WebDriver driver, By Element)
    {
		WebElement element = null;
		boolean isFound = false;
        try
        {
            element = driver.findElement(Element);
            isFound = element.isDisplayed();
        }
        catch (Exception ex)
        {
            isFound = false;
        	System.out.println(ex.toString());
        }
        
        return isFound;
    }
	
	public  Boolean isElementPresent(WebDriver driver, WebElement Element)
    {
		boolean isFound = false;
        try
        {
            isFound = Element.isDisplayed();
        }
        catch (Exception ex)
        {
            isFound = false;
        	System.out.println(ex.toString());
        }
        
        return isFound;
    }
	
	public  Boolean isElementTextMatch(WebDriver driver, By Element, String ElementText)
    {
		WebElement element = null;
		boolean isMatch = false;
        try
        {
            element = driver.findElement(Element);
            isMatch = element.getText().equalsIgnoreCase(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	public  Boolean isElementTextMatch(WebDriver driver, WebElement Element, String ElementText)
    {
		boolean isMatch = false;
        try
        {
            isMatch = Element.getText().equalsIgnoreCase(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	public  Boolean isElementTextMatch2(WebDriver driver, WebElement Element, String ElementText)
    {
		boolean isMatch = false;
		String elementText = null;
        try
        {
        	elementText = Element.getText();
        	elementText = elementText.replaceAll(" ", "");
            isMatch = elementText.equalsIgnoreCase(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	public  Boolean isElementTextContain(WebDriver driver, By Element, String ElementText)
    {
		WebElement element = null;
		boolean isMatch = false;
        try
        {
            element = driver.findElement(Element);
            isMatch = element.getText().contains(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	public  Boolean isElementTextContain(WebDriver driver, WebElement Element, String ElementText)
    {
		System.out.println("Element.getText()::"+Element.getText());
		boolean isMatch = false;
        try
        {
            isMatch = Element.getText().contains(ElementText);
        }
        catch (Exception ex)
        {
        	isMatch = false;
        	System.out.println(ex.toString());
        }
        
        return isMatch;
    }
	
	public  Boolean isElementAttributeValueEqual(WebDriver driver, WebElement element,String attributeName, String attributeValue)
    {
		boolean isEqual = false;
        try
        {
            isEqual = element.getAttribute(attributeName).equalsIgnoreCase(attributeValue);
        }
        catch (Exception ex)
        {
        	isEqual = false;
        	System.out.println(ex.toString());
        }
        
        return isEqual;
    }
	
	public  Boolean isElementAttributeValueEqual(WebDriver driver, By elementBy,String attributeName, String attributeValue)
    {
		WebElement element = null;
		boolean isEqual = false;
        try
        {
            element = driver.findElement(elementBy);
            isEqual = element.getAttribute(attributeName).equalsIgnoreCase(attributeValue);
        }
        catch (Exception ex)
        {
        	isEqual = false;
        	System.out.println(ex.toString());
        }
        
        return isEqual;
    }
	
	public  Boolean isElementAttributeValueContain(WebDriver driver, WebElement element,String attributeName, String attributeValue)
    {
		boolean isEqual = false;
        try
        {
            isEqual = element.getAttribute(attributeName).contains(attributeValue);
        }
        catch (Exception ex)
        {
        	isEqual = false;
        	System.out.println(ex.toString());
        }
        
        return isEqual;
    }
	
	public  Boolean isElementAttributeValueEmpty(WebDriver driver, WebElement element, String attributeName)
    {
		boolean isEmpty = false;
		String attributeValue = null;
        try
        {
        	attributeValue = element.getAttribute(attributeName);
        	if (attributeValue.isEmpty() || attributeValue == "")
        	{
        		isEmpty = true;
        	}
        	else
        	{
        		isEmpty = false;
        	}
        }
        catch (Exception ex)
        {
        	isEmpty = true;
        	System.out.println(ex.toString());
        }
        
        return isEmpty;
    }
	
	public  Boolean isElementAttributeValueContain(WebDriver driver, By elementBy,String attributeName, String attributeValue)
    {
		WebElement element = null;
		boolean isEqual = false;
        try
        {
            element = driver.findElement(elementBy);
            isEqual = element.getAttribute(attributeName).contains(attributeValue);
        }
        catch (Exception ex)
        {
        	isEqual = false;
        	System.out.println(ex.toString());
        }
        
        return isEqual;
    }
	
	public void ClearTextbox(WebDriver driver, WebElement element) throws Throwable
	{
		 Actions move = new Actions(driver);
		 Action clear = move.moveToElement(element).build();
		 clear.perform();
		 Thread.sleep(2000);
		 clear = move.click().build();
		 clear.perform();
		 Thread.sleep(2000);
		 clear = move.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE).build();
		 clear.perform();
		 Thread.sleep(3000);
//		 ImplicitlyWait(driver, 5);
	}
	
	public void DragAndDrop(WebDriver driver, WebElement fromElement, WebElement toElement) throws Throwable
	{
		 Actions moved = new Actions(driver);
		 Action dragDrop = moved.moveToElement(fromElement)
				 .clickAndHold(fromElement)
				 .moveToElement(toElement)
				 .release(toElement).build();
		 dragDrop.perform();
		 
		 Thread.sleep(3000);
	}
	
	public void JavascriptExecutorClick(WebDriver driver, WebElement Element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", Element);
	}
	
	public void SelectFromDropdownList(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		ExplicityWaitForElementTobeClickable(driver, elementToClick, 10);
		elementToClick.click();
		Thread.sleep(1000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementTextContain(driver, DropdownListElements.get(i), selectValue) == true)
			{
				DropdownListElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public void SelectFromAutoDropdownList(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		elementToClick.sendKeys(selectValue);
		Thread.sleep(3000);
//		ImplicitlyWait(driver, 6);
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementTextContain(driver, DropdownListElements.get(i), selectValue) == true)
			{
//				Actions move = new Actions(driver);
//			    Action click = move.moveToElement(DropdownListElements.get(i)).click().sendKeys(Keys.BACK_SPACE).build();
//			    click.perform();
				DropdownListElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	
	public void SelectFromAutoDropdownList2(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		elementToClick.sendKeys(selectValue);
		Thread.sleep(3000);
//		ImplicitlyWait(driver, 6);
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementTextMatch2(driver, DropdownListElements.get(i), selectValue) == true)
			{
//				Actions move = new Actions(driver);
//			    Action click = move.moveToElement(DropdownListElements.get(i)).click().sendKeys(Keys.BACK_SPACE).build();
//			    click.perform();
				DropdownListElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public void SelectFromCheckDropdownList(WebDriver driver, WebElement elementToClick, WebElement searchFieldElement, 
			List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements,String selectValue) throws Throwable
	{
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		searchFieldElement.sendKeys(selectValue);
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownNameListElements.size(); i++)
		{
			if (isElementTextContain(driver, DropdownNameListElements.get(i), selectValue) == true)
			{
				DropdownNameCheckElements.get(i).click();
				break;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public void SelectFromCheckDropdownList(WebDriver driver, WebElement elementToClick, 
			List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements,String selectValue) throws Throwable
	{
		elementToClick.click();
		Thread.sleep(1000);
//		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownNameListElements.size(); i++)
		{
			if (isElementTextContain(driver, DropdownNameListElements.get(i), selectValue) == true)
			{
				JavascriptExecutor_ElementScroll(driver, DropdownNameCheckElements.get(i));
				Thread.sleep(500);
				DropdownNameCheckElements.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
//		ImplicitlyWait(driver, 5);
		elementToClick.click();
		Thread.sleep(1000);
//		ImplicitlyWait(driver, 5);
	}
	
	public void SelectFromCheckDropdownList(WebDriver driver, WebElement elementToClick, WebElement searchFieldElement, 
			List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements, String[] selectValues) throws Throwable
	{
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < selectValues.length; i++) 
		{
			searchFieldElement.clear();
//			Thread.sleep(500);
			ImplicitlyWait(driver, 5);
			ClearTextbox(driver, searchFieldElement);
//			Thread.sleep(500);
			ImplicitlyWait(driver, 5);
			searchFieldElement.sendKeys(selectValues[i]);
//			Thread.sleep(2000);
			ImplicitlyWait(driver, 5);
			for (int j = 0; j < DropdownNameListElements.size(); j++)
			{
				if (isElementTextContain(driver, DropdownNameListElements.get(j), selectValues[i]) == true)
				{
					DropdownNameCheckElements.get(j).click();
					break;
				}
			}
//			Thread.sleep(2000);
			ImplicitlyWait(driver, 5);
		}
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
	}
	
	public boolean isSelected(WebDriver driver, WebElement elementToClick, WebElement searchFieldElement, List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements,String selectValue) throws Throwable
	{
		boolean isSelect = false;
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		searchFieldElement.sendKeys(selectValue);
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownNameListElements.size(); i++)
		{
			if (isElementTextContain(driver, DropdownNameListElements.get(i), selectValue) == true)
			{
				isSelect = isElementAttributeValueContain(driver, DropdownNameCheckElements.get(i), "class", "checked");
				break;
			}
			else
			{
				isSelect = false;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		
		return isSelect;
	}
	
	public void SelectFromCheckDropdownList(WebDriver driver,
			List <WebElement> DropdownNameListElements, List <WebElement> DropdownNameCheckElements, String... selectValues) throws Throwable
	{
		for (int i = 0; i < selectValues.length; i++) 
		{
			for (int j = 0; j < DropdownNameListElements.size(); j++)
			{
				if (isElementTextContain(driver, DropdownNameListElements.get(j), selectValues[i]) == true)
				{
					DropdownNameCheckElements.get(j).click();
					break;
				}
			}
//			Thread.sleep(2000);
			ImplicitlyWait(driver, 5);
		}
	}
	
	public boolean isSelected(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownNameCheckElements) throws Throwable
	{
		boolean isSelect = false;
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownNameCheckElements.size(); i++)
		{
			if (isElementAttributeValueContain(driver, DropdownNameCheckElements.get(i), "class", "checked") == true)
			{
				isSelect = true;
				break;
			}
			else
			{
				isSelect = false;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		elementToClick.click();
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		
		return isSelect;
	}
	
	public boolean isSelected(WebDriver driver, WebElement elementToClick, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		boolean isSelect = false;
		elementToClick.click();
//		Thread.sleep(1000);
		ImplicitlyWait(driver, 5);
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementAttributeValueContain(driver, DropdownListElements.get(i), "class", "selected") == true)
			{
				if (isElementTextContain(driver, DropdownListElements.get(i), selectValue))
				{
					isSelect = true;
					break;
				}
				else
				{
					isSelect = false;
				}
				
			}
			else
			{
				isSelect = false;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		
		return isSelect;
	}
	
	public boolean isSelected(WebDriver driver, List <WebElement> DropdownListElements, String selectValue) throws Throwable
	{
		boolean isSelect = false;
		for (int i = 0; i < DropdownListElements.size(); i++) 
		{
			if (isElementAttributeValueContain(driver, DropdownListElements.get(i), "class", "checked") == true)
			{
				if (isElementTextContain(driver, DropdownListElements.get(i), selectValue))
				{
					isSelect = true;
					break;
				}
				else
				{
					isSelect = false;
				}
				
			}
			else
			{
				isSelect = false;
			}
		}
//		Thread.sleep(2000);
		ImplicitlyWait(driver, 5);
		
		return isSelect;
	}
	
	public WebElement TextContainsWebelement(WebDriver driver, String textValue) throws Throwable
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'"+textValue+"')]"));
		
		return element;
	}
	
	public WebElement TextMatchWebelement(WebDriver driver, String textValue) throws Throwable
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='"+textValue+"']"));
		
		return element;
	}
	
	public  Boolean isElementPresent(WebDriver driver, String linkTextValue) throws Throwable
    {
		WebElement element = null;
		boolean isFound = false;
        try
        {
            element = TextContainsWebelement(driver,linkTextValue);
            isFound = element.isDisplayed();
        }
        catch (Exception ex)
        {
            isFound = false;
        	System.out.println(ex.toString());
        }
        
        return isFound;
    }
	
	public void Active(WebDriver driver, WebElement Active, WebElement activeCheckbox, String active) throws Throwable 
	 {
		 if (active.contains("Yes"))
		 {
			 if(isElementAttributeValueContain(driver, Active, "class", "checked") == false)
			 {
				 activeCheckbox.click();
			 }
		 }
		 else if (active.contains("No"))
		 {
			 if(isElementAttributeValueContain(driver, Active, "class", "checked") == true)
			 {
				 activeCheckbox.click();
			 }
		 }
		 
		 ImplicitlyWait(driver, 10);
		 Thread.sleep(2000);
	 }
	
	public void ColFilter(WebDriver driver, List <WebElement> ColFilterIconList, List <WebElement> ColHeaderNameList, 
			WebElement Fliter_TB, WebElement FliterApplyBtn,  String colName, String fliterValue) throws Throwable
	{
		 for (int i = 0; i <= ColFilterIconList.size(); i++) 
		 {
			 if(isElementTextContain(driver, ColHeaderNameList.get(i+1), colName) == true)
			 {
				 System.out.println();
				 Thread.sleep(2000);
				 ColFilterIconList.get(i+1).click();
				 break;
			 }
		 }
		 ImplicitlyWait(driver, 6);
//		 Thread.sleep(3000);
		 
		 Fliter_TB.sendKeys(fliterValue, Keys.ENTER);
		 ImplicitlyWait(driver, 10);
//		 Thread.sleep(4000);
		 
	
		 
		 FliterApplyBtn.click();
		 ImplicitlyWait(driver, 10);
//		 Thread.sleep(5000);
  	}
	
	
	public void RemoveColFilter(WebDriver driver, List <WebElement> ColFilterIconList, List <WebElement> ColHeaderNameList, 
			WebElement SelectAll, WebElement FliterApplyBtn,String colName) throws Throwable
	 {
		for (int i = 0; i < ColFilterIconList.size(); i++) 
		 {
			 if(isElementTextContain(driver, ColHeaderNameList.get(i+1), colName) == true)
			 {
				 ColFilterIconList.get(i+1).click();
				 break;
			 }
		 }
		 ImplicitlyWait(driver, 10);
		 
		 SelectAll.click();
		 ImplicitlyWait(driver, 10);
		 SelectAll.click();
		 ImplicitlyWait(driver, 10);
		 
		 FliterApplyBtn.click();
		 ImplicitlyWait(driver, 10);
	 }
	
	public void ColSort(WebDriver driver, List <WebElement> ColSortIconList, List <WebElement> ColHeaderNameList, String colName) throws Throwable
	 {
		 for (int i = 0; i < ColHeaderNameList.size(); i++) 
		 {
			 if(isElementTextContain(driver, ColHeaderNameList.get(i), colName) == true)
			 {
				 ColSortIconList.get(i).click();
				 break;
			 }
		 }
		 ImplicitlyWait(driver, 10);
	 }
	
	public void DragAndDrop(WebDriver driver, List <WebElement> ColHeaderNameList, WebElement DropLocation, String colName) throws Throwable
	 {
		 for (int i = 0; i < ColHeaderNameList.size(); i++) 
		 {
			 if(isElementTextContain(driver, ColHeaderNameList.get(i), colName))
			 {
				 DragAndDrop(driver, ColHeaderNameList.get(i), DropLocation);
				 break;
			 }
		 }
		 ImplicitlyWait(driver, 5);
//		 Thread.sleep(1000);
	 }
	//CLick on dropdown before calling this method.
	public boolean isAbleToSelectActiveElement(WebDriver driver, List <WebElement> dropDownList, String activeElement)
	{
		boolean verify = false;
		
		if (dropDownList.size() == 0)
		{
			verify = false;
		}
		else
		{
			for (int i = 0; i < dropDownList.size(); i++) 
			{
				if (isElementTextContain(driver, dropDownList.get(i), activeElement) == true)
				{
					verify = true;
					break;
				}
				else
				{
					verify = false;
				}
			}
		}
		
		return verify;
	}
	
//	public void isAbleToSelectActiveElement()
	
	//this
	public String FirstRowCellText(WebDriver driver, List <WebElement> colHeaderNameList, List <WebElement> firstRowCellElements, String colName)
	{
		String elementText = null;
		
		for (int i = 0; i < colHeaderNameList.size(); i++) 
		 {
			 if(isElementTextContain(driver, colHeaderNameList.get(i), colName))
			 {
				 elementText = firstRowCellElements.get(i).getText();
				 break;
			 }
		 }
		 
		 return elementText;
	}
	
	public String FirstRowCellText1(WebDriver driver, List <WebElement> colHeaderNameList, List <WebElement> firstRowCellElements, String colName)
	{
		String elementText = null;
		int isFound = 0;
		
		Action_MoveOverElement(driver, colHeaderNameList.get(0));
		
		for (int i = 0; i < colHeaderNameList.size(); i++)
		{
			if(isElementTextContain(driver, colHeaderNameList.get(i), colName))
			{
				elementText = firstRowCellElements.get(i).getText();
				isFound = 1;
				break;
			}
			else
			{
				isFound = 0;
			}
		}
		
		if (isFound == 0)
		{
			for (int j = 4; j < 10; j++) 
			{
				for (int i = 0; i < colHeaderNameList.size(); i++)
				{
					if(isElementTextContain(driver, colHeaderNameList.get(i), colName))
					{
						elementText = firstRowCellElements.get(i).getText();
						isFound = 1;
					}
					else
					{
						isFound = 0;
					}
				}
				
				if (isFound == 1)
				{
					break;
				}
				else
				{
					Action_ScrollSide(driver, firstRowCellElements.get(firstRowCellElements.size()-2));
					Action_ScrollSide(driver, firstRowCellElements.get(firstRowCellElements.size()-1));
				}
			}
		}
		
		
		 
		 return elementText;
	}
	
	public boolean isAccess(WebDriver driver, List <WebElement> iconBtnList)
	{
		boolean verify = false;
		
		if (iconBtnList.size() <= 6)
		{
			for (int i = 0; i < iconBtnList.size(); i++) 
			{
				if (isElementAttributeValueContain(driver, iconBtnList.get(i), "class", "disabled") == false)
				{
					verify = true;
					break;
				}
				else
				{
					verify = false;
				}
			}
		}
		else
		{
			for (int i = 0; i < iconBtnList.size()-4; i++) 
			{
				if (isElementAttributeValueContain(driver, iconBtnList.get(i), "class", "disabled") == false)
				{
					verify = true;
					break;
				}
				else
				{
					verify = false;
				}
			}
		}
		
		return verify;
	}
	
	public String ElementText(WebDriver driver, WebElement element)
	{
		String elementText= element.getText();
		
		return elementText;
	}
	
	public String ElementAttributeValue(WebDriver driver, WebElement element, String attributeName)
	{
		String attributeValue= element.getAttribute(attributeName);
		
		return attributeValue;
	}
	
	public void Action_ScrollSide(WebDriver driver, WebElement element)
	{
		Actions move = new Actions(driver);
	    Action scroll = move.moveToElement(element).click().sendKeys(Keys.ARROW_RIGHT).build();
	    scroll.perform();
	    ImplicitlyWait(driver, 10);
	}
	
	public void Action_ScrollDown(WebDriver driver, WebElement element)
	{
		Actions move = new Actions(driver);
	    Action scroll = move.moveToElement(element).click().sendKeys(Keys.ARROW_DOWN).build();
	    scroll.perform();
	    ImplicitlyWait(driver, 10);
	}
	
	public void Action_MoveOverElement(WebDriver driver, WebElement element)
	{
		Actions move = new Actions(driver);
	    Action hover = move.moveToElement(element).build();
	    hover.perform();
	    ImplicitlyWait(driver, 10);
	}
	
	public void Action_SelectElement(WebDriver driver) throws Throwable
	{
		Actions select = new Actions(driver);
		select.sendKeys(Keys.chord(Keys.CONTROL,Keys.SPACE)).build().perform();
		Thread.sleep(500);
		select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	}
	
	public void Action_SelectElement(WebDriver driver, WebElement element) throws Throwable
	{
		Actions select = new Actions(driver);
		select.moveToElement(element).build().perform();
		Thread.sleep(500);
		select.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
	}
	
	public void JavascriptExecutor_ElementScroll(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		ImplicitlyWait(driver, 5);
	}
	
	public void selectDropDownElementByVisibleText(WebDriver driver, WebElement element, String option) throws InterruptedException
	{	Thread.sleep(3000);
		Select dropDownElement = new Select(element);
		dropDownElement.selectByVisibleText(option);
	}
	
	
	public void  scrolldown(WebDriver driver, WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver); 
		Actions scrollDown = actions.moveToElement( element ); 
		scrollDown.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform(); 
		Thread.sleep( 1000  );
	}
	
	
	public void  scrolldownUsingJSE(WebDriver driver, String pixel) throws InterruptedException {
		//to perform Scroll on application using JavaScriptExecutor(JSE)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,"+pixel+")", "");
	}

	public void  scrolldownUsingJSE_tillvisibilityOfElement(WebDriver driver, WebElement Element) throws InterruptedException {
		//to perform Scroll on application using JavaScriptExecutor(JSE)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	public void enterTextInto(WebDriver driver, WebElement element, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].value='"+input+"'"+";", element);
	}
	
	public void ClickUsingJSExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void switchToChildBrowserTab(WebDriver driver) {
		// hold all window handles in array list
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      System.out.println("Driver Switched to New Child tab:" + driver.getWindowHandle()+ " having Page title of new tab:" +driver.getTitle());
	}
	
	public void switchToParentBrowserTab(WebDriver driver) {
		// hold all window handles in array list
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      System.out.println("Driver Switched to New Child tab:" + driver.getWindowHandle()+ " having Page title of new tab:" +driver.getTitle());
	}
	
//	Added by Rakesh Jaiswal
	
	public void mouseHover(WebDriver driver, WebElement mainMenu, WebElement subMenu) {
		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenu);
		//---------------------------------------
		actions.moveToElement(subMenu);
		actions.click().build().perform();
	}
	
	
	public boolean isAlertPresent() 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	    
	}  
	
	
	
	
	
}
