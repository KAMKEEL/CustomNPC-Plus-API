package noppes.npcs.api.entity;

import net.minecraft.entity.projectile.EntityArrow;

/**
 * Represents a arrow entity with additional methods.
 *
 * @param <T> The underlying Minecraft EntityArrow type.
 */
public interface IArrow<T extends EntityArrow> extends IEntity<T> {

    /**
     * Gets the entity that shot this arrow.
     * @return the shooter entity, or null if none
     */
    IEntity getShooter();

    /**
     * Gets the base damage of this arrow.
     * @return the damage value
     */
    double getDamage();

    /**
     * Removes this arrow from the world.
     */
    void kill();
}
