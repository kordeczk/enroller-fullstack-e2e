package com.company.enroller.e2e.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    int timeoutSec = 5;

    public BasePage(WebDriver driver) {
        this.setupWebDriver(driver, this.timeoutSec);
    }

    public BasePage(WebDriver driver, int timeoutSec) {
        this.setupWebDriver(driver, timeoutSec);
    }

    private void setupWebDriver(WebDriver driver, int timeoutSec) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeoutSec));
        PageFactory.initElements(this.driver, this);
    }

    public void get(String url) {
        this.driver.get(url);
    }

    public void click(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public Boolean elementIsPresent(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public String getElementText(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public WebElement getMeetingByTitle(String meetingName) {
        String xPath = "//td[contains(text(), '" + meetingName + "')]/parent::tr";
        try {
            return this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException has been handled." + ex);
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred for meeting title: " + meetingName + e.getMessage());
        }
        return null;
    }

    public List<WebElement> getMeetings() {
        String meetingSel = "table > tbody > tr";
        try {
            return this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(meetingSel), 0));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred." + e.getMessage());
        }
        return null;
    }

    public String getMeetingColValue(WebElement meeting, int colIndex) {
        if (meeting == null) {
            return null;
        }

        List<WebElement> cols = meeting.findElements(By.cssSelector("td"));

        if (colIndex < 0 || colIndex >= cols.size()) {
            return null;
        }

        return cols.get(colIndex).getText();
    }

    public String getMeetingDesc(String meetingTitle) {
        WebElement meeting = this.getMeetingByTitle(meetingTitle);
        return this.getMeetingColValue(meeting, 1);
    }

    public List<String> getParticipantsListForMeeting(String meetingName) {
        String participantsItemSel = "td li";
        WebElement meeting = this.getMeetingByTitle(meetingName);
        return Optional.ofNullable(meeting)
                .map(m -> m.findElements(By.cssSelector(participantsItemSel))
                        .stream()
                        .map(WebElement::getText)
                        .toList())
                .orElse(List.of());
    }
}
