package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IAnimation;

public interface IAnimationHandler {
    IAnimation saveAnimation(IAnimation animation);

    void delete(String name);

    boolean has(String name);

    IAnimation get(String name);

    IAnimation[] getAnimations();
}
