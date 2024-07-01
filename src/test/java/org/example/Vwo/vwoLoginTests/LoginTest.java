package org.example.Vwo.vwoLoginTests;

import org.example.baseTest.BaseTest;
import org.example.pages.pageObjectModel.DashboardPage_POM;
import org.example.pages.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginPositive() throws Exception
    {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openUrl(PropertyReader.readKey("url"));
        DashboardPage_POM dashboardPagePom = loginPagePom.loginTovwoPositive().afterLogin();
        String nameOnDasboard = dashboardPagePom.loggedInUserNameOnDashboard();
        Assertion assertion = new Assertion();
        assertion.assertTrue(nameOnDasboard.contains(PropertyReader.readKey("expected_username")));
    }

}
