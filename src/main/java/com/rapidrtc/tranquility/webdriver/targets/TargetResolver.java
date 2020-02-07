package com.rapidrtc.tranquility.webdriver.targets;

import org.openqa.selenium.WebDriver;

public class TargetResolver {
    private final WebDriver driver;

    public TargetResolver(WebDriver driver, ByTarget byTarget) {
        this.driver = driver;
        IFrameSwitcher.getInstance().switchToIFrame(driver, byTarget);
    }

    public static TargetResolver create(WebDriver driver, ByTarget byTarget) {
        return new TargetResolver(driver, byTarget);
    }
}
