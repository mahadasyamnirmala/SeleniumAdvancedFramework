package org.example.Tests.VWO;
import org.example.Pages.POM.VWO.LoginPage;
import org.example.Pages.POM.VWO.DashboardPage;
import org.example.Pages.POM.VWO.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_Normal_POM {

    // D
    // L
    // V

    @Owner("Nirmala")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L

        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOInvalidCreds("admin@gmail.com","1234");
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
        driver.quit();



    }

    @Owner("PRAMOD")
    @Description("Verify that with valid email, pass,logins and open Dashboard page.")
    @Test
    public void test_positive_vwo_login() {

        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOValidCreds("cxh04@tempumail.cc","ILoveDrive#08");
        // Assertions - 3 - V
        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        Assert.assertEquals(userNameLoggedIn,"Kishore J");
        driver.quit();



    }

    @Owner("Nirmala")
    @Description("Verify that with valid email, pass,logins and open Dashboard page.")
    @Test
    public void  free_trial_vwo_login() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.FreeTrailPage();
        WaitHelpers.waitJVM(2000);



    }


}
