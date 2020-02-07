package com.rapidrtc.tranquility.webdriver.targets;

import com.rapidrtc.tranquility.core.Actor;
import com.rapidrtc.tranquility.webdriver.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.Optional;

public class ByTarget extends Target {
    private By locator;

    public ByTarget(String targetElementName, By locator, Optional<IFrame> iFrame) {
        super(targetElementName, iFrame);
        this.locator = locator;
    }

    @Override
    public WebElementWrapper resolveFor(Actor actor) {
        TargetResolver resolver = TargetResolver.create(BrowseTheWeb.as(actor).getDriver(), this);
        if(timeout.isPresent()) {
        }
        else{

        }

        return null;
    }
}
