package noppes.npcs.api.entity;

import noppes.npcs.api.handler.data.IAnimationData;

/**
 * Represents an entity capable of playing animations.
 * Provides access to its animation data.
 */
public interface IAnimatable {

    /**
     * Returns the animation data associated with this entity.
     *
     * @return the animation data.
     */
    IAnimationData getAnimationData();
}
