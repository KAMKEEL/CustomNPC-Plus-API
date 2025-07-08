package noppes.npcs.api.entity;

import net.minecraft.entity.projectile.EntityArrow;

/**
 * Represents a arrow entity with additional methods.
 *
 * @param <T> The underlying Minecraft EntityArrow type.
 */
public interface IArrow<T extends EntityArrow> extends IEntity<T> {

    IEntity getShooter();

    double getDamage();

    void kill();
}
