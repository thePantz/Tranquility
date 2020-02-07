package com.rapidrtc.tranquility.core;

/**
 * A task or action that can be performed by an actor
 */
public interface IPerformable {
    <T extends Actor> void performAs(T actor);
}
