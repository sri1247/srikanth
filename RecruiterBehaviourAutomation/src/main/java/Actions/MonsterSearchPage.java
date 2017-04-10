package Actions;

import Utility.Constant;
import Utility.Excelutility;
import Utility.WriteExcel;
import locators.LoginPageLocators;
import locators.SearchLocators;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static locators.LoginPageLocators.monsterclickOnLoginPage;
import static locators.SearchLocators.logoutLocator;





public class MonsterSearchPage extends SeleniumActions {
    WriteExcel writeExcel = null;
    Logger logger = Logger.getLogger(MonsterSearchPage.class);
    Excelutility excelutility = new Excelutility();
    public MonsterSearchPage(WebDriver driver, PageFactory pageFactory) throws Exception {
        super(driver, pageFactory);

    }
    public void geturl(String jobPortal) {

        if (jobPortal.equalsIgnoreCase("Monster")) {
            logger.info("Loading the monster url");
            open(Constant.monsterURL);
            closechildwindow();
                    }
                    else if (jobPortal.equals("Naukri")) {

            }
        }


    public void login(String jobPortal, String username, String password) throws Exception {
        try {
            clickOnEle("xpath", monsterclickOnLoginPage);
            if (jobPortal.equalsIgnoreCase("naukri")) {
            } else if (jobPortal.equalsIgnoreCase("monster")) {
                logger.info("Enter to the Monster details");
                setValue("xpath", LoginPageLocators.monsterUsernameLocator, username);
                setValue("xpath", LoginPageLocators.monsterPasswordLocator, password);
                clickOnEle("xpath", LoginPageLocators.monsterClickButton);
                logger.info("logging the monster successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendData(String value, String locatorvalue) {

        setValue("xpath", locatorvalue, value);

    }

    public void enterOnDropDownValue(String locVal, String locVal1, String value) throws InterruptedException {
             //threadSleep(3000);
        try {
            clickOnEle("xpath", locVal);
            setValueEnter("xpath", locVal1,value);
            clickOnEle("xpath", locVal);
              } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void clickRadioButton(String locval,String value) {
    String option = "Or";
    if (!option.equalsIgnoreCase(value)) {
        WebElement radio = driver.findElement(By.xpath(locval + "//input[@value='and']"));
                clickOnEle(radio);
    } else {
    }
}  public void clickOnCheckBox (String locVal,String value){
        String option="yes";
        if(option.equalsIgnoreCase(value)){
            clickOnEle("xpath",locVal);

    }
} public void selectIndustry(String value) {

        try {
           // threadSleep(3000);
            clickOnEle("xpath", SearchLocators.industrylocator);
            clickOnEle("xpath", "//div[contains(text(),'" + value + "')]");
            clickOnEle("xpath", SearchLocators.industrylocator);
        } catch (Exception e) {
            System.out.println("isssue is here" + e.getMessage());
            e.printStackTrace();
        }

    }
    public void selectOnLinkText(String locval, String value) {

        try {
           threadSleep(2000);
            WebElement companyType = createWebElement("xpath", locval);
            clickOnEle(companyType);
            WebElement selectValue = createWebElement(companyType, "linktext", value);
            clickOnEle(selectValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectRole(String value, String value1) {
        clickOnEle("xpath", SearchLocators.choosefromAllRoles);
        WebElement roleType = createWebElement("xpath", "//div[@id='otherRole_container']//div[@title='"+value+"']");
        clickOnEle(roleType);
        String dataID = roleType.getAttribute("data-id");
        WebElement subRoleType = createWebElement("xpath", "//div[@id='" + dataID + "']/div[@title='" + value1 + "']");
        clickOnEle(subRoleType);
        clickOnEle("xpath", SearchLocators.choosefromAllRoles);
    }

    public void selectyearofpassing(String locval, String value) {
        clickOnEle("xpath", locval);
        WebElement elm = createWebElement("xpath", locval);
        WebElement elem1 = createWebElement(elm, "xpath", "//a[text()='" + value + "']");
        clickOnEle(elem1);
    }

    public void selectSalary(String locval,String value){

        clickOnEle("xpath",locval);
       // threadSleep(5000);
        WebElement salary=createWebElement("xpath",locval);
       // threadSleep(5000);
        WebElement salaryRangeLacs=createWebElement(salary,"xpath","//div[text()='"+value+"']");
        clickOnEle(salaryRangeLacs);
        WebElement salaryRangeThousands=createWebElement(salary,"xpath","//div[text()='"+20000+"']");
          clickOnEle(salaryRangeThousands);
        clickOnEle("xpath",locval);
    }

    public void selectSpecialization(String locval, String value, String value1) {
        clickOnEle("xpath", locval);
        WebElement specialCourse = driver.findElement(By.xpath("//div[@id='specialization_container']//div[@title='" + value + "']"));
        String dataID = specialCourse.getAttribute("data-id");
        WebElement specialGroup = driver.findElement(By.xpath("//div[@id='" + dataID + "']/div[@title='" + value1 + "']"));
        specialGroup.click();
        clickOnEle("xpath", locval);
    }

    public void selectValueinDropDownByName(String locator, String value) throws RuntimeException {
        try {
            Select select = new Select(driver.findElement(By.xpath(locator)));
            List <WebElement> elementCount = select.getOptions();
            int iSize = elementCount.size();

            for (int i = 0; i > iSize; i++) {
                String sValue = elementCount.get(i).getText();
                if (value.toUpperCase().equalsIgnoreCase(sValue.toUpperCase())) ;
                select.selectByValue(sValue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dis(String locval, String value) {

        try {
            threadSleep(2000);
            WebElement companyType = createWebElement("xpath", locval);
            clickOnEle(companyType);
            WebElement selectValue = createWebElement(companyType, "linktext", value);
            clickOnEle(selectValue);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void  logout(){

               jsclick("xpath",logoutLocator);}

    public void getprofilesData() throws Exception {
        ArrayList data = new ArrayList();
        writeExcel = new WriteExcel();

        List <WebElement> list = createWebElements("xpath","//div[@class='ritemheader']");
        List <WebElement> info = createWebElements("xpath","//div[@class='crinfo']");
        int i=0;
        for (int a = 0; a <= list.size() - 1; a++) {
            String s = list.get(a).getText();
            String w = info.get(a).getText();
                data.add(i, s+w);
                  i++;
            }
            System.out.println(data);
            writeExcel.writeDataToExcel(data);
        }

    }








