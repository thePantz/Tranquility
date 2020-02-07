package com.rapidrtc.tranquility.webdriver.abilities;

import com.rapidrtc.tranquility.core.Actor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class BrowseTheWebTests {
    @Test
    public void With_ShouldSetDriver(){
        // Arrange
        WebDriver driver = new HtmlUnitDriver();

        // Act
        BrowseTheWeb browseTheWeb = BrowseTheWeb.with(driver);

        // Assert
        assertThat(browseTheWeb.getDriver(), is(equalTo(driver)));
    }

    @Test
    public void As_IfActorDoesNotHaveAbility_ShouldThrowException() {
        // Arrange
        Actor actor = Actor.named("Test Actor");

        // Act
        expectedException.expect(IllegalStateException.class);
        BrowseTheWeb.as(actor);
    }

    @Test
    public void As_IfActorHasAbility_ShouldReturnAbility() {
        // Arrange
        Actor actor = Actor.named("Test Actor");
        WebDriver driver = new HtmlUnitDriver();
        BrowseTheWeb browseTheWeb = BrowseTheWeb.with(driver);
        actor.can(browseTheWeb);

        // Act
        BrowseTheWeb result = BrowseTheWeb.as(actor);

        // Assert
        assertThat(result, is(equalTo(browseTheWeb)));

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
}
