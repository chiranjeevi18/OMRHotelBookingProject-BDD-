package com.omrbranch.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.masterthought.cucumber.json.Output;

public class BaseClass {
	protected static WebDriver driver;
	private Object object;

	// 1. Enter Application URL - Check
	public static void enterApplicationUrl(String url) {
		driver.get(url);
	}

	// 2. Maximize the Window - Check
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 3. Insert Value in Text Box - Check
	public static void sendkeys(WebElement element, String value) {
		visibilityOfElement(element);
		element.sendKeys(value);
	}

	public static void enterKey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	// 4. Click Button - Check
	public static void clickElement(WebElement element) {
		visibilityOfElement(element);
		element.click();
	}

	// 5. Switch to Alert Box and accept - Check
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	// 6. Switch to Alert Box and Dismiss - Check
	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	// 7. Get the text from Web page - Check
	public static String elementGetText(WebElement element) {
		visibilityOfElement(element);
		String text = element.getText();
		return text;
	}

	// 8. Get the Inserted Value from the text box - Check
	public static String getInsertedValue(WebElement element, String attributeValue) {
		visibilityOfElement(element);
		String attribute = element.getAttribute(attributeValue);
		return attribute;
	}

	// 9. Close All window - Check
	public static void closeAllWindow() {
		driver.quit();
	}

	// 10. Close Current Window - Check
	public static void closeCurrentWindow() {
		driver.close();
	}

