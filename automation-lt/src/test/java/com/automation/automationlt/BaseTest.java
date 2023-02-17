package com.automation.automationlt;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeMethod
    public void setUp() {
        open("https://www.saucedemo.com/");
    }

}
