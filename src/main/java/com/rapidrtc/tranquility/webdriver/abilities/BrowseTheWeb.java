package com.rapidrtc.tranquility.webdriver.abilities;

import com.rapidrtc.tranquility.core.Actor;
import com.rapidrtc.tranquility.core.IAbility;
import org.openqa.selenium.WebDriver;

/**
 * Gives an actor the ability to browse the web
 */
public class BrowseTheWeb implements IAbility {
    private WebDriver driver;

    private BrowseTheWeb(WebDriver driver) {
        this.driver = driver;
    }

    public static BrowseTheWeb with(WebDriver driver){
        return new BrowseTheWeb(driver);
    }

    public static BrowseTheWeb as(Actor actor){
        if(actor.abilityTo(BrowseTheWeb.class) == null){
            throw new IllegalStateException(String.format("%s does not have the ability to Browse the web", actor.getName()));
        }

        return actor.abilityTo(BrowseTheWeb.class);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
