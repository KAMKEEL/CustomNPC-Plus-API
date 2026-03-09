package noppes.npcs.api.entity;

import net.minecraft.entity.projectile.EntityThrowable;

/**
 * Represents a throwable entity with additional methods.
 *
 * @param <T> The underlying Minecraft EntityThrowable type.
 */
public interface IThrowable<T extends EntityThrowable> extends IEntity<T> {

    /**
     * Returns the entity that threw this throwable.
     *
     * @return the thrower, or null if unknown.
     */
    IEntityLivingBase getThrower();

    /**
     * Removes this throwable entity from the world.
     */
    void kill();
}
