package noppes.npcs.api.handler;

import noppes.npcs.api.handler.data.IAnimation;

public interface IAnimationHandler {
    IAnimation saveAnimation(IAnimation animation);

    void delete(String name);

    void delete(int id);

    boolean has(String name);

    IAnimation get(String name);

    IAnimation get(int id);

    IAnimation[] getAnimations();

    /**
     * Get all built-in animations.
     * Built-in animations are read-only and cannot be modified or deleted.
     */
    IAnimation[] getBuiltInAnimations();

    /**
     * Get all animations (both built-in and user-created).
     */
    IAnimation[] getAllAnimations();

    /**
     * Check if an animation name is a built-in animation.
     *
     * @param name The animation name to check
     * @return true if this is a built-in animation
     */
    boolean isBuiltIn(String name);

    /**
     * Get names of all built-in animations.
     */
    String[] getBuiltInAnimationNames();
}
