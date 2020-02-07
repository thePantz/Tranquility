package com.rapidrtc.tranquility.webdriver.targets;

import com.rapidrtc.tranquility.core.Actor;

import java.time.Duration;
import java.util.Optional;

public abstract class Target {
    protected final String targetElementName;
    protected final Optional<IFrame> iFrame;
    protected final Optional<Duration> timeout;

    public Target(String targetElementName, Optional<IFrame> iFrame) {
        this.targetElementName = targetElementName;
        this.iFrame = iFrame;
        this.timeout = Optional.empty();
    }

    public Target(String targetElementName, Optional<IFrame> iFrame, Optional<Duration> timeout) {
        this.targetElementName = targetElementName;
        this.iFrame = iFrame;
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return this.targetElementName;
    }

    public abstract WebElementWrapper resolveFor(Actor actor);

    public String  getName(){
        return this.targetElementName;
    }
}
