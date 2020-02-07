package com.rapidrtc.tranquility.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ActorTests {

    Actor actor;

    @Before
    public void BeforeTest(){
        actor = Actor.named("Test Actor");
    }

    @Test
    public void Named_ShouldAddName(){
        // Arrange
        String expectedName = "Test Actor";

        // Assert
        assertThat(actor.getName(), equalTo(expectedName));
    }

    @Test
    public void Can_ShouldAddAbilities() {
        // Arrange
        TestAbility ability = new TestAbility();
        OtherTestAbility otherTestAbility = new OtherTestAbility();

        // Act
        actor.can(ability);
        actor.can(otherTestAbility);

        // Assert
        assertThat(actor.abilityTo(TestAbility.class), is(notNullValue()));
        assertThat(actor.abilityTo(OtherTestAbility.class), is(notNullValue()));
    }

    @Test
    public void AbilityTo_IfActorDoesNotHaveAbility_ShouldReturnNull() {
        // Act
        TestAbility result = actor.abilityTo(TestAbility.class);

        // Assert
        assertThat(result, is(nullValue()));
    }

    @Test
    public void AttemptsTo_ShouldPerformAllActions(){
        // Arrange
        TestPerformable performable1 = new TestPerformable();
        TestPerformable performable2 = new TestPerformable();
        TestPerformable performable3 = new TestPerformable();

        // Act
        actor.attemptsTo(performable1, performable2);

        // Assert
        assertThat(performable1.getCount(), is(1));
        assertThat(performable2.getCount(), is(1));
        assertThat(performable3.getCount(), is(0));
    }

    @Test
    public void AsksFor_ShouldReturnAnswer(){
        // Arrange
        TestStringQuestion stringQuestion = new TestStringQuestion();
        TestIntQuestion intQuestion = new TestIntQuestion();

        // Act
        String stringResult = actor.asksFor(stringQuestion);
        Integer intResult = actor.asksFor(intQuestion);

        // Assert
        assertThat(stringResult, is("String Answer"));
        assertThat(intResult, is(2));

    }

    public class TestAbility implements IAbility{}

    public class OtherTestAbility implements IAbility{}

    public class TestPerformable implements IPerformable {

        int count = 0;

        @Override
        public <T extends Actor> void performAs(T actor) {
            count++;
        }

        public int getCount(){
            return this.count;
        }
    }

    public class TestStringQuestion implements IQuestion<String> {

        @Override
        public String answeredBy(Actor actor) {
            return "String Answer";
        }
    }

    public class TestIntQuestion implements IQuestion<Integer> {

        @Override
        public Integer answeredBy(Actor actor) {
            return 2;
        }
    }
}
