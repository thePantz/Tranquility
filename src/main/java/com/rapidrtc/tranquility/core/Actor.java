package com.rapidrtc.tranquility.core;

import java.util.HashMap;
import java.util.Map;

public class Actor {
    private Map<Class, IAbility> abilities = new HashMap<>();
    private String name;

    private Actor(String name){
        this.name = name;
    }
    public void attemptsTo(IPerformable... tasks){
        for(IPerformable task : tasks){
            try{
                task.performAs(this);
            } catch (Exception ex){
                //ToDo: Add error logging
            }
        }
    }

    public <T extends IAbility> void can(T doSomething){
        abilities.put(doSomething.getClass(), doSomething);
    }

    @SuppressWarnings("unchecked")
    public <T extends IAbility> T abilityTo(Class<? extends T> doSomething){
        return (T) abilities.get(doSomething);
    }

    public <ANSWER> ANSWER asksFor(IQuestion<ANSWER> question){
        return question.answeredBy(this);
    }

    public String getName(){
        return this.name;
    }

    public static Actor named(String name){
        return new Actor(name);
    }
}
