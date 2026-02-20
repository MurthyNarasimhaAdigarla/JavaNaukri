package com.murthy.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Set;


public class JavaNaukriTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void Naukri_With_Java() {

        driver.get("https://www.naukri.com/");

        // Close all popup windows except main
        Set<String> allWindows = driver.getWindowHandles();
        String mainWindow = driver.getWindowHandle();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);

        // Click on login button
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));
            loginBtn.click();
        } catch (Exception e) {
            System.out.println("Login button not found: " + e.getMessage());
        }

        // Enter username and password
        try {
            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")));
            email.sendKeys("murthynarasimha0401@gmail.com"); // replace with your email

            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
            password.sendKeys("Jobskosam@01"); // replace with your password

            WebElement submit = driver.findElement(By.xpath("//button[text()='Login']"));
            submit.click();

            Thread.sleep(2000);

            //Updating profile and resume
            // driver.navigate().back();
            WebElement viewProfileLink = driver.findElement(By.linkText("View profile"));
            viewProfileLink.click();

            Thread.sleep(3000);

//            // Click the "Update" link
//            WebElement updateLink = wait.until(
//                    ExpectedConditions.elementToBeClickable(
//                            By.xpath("//li[@class='collection-item typ-14Medium']//a[text()='Update']")
//                    )
//            );
//            updateLink.click();
//            System.out.println("Resume update button clicked");
//
//// Locate the file input (hidden in DOM)
//            WebElement fileInput = wait.until(
//                    ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']"))
//            );
//
//// Build the absolute path to the resume inside your project folder
//            String resumePath = System.getProperty("user.dir") + "/src/main/resources/Narasimha_Murthy_QA_Sdet.pdf";
//
//// Upload the file directly (no OS dialog needed)
//            fileInput.sendKeys(resumePath);
//            System.out.println("Resume uploaded successfully from project folder");

            // Locate the file input directly (even if hidden)
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));

// Build the absolute path dynamically from your project folder
            String resumePath = System.getProperty("user.dir") + "/src/main/resources/Narasimha_Murthy_QA_Sdet.pdf";

// Upload the file directly (no OS dialog needed)
            fileInput.sendKeys(resumePath);

            System.out.println("Resume uploaded successfully from project folder");

            //Seraching Jobs

            WebElement searchPlaceholder = driver.findElement(By.xpath("//span[text()='Search jobs here']"));
            searchPlaceholder.click();
            WebElement searchAndEnterKeyword = driver.findElement(By.xpath("//input[@placeholder='Enter keyword / designation / companies']"));
            searchAndEnterKeyword.sendKeys("Selenium Automation Testing.");

            // Click the input field to open dropdown
            WebElement experienceInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("experienceDD")));
            experienceInput.click();

            // Wait for dropdown option and select "10 years"
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[normalize-space(text())='10 years']")));
            option.click();

            WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Enter location']")));

            locationInput.clear();
            locationInput.sendKeys("Hyderabad");
            locationInput.sendKeys(Keys.ENTER);


        } catch (Exception e) {
            System.out.println("Login fields not accessible: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

//            WebElement profileIcon =
//                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-toggle='dropdown']")));
//            profileIcon.click();
//            WebElement logoutBtn =
//                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
//            logoutBtn.click();
            driver.quit();
        }
    }
}

