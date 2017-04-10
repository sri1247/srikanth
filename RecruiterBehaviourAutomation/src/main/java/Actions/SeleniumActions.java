package Actions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;


//import org.apache.logging.log4j.core.config.Property;




 public class SeleniumActions {

    protected WebDriver driver;
    protected PageFactory pageFactory;
    private Actions action;
    Properties properties;

    public SeleniumActions(WebDriver driver,  PageFactory pageFactory){
        this.driver=driver;
        this.pageFactory= this.pageFactory;
        properties = new Properties();
        PropertyConfigurator.configure("D:\\RecruiterBehaviourAutomation\\RecruiterBehaviourAutomation\\src\\main\\java\\libs\\log4j.properties");

    }

     public SeleniumActions(WebDriver driver, BrowserSetup browserSetup) {
     }


     public Actions getActions() {

         return action;
     }

    Logger log= Logger.getLogger(SeleniumActions.class);
    WebElement element;
    public void open(String url){
        driver.get(url);
        log.info("loading the url.........");
    }
    public  void setValue(String locator,String locVal,String value){


        By by=locBy(locator,locVal);

        WebElement ele=driver.findElement(by);
        ele.sendKeys(value);
    }
    public  void closechildwindow( ) {
        String parentwindow = driver.getWindowHandle();
        Set<String> window = driver.getWindowHandles();
        for (String currentWindow : window) {
            if (!currentWindow.equalsIgnoreCase(parentwindow)) {
                driver.switchTo().window(currentWindow);
                driver.close();


            }
        }driver.switchTo().window(parentwindow);
        log.info("closing the subwindow");
    }


    public  WebElement createWebElement(String locator,String locVal){

        WebElement ele=null;
        threadSleep(1000);

        try{

            By by=locBy(locator,locVal);

            ele=driver.findElement(by);

            }

            catch(NoSuchElementException e){

            System.out.print("Element not found..with the folowing message:"+e.getMessage());


            }

    return ele;
    }

    public  WebElement createWebElement(WebElement ele,String locator,String locVal){

        WebElement elem=null;

        try{

            By by=locBy(locator,locVal);

            elem=ele.findElement(by);

        }

        catch(NoSuchElementException e){

            System.out.print("Element not found..with the folowing message:"+e.getMessage());


        }

        return ele;
    }

    public  List<WebElement> createWebElements(String locator,String locVal){

        List<WebElement> ele=null;

        try{

            By by=locBy(locator,locVal);

            ele=driver.findElements(by);

        }

        catch(NoSuchElementException e){

            System.out.print("Element not found..with the folowing message:"+e.getMessage());


        }

        return ele;
    }
    public  void clickOnEle(WebElement ele){

        try {

            ele.click();

        }

        catch (final ElementNotVisibleException e) {
        }
    }
    public  void clickOnEle(String loc,String locVal){

        WebElement ele=null;
        try {
            ele=createWebElement(loc,locVal);
            ele.click();
        }

        catch (final ElementNotVisibleException e) {
        }
    }

    public  void clickOnEleVisibleJS(String loc,String locVal){
        try {

            WebElement ele=createWebElement(loc,locVal);

            String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';arguments[0].click()";

            ((JavascriptExecutor)driver).executeScript(js,ele);

            ele.click();

        }catch (ElementNotVisibleException e){
            e.printStackTrace();
        }
    }
     public  void clickOnEleVisibleJS(String loc,WebElement ele){
         try {
             String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';arguments[0].click()";

             ((JavascriptExecutor)driver).executeScript(js,ele);

             ele.click();

         }

        catch (final ElementNotVisibleException e) {
        }
    }
    public void clickEnter() {

        getActions().sendKeys(Keys.ENTER).build().perform();


    }
    public  void jsclick(String loc,String locVal) {
        try {

            WebElement ele=createWebElement(loc,locVal);

            //WebElement windowpopup = driver.findElement(By.xpath(locator));
            JavascriptExecutor executor = (org.openqa.selenium.JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public  void  setValueEnter(String loc, String locVal,String value) {
        By by=locBy(loc,locVal);
        WebElement ele=driver.findElement(by);
        ele.sendKeys(value);
        ele.sendKeys(Keys.RETURN);
    }
    public By locBy(String loc,String locVal)
    {

        By by = null;
        try {

            switch (loc.toUpperCase()) {
                case "ID":
                    by = By.id(locVal);
                    break;
                case "XPATH":
                    by = By.xpath(locVal);
                    break;
                case "LINKTEXT":
                    by = By.linkText(locVal);
                    break;
                case "CSSSELECTOR":
                    by = By.cssSelector(locVal);
                    break;
                case "TAGNAME":
                    by = By.tagName(locVal);
                    break;
                case "NAME":
                    by = By.name(locVal);
                    break;
                case "CLASSNAME":
                    by = By.className(locVal);
                    break;
            }
        }
        catch(NoSuchElementException e){
            System.out.println("locBy ele not founf=d part:"+e.getMessage());
        }
        return by;

    }
    public void threadSleep(long Millisec) {
        try {
            Thread.sleep(Millisec);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void wait(int intTimeToWait,String strExpectedCondition,String locType,String locVal){

        WebDriverWait wait = new WebDriverWait(driver,intTimeToWait);

        By by =locBy(locType,locVal);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }






    public void clickDropDownvalue(String value, String locator) {
        try {
            clickOnEle("xpath",locator);
              clickOnEle("xpath","//div[@title='" + value + "']");
            //click(locator)
            clickOnEle("xpath","//div[@title='" + value + "']");

        } catch (final Exception e) {
            //click(locator);

            clickOnEle("xpath",locator);
            System.out.println("Error Occured in method 'selectdropdown' due to " + e.getMessage());
            e.printStackTrace();

        }
    }
    /*public void typeTextUsingJavaScript(By locator, String sString) {
        driver.findElement(locator).clear();
        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + sString + "'", driver.findElement(locator));
    }*/

      public void selectOnText(String locatorVal,String value) {

        try{


       // wait(60,"visibilitypfelementlocated","xpath",locator);
          //click(locator);

    clickOnEle("xpath",locatorVal);
       wait(60,"visibilitypfelementlocated","xpath", "//a[contains(text(),'"+value+"')]");
       clickOnEle("xpath","//a[contains(text(),'"+value+"')]");
         /*/ Select select = new Select(driver.findElement(By.xpath(locator)));
                  List < WebElement > elementCount = select.getOptions();
          int iSize = elementCount.size();

          for (int i = 0; i > iSize; i++) {
              String sValue = elementCount.get(i).getText();
                 if(value.toUpperCase().equalsIgnoreCase(sValue.toUpperCase()));
                 select.selectByValue(s"Value);
              //System.out.println(sValue);
          }*/

      }
       catch(Exception e){
 System.out.println("issue is here:"+e.getMessage());
  e.printStackTrace();

    }
      }

    public void mouseDown(String locator) {

        final Locatable mainNav = (Locatable) driver.findElement(By.id(locator));
        final Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseDown(mainNav.getCoordinates());
    }

    public void mouseUp(String locator) {

        final Locatable mainNav = (Locatable) driver.findElement(By.id(locator));
        final Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseUp(mainNav.getCoordinates());
    }


    public boolean isEnabled(String loc,String locVal) {

        boolean status = false;
        try {
            WebElement ele = createWebElement(loc, locVal);
            status = ele.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return status;

    }
    public boolean isDisplayed(String loc,String locVal) {

        boolean status = false;
        try {

            WebElement ele = createWebElement(loc, locVal);
            status = ele.isDisplayed();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.print(e.getMessage());

        }

        return status;

    }
   public  void closeAll(WebDriver driver)

   {
        driver.quit();
    }

    public void maximize(WebDriver driver){
        driver.manage().window().maximize();

    }
    public void clearText(String loc,String locVal){

        WebElement ele=createWebElement(loc,locVal);

        ele.clear();

    }


}





