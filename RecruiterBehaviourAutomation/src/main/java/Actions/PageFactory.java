package Actions;



import org.openqa.selenium.WebDriver;

public class PageFactory {

    private WebDriver driver;

    public PageFactory(WebDriver driver){
        this.driver = driver;
    }

	    public SeleniumActions seleniumActions(){
        return new SeleniumActions(driver,this);
    }

    public MonsterSearchPage monster() throws Exception {
            return new MonsterSearchPage(driver,this);

        }
    public BrowserSetup browserSetup() throws Exception {
        return new BrowserSetup(driver,this);
}

}
