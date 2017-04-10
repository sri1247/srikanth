import Actions.BrowserSetup;
import Actions.MonsterSearchPage;
import Actions.PageFactory;
import Actions.SeleniumActions;
import Utility.Constant;
import Utility.Excelutility;
import locators.LoginPageLocators;
import locators.SearchLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static locators.SearchLocators.*;

/**
 * Created by Srikanth on 3/22/2017.
 */
public class MonsterTest {
    public WebDriver driver;
    SeleniumActions seleniumActions;
    MonsterSearchPage monster;
    BrowserSetup browsersetup;
    Excelutility excelutility;
    public static String[][] inputData;


    public PageFactory getPageFactory() {
        return new PageFactory(driver);
    }

public MonsterTest() throws Exception {
    excelutility = new Excelutility();
    excelutility.setExcelFile(Constant.Path_TestData + Constant.readFile_TestData,"Sheet1");
//String path="Constant.Path_TestData + Constant.readFile_TestData,"Sheet1""
}
    @BeforeTest
    @Parameters("browser")

    public void login(String browser) throws Exception {

          int i=1;


            String  jobportal = excelutility.getCellData(i, 0);
            String username = excelutility.getCellData(i, 1);
            String password = excelutility.getCellData(1, 2);
            browsersetup = getPageFactory().browserSetup();
            driver = browsersetup.startBrowser(browser);
            seleniumActions = getPageFactory().seleniumActions();
            monster = getPageFactory().monster();
            monster.geturl(jobportal);
            monster.login(jobportal, username, password);
            //seleniumActions.wait(120, "visibilitypfelementlocated", "xpath", LoginPageLocators.monsterPopup);
            Assert.assertEquals("MonsterIndia.com - More jobs for Indians", driver.getTitle(), "login details are not correct");

    }




    @Test
    public void MonsterTest() throws Exception {

        String anySkill = excelutility.getCellData(1, 3);
        String allSkills = excelutility.getCellData(1, 4);
        String excludingvalue = excelutility.getCellData(1, 5);
        String resume = excelutility.getCellData(1, 6);
        String minExpernice = excelutility.getCellData(1, 7);
        String maxExpernice = excelutility.getCellData(1, 8);
        String industry = excelutility.getCellData(1, 9);
        String rolesection = excelutility.getCellData(1, 10);
        String role = excelutility.getCellData(1, 11);
        String currentlocation = excelutility.getCellData(1, 12);
        String preferredlocation = excelutility.getCellData(1, 13);
        String company = excelutility.getCellData(1, 14);
        String excludeCompany = excelutility.getCellData(1, 15);
        String desigination = excelutility.getCellData(1, 16);
        String noticeperiod = excelutility.getCellData(1, 17);
        String salaryMinValue = excelutility.getCellData(1, 18);
        String salaryMaxValue = excelutility.getCellData(1, 19);
        String education = excelutility.getCellData(1, 22);
        String specialCourse = excelutility.getCellData(1, 23);
        String yearofPassingFromValue = excelutility.getCellData(1, 20);
        String yearofPassingToValue = excelutility.getCellData(1, 21);
        String nationality = excelutility.getCellData(1, 24);
        String language = excelutility.getCellData(1, 25);
        String activeresume = excelutility.getCellData(1, 26);
        String jobType = excelutility.getCellData(1, 27);
        String educationSpecialiZation = excelutility.getCellData(1, 28);


        browsersetup = getPageFactory().browserSetup();
        seleniumActions.jsclick("xpath", LoginPageLocators.monsterPopup);
        seleniumActions.jsclick("xpath", SearchLocators.searchpageoption);
       driver.findElement(By.xpath(".//*[@id='company']/div[1]/div[1]/div[1]/ul[1]/li[1]")).sendKeys("yes");
        //Thread.sleep(3000);
            monster.selectOnText("//div[@id='distance']","50 KM");
            monster.sendData(anySkill, anyLocator);
            monster.sendData(allSkills, allLocator);
            monster.sendData(excludingvalue, excluding);
            monster.selectOnText(etireResume, resume);
            monster.clickOnCheckBox(SearchLocators.excludeSynonyms,"yes");
            monster.sendData(minExpernice, experienceMinYrs);
            monster.sendData(maxExpernice, experienceMaxYrs);
            monster.enterOnDropDownValue(currentLocation, inputOnCurrentLocation, currentlocation);
            monster.clickRadioButton(locationRadioButton,"");
            monster.enterOnDropDownValue(preferredLocation, inputOnPreferredLocation, preferredlocation);
           monster.sendData("yes",anyofthecompanies);
           monster.selectOnLinkText(anyofthecompaniesOptions, company);
            monster.sendData("yes",excludecompanies);
            monster.selectOnLinkText(excludecompaniesOptions, excludeCompany);
            monster.sendData("yes",designation);
            monster.selectOnLinkText(designationOptions, desigination);
            monster.selectIndustry(industry);
            monster.selectRole(rolesection, role);
            monster.selectOnText(noticePeriod, noticeperiod);
            monster.selectSalary(salaryMin, salaryMinValue);
            monster.clickOnCheckBox(SearchLocators.profilesNotMentionedCurrentSalary,"yes");
            //WebElement ele= driver.findElement(By.xpath("//div[@id='sal_highlight']/div[3]"));
              //    ele.click();
                //  driver.findElement(By.xpath("//div[@id='salmax_popup']/div[3]//div[text()='30000']")).click();
            // monster.selectSalary(salaryMax, salaryMaxValue);
           monster.enterOnDropDownValue(highestdegree, inputonhighestdegree, education);
            monster.selectSpecialization(specialization, educationSpecialiZation, specialCourse);
            monster.selectOnLinkText(yearofPassingFrom, yearofPassingFromValue);
            monster.selectOnLinkText(yearofPassingTo, yearofPassingToValue);
            monster.clickRadioButton(educationRadioButton,"");
            //monster.enterondropdownvalue(SearchLocators.nationality, inputonnationality, nationality);
            monster.clickOnCheckBox(includeProfilesWithWorkAuthorization,"");
            monster.enterOnDropDownValue(languageKnown, inputonLangugeKnown, language);
            monster.clickRadioButton(nationalityRadioButton,"");

           monster.selectOnText(showResumesACtive, activeresume);
            monster.clickRadioButton(locationRadioButton,"Or");
            monster.selectOnText(ageGroupMin,"25");
      monster.selectOnLinkText(ageGroupMax, "28");
        monster.clickOnCheckBox(excludeConfidentialResumes, "yes");
        monster.clickOnCheckBox(womenJobSeekers, "yes");
        monster.clickOnCheckBox(resumesNotViewed, "yes");
        monster.clickOnCheckBox(profilesWithVerifiedEmailId, "yes");
        monster.clickOnCheckBox(profilesWithVerifiedMobileNo, "yes");
        monster.clickOnCheckBox(profilesWithPhotograph, "yes");
        monster.clickOnEle("xpath", getResumes);
        monster.getprofilesData();


    }


    @AfterTest

    public void logOut() {
        monster.logout();
        seleniumActions.closeAll(driver);

    }
}