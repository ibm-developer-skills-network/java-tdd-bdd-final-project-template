package com.productstore.service.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebSteps {

    @Autowired
    private WebDriver driver;
    
    private final WebDriverWait wait;
    private String clipboard = "";
    
    public WebSteps() {
        // Initialize the WebDriverWait with default timeout
        // The actual driver will be injected by Spring
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I visit the {string}")
    public void iVisitThe(String page) {
        if ("Home Page".equals(page)) {
            driver.get("http://localhost:8080");
        }
    }

   
}