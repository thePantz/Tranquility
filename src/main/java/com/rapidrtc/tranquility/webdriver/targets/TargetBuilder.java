package com.rapidrtc.tranquility.webdriver.targets;

import org.openqa.selenium.By;

import java.util.Optional;

public class TargetBuilder<T> {

    private String targetElementName;
    private Optional<IFrame> iFrame = Optional.empty();

    public TargetBuilder(String targetElementName) {
        this.targetElementName = targetElementName;
    }

    public TargetBuilder inIFrame(IFrame iFrame) {
        this.iFrame = Optional.ofNullable(iFrame);
        return this;
    }

    public Target locatedBy(By locator) {
        return new ByTarget(targetElementName, locator, iFrame);
    }
}
