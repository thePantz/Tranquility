package com.rapidrtc.tranquility.core;

public interface IQuestion<ANSWER> {
    ANSWER answeredBy(Actor actor);
}
