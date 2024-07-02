package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import obj_repository.HomePage;
import obj_repository.LoginPage;

public class BaseClass {
	//for taking screenshot 
	public static WebDriver sDriver;
	public WebDriver driver;
	public File_Utility flib = new File_Utility();
	public WebDriver_utility wlib = new WebDriver_utility();
	 public Java_Utility jlib = new Java_Utility();
	 public Excel_Utility elib = new Excel_Utility();
	 	
	
		@BeforeSuite(groups={"smokeTest","regressionTest","integrationTest"})
		public void bs()
		{
			System.out.println("Database connected");
		}
		@BeforeTest(groups={"smokeTest","regressionTest","integrationTest"})
		public void bt()
		{
			System.out.println("Parallel execution starts");
		}
		//@Parameters("BROWSER") --only used for cross browser exec
		@BeforeClass(groups={"smokeTest","regressionTest","integrationTest"})
		public void bc(/*String BROWSER*/) throws Throwable
		{
			String BROWSER = flib.getKeyAndValueData("browser");
			//reading data from cmd
			//String BROWSER = System.getProperty("browser");
			
			if(BROWSER.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			System.out.println("Browser launched");
			sDriver=driver;
		}
		@BeforeMethod(groups={"smokeTest","regressionTest","integrationTest"})
		public void bm() throws Throwable
		{	
			
			String URL = flib.getKeyAndValueData("url");
			 String USERNAME = flib.getKeyAndValueData("username");
			 String PASSWORD = flib.getKeyAndValueData("password");
			
			//read data from cmd
			//String URL = System.getProperty("url");
			//String USERNAME = System.getProperty("username");
			//String PASSWORD = System.getProperty("password");
			
			 wlib.maximizeWindow(driver);
			 wlib.elementsToGetLoaded(driver);
			 
			 driver.get(URL);
	       	 LoginPage login = new LoginPage(driver);
	       	 login.loginToApp(USERNAME, PASSWORD);
			System.out.println("Login to application");
		}
		
		@AfterMethod(groups={"smokeTest","regressionTest","integrationTest"})
		public void am()
		
		{	
			 HomePage home = new HomePage(driver);
		     home.logOutFromApp();

			System.out.println("Logout to application");
		}
		@AfterClass(groups={"smokeTest","regressionTest","integrationTest"})
		public void ac()
		{
			System.out.println("Browswer Closed");
		}
		@AfterTest(groups={"smokeTest","regressionTest","integrationTest"})
		public void at()
		{
			System.out.println("Parallel Execution Done");
		}
		@AfterSuite (groups={"smokeTest","regressionTest","integrationTest"})
		public void as()
		{
			System.out.println("Close database");
		}
}