	// 11. Get the Title - Check
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 12. Get the Entered URL - Check
	public static String getEnteredUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 13. Select Drop-down option by text - Check
	public static void selectByText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		visibilityOfElement(element);
	}

	// 14. Select Drop-down options by Attribute - Check
	public static void selectByAttributeValue(WebElement element, String attributeValue) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByValue(attributeValue);
	}

	// 15. Select Drop-down options by Index - Check
	public static void selectByIndex(WebElement element, int indexNo) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByIndex(indexNo);
	}

	// 16. Insert value in text box by using JavaScript - Check
	public static void sendKeysByJS(WebElement element, String value) {
		visibilityOfElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	// 17. Click Button by JavaScript - Check
	public static void clickButtonJS(WebElement element) {
		visibilityOfElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public static void setAttributeJS(WebElement element, String value) {
		visibilityOfElement(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	// 18. Launch Chrome Browser
	public static void browseLaunch() {
		driver = new ChromeDriver();
	}

	public static void getDriver(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
	}

	// 19. Switch To Child Window - Check
	public static String switchChildWindow() {
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWindow : windowHandles) {
			if (!parentWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}
		return parentWindow;
	}

	// Switch the window by Index - Check
	public static String switchWindowByIndex(int index) {
		Set<String> allWindow = driver.getWindowHandles();
		List<String> listofwindow = new ArrayList<String>();
		listofwindow.addAll(allWindow);
		String reqwindow = listofwindow.get(index);
		driver.switchTo().window(reqwindow);
		return reqwindow;
	}

	// 20. Switch Frame by Index - Check
	public static void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void switchFrameByWebElement(WebElement element) {
		visibilityOfElement(element);
		driver.switchTo().frame(element);
	}

	public static void switchFrameToDefault() {
		driver.switchTo().defaultContent();
	}

	// 21. Switch to frame by Frame Id - Check
	public static void switchFrameByID(String frameID) {
		WebElement locateByID = locateByID(frameID);
		driver.switchTo().frame(locateByID);
	}

	// 22. Find locator by Id - Check
	public static WebElement locateByID(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	// 23. Find Locator by Name - Check
	public static WebElement locateByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 24. Find Locator by ClassName - Check
	public static WebElement locateByClassName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;
	}

	// 25. Find Locator By X-path - Check
	public static WebElement findLocatorByXpath(String name) {
		WebElement element = driver.findElement(By.xpath(name));
		return element;
	}

	public static List<WebElement> findLocatorsByxpath(WebElement element) {
		visibilityOfElement(element);
		List<WebElement> elements = driver.findElements((By) element);
		return elements;
	}
	public String getElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            String string = element.getText();
        }
		return null;
    }
	public List<String> elementsAll(List<WebElement> elements) {
		List<String> elementTexts = new ArrayList<>();
        for (WebElement element : elements) {
            elementTexts.add(element.getText());
        }
		return elementTexts;
	}


	// 26. Get Options from DropDown as Text - Check
	public static void selectOptionsAsText(WebElement element, String name) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(name);
	}

	// 27. Get All Options from Drop down as attribute Value - Check
	public static List<WebElement> getAllOptions(WebElement element) {
		visibilityOfElement(element);
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// 28. Get the First Selected option text in drop down - Check
	public static WebElement getFirstSelectOption(WebElement element) {
		visibilityOfElement(element);
		Select select = new Select(element);
		WebElement getfirstSelectedOption = select.getFirstSelectedOption();
		return getfirstSelectedOption;
	}

	// 29. Verify in Drop down is Multi-selected options - Check
	public static boolean isMultiselect(WebElement element) {
		visibilityOfElement(element);
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 30. Implicit wait - Check
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void implicitWait(int second) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
	}

	// 31. Explicit Wait - Check
	public static void explicitWait(WebElement element) {
		WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(2));
		driverwait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait  = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
	// 32. Fluent Wait

	// 33. Verify is Displayed

	// 34. Verify is Enabled

	// 35. Verify is Selected

	// 36. De-select By Text - Check
	public static void deSelectByText(WebElement element, String visibleText) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}

	// 37. De-select By Attribute - Check
	public static void deSelectByAttributeValue(WebElement element, String attributeValue) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.deselectByValue(attributeValue);
	}

	// 38. De-select By Index - Check
	public static void deSelectByIndex(WebElement element, int indexNo) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.deselectByIndex(indexNo);
	}

	// 39. De-select All - Check
	public static void deSelectAll(WebElement element) {
		visibilityOfElement(element);
		Select select = new Select(element);
		select.deselectAll();
	}

	// 40. Get the Parent Window - Check
	public static String getParentWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	// 41. Get the all Window - Check
	public static Set<String> getAllWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	// 42. Clear Text Box - Check
	public static void clearTextBox(WebElement element) {
		visibilityOfElement(element);
		element.clear();
	}

	// 43. Take Screenshot - Check
	public static void takeScreenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\USER\\eclipse-workspace\\Day - 13\\mavenTesting\\ImgFolder\\" + name + ".png"));
	}

	// 44. Take Screenshot for Element
	public static void takeScreenshot(WebElement element, String name) throws IOException {
		visibilityOfElement(element);
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,
				new File("C:\\Users\\USER\\eclipse-workspace\\Day - 13\\mavenTesting\\ImgFolder\\" + name + ".png"));
	}
	// 45. Mouse Over Action for single option

	// 46. Drag and Drop

	// 47. Right Click - Check
	public static void rightClick(WebElement element) {
		visibilityOfElement(element);
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// 48. Double Click - Check
	public static void doubleClick(WebElement element) {
		visibilityOfElement(element);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	// 49. Insert Value in text-box and enter - Check
	public static void insertValueInTextBoxAndEnter(WebElement element, String value) {
		visibilityOfElement(element);
		element.sendKeys(value + Keys.ENTER);
	}

	// 50. Refresh Page - Check
	public static void refresh() {
		driver.navigate().refresh();
	}

	// 51. Getting Data from excel
	public static String getDatafromExcel(String sheetName, int rowNum, int cellNum) throws IOException {
		String returnStatement = "";
		File file = new File("C:\\Users\\USER\\eclipse-workspace\\Day - 13\\mavenTesting\\Excel Folder\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			returnStatement = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				returnStatement = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					returnStatement = String.valueOf(numericCellValue);
				}
			}
			break;
		default:
			break;
		}
		return returnStatement;
	}

	// 52. Write data to excel
	public static void updateCellData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {
		File file = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Day - 13\\mavenTesting\\Excel Folder\\OMR-Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String stringCellValue = cell.getStringCellValue();
		if (stringCellValue.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream outPutStream = new FileOutputStream(file);
		workbook.write(outPutStream);
	}

	public static void createCellAddValue(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File(
				"C:\\Users\\USER\\eclipse-workspace\\Day - 13\\mavenTesting\\Excel Folder\\OMR-Datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		if (row == null) {
			row = sheet.createRow(rowNum);
		}
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream outPutStream = new FileOutputStream(file);
		workbook.write(outPutStream);
	}

	// Get Current Url
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public String getProperityFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		Object obj = properties.get(key);
		String value = (String) obj;
		return value;
	}
	public byte[] screenShot() {
		TakesScreenshot as = (TakesScreenshot) driver;
		byte[] screenshotAs = as.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}
}
