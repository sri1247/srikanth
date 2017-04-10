package locators;

public interface SearchLocators {
       //monster mpower search page  locators
    public static final String searchpageoption="//a[@id='mpower']";
    public static final String anyLocator="//input[@id='anw']";
    public static final String allLocator="//input[@id='alw']";
    public static final String excluding="//input[@id='now']";
    public static final String etireResume="//div[@id='search_within_power_id']/div[2]";
    public static final String ecludesynonyms="//div[@id='elesyn_id']";
    public static final String experienceMinYrs ="//input[@id='idMne']";
    public static final String experienceMaxYrs ="//input[@id='idMxe']";
    public static final String industrylocator="//div[@id='selInd_value']";
    public static final String inputonindustrylocator="//input[@id='selInd_typeahead']";
    public static final String choosefromAllRoles="//div[@id='selRol2_value']";
    public static final String inputonrole="//input[@id='selRol2_typeahead']";
    public static final String currentLocation="//div[@id='selCl_value']";
    public static final String inputOnCurrentLocation="//input[@id='selCl_typeahead']";
    public static final String includeProfilesWithin="location_check";
    public static final String includeProfilesWithinSelect="//div[@id='distance']";
    public static final String preferredLocation="//div[text()='Preferred Location']";
    public static final String inputOnPreferredLocation="//input[@id='selPrl_typeahead']";
    public static final String anyofthecompanies="//div[@id='company']/div[1]/div[1]";
    public static final String anyofthecompaniesOptions="//div[@id='company_any']";//div[@id='selAcp']";
    public static final String excludecompanies ="//div[@id='company']/div[3]/div[1]";
    public static final String excludecompaniesOptions="//div[@id='company_exc']/div[1]";
    public static final String designation  ="//div[@id='company']/div[4]/div[1]";
    public static final String designationOptions="//div[@id='desig_container']/div[1]";
    public static final String noticePeriod="//div[@id='np_period']/div[1]";
    public static final String salaryMin  ="//div[@id='sal_highlight']/div[2]";
    public static final String salaryMax ="//div[@id='salmax_parent']";
    public static final String highestdegree="//div[contains(text(),'Highest degree')]";
    public static final String inputonhighestdegree="//input[@id='selFdg_typeahead']";
    public static final String specialization ="//div[@id='selFsp_value']";
    public static final String yearofPassingFrom="//div[@id='year_passing']/div[1]";//div[@id='selYop'][1]";
    public static final String yearofPassingTo="//div[@id='year_passing2']/div[1]";
    public static final String nationality="//div[contains(text(),'Nationality')]";
    public static final String inputonnationality="//input[@id='selNat_typeahead']";
    public static final String languageKnown="//div[contains(@id,'selLng_1_value')]";
    public static final String inputonLangugeKnown="//input[@id='selLng_1_typeahead']";
    public static final String showResumesACtive="//div[@id='selDay'] ";
    public static final String ageGroupMin="//div[@id='selAgf']";
    public static final String ageGroupMax="//div[@id='additional']/div[3]//div[@id='sel_Agt']/div[1]";
    public static final String jobTypeLoc="//div[@id='selJobType']";
    public static final String locationRadioButton="//div[@id='location']";
    public static final String excludeSynonyms ="//div[@id='elesyn_id']/div[1]";
    public static final String includeProfilesWithInRange="//div[@id='location_check']";
    public static final String includeProfilesWithWorkAuthorization="//div[@id='radExcludediv']";
    public static final String profilesNotMentionedCurrentSalary="//div[@id='chknos_id']";
    public static final String excludeConfidentialResumes=" //div[@id='Exconfresdiv']";
    public static final String womenJobSeekers       ="//div[@id='lrtochksex']";
    public static final String resumesNotViewed ="//div[@id='lrtochknvd']";
    public static final String profilesWithVerifiedEmailId="//div[@id='lrtochkveml']";
    public static final String profilesWithVerifiedMobileNo="//div[@id='lrtochkver']";
    public static final String profilesWithPhotograph     ="//div[@id='lrtochkisimg']";
    public static final String educationRadioButton="//div[@id='education']";
    public static final String nationalityRadioButton="//div[@id='nationality']";
    public static final String getResumes="//input[@value=\"Get Resumes\"]";
    public static final String logoutLocator="//a[@class='userlogout']";

//profiles list page Locators
 public  static  final  String profilename="//a[@class='skname']";
 public  static  final  String currentCompany="//div[@class='scndinfo'][1]";
 public  static  final   String education="//div[@class='scndinfo'][2]";
 public static   final  String experniceWithinfo="//a[@class='res_h']";
 public static   final  String industry="//div[@class='scndinfo mrgn'][1]";
 public  static  final  String function="//div[@class='scndinfo mrgn'][2]";
 public static  final   String  role="//div[@class='scndinfo mrgn'][3]";

}
